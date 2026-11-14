
CREATE DATABASE IF NOT EXISTS smart_campus_db;

USE smart_campus_db;

CREATE TABLE IF NOT EXISTS students (
    student_id VARCHAR(50) PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    programme VARCHAR(100) NOT NULL,
    year_of_study INT NOT NULL
);

CREATE TABLE IF NOT EXISTS courses (
    course_id VARCHAR(50) PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    course_code VARCHAR(30) NOT NULL UNIQUE,
    credit_hours INT NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS administrators (
    administrator_id VARCHAR(50) PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS registrations (
    registration_id VARCHAR(50) PRIMARY KEY,
    student_id VARCHAR(50) NOT NULL,
    course_id VARCHAR(50) NOT NULL,
    registration_date DATE NOT NULL,
    status VARCHAR(30) NOT NULL,
    CONSTRAINT fk_registration_student
        FOREIGN KEY (student_id) REFERENCES students(student_id),
    CONSTRAINT fk_registration_course
        FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

CREATE TABLE IF NOT EXISTS academic_requests (
    request_id VARCHAR(50) PRIMARY KEY,
    student_id VARCHAR(50) NOT NULL,
    request_type VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    submission_date DATE NOT NULL,
    status VARCHAR(30) NOT NULL,
    CONSTRAINT fk_request_student
        FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE IF NOT EXISTS announcements (
    announcement_id VARCHAR(50) PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    message TEXT NOT NULL,
    publication_date DATE NOT NULL,
    administrator_id VARCHAR(50) NOT NULL,
    CONSTRAINT fk_announcement_administrator
        FOREIGN KEY (administrator_id)
        REFERENCES administrators(administrator_id)
);

