CREATE TABLE students (
	id serial PRIMARY KEY,
	"name" varchar(55) NOT NULL,
	phone varchar(15),
	email text
);

CREATE TABLE courses (
	id serial PRIMARY KEY,
	title varchar(20) NOT NULL,
	course_number int NOT NULL
);

CREATE TABLE teachers (
	id serial PRIMARY KEY,
	"name" varchar(55) NOT NULL,
	phone varchar(15),
	email TEXT,
	courses int REFERENCES courses(id)
);

CREATE TABLE topics (
	id serial PRIMARY KEY,
	topic varchar(25) UNIQUE NOT NULL,
	description text
);

CREATE TABLE students_courses (
	studentID int REFERENCES students(id),
	courseID int REFERENCES courses(id)
);

CREATE TABLE courses_topics (
	courseID int REFERENCES topics(id),
	topicsID int REFERENCES courses(id)
);

--5 students
INSERT INTO students
("name", phone, email)
VALUES('Adam', '5214785236', 'adam@test.net');

INSERT INTO students
("name", phone, email)
VALUES('Bob', '1235864785', 'bob@test.net');

INSERT INTO students
("name", phone, email)
VALUES('Charlie', '4851239672', 'charlie@test.net');

INSERT INTO students
("name", phone, email)
VALUES('Dana', '584720369', 'dana@test.net');

INSERT INTO public.students
("name", phone, email)
VALUES('Erica', '7485124859', 'erica@test.net');

--3 courses for them to enroll in
INSERT INTO courses
(title, course_number)
VALUES('CS', 101);

INSERT INTO courses
(title, course_number)
VALUES('English', 102);

INSERT INTO courses
(title, course_number)
VALUES('Art', 100);

--3 teachers to teach them
INSERT INTO teachers
("name", phone, email, courses)
VALUES('Fran', '1245789632', 'fran@test.com', 1);

INSERT INTO teachers
("name", phone, email, courses)
VALUES('George', '1235847025', 'geaorge@test.com', 2);

INSERT INTO teachers
("name", phone, email, courses)
VALUES('Hailey', '5328613970', 'hailey@test.com', 3);

-- and a few topics for those courses to cover
INSERT INTO public.topics
(topic, description)
VALUES('java', 'an introduction to Java programming');

INSERT INTO public.topics
(topic, description)
VALUES('sql', 'an introduction to SQL and databases');

INSERT INTO public.topics
(topic, description)
VALUES('react', 'an introduction to React using javascript');