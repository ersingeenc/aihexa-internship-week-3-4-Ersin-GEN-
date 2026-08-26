# Gün 28 - Config ve Secret Yönetimi

Config değerlerinin kaynak kod içine gömülmemesi için environment variable kullanıldı.
Gerçek `.env` dosyası `.gitignore` içine alındı ve repository içinde yalnızca
`.env.example` tutuldu.

## Config Matrisi

| Değer | Development | Production |
|---|---|---|
| DB URL | Local/Compose | Production DB |
| DB User | Local user | Secret olarak |
| DB Password | Yerel `.env` | Secret manager |
| APP ENV | development | production |

## Cache
Cache sık kullanılan verilerin daha hızlı erişilebilen bir yerde tutulmasıdır.
Eski verinin cache içinde kalması stale data problemine yol açabilir.

## Git Squash
Birden fazla küçük commit'i tek anlamlı commit haline getirmek için kullanılır.

## Güvenli Dosya Paylaşımı
Public link yerine ihtiyaç durumunda restricted link kullanılmalıdır. Düzenleme yetkisi
yalnızca gerçekten ihtiyacı olan kişilere verilmelidir.
