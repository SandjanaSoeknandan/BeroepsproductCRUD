create database apotheek_administratie; 
show databases; 
use apotheek_administratie; 

create table Medicijnen ( 
Medicijn_id  int primary key not null auto_increment, 
Medicijn_naam char(30) not null, 
Medicijn_aantal int(30) 
); 

insert into Medicijnen (Medicijn_naam, Medicijn_aantal) values 
('Parcetamol', 5000),  
('Amoxil', 2500), 
('Paracoph', 1700), 
('Vitamine B-complex', 2000), 
('Vitamine C 1000mg', 1300), 
('Aspirine', 1400), 
('Nexoderm', 2500), 
('Wormkuur', 1230)
; 

create table Bestellingen ( 
Bestelling_id int primary key auto_increment not null, 
Datum datetime, 
Aantal int(30), 
Verantwoordelijke char(30), 
Medicijn_id int(30), 

foreign key (Medicijn_id) references Medicijnen (Medicijn_id) on delete cascade  
); 

insert into Bestellingen (Datum, Aantal, Verantwoordelijke, Medicijn_id) values 
('01-03-20', 2000, 'Jaya Mangroe', 3), 
('14-02-20', 1420, 'Shayant', 7), 
('31-09-20', 2400, 'Shanaya', 7),  
('25-03-20', 1240, 'Humphrey', 5), 
('23-01-20', 1300, 'Siddhart', 8)
; 

create table Klanten ( 
Klant_id int primary key auto_increment not null, 
Voornaam char(30) not null, 
Achternaam char(30) not null, 
Contactnummer int, 
Adress char(30) 
);  

insert into Klanten (Voornaam, Achternaam, Contactnummer, Adress) values 
('Dhiradj', 'Ramadhin', 12345123, 'Fredericiweg #178'), 
('Sonali', 'Nanda', 2690273, 'Y-weg #11'), 
('Wiren', 'Nanda', 1849027, 'Emma straat #10'), 
('Malti', 'Sarjoe', 2948210, 'Johan Adolf Pengel Straat #15'), 
('Rekha', 'Chander', 2971037, 'Fredericiweg #128'), 
('Shiven', 'Mangroe', 1830183, 'Somewhere')
; 

create table TT_Medicijnen_Klanten ( 
Medicijn_id int, 
Klant_id int, 
Aantal_verkocht int,
foreign key (Medicijn_id) references Medicijnen (Medicijn_id) on delete cascade, 
foreign key (Klant_id) references Klanten (Klant_id) on delete cascade 

); 

insert into TT_Medicijnen_Klanten (Medicijn_id, Klant_id,Aantal_verkocht) values 
(3, 1,30), 
(1, 1,17), 
(5, 1,50), 
(4, 3,14), 
(6, 2,91), 
(1, 4,24), 
(7, 5,23) 
; 
