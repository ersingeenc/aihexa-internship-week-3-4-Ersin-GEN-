export const preferenceStore = {
  saveTheme(theme) { localStorage.setItem("week5-theme", theme); },
  loadTheme() { return localStorage.getItem("week5-theme") ?? "light"; }
};

export const draftStore = {
  save(text) { sessionStorage.setItem("week5-draft", text); },
  load() { return sessionStorage.getItem("week5-draft") ?? ""; }
};
