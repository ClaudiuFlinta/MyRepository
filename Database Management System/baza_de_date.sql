CREATE TABLE Film (
	titlu varchar(30) NOT NULL ,
	an int(4) NOT NULL ,
	durata int(4) NOT NULL,
    gen varchar (8) NOT NULL ,
	studio varchar (20) NOT NULL ,
	id_producator int (5) NOT NULL);
	
CREATE TABLE Distributie(
    titlu_film varchar (30) NOT NULL,
	an_film int(4) NOT NULL,
	id_actor int(5) NOT NULL);

CREATE TABLE Persoana (
    id_persoana int (5) NOT NULL,
	nume varchar (30) NOT NULL,
	adresa varchar (30) NOT NULL,
	sex varchar(1) NOT NULL,
	data_nastreii date NOT NULL,
	castig_net float(12),
	moneda varchar(3) NOT NULL);

CREATE TABLE Studio(
    numes varchar (20) NOT NULL,
	adresas varchar (30) NOT NULL,
	tara varchar(20) NOT NULL,
	id_presedinte int(5) NOT NULL);


ALTER TABLE Film ADD CONSTRAINT PK_Film PRIMARY KEY (titlu,an);
ALTER TABLE Distributie ADD CONSTRAINT PK_Distributie PRIMARY KEY (titlu_film,an_film,id_actor);	
ALTER TABLE Persoana ADD CONSTRAINT PK_Persoana PRIMARY KEY (id_persoana);
ALTER TABLE Studio ADD CONSTRAINT PK_Studio PRIMARY KEY (numes);


ALTER TABLE Film ADD 
	CONSTRAINT FK_film_studio FOREIGN KEY (studio) REFERENCES Studio (numes);
	
ALTER TABLE Film ADD
    CONSTRAINT FK_PRODUCATOR_PERSOANA FOREIGN KEY (id_producator) REFERENCES Persoana (id_persoana);

ALTER TABLE Distributie ADD
    CONSTRAINT FK_ACTOR_PERSOANA FOREIGN KEY (id_actor) REFERENCES Persoana (id_persoana);	
	
ALTER TABLE Studio ADD
    CONSTRAINT FK_PRESEDINTE_PERSOANA FOREIGN KEY (id_presedinte) REFERENCES Persoana (id_persoana);

ALTER TABLE Persoana ADD email varchar(50);	

INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (1,'Zoe Seldana','New Jersey, USA','F', str_to_date('June 19 1978','%M %d %Y'),1200000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (2,'Robert Dowvey','New York, USA','M', str_to_date('April 6 1965','%M %d %Y'),2400000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (3,'Tim Roth','London, UK','M', str_to_date('May 14 1961','%M %d %Y'),2500000,'GBP');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (4,'James Cameron','Ontario, Canada','M', str_to_date('August 16 1954','%M %d %Y'),6000000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (5,'Kevin Feige','Boston, USA','M', str_to_date('June 2 1973','%M %d %Y'),900000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (6,'Estera Warren','Ontario, Canada','F', str_to_date('December 23 1978','%M %d %Y'),150000,'EUR');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (7,'Joe Silver','New Jersey, USA','M', str_to_date('July 14 1952','%M %d %Y'),1000100,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (8,'Walter Wanger','California, USA','M', str_to_date('July 11 1894','%M %d %Y'),100000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (9,'Leonardo DiCaprio','Los Angeles, USA','M', str_to_date('November 11 1974','%M %d %Y'),10000000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (10,'Joaquin Phoenix','San Juan, Puerto Rico','M', str_to_date('October 28 1974','%M %d %Y'),7550000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (11,'Hal B. Wallis','California, USA','M', str_to_date('October 19 1898','%M %d %Y'),600000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (12,'David Heyman','London, UK','M', str_to_date('July 26 1961','%M %d %Y'),15000000,'GBP');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (13,'Matei Dima','Bucharest, Romania','M', str_to_date('June 19 1987','%M %d %Y'),100000,'EUR');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (14,'McCauly Culkin','New York, USA','M', str_to_date('August 26 1980','%M %d %Y'),18000000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (15,'John Hunghes','New York, USA','M', str_to_date('February 18 1950','%M %d %Y'),50000000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (16,'Jim Carry','Ontario, Canada','M', str_to_date('January 17 1962','%M %d %Y'),9000000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (17,'Kristen Bell','Michigan, USA','F', str_to_date('July 18 1980','%M %d %Y'),700000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (18,'Peter Del Vecho','Los Angeles, USA','M', str_to_date('April 6 1958','%M %d %Y'),1500000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (19,'Sandra Bullock','Virginia, USA','F', str_to_date('July 26 1964','%M %d %Y'),3100000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (20,'Joan Cusack','New York, USA','F', str_to_date('October 11 1962','%M %d %Y'),13000000,'USD');
INSERT INTO Persoana(id_persoana,nume,adresa,sex,data_nastreii,castig_net,moneda) values (22,'Humphrey Bogart','New York, USA','M', str_to_date('January 14 1899','%M %d %Y'),17500000,'USD');  

INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('20th Century','New York', 'USA', 9);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Marvel','Los Angeles', 'USA', 8);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Village Roadshow','London', 'UK', 4);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Paramount Pictures','Los Angeles', 'USA', 6);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Columbia Pictures','Washington', 'USA', 7);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Studio Indie','Buftea', 'Romania', 13);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Dark Horse','Ottawa', 'Canada', 15);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Walt Disney','Paris', 'France', 18);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Illumination','Tokyo', 'Japan', 5);
INSERT INTO Studio (numes, adresas, tara, id_presedinte) values ('Warner Bros.','Burbank, Califormia', 'USA', 8);

	
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Avatar', 2009,162,'SF','20th Century', 4);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('The Avangers', 2012,143,'SF','Marvel', 5);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Planeta Maimutelor', 2001,119,'SF','20th Century', 6);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('The Matrix', 1999,136,'SF','Village Roadshow', 7);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Invasion of the BS', 1956,80,'SF','Paramount Pictures', 8);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Titanic', 1997,194,'drama','Paramount Pictures', 9);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Joker', 2019,122,'drama','Village Roadshow', 10);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Once upon a time..In Hollywood', 2019,161,'drama','Columbia Pictures', 12);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Miami Bici', 2020,98,'comedie','Studio Indie', 13);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Home Alone', 1990,103,'comedie','20th Century', 15);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('The Mask', 2001,101,'comedie','Dark Horse', 4);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Frozen', 2013,102,'copii','Walt Disney', 18);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Minions', 2015,91,'copii','Illumination', 5);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Toy Strory 3', 2010,103,'copii','Walt Disney', 8);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('Iron Man 3', 2013,131,'SF','Marvel', 5);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('XYZ', 2010,194,'comedie','Marvel', 2);
INSERT INTO Film (titlu,an,durata,gen,studio,id_producator) values ('ABC', 2003,194,'SF','Marvel', 1);


INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Avatar', 2009,1);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('The Avangers', 2012,2);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Planeta Maimutelor', 2001,3);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('The Matrix', 1999,7);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Invasion of the BS', 1956,8);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Titanic', 1997,9);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Joker', 2019,10);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Once upon a time..In Hollywood', 2019,9);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Miami Bici', 2020,13);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Home Alone', 1990,14);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('The Mask', 2001,16);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Frozen', 2013,17);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Minions', 2015,19);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Toy Strory 3', 2010,20);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Iron Man 3', 2013,12);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Iron Man 3', 2013,8);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Iron Man 3', 2013,19);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Miami Bici', 2020,8);
INSERT INTO Distributie (titlu_film,an_film,id_actor) values ('Home Alone', 1990,8);



