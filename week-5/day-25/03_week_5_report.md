# 5. Hafta Raporu

Bu hafta test mimarisi ve yazılım kalitesi konuları üzerine çalışıldı. İlk gün risk bazlı test stratejisi oluşturularak unit, integration, contract ve E2E testlerinin hangi riskleri kapsaması gerektiği planlandı. Test verisi ve cleanup yaklaşımı belirlendi.

İkinci gün service katmanının davranışını doğrulayan unit testler hazırlandı. Boundary ve invalid-case testleri parameterized test yaklaşımıyla ele alındı. Testlerin implementasyon ayrıntılarına gereksiz bağlanmaması için repository arayüzü ve in-memory fake kullanıldı.

Üçüncü gün PostgreSQL davranışını gerçek ortama daha yakın doğrulamak amacıyla Testcontainers tabanlı integration test yapısı hazırlandı. Migration, rollback ve unique constraint senaryoları ele alındı.

Dördüncü gün API regression ve contract kontrolü çalışıldı. Response schema, auth negatif senaryosu, schema drift ve breaking change kavramları incelendi. Postman koleksiyonu ve JSON Schema örneği hazırlandı.

Beşinci gün kritik kullanıcı akışları E2E/tekrarlanabilir senaryolar şeklinde tanımlandı ve merge öncesi kalite kapısı checklist'i oluşturuldu. Böylece testlerin yalnızca sayısına değil, iş risklerini kapsamasına ve deterministik çalışmasına odaklanıldı.

Hafta boyunca Git, dijital okuryazarlık, Java SE ve web frontend sürekli serileri de devam ettirilerek `.gitignore`, HEAD, origin/upstream, PR/MR, Issue; koleksiyonlar ve generics; BEM, Bootstrap, ES Modules, Web Storage ve TypeScript generics konuları uygulamalı olarak tekrar edildi.
