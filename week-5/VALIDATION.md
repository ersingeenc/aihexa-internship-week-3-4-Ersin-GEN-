# Paket Doğrulama Notları

Paket hazırlanırken aşağıdaki kontroller uygulanmıştır:

- Java SE örnekleri `javac --release 17` ile derlenmiştir.
- Ana Java sınıfları `javac --release 17` ile derlenmiştir.
- Frontend JavaScript/TypeScript dosyaları sözdizimi ve derleme kontrolünden geçirilmiş, her demo için `DEMO_EVIDENCE.md` hazırlanmıştır.
- JSON dosyaları parse edilmiştir.

JUnit/Testcontainers testleri Maven ve Docker gerektirir. Paket hazırlama ortamında Maven bulunmadığı için bu testlerin geçtiği iddia edilmemiştir. Docker + Maven bulunan ortamda `mvn verify` ile doğrulanmalıdır.
