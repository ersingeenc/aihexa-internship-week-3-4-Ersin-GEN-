# Git Günlüğü #23 - origin ve upstream

Fork tabanlı çalışmada `origin` genellikle geliştiricinin kendi fork repository'sini, `upstream` ise fork'un alındığı ana repository'yi gösterir.

```text
Ana Repo (upstream)
       |
       | fetch
       v
Yerel Repo ---- push ----> Kişisel Fork (origin)
```

Örnek komutlar:

```bash
git remote -v
git remote add upstream https://github.com/original/project.git
git fetch upstream
git switch main
git merge upstream/main
```

Kaynak: https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks
