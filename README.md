# Общие сведения

«**repair-service-app**» представляет собой пример реализации `backend` компьютерной мастерской.

## Принцип реализации

Здесь данный проект использует стандартную `Spring` архитектуру, которая представлена на фото ниже:

![изображение](https://github.com/user-attachments/assets/52af3dc1-9aa6-4d39-ad0c-6b6ddf59ea13)

# Зависимости

- [`Spring boot`]()
- [`Spring Security`]()
- [`Spring Data JPA`]()
- [`Spring Validation`]()
- [`Spring WebMVC`]()
- [`logback`]()
- [`springdoc`]()
- [`hypersistence`]()
- [`jsonwebtoken`]()

Более подробно смотрите зависимости [здесь](build.gradle.kts)

## Поддержка проекта

...

> [!IMPORTANT]
> Если вы хотите запускать `Spring` приложение без `Docker`, то воспользуйтесь обычным `docker-compose.yml`.
> Также в `src/main/resources/application.yml` уберите комментарии, чтобы можно было удобно запускать из-под `IDEA`.

## Полезные ссылки

- [Как настраивать `Swagger`?](https://struchkov.dev/blog/ru/api-swagger/)
- [Как настраивать `Swagger` c `Spring Security`](https://www.javainuse.com/boot3/sec/8)
- [Почему функции некоторые были написаны без комментариев с `changeSet`](https://stackoverflow.com/questions/34712347/create-function-from-sql-script-by-liquibase)
