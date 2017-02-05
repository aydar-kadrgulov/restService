CREATE TABLE patients
(
ID  SERIAL PRIMARY KEY,
firstName CHAR(50) NOT NULL,
patientName CHAR(50) NOT NULL,
lastName CHAR(50),
birthDate date NOT NULL,
snils CHAR(11) NOT NULL,
CONSTRAINT snils_unique UNIQUE (snils)
);

CREATE TABLE vaccinations
(
ID SERIAL PRIMARY KEY,
drugName char(50) NOT NULL,
eventDate date NOT NULL,
patient_id integer REFERENCES patients (id)
);

insert into patients (firstName, patientName, lastName, birthDate, snils) values ('sd','gfg','sdg','11.11.2011','123456789');

insert into vaccinations (drugName, eventDate, patient_id) VALUES ('sdfsdf', '11.11.2012', 1);