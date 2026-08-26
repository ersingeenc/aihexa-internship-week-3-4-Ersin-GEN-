# Git Günlüğü #21 - .gitignore

`.gitignore`, Git tarafından takip edilmemesi gereken dosya ve klasörleri tanımlar. IDE ayarları, derleme çıktıları, işletim sistemi dosyaları ve gizli bilgiler repoya gereksiz veya riskli veri ekleyebilir.

Bu repository'nin kökündeki `.gitignore` dosyasında `.idea/`, `target/`, `.env`, `*.log`, `.DS_Store` ve `Thumbs.db` gibi örnekler eklenmiştir. Özellikle `.env` veya yerel secret dosyalarının repoya alınmaması güvenlik açısından önemlidir.

Kaynak: https://git-scm.com/docs/gitignore
