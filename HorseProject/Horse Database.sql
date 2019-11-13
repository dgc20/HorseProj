create table horses (
                        horseId integer primary key,
                        sire integer,
                        dam integer,
                        name varchar(45)
);

create table encodings (
                           horseId integer primary key,
                           gait varchar(2),
                           breed varchar(4),
                           coo varchar(4),
                           sex varchar(1),
                           yob integer,
                           comment varchar(45)
);

create table logins (
                        userId integer primary key,
                        fname varchar(20),
                        lname varchar(20),
                        email varchar(30)
);
insert into Horses values(1,NULL,NULL,'jfksdjlj');
insert into encodings values(1,'ff','ffff','fff','f',3423,'fslkjfd');

SELECT * FROM horses as h join encodings e on e.horseid=h.horseid;