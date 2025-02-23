﻿CREATE DATABASE skillhub_project;

-- Создание таблицы ролей
CREATE TABLE roles (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(50) UNIQUE NOT NULL
);

-- Создание таблицы пользователей
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100),
                       level INTEGER DEFAULT 1
);

-- Создание связывающей таблицы для пользователей и ролей
CREATE TABLE user_roles (
                            user_id BIGINT NOT NULL,
                            role_id BIGINT NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
                            CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);

-- Создание таблицы курсов
CREATE TABLE courses (
                         id BIGSERIAL PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         description TEXT,
                         author_id BIGINT,
                         CONSTRAINT fk_course_author FOREIGN KEY (author_id) REFERENCES users (id) ON DELETE SET NULL
);

-- Создание таблицы уроков
CREATE TABLE lessons (
                         id BIGSERIAL PRIMARY KEY,
                         title VARCHAR(255),
                         content TEXT,
                         course_id BIGINT NOT NULL,
                         CONSTRAINT fk_lesson_course FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE
);

-- Создание таблицы тестов (quiz)
CREATE TABLE quizzes (
                         id BIGSERIAL PRIMARY KEY,
                         title VARCHAR(255),
                         course_id BIGINT NOT NULL,
                         CONSTRAINT fk_quiz_course FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE
);

-- Создание таблицы вопросов
CREATE TABLE questions (
                           id BIGSERIAL PRIMARY KEY,
                           question_text TEXT,
                           correct_answer TEXT,
                           options TEXT,
                           quiz_id BIGINT NOT NULL,
                           CONSTRAINT fk_question_quiz FOREIGN KEY (quiz_id) REFERENCES quizzes (id) ON DELETE CASCADE
);

-- Создание таблицы комментариев
CREATE TABLE comments (
                          id BIGSERIAL PRIMARY KEY,
                          content TEXT NOT NULL,
                          user_id BIGINT,
                          course_id BIGINT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL,
                          CONSTRAINT fk_comment_course FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE
);

-- Создание таблицы достижений
CREATE TABLE achievements (
                              id BIGSERIAL PRIMARY KEY,
                              name VARCHAR(255),
                              description TEXT,
                              user_id BIGINT,
                              achieved_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              CONSTRAINT fk_achievement_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
