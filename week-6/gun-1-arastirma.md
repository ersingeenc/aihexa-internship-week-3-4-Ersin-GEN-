# 1. Gün Araştırma Notları
## Dockerfile ve Reproducible Build

Bu dosya 1. güne ait araştırma başlıklarını tek yerde toplar.

---

## 1. Dockerfile ve Reproducible Build

### Multi-stage build nedir?

Multi-stage build, bir Dockerfile içerisinde birden fazla `FROM` aşaması kullanarak uygulamanın **derleme ortamı** ile **çalışma ortamını** birbirinden ayırma yöntemidir. İlk aşamada Maven/Gradle, JDK ve derleme araçları bulunabilir; son aşamaya ise yalnızca çalıştırmak için gereken JRE ve oluşturulan `.jar` dosyası alınır.

**Neden önemlidir?**
- Final image daha küçük olur.
- Derleme araçları production image içinde kalmaz.
- Gereksiz paketler azaldığı için saldırı yüzeyi küçülür.
- Build süreci daha düzenli ve tekrarlanabilir hale gelir.

**Spring Boot için örnek:**

```dockerfile
# Build aşaması
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Runtime aşaması
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
```

Burada Maven ve JDK yalnızca `build` aşamasında kullanılır. Final image içerisine sadece JRE ve uygulama paketi taşınır.

---

### Base image seçimi güvenliği nasıl etkiler?

Base image, Docker image'ın üzerine kurulduğu temel katmandır. Gereksiz araçlar, eski paketler veya güvenlik açığı bulunan bağımlılıklar içeren bir base image kullanmak final image'ın riskini artırır.

**Daha güvenli seçim için:**
- Güvenilir ve resmi image'lar tercih edilmelidir.
- Gereksiz paket içermeyen daha küçük runtime image'ları seçilmelidir.
- Image sürümü mümkün olduğunca açık şekilde belirtilmelidir.
- Image düzenli olarak güncellenmeli ve güvenlik taramasından geçirilmelidir.
- Uygulama root yetkisine ihtiyaç duymuyorsa non-root kullanıcıyla çalıştırılmalıdır.

**Non-root örneği:**

```dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app

RUN useradd -r -u 1001 appuser
COPY target/app.jar app.jar

USER appuser
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Bu yaklaşım, container içerisindeki uygulamanın gereksiz yönetici yetkileriyle çalışmasını önlemeye yardımcı olur.

---

### Layer cache nasıl optimize edilir?

Docker, Dockerfile komutlarının sonuçlarını katmanlar halinde önbelleğe alabilir. Bir katman değişirse ondan sonraki katmanların yeniden oluşturulması gerekebilir.

**Cache'i daha verimli kullanmak için:**
1. Sık değişmeyen adımlar Dockerfile'ın üst tarafında tutulmalıdır.
2. Sık değişen kaynak kodları daha sonra kopyalanmalıdır.
3. Gereksiz dosyalar `.dockerignore` ile build context dışında bırakılmalıdır.
4. Paket yöneticilerinin cache mount özelliklerinden yararlanılabilir.
5. Dependency dosyaları kaynak koddan ayrı kopyalanarak bağımlılık indirme adımı tekrar kullanılabilir.

**Mantık örneği:**

```dockerfile
COPY pom.xml .
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw package
```

Sadece `src` değiştiğinde bağımlılıkların her build'de yeniden indirilmesi engellenebilir.

---

## 2. Yazılım Terimi: CI ve CD

### CI nedir?

**Continuous Integration (Sürekli Entegrasyon)**, geliştiricilerin yaptığı değişikliklerin düzenli olarak ortak repository'ye alınması ve bu değişiklikler üzerinde otomatik build/test işlemlerinin çalıştırılması yaklaşımıdır.

CI'nin amacı hataları mümkün olduğunca erken yakalamaktır.

Örnek akış:

```text
Commit / Pull Request
        ↓
      Build
        ↓
      Test
        ↓
   Sonuç raporu
```

### CD nedir?

CD iki yakın kavram için kullanılır:

- **Continuous Delivery:** Kodun her zaman production'a gönderilebilir durumda tutulmasıdır. Production'a geçişte manuel onay bulunabilir.
- **Continuous Deployment:** Testlerden geçen değişikliklerin manuel onay olmadan otomatik olarak production'a dağıtılmasıdır.

### CI ve CD farkı

| Kavram | Temel amaç |
|---|---|
| CI | Değişiklikleri sık birleştirmek, build ve test ile erken hata bulmak |
| Continuous Delivery | Yazılımı her an dağıtıma hazır tutmak |
| Continuous Deployment | Başarılı değişiklikleri otomatik olarak production'a dağıtmak |

---

## 3. Git: `cherry-pick`

`git cherry-pick`, başka bir branch'teki belirli bir commit'in yaptığı değişiklikleri mevcut branch'e uygulamak için kullanılır.

**Ne zaman yararlıdır?**
- Bir bug fix yalnızca belirli bir branch'e alınacaksa,
- Tüm feature branch'i merge etmek istenmiyorsa,
- Yanlış branch'e atılmış tek bir commit doğru branch'e taşınacaksa.

**Örnek:**

```bash
git log --oneline
git checkout main
git cherry-pick a1b2c3d
```

### Geçmiş açısından riskleri

Cherry-pick aynı değişikliği yeni bir commit kimliğiyle oluşturur. Çok sık kullanılırsa:
- Aynı mantıksal değişiklik farklı commit'ler olarak geçmişte bulunabilir.
- Daha sonra yapılan merge işlemlerini anlamak zorlaşabilir.
- Conflict ihtimali artabilir.
- Branch geçmişi neden-sonuç ilişkisini daha az açık gösterebilir.

Bu nedenle cherry-pick, tüm branch'i birleştirmek yerine **özellikle seçilmiş commit'lerin gerekli olduğu durumlarda** kullanılmalıdır.

---

## 4. Dijital Okuryazarlık: Fotoğraf / Video Rızası

Bir stajyerin, çalışanın veya müşterinin tanınabilir görüntüsü kişisel veri niteliği taşıyabileceği için görüntünün çekilmesi ve özellikle sosyal medyada paylaşılması öncesinde veri işleme şartı ve paylaşım amacı değerlendirilmelidir. Paylaşımın neden yapılacağı açık olmalı ve görüntü yalnızca belirlenen amaçla uyumlu şekilde kullanılmalıdır. Kişiye fotoğrafın veya videonun nerede yayınlanacağı konusunda anlaşılır bilgi verilmesi önemlidir. Gerekmeyen kişilerin görüntülerini kadraja almak veya amaç için gerekli olmayan fazla görüntü toplamak veri minimizasyonu yaklaşımıyla bağdaşmaz. Kurum içi kayıt ile herkese açık sosyal medya paylaşımının erişim kapsamı aynı değildir; bu nedenle riskleri de farklıdır. Özellikle tanıtım amaçlı paylaşımlarda gerekli hukuki dayanak ve gerekiyorsa açık rıza süreci kurum tarafından önceden belirlenmelidir. Rıza veya başka bir hukuki sebep bulunmayan görüntüler gelişigüzel şekilde paylaşılmamalıdır.

**Kısa kontrol listesi:**
- Paylaşım amacı belli mi?
- Görüntüde kimlerin bulunduğu biliniyor mu?
- İlgili kişiye nerede paylaşılacağı söylendi mi?
- Gereken hukuki şart / izin sağlandı mı?
- Gereksiz kişi veya bilgiler görüntüden çıkarılabilir mi?

---

## 5. Java SE: Lambda Expression

Lambda expression, tek bir davranışı kısa biçimde ifade etmeyi sağlar ve özellikle functional interface'lerle birlikte kullanılır.

### Temel sözdizimi

```java
(parametreler) -> ifade
```

veya:

```java
(parametreler) -> {
    // işlemler
}
```

### Çalışır mini örnek: filtreleme + sıralama

```java
import java.util.ArrayList;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> technologies = new ArrayList<>(
                List.of("Docker", "Java", "Git", "PostgreSQL", "React")
        );

        technologies.removeIf(name -> name.length() < 5);
        technologies.sort((a, b) -> a.compareToIgnoreCase(b));

        technologies.forEach(name -> System.out.println(name));
    }
}
```

**Beklenen çıktı:**

```text
Docker
PostgreSQL
React
```

Lambda ifadeleri özellikle filtreleme, sıralama, event işlemleri ve Stream API gibi alanlarda daha kısa ve okunabilir kod yazmayı sağlar.

---

## 6. Web Frontend: HTML5 İleri Form Senaryoları

### `fieldset` ve `legend`

`fieldset`, ilişkili form alanlarını mantıksal olarak gruplar. `legend` ise bu grubun başlığını belirtir.

```html
<fieldset>
    <legend>İletişim Bilgileri</legend>

    <label for="email">E-posta</label>
    <input id="email" type="email">
</fieldset>
```

Bu yapı özellikle uzun formların anlaşılabilirliğini ve erişilebilirliğini artırır.

### `autocomplete`

Tarayıcıya alanın hangi bilgiyi beklediğini bildirir ve uygun durumlarda daha önce kaydedilmiş bilgilerin doldurulmasını kolaylaştırır.

```html
<input type="text" name="name" autocomplete="name">
<input type="email" name="email" autocomplete="email">
```

Şifre, kart bilgisi veya kişisel veri içeren alanlarda autocomplete davranışı tasarlanırken güvenlik ve kullanım amacı ayrıca değerlendirilmelidir.

### `multiple`

Bir input veya select alanında birden fazla değer seçilebilmesini sağlar.

```html
<input type="file" name="documents" multiple>
```

### File input

```html
<input
    type="file"
    name="cv"
    accept=".pdf,.doc,.docx"
    required
>
```

`accept` kullanıcıya beklenen dosya türü hakkında yardımcı olur; ancak gerçek dosya türü kontrolü backend tarafında da yapılmalıdır.

### Profesyonel çok alanlı form örneği

```html
<form action="/applications" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>Kişisel Bilgiler</legend>

        <label for="fullName">Ad Soyad</label>
        <input
            id="fullName"
            name="fullName"
            type="text"
            autocomplete="name"
            required
        >

        <label for="email">E-posta</label>
        <input
            id="email"
            name="email"
            type="email"
            autocomplete="email"
            required
        >
    </fieldset>

    <fieldset>
        <legend>Başvuru Bilgileri</legend>

        <label for="skills">Teknolojiler</label>
        <select id="skills" name="skills" multiple>
            <option>Java</option>
            <option>Spring Boot</option>
            <option>React</option>
            <option>Docker</option>
        </select>

        <label for="cv">CV</label>
        <input
            id="cv"
            name="cv"
            type="file"
            accept=".pdf"
            required
        >
    </fieldset>

    <button type="submit">Başvuruyu Gönder</button>
</form>
```

### Kullanıcı deneyimi kuralları

- Her input için görünür bir `label` kullanılmalıdır.
- Placeholder, label yerine kullanılmamalıdır.
- Zorunlu alanlar açık biçimde belirtilmelidir.
- Hata mesajı hangi alanda sorun olduğunu söylemelidir.
- Dosya alanında kabul edilen format ve mümkünse boyut sınırı kullanıcıya önceden gösterilmelidir.
- Uzun formlar anlamlı `fieldset` gruplarına ayrılmalıdır.
- Kullanıcıdan ihtiyaç duyulmayan veri istenmemelidir.
