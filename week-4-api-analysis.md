# API ve Backend Temel Kavramları

## 1) API Endpoint Nedir?

API Endpoint, frontend veya başka bir uygulamanın backend ile iletişim kurduğu belirli bir URL adresidir.

Örneğin:

```http
GET /api/users
```

Bu endpoint kullanıcılarını listelemek için kullanılabilir.

Yani endpoint genel olarak:

```text
HTTP Metodu + URL
```

şeklinde düşünülebilir.

---

## 2) Request Nedir?

Request, istemcinin backend'e gönderdiği istektir.

İstemci:

* Web Sitesi
* Mobil uygulama
* Postman
* Başka bir backend

olabilir.

Örneğin kullanıcı giriş yapmak istediğinde fronetnd backend'e şöyle bir istek gönderebilir:

```http
POST /api/login
```

Request içerisinde şunlar bulunabilir:

* HTTP etodu
* Endpoint
* Header
* Body
* Query parameter
* Path parameter

Örneğin:

```http
GET /api/users/10
```

Burada kullanıcı 10 numaralı kullanıcının bilgilerini istemektedir.

---

## 3) Response Nedir?

Response, backend'in gelen request'e verdiği cevaptır.

Örneğin frontend:

```http
GET /api/users/10
```

İsteğini gönderirse backend şöyle cevap verebilir:

```json
{
  "id": 10,
  "name": "Ersin",
  "email": "ersingenc02@gmail.com"
}
```

Response içerisinde genellikle:

* HTTP status code
* Response Body
* Header

bulunur.

Örneğin:

```text
200 0K
```

başarılı bir isteği ifade eder.

---

## 4) JSON Request Body Nedir?

JSON Request Body, istemcinin backend'e gönderdiği verilerin JSON formatında hazırlanmış halidir.

Örneğin yeni kullanıcı oluşuturmak için:

```http
POST /api/users
```

Request body:

```json
{
  "name": "Ersin",
  "email": "ersingenc02@gmail.com"
  "password": "123456"
}
```

Backend bu verileri alır ve işler.

---

## 5) JSON Response Body Nedir?

JSON Response Body, backend'in istemciye JSON formatında gönderdiği veridir.

Örnek:

```json
{
  "id": 15,
  "name": "Ersin",
  "email": "ersingenc02@gmail.com"
}
```

---

## 6) CRUD Nedir?

CRUD, veritabanındaki temel veri işlemlerini ifade eder.

* **C -> Create ->** veri oluşturma
* **R -> Read ->** Veri okuma
* **U -> Update ->** Veri güncelleme
* **D -> Delete ->** Veri silme

REST API'lerde genellikle HTTP metotlarıyla eşleştirilir:

| İşlem  | HTTP Metodu | Endpoint       |
| ------ | ----------- | -------------- |
| Create | POST        | `/api/users`   |
| Read   | GET         | `/api/users`   |
| Update | PUT/PATCH   | `/api/users/5` |
| Delete | DELETE      | `/api/users/5` |

---

## 7) Create, Read, Update, Delete İşlemleri Nelerdir?

### Create

Yeni veri oluşturmak için kullanılır.

Örnek:

```http
POST /api/products
```

Yeni ürün eklemek.

### Read

Mevcut verileri görüntülemek için kullanılır.

Örnek:

```http
GET /api/products
```

Tüm ürünleri getirir.

### Update

Mevcut veriyi değiştirmek için kullanılır.

Örnek:

```http
PUT /api/products/5
```

5 numaralı ürünün adın veya fiyatını güncellemek.

* PUT genellikle kaynağın tamamını güncellemek için, PATCH ise belirli alanları değiştirmek için kullanılır.

### Delete

Mevcut veriyi silmek için kullanılır.

```http
DELETE /api/products/5
```

5 numaralı ürünü siler.

---

## 8) Backend Validasyon Nedir?

Backend Validasyon, kullanıcıdan veya frontend'den gelen verilerin doğru olup olmadığının backend tarafında kontrol edilmesidir.

Örneğin kayıt sırasında:

```json
{
  "name": "",
  "email": "abc",
  "password": "12"
}
```

gibi bir veri gönderildiğini düşünelim.

Backend şunları kontrol edebilir:

* İsim boş mu?
* Email formatı doğru mu?
* Şifre yeterince uzun mu?
* Kullanıcı zaten kayıtlı mı?
* Sayısal değer geçerli mi?

Spring Boot'a örneğin:

```java
@NotBlank 
private String name;

@Email
private String email;

@Size(min = 6)
private String password;
```

---

## 9) Zorunlu Alan Kontrolü Nedir?

Bir işlemin yapılabilmesi için mutlaka gönderilmesi gereken alanların kontrol edilmesidir.

Örneğin kullanıcı oluştururken:

```json
{
  "name": "Ersin",
  "email": "",
  "password": "123456"
}
```

Email zorunluysa backend bu isteği kabul etmemelidir.

Spring Boot'ta:

```java
@NotBlank
private String email;
```

Bazı yaygın validasyon anotasyonları:

* `@NotNull` -> Değer null olamaz
* `@NotBlank` -> String null, boş veya sadece boşluk olamaz
* `@NotEmpty` -> Alan boş olmaz
* `@Email` -> Email formatını kontrol eder
* `@Size` -> Uzunluğu kontrol eder
* `@Min` -> Minimum sayısal değeri kontrol eder
* `@Max` -> Maksimum sayısal değeri kontrol eder

---

## 10) Hata Mesajı Nasıl Tasarlanır?

Hata mesajı kullanıcıya veya frontend geliştiricisine neyin yanlış olduğunu açıkça anlatmalıdır.

Kötü örnek:

```json
{
  "error": "Error"
}
```

Bu mesaj sorunun ne olduğunu açıklamaz.

Daha iyi:

```json
{
  "status": 400,
  "message": "Email alanı boş bırakılamaz."
}
```

---

## 11) Başarılı Response Nasıl Yazılır?

Başarılı bir response işlem sonucunu açık şekilde göstermelidir.

Örneğin kullanıcı oluşturuldu:

```json
{
  "success": true,
  "message": "Kullanıcı başarıyla oluşturuldu.",
  "data": {
    "id": 15,
    "name": "Ersin",
    "email": "ersin@example.com"
  }
}
```

Status code:

```text
201 Created
```

Response:

```json
{
  "success": true,
  "data": {
    "id": 15,
    "name": "Ersin"
  }
}
```

---

## 12) Hatalı Response Nasıl Yazılır?

İşlem başarısız olduğunda uygun HTTP durum koduyla beraber anlaşılır bir hata mesajı gönderilmelidir.

Örneğin kullanıcı bulunamadı:

```text
404 Not Found
```

```json
{
  "success": false,
  "message": "Kullanıcı bulunamadı."
}
```

Geçersiz veri gönderildiğinde:

```text
400 Bad Request
```

```json
{
  "success": false,
  "message": "Gönderilen bilgiler geçersiz."
}
```

Yetkisiz erişimde:

```text
401 Unauthorized
```

```json
{
  "success": false,
  "message": "Bu işlem için giriş yapmanız gerekiyor."
}
```

Yetki yetersiz olduğunda:

```text
403 Forbidden
```

```json
{
  "success": false,
  "message": "Bu işlemi yapmaya yetkiniz bulunmamaktadır."
}
```

Sunucu tarafında beklenmeyen hata oluştuğunda:

```text
500 Internal Server Error
```

```json
{
  "success": false,
  "message": "Sunucu tarafında beklenmeyen bir hata oluştu."
}
```

---

# Genel Akış

```text
Frontend
   |
   | Request
   v
API Endpoint
   |
   v
Controller
   |
   v
Validasyon
   |
   v
Service
   |
   v
Repository
   |
   v
Database
   |
   v
Response
   |
   v
Frontend
```

