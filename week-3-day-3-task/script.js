const egitimFormu = document.getElementById("egitimFormu");
const jsonSonucu = document.getElementById("jsonSonucu");

egitimFormu.addEventListener("submit", function (event) {
    event.preventDefault();

    const kayitBilgileri = {
        firstName: document.getElementById("ad").value,
        lastName: document.getElementById("soyad").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("telefon").value,
        educationName: document.getElementById("egitim").value,
        level: document.getElementById("seviye").value,
        description: document.getElementById("aciklama").value,
        kvkkApproved: document.getElementById("kvkk").checked
    };

    const jsonVerisi = JSON.stringify(kayitBilgileri, null, 2);

    jsonSonucu.textContent = jsonVerisi;

    console.log("Backend'e gönderilecek JSON:");
    console.log(kayitBilgileri);
});