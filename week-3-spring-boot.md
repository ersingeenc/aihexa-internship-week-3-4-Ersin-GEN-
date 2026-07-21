# Spring Boot Nedir?

Spring Boot, Java ile özellikle backend ve web uygulamaları geliştirmeyi kolaylaştıran bir framework'tür.

Spring Framework üzerine kuruludur. Spring projelerinde yapılması gereken birçok ayarı otomatik olarak gerçekleştirir.

## Spring Boot'un sağladıkları:

* Web uygulaması geliştirme
* REST API oluşturma
* Veritabanına bağlanma
* Kullanıcı yetkilendirme
* Hata yönetimi
* Bağımlılık yönetimi
* Uygulamayı hızlı şekilde çalıştırma

Spring Boot projelerinde genellikle katmanlı mimari kullanılır:

```text
Controller -> Service -> Repository -> Database
```

---

# Backend Nedir?

Backend, bir uygulamanın kullanıcı tarafından doğrudan görülmeyen, sunucu tarafında çalışan bölümüdür.

## Backend'in görevleri:

* Kullanıcıdan gelen istekleri işlemek
* Veritabanıyla iletişim kurmak
* Verileri kaydetmek, güncellemek ve silmek
* Kullanıcı girişlerini kontrol etmek
* Yetkilendirme yapmak
* İş kurallarını uygulamak
* Frontend'e veri göndermek

## Örnek:

Bir kullanıcı giriş yaptığında backend;

1. E-posta ve şifreyi alır.
2. Kullanıcıyı veritabanında arar.
3. Şifreyi kontrol eder.
4. Sonucu frontend'e gönderir.

---

# REST API Nedir?

REST API, frontend ile backend'in HTTP üzerinden iletişim kurmasını sağlayan bir yapıdır.

Frontend, backend'e bir istek gönderir. Backend isteği işler ve genellikle JSON formatında cevap verir.

## Örnek API adresleri:

```http
GET /api/users
POST /api/users
PUT /api/users
DELETE /api/users
```

> **Not:** REST API sayesinde Web uygulamaları, mobil uygulamalar, Masaüstü uygulamaları aynı backend sistemini kullanabilir.

---

# Controller Nedir?

Controller, backend'e gelen HTTP isteklerini karşılayan katmandır.

## Controller'ın görevleri:

* İstekleri kabul etmek
* URL adreslerini belirlemek
* GET,POST,PUT ve DELETE metotlarını yönetmek
* İstekten gelen verileri almak
* Service katmanını çağırmak
* Kullanıcıya HTTP cevabı döndürmek

## Örnek:

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}
```

> **Not:** Controller içerisinde mümkün olduğunca iş mantığı yazılmamalıdır. İşlemler Service katmanına aktarılmalıdır.

---

# Service Nedir?

Service, uygulamanın iş kurallarının bulunduğu katmandır.

## Service'in görevleri:

* Verileri kontrol etmek
* Hesaplama yapmak
* İş kurallarını uygulamak
* Controller ile Repository arasında bağlantı kurmak
* Hataları yönetmek

## Örnek:

Bir randevu oluşturulurken;

* Tarihin geçmişte olup olmadığı
* Veterinerin müsait olup olmadığı
* Aynı saate başka randevu bulunup bulunmadığı service katmanında kontrol edilir.

```java
@Service 
public class UserService{

	public User saveUser(User user){
		return userRepository.save(user);
	}
}
```

---

# Repository Nedir?

Repository, veritabanı işlemlerini gerçekleştiren katmandır.

## Repository üzerinden:

* Veri kaydedilir.
* Veri aranır.
* Veri güncellenir.
* Veri silinir.
* Tüm veriler listelenir.

---

# Entity Nedir?

Entity, veritabanındaki bir tabloyu temsil eden Java sınıfıdır.

Entity sınıfındaki değişkenler genellikle tablodaki sütunlara karşılık gelir.

```java
@Entity 
@Table(name = "users")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String name;

}
```

## Burada:

| Java Alanı  | Veritabanı Karşılığı |
| ----------- | -------------------- |
| User sınıfı | Users tablosu        |
| id          | id sütunu            |
| name        | name sütunu          |
| email       | email sütunu         |

---

# DTO Nedir?

DTO, Data Transfer Object ifadesinin kısaltmasıdır. Katmanlar veya uygulamalar arasında veri taşımak için kullanılan sınıftır.

Entity sınıfının tamamını frontend'e göndermek yerine sadece gerekli alanlar DTO içerisinde tutulur.

```java
public class UserResponseDto{
	private Long id;
	private String nanme;
	private String email;
}
```

## DTO kullanılmasının nedenleri;

* Gereksiz verilerin gönderilmesini engellemek
* Şifre gibi hassas alanları gizlemek
* Entity ile API yapısını birbirinden ayırmak
* Veri doğrulaması yapmak
* Daha güvenli ve düzenli kod oluşturmak

> **Örnek:** Entity içerisinde şifre bulunsa bile DTO içerisinde şifre alanı bulunmayabilir.

---

# JPA Nedir?

JPA, Java Persistence API ifadesinin kısaltmasıdır.

Java nesneleriyle ilişkisel veritabanı tabloları arasında bağlantı kurmak için kullanılan bir standarttır.

JPA sayesinde SQL sorgularının büyük kısmını doğrudan yazmadan veritabanı işlemleri yapılabilir.

---

# Hibernate Nedir?

Hibernate, JPA standartlarını uygulayan bir ORM aracıdır.

ORM, Object Relational Mapping anlamına gelir. Java nesneleriyle veritabanı tabloları arasında dönüşüm sağlar.

| JPA                 | Hibernate                    |
| ------------------- | ---------------------------- |
| Bir standarttır     | JPA'YI uygulayan araçtır     |
| Kuralları belirler  | Kuralları gerçekleştirir     |
| Tek başına çalışmaz | Veritabanı işlemlerini yapar |

> **Not:**Spring Boot projelerinde JPA kullanıldığında çoğunlukla arka planda Hibernate çalışır.

---

# Maven nedir?

Maven, Java projelerinde kullanılan bir proje ve bağımlılık yönetim aracıdır.

## Maven'in görevleri:

* Kütüphaneleri projeye eklemek
* Projeyi derlemek
* Testleri çalıştırmak
* Projeyi paketlemek
* Standart klasör yapısı oluşturmak
* Kütüphane sürümlerini yönetmek

## Örnek Maven Komutları:

```bash
mvn clean 
mvn compile
mvn test
mvn package
mvn spring-boot:run
```

---

# pom.xml Ne İşe Yarar?

pom.xml, Maven projesinin temel yapılandırma dosyasıdır.

POM, Project Object Model anlamına gelir.

## Bu dosyada:

* Proje adı
* Proje sürümü
* Java sürümü
* Spring Boot sürümü
* Kullanılan bağımlılıklar
* Derleme ayarları
* Maven eklentileri

bulunur.

## Örnek bağımlılık:

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifavtId>
</dependency>
```

Bu bağımlılık projeye web ve REST API geliştirme özelliklerini ekler.

---

# application.properties Nedir?

application.properties, Spring Boot uygulamasının ayarlarının yazıldığı dosyadır.

## Bu dosyada genellikle:

* Veritabanı bağlantısı
* Port numarası
* JPA ayarları
* Loglama ayarları
* Dosya yükleme sınırları
* Güvenlik ayarları

bulunur.

---

# application.yml Nedir?

application.yml, application.properties ile aynı amaçla kullanılan başka bir yapılandırma dosyasıdır.

Fark,ayarların YAML formatında ve hiyerarşik olarak yazılmasıdır.

---

# HTTP Metotları

## GET Metodu

GET: Sunucudan veri almak için kullanılır.

```http
GET /api/users
```

Tüm kullanıcıları getirir.

> **Not:** GET işlemi veritabanındaki verileri değiştirmez.

## POST Metodu

Post, yeni veri oluşturmak için kullanılır.

```http
POST /api/users
```

İstek gövdesi:

```json
{
	"name": "Ersin",
	"email": "ersingenc02@gmail.com"
}
```

Bu istek veritabanına yeni bir kullanıcı ekler.

## PUT Metodu

PUT, mevcut bir veriyi güncellemek için kullanılır.

```http
PUT /api/users/5
```

İstek gövdesi:

```json
{
	"name": "Ersin",
	"email": "ersingenc02@gmail.com"
}
```

## Delete Metodu

DELETE, mevcut bir veriyi silmek için kullanılır.

```http
DELETE /api/users/5
```

ID değeri 5 olan kullanıcı silinir.

---

# HTTP Status Kodları Nedir?

HTTP status kodları, backend'in gelen isteğin sonucunu belirtmek için gönderdiği sayısal cevaplardır.

Kodlar genel olarak şu gruplara ayrılır:

| Kod Grubu | Anlamı                |
| --------- | --------------------- |
| 1xx       | Bilgilendirme         |
| 2xx       | İşlem Başarılı        |
| 3xx       | Yönlendirme           |
| 4xx       | İstemci Kaynaklı Hata |
| 5xx       | Sunucu Kaynaklı Hata  |

## 200 OK

İstek başarıyla tamamlanmıştır.

Genellikle GET ve başarılı güncelleme işlemlerinde görülür.

## 201 Created

Yeni kaynak başarıyla oluşturulmuştur.

Genellikle başarılı POST işlemlerinde kullanılır.

## 400 Bad Request

Backend'e gönderilen isteğin hatalı olduğunu belirtir.

### Nedenleri:

* Zorunlu alanın boş gönderilmesi
* Geçersiz veri formatı
* Hatalı JSON
* Geçersiz tarih
* Yanlış veri tipi
* Validation hatası

## 401 Unauthorized

Kullanıcının kimliğinin doğrulanmadığı belirtir.

### Genellikle:

* Kullanıcı giriş yapmamıştır.
* Token gönderilmemiştir.
* Token geçersizdir.
* Token süresi dolmuştur.
* Kullanıcı adı veya şifre yanlıştır.

Buradai sorun kullanıcının kim olduğunun doğrulanmamasıdır.

## 403 Forbidden

Kullanıcının kimliği doğrulanmıştır ancak işlemi yapma yetkisi yoktur.

### Örnek:

* Normal kullanıcı admin sayfasına erişmeye çalışır.
* Kullanıcı başkasına ait kaydı silmeye çalışır.
* Müşteri yalnızca veterinerin kullanabileceği işlemi çağırır.

## 404 Not Found

İstenen kaynak bulunamadığına kullanılır.

### Nedenleri:

* URL yanlış yazılmıştır.
* İstenen kayıt veritabanında yoktur.
* Controller adresi yanlıştır.
* ID deperine ait veri bulunmamıştır.

## 500 Internal Server Error

Backend içerisinde beklenmeyen bir hata oluştuğunu belirtir.

### Nedenleri

* NullPointerException
* Veritabanı bağlantı hatası
* Kodlama hatası
* Dönüştürme hatası
* Yakalanmamış Exception
* Yanlış yapılandırma
* Sonsuz döngü
* Entity ilişki problemi

> **Not:** 500 hatası çoğunlukla backend kodunun veya sunucu ayarlarının incelenmesini gerektirir.

---

# Backend Hata Mesaj Nasıl Okunur?

Backend hata mesajı okunurken önce şu bilgilere bakılmalıdır:

1. HTTP durum kodu
2. Hata türü
3. Hata mesajı
4. Hatanın oluştuğu sınıf
5. Satır numarası
6. Ana neden

---

# Stack Trace Nedir?

Stack Trace, uygulamada bir hata oluştuğunda:

* Hatanın ne olduğunu,
* Hangi sınıfta oluştuğunu
* Hangi satırda meydana geldiğini
* O satıra hangi metotlardan gelindiğini

gösteren çıktıdır.

Yani stack trace şu soruya cevap verir:

> "Programın hangi işlemleri yaptı ve sonunda nerede hata verdi?"

---

# Stack Trace Backend tarafında nasıl yorumlanır?

## 1)Önce hata türünü bul

Örnek:

```text
java.lang.NullPointerException
```

## 2)Hata mesajını oku

Örnek:

```text
Cannot invoke "User.getname()" because "user" is null
```

## 3)Caused by bölümü bulunur.

Örnek:

```text
Caused by: Connection refused
```

## 4)Kendi proje sınıfın aranır.

Örnek:

```text
com.example.service.UserService
```

## 5)Dosya ve satır numarasına gidilir.

Örnek:

```text
UserService.java:42
```

## 6)Hatanın hangi metottan geldiği takip edilir.

Örnek:

```text
Controller -> Service -> Repository -> Hata
```

---

# Tüm Bu Bilgiler AIHEXA Şirketinde Nasıl Kullanılabilir?

* Spring Boot, yapay zekâ destekli web uygulamalarının ve kurumsal projelerin backend tarafını geliştirmek için kullanılabilir.
* REST API, frontend, mobil uygulama, veritabanı ve yapay zekâ servislerinin birbiriyle iletişim kurmasını sağlar.
* Controller, Service ve Repository katmanları, projelerin düzenli, anlaşılır ve kolay yönetilebilir olmasına yardımcı olur.
* Entity, DTO, JPA ve Hibernate, verilerin güvenli şekilde saklanmasını, taşınmasını ve veritabanı işlemlerinin kolaylaştırılmasını sağlar.
* HTTP metotları ve durum kodları, uygulamalarda yapılan işlemlerin doğru şekilde yönetilmesine yardımcı olur.
* Backend hata mesajları ve stack trace bilgisi, projelerde oluşan hataların daha hızlı bulunmasını ve çözülmesini sağlar.

* 

# Kullanıcı Kayıt Sistemi Akışı

> Kullanıcı kayıt sisteminde veriler React tarafından alınır, Spring Boot tarafından işlenir ve veritabanına kaydedilir.

## Genel Akış

```text
React Form
    ↓
JSON Veri
    ↓
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
    ↓
Response
    ↓
Frontend Mesajı
```

## 1. Kullanıcının Bilgileri Girmesi

Kullanıcı kayıt formuna şu bilgileri girer:

* Ad ve soyad
* E-posta
* Kullanıcı adı
* Şifre

## 2. React Form

React, form alanlarındaki bilgileri `state` içerisinde toplar. Kullanıcı **Kayıt Ol** butonuna bastığında bilgiler bir nesne hâline getirilir.

## 3. JSON Verisi

Bilgiler backend’e `POST` isteğiyle JSON formatında gönderilir.

```json
{
  "name": "Ersin",
  "email": "ersin@example.com",
  "password": "123456"
}
```

## 4. Controller

Controller, React tarafından gönderilen isteği karşılar ve gelen verileri Service katmanına aktarır.

## 5. Service

Service, kullanıcı bilgilerini kontrol eder:

* Alanlar boş mu?
* E-posta daha önce kullanılmış mı?
* Şifre uygun mu?
* Bilgiler doğru formatta mı?

Kontroller başarılıysa kullanıcı Repository katmanına gönderilir.

## 6. Repository

Repository, uygulama ile veritabanı arasındaki bağlantıyı sağlar ve kullanıcı bilgilerini kaydeder.

```java
userRepository.save(user);
```

## 7. Database

Veritabanına şu bilgiler kaydedilir:

| Bilgi         | Açıklama                         |
| ------------- | -------------------------------- |
| ID            | Kullanıcıya ait benzersiz numara |
| Ad            | Kullanıcının adı                 |
| E-posta       | Kullanıcının e-posta adresi      |
| Kullanıcı adı | Sisteme giriş için kullanılır    |
| Şifre         | Şifrelenmiş olarak saklanır      |

> **Önemli:** Kullanıcı şifresi veritabanında açık şekilde saklanmamalıdır.

## 8. Başarılı Response

Kayıt başarılı olursa backend genellikle `201 Created` durum kodunu gönderir.

Frontend kullanıcıya şu mesajı gösterir:

```text
Kayıt işlemi başarıyla tamamlandı.
```

## 9. Hatalı Response

Bir sorun oluşursa backend uygun hata kodunu ve mesajını gönderir.

Örneğin e-posta daha önce kullanılmışsa:

```text
Bu e-posta adresi zaten kullanılıyor.
```

Beklenmeyen bir sunucu hatasında ise:

```text
Kayıt sırasında bir hata oluştu. Lütfen tekrar deneyiniz.
```


