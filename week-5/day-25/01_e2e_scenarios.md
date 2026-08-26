# E2E / Tekrarlanabilir Kritik Akış Senaryoları

## Senaryo 1 - Başarılı kullanıcı kaydı

**Ön koşul:** Uygulama ve veritabanı çalışıyor.

1. Kayıt ekranını aç.
2. İsim alanına `Ada Lovelace` yaz.
3. E-posta alanına benzersiz geçerli bir e-posta yaz.
4. Kaydet butonuna bas.
5. Başarılı mesajının göründüğünü doğrula.
6. Kullanıcının API/DB üzerinden oluştuğunu doğrula.

**Beklenen:** Tek kayıt oluşur, hata görünmez.

## Senaryo 2 - Duplicate e-posta

1. Bir kullanıcı kaydet.
2. Aynı e-postayla ikinci kayıt gönder.
3. Hata mesajını doğrula.
4. Veritabanında aynı e-posta için tek kayıt olduğunu doğrula.

**Beklenen:** Duplicate kayıt reddedilir.

## Senaryo 3 - Yetkisiz admin çağrısı

1. Token olmadan admin endpoint'ine istek gönder.
2. Response status kontrol et.

**Beklenen:** 401 Unauthorized.

## Flaky E2E nedenleri ve önlem

- Sabit `sleep` kullanımı → görünür element/response koşulu beklenir.
- Paylaşılan test verisi → her test benzersiz veri üretir.
- Test sırasına bağımlılık → senaryolar bağımsız çalışır.
- Ağ/servis kararsızlığı → kontrollü retry yalnızca altyapısal durumlarda kullanılır.
