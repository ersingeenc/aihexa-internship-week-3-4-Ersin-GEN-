# Migration Test Sonucu

Migration örneği `src/test/resources/schema.sql` dosyasında tutulur. Integration test başlamadan önce temiz PostgreSQL container üzerinde bu SQL uygulanır.

Beklenen sonuç:

- `users` tablosu oluşturulur.
- `id` alanı primary key olur.
- `name` ve `email` null kabul etmez.
- `email` unique constraint ile korunur.

Docker bulunan ortamda doğrulama komutu:

```bash
mvn verify
```

Bu paketin oluşturulduğu çalışma ortamında Maven bulunmadığı için gerçek container test çıktısı uydurulmamış; çalıştırılabilir test kodu ve doğrulama komutu teslim edilmiştir.
