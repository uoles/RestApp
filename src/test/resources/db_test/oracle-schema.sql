-- Create tablespace
CREATE TABLESPACE USERS_TEST
  DATAFILE 'USERS_TEST.dat'
    SIZE 10M
    REUSE
    AUTOEXTEND ON NEXT 10M MAXSIZE 200M;

-- Create the user
CREATE USER TEST IDENTIFIED BY test
    DEFAULT TABLESPACE USERS_TEST
  TEMPORARY TABLESPACE TEMP;

ALTER USER TEST quota unlimited on USERS_TEST;

-- Grant/Revoke system privileges
grant create session to TEST;
grant alter any table to TEST;
grant comment any table to TEST;
grant create any index to TEST;
grant create any indextype to TEST;
grant create any table to TEST;
grant create any view to TEST;
grant create session to TEST;
grant create table to TEST;
grant create view to TEST;
grant delete any table to TEST;
grant drop any table to TEST;
grant drop any view to TEST;
grant insert any table to TEST;
grant select any dictionary to TEST;
grant select any table to TEST;
grant under any table to TEST;
grant update any table to TEST;
grant comment any table to TEST;