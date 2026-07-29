# React Form Analizi – QR Kod Oluşturma Modülü

## 1. React Form Mantığı Nedir?

React form yapısı, kullanıcıdan alınan bilgilerin uygulama içerisinde yönetilmesini sağlar.

Form içerisinde bulunan `input`, `select`, `checkbox` ve `textarea` gibi alanlara girilen değerler React tarafında genellikle **state** içerisinde tutulur.

Örneğin kullanıcı QR kod oluşturmak için bir URL girdiğinde:

```jsx
const [url, setUrl] = useState("");
```

şeklinde değer tutulabilir.

Kullanıcı input alanına veri girdikçe state güncellenir.

---

## 2. Form Alanı Nedir?

Form alanı, kullanıcıdan bilgi almak için kullanılan bölümlerdir.

QR Kod Oluşturma Modülünde form alanları:

* QR kod adı
* QR kod tipi
* İçerik
* Açıklama
* Boyut
* Renk
* Arka plan rengi
* Aktiflik durumu

gibi bilgiler olabilir.

---

## 3. Input Nedir?

`input`, kullanıcıdan kısa veri almak için kullanılan HTML form elemanıdır.

Örneğin QR kod adı:

```html
<input type="text" />
```

URL almak için:

```html
<input type="url" />
```

kullanılabilir.

React içerisinde input değerleri state ile yönetilebilir.

---

## 4. Select Nedir?

`select`, kullanıcının hazır seçeneklerden birini seçmesini sağlar.

QR Kod Modülünde kullanıcının QR kod türünü seçmesi için kullanılabilir.

Örneğin:

```html
<select>
  <option>URL</option>
  <option>Metin</option>
  <option>E-posta</option>
  <option>Telefon</option>
</select>
```

---

## 5. Checkbox Nedir?

`checkbox`, kullanıcının bir seçeneği işaretlemesini sağlar.

QR Kod Modülünde örneğin:

* QR kod aktif olsun
* QR kod herkese açık olsun

gibi seçenekler için kullanılabilir.

```html
<input type="checkbox" />
```

---

## 6. Textarea Nedir?

`textarea`, kullanıcının uzun metin girebilmesini sağlayan form alanıdır.

QR Kod Modülünde kullanıcı QR kod için açıklama yazmak istediğinde kullanılabilir.

```html
<textarea></textarea>
```

---

## 7. Buton Durumu Nasıl Yönetilir?

React içerisinde butonun aktif veya pasif olması state ile yönetilebilir.

Örneğin formda gerekli bilgiler girilmemişse:

```jsx
<button disabled={!name || !content}>
  QR Kod Oluştur
</button>
```

Buton pasif hale getirilebilir.

API isteği gönderilirken de kullanıcının aynı işlemi birden fazla kez yapmasını engellemek için buton geçici olarak kapatılabilir.

---

## 8. Zorunlu Alan Uyarısı Nasıl Gösterilir?

Form gönderilmeden önce zorunlu alanların doldurulup doldurulmadığı kontrol edilir.

Örneğin:

* QR kod adı boş bırakılamaz.
* QR kod tipi seçilmelidir.
* QR kod içeriği girilmelidir.

Kullanıcı gerekli alanlardan birini boş bırakırsa:

```text
QR kod adı zorunludur.
```

gibi bir hata mesajı gösterilebilir.

---

## 9. Loading Durumu Nasıl Gösterilir?

Frontend backend'e istek gönderdiğinde işlemin tamamlanması biraz zaman alabilir.

Bu sırada kullanıcıya:

```text
QR kod oluşturuluyor...
```

mesajı gösterilebilir.

React içerisinde:

```jsx
const [loading, setLoading] = useState(false);
```

şeklinde loading durumu tutulabilir.

İstek başladığında:

```jsx
setLoading(true);
```

İstek tamamlandığında:

```jsx
setLoading(false);
```

yapılır.

---

## 10. Başarılı Mesaj Nasıl Gösterilir?

Backend işlemin başarılı olduğunu bildirdiğinde kullanıcıya bir başarı mesajı gösterilir.

Örneğin:

> QR kod başarıyla oluşturuldu.

Bu mesaj bir bildirim, modal veya sayfa içerisinde mesaj olarak gösterilebilir.

---

## 11. Hata Mesajı Nasıl Gösterilir?

Backend isteği sırasında hata oluşursa kullanıcı bilgilendirilmelidir.

Örneğin:

> QR kod oluşturulurken bir hata oluştu.

veya:

> Geçerli bir URL giriniz.

Frontend backend'den gelen hata mesajını kullanıcıya gösterebilir.

---

## 12. Form Submit Nedir?

Form submit, kullanıcının formu tamamladıktan sonra bilgileri göndermesi işlemidir.

Örneğin kullanıcı:

**QR Kod Oluştur**

butonuna bastığında form submit işlemi gerçekleşir.

React içerisinde:

```jsx
const handleSubmit = (event) => {
  event.preventDefault();

  // Form işlemleri
};
```

kullanılabilir.

`preventDefault()` sayfanın form gönderildiğinde yeniden yüklenmesini engeller.

---

## 13. API'ye Veri Gönderme Mantığı Nedir?

Kullanıcı formu doldurduktan sonra frontend verileri toplar ve JSON formatına dönüştürür.

Bu veri HTTP isteği kullanılarak backend API'ye gönderilir.

Örneğin:

```text
POST /api/qr-codes
```

Frontend:

```text
React Form
    ↓
Form Verileri
    ↓
JSON
    ↓
HTTP Request
    ↓
Backend API
```

Backend isteği aldıktan sonra:

1. Gelen verileri kontrol eder.
2. Gerekli işlemleri gerçekleştirir.
3. QR kodu oluşturur.
4. Veritabanına kaydeder.
5. Frontend'e response gönderir.

---

# QR Kod Oluşturma Modülü Frontend Analizi

## Seçilen Modül İçin Gerekli Frontend Ekranları

QR Kod Oluşturma Modülü için aşağıdaki ekranlar oluşturulabilir.

### 1. QR Kod Oluşturma Ekranı

Kullanıcının yeni bir QR kod oluşturacağı ana form ekranıdır.

Kullanıcı QR kod bilgilerini burada girer.

### 2. QR Kod Önizleme Ekranı

Oluşturulan QR kod kullanıcıya gösterilir.

Bu ekranda:

* QR kod görüntüsü
* QR kod adı
* İçerik
* Oluşturulma tarihi

gösterilebilir.

### 3. QR Kodlarım Ekranı

Kullanıcının daha önce oluşturduğu QR kodların listelendiği ekrandır.

Kullanıcı buradan QR kodlarını görüntüleyebilir veya silebilir.

### 4. QR Kod Detay Ekranı

Seçilen QR kod hakkında ayrıntılı bilgilerin gösterildiği ekrandır.

### 5. Admin QR Kod Listeleme Ekranı

Admin sistemde oluşturulan QR kodları görüntüleyebilir.

Gerekli durumlarda QR kodları kontrol edebilir veya silebilir.

---

# Form Alanları

QR kod oluşturma formunda aşağıdaki alanlar bulunabilir:

| Form Alanı      | Türü             | Açıklama                                |
| --------------- | ---------------- | --------------------------------------- |
| QR Kod Adı      | Input            | QR kod için belirlenen isim             |
| QR Kod Tipi     | Select           | URL, metin, e-posta veya telefon seçimi |
| İçerik          | Input / Textarea | QR kod içerisinde bulunacak veri        |
| Açıklama        | Textarea         | QR kod hakkında açıklama                |
| Boyut           | Select           | QR kodun görüntü boyutu                 |
| QR Rengi        | Color Input      | QR kodun rengini belirler               |
| Arka Plan Rengi | Color Input      | QR kod arka plan rengini belirler       |
| Aktif           | Checkbox         | QR kodun aktif olup olmadığını belirler |
| QR Kod Oluştur  | Button           | Formu backend'e gönderir                |

---

# Zorunlu Alanlar

QR kod oluşturulabilmesi için bazı alanların doldurulması zorunlu olmalıdır.

| Alan            | Zorunlu |
| --------------- | ------- |
| QR Kod Adı      | Evet    |
| QR Kod Tipi     | Evet    |
| İçerik          | Evet    |
| Açıklama        | Hayır   |
| Boyut           | Hayır   |
| QR Rengi        | Hayır   |
| Arka Plan Rengi | Hayır   |
| Aktiflik Durumu | Hayır   |

Zorunlu alanlar doldurulmadan form gönderilmemelidir.

---

# Kullanıcı Hangi Adımları Takip Eder?

1. Kullanıcı QR Kod Oluşturma sayfasını açar.
2. QR kod için bir isim girer.
3. QR kod türünü seçer.
4. QR kod içerisinde bulunacak içeriği girer.
5. İsterse açıklama ekler.
6. QR kod boyutunu belirler.
7. QR kod rengini belirler.
8. Arka plan rengini belirler.
9. Aktiflik durumunu seçer.
10. **QR Kod Oluştur** butonuna basar.
11. Frontend zorunlu alanları kontrol eder.
12. Form bilgileri JSON formatına dönüştürülür.
13. JSON verisi backend API'ye gönderilir.
14. Backend verileri kontrol eder.
15. QR kod oluşturulur.
16. Backend frontend'e response gönderir.
17. İşlem başarılıysa QR kod kullanıcıya gösterilir.
18. Hata oluşursa kullanıcıya hata mesajı gösterilir.

---

# Formdan Backend'e Gönderilecek JSON

Örnek olarak frontend tarafından backend'e aşağıdaki JSON gönderilebilir:

```json
{
  "name": "AIHEXA Web Sitesi",
  "type": "URL",
  "content": "https://aihexa.com",
  "description": "AIHEXA web sitesine yönlendiren QR kod",
  "size": 300,
  "foregroundColor": "#000000",
  "backgroundColor": "#FFFFFF",
  "active": true
}
```

Bu veri örneğin:

```text
POST /api/qr-codes
```

endpoint'ine gönderilebilir.

---

# Backend'den Dönecek Başarılı Response

QR kod başarıyla oluşturulduğunda backend aşağıdaki gibi bir response gönderebilir:

```json
{
  "success": true,
  "message": "QR kod başarıyla oluşturuldu.",
  "data": {
    "id": 15,
    "name": "AIHEXA Web Sitesi",
    "type": "URL",
    "content": "https://aihexa.com",
    "qrCodeUrl": "/qr/15.png",
    "active": true
  }
}
```

HTTP durum kodu:

```text
201 Created
```

olabilir.

---

# Backend'den Dönecek Hata Response

Örneğin kullanıcı geçersiz veya eksik veri gönderirse:

```json
{
  "success": false,
  "message": "QR kod oluşturulamadı.",
  "error": "QR kod içeriği zorunludur."
}
```

HTTP durum kodu:

```text
400 Bad Request
```

olabilir.

Sunucu tarafında beklenmeyen bir hata oluşursa:

```json
{
  "success": false,
  "message": "QR kod oluşturulurken bir hata oluştu."
}
```

response'u dönebilir.

---

# Kullanıcıya Gösterilecek Mesajlar

### Başarılı İşlem

```text
QR kod başarıyla oluşturuldu.
```

### Zorunlu Alan Hatası

```text
Lütfen zorunlu alanları doldurunuz.
```

### İçerik Hatası

```text
QR kod içeriği boş bırakılamaz.
```

### URL Hatası

```text
Lütfen geçerli bir URL giriniz.
```

### API Hatası

```text
QR kod oluşturulurken bir hata oluştu. Lütfen tekrar deneyiniz.
```

### Loading Mesajı

```text
QR kod oluşturuluyor...
```

### Silme Başarılı

```text
QR kod başarıyla silindi.
```

---

# Olası Frontend Hataları

QR Kod Oluşturma Modülünde frontend tarafında aşağıdaki hatalar ortaya çıkabilir:

### 1. Zorunlu Alanların Boş Bırakılması

Kullanıcı QR kod adı veya içerik gibi gerekli alanları doldurmadan form göndermeye çalışabilir.

Frontend formu göndermeden önce alanları kontrol etmelidir.

### 2. Geçersiz URL Girilmesi

QR kod tipi URL olarak seçildiğinde kullanıcı yanlış URL girebilir.

Frontend URL formatını kontrol etmelidir.

### 3. Formun Birden Fazla Gönderilmesi

Kullanıcı oluştur butonuna art arda basabilir.

API isteği devam ederken buton pasif hale getirilmelidir.

### 4. Backend'e Bağlanılamaması

Backend sunucusu çalışmıyor olabilir veya internet bağlantısı kesilmiş olabilir.

Kullanıcıya uygun hata mesajı gösterilmelidir.

### 5. Backend Hatası

Backend isteğe `400`, `404`, `500` gibi hata durum kodları döndürebilir.

Frontend bu cevapları kontrol ederek kullanıcıya açıklayıcı mesaj göstermelidir.

### 6. State Güncelleme Hatası

Form alanlarının state değerleri doğru yönetilmezse kullanıcı tarafından girilen bilgiler yanlış veya eksik gönderilebilir.

### 7. Yanlış Veri Tipi Gönderilmesi

Örneğin `size` alanı sayı olması gerekirken metin olarak gönderilebilir.

Frontend veriyi API'ye göndermeden önce uygun veri tipine dönüştürmelidir.

---

# Genel Çalışma Mantığı

QR Kod Oluşturma Modülünün frontend çalışma mantığı özetle şu şekildedir:

```text
Kullanıcı
   ↓
QR Kod Formu
   ↓
Form Alanlarının Kontrolü
   ↓
React State
   ↓
JSON Oluşturma
   ↓
POST /api/qr-codes
   ↓
Backend
   ↓
Response
   ↓
Başarılı → QR Kodu Göster
Hata      → Hata Mesajı Göster
```

React tarafının temel görevi kullanıcıdan bilgileri almak, form kontrollerini gerçekleştirmek, backend API ile iletişim kurmak ve gelen sonuca göre kullanıcı arayüzünü güncellemektir.

---

