# Test Mimarisi ve Risk Bazlı Test Stratejisi

## Test Pyramid ve Testing Trophy

**Test Pyramid**, tabanda çok sayıda hızlı unit test, ortada daha az integration test ve üstte az sayıda E2E test önerir. Amaç hızlı geri bildirim ve düşük bakım maliyetidir. **Testing Trophy** ise modern web uygulamalarında integration testlere daha fazla ağırlık verir; static analysis ve E2E testleri de tamamlayıcı katmanlar olarak görür.

## Contract Test

Contract test, iki servis veya frontend-backend arasındaki veri sözleşmesinin bozulmadığını doğrular. Alan adının silinmesi, tipinin değişmesi veya zorunlu alan davranışının değişmesi gibi entegrasyonu kırabilecek durumları erken yakalar.

## Mutation Testing

Mutation testing, kaynak kodda küçük yapay hatalar üretip testlerin bu hataları yakalayıp yakalamadığını ölçer. Test sayısından çok testlerin hata bulma gücünü değerlendirmeye yardım eder.

## Risk Bazlı Kapsam

1. **Kullanıcı kaydı ve doğrulama — Yüksek risk:** Unit + integration + E2E
2. **Veritabanı unique constraint — Yüksek risk:** Integration
3. **API response sözleşmesi — Yüksek risk:** Contract + regression
4. **Görsel düzen — Orta risk:** Component/manual
5. **Bilgilendirme metni — Düşük risk:** Manual review

## Önerilen dağılım

- Unit: %50
- Integration: %30
- Contract/API regression: %15
- E2E: %5

Bu oranlar kesin kural değildir; iş riskine göre değiştirilir.

## Kaynaklar

- JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
- Martin Fowler - Test Pyramid: https://martinfowler.com/articles/practical-test-pyramid.html
- Pact - Consumer Driven Contracts: https://docs.pact.io/
