# Refactor Notu

Testlerde tekrar eden repository kurulumu `@BeforeEach` içine taşınmıştır. Duplicate e-posta kontrolü `UserService` içinde davranış olarak korunmuş, veri saklama ayrıntısı `UserRepository` arayüzünün arkasında tutulmuştur.

Bu refactor ile:

- Test hazırlığı sadeleşmiştir.
- Service katmanı concrete repository sınıfına bağımlı olmaktan çıkarılmıştır.
- Aynı servis hem in-memory fake hem PostgreSQL repository ile test edilebilir hale gelmiştir.
- Davranış değişmeden kodun okunabilirliği ve test edilebilirliği artırılmıştır.
