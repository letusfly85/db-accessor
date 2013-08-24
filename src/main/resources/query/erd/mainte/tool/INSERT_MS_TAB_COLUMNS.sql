INSERT INTO MS_TAB_COLUMNS
(
		TAB_DEF_ID
	,	TABLE_ID
	,	REVISION
	,	LOGICAL_TABLE_NAME
	,	PHYSICAL_TABLE_NAME
	,	TABLE_COMMENT
	,	COLUMN_ID
	,	LOGICAL_COLUMN_NAME
	,	PHYSICAL_COLUMN_NAME
	,	COLUMN_COMMENT
	,	DATA_TYPE
	,	DATA_LENGTH
	,	DATA_PRECISION
	,	DATA_DEFAULT
	,	PK_FLG
	,	NULLABLE
	,	TRKM_STATUS
	,	TICKET_NUMBER
	,	EXISTS_FLG
	,	TOROKUYMD
	,	TOROKUHMS
	,	TOROKUUSER
	,	KOSINYMD
	,	KOSINHMS
	,	KOSINUSER
) VALUES (
	 ?	/* 1	TAB_DEF_ID */
	,?	/* 2	TABLE_ID */
	,?	/* 3	REVISION */
	,?	/* 4	LOGICAL_TABLE_NAME */
	,?	/* 5	PHYSICAL_TABLE_NAME */
	,?	/* 6	TABLE_COMMENT */
	,?	/* 7	COLUMN_ID */
	,?	/* 8	LOGICAL_COLUMN_NAME */
	,?	/* 9	PHYSICAL_COLUMN_NAME */
	,?	/* 10	COLUMN_COMMENT */
	,?	/* 11	DATA_TYPE */
	,?	/* 12	DATA_LENGTH */
	,?	/* 13	DATA_PRECISION */
	,?	/* 14	DATA_DEFAULT */
	,?	/* 15	PK_FLG */
	,?	/* 16	NULLABLE */
	,?	/* 17	TRKM_STATUS */
	,?	/* 18	TICKET_NUMBER */
	,?	/* 19	EXISTS_FLG */
    ,TO_CHAR(SYSDATE,'YYYYMMDD')
    ,TO_CHAR(SYSDATE,'HH24MISS')
    ,SYS_CONTEXT('USERENV','MODULE')
    ,TO_CHAR(SYSDATE,'YYYYMMDD')
    ,TO_CHAR(SYSDATE,'HH24MISS')
    ,SYS_CONTEXT('USERENV','MODULE')
)