DROP TABLE IF EXISTS `time_record`;
DROP TABLE IF EXISTS `work_group`;
DROP TABLE IF EXISTS `time_range`;
DROP TABLE IF EXISTS `work_day_type`;
DROP TABLE IF EXISTS `settlement`;
DROP TABLE IF EXISTS `company`;
DROP TABLE IF EXISTS `work_group_record`;
DROP TABLE IF EXISTS `distribution`;
DROP TABLE IF EXISTS `user`;

# 출퇴근기록
CREATE TABLE `time_record`
(
    `time_record_id` bigint auto_increment NOT NULL,
    `user_id`        bigint                NOT NULL,
    `date`           date                  NOT NULL,
    `start_work`     datetime              NULL,
    `leave_work`     datetime              NULL,
    `work_state`     varchar(10)           NOT NULL,
    `date_created`   datetime              NOT NULL,
    `date_updated`   datetime              NOT NULL,
    PRIMARY KEY (time_record_id)
);

# 근로제
CREATE TABLE `work_group`
(
    `work_group_id` bigint auto_increment NOT NULL,
    `name`          varchar(50)           NOT NULL,
    `type`          char(2)               NOT NULL,
    `date_created`  datetime              NOT NULL,
    `date_updated`  datetime              NOT NULL,
    `date_deleted`  datetime              NULL,
    `is_deleted`    boolean               NOT NULL,
    `is_on`         boolean               NOT NULL,
    `company_id`    bigint                NOT NULL,
    PRIMARY KEY (work_group_id)
);

# 시간범위
CREATE TABLE `time_range`
(
    `time_range_id` bigint auto_increment NOT NULL,
    `type`          char(2)               NOT NULL,
    `start`         time                  NOT NULL,
    `end`           time                  NOT NULL,
    `work_group_id` bigint                NOT NULL,
    PRIMARY KEY (time_range_id)
);

# 근무요일타입
CREATE TABLE `work_day_type`
(
    `work_day_type_id` bigint auto_increment NOT NULL,
    `mon`              char(2)               NOT NULL,
    `tue`              char(2)               NOT NULL,
    `wed`              char(2)               NOT NULL,
    `thu`              char(2)               NOT NULL,
    `fri`              char(2)               NOT NULL,
    `sat`              char(2)               NOT NULL,
    `sun`              char(2)               NOT NULL,
    `work_group_id`    bigint                NOT NULL,
    PRIMARY KEY (work_day_type_id)
);

# 정산
CREATE TABLE `settlement`
(
    `settlement_id`        bigint auto_increment NOT NULL,
    `user_id`              bigint                NOT NULL,
    `date`                 date                  NOT NULL,
    `start_time`           time                  NULL,
    `end_time`             time                  NULL,
    `working_time`         time                  NOT NULL,
    `over_time`            time                  NOT NULL,
    `day_type`             char(2)               NULL,
    `date_created`         datetime              NOT NULL,
    `date_updated`         datetime              NOT NULL,
    `work_group_record_id` bigint                NOT NULL,
    PRIMARY KEY (settlement_id)
);

# 회사
CREATE TABLE `company`
(
    `company_id`   bigint auto_increment NOT NULL,
    `name`         varchar(50)           NOT NULL,
    `code`         varchar(255)          NOT NULL,
    `logo_url`     varchar(255)          NULL,
    `date_created` datetime              NOT NULL,
    `date_updated` datetime              NOT NULL,
    `date_deleted` datetime              NULL,
    `is_deleted`   boolean               NOT NULL,
    PRIMARY KEY (company_id)
);

# 근로제 이력
CREATE TABLE `work_group_record`
(
    `work_group_record_id` bigint auto_increment NOT NULL,
    `date`                 datetime              NOT NULL,
    `work_group_name`      varchar(50)           NOT NULL,
    `work_group_type`      char(2)               NOT NULL,
    `time_range_type`      varchar(255)          NOT NULL,
    `start`                varchar(255)          NOT NULL,
    `end`                  varchar(255)          NOT NULL,
    `mon`                  char(2)               NOT NULL,
    `tue`                  char(2)               NOT NULL,
    `wed`                  char(2)               NOT NULL,
    `thu`                  char(2)               NOT NULL,
    `fri`                  char(2)               NOT NULL,
    `sat`                  char(2)               NOT NULL,
    `sun`                  char(2)               NOT NULL,
    `work_group_id`        bigint                NOT NULL,
    PRIMARY KEY (work_group_record_id)
);

# 배포
CREATE TABLE `distribution`
(
    `distribution_id` bigint auto_increment NOT NULL,
    `date`            datetime              NOT NULL,
    `user_id`         bigint                NOT NULL,
    `work_group_id`   bigint                NOT NULL,
    PRIMARY KEY (distribution_id)
);

# 회원
CREATE TABLE `user`
(
    `user_id`      bigint auto_increment NOT NULL,
    `user_code`    char(9)               NOT NULL,
    `name`         varchar(50)           NOT NULL,
    `email`        varchar(100)          NOT NULL,
    `password`     varchar(255)          NOT NULL,
    `phone`        varchar(20)           NOT NULL,
    `hire_date`    date                  NULL,
    `birthday`     date                  NOT NULL,
    `dept`         varchar(50)           NULL,
    `position`     varchar(20)           NULL,
    `distribution` boolean               NOT NULL,
    `date_created` datetime              NOT NULL,
    `date_updated` datetime              NOT NULL,
    `date_deleted` datetime              NULL,
    `is_deleted`   boolean               NOT NULL,
    `role`         varchar(10)           NOT NULL,
    `company_id`   bigint                NOT NULL,
    PRIMARY KEY (user_id)
);
