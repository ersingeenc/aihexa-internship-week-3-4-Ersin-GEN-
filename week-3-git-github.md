# Git Nedir?

Git, yazılım geliştiricilerinin kodlarında yapılan değişiklikleri takip etmelerini sağlayan bir **Versiyon Kontrol Sistemi (Version Control System - VCS)**'dir.

---

## Git Neden Kullanılır?

### Örnek

Bir web sitesi geliştiren yazılımcımız var.

| Gün            | Yapılan İşlem                                                               |
| -------------- | --------------------------------------------------------------------------- |
| **İlk gün**    | Sitenin tasarımı yapıldı.                                                   |
| **İkinci gün** | Sitenin tasarımı değiştirildi ve değişiklikler Git aracılığıyla kaydedildi. |
| **Üçüncü gün** | Tasarımın yine bozuk olduğu fark edildi.                                    |

* Eğer Git kullanılmıyorsa tasarımı eski hâline geri getirmek zor olabilir.
* Ama eğer Git kullanılıyorsa birkaç komutla tasarım eski hâline geri getirilebilir.

---

## Git Nasıl Çalışır?

```text
Working Directory ---> Staging Area ---> Repository
```

| Alan                  | Açıklama                                                                |
| --------------------- | ----------------------------------------------------------------------- |
| **Working Directory** | Kodun yazıldığı klasördür.                                              |
| **Staging Area**      | Git'e “Bu dosyaları kaydetmeye hazırlan.” denilen alandır.              |
| **Repository**        | Kaydetmeye hazırlanmış dosyaların artık kayıt altına alındığı kısımdır. |

---

## Git'in En Büyük Avantajları

1. Geçmişe dönülebilir.
2. Ortak bir geliştirmede kimlerin neler yaptığı görülebilir.
3. Aynı anda birden fazla kişi çalışabilir.

---

## Git'in Temel İş Akışı

```text
Kod yaz
   ↓
git add
   ↓
git commit
   ↓
git push
   ↓
GitHub
```

---

# GitHub Nedir?

GitHub, yazılım geliştiricilerinin Git kullanarak oluşturdukları projeleri internette sakladıkları, yönettikleri ve ister açık isterlerse gizli kaynak olarak paylaşabildikleri bir platformdur.

---

## GitHub Ne İşe Yarar?

### 1. Kodları İnternette Saklamak

Bilgisayarındaki bir projeyi GitHub'a yükleyebilirsin.

**Bilgisayarında:**

```text
Yemek_Kuyruğu/
│
├── backend/
├── frontend/
├── database.sql
└── README.md
```

Bu projeyi GitHub'a gönderdiğinde:

```text
GitHub
│
└── Yemek_Kuyrugu Repository
```

şeklinde internette saklanır.

Böylece:

* Bilgisayar bozulsa bile proje kaybolmaz.
* Her yerden projeye ulaşılabilir.
* Başkaları projeyi inceleyebilir.

---

# Repository Nedir?

GitHub'daki proje klasörlerine **Repository** denir.

Bir repository içerisinde:

* Kaynak kodlar
* Belgeler
* Proje açıklamaları
* Resimler
* Commit geçmişi

bulunabilir.

---

# Commit Nedir?

Commit, yaptığın değişikliklerin açıklamalı bir kaydıdır.

### Örnek Commit Mesajları

```text
Navbar eklendi.
Login sistemi tamamlandı.
CSS düzeltildi.
```

> Her commit, projenin yeni sürümünü oluşturur.

---

# Branch Nedir?

Branch, ana projeyi bozmadan farklı bir kopya üzerinde çalışmanı sağlar.

```text
main
 │
 ├──────────────────────
 │
 └── feature-login
```

Main kısmındaki kodları bozmadan login özelliği geliştirilir.

Her şey düzgün çalışırsa:

```text
feature-login
      │
      │
      ▼
     main
```

Bulunulan branch ile main branch'i birleştirilir.

---

# Pull Request Nedir?

Pull Request, bir geliştiricinin yaptığı kod değişikliklerinin ana projeye eklenmesi için oluşturduğu istektir.

Yani bir geliştirici kendi çalışma alanında, yani branch üzerinde yaptığı değişiklikleri tamamladıktan sonra:

> “Yaptığım değişiklikleri inceleyin ve uygun görürseniz ana projeye dâhil edin.”

demek için Pull Request oluşturur.

---

## Pull Request Ne İşe Yarar?

Pull Request'in temel amacı:

* Kod değişikliklerinin kontrol edilmesini sağlamak
* Hatalı kodların ana projeye girmesini engellemek
* Takım üyelerinin yapılan değişikliklerden haberdar olmasını sağlamak
* Kod kalitesini artırmak

---

## Pull Request Süreci

Genel akış:

```text
Kod değişikliği yapılır
          ↓
Commit oluşturulur
          ↓
Branch GitHub'a gönderilir
          ↓
Pull Request açılır
          ↓
Kod incelenir
          ↓
Onaylanırsa Merge yapılır
```

---

## Pull Request İçerisinde Neler Bulunur?

* Yapılan değişikliklerin açıklaması
* Değişen dosyalar
* Eklenen ve silinen kod satırları
* Kod inceleme yorumları
* Test sonuçları

---

## Pull Request ile Merge Arasındaki Fark

| Pull Request         | Merge                                                                          |
| -------------------- | ------------------------------------------------------------------------------ |
| Bir istektir.        | Bu isteğin kabul edilip değişikliklerin gerçekten ana branch'e aktarılmasıdır. |
| İnceleme aşamasıdır. | Birleştirme işlemidir.                                                         |

```text
Pull Request ---> İnceleme aşaması
Merge ---------> Birleştirme işlemi
```

---

# Merge Conflict Nedir?

Merge Conflict, Git'in iki farklı değişikliği otomatik olarak birleştiremediği durumdur.

---

## Neden Oluşur?

* Aynı dosyanın aynı satırlarının değiştirilmesi
* Bir dosyanın bir branch'te değiştirilip diğerinde silinmesi
* Farklı geliştiricilerin aynı bölge üzerinde çalışması

---

## Çözüm Süreci

1. Conflict olan dosya bulunur.
2. Hangi kodun kalacağına karar verilir.
3. Dosya düzenlenir.
4. Yeni commit oluşturulur.

> **Özet:** Merge conflict, Git'in otomatik karar veremediği kod değişikliklerinde oluşan çakışmadır.

---

# `.gitignore` Nedir?

`.gitignore`, Git tarafından takip edilmesini istemediğimiz dosya ve klasörleri belirtmek için kullanılan dosyadır.

Bazı dosyalar projede bulunur ancak GitHub'a gönderilmemelidir.

### Örnek

* Şifre içeren dosyalar
* Geçici dosyalar
* Derleme dosyaları
* IDE ayarları
* Büyük boyutlu dosyalar

`.gitignore` içerisine yazılan dosyalar Git tarafından takip edilemez.

> **Özet:** `.gitignore`, gereksiz veya gizli dosyaların Git tarafından takip edilmesini engeller.

---

# `README.md` Dosyası Neden Önemlidir?

Bu dosya, bir projenin kılavuzu ve açıklama dosyasıdır. GitHub'a bakıldığında görülen ilk dosyalardan biridir.

README içerisinde genellikle şunlar bulunur:

* Projenin amacı
* Kullanılan teknolojiler
* Kurulum adımları
* Kullanım bilgileri
* Proje özellikleri
* Geliştirici bilgileri

---

## Örnek Bir `README.md` Dosyası

```markdown
# Proje Adı

Online yemek sipariş sistemi.

## Kullanılan Teknolojiler

- Java
- Spring Boot
- PostgreSQL
```

---

## README Dosyasının Önemleri

* Projenin anlaşılmasını kolaylaştırır.
* Takım üyelerine rehber olur.
* Projeyi profesyonel gösterir.

---

# Issue Nedir?

Issue, GitHub üzerinde görev, hata veya geliştirme önerilerini takip etmek için kullanılan sistemdir.

---

## Issue Yararları

* Hatalar bildirilebilir.
* Yapılacak işler oluşturulabilir.
* Özellik önerileri takip edilebilir.
* Proje görevleri organize edilebilir.

---

## Issue İçerisinde Genellikle Bulunanlar

* Başlık
* Açıklama
* Etiketler
* Sorumlu kişi
* Durum bilgisi

---

# Bir Yazılım Ekibinde GitHub Nasıl Kullanılır?

Yazılım ekiplerinde GitHub, kod yönetimi ve ekip çalışması için kullanılır.

---

## Genel Kullanım Süreci

1. Proje GitHub üzerinde oluşturulur.
2. Geliştiriciler projeyi bilgisayarlarına indirir.
3. Her geliştirici kendi branch'inde çalışır.
4. Değişiklikler commit yapılır.
5. Kod GitHub'a gönderilir.
6. Pull Request oluşturulur.
7. Kod incelemesi yapılır.
8. Uygunsa merge edilir.

GitHub ekip içerisinde:

* Kod paylaşımı
* Versiyon kontrolü
* Görev takibi
* Kod inceleme
* Dokümantasyon

için kullanılır.

---

# Commit Mesajı Nasıl Yazılmalıdır?

Commit mesajı, yapılan değişikliğin ne olduğunu açıklayan kısa mesajdır.

---

## İyi Bir Commit Mesajının Özellikleri

* Kısa olmalıdır.
* Ne yapıldığını belirtmelidir.
* Anlaşılır olmalıdır.
* Emir kipinde veya geçmiş zaman şeklinde tutarlı kullanılmalıdır.

---

## İyi Örnekler

```text
Login sistemi eklendi.
Kullanıcı doğrulama hatası düzeltildi.
Navbar tasarımı güncellendi.
```

---

## Kötü Örnekler

```text
Değişiklik yaptım
uptade
son hali
```

---

# Proje Klasör Yapısı Neden Önemlidir?

Proje klasör yapısı, dosyaların düzenli ve anlaşılır şekilde organize edilmesidir.

Düzenli bir yapı:

* Kodun okunabilirliğini artırır.
* Projeye yeni katılan kişilerin anlamasını kolaylaştırır.
* Bakım ve geliştirme işlemlerini hızlandırır.
* Hataları bulmayı kolaylaştırır.

---

## Eğer Bir Proje Düzensiz Yapıdaysa Yaşanacak Sıkıntılar

* Dosya karmaşası olur.
* Kod yönetimi zorlaşır.
* Takım çalışması zorlaşır.

---

# Tüm Bu Bilgiler AIHEXA Şirketinde Nasıl Kullanılabilir?

* Git ve GitHub kullanılarak takım çalışmalarında proje kayıplarının önüne geçilebilir.
* Şirkete ait özel bir GitHub hesabı açılarak pazarlamada ve müşteri ilişkilerinde geçmiş repolar gösterilerek şirketimizin kalitesi gözler önüne serilebilir.
* `.gitignore` ile şirkete ve müşterilere ait özel bilgileri saklı tutarken projeleri herkese açık bir şekilde sergileyebiliriz.
* `README.md` dosyasını hem kılavuz hem de bir markalama işleminden geçirebiliriz. Tüm projelerde AIHEXE firmasına ait olduğunu belli eden özel içerikli bir README dosyası oluşturulabilir.
* Uygun bir proje klasör yapısı belirlenerek şirketteki projelerin daha düzenli bir şekilde gelişmesi sağlanabilir.
