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

create table question_set (
  id                        bigint not null,
  name                      varchar(255),
  no_of_trial               integer,
  start_date                timestamp,
  expire_date               timestamp,
  constraint pk_question_set primary key (id))
;

create table trial (
  id                        bigint not null,
  constraint pk_trial primary key (id))
;

create sequence question_seq;

create sequence question_set_seq;

create sequence trial_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists question;

drop table if exists question_set;

drop table if exists trial;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists question_seq;

drop sequence if exists question_set_seq;

drop sequence if exists trial_seq;

