# Gün 22 - Günlük Rapor

## Yapılanlar
Behavior/implementation test farkı, parameterized test ve test double türleri araştırıldı. `UserService` için kritik kuralları, boundary ve invalid-case durumlarını doğrulayan unit testler hazırlandı. Refactoring, Git HEAD, erişilebilir sosyal medya, Set/HashSet ve BEM CSS çalışmaları tamamlandı.

## Sorunlar
Unit testlerin repository implementasyonuna fazla bağlanması riski görüldü.

## Denenen çözüm
Repository arayüzü ve in-memory fake kullanılarak testlerin davranışa odaklanması sağlandı.

## Sonraki adım
PostgreSQL üzerinde integration, rollback ve constraint testlerinin hazırlanması.

## Kullanılan kaynaklar

- JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
- Git glossary: https://git-scm.com/docs/gitglossary
- BEM: https://getbem.com/introduction/
