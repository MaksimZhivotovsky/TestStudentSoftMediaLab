CREATE TABLE students (
                          "date" date NULL,
                          student_id bigserial NOT NULL,
                          first_name varchar(255) NULL,
                          last_name varchar(255) NULL
);

CREATE TABLE grades (
                        grade_id bigserial NOT NULL,
                        id int8 NULL,
                        "text" varchar(255) NULL
);

CREATE TABLE student_grades (
                                grade_id bigint NOT NULL,
                                student_id bigint NOT NULL
);

INSERT INTO grades( id, text)
VALUES  (2, 'неуд'), (3, 'уд'), (4, 'хор'), (5, 'отл');