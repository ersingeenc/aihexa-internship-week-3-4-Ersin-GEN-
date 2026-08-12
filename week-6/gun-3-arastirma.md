# 3. Gün Araştırma Notları
## Secret / Config Yönetimi ve Ortam Ayrımı

Bu dosya 3. güne ait araştırma başlıklarını tek yerde toplar.

---

## 1. 12-Factor Config Prensibi Nedir?

12-Factor yaklaşımında uygulama ayarlarının doğrudan kaynak kodun içine gömülmemesi önerilir. Özellikle deploy'a göre değişen config değerleri koddan ayrılmalıdır.

Bu değerlere örnek:
- Database bağlantı adresi,
- Kullanıcı adı,
- API endpoint'i,
- Port,
- Harici servis ayarları,
- Ortama göre değişen feature/config değerleri.

Basit Spring Boot örneği:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Burada uygulamanın kaynak kodu dev, test ve prod ortamı için aynı kalabilir; yalnızca çalışma ortamında sağlanan değerler değişir.

> Not: Parola ve API anahtarı gibi gerçek secret'ların yalnızca düz environment variable olarak saklanması her sistem için en güvenli seçenek değildir. Container/production ortamlarında secret manager veya Docker secrets gibi özel mekanizmalar tercih edilebilir.

---

## 2. Secret Rotation Nedir?

Secret rotation; parola, API key, token veya cryptographic key gibi gizli değerlerin belirli aralıklarla veya risk oluştuğunda yenisiyle değiştirilmesidir.

Temel süreç:

```text
Yeni secret oluştur
        ↓
Yeni değeri sisteme tanıt
        ↓
Uygulamanın yeni değerle çalıştığını doğrula
        ↓
Eski secret'ı geçersiz kıl
```

**Neden önemlidir?**
- Uzun süre aynı kalan credential'ın ele geçirilme riskini azaltır.
- Bir secret sızdığında erişimi hızlı biçimde kesmeyi sağlar.
- Eski veya artık kullanılmayan anahtarların yaşamaya devam etmesini önler.

Rotation yapılırken uygulamanın kesintiye uğramaması için eski ve yeni secret'ın kısa bir geçiş döneminde kontrollü biçimde birlikte kabul edilmesi gerekebilir.

---

## 3. Dev / Test / Prod Config Neden Ayrılır?

Farklı ortamların amaçları farklıdır.

| Ortam | Amaç | Örnek özellik |
|---|---|---|
| Development | Geliştirme | Lokal DB, ayrıntılı log |
| Test | Otomatik/manuel test | Test DB, test servisleri |
| Production | Gerçek kullanıcı | Gerçek altyapı, sıkı güvenlik |

Aynı database veya API credential'ının tüm ortamlarda kullanılması ciddi risk oluşturur. Development ortamındaki bir sızıntının production verisine erişim vermemesi gerekir.

Spring Boot profile örneği:

```text
application.properties
application-dev.properties
application-test.properties
application-prod.properties
```

Ancak gerçek parolalar bu dosyalara yazılıp Git'e gönderilmemelidir.

`.env.example` benzeri örnek dosyada yalnızca değişken isimleri ve örnek değerler tutulabilir:

```env
DB_URL=jdbc:postgresql://localhost:5432/appdb
DB_USERNAME=your_username
DB_PASSWORD=your_password
JWT_SECRET=change_me
```

Gerçek `.env`:

```gitignore
.env
.env.*
!.env.example
```

---

## 4. Yazılım Terimi: Cache

Cache, sık kullanılan verinin daha hızlı erişilebilen bir yerde geçici olarak tutulmasıdır. Böylece aynı veri için her seferinde maliyetli işlem, uzak ağ isteği veya veritabanı sorgusu yapmak gerekmeyebilir.

### Performansı nasıl artırır?

Örneğin ürün listesi her istekte veritabanından okunuyorsa:

```text
Kullanıcı → Backend → Database
```

Cache kullanıldığında:

```text
Kullanıcı → Backend → Cache
                   ↘ gerektiğinde Database
```

Cache hit olduğunda gecikme ve backend/database yükü azalabilir.

### Stale data riski nasıl oluşur?

Cache'teki veri güncelliğini kaybettiği halde istemciye veya uygulamaya sunulursa **stale data** oluşur.

Örnek:
1. Ürün fiyatı DB'de 100 TL'den 120 TL'ye güncellenir.
2. Cache hâlâ 100 TL değerini tutuyordur.
3. Cache temizlenmez veya süresi dolmazsa kullanıcı eski fiyatı görebilir.

Bu nedenle cache tasarımında:
- TTL,
- invalidation,
- yeniden doğrulama,
- güncelleme stratejisi

gibi konular planlanmalıdır.

---

## 5. Git: Squash

Squash, birden çok küçük commit'i tek ve anlamlı bir commit altında birleştirme yaklaşımıdır.

Örnek geçmiş:

```text
a1 - login sayfası eklendi
b2 - typo düzeltildi
c3 - buton düzeltildi
d4 - login tamamlandı
```

Squash sonrası:

```text
x9 - feat: login ekranını tamamla
```

Interactive rebase örneği:

```bash
git rebase -i HEAD~4
```

Editörde:

```text
pick   a1 login sayfası eklendi
squash b2 typo düzeltildi
squash c3 buton düzeltildi
squash d4 login tamamlandı
```

**Neden kullanılır?**
- Ana branch geçmişini temiz tutar.
- Çok küçük “fix”, “typo”, “deneme” commit'lerini tek mantıksal değişiklik haline getirir.

**Dikkat:** Rebase/squash commit geçmişini yeniden yazar. Başkalarının kullandığı paylaşılmış branch üzerinde kontrolsüz uygulanması senkronizasyon problemlerine yol açabilir.

---

## 6. Dijital Okuryazarlık: Güvenli Dosya Paylaşımı

Public veya “anyone with the link” biçimindeki bağlantılarda linki elde eden kişiler dosyaya erişebilir; bu yüzden hassas iş dosyalarında mümkün olduğunca sınırlı erişim tercih edilmelidir. Restricted paylaşımda dosya yalnızca özellikle yetkilendirilmiş kullanıcı veya gruplara açılır ve erişim kapsamı daha kontrollüdür. Viewer, commenter ve editor yetkileri aynı değildir; kullanıcıya yalnızca işi için gereken en düşük yetki verilmelidir. Süreli erişim desteklenen sistemlerde geçici çalışan, müşteri veya dış paydaş için erişimin otomatik sona ermesi riski azaltabilir. Link bir sohbet grubuna gönderilmeden önce gruba daha sonra katılacak kişilerin de erişim kazanıp kazanmadığı kontrol edilmelidir. Paylaşımdan sonra “kimlerin erişimi var?” listesi periyodik olarak gözden geçirilmelidir. Hassas veya kişisel veri içeren dosyalarda public link kullanmak yerine kimliği belirli kullanıcılarla sınırlı paylaşım yapılması daha güvenli bir varsayımdır.

### Kısa karşılaştırma

| Paylaşım türü | Risk / kullanım |
|---|---|
| Public / anyone with link | Link yayıldığında kontrol kaybı riski daha yüksek |
| Restricted | Yalnızca izin verilen hesaplar erişir |
| Süreli erişim | Geçici erişimi otomatik sonlandırmak için yararlı |

---

## 7. Java SE: Stream API

Stream API, koleksiyonlar üzerinde declarative biçimde filtreleme, dönüştürme, sıralama ve sonuç toplama işlemleri yapmayı kolaylaştırır.

Sık kullanılan işlemler:
- `filter()` → koşula uyanları seçer.
- `map()` → elemanları dönüştürür.
- `sorted()` → sıralar.
- `collect()` → sonucu bir koleksiyonda toplar.

### Çalışır mini örnek

```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> technologies =
                List.of("java", "docker", "git", "spring boot", "react");

        List<String> result = technologies.stream()
                .filter(item -> item.length() >= 5)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
```

**Beklenen çıktı:**

```text
DOCKER
REACT
SPRING BOOT
```

Bu zincirde orijinal liste değiştirilmeden yeni bir sonuç listesi üretilir.

---

## 8. Web Frontend: Bootstrap 5 Validation, Toast ve Dropdown

### Bootstrap Validation

Bootstrap, HTML5 form doğrulamasını görsel geri bildirim sınıflarıyla destekler. Genellikle submit denemesinden sonra forma `.was-validated` sınıfı eklenir.

```html
<form id="applicationForm" class="needs-validation" novalidate>
    <label for="email" class="form-label">E-posta</label>

    <input
        id="email"
        type="email"
        class="form-control"
        required
    >

    <div class="invalid-feedback">
        Geçerli bir e-posta adresi girin.
    </div>

    <button class="btn btn-primary mt-3" type="submit">
        Kaydet
    </button>
</form>
```

JavaScript:

```javascript
const form = document.getElementById("applicationForm");

form.addEventListener("submit", event => {
    if (!form.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
    }

    form.classList.add("was-validated");
});
```

### Toast

Toast, kullanıcıya kısa süreli bildirim göstermek için kullanılan Bootstrap bileşenidir.

```html
<div
    id="successToast"
    class="toast"
    role="status"
    aria-live="polite"
>
    <div class="toast-header">
        <strong class="me-auto">Başarılı</strong>
        <button
            type="button"
            class="btn-close"
            data-bs-dismiss="toast"
        ></button>
    </div>

    <div class="toast-body">
        Form başarıyla kaydedildi.
    </div>
</div>
```

```javascript
const toastElement = document.getElementById("successToast");
const toast = new bootstrap.Toast(toastElement);
toast.show();
```

### Dropdown

Dropdown, kullanıcıya açılır bir işlem/seçenek menüsü sunar.

```html
<div class="dropdown">
    <button
        class="btn btn-secondary dropdown-toggle"
        type="button"
        data-bs-toggle="dropdown"
        aria-expanded="false"
    >
        İşlemler
    </button>

    <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="#">Görüntüle</a></li>
        <li><a class="dropdown-item" href="#">Düzenle</a></li>
        <li><a class="dropdown-item" href="#">Sil</a></li>
    </ul>
</div>
```

### Form geri bildirimi + bildirim akışı

```text
Kullanıcı formu gönderir
        ↓
HTML5 / Bootstrap validation
        ↓
Geçersiz → alanın altında hata mesajı
        ↓
Geçerli → backend isteği
        ↓
Başarılı → Bootstrap toast
```

Bootstrap'ın dropdown ve toast bileşenlerinin çalışması için Bootstrap JavaScript bundle'ın sayfaya dahil edilmesi gerekir.

---

## 9. Config / Secret İçin Kısa Uygulama Kontrolü

```text
[ ] Gerçek parola source code içinde değil
[ ] .env Git'e gönderilmiyor
[ ] .env.example gerçek secret içermiyor
[ ] Dev/test/prod credential'ları birbirinden ayrı
[ ] Kullanılmayan secret'lar iptal ediliyor
[ ] Secret rotation yöntemi tanımlı
[ ] Container image içinde secret bulunmuyor
[ ] Erişimler minimum yetki prensibiyle sınırlandırılıyor
```
