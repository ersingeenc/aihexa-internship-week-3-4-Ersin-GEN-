# Integration Testleri

`src/test/java/com/aihexa/week5/PostgresUserRepositoryIT.java`, gerçek PostgreSQL davranışına yakın bir ortam için Testcontainers kullanacak şekilde hazırlanmıştır.

## Senaryolar

- Kullanıcı kaydı ve e-posta ile tekrar okuma
- Transaction rollback sonrası kayıt sayısının sıfır olması
- Unique e-posta constraint'inin duplicate kaydı reddetmesi

## Testcontainers

Testcontainers, test sırasında geçici container başlatmayı ve test bittiğinde kapatmayı kolaylaştırır. Böylece yalnızca in-memory veritabanına güvenmek yerine gerçek PostgreSQL motoruna daha yakın davranış test edilebilir.

Kaynak: https://java.testcontainers.org/modules/databases/postgres/
