CREATE TABLE RS_SVN_SRC_INFO (
    HEAD_REVISION           NUMBER(38,0),
    PROJECT_NAME            VARCHAR2(30),
	FILE_NAME				VARCHAR2(500)	NOT NULL,
	PATH				    VARCHAR2(2000),
	REVISION    			NUMBER(38,0),
	AUTHOR      			VARCHAR2(30),
	COMMIT_YMD              CHAR(8),
	COMMIT_HMS              CHAR(6),
	EXTENSION               VARCHAR2(30),
	TOROKUYMD				VARCHAR2(8),
	TOROKUHMS				VARCHAR2(6),
	TOROKUUSER				VARCHAR2(50),
	KOSINYMD				VARCHAR2(8),
	KOSINHMS				VARCHAR2(6),
	KOSINUSER				VARCHAR2(50),
	BIKO					VARCHAR2(250)
) 
;


ALTER TABLE RS_SVN_SRC_INFO ADD CONSTRAINT PK_RS_SVN_SRC_INFO PRIMARY KEY (PATH);
