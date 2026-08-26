# Kısa Demo Kanıtı

## Doğrulanan senaryo

Tema seçimi localStorage içine, taslak metni sessionStorage içine kaydedilir. Sayfa yenilendiğinde tema korunur; sekme oturumu boyunca taslak korunur.

## Çalıştırma

Repository kökünde:

```bash
python -m http.server 8000
```

Sonra tarayıcıdan `/day-24/frontend/index.html` yolu açılır.

## Paket hazırlama kontrolü

- JavaScript dosyaları `node --check` ile sözdizimi kontrolünden geçirilir.
- TypeScript bulunan gün için `tsc --noEmit` kontrolü uygulanır.
- HTML/CSS/JS kaynakları repository içinde birlikte teslim edilir.

> Not: Otomatik headless Chromium bu çalışma ortamında sistem DBus problemi nedeniyle ekran görüntüsü üretemedi. Bu yüzden sahte ekran görüntüsü eklenmemiştir; gerçek görsel kanıt gerekiyorsa demo kendi tarayıcında açılıp ekran görüntüsü alınmalıdır.
