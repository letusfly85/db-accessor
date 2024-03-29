CREATE TABLE TP_TICKET_NUMBERS4RELEASE (
	RELEASE_ID			NUMBER(38,0),
	TRKM_ID				NUMBER(38,0),
	TICKET_NUMBER		NUMBER(38,0),
	TOROKUYMD			VARCHAR2(8),
	TOROKUHMS			VARCHAR2(6),
	TOROKUUSER			VARCHAR2(50),
	KOSINYMD			VARCHAR2(8),
	KOSINHMS			VARCHAR2(6),
	KOSINUSER			VARCHAR2(50),
	BIKO				VARCHAR2(250)
)
;

ALTER TABLE TP_TICKET_NUMBERS4RELEASE ADD CONSTRAINT PK_TP_TICKET_NUMBERS4RELEASE PRIMARY KEY  (RELEASE_ID, TICKET_NUMBER)
;
