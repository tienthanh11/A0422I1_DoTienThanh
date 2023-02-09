create database final_exam_m4;
use final_exam_m4;

create table question_type(
	id integer primary key auto_increment,
    `name` varchar(50)
);

create table question_content(
	id integer primary key auto_increment,
    title  varchar(50),
    content varchar(50),
    answer varchar(50),
    id_question_type integer,
    date_create date,
    `status` boolean,
    foreign key(id_question_type) references question_type(id)
);
