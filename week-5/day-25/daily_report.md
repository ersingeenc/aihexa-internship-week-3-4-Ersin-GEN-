# Gün 25 - Günlük Rapor

## Yapılanlar
Kritik kullanıcı akışları E2E/manuel tekrarlanabilir senaryolar haline getirildi. Flaky test nedenleri incelendi ve merge quality gate checklist'i oluşturuldu. Semantic Versioning, Git Issue, görsel/müzik kullanım hakları, Comparable/Comparator ve TypeScript fonksiyon tipleri/generics çalışmaları tamamlandı.

## Sorunlar
E2E testlerde sabit bekleme ve paylaşılan test verisinin kararsız sonuçlara yol açabileceği görüldü.

## Denenen çözüm
Sabit `sleep` yerine koşul bazlı bekleme, test başına benzersiz veri ve bağımsız senaryo yaklaşımı benimsendi.

## Sonraki adım
Haftalık çıktıların code review ile kontrol edilmesi ve quality gate şartlarını geçen değişikliklerin merge edilmesi.

## Kullanılan kaynaklar

- Semantic Versioning: https://semver.org/
- GitHub Issues: https://docs.github.com/en/issues
- TypeScript Handbook: https://www.typescriptlang.org/docs/handbook/2/generics.html
