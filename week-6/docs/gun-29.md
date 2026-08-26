# Gün 29 - CI Pipeline, Cache ve Artifact

GitHub Actions ile basit bir CI pipeline oluşturuldu. Pipeline Java 17 ortamını kurar,
Maven projesini package eder, Docker image oluşturur ve JAR dosyasını artifact olarak
saklar.

Dependency cache sayesinde Maven bağımlılıklarının her çalışmada yeniden indirilmesi
azaltılabilir.

## Transaction ve ACID
Transaction, birden fazla veritabanı işleminin güvenli bir bütün olarak yürütülmesini
sağlar. ACID; Atomicity, Consistency, Isolation ve Durability özelliklerini ifade eder.

## git blame
Bir satırın hangi commit ile ve kim tarafından değiştirildiğini incelemeye yardımcı olur.
Amaç kişiyi suçlamak değil değişikliğin geçmiş bağlamını bulmaktır.

## Bulut İzinleri
View, comment ve edit izinleri ihtiyaca göre verilmelidir. Gereksiz edit yetkisi yanlış
değişiklik veya veri sızıntısı riskini artırabilir.
