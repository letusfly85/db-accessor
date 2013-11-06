CREATE TABLE RS_SQL_CDATA (
	    HEAD_REVISION           NUMBER(38,0),
        PROJECT_NAME            VARCHAR2(30),
    	FILE_NAME				VARCHAR2(500)	NOT NULL,
    	PATH				    VARCHAR2(2000),
        PERSISTER_NAME			VARCHAR2(100)		DEFAULT 'NONE',
        LINE					NUMBER(38,0),
        TEXT					VARCHAR2(4000),
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

--ALTER TABLE RS_SQL_CDATA ADD CONSTRAINT PK_RS_SQL_CDATA PRIMARY KEY  (FILE_PATH,PERSISTER_NAME,LINE)
--;