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
CREATE SEQUENCE posts_sequence START WITH 1 INCREMENT BY 1;

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
	location	varchar2(100),
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

insert into BitPosts values(posts_sequence.nextval, 'xie11a', 'sung', '상해가자~', 4, '아시아', '7', 'friend', SYSDATE, 1);
insert into BitTripDay values(1, '1_1day', '1일차 짱짱맨');
insert into BitTripDay values(1, '1_2day', '2일차 짱짱맨');
insert into BitTripDay values(1, '1_3day', '3일차 짱짱맨');
insert into BitDayLocation values('1_1day', '중국상하이 시푸둥 신구S1迎宾高速상하이 푸둥 국제공항', 1);
insert into BitDayLocation values('1_1day', '1일차 이곳2', 2);
insert into BitDayLocation values('1_2day', '2일차 이곳1', 2);
insert into BitDayLocation values('1_2day', '2일차 이곳2', 1);
insert into BitDayLocation values('1_3day', '3일차 이곳1', 1);


Alert table BitDayLocation modify(location varchar2(50));


alter table BITPOSTS add(location varchar2(100));
alter table BITPOSTS add(content varchar2(1000));

update BITPOSTS set location = '중국상하이 시푸둥 신구S1迎宾高速상하이 푸둥 국제공항';
update BITPOSTS set content = '상해에서 재밌게 놀껀디';





