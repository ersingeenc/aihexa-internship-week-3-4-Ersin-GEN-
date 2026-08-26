# Web Frontend #25 - TypeScript Fonksiyon Tipleri ve Generics

TypeScript, fonksiyon parametrelerine ve dönüş değerlerine tip vererek hataları çalışma zamanından önce yakalamaya yardımcı olur. Callback type, fonksiyona parametre olarak gönderilen başka bir fonksiyonun imzasını tanımlar.

Generic fonksiyonlar aynı algoritmayı farklı tiplerle güvenli biçimde kullanmayı sağlar. Demo içinde `uniqueBy<T, K>` fonksiyonu hem tip güvenli hem tekrar kullanılabilir bir şekilde listedeki tekrarları temizler.

`app.ts` TypeScript kaynak dosyasıdır. `app.js`, tarayıcıda doğrudan çalıştırılabilmesi için aynı örneğin derlenmiş JavaScript karşılığı olarak pakete eklenmiştir.

Kanıt: `frontend/DEMO_EVIDENCE.md`

Kaynaklar:
- https://www.typescriptlang.org/docs/handbook/2/functions.html
- https://www.typescriptlang.org/docs/handbook/2/generics.html
