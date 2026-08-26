# Test Data ve Cleanup Planı

Test verisi gerçek kullanıcı verisinden bağımsız olmalıdır. Her test kendi verisini üretmeli ve testler birbirine bağımlı çalışmamalıdır.

## Veri kategorileri

- Geçerli kullanıcı: `ada@example.com`
- Duplicate kullanıcı: aynı e-posta iki kez
- Boundary değer: boş isim, yalnızca boşluk, minimum geçerli metin
- Invalid değer: `user@`, `@example.com`, `invalid`

## Cleanup

- Unit testlerde her test için yeni `InMemoryUserRepository` oluşturulur.
- Integration testlerde `@BeforeEach` içinde `DELETE FROM users` çalıştırılır.
- Transaction senaryosunda değişiklik `rollback()` ile geri alınır.
- Testler production veritabanına bağlanmaz.
