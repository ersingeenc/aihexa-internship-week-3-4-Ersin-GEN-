# Gün 26 - Dockerfile ve Reproducible Build

Multi-stage build, uygulamanın önce build image içinde derlenip daha sonra sadece gerekli
çıktının küçük bir runtime image içine alınmasıdır. Bu yöntem image boyutunu küçültür ve
gereksiz araçların production image içinde bulunmasını engeller.

Base image seçerken güvenilir ve mümkün olduğunca küçük image tercih edilmelidir.
Dockerfile içerisinde Maven build aşaması ve Java 17 JRE çalışma aşaması ayrılmıştır.
Container root yerine `appuser` kullanıcısıyla çalıştırılmıştır.

## CI ve CD
CI, kod değişikliklerinin otomatik build ve testlerden geçirilmesidir. CD ise başarılı
çıktının dağıtıma hazır tutulması veya otomatik dağıtılması sürecidir.

## Git cherry-pick
Belirli bir commit'i başka branch üzerine almak için kullanılır.

```bash
git cherry-pick COMMIT_HASH
```

## Fotoğraf / Video Rızası
Bir kişinin görüntüsü paylaşılmadan önce kullanım amacı ve paylaşım alanı konusunda izin
alınması gerekir. Görüntüde kişisel veri, evrak veya özel bilgi bulunup bulunmadığı da
kontrol edilmelidir.
