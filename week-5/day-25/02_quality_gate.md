# Merge Quality Gate Checklist

- [ ] Unit testlerin tamamı geçiyor.
- [ ] Integration testlerin tamamı geçiyor.
- [ ] Kritik E2E/manual repeatable senaryolar geçiyor.
- [ ] Yeni/etkilenen iş kuralları için test eklendi.
- [ ] API contract veya breaking change kontrol edildi.
- [ ] Migration temiz veritabanında doğrulandı.
- [ ] Secret veya `.env` dosyası commit edilmedi.
- [ ] Kodda kritik lint/compile hatası yok.
- [ ] PR açıklamasında amaç, değişiklik, test ve risk alanları var.
- [ ] Flaky test bulunuyorsa neden çözülmeden merge edilmiyor.

## Örnek metrikler

- Test başarısı: %100 geçiş
- Kritik senaryo başarısı: %100
- Yeni kritik iş kuralı test kapsamı: zorunlu
- Açık blocker/critical bug: 0
- Breaking API change: belgelenmeden ve versiyonlanmadan 0
