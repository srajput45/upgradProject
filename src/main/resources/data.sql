DROP TABLE IF EXISTS USERS CASCADE;
CREATE TABLE IF NOT EXISTS USERS(id SERIAL, uuid VARCHAR(200) NOT NULL ,firstName VARCHAR(30) NOT NULL , lastName VARCHAR(30) NOT NULL ,userName VARCHAR(30) UNIQUE NOT NULL,  email VARCHAR(50) UNIQUE NOT NULL ,password VARCHAR(255) NOT NULL, salt VARCHAR(200) NOT NULL ,country VARCHAR(30) ,aboutMe VARCHAR(50),dob VARCHAR(30), role VARCHAR(30),contactNumber VARCHAR(30), PRIMARY KEY (id));
INSERT INTO users(
	id, uuid, firstname, lastname, username, email, password, salt, country, aboutme, dob, role, contactnumber)
	VALUES (1024,'rdtrdtdyt','Abhi','Mahajan','abhi','a@gmail.com','507FF5FED1CAC746','8Xt6jxoCI3MWsVaKY/1ySAp2qzlb2Z7P89+vDrb1o6U=', 'India' ,'I am @ UpGrad' ,'22-10-1995' , 'admin' , '1222333333' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country, aboutme, dob, role, contactnumber)
    	VALUES (1025,'database_uuid','database_firstname','database_lastname','database_username','database_email','database_password','database_salt', 'database_country' ,'database_aboutme' ,'database_dob' , 'admin' , 'database_contactnumber' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country, aboutme, dob, role, contactnumber)
     VALUES (1026,'database_uuid1','database_firstname1','database_lastname1','database_username1','database_email1','database_password1','database_salt1', 'database_country1' ,'database_aboutme1' ,'database_dob1' , 'nonadmin' , 'database_contactnumber1' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country, aboutme, dob, role, contactnumber)
    VALUES (1027,'database_uuid2','database_firstname2','database_lastname2','database_username2','database_email2','database_password2','database_salt2', 'database_country2' ,'database_aboutme2' ,'database_dob2' , 'nonadmin' , 'database_contactnumber2' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country, aboutme, dob, role, contactnumber)
    VALUES (1028,'database_uuid3','database_firstname3','database_lastname3','database_username3','database_email3','database_password3','database_salt3', 'database_country3' ,'database_aboutme3' ,'database_dob3' , 'nonadmin' , 'database_contactnumber3' );
INSERT INTO users(id, uuid, firstname, lastname, username, email, password, salt, country, aboutme, dob, role, contactnumber)
    VALUES (1029,'database_uuid4','database_firstname4','database_lastname4','database_username4','database_email4','database_password4','database_salt4', 'database_country4' ,'database_aboutme4' ,'database_dob4' , 'nonadmin' , 'database_contactnumber4' );

--USER_AUTH table is created to store the login information of all the users
DROP TABLE IF EXISTS USER_AUTH CASCADE;
CREATE TABLE IF NOT EXISTS USER_AUTH(
	ID BIGSERIAL PRIMARY KEY,
	uuid VARCHAR(200) NOT NULL,
	USER_ID INTEGER NOT NULL,
	ACCESS_TOKEN VARCHAR(500) NOT NULL,
	EXPIRES_AT TIMESTAMP NOT NULL,
	LOGIN_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	LOGOUT_AT TIMESTAMP NULL
);

ALTER TABLE USER_AUTH ADD CONSTRAINT FK_USER_AUTH_USER_ID FOREIGN KEY(USER_ID) REFERENCES USERS(ID) ON DELETE CASCADE ;

--QUESTION table is created to store the questions related information posted by any user in the Application
DROP TABLE IF EXISTS QUESTION CASCADE;
CREATE TABLE IF NOT EXISTS QUESTION(id SERIAL,uuid VARCHAR(200) NOT NULL, content VARCHAR(500) NOT NULL, date TIMESTAMP NOT NULL , user_id INTEGER NOT NULL, PRIMARY KEY(id), FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE);


--ANSWER table is created to store the answers related information in reply to any question posted in the Application
DROP TABLE IF EXISTS ANSWER CASCADE;
CREATE TABLE IF NOT EXISTS ANSWER(id SERIAL,uuid VARCHAR(200) NOT NULL, ans VARCHAR(255) NOT NULL,date TIMESTAMP NOT NULL , user_id INTEGER NOT NULL, question_id INTEGER NOT NULL , PRIMARY KEY(id), FOREIGN KEY (user_id) REFERENCES USERS(id) ON DELETE CASCADE, FOREIGN KEY (question_id) REFERENCES QUESTION(id) ON DELETE CASCADE);
