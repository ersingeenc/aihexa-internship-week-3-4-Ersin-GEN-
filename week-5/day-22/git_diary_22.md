# Git Günlüğü #22 - HEAD

Git'te `HEAD`, çalışma anında seçili olan commit/branch konumunu temsil eder. Normal durumda `HEAD` aktif branch'i işaret eder ve branch de son commit'i gösterir.

Bir commit hash'ine doğrudan checkout yapılırsa **detached HEAD** oluşabilir. Bu durumda yeni commit üretilebilir ancak bir branch'e bağlı olmadığı için commit'in kaybolmaması adına yeni branch oluşturmak gerekir.

Örnek:

```bash
git switch --detach <commit-hash>
git switch -c inceleme-branch
```

Kaynak: https://git-scm.com/docs/gitglossary
