-- begin DEALERAPP_CAR_CONFIGURATION
create table DEALERAPP_CAR_CONFIGURATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRICE integer,
    NAME varchar(255) not null,
    CAR_TYPE integer,
    COMMENT varchar(255),
    CAR_BRAND_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end DEALERAPP_CAR_CONFIGURATION
-- begin DEALERAPP_REQUEST
create table DEALERAPP_REQUEST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CAR_ID varchar(36),
    CONTRACTOR_ID varchar(36),
    PAID boolean,
    MANAGER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end DEALERAPP_REQUEST
-- begin DEALERAPP_CAR_BRAND
create table DEALERAPP_CAR_BRAND (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CAR_MAKER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end DEALERAPP_CAR_BRAND
-- begin DEALERAPP_CAR
create table DEALERAPP_CAR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CAR_MAKER_ID varchar(36) not null,
    CAR_BRAND_ID varchar(36) not null,
    CAR_CONFIGURATION_ID varchar(36) not null,
    YEAR integer not null,
    PRICE integer not null,
    --
    primary key (ID)
)^
-- end DEALERAPP_CAR
-- begin DEALERAPP_CONTRACTOR
create table DEALERAPP_CONTRACTOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    PHONE varchar(7),
    --
    primary key (ID)
)^
-- end DEALERAPP_CONTRACTOR
-- begin DEALERAPP_COMPANY
create table DEALERAPP_COMPANY (
    ID varchar(36) not null,
    --
    TITLE varchar(255),
    INN varchar(12),
    ADDRESS longvarchar,
    --
    primary key (ID)
)^
-- end DEALERAPP_COMPANY
-- begin DEALERAPP_PERSON
create table DEALERAPP_PERSON (
    ID varchar(36) not null,
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end DEALERAPP_PERSON
-- begin DEALERAPP_CAR_MAKER
create table DEALERAPP_CAR_MAKER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    --
    COUNTRY_ID varchar(36),
    --
    primary key (ID)
)^
-- end DEALERAPP_CAR_MAKER
-- begin DEALERAPP_COLOR
create table DEALERAPP_COLOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    --
    primary key (ID)
)^
-- end DEALERAPP_COLOR
-- begin DEALERAPP_COUNTRY
create table DEALERAPP_COUNTRY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    --
    primary key (ID)
)^
-- end DEALERAPP_COUNTRY
-- begin SEC_USER
alter table SEC_USER add column COUNTRY_ID varchar(36) ^
alter table SEC_USER add column DTYPE varchar(100) ^
update SEC_USER set DTYPE = 'dealerapp_Manager' where DTYPE is null ^
-- end SEC_USER
