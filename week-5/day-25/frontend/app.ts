type TestCase = {
  id: number;
  name: string;
  priority: "low" | "medium" | "high";
};

type KeySelector<T, K> = (item: T) => K;

function uniqueBy<T, K>(items: T[], keySelector: KeySelector<T, K>): T[] {
  const seen = new Set<K>();
  return items.filter(item => {
    const key = keySelector(item);
    if (seen.has(key)) return false;
    seen.add(key);
    return true;
  });
}

const cases: TestCase[] = [
  { id: 1, name: "Register", priority: "high" },
  { id: 1, name: "Register duplicate", priority: "high" },
  { id: 2, name: "Login", priority: "high" }
];

const uniqueCases = uniqueBy(cases, item => item.id);
const output = document.querySelector<HTMLPreElement>("#output");
if (output) output.textContent = JSON.stringify(uniqueCases, null, 2);
