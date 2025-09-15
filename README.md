# WebProgramming lab work №1


## Quick Start
```bash
docker comose up
```

## Structure
```
├── httpd/                  # Директория с конфигурациями веб-серверов и статическими файлами
      ├── nginx-conf/       # Конфиг веб-сервера для nginx  
      ├── apache-conf/      # Конфиг веб-сервера для apache (! НА ДАННЫЙ МОМЕНТ ОТКЛЮЧЁН !)
      ├── static/           # Директория с статическими файлами
            ├── index.html  # Основной файл сайта
            ├── js/         # Js сайта
            └── assets/     # Ресурсы сайта
      ├── Dockerfile-nginx  # Dockerfile для Nginx
      └── Dockerfile-apache # Dockerfile для Apache  (! НА ДАННЫЙ МОМЕНТ ОТКЛЮЧЁН !)
├── server/                 # Директория с кодом java-сервера (FastCGI)
      ├── lib/              # Директория с библиотекой для fastcgi
      ├── src/              # Исходники
      └── Dockerfile        # Dockerfile для fastcgi-сервера
```


## TODOs

### Httpd
- [ ] https support

### Java FCGI
- [X] User input validation
- [X] Add support of responces with information about errors
