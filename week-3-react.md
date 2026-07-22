# React Temelleri ve Frontend Mantığı

## React Nedir?

React, web ve mobil uygulamalarında kullanıcı arayüzü oluşturmak için kullanılan JavaScript kütüphanesidir. Arayüzün küçük ve tekrar kullanılabilir component parçalarına bölünmesini sağlar.

---

## Frontend Nedir?

Frontend, bir uygulamanın kullanıcının gördüğü ve etkileşim kurduğu bölümüdür.

Frontend tarafında genellikle şunlar bulunur:

* Sayfa tasarımı
* Butonlar ve formlar
* Menü ve yönlendirmeler
* Kullanıcıdan veri alma
* Backend'den gelen verileri gösterme
* Hata ve yükleme ekranları

> **Not:** HTML sayfanın yapısını, CSS tasarımını, JavaScript ise işlevlerini oluşturur.

---

## Component Nedir?

Component, kullanıcı arayüzünün bağımsız ve tekrar kullanılabilir parçasıdır. Bir buton, menü, ürün kartı veya tam bir sayfa component olabilir.

React componentleri genellikle JSX döndüren JavaScript fonksiyonlarıdır. Component isimleri büyük harfle başlamalıdır.

```jsx
function Header() {
  return <h1>Web Sitem</h1>;
}
```

---

## JSX Nedir?

JSX, JavaScript dosyasının içerisinde HTML benzeri kod yazmayı sağlayan söz dizimidir. Tam olarak HTML değildir; JavaScript'in genişletilmiş bir yazım biçimidir.

```jsx
const title = <h1>Hoş Geldiniz</h1>;
```

JSX içerisinde JavaScript değerleri `{}` arasına yazılır:

```jsx
const name = "Ersin";

<h1>Merhaba {name}</h1>;
```

---

## Props Nedir?

Props, bir componentten başka bir componente veri göndermek için kullanılır. Genellikle veri üst componentten alt componente aktarılır.

Props dışarıdan gelen bilgilerdir ve component içerisinde doğrudan değiştirilmemelidir. Props olarak metin, sayı, nesne, dizi ve fonksiyon gönderilir.

```jsx
function User({ name }) {
  return <p>Kullanıcı: {name}</p>;
}

<User name="Ersin" />;
```

---

## State Nedir?

State, bir componentin zaman içerisinde değişebilen ve hatırlaması gereken verileridir.

Örneğin:

* Sayaç değeri
* Form alanındaki yazı
* Kullanıcının giriş durumu
* API'den gelen veriler
* Menü açık mı kapalı mı?

State değiştiğinde React componenti yeniden ekrana işler. State, onu tanımlayan componente özeldir.

---

## useState Nedir?

`useState`, component içerisinde state oluşturmak için kullanılan React Hook'udur.

İki değer döndürür:

1. State'in mevcut değeri
2. State'i değiştiren fonksiyon

```jsx
const [count, setCount] = useState(0);
```

Burada:

* `count`: Mevcut değer
* `setCount`: Değeri değiştiren fonksiyon
* `0`: Başlangıç değeri

---

## useEffect Nedir?

`useEffect`, component dışında bulunan sistemlerle bağlantı kurmak veya belirli değişikliklerden sonra işlem yapmak için kullanılan Hook'tur.

Genellikle şu işlemlerde kullanılır:

* API'den veri çekme
* Zamanlayıcı çalıştırma
* Olay dinleyicisi ekleme
* Harici bir sistemle bağlantı kurma
* Component açıldığında işlem yapma

```jsx
useEffect(() => {
  console.log("Component çalıştı.");
}, []);
```

Sondaki bağımlılık dizisi davranışı belirler:

```jsx
useEffect(() => {
  // Her render sonrasında çalışabilir.
});
```

```jsx
useEffect(() => {
  // Component ilk açıldığında çalışır.
}, []);
```

```jsx
useEffect(() => {
  // userId değiştiğinde çalışır.
}, [userId]);
```

---

## React Router Nedir?

React Router, React uygulamalarında sayfalar arasında yönlendirme yapmak için kullanılan kütüphanedir.

URL yollarını componentlerle eşleştirir:

* `/` → Ana sayfa
* `/login` → Giriş sayfası
* `/products` → Ürünler sayfası

Sayfanın tamamını yeniden yüklemeden componentler arasında geçiş yapılmasını sağlar. Routing işlemlerinde `BrowserRouter`, `Routes`, `Route` ve `Link` gibi yapılar kullanılabilir.

---

## Form Yönetimi Nedir?

Form yönetimi, kullanıcının girdiği bilgilerin alınması, kontrol edilmesi ve gönderilmesi işlemlerinin tamamıdır.

Şunları kapsar:

* Input değerlerini state içerisinde tutma
* Zorunlu alanları kontrol etme
* E-posta ve şifre formatlarını doğrulama
* Form gönderimini yönetme
* Hata mesajlarını gösterme
* Verileri API'ye gönderme
* Gönderim sırasında butonu devre dışı bırakma

Tarayıcı tarafındaki doğrulama kullanıcı deneyimini iyileştirir ancak güvenlik açısından veriler backend tarafında da kontrol edilmelidir.

---

## API'den Veri Çekme Nedir?

API'den veri çekme, frontend uygulamasının backend sunucusuna HTTP isteği göndererek veri almasıdır.

JavaScript tarafında genellikle `fetch()` veya Axios kullanılır. `fetch()` isteğin sonucunu bir Promise olarak döndürür. HTTP hata kodlarının kontrol edilmesi gerekir.

```javascript
const response = await fetch("/api/products");

if (!response.ok) {
  throw new Error("Veriler alınamadı.");
}

const data = await response.json();
```

API işlemlerinde genellikle üç ayrı durum tutulur:

```jsx
const [data, setData] = useState([]);
const [loading, setLoading] = useState(true);
const [error, setError] = useState("");
```

---

## localStorage Nedir?

`localStorage`, küçük verileri kullanıcının tarayıcısında saklamayı sağlayan Web Storage özelliğidir.

Sayfa kapatılsa veya tarayıcı yeniden açılsa bile veriler genellikle saklanmaya devam eder. Veriler anahtar-değer biçiminde tutulur.

---

## Kullanıcıya Hata Mesajı Nasıl Gösterilir?

Hata mesajları genellikle state içerisinde tutulur ve bir sorun oluştuğunda ekranda gösterilir.

Hata mesajı açık ve anlaşılır olmalı, kullanıcının ne yapması gerektiğini belirtmelidir.

**Örnek:**

> E-posta alanı boş bırakılamaz.

---

## Loading Durumu Nedir?

Loading durumu, bir işlem devam ederken kullanıcıya beklemesi gerektiğini gösterir.

API'den veri gelirken kullanıcıya:

> Veriler yükleniyor...

mesajı ve yüklenme simgesi gösterilebilir.

---

## Responsive Tasarım Nedir?

Responsive tasarım, bir web sitesinin farklı ekran boyutlarına otomatik olarak uyum sağlamasıdır.

Responsive tasarım için genellikle CSS Media Query, Flexbox ve Grid kullanılır.

---

## Frontend Klasör Yapısı Nasıl Okunur?

React projelerinde klasörler görevlerine göre ayrılır.

```text
src/
├── assets/
├── components/
├── pages/
├── services/
├── styles/
├── App.jsx
└── main.jsx
```

* **`src`:** Projenin temel kaynak kodlarının bulunduğu klasördür.
* **`components`:** Navbar, Button ve Card gibi tekrar kullanılabilir parçaları içerir.
* **`pages`:** Ana sayfa, giriş sayfası ve profil sayfası gibi sayfaları içerir.
* **`services`:** Backend API isteklerinin yazıldığı dosyaları içerir.
* **`assets`:** Resim, logo ve ikon gibi dosyaları içerir.
* **`styles`:** CSS dosyalarını içerir.
* **`App.jsx`:** Uygulamanın ana componentidir.
* **`main.jsx`:** React uygulamasının çalışmaya başladığı giriş dosyasıdır.

## AIHEXA Şirketinde React Nerede Kullanılabilir?

React, AIHEXA şirketinde geliştirilen web uygulamalarının kullanıcı tarafından görülen frontend bölümünde kullanılabilir.

React ile:

* Şirketin internet sitesi hazırlanabilir.
* Yönetici ve kullanıcı panelleri geliştirilebilir.
* Giriş ve kayıt sayfaları oluşturulabilir.
* Formlar ve veri giriş ekranları hazırlanabilir.
* Backend’den gelen veriler ekranda gösterilebilir.
* Yapay zekâ sistemlerinden gelen sonuçlar kullanıcıya sunulabilir.
* Grafik, tablo ve raporlama ekranları oluşturulabilir.
* Mobil cihazlara uyumlu kullanıcı arayüzleri geliştirilebilir.

React’ın component yapısı sayesinde buton, menü, form ve kart gibi bölümler farklı sayfalarda tekrar kullanılabilir. Bu durum projenin daha düzenli, geliştirilebilir ve yönetilebilir olmasını sağlar.


