function uniqueBy(items, keySelector) {
  const seen = new Set();
  return items.filter(item => {
    const key = keySelector(item);
    if (seen.has(key)) return false;
    seen.add(key);
    return true;
  });
}

const cases = [
  { id: 1, name: "Register", priority: "high" },
  { id: 1, name: "Register duplicate", priority: "high" },
  { id: 2, name: "Login", priority: "high" }
];

document.querySelector("#output").textContent = JSON.stringify(uniqueBy(cases, item => item.id), null, 2);
