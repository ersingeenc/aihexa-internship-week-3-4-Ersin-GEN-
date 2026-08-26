# Kısa Demo Kanıtı

## Doğrulanan senaryo

Sayfa açıldığında Unit Test, Integration Test ve E2E Test kartları görünür. Bir karta tıklanınca dialog açılır ve başlık `data-modal-title` üzerinden okunur.

## Çalıştırma

Repository kökünde:

```bash
python -m http.server 8000
```

Sonra tarayıcıdan `/day-21/frontend/index.html` yolu açılır.

## Paket hazırlama kontrolü

- JavaScript dosyaları `node --check` ile sözdizimi kontrolünden geçirilir.
- TypeScript bulunan gün için `tsc --noEmit` kontrolü uygulanır.
- HTML/CSS/JS kaynakları repository içinde birlikte teslim edilir.

> Not: Otomatik headless Chromium bu çalışma ortamında sistem DBus problemi nedeniyle ekran görüntüsü üretemedi. Bu yüzden sahte ekran görüntüsü eklenmemiştir; gerçek görsel kanıt gerekiyorsa demo kendi tarayıcında açılıp ekran görüntüsü alınmalıdır.
