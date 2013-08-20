INSERT INTO MS_INDEXES
(
		INDEX_NAME
	,	REVISION
	,	TABLE_ID
	,	TAB_DEF_ID
	,	TICKET_NUMBER
	,	UNIQUENESS
	,	FUNCTION
	,	BITMAP
	,	REVERSE
	,	KEY_COMPRESS
	,	COMMIT_FLG
	,	FUNCTION_FOMULA
	,	LOCALITY
	,	PARTITIONED
	,	STATUS
	,	PK_INDEX_FLG
	,	TOROKUYMD
	,	TOROKUHMS
	,	TOROKUUSER
	,	KOSINYMD
	,	KOSINHMS
	,	KOSINUSER
)
VALUES
(
	 ?	/* 1	INDEX_NAME */
	,?	/* 2	REVISION */
	,?	/* 3	TABLE_ID */
	,?	/* 4	TAB_DEF_ID */
	,?	/* 5	TICKET_NUMBER */
	,?	/* 6	UNIQUENESS */
	,?	/* 7	FUNCTION */
	,?	/* 8	BITMAP */
	,?	/* 9	REVERSE */
	,?	/* 10	KEY_COMPRESS */
	,?	/* 11	COMMIT_FLG */
	,?	/* 12	FUNCTION_FOMULA */
	,?	/* 13	LOCALITY */
	,?	/* 14	PARTITIONED */
	,?	/* 15	STATUS */
	,?	/* 16	PK_INDEX_FLG */
    ,TO_CHAR(SYSDATE,'YYYYMMDD')
    ,TO_CHAR(SYSDATE,'HH24MISS')
    ,SYS_CONTEXT('USERENV','MODULE')
    ,TO_CHAR(SYSDATE,'YYYYMMDD')
    ,TO_CHAR(SYSDATE,'HH24MISS')
    ,SYS_CONTEXT('USERENV','MODULE')
)