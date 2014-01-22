# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table question (
  id                        bigint not null,
  first_word                varchar(255),
  second_word               varchar(255),
  third_word                varchar(255),
  constraint pk_question primary key (id))
;

create table user (
  id                        varchar(255) not null,
  password                  varchar(255),
  status                    integer,
  constraint ck_user_status check (status in (0,1,2,3)),
  constraint pk_user primary key (id))
;

create sequence question_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists question;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists question_seq;

drop sequence if exists user_seq;

