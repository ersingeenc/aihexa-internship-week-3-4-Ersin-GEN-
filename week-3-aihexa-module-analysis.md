# Modül Nedir?

Modül, bir yazılım sistemi içerisinde belirli bir görevi yerine getiren bağımsız bölümdür. Her modül farklı bir işlevden sorumludur ve gerektiğinde diğer modüllerle birlikte çalışabilir.

---

# 1) Kullanıcı Yönetim Modülü

## Ne işe Yarar?

* Kullanıcıların kayıt olmasını, giriş yapmasını, profil ve yetki bilgilerinin yönetilmesini sağlar.

## Kim Kullanır?

* Öğrenciler, eğitmenler, yöneticiler ve sistem kullanıcıları.

## Frontend Tarafında Hangi Ekranlar Olur?

* Giriş, kayıt, şifre yenileme, profil ve kullanıcı yönetim ekranları.

## Backend Tarafında Hangi API'ler gerekir?

* Kullanıcı kaydetme
* Giriş yapma
* Kullanıcı listeleme
* Kullanıcı güncelleme
* Kullanıcı silme

## Database Tarafında Hangi Tablolar Olabilir?

* `users`
* `roles`
* `user_roles`

## Bu Modülde Hangi Hatalar Çıkabilir?

* Yanlış şifre, aynı e-posta ile kayıt, eksik bilgi ve yetkisiz erişim.

## Bu Modül Sosyal Medya, SEO veya eğitim tarafına nasıl katkı sağlar?

* Kullanıcılara özel eğitim ve içerik önerileri sunulmasını sağlar.

---

# 2) Eğitim Modülü

## Ne İşe Yarar?

* Eğitim içeriklerinin oluşturulmasını ve kullanıcıların bu içeriklere ulaşmasını sağlar.

## Kim Kullanır?

* Öğrenciler, eğitmenler ve yöneticiler

## Frontend Tarafında Hangi Ekranlar Olur?

* Eğitim listesi, eğitim detayı, video ve doküman görüntüleme ekranları.

## Backend Tarafında Hangi API'ler gerekir?

* Eğitim listeleme
* Eğitim ekleme
* Eğitim güncelleme
* Eğitim silme
* Eğitim ilerlemesini görüntüleme

## Database Tarafında Hangi Tablolar Olabilir?

* `trainings`
* `training_contents`
* `trainind_progress`

## Bu Modülde Hangi Hatalar Çıkabilir?

Video açılmaması, dosya yüklenememesi ve yetkisiz erişim.

## Bu Modül Sosyal Medya, SEO veya eğitim tarafına nasıl katkı sağlar?

* Eğitim içeriklerinin sosyal medyada ve arama motorlarında tanıtılmasını sağlar.

---

# 3) Kurs Modülü

## Ne İşe Yarar?

* Kursların oluşturulmasını, öğrencilerin kurslara katılmasını ve ilerlemelerini takip edilmesini sağlar.

## Kim Kullanır?

* Öğrenciler, eğitmenler ve kurs yöneticileri.

## Frontend Tarafında Hangi Ekranlar Olur?

* Kurs listesi, kurs detayı, kurs kayıt ve ders görüntüleme ekranları.

## Backend Tarafında Hangi API'ler gerekir?

* Kurs listeleme
* Kurs oluşturma
* Kursa kayıt olma
* Ders ekleme
* Kurs ilerlemesini görüntüleme

## Database Tarafında Hangi Tablolar Olabilir?

* `courses`
* `course_lessons`
* `course_enrollments`

## Bu Modülde Hangi Hatalar Çıkabilir?

* Aynı kursa tekrar kayıt, kontenjan dolması ve derslerin açılmaması.

## Bu Modül Sosyal Medya, SEO veya eğitim tarafına nasıl katkı sağlar?

* Kursların sosyal medya ve SEO çalışmalarıyla daha fazla kişiye ulaşmasını sağlar.

---

# 4) Blog Modülü

## Ne İşe Yarar?

* Bilgilendirici yazıların oluşturulmasını, düzenlenmesini ve yayımlanmasını sağlar.

## Kim Kullanır?

* Yazarlar, editörler, yöneticiler ve ziyaretçiler.

## Frontend Tarafında Hangi Ekranlar Olur?

* Blog listesi, blog detay, arama ve blog oluşturma ekranları

## Backend Tarafında Hangi API'ler gerekir?

* Blog listeleme
* Blog ekleme
* Blog güncelleme
* Blog silme
* Yorum ekleme

## Database Tarafında Hangi Tablolar Olabilir?

* `blogs`
* `blog_categorşes`
* `blog_comments`

## Bu Modülde Hangi Hatalar Çıkabilir?

* Eksik içerik, görsel yükleme hatası ve yetkisiz paylaşım.

## Bu Modül Sosyal Medya, SEO veya eğitim tarafına nasıl katkı sağlar?

* SEO görünürlüğünü artırır ve sosyal medya için paylaşılabilir içerikler oluşturur.

---

# 5) Randevu Modülü

## Ne İşe Yarar?

* Kullanıcıların uygun tarih ve saatlere randevu oluşturmasını sağlar.

## Kim Kullanır?

* Öğrenciler, eğitmenler, danışmanlar ve yöneticiler.

## Frontend Tarafında Hangi Ekranlar Olur?

* Randevu oluşturma, takvim, randevu listeleme ve iptal ekranları.

## Backend Tarafında Hangi API'ler gerekir?

* Randevu oluşturma
* Randevu listeleme
* Randevu güncelleme
* Randevu iptal etme
* Uygun saatleri görüntüleme

## Database Tarafında Hangi Tablolar Olabilir?

* `appointments`
* `available_times`
* `appointment_statuses`

## Bu Modülde Hangi Hatalar Çıkabilir?

* Aynı saate iki ranevu verilmesi, geçmiş tarihe randevu alınması ve eksik bilgi girilmesi.

## Bu Modül Sosyal Medya, SEO veya eğitim tarafına nasıl katkı sağlar?

* Eğitim görüşmelerinin ve danışmanlık hizmetlerinin düzenli şekilde planlanmasını sağlar.

