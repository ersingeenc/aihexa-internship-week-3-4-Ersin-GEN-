# AIHEXA - QR Kod Oluşturma Modülü Proje Planı

## Seçilen Modül Adı

**QR Kod Oluşturma Modülü**

---

## Modülün Amacı

QR Kod Oluşturma Modülünün amacı, AIHEXA bünyesinde bulunan eğitim, kurs, etkinlik, web sayfası, iletişim bilgisi veya diğer dijital içerikler için hızlı şekilde QR kod oluşturulmasını sağlamaktır.

Oluşturulan QR kodlar sayesinde kullanıcılar uzun bağlantıları manuel olarak yazmak yerine telefonların kamerası ile QR kodu tarayarak ilgili içeriğe kolayca ulaşılabilir.

---

## Modülü Kim Kullanacak?

Modülü temel olarak iki kullanıcı grubu kullanacaktır:

### Kullanıcı

> AIHEXA'nın internet sitesini ziyaret eden öğrenciler, eğitim almak isteyen kişiler, profesyoneller veya diğer ziyaretçiler.

### Admin

> AIHEXA yöneticileri ve içerik yöneticileri modülü kullanarak farklı içerikler için QR kod oluşturulabilir ve oluşturulan QR kodları yönetilebilir.

---

## Kullanıcı Bu Modülde Ne Yapmak İster?

Kullanıcı QR kod üzerinden:

* AIHEXA web sitesine ulaşmak
* Eğitim detaylarını görüntülemek
* Kurs sayfalarına ulaşmak
* Eğitim başvuru formunu açmak
* Blog içeriklerine ulaşmak
* Sosyal medya hesaplarına ulaşmak
* Telefon üzerinden hızlı şekilde bağlantı açmak

---

## Admin Bu Modülde Ne Yapmak İster?

Admin QR Kod Oluşturma Modülünde:

* Yeni QR kod oluşturmak
* QR kod için bağlantı belirlemek
* QR koda açıklayıcı başlık vermek
* Oluşturulan QR kodları görüntülemek
* QR kod listesini yönetmek
* QR kodun bağlı olduğu bağlantıyı görüntülemek
* Gerekirse QR kod kaydını silmek
* QR kodu görsel olarak indirmek
* QR kodu eğitim veya tanıtım materyallerinde kullanmak

ister.

---

## Bu Modül AIHEXA'ya Ne Katkı Sağlar?

QR Kod Oluşturma Modülü AIHEXA'nın dijital içeriklerine daha kolay ulaşılmasını sağlar.

### Modül Sayesinde:

* Eğitimlere erişim kolaylaşır
* Kurs bağlantıları hızlı şekilde paylaşılabilir.
* Sosyal medya içerikleri desteklenebilir.
* Fiziksel tanıtım materyalleri ile internet sitesi arasında bağlantı kurulabilir.
* Broşür, afiş ve kartvizitlerde QR kod kullanılabilir.
* Kullanıcıların uzun URL adreslerine yazmasına gerek kalmaz.
* AIHEXA'nın dijital ve modern bir kullanıcı deneyimi sunmasına katkı sağlar.
* Eğitim ve etkinlik tanıtımlarının daha etkili yapılmasını sağlar.

---

## Fronetend Tarafında Hangi Ekranlar Gerekir?

### 1) QR Kod Oluşturma Ekranı

Adminin yeni QR kod oluşturabileceği ekrandır.

Form içerisinde:

* QR kod başlığı
* Yönlendirilecek URL
* Açıklama

alanları bulunabilir.

Admin bilgileri girdikten sonra **QR Kod Oluştur** butonuna basar.

### 2) QR Kod Önizleme Ekranı

QR kod oluşturulduktan sonra admin QR kodu ekranda görebilir.

Bu ekranda:

* QR kod görseli
* QR kod başlığı
* Bağlantı adresi
* QR kod indirme butonu

bulunabilir.

### 3) QR Kod Detay Ekranı

Seçilen QR kod hakkında ayrıntılı bilgilerin görüntülendiği ekrandır.

Bu ekranda:

* QR kod görseli
* Başlık
* Açıklama
* URL
* Oluşturulma tarihi

görüntülenebilir.

---

## Backend Tarafında Hangi İşlemler Gerekir?

Backend tarafında QR kodların oluşturulması ve yönetilmesi sağlanacaktır.

Gerekli temel işlemler:

* **QR Kod Oluşturma:** Admin tarafından gönderilen URL kullanılarak yeni bir QR kod oluşturulur.
* **QR Kod Kaydetme:** Oluşturulan QR kodun bilgileri veritabanına kaydedilir.
* **QR Kod Listeleme:** Sistemde daha önce oluşturulmuş QR kodların listesi frontend tarafına gönderilir.
* **QR Kod Detayı Görüntüleme:** Belirli bir QR kodun bilgileri ID üzerinden bulunarak kullanıcıya veya admine gösterilir.
* **QR Kod Görseli Oluşturma:** Girilen URL'nin QR kod formatına dönüştürülmesini sağlar.
* **QR Kod İndirme:** Oluşturulan QR kodun PNG gibi bir görsel formatında inidirilmesini sağlar.

---

## Database tarafında hangi bilgiler tutulmalıdır?

### QR Kod Tablosu

| Alan          | Açıklama                                |
| ------------- | --------------------------------------- |
| `id`          | QR kodun benzersiz kimliği              |
| `title`       | QR kod için verilen başlık              |
| `url`         | QR kodun yönlendireleceği bağlantı      |
| `description` | QR kod hakkında kısa açıklama           |
| `imagePath`   | Oluşturulan QR kod görselinin konumu    |
| `createdAt`   | QR kodun oluşturulma tarihi             |
| `updateAt`    | QR kodun son güncelleme tarihi          |
| `active`      | QR kodun aktif olup olmadığını belirtir |

---

## Bu Modül Sosyal Medya, SSEO veya Eğitim Tarafına Nasıl Katkı Sağlar?

### Eğitim Tarafına Katkısı

QR kodlar eğitim süreçlerinde aktif şekilde kullanılabilir.

Örneğin:

* Eğitim başvuru formuna yönlendirme
* Kurs sayfasına yönlendirme
* Eğitim materyallerine erişim
* Eğitim videolarına ulaşma
* Ders notlarına ulaşma
* Sertifika doğrulama sayfasına yönlendirme

gibi işlemler QR kod tarandığında kullanıcı doğrudan ilgili eğitimin detay sayfasına ulaşabilir.

### Sosyal Medya tarafına Katkısı

QR kodlar AIHEXA'nın sosyal medya hesaplarının tanıtımında kullanılabilir.

Örneğin QR kodlar:

* İnstagram
* Linkedn
* Youtube
* X
* Facebook

gibi sosyal medya hesaplarına yönlendirme sağlayabilir.

Ayrıca sosyal medya üzerinde paylaşılan eğitim veya etkinlik içeriklerinde de QR kod kullanılabilir.

### SEO Tarafına Katkısı

QR kod doğrudan bir SEO yöntemi değildir. Ancak kullanıcılarının AIHEXA'nın web sayfalarına daha kolay ulaşmasını sağlayarak site trafiğini destekleyebilir.

QR Kodlar Özellikle:

* Blog yazıları
* Eğitim sayfaları
* Kurs detayları
* Etkinlik sayfaları
* Kampanya sayfaları

gibi içeriklere yönlendirme yapmak için kullanılabilir.

Bu sayede farklı platformlardan AIHEXA internet sitesine kullanıcı yönlendirilmesi sağlanabilir.

---

## Modülün Genel Çalışma Mantığı

```text
Admin
  ↓
QR Kod Oluşturma formu
  ↓
Başlık + URL + Açıklama
  ↓
Backend
  ↓
QR Kod oluşturulur.
  ↓
Database'e kaydedilir.
  ↓
QR kod görseli gösterilir.
  ↓
Admin Qr kodu indirir
  ↓
Sosyal Medya/Eğitim/Afiş/Web sitesinde paylaşılır.
  ↓
Kullanıcı QR kodu tarar.
  ↓
İlgili AIHEXA içeriğine ulaşır.
```

