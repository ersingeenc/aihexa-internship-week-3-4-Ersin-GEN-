# 4. Hafta Final Raporu

## 4. Hafta Boyunca Ne Öğrendim?

Bu hafta bir yazılım modülünü sadece kod tarafıyla değil, **frontend, backend, database, WordPress, SEO ve sosyal medya** yönleriyle birlikte değerlendirmeyi öğrendim.

React tarafında form yapısı, input, select, checkbox, textarea, zorunlu alan kontrolü, loading, başarılı ve hata mesajları ile API’ye veri gönderme mantığını araştırdım.

Backend tarafında API endpoint, request, response ve frontend ile backend arasındaki veri alışverişini inceledim. Ayrıca geliştirilen bir modülün WordPress üzerinde nasıl tanıtılabileceğini, SEO uyumlu içerik hazırlanmasını ve sosyal medya üzerinden hedef kitleye nasıl duyurulabileceğini öğrendim.

---

## Seçtiğim Modül Nedir?

Seçtiğim modül **AIHEXA QR Kod Oluşturma Modülü**dür.

---

## Bu Modül Ne İşe Yarar?

Bu modül, kullanıcının bir bağlantı veya metin girerek hızlı şekilde QR kod oluşturmasını sağlar.

Oluşturulan QR kod kullanıcı tarafından görüntülenebilir ve indirilebilir. Böylece web sitesi bağlantıları, eğitim içerikleri, sosyal medya hesapları veya farklı dijital içerikler kolay şekilde paylaşılabilir.

---

## Frontend Tarafında Hangi Ekranları Düşündüm?

Frontend tarafında aşağıdaki ekranları düşündüm:

- QR kod oluşturma formu
- QR kod önizleme ve sonuç ekranı
- Oluşturulan QR kodları listeleme ekranı
- QR kod detay ekranı
- Gerekirse admin için yönetim ekranı

Form içerisinde QR kod oluşturulacak içerik girilir ve oluşturma butonuna basıldığında veri backend’e gönderilir.

---

## Backend Tarafında Hangi API’leri Düşündüm?

Modül için temel olarak aşağıdaki API endpointlerini düşündüm:

- `POST /api/qr-codes` → Yeni QR kod oluşturma
- `GET /api/qr-codes` → Oluşturulan QR kodları listeleme
- `GET /api/qr-codes/{id}` → Belirli bir QR kodun bilgilerini getirme
- `DELETE /api/qr-codes/{id}` → QR kod kaydını silme

Backend, frontend’den gelen veriyi kontrol eder, QR kod oluşturma işlemini gerçekleştirir ve sonucu frontend’e döndürür.

---

## Database Tarafında Hangi Tabloları Düşündüm?

Database tarafında temel olarak şu tablolar düşünülebilir:

### `users`

Kullanıcı bilgilerini tutar.

Örnek alanlar:

- `id`
- `name`
- `email`
- `role`

### `qr_codes`

Oluşturulan QR kod bilgilerini tutar.

Örnek alanlar:

- `id`
- `user_id`
- `content`
- `image_path`
- `created_at`

Bu yapı sayesinde hangi kullanıcının hangi QR kodu oluşturduğu kayıt altında tutulabilir.

---

## WordPress Tarafında Bu Modül Nasıl Tanıtılır?

AIHEXA WordPress sitesinde QR Kod Oluşturma Modülü için özel bir **landing page** hazırlanabilir.

Sayfada:

- Modülün amacı
- Kullanım alanları
- Sağladığı avantajlar
- Örnek QR kod görselleri
- Modülün nasıl çalıştığını anlatan kısa açıklamalar
- Kullanıcıyı harekete geçiren CTA butonları

yer alabilir.

Ayrıca QR kodların kullanım alanları hakkında blog yazıları hazırlanarak modülün daha fazla kullanıcıya ulaşması sağlanabilir.

---

## SEO Tarafında Hangi Anahtar Kelimeler Kullanılabilir?

Modül için kullanılabilecek bazı anahtar kelimeler:

- QR kod oluşturma
- QR kod oluşturucu
- ücretsiz QR kod
- online QR kod oluşturma
- QR code generator
- bağlantıdan QR kod oluşturma
- dijital QR kod
- AIHEXA QR kod

Başlık ve meta açıklamalarda anahtar kelimeler doğal şekilde kullanılmalıdır.

---

## Sosyal Medya Tarafında Bu Modül Nasıl Duyurulur?

Modül LinkedIn ve Instagram üzerinden farklı içerik türleriyle tanıtılabilir.

LinkedIn üzerinde modülün teknik yapısı, kullanım amacı ve işletmelere sağlayacağı faydalar anlatılabilir.

Instagram üzerinde ise Reels, Story ve Carousel içerikleri hazırlanarak QR kod oluşturma süreci kısa ve görsel şekilde gösterilebilir.

Paylaşımlarda **“QR kodunuzu oluşturun”, “AIHEXA’yı takip edin” veya “Detaylı bilgi için bizimle iletişime geçin”** gibi CTA metinleri kullanılabilir.

---

## Bu İki Haftalık Süreçte En Çok Zorlandığım Konu Neydi?

Bu süreçte en çok zorlandığım konu, bir yazılım modülünün **frontend, backend ve database taraflarının birbirleriyle nasıl bağlantılı çalışacağını birlikte düşünmek** oldu.

Özellikle formdan gönderilen verinin API üzerinden backend’e ulaşması, backend tarafından işlenmesi ve gerekli bilgilerin database içerisinde saklanması başlangıçta daha dikkatli düşünmem gereken bir konuydu.

Yaptığım araştırmalar sayesinde bu yapıların birbirini tamamlayan parçalar olduğunu daha iyi anladım.

---

## AIHEXA Projesine Hangi Konuda Katkı Sağlayabilirim?

AIHEXA projesine özellikle **backend geliştirme, API tasarımı ve database işlemleri** konusunda katkı sağlayabilirim.

Spring Boot kullanarak API geliştirme, gelen verileri işleme ve PostgreSQL gibi veritabanlarıyla çalışma konularında kendimi geliştirmeye devam ediyorum.

Ayrıca geliştirdiğim modüllerin frontend, SEO ve sosyal medya taraflarını da düşünerek projenin yalnızca teknik kısmına değil, kullanıcıya ulaşma sürecine de katkı sağlayabilirim.
