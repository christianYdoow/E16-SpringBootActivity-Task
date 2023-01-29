CREATE DATABASE taskdb;

CREATE TABLE task (
    task_id SERIAL PRIMARY KEY NOT NULL,
    task_title VARCHAR(255) NOT NULL,
    task_description VARCHAR(255) NOT NULL,
    is_task_completed BOOLEAN NOT NULL
);