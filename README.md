# BLUEPRINT.spring-boot-sample-data-jpa
#### fuse-rest-soap-infinispan-oracle

```
#rest #springboot #oracle #blueprint
```
#### REQUESTED SCENARIO

- Expose REST endpoint;
- JPA with oracle database;
- Simple CRUD operations.

#### STANDALONE LOCAL RUN

```
# download oracle-xe docker image
docker pull wnameless/oracle-xe-11g

# start oracle-xe
docker run -d -p 49161:1521 -e ORACLE_ALLOW_REMOTE=true wnameless/oracle-xe-11g
port: 49161
sid: xe
username: system
password: oracle

mvn spring-boot:run
```

Open: http://localhost:8080/

Check if database objects was created:

```
SELECT owner, table_name
     FROM all_tables where owner like 'CONVENIO';
   
SELECT * FROM CONVENIO.BENEFICIARIO;

-- insert a record for testing purposes.
INSERT INTO CONVENIO.BENEFICIARIO
  (handle,nu_contrato,nu_cpf,dt_adesao,email,nome) VALUES (
   CONVENIO.BENEFICIARIO_SEQ.nextVal,'100789','11111111111',sysdate,'raphael.alex@gmail.com','raphael abreu');
```

### APPENDIX A
#### ORACLE USER (LOCAL ENVIRONMENT W/ DOCKER)

```
CREATE USER convenio IDENTIFIED BY convenio;

GRANT CREATE SESSION TO convenio WITH ADMIN OPTION;

GRANT UNLIMITED TABLESPACE TO convenio;

GRANT CONNECT,RESOURCE,DBA TO convenio;

ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED; -- SET IT TO UNLIMITED

ALTER PROFILE DEFAULT LIMIT COMPOSITE_LIMIT UNLIMITED PASSWORD_LIFE_TIME UNLIMITED PASSWORD_REUSE_TIME UNLIMITED PASSWORD_REUSE_MAX UNLIMITED PASSWORD_VERIFY_FUNCTION NULL PASSWORD_LOCK_TIME UNLIMITED PASSWORD_GRACE_TIME UNLIMITED FAILED_LOGIN_ATTEMPTS UNLIMITED;

ALTER USER convenio ACCOUNT UNLOCK;

-- execute after creating the table
GRANT SELECT, INSERT, UPDATE, DELETE on convenio.BENEFICIARIO to convenio;
```

port: 49161<br>
sid: xe<br>
username: convenio<br>
password: convenio<br>

### RELEASE NOTES

#### 1.0.0
 - First release
 

### LICENSE

Apache License Version 2.0

