const items = ["Unit Test", "Integration Test", "E2E Test"];
const template = document.querySelector("#cardTemplate");
const list = document.querySelector("#cardList");
const dialog = document.querySelector("#detailDialog");
const title = document.querySelector("#dialogTitle");

items.forEach(item => {
  const node = template.content.cloneNode(true);
  const button = node.querySelector("button");
  button.dataset.modalTitle = item;
  button.querySelector("span").textContent = item;
  button.addEventListener("click", event => {
    title.textContent = event.currentTarget.dataset.modalTitle;
    dialog.showModal();
  });
  list.appendChild(node);
});

document.querySelector("#closeDialog").addEventListener("click", () => dialog.close());
