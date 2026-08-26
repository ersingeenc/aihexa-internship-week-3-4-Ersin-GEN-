const form = document.querySelector("#demoForm");
const message = document.querySelector("#message");

form.addEventListener("submit", async (event) => {
  event.preventDefault();

  try {
    if (!form.checkValidity()) {
      form.classList.add("was-validated");
      throw new Error("Form alanlarini kontrol edin.");
    }

    const results = await Promise.allSettled([
      Promise.resolve("kayit"),
      Promise.resolve("bildirim")
    ]);

    message.textContent = "Islem basarili. Promise sonucu: " + results.length;
  } catch (error) {
    message.textContent = error.message;
  } finally {
    console.log("Form islemi tamamlandi.");
  }
});
