CREATE TABLE users (
	id serial PRIMARY KEY,
	fName varchar(25) NOT NULL,
	lName varchar(25) NOT NULL,
	uName varchar(25) NOT NULL,
	"password" TEXT NOT NULL,
	"role" varchar(15)  DEFAULT 'Employee'
);

CREATE TABLE reports (
	id serial PRIMARY KEY,
	userID int NOT NULL REFERENCES users(id),
	amount decimal NOT NULL,
	description TEXT NOT NULL,
	status varchar(20) DEFAULT 'Pending'
);


INSERT INTO users VALUES (0, 'Patrick', 'Grady', 'patgrady', 'pass1234');