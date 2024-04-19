-- food
CREATE DATABASE foodDB;

USE foodDB;

CREATE TABLE tbl_food(
	f_code	BIGINT auto_increment	PRIMARY KEY,
	f_sort	VARCHAR(50)		,
	f_foodname	VARCHAR(50)		
);

CREATE TABLE tbl_user(
	m_id	VARCHAR(20)		PRIMARY KEY,
	m_password	VARCHAR(125)	NOT NULL	,
	m_email	VARCHAR(30)		,
	m_name	VARCHAR(10)	NOT NULL,	
	m_role	VARCHAR(5)		,
	m_tel	VARCHAR(15)			
);
DROP TABLE tbl_user;

DROP TABLE tbl_food;

DROP database foodDB;


CREATE TABLE tbl_fooduser(
	f_fcode	BIGINT,
	f_fuserid	VARCHAR(20),
		primary key(f_fcode,f_fuserid)
);

ALTER TABLE tbl_fooduser
ADD CONSTRAINT fk_f FOREIGN KEY (f_fcode)
REFERENCES tbl_food(f_code);

ALTER TABLE tbl_fooduser
ADD CONSTRAINT fk_u FOREIGN KEY (f_fuserid)
REFERENCES tbl_user(m_id);


SELECT * FROM tbl_user;