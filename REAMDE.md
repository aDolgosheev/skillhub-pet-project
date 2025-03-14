# SkillHub - Платформа онлайн-курсов
**(В РАЗРАБОТКЕ)**

## Описание

SkillHub - это веб-приложение для онлайн-обучения, позволяющее пользователям проходить курсы, смотреть уроки, выполнять тесты и получать достижения.

## Возможности

- Регистрация и аутентификация пользователей
- Просмотр списка курсов
- Прохождение уроков и тестов
- Система достижений
- Комментарии к курсам и урокам
- Веб-сокеты для взаимодействия в реальном времени

## Используемые технологии

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Security** (JWT-аутентификация)
- **Spring Data JPA** (Hibernate)
- **Spring Web** (REST API)
- **Spring WebSockets** (реализация веб-сокетов)
- **PostgreSQL** (база данных)
- **Flyway** (миграции базы данных)
- **Lombok** (автоматическая генерация кода)
- **Docker** (развёртывание)

## Запуск проекта

### Локальный запуск (без Docker)

1. Убедитесь, что установлены **Java 17** и **PostgreSQL**.
2. Выполните клонирование репозитория:
   ```sh
   git clone https://github.com/your-repo/skillhub-pet-project.git
   cd skillhub-pet-project
   ```
3. Настройте **application.properties** или **application.yml**, указав параметры подключения к БД.
4. Запустите миграции базы данных:
   ```sh
   mvn flyway:migrate
   ```
5. Запустите приложение:
   ```sh
   mvn spring-boot:run
   ```

### Запуск через Docker

1. Убедитесь, что установлен **Docker** и **Docker Compose**.
2. Создайте `.env` файл и укажите параметры для БД.
3. Запустите контейнеры:
   ```sh
   docker-compose up -d
   ```

## API

Документация API доступна по адресу:

```
http://localhost:8080/swagger-ui.html
```

## Авторы

https://github.com/aDolgosheev

