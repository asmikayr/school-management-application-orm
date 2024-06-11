INSERT INTO roles(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id, description)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Admin'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Manager'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Instructor');

INSERT INTO addresses(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                      address_info,
                      state, phone_number)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '123 Main Street Anytown 12345', 'CALIFORNIA',
        '+1 (555) 555-1234'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '456 Oak Avenue Smallville 67890', 'TEXAS',
        '+1 (555) 555-5678'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '101 Pineapple Avenue Beachtown 98765', 'HAWAII',
        '+1 (555) 555-6789'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '321 Elm Street Springfield 23456', 'ILLINOIS',
        '+1 (555) 555-2456'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '567 Pine Road Lakeside 78901', 'FLORIDA',
        '+1 (555) 555-7890'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '789 Maple Drive Suburbia 45678', 'NEW_YORK',
        '+1 (555) 555-9012'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '890 Cedar Lane Mountainview 56789',
        'COLORADO', '+1 (555) 555-2345'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '741 Wood Drive Downtown 65678', 'PENNSYLVANIA',
        '+1 (555) 555-1980'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, '235 Snow Street 30897', 'ALASKA',
        '+1 (555) 555-1949');

INSERT INTO users(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                  first_name, last_name, user_name, password, confirm_password, role_id, gender, address_id)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Michael', 'Jordan', 'mick@gmail.com', 'PassWord$1',
        'PassWord$1', 1, 'MALE', 1),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Larry', 'Bird', 'larry@gmail.com', 'PassWord$2',
        'PassWord$2', 2, 'MALE', 2),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Angelina', 'Sea', 'star@yahoo.com', 'PassWord$3',
        'PassWord$3', 3, 'FEMALE', 3),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Elizabeth', 'Loren', 'loren@hotmail.com',
        'PassWord$4', 'PassWord$4', 3, 'FEMALE', 4),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Bill', 'Wooden', 'bill@gmail.com', 'PassWord$5',
        'PassWord$5', 3, 'MALE', 5);

INSERT INTO courses(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                    name, description, course_manager_id, start_date, end_date)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Spring Boot', 'Spring Boot with MVC, ORM, REST', 2,
        '2024-01-10', '2024-01-10'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Java Advanced',
        'Functional Programming, Streams, New Features', 2, '2024-01-10', '2024-01-10'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'React Development', 'Create web app with React', 2,
        '2024-01-10', '2024-01-10');

INSERT INTO lessons(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                    name, description, course_id, instructor_id)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Dependency Injection',
        'In this lesson, you will learn the details of Injection', 1, 3),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Bean Annotation and Component',
        'This lesson for how to create Bean', 1, 3),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Lambda Expression',
        'How to use functional interfaces', 2, 4),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Streams',
        'You will learn common methods of Stream interface', 2, 4),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'How to create API', 'Basics of API creation', 3, 5),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Single Page Application',
        'Introduction to front-end development', 3, 5);

INSERT INTO students(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                     first_name, last_name, email, gender, address_id)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Igor', 'Kotlin', 'igor@yahoo.com', 'MALE',
        6),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Sue', 'Jayden', 'sue@gmail.com', 'FEMALE',
        7),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Tina', 'Davis', 'tina@gmail.com', 'FEMALE',
        8),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 'Jorge', 'News', 'news@gmail.com', 'MALE',
        9);

VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 3, 1),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 4, 1),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 3, 2),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 4, 2);

INSERT INTO course_student(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                           course_id, student_id,
                           is_enrolled)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 1, 1, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 1, 2, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 1, 3, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 1, 4, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 2, 1, true),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 2, 2, true),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 2, 3, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 2, 4, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 3, 1, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 3, 2, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 3, 3, false),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 3, 4, false);

INSERT INTO lesson_student(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                           lesson_id, student_id)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 3, 1),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 4, 1),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 3, 2),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 4, 2);



INSERT INTO assessments(insert_date_time, insert_user_id, is_deleted, last_update_date_time, last_update_user_id,
                        lesson_student_id, grade_date, grade, instructor_impression_of_student)
VALUES ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 1, '2022-01-05 00:00:00', 50, 'Not Bad'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 1, '2022-01-05 00:00:00', 70, 'Good'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 2, '2022-01-05 00:00:00', 80, 'Good'),
       ('2022-01-05 00:00:00', 1, false, '2022-01-05 00:00:00', 1, 2, '2022-01-05 00:00:00', 10, 'Are you serious');