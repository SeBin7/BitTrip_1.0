create table BitUser(
	user_id 	varchar2(8) CONSTRAINT PK_BitUser primary key,
	name		varchar2(20),
	email		varchar2(30),
	password 	varchar2(8),
	gender		varchar2(1)
);

drop table BitUser;
select * from BitUser;

create table BitPosts(
	post_id		number(5) CONSTRAINT PK_BitPosts primary key,
	user_id 	varchar2(8) CONSTRAINT FK_BitPosts references BitUser(user_id),
	title		varchar2(20),
	trip_date	number(2),
	create_date date default SYSDATE,
	count			number(5) default 0
);

alter table BitPosts ADD CONSTRAINT FK_BitPosts foreign key(user_id) references BitUser(user_id);
drop table BitPosts;
select * from BitPosts;

create table BitTripDay(
	post_id		number(5) CONSTRAINT FK_BitTripDay references BitPosts(post_id),
	post_id_day	varchar2(8) CONSTRAINT PK_BitTripDay primary key,
	content		varchar2(1000)
);


create table BitDayLocation(
	post_id_day	varchar2(8) CONSTRAINT FK_BitDayLocation references BitTripDay(post_id_day),
	location	varchar2(8),
	sort		number(5)
);

drop table BitDayLocation;

create table BitPostComment(
	post_id 	number(5) CONSTRAINT FK_BitPostComment references BitPosts(post_id),
	user_id 	varchar2(8),
	content		varchar2(500),
	create_date date default SYSDATE
);


create table BitPostRecommend(
	post_id 	number(5) CONSTRAINT FK_BitPostRecommend references BitPosts(post_id),
	user_id 	varchar2(8)
);
