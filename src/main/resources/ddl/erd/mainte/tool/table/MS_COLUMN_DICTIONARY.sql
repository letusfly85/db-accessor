CREATE TABLE MS_COLUMN_DICTIONARY (
	 DICT_COLUMN_ID			NUMBER(38,0)
	,PHYSICAL_COLUMN_NAME	VARCHAR2(30)
	,DATA_TYPE				VARCHAR2(38)
	,DATA_LENGTH			VARCHAR2(38)
	,DATA_PRECISION			VARCHAR2(38)
	,DATA_DEFAULT			VARCHAR2(38)
	,ENTITY_FIELD_NAME		VARCHAR2(30)
	,ENTITY_FIELD_TYPE		VARCHAR2(30)
	,TOROKUYMD				VARCHAR2(8)
	,TOROKUHMS				VARCHAR2(6)
	,TOROKUUSER				VARCHAR2(50)
	,KOSINYMD				VARCHAR2(8)
	,KOSINHMS				VARCHAR2(6)
	,KOSINUSER				VARCHAR2(50)
	,BIKO					VARCHAR2(250)
)
;

ALTER TABLE MS_COLUMN_DICTIONARY ADD CONSTRAINT PK_MS_COLUMN_DICTIONARY PRIMARY KEY (PHYSICAL_COLUMN_NAME);

