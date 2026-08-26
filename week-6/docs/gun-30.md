# Gün 30 - Deployment ve Rollback

Bu örnek proje için basit ve anlaşılır olması nedeniyle rolling deployment yaklaşımı
uygun görülmüştür. Yeni sürüm kademeli olarak eski sürümün yerini alır.

Blue-green yaklaşımında iki ayrı ortam bulunur. Canary deployment yeni sürümü önce
kullanıcıların küçük bölümüne açar. Rolling deployment ise instance'ları sırayla günceller.

Rollback, sorunlu sürümden önceki çalışan sürüme dönmektir. Roll-forward ise problemi
yeni bir düzeltme sürümüyle ileriye doğru çözmektir.

## Rollback Planı

1. Hatalı deployment durdurulur.
2. Son çalışan image/tag belirlenir.
3. Önceki sürüm yeniden deploy edilir.
4. Healthcheck kontrol edilir.
5. Loglar incelenir.
6. Database migration varsa uyumluluk ayrıca kontrol edilir.

## Concurrency ve Thread
Concurrency birden fazla işin aynı zaman aralığında ilerlemesidir. Parallelism işlerin
gerçekten aynı anda farklı işlem kaynaklarında çalışmasıdır. Thread ise program içindeki
çalışma akışlarından biridir.

## git reflog
HEAD ve branch hareketlerini gösterir. Yanlışlıkla kaybolduğu düşünülen commit'i bulmaya
yardımcı olabilir.

```bash
git reflog
```

## 3-2-1 Yedekleme
Verinin 3 kopyası tutulur, 2 farklı ortam kullanılır ve 1 kopya farklı fiziksel/uzak
konumda saklanır.
