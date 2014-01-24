# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table experiment_schedule (
  id                        bigint not null,
  name                      varchar(255),
  no_of_trial               integer,
  start_date                timestamp,
  expire_date               timestamp,
  constraint pk_experiment_schedule primary key (id))
;

create table question (
  id                        bigint not null,
  first_word                varchar(255),
  second_word               varchar(255),
  third_word                varchar(255),
  constraint pk_question primary key (id))
;

create table trial (
  id                        bigint not null,
  trigram_type              integer,
  trigram_language          integer,
  experiment_schedule_id    bigint,
  constraint ck_trial_trigram_type check (trigram_type in (0,1)),
  constraint ck_trial_trigram_language check (trigram_language in (0,1)),
  constraint pk_trial primary key (id))
;

create sequence experiment_schedule_seq;

create sequence question_seq;

create sequence trial_seq;

alter table trial add constraint fk_trial_experimentSchedule_1 foreign key (experiment_schedule_id) references experiment_schedule (id) on delete restrict on update restrict;
create index ix_trial_experimentSchedule_1 on trial (experiment_schedule_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists experiment_schedule;

drop table if exists question;

drop table if exists trial;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists experiment_schedule_seq;

drop sequence if exists question_seq;

drop sequence if exists trial_seq;

