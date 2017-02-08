CREATE TABLE patients
(
ID  SERIAL PRIMARY KEY,
firstName VARCHAR(50) NOT NULL,
patientName VARCHAR(50) NOT NULL,
lastName VARCHAR(50),
gender boolean not null,
birthDate date NOT NULL,
snils VARCHAR(11) NOT NULL,
CONSTRAINT snils_unique UNIQUE (snils)
);

CREATE TABLE vaccinations
(
ID SERIAL PRIMARY KEY,
drugName VARCHAR (50) NOT NULL,
eventDate date NOT NULL,
patient_id integer REFERENCES patients (id)
);

insert into patients (firstName, patientName, lastName, birthDate, snils) values ('sd','gfg','sdg','11.11.2011','123456789');

insert into vaccinations (drugName, eventDate, patient_id) VALUES ('sdfsdf', '11.11.2012', 1);