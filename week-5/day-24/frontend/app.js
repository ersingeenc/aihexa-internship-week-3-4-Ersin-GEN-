import { preferenceStore, draftStore } from "./storage.js";

const theme = document.querySelector("#theme");
const draft = document.querySelector("#draft");
const status = document.querySelector("#status");

function applyTheme(value) {
  document.body.classList.toggle("dark", value === "dark");
}

theme.value = preferenceStore.loadTheme();
draft.value = draftStore.load();
applyTheme(theme.value);

theme.addEventListener("change", () => {
  preferenceStore.saveTheme(theme.value);
  applyTheme(theme.value);
  status.textContent = "Tema localStorage içine kaydedildi.";
});

draft.addEventListener("input", () => {
  draftStore.save(draft.value);
  status.textContent = "Taslak sessionStorage içine kaydedildi.";
});
