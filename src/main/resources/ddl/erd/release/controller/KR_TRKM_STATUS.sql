CREATE TABLE KR_TRKM_STATUS (
	TRKM_ID				NUMBER(38,0),
	TRKM_STATUS			CHAR(1),
	CURRENT_FLG         CHAR(1) DEFAULT '0',
	TRKM_YMD			CHAR(8),
	TRKM_HHMISS			CHAR(6),
	TOROKUYMD			VARCHAR2(8),
	TOROKUHMS			VARCHAR2(6),
	TOROKUUSER			VARCHAR2(50),
	KOSINYMD			VARCHAR2(8),
	KOSINHMS			VARCHAR2(6),
	KOSINUSER			VARCHAR2(50)
)
/

ALTER TABLE KR_TRKM_STATUS ADD CONSTRAINT PK_KR_TRKM_STATUS PRIMARY KEY (TRKM_ID)
/
