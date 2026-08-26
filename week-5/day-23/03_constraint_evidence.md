# Constraint Kanıtı

Şemadaki `email VARCHAR(180) NOT NULL UNIQUE` tanımı duplicate e-postayı veritabanı seviyesinde engeller.

Integration testinde önce `same@example.com` kaydedilir, ardından aynı e-posta ikinci kez kaydedilmeye çalışılır. Beklenen sonuç `SQLException` oluşmasıdır.

Bu test, yalnızca service validation'a değil veritabanı bütünlüğüne de güvence ekler.
