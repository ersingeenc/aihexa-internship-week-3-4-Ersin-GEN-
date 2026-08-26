# Web Frontend #21 - data-*, template ve dialog

## data-* özellikleri

HTML elemanlarına uygulamaya özel veri eklemek için `data-*` attribute'ları kullanılabilir. JavaScript tarafında `element.dataset` ile okunur.

## template

`template` içindeki içerik sayfa açıldığında doğrudan render edilmez. JavaScript ile klonlanıp gerektiğinde dinamik bileşen üretmek için kullanılabilir.

## dialog

`dialog`, modal veya modal olmayan iletişim kutuları oluşturmayı sağlar. `showModal()` ile modal olarak açılabilir ve `close()` ile kapatılabilir.

## Demo

`frontend/index.html` içinde bir `template` üzerinden butonlar üretilir. Butonların `data-modal-title` değeri okunur ve `dialog` içinde gösterilir.

## Kanıt

`frontend/DEMO_EVIDENCE.md` dosyası kısa demo doğrulama adımlarını ve beklenen sonucu içerir.

## Kaynaklar

- https://developer.mozilla.org/docs/Learn/HTML/Howto/Use_data_attributes
- https://developer.mozilla.org/docs/Web/HTML/Element/template
- https://developer.mozilla.org/docs/Web/HTML/Element/dialog
