# Gün 27 - Docker Compose, Network ve Healthcheck

Docker Compose ile PostgreSQL, backend ve frontend servisleri tek dosya üzerinden
tanımlandı. Aynı Compose ağı içindeki servisler birbirlerine servis isimleriyle erişebilir.

Healthcheck, process'in sadece çalışıp çalışmadığını değil servisin gerçekten kullanıma
hazır olup olmadığını kontrol eder. PostgreSQL için `pg_isready` kullanıldı.

## Container ve Image
Image çalıştırılabilir uygulama şablonudur. Container ise image'ın çalışan örneğidir.

## Merge Stratejileri
- Merge commit: branch geçmişini korur.
- Squash merge: değişiklikleri tek commit yapar.
- Rebase merge: daha doğrusal commit geçmişi oluşturur.

## KVKK Farkındalığı
İhtiyaçtan fazla kişisel veri toplanmamalı ve veri yalnızca belirtilen amaç için
kullanılmalıdır.
