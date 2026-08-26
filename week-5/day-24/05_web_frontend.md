# Web Frontend #24 - ES Modules ve localStorage/sessionStorage

ES Modules, JavaScript kodunu `export` ve `import` ile ayrı dosyalara bölmeyi sağlar. Her module kendi scope'una sahiptir ve global değişken çakışmasını azaltır.

`localStorage`, veri silinene kadar tarayıcıda kalabilir. `sessionStorage` ise ilgili sekmenin oturumu boyunca yaşar. Demo, tema tercihini `localStorage` içine; geçici taslağı ise `sessionStorage` içine kaydeder.

ES Modules nedeniyle demo HTTP sunucusu üzerinden açılmalıdır.

Kanıt: `frontend/DEMO_EVIDENCE.md`

Kaynaklar:
- https://developer.mozilla.org/docs/Web/JavaScript/Guide/Modules
- https://developer.mozilla.org/docs/Web/API/Window/localStorage
- https://developer.mozilla.org/docs/Web/API/Window/sessionStorage
