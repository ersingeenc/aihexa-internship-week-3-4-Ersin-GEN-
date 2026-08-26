# API Regression Raporu

`api/week5.postman_collection.json` koleksiyonu örnek API kontrollerini otomatik çalıştırmak için hazırlanmıştır.

## Kontroller

- `GET /api/users/1` için 200 durum kodu
- Response body'sinde `id`, `name`, `email` alanlarının bulunması
- `GET /api/admin/users` çağrısında token yokken 401 beklenmesi

## Otomatik çalıştırma

Newman kuruluysa:

```bash
newman run api/week5.postman_collection.json --env-var baseUrl=http://localhost:8080
```

Not: Koleksiyon örnek sözleşmeyi ve test scriptlerini içerir; gerçek sonuç backend ayaktayken üretilir.
