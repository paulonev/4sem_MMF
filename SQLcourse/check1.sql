drop table if exists `tab1`;
drop table if exists `tab2`;

create table tab1(
	person_name int not null,
    popularity int not null
);
insert into tab1(person_name, popularity)
values
(1,2),(2,3),(1,4),(4,3),(3,2);

create table tab2(
	person_name int not null,
    grade int not null
);
insert into tab2(person_name, grade)
values
(1,8),(1,7),(2,4),(3,8),(5,6);

SELECT tab1.person_name, tab1.popularity, tab2.grade
FROM tab1 inner join tab2
on tab1.person_name = tab2.person_name
