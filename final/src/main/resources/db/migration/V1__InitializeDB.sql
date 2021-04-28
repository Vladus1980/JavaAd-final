create table user (
	user_id integer not null auto_increment,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	email varchar(255) not null unique,
	password varchar(255) not null,
	active bit,
	activation_code varchar(255),
	primary key (user_id)
) engine=MyISAM;

create table accsses_level (
	user_id integer not null,
	access_levels varchar(255)
) engine=MyISAM;

create table faculty (
	faculty_id integer not null auto_increment,
	title varchar(255) not null,
	primary key (faculty_id)
) engine=MyISAM;

create table speciality (
	speciality_id integer not null auto_increment,
	title varchar(255) not null,
	faculty_id integer not null,
	enrollment_plan integer not null,
	primary key (speciality_id)
) engine=MyISAM;

create table subject (
	subject_id integer not null auto_increment,
	title varchar(255) not null,
	primary key (subject_id)
) engine=MyISAM;

create table subject_faculty (
	faculty_id integer not null,
	subject_id integer not null,
	primary key (faculty_id, subject_id)
) engine=MyISAM;

create table entrant (
	user_id integer not null,
	birth_date date,
	city varchar(255),
	school varchar(255),
	primary key (user_id)
) engine=MyISAM;

create table speciality_entrant (
	user_id integer not null,
	speciality_id integer not null,
	primary key (user_id, speciality_id)
) engine=MyISAM;

create table entration (
	entration_id integer not null auto_increment,
	entrant_id integer not null,
	speciality_id integer not null,
	att_mark integer not null,
	primary key (entration_id)
) engine=MyISAM;

create table zno_marks (
	entration_entration_id integer not null,
	zno_marks_key integer not null,
	zno_marks integer not null,
	primary key (entration_entration_id, zno_marks_key)
) engine=MyISAM;

create table rating_list (
	entration_id integer not null,
	total_mark double precision,
	accepted bit,
	primary key (entration_id)
) engine=MyISAM;

alter table accsses_level
	add constraint access_level__user__fk
	foreign key (user_id) references user (user_id);

alter table speciality
	add constraint speciality__faculty__fk
	foreign key (faculty_id) references faculty (faculty_id);

alter table subject_faculty
	add constraint subject_faculty__subject__fk
	foreign key (subject_id) references subject (subject_id);

alter table subject_faculty
	add constraint subject_faculty__faculty__fk
	foreign key (faculty_id) references faculty (faculty_id);

alter table entrant
	add constraint entrant__user__fk
	foreign key (user_id) references user (user_id);

alter table speciality_entrant
	add constraint speciality_entrant__speciality__fk
	foreign key (speciality_id) references speciality (speciality_id);

alter table speciality_entrant
	add constraint speciality_entrant__entrant__fk
	foreign key (user_id) references entrant (user_id);

alter table entration
	add constraint entration__entrant__fk
	foreign key (entrant_id) references entrant (user_id);

alter table entration
	add constraint entration__speciality__fk
	foreign key (speciality_id) references speciality (speciality_id);

alter table zno_marks
	add constraint zno_marks__entration__fk
	foreign key (entration_entration_id) references entration (entration_id);

alter table zno_marks
	add constraint zno_marks__subject__fk
	foreign key (zno_marks_key) references subject (subject_id);

alter table rating_list
	add constraint rating_list__entration__fk
	foreign key (entration_id) references entration (entration_id); 