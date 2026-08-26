# Gün 23 - Günlük Rapor

## Yapılanlar
Testcontainers, rollback ve repository testlerinin amacı araştırıldı. PostgreSQL için integration test senaryoları, migration SQL'i ve unique constraint kanıtı hazırlandı. Code smell, origin/upstream, hashtag/anahtar kelime, Map/HashMap ve Bootstrap özelleştirme çalışmaları tamamlandı.

## Sorunlar
Integration testlerin lokal ortam ile production davranışından ayrışma riski değerlendirildi.

## Denenen çözüm
Gerçek PostgreSQL image kullanan Testcontainers yaklaşımı seçildi.

## Sonraki adım
API regression, contract ve backward compatibility kontrolleri.

## Kullanılan kaynaklar

- Testcontainers PostgreSQL: https://java.testcontainers.org/modules/databases/postgres/
- GitHub Forks: https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks
- Bootstrap: https://getbootstrap.com/docs/5.3/customize/css-variables/
