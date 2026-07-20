# aihexa-internship-week-3-4-Ersin-GENÇ

# AIHEXA Staj Çalışması — 3. ve 4. Hafta

Bu repository, **AIHEXA 2026 Yaz Stajı** kapsamında yürütülen 3. ve 4. hafta çalışmalarını içermektedir.  
Çalışmanın temel amacı; modern bir web projesini yalnızca kod açısından değil, **frontend, backend, veritabanı, API, GitHub, WordPress, SEO, sosyal medya, kullanıcı deneyimi ve raporlama** yönleriyle birlikte değerlendirmektir.

---

## Öğrenci Bilgileri

| Bilgi | Açıklama |
|---|---|
| **Öğrenci Adı Soyadı** | Ersin Genç |
| **Staj Dönemi** | 2026 Yaz Stajı |
| **Çalışma Haftaları** | 3. ve 4. Hafta |
| **Kurum** | AIHEXA |
| **Repository Adı** | `aihexa-internship-week-3-4-ersin-genc` |

---

## Çalışmanın Amacı

Bu iki haftalık çalışma sürecinde aşağıdaki konuların birbiriyle ilişkili şekilde öğrenilmesi amaçlanmaktadır:

- Git ve GitHub kullanımı
- Düzenli repository ve dosya yapısı oluşturma
- Profesyonel `README.md` hazırlama
- Spring Boot ile backend mantığını anlama
- React ile frontend mantığını anlama
- Frontend, backend ve database ayrımını kavrama
- REST API ve JSON veri akışını öğrenme
- WordPress ile özel yazılım arasındaki farkları değerlendirme
- SEO’nun web projelerindeki önemini anlama
- Kurumsal sosyal medya kullanımını analiz etme
- AIHEXA için geliştirilebilecek modülleri planlama
- Bir mini modülün frontend, backend ve database ihtiyaçlarını belirleme
- Teknik çalışmaların raporlanması ve sunulması

---

## Kullanılacak Teknolojiler ve Araçlar

| Teknoloji / Araç | Kullanım Amacı |
|---|---|
| **Git** | Dosya değişikliklerini ve proje geçmişini takip etmek |
| **GitHub** | Projeyi uzakta saklamak, paylaşmak ve sürüm kontrolü sağlamak |
| **Markdown** | Araştırma, rapor ve dokümantasyon dosyalarını hazırlamak |
| **Java** | Backend geliştirme dili |
| **Spring Boot** | REST API ve backend servisleri geliştirmek |
| **Maven** | Spring Boot bağımlılıklarını ve proje yapısını yönetmek |
| **React** | Kullanıcı arayüzü ve form ekranları geliştirmek |
| **JavaScript** | Frontend tarafındaki işlemleri yönetmek |
| **JSON** | Frontend ile backend arasında veri taşımak |
| **REST API** | Frontend ve backend arasında iletişim kurmak |
| **PostgreSQL** | Uygulama verilerini saklamak |
| **WordPress** | Tanıtım sayfası, blog ve içerik yönetimi oluşturmak |
| **SEO** | Web içeriklerinin arama motorlarında görünürlüğünü artırmak |
| **Sosyal Medya** | Marka bilinirliği, tanıtım ve hedef kitle iletişimi sağlamak |

---

## Modern Web Projesinin Genel Yapısı

```text
Kullanıcı
   │
   ▼
React Frontend
   │
   │ JSON Request
   ▼
Spring Boot REST API
   │
   ▼
Service Katmanı
   │
   ▼
Repository Katmanı
   │
   ▼
PostgreSQL Database
   │
   │ JSON Response
   ▼
React Frontend
   │
   ▼
Başarı veya Hata Mesajı
```

Bir web projesi yalnızca frontend veya backend kodundan oluşmaz. Projenin teknik yapısına ek olarak GitHub düzeni, hata yönetimi, içerik planı, SEO görünürlüğü, sosyal medya iletişimi ve kullanıcı deneyimi de birlikte düşünülmelidir.

---

## Öğrenilecek Ana Konular

### 3. Hafta — Kavramsal Temeller

- Git, GitHub ve repository kavramları
- Commit, branch, pull request ve merge conflict
- `.gitignore`, issue ve README kullanımı
- Spring Boot ve backend mimarisi
- Controller, Service, Repository, Entity ve DTO katmanları
- REST API, HTTP metotları ve status kodları
- React, component, JSX, props ve state
- `useState`, `useEffect`, React Router ve form yönetimi
- WordPress temel yapısı
- Sosyal medya ve kurumsal kullanım amaçları
- SEO, anahtar kelime ve içerik görünürlüğü
- AIHEXA modüllerinin teknik analizi

### 4. Hafta — Uygulama Hazırlığı

- AIHEXA için mini modül seçimi
- Proje planı hazırlama
- Frontend ekranlarını belirleme
- Backend API ihtiyaçlarını çıkarma
- Database alanlarını ve tablolarını planlama
- React form akışını analiz etme
- Request ve response örnekleri hazırlama
- Validasyon ve hata senaryolarını belirleme
- WordPress tanıtım sayfası planlama
- SEO başlığı, URL ve meta açıklama hazırlama
- Bir haftalık sosyal medya içerik takvimi oluşturma
- Final raporu ve sunumu hazırlama

---

## Planlanan Mini Modül

### Eğitim Başvuru Modülü

Bu repository kapsamında örnek mini modül olarak **Eğitim Başvuru Modülü** ele alınacaktır.

#### Modülün Amacı

AIHEXA eğitimlerine katılmak isteyen öğrencilerin veya profesyonellerin çevrim içi başvuru yapmasını sağlamak.

#### Kullanıcı İşlemleri

- Eğitimleri görüntüleme
- Başvuru formunu doldurma
- Eğitim seviyesi seçme
- Açıklama ekleme
- KVKK onayı verme
- Başvuruyu gönderme
- Başvuru sonucunu görüntüleme

#### Admin İşlemleri

- Başvuruları listeleme
- Başvuru detaylarını görüntüleme
- Başvuru durumunu güncelleme
- Başvuruyu onaylama veya reddetme
- Başvuru sahibinin iletişim bilgilerine erişme
- Gerekli durumlarda başvuruyu silme

#### Örnek Veri Alanları

| Alan | Açıklama |
|---|---|
| `firstName` | Başvuru sahibinin adı |
| `lastName` | Başvuru sahibinin soyadı |
| `email` | E-posta adresi |
| `phone` | Telefon numarası |
| `educationName` | Başvurulan eğitim |
| `level` | Eğitim seviyesi |
| `description` | Kullanıcının açıklaması |
| `kvkkApproved` | KVKK onay bilgisi |
| `status` | Başvuru durumu |
| `createdAt` | Başvurunun oluşturulma tarihi |

---

## Örnek Kullanıcı Başvuru Akışı

1. Kullanıcı eğitim başvuru sayfasını açar.
2. React formundaki gerekli alanları doldurur.
3. KVKK onay kutusunu işaretler.
4. Başvuruyu gönder butonuna basar.
5. React, form verilerini JSON formatına dönüştürür.
6. JSON verisi Spring Boot API’ye gönderilir.
7. Controller gelen isteği karşılar.
8. Service katmanı iş kurallarını ve doğrulamaları kontrol eder.
9. Repository katmanı veriyi PostgreSQL veritabanına kaydeder.
10. Backend başarılı veya hatalı bir response döndürür.
11. React, kullanıcıya uygun başarı veya hata mesajını gösterir.

### Örnek JSON Request

```json
{
  "firstName": "Ersin",
  "lastName": "Genç",
  "email": "ersin@example.com",
  "phone": "05xx xxx xx xx",
  "educationName": "Java Full Stack Eğitimi",
  "level": "Başlangıç",
  "description": "Eğitim hakkında ayrıntılı bilgi almak istiyorum.",
  "kvkkApproved": true
}
```

### Örnek Başarılı Response

```json
{
  "success": true,
  "message": "Eğitim başvurusu başarıyla oluşturuldu.",
  "status": 201
}
```

### Örnek Hatalı Response

```json
{
  "success": false,
  "message": "E-posta adresi geçerli formatta olmalıdır.",
  "status": 400
}
```

---

## Repository Dosya Yapısı

```text
aihexa-internship-week-3-4-ersin-genc/
│
├── README.md
│
├── week-3-git-github.md
├── week-3-spring-boot.md
├── week-3-react.md
├── week-3-wordpress.md
├── week-3-social-media.md
├── week-3-seo.md
├── week-3-aihexa-module-analysis.md
├── week-3-weekly-report.md
│
├── week-4-project-plan.md
├── week-4-api-analysis.md
├── week-4-react-form-analysis.md
├── week-4-wordpress-seo-analysis.md
├── week-4-social-media-calendar.md
└── week-4-final-report.md
```

---

## Çalışma Dosyaları

### 3. Hafta Teslimleri

| Dosya | İçerik | Durum |
|---|---|---|
| [`week-3-git-github.md`](week-3-git-github.md) | Git, GitHub, README ve proje dosya disiplini | ⬜ Planlandı |
| [`week-3-spring-boot.md`](week-3-spring-boot.md) | Spring Boot, backend, REST API ve kullanıcı kayıt akışı | ⬜ Planlandı |
| [`week-3-react.md`](week-3-react.md) | React, component, state, form ve JSON yapısı | ⬜ Planlandı |
| [`week-3-wordpress.md`](week-3-wordpress.md) | WordPress ve özel yazılım karşılaştırması | ⬜ Planlandı |
| [`week-3-social-media.md`](week-3-social-media.md) | Sosyal medya ve kurumsal kullanım amaçları | ⬜ Planlandı |
| [`week-3-seo.md`](week-3-seo.md) | SEO temelleri ve blog başlıkları | ⬜ Planlandı |
| [`week-3-aihexa-module-analysis.md`](week-3-aihexa-module-analysis.md) | AIHEXA için en az beş modülün analizi | ⬜ Planlandı |
| [`week-3-weekly-report.md`](week-3-weekly-report.md) | Üçüncü hafta değerlendirme raporu | ⬜ Planlandı |

### 4. Hafta Teslimleri

| Dosya | İçerik | Durum |
|---|---|---|
| [`week-4-project-plan.md`](week-4-project-plan.md) | Seçilen mini modülün proje planı | ⬜ Planlandı |
| [`week-4-api-analysis.md`](week-4-api-analysis.md) | Endpoint, request, response ve validasyon analizi | ⬜ Planlandı |
| [`week-4-react-form-analysis.md`](week-4-react-form-analysis.md) | React formu ve frontend ekran analizi | ⬜ Planlandı |
| [`week-4-wordpress-seo-analysis.md`](week-4-wordpress-seo-analysis.md) | WordPress tanıtımı ve SEO planı | ⬜ Planlandı |
| [`week-4-social-media-calendar.md`](week-4-social-media-calendar.md) | Bir haftalık sosyal medya içerik takvimi | ⬜ Planlandı |
| [`week-4-final-report.md`](week-4-final-report.md) | Dördüncü hafta ve genel süreç değerlendirmesi | ⬜ Planlandı |

> Çalışmalar tamamlandıkça durum alanları `✅ Tamamlandı` şeklinde güncellenecektir.

---

## Günlük İlerleme Tablosu

| Gün | Çalışma Konusu | Oluşturulacak Dosya | Durum |
|---|---|---|---|
| 3. Hafta Pazartesi | Git, GitHub, README ve dosya disiplini | `week-3-git-github.md` | ⬜ |
| 3. Hafta Salı | Spring Boot ve backend mantığı | `week-3-spring-boot.md` | ⬜ |
| 3. Hafta Çarşamba | React ve frontend mantığı | `week-3-react.md` | ⬜ |
| 3. Hafta Perşembe | WordPress, sosyal medya ve SEO | Üç ayrı araştırma dosyası | ⬜ |
| 3. Hafta Cuma | AIHEXA modül analizi ve haftalık rapor | İki ayrı rapor dosyası | ⬜ |
| 4. Hafta Pazartesi | Mini modül seçimi ve proje planı | `week-4-project-plan.md` | ⬜ |
| 4. Hafta Salı | API analizi ve backend iş akışı | `week-4-api-analysis.md` | ⬜ |
| 4. Hafta Çarşamba | React formu ve frontend ekranları | `week-4-react-form-analysis.md` | ⬜ |
| 4. Hafta Perşembe | WordPress, SEO ve sosyal medya entegrasyonu | `week-4-wordpress-seo-analysis.md` | ⬜ |
| 4. Hafta Cuma | Sosyal medya takvimi, final raporu ve sunum | İki ayrı teslim dosyası | ⬜ |

---

## Günlük Rapor Düzeni

Her çalışma gününün sonunda aşağıdaki sorular cevaplanacaktır:

1. Bugün ne öğrendim?
2. En çok zorlandığım konu neydi?
3. GitHub üzerinde ne oluşturdum veya güncelledim?
4. AIHEXA projesiyle nasıl bir bağlantı kurdum?
5. Bir sonraki gün hangi konuya çalışacağım?

---

## Örnek API Endpointleri

| HTTP Metodu | Endpoint | Açıklama |
|---|---|---|
| `POST` | `/api/education-applications` | Yeni eğitim başvurusu oluşturur |
| `GET` | `/api/education-applications` | Tüm başvuruları listeler |
| `GET` | `/api/education-applications/{id}` | Belirli bir başvurunun detayını getirir |
| `PUT` | `/api/education-applications/{id}/status` | Başvurunun durumunu günceller |
| `DELETE` | `/api/education-applications/{id}` | Başvuruyu siler |

### Temel Validasyon Kuralları

- Ad ve soyad boş bırakılamaz.
- E-posta geçerli formatta olmalıdır.
- Telefon alanı boş bırakılamaz.
- Eğitim seçimi yapılmalıdır.
- KVKK onayı verilmeden başvuru gönderilemez.
- Geçersiz veriler için anlaşılır hata mesajları döndürülmelidir.

---

## HTTP Status Kodları

| Kod | Anlamı | Kullanım Örneği |
|---|---|---|
| `200 OK` | İşlem başarılı | Listeleme veya güncelleme işlemi |
| `201 Created` | Yeni kayıt oluşturuldu | Yeni eğitim başvurusu |
| `400 Bad Request` | Gönderilen veri hatalı | Eksik veya geçersiz form alanı |
| `401 Unauthorized` | Kimlik doğrulama gerekli | Giriş yapılmadan korumalı alana erişim |
| `403 Forbidden` | Erişim yetkisi yok | Kullanıcının admin işlemine erişmesi |
| `404 Not Found` | Kayıt bulunamadı | Geçersiz başvuru ID’si |
| `500 Internal Server Error` | Sunucu tarafında hata oluştu | Beklenmeyen backend hatası |

---

## WordPress, SEO ve Sosyal Medya Bağlantısı

Eğitim Başvuru Modülü yalnızca teknik bir formdan oluşmaz. Modülün hedef kitleye ulaşabilmesi için aşağıdaki destekleyici çalışmalar da planlanacaktır:

### WordPress

- Eğitim tanıtım sayfası
- Eğitim detayları
- Sık sorulan sorular
- Başvuru formuna yönlendiren CTA alanı
- Blog içerikleri

### SEO

- SEO uyumlu sayfa başlığı
- Açıklayıcı ve okunabilir URL
- Meta açıklama
- Hedef anahtar kelimeler
- Mobil uyumluluk
- Görsel optimizasyonu ve `alt` metinleri
- İç linkleme

### Sosyal Medya

- LinkedIn bilgilendirici gönderileri
- Instagram Reels içerikleri
- Story soru-cevap içerikleri
- Carousel eğitim içerikleri
- Başvuru duyuruları
- Web sitesine yönlendiren CTA metinleri

---

## Örnek SEO Planı

| Alan | Öneri |
|---|---|
| **Sayfa Başlığı** | AIHEXA Java Full Stack Eğitim Başvuru Sistemi |
| **SEO URL** | `/java-full-stack-egitim-basvuru` |
| **Hedef Anahtar Kelime** | Java Full Stack eğitimi |
| **İkincil Anahtar Kelimeler** | Spring Boot eğitimi, React eğitimi, yazılım eğitimi |
| **Meta Açıklama** | AIHEXA Java Full Stack eğitimi için online başvuru yapın ve proje tabanlı yazılım geliştirme süreci hakkında bilgi alın. |
| **CTA** | Eğitime başvurmak için formu doldurun. |

---

## Git ve GitHub Çalışma Disiplini

Repository üzerinde düzenli çalışmak için aşağıdaki kurallara dikkat edilecektir:

- Dosya adları açık ve tutarlı olacaktır.
- Türkçe ve İngilizce dosya adları karışık kullanılmayacaktır.
- Her konu ayrı Markdown dosyasında tutulacaktır.
- Yapılan her anlamlı değişiklik için commit oluşturulacaktır.
- Commit mesajları yapılan işlemi açık şekilde anlatacaktır.
- Gereksiz dosyalar `.gitignore` içerisine eklenecektir.
- Repository yapısı düzenli tutulacaktır.
- Araştırmalar kopyala-yapıştır yerine kişisel anlatımla hazırlanacaktır.
- Gerekli yerlerde tablo, şema, örnek ve ekran görüntüsü kullanılacaktır.

### Örnek Commit Mesajları

```bash
git commit -m "docs: Git ve GitHub araştırması eklendi"
git commit -m "docs: Spring Boot kullanıcı kayıt akışı hazırlandı"
git commit -m "docs: React form analizi güncellendi"
git commit -m "docs: SEO blog başlıkları eklendi"
git commit -m "docs: Dördüncü hafta final raporu tamamlandı"
```

---




