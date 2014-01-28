CREATE TABLE MS_TABLES (
	TRKM_ID					NUMBER(38,0)		NOT NULL,
	TAB_DEF_ID				NUMBER(38,0)		NOT NULL,
	TABLE_ID				NUMBER(38,0)		NOT NULL,
    SERVICE_NAME            VARCHAR2(30),
    SUBSYSTEM_NAME          VARCHAR2(30),
	REVISION				NUMBER(38,0)		NOT NULL,
	LOGICAL_TABLE_TAG		VARCHAR2(30),
	LOGICAL_TABLE_NAME		VARCHAR2(200)		NOT NULL,
	PHYSICAL_TABLE_NAME		VARCHAR2(30)		NOT NULL,
	TRKM_STATUS				CHAR(1),
	TABLE_COMMENT			VARCHAR2(300),
	SEGOSEI_CHECK_STATUS	CHAR(1),
    TICKET_NUMBER           NUMBER(38,0),
    EXISTS_FLG              CHAR(1),
    TOROKUYMD			    VARCHAR2(8),
    TOROKUHMS			    VARCHAR2(6),
    TOROKUUSER			    VARCHAR2(50),
    KOSINYMD			    VARCHAR2(8),
    KOSINHMS			    VARCHAR2(6),
    KOSINUSER			    VARCHAR2(50),
    BIKO				    VARCHAR2(250)
)
;

ALTER TABLE MS_TABLES ADD CONSTRAINT PK_MS_TABLES PRIMARY KEY  (PHYSICAL_TABLE_NAME)
;
