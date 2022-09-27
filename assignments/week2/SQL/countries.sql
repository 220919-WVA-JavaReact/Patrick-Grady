CREATE TABLE countries (
	country varchar(25),
	region varchar(25),
	population int,
	"area" decimal,
	gdp int
);

INSERT INTO countries
("country", region, population, area, gdp)
VALUES ('USA', 'Northern America', 298444215, 9631420, 37800);

INSERT INTO countries
VALUES ('Australia', 'Oceania', 20264082, 7686850, 29000);

INSERT INTO countries
VALUES ('United Kingdom', 'Western Europe', 60609153, 244820, 27700);

INSERT INTO countries
VALUES ('Netherlands', 'Western Europe', 16491461, 41526, 28600);