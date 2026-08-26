# Contract Bulguları

## Schema Drift

Schema drift, servis sağlayıcının döndürdüğü veri yapısının tüketicinin beklediği şemadan zamanla farklılaşmasıdır. Örneğin `email` alanının `emailAddress` olarak değiştirilmesi frontend'i bozabilir.

## Backward Compatibility

Mevcut tüketicilerin kullandığı alanı silmek, tipini değiştirmek veya zorunlu yeni request alanı eklemek geriye dönük uyumluluğu bozabilir.

## Consumer-Driven Contract Testing

Consumer-driven contract yaklaşımında tüketici, ihtiyaç duyduğu API davranışını sözleşme olarak tanımlar; provider bu beklentiyi karşılayıp karşılamadığını doğrular.

## Mevcut örnek sözleşme

`contract/user-response.schema.json`, kullanıcı response'unda `id`, `name` ve `email` alanlarını zorunlu kabul eder.
