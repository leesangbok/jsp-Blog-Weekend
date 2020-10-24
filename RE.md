## 블로그 프로젝트

### 데이터베이스 테이블 스키마

```sql
create table user(
	id int primary key auto_increment,
    username varchar(45)not null unique,
    password varchar(15)not null,
    email varchar(100) not null,
    address varchar(100)not null,
    createDate timestamp
) engine=InnoDB default charset=utf8;


CREATE TABLE post(
	id int primary key auto_increment,
    userId int,
    title varchar(100) not null,
    content longtext,
    readCount int,
    createDate timestamp,
    foreign key (userId) references user (id)
)engine=InnoDB default charset=utf8;

CREATE TABLE comment(
	id int primary key,
    userId int,
    postId int,
    content varchar(300) not null,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null,
    foreign key (postId) references post (id) on delete cascade -- cascade 라는 것은 자동삭제
)engine=InnoDB default charset=utf8;

```