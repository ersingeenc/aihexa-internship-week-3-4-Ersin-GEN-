# Gün 21 - Günlük Rapor

## Yapılanlar
Test pyramid, testing trophy, contract test ve mutation testing araştırıldı. Risk bazlı test kapsamı, test matrisi ve test veri/cleanup planı hazırlandı. `.gitignore`, CTR/dönüşüm, List/ArrayList ve HTML5 `data-*`, `template`, `dialog` konuları uygulandı.

## Sorunlar
E2E testlerin fazla sayıda tutulmasının bakım maliyetini artırabileceği görüldü.

## Denenen çözüm
Kritik akışlar E2E seviyesinde bırakılırken, iş kurallarının büyük bölümü unit ve integration testlerine dağıtıldı.

## Sonraki adım
Service katmanında davranış odaklı unit testlerin hazırlanması.

## Kullanılan kaynaklar

- JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
- Git gitignore: https://git-scm.com/docs/gitignore
- MDN HTML: https://developer.mozilla.org/
