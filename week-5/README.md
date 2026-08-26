# 5. Hafta - Test, Kalite ve Yazılım Geliştirme Çalışmaları

Bu repository, 5. haftanın günlük araştırma, uygulama ve kanıt teslimlerini tek yerde toplar.

## İçerik

- **Gün 21:** Test mimarisi, risk bazlı test stratejisi, `.gitignore`, CTR/dönüşüm, List/ArrayList, HTML5 data-* / template / dialog
- **Gün 22:** Domain/service unit testleri, HEAD, erişilebilir sosyal medya, Set/HashSet, BEM ve sürdürülebilir CSS
- **Gün 23:** Integration/repository/transaction testleri, origin/upstream, hashtag/anahtar kelime, Map/HashMap, Bootstrap özelleştirme
- **Gün 24:** API regression ve contract kontrolü, PR/MR, kısa video içeriği, Generics, ES Modules ve Web Storage
- **Gün 25:** Frontend/E2E kritik akışlar, kalite kapısı, Issue, kullanım hakları, Comparable/Comparator, TypeScript fonksiyon tipleri ve generics

## Teknik yapı

- Java: 17 uyumlu
- Test: JUnit 5
- Integration test: PostgreSQL + Testcontainers
- Frontend: HTML5, CSS3, Bootstrap 5, JavaScript ES Modules, TypeScript
- API regression örneği: Postman collection

## Test komutları

Maven kuruluysa:

```bash
mvn test
mvn verify
```

`mvn verify` sırasında Testcontainers entegrasyon testi için Docker çalışıyor olmalıdır.

## Frontend demoları

Her günün klasöründeki `frontend/index.html` dosyası incelenebilir. ES Modules kullanılan Gün 24 için doğrudan `file://` yerine küçük bir HTTP sunucusu önerilir:

```bash
python -m http.server 8000
```

Ardından tarayıcıdan ilgili klasöre gidilir.

## Not

Her frontend klasöründe kısa demo kanıtı ve kontrol adımları bulunur. Görsel ekran görüntüsü isteniyorsa kendi tarayıcında demoyu açıp ekran görüntüsünü aynı klasöre ekleyebilirsin. Testcontainers entegrasyon testi için gerçek PostgreSQL container çıktısı Docker bulunan geliştirme ortamında `mvn verify` çalıştırılarak üretilmelidir.

## Önerilen anlamlı commit mesajları

- `docs: add day 21 test strategy and frontend research`
- `test: add service unit tests and refactor notes`
- `test: add postgres integration and transaction scenarios`
- `test: add api regression and contract checks`
- `docs: add e2e scenarios quality gate and week 5 report`
