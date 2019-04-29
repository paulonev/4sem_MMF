drop table if exists `3NF_courses`;
drop table if exists `3NF_lecturers`;
drop table if exists `3NF_studentPerformance`;
drop table if exists `3NF_sqlMarks`;
drop table if exists `3NF_students`;
drop table if exists `3NF_groups`;
drop table if exists `1NF_sqlCourse`;

CREATE table 1NF_sqlCourse(
    student_id INT primary key auto_increment, 
    student_snm VARCHAR(50) not null,
    student_nm VARCHAR(50) not null,
    group_num SMALLINT,
    student_mail VARCHAR(50),
    var_num TINYINT check (var_num >= 1 AND var_num <=6),
    groupLead_snm VARCHAR(50) not null,
    groupLead_nm VARCHAR(50) not null,
    groupLead_mail VARCHAR(50),
    misses TINYINT UNSIGNED default 0,
    hometask1 TINYINT UNSIGNED check (hometask1 >=0 AND hometask1 <=10),
    hometask2 TINYINT UNSIGNED check (hometask2 >=0 AND hometask2 <=10),
    hometask3 TINYINT UNSIGNED check (hometask3 >=0 AND hometask3 <=10),
    test1 TINYINT UNSIGNED check (test1 >=0 AND test1 <=10),
    test2 TINYINT UNSIGNED check (test2 >=0 AND test2 <=10),
    test3 TINYINT UNSIGNED check (test3 >=0 AND test3 <=10),
    final_test1 TINYINT UNSIGNED check (final_test1 >=0 AND final_test1 <=10),
    final_test2 TINYINT UNSIGNED check (final_test2 >=0 AND final_test2 <=10),
    final_test3 TINYINT UNSIGNED check (final_test3 >=0 AND final_test3 <=10),
    performance DOUBLE AS ((hometask1+hometask2+hometask3+test1+test2+test3+final_test1+final_test2+final_test3)/9),
    sql_ex TINYINT UNSIGNED check (sql_ex >=0 AND sql_ex <=80),
    lector_snm VARCHAR(50) not null default 'Kandrashevich',
    lector_nm VARCHAR(50) not null default 'Siarhei',
    lector_mail VARCHAR(50) default 'dklfj@mail.ru',
    lector_phone VARCHAR(20) default '+375293764812'
);

INSERT INTO 1NF_sqlCourse(student_snm,student_nm,group_num,student_mail,var_num,groupLead_snm,groupLead_nm,groupLead_mail,hometask1,hometask2,hometask3,test1,test2,test3,final_test1,final_test2,final_test3,sql_ex)
VALUES
('Borovik', 'Roman',9,'starmordar@gmail.com',1,'Sivenkov','Yegor','egor.sivenkov@gmail.com',4,6,7,8,5,6,10,7,7,35);

CREATE TABLE 3NF_lecturers(
	lecturer_id INT primary key auto_increment,
    lecturer_snm varchar(50) not null,
    lecturer_nm varchar(50) not null,
    lecturer_mail varchar(50) not null,
    lecturer_phone varchar(20) not null
);
INSERT INTO 3NF_lecturers(lecturer_snm,lecturer_nm,lecturer_mail,lecturer_phone) 
VALUES
('Kandrashevich','Siarhei','Siarhei_Kandrashevich@epam.com','+375291343207');

CREATE TABLE 3NF_courses(
	subject_id INT primary key auto_increment,
    title text,
    lecturer_id INT not null,
    lectures_mnt SMALLINT UNSIGNED,
    constraint FK_lecturer_id foreign key (lecturer_id)
    references 3NF_lecturers(lecturer_id)
);
INSERT INTO 3NF_courses(title,lecturer_id,lectures_mnt)
VALUE ('SQL',1,6);

CREATE TABLE 3NF_groups(
	id INT primary key auto_increment,
    groupLead_snm VARCHAR(50) not null,
    groupLead_nm VARCHAR(50) not null,
    groupLead_mail VARCHAR(50) not null,
    groupLead_phone VARCHAR(50) not null
);
INSERT INTO 3NF_groups(groupLead_snm,groupLead_nm,groupLead_mail,groupLead_phone)
VALUES ('Sivenkov','Yegor','siv.egor@gmail.com','+375449876543'),
	   ('Karchevskaya','Darya','darakarch@gmail.com','+375876567898');

CREATE TABLE 3NF_students(
	id INT primary key auto_increment,
    student_snm VARCHAR(50) not null,
    student_nm VARCHAR(50) not null,
    student_mail VARCHAR(50),
    var_num TINYINT not null,
    group_id INT not null,    
    misses TINYINT UNSIGNED default 0,
    constraint FK_group_id foreign key (group_id)
    references 3NF_groups(id)
);

INSERT INTO 3NF_students(student_snm,student_nm,student_mail,var_num,group_id,misses)
VALUES
('Azhevsky','Pavel','pazhevich@gmail.com',1,2,rand()*6),
('Borovik','Roman','starmordar@gmail.com',5,1,rand()*6);

CREATE TABLE 3NF_sqlMarks(
	student_id INT,
    ht1 INT not null,
    ht2 INT not null,
    ht3 INT not null,
    ts1 INT not null,
    ts2 INT not null,
    ts3 INT not null,
    fin1 INT not null,
    fin2 INT not null,
    fin3 INT not null,
    constraint FK_student_id foreign key (student_id)
    references 3NF_students(id)
);
INSERT INTO 3NF_sqlMarks(student_id,ht1,ht2,ht3,ts1,ts2,ts3,fin1,fin2,fin3)
VALUES
(1,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10),
(2,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10,rand()*10);

CREATE TABLE 3NF_studentPerformance(
	student_id2 INT not null,
    avg_sql double,
    sql_ex int,
    constraint FK_student_id2 foreign key (student_id2)
    references 3NF_students(id)
);

INSERT INTO 3NF_studentPerformance(student_id2, avg_sql,sql_ex) select m.student_id, (m.ht1+m.ht2+m.ht3+m.ts1+m.ts2+m.ts3+m.fin1+m.fin2+m.fin3)/9,Rand()*80 from 3NF_sqlMarks m;

/*Select * from 3NF_sqlMarks;

Select * from 3NF_studentPerformance;

select * from 3NF_students*/
