# Test Matrisi

| Risk / Özellik | Unit | Integration | Contract | E2E | Öncelik |
|---|---:|---:|---:|---:|---|
| Kullanıcı adı doğrulaması | ✅ |  |  | ✅ | Yüksek |
| E-posta doğrulaması | ✅ |  |  | ✅ | Yüksek |
| Aynı e-postanın ikinci kez kaydı | ✅ | ✅ |  | ✅ | Yüksek |
| PostgreSQL unique constraint |  | ✅ |  |  | Yüksek |
| API response alanları |  | ✅ | ✅ |  | Yüksek |
| Yetkisiz istek |  | ✅ | ✅ | ✅ | Yüksek |
| Frontend modal açılışı |  |  |  | ✅/Manual | Orta |
| Tema görünümü |  |  |  | Manual | Düşük |
