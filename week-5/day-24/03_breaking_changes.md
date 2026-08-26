# Breaking Change Adayları

| Değişiklik | Breaking mi? | Neden |
|---|---|---|
| `email` alanını kaldırmak | Evet | Mevcut frontend alanı okuyamaz |
| `id` tipini number'dan object'e çevirmek | Evet | Tip sözleşmesi değişir |
| Yeni optional `avatarUrl` alanı eklemek | Genellikle hayır | Eski tüketici alanı görmezden gelebilir |
| `/api/users/{id}` endpoint'ini kaldırmak | Evet | Mevcut çağrılar 404 alır |
| Response'a yeni metadata alanı eklemek | Genellikle hayır | Tüketici strict değilse uyumludur |
