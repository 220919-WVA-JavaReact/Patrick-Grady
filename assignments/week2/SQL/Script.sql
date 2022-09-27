CREATE TABLE users (
	id int,
	fName varchar(25),
	lName varchar(25),
	uName varchar(25),
	"password" TEXT
);

CREATE TABLE reports (
	id int,
	amount decimal,
	description TEXT,
	status varchar(20)
);


INSERT INTO users VALUES (0, 'Patrick', 'Grady', 'patgrady', 'pass1234');