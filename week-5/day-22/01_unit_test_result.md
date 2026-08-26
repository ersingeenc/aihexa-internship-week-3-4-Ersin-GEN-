# Unit Test Seti ve Sonuç Raporu

`src/test/java/com/aihexa/week5/UserServiceTest.java` dosyasında aşağıdaki davranışlar test edilmiştir:

- Geçerli kullanıcı kaydı
- E-postanın normalize edilmesi
- Duplicate e-posta reddi
- Boş/yalnızca boşluk içeren isimlerin reddi
- Geçersiz e-posta formatlarının reddi
- Parameterized test ile birden fazla boundary/invalid değerinin aynı test mantığında çalıştırılması

## Behavior Test ve Implementation Test

Behavior test, sistemin dışarıdan gözlenen sonucunu doğrular. Implementation test ise iç metot çağrıları veya özel uygulama ayrıntılarına fazla bağlanabilir. Bu örnekte testler private metotları veya iç koleksiyon yapısını değil, `register()` metodunun davranışını doğrular.

## Parameterized Test

Aynı davranışı farklı girişlerle doğrulamak gerektiğinde faydalıdır. JUnit 5 `@ParameterizedTest`, `@ValueSource` ve benzeri kaynaklarla aynı testi tekrar çalıştırabilir.

## Test Double Türleri

- Dummy: Sadece parametreyi doldurur.
- Stub: Önceden belirlenmiş cevap döndürür.
- Fake: Basitleştirilmiş çalışan implementasyondur. `InMemoryUserRepository` bu örnekte fake'tir.
- Mock: Beklenen etkileşimleri doğrular.
- Spy: Gerçek nesneyi sarıp etkileşimleri gözlemler.

Kaynak: https://junit.org/junit5/docs/current/user-guide/
