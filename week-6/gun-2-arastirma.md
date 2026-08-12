# 2. Gün Araştırma Notları
## Compose, Servis Ağı ve Healthcheck

Bu dosya 2. güne ait araştırma başlıklarını tek yerde toplar.

---

## 1. Container Networking Nasıl Çalışır?

Docker container'ları kendi izole ağ alanlarına sahip olabilir. Aynı Docker host üzerinde çalışan ve aynı user-defined bridge network'e bağlı container'lar birbirleriyle ağ üzerinden haberleşebilir.

Docker'ın user-defined bridge network yapısının önemli avantajlarından biri, container'ların birbirlerini sabit IP adresi yerine **servis/container adıyla** çözebilmesidir.

Örneğin Compose içinde:

```yaml
services:
  backend:
    image: my-backend
    environment:
      DB_HOST: database

  database:
    image: postgres:18
```

Backend tarafında veritabanı adresi `localhost` değil `database` olmalıdır.

```text
backend container
      |
      | database:5432
      v
database container
```

Container içerisindeki `localhost`, host bilgisayarı veya başka bir container'ı değil **o container'ın kendisini** ifade eder.

---

## 2. Healthcheck ile Process-Running Arasındaki Fark

Bir container'ın çalışıyor (`running`) görünmesi yalnızca ana process'in henüz kapanmadığını gösterir. Ancak process açık olsa bile uygulama isteklere doğru cevap veremiyor olabilir.

Örneğin:
- Web sunucusu sonsuz döngüye girmiş olabilir.
- Veritabanı başlatılmış ancak bağlantı kabul etmeye hazır olmayabilir.
- Uygulamanın bağımlı olduğu servis erişilemiyor olabilir.

`HEALTHCHECK`, uygulamanın gerçekten kullanılabilir durumda olup olmadığını belirlemek için periyodik bir kontrol çalıştırır.

Dockerfile örneği:

```dockerfile
HEALTHCHECK --interval=30s --timeout=5s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1
```

Böylece container durumu yalnızca `running` değil ayrıca `healthy` veya `unhealthy` olarak değerlendirilebilir.

---

## 3. `depends_on` Neden Tek Başına Readiness Garantilemez?

`depends_on`, servislerin hangi sırayla başlatılacağını düzenlemek için kullanılır. Fakat yalnızca bir container'ın başlatılmış olması, içindeki uygulamanın bağlantı kabul etmeye hazır olduğu anlamına gelmez.

Örneğin PostgreSQL container'ı başlatılmış olabilir ama birkaç saniye boyunca henüz bağlantı kabul etmiyor olabilir.

Daha güvenli Compose yaklaşımı:

```yaml
services:
  database:
    image: postgres:18
    environment:
      POSTGRES_DB: appdb
      POSTGRES_USER: appuser
      POSTGRES_PASSWORD: example
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U appuser -d appdb"]
      interval: 5s
      timeout: 5s
      retries: 5

  backend:
    image: my-backend
    depends_on:
      database:
        condition: service_healthy
```

Burada backend yalnızca database container'ının başlatılmasını değil, healthcheck sonucunun başarılı olmasını bekler.

---

## 4. Yazılım Terimi: Container ve Image

### Image nedir?

Image, uygulamanın çalışması için gereken dosyaları, runtime'ı, bağımlılıkları ve varsayılan ayarları içeren salt-okunur paket şablonudur.

### Container nedir?

Container, bir image'ın çalışan örneğidir.

```text
Dockerfile → Image → Container
```

Aynı image'dan birden fazla container oluşturulabilir.

### Container ile Virtual Machine farkı

| Container | Virtual Machine |
|---|---|
| Host kernelini paylaşır | Kendi işletim sistemi ve kernel yapısına sahiptir |
| Genellikle daha hafiftir | Daha fazla kaynak tüketir |
| Daha hızlı başlatılabilir | İşletim sistemi boot süreci vardır |
| Uygulama/process izolasyonuna odaklanır | Tam makine sanallaştırmasına odaklanır |

Container, VM ile aynı şey değildir; ikisi farklı izolasyon seviyeleri ve kullanım amaçlarına sahiptir.

---

## 5. Git: Merge Stratejileri

### Merge commit

Branch geçmişini koruyarak iki geliştirme hattını birleştirir ve gerektiğinde yeni bir merge commit oluşturur.

```bash
git checkout main
git merge feature/login
```

**Avantaj:** Branch yapısı ve geliştirme geçmişi daha görünürdür.  
**Dezavantaj:** Çok sayıda kısa branch kullanıldığında geçmiş kalabalık olabilir.

### Squash merge

Feature branch'teki birden fazla commit'in toplam değişikliğini tek bir commit olarak ana branch'e taşımayı amaçlar.

**Avantaj:** `main` geçmişi daha sade olur.  
**Dezavantaj:** Feature içindeki ayrı commit geçmişi ana branch'te korunmaz.

### Rebase merge yaklaşımı

Feature branch commit'lerini hedef branch'in en son noktasının üzerine yeniden uygular. Böylece daha doğrusal bir geçmiş elde edilir.

**Avantaj:** Linear history oluşturur.  
**Dezavantaj:** Commit kimlikleri değiştiği için paylaşılmış branch'lerde dikkatsiz kullanım geçmiş karmaşasına yol açabilir.

### Kısa karşılaştırma

| Yaklaşım | Geçmiş | Uygun kullanım |
|---|---|---|
| Merge commit | Branch yapısını korur | Branch geçmişi önemliyse |
| Squash | Tek commit | Küçük feature'ları temiz şekilde almak için |
| Rebase | Doğrusal | Temiz linear history istendiğinde |

---

## 6. Dijital Okuryazarlık: KVKK, Veri Minimizasyonu ve Amaçla Sınırlılık

KVKK yaklaşımında kişisel veriler belirli, açık ve meşru amaçlarla işlenmeli; toplanan veri bu amaçla bağlantılı, sınırlı ve ölçülü olmalıdır. Bu nedenle bir iş sürecinde “ileride lazım olabilir” düşüncesiyle gereksiz kişisel veri toplamak doğru bir yaklaşım değildir. Örneğin staj başvurusu için yalnızca iletişim ve değerlendirme açısından gerekli bilgiler istenmeli, görevle ilgisi olmayan fazladan kişisel bilgiler talep edilmemelidir. Toplanan veri daha sonra başlangıçta belirtilen amaçtan tamamen farklı bir kullanım için gelişigüzel kullanılmamalıdır. Form tasarımında her alan için “Bu bilgi gerçekten gerekli mi?” sorusu sorulmalıdır. Erişim yetkileri de aynı mantıkla yalnızca ihtiyacı olan kişilerle sınırlandırılmalıdır. Saklama süresi dolan ve artık işleme amacı bulunmayan veriler için kurumun silme, yok etme veya anonimleştirme yükümlülükleri ayrıca değerlendirilmelidir.

**İş hayatı örneği:**  
Bir etkinliğe katılım formunda ad, soyad ve kurumsal e-posta yeterliyken kişinin ev adresini ve aile bilgilerini istemek, amaç için gereksiz veri toplamaya örnek olabilir.

---

## 7. Java SE: Functional Interface

Functional interface, yalnızca **bir soyut metoda** sahip olan ve lambda expression için hedef tip olarak kullanılabilen interface'tir.

Java'nın `java.util.function` paketinde sık kullanılan dört interface:

| Interface | Görevi |
|---|---|
| `Predicate<T>` | Bir koşulu test eder, `boolean` döndürür |
| `Function<T,R>` | Bir değeri başka bir değere dönüştürür |
| `Consumer<T>` | Değeri tüketir/işler, sonuç döndürmez |
| `Supplier<T>` | Parametre almadan değer üretir |

### Çalışır mini örnek

```java
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Predicate<String> longName = text -> text.length() >= 5;
        Function<String, String> upperCase = String::toUpperCase;
        Consumer<String> printer = System.out::println;
        Supplier<List<String>> technologies =
                () -> List.of("Java", "Docker", "React", "Git");

        technologies.get().stream()
                .filter(longName)
                .map(upperCase)
                .forEach(printer);
    }
}
```

**Beklenen çıktı:**

```text
DOCKER
REACT
```

Bu örnekte görevde istenenden fazla olarak dört functional interface de kullanılmıştır.

---

## 8. Web Frontend: Modern Responsive Teknikler

### `clamp()`

Minimum, tercih edilen ve maksimum değer arasında akışkan değer üretir.

```css
h1 {
    font-size: clamp(1.5rem, 4vw, 3rem);
}
```

Ekran büyüdükçe yazı büyür fakat `1.5rem` altına veya `3rem` üstüne çıkmaz.

### `min()`

Verilen seçeneklerden küçük olan değeri kullanır.

```css
.container {
    width: min(90%, 1200px);
}
```

### `max()`

Verilen seçeneklerden büyük olan değeri kullanır.

```css
.card {
    padding: max(1rem, 2vw);
}
```

### `aspect-ratio`

Bir elemanın genişlik/yükseklik oranını korur.

```css
.card-image {
    aspect-ratio: 16 / 9;
}
```

### `object-fit`

Görsel veya video gibi replaced element'in kutuya nasıl sığacağını belirler.

```css
.card-image img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
```

`cover`, oranı korur ve kutuyu doldurur; gerekirse görselin kenarlarını kırpar.

### Container Query

Media query tüm viewport'a göre çalışırken container query bir bileşenin kendi kapsayıcısının boyutuna göre stil değiştirmesine izin verir.

```css
.cards {
    container-type: inline-size;
}

@container (min-width: 600px) {
    .card {
        display: grid;
        grid-template-columns: 180px 1fr;
    }
}
```

### Akışkan tipografi + kart görseli örneği

```html
<article class="card-wrapper">
    <div class="card">
        <img
            class="card-image"
            src="https://picsum.photos/800/450"
            alt="Örnek proje görseli"
        >

        <div class="card-content">
            <h2>Docker Eğitimi</h2>
            <p>Container ve Compose temellerini öğrenin.</p>
        </div>
    </div>
</article>
```

```css
.card-wrapper {
    container-type: inline-size;
    width: min(100%, 900px);
    margin: auto;
}

.card {
    padding: max(1rem, 2vw);
}

.card h2 {
    font-size: clamp(1.3rem, 3vw, 2.2rem);
}

.card-image {
    width: 100%;
    aspect-ratio: 16 / 9;
    object-fit: cover;
}

@container (min-width: 600px) {
    .card {
        display: grid;
        grid-template-columns: minmax(220px, 40%) 1fr;
        gap: 1.5rem;
        align-items: center;
    }
}
```

Bu tasarım hem tipografiyi akışkan hale getirir hem de kartın kendi genişliğine göre yerleşimini değiştirir.
