MERGE INTO KR_NASA_TABLE_SEQ tgt
USING (
	select	'V_CHANGESETS' table_name, 39401 current_id, 39401 previous_id from dual
	) src
  ON (
    tgt.table_name = src.table_name
  )
WHEN NOT MATCHED THEN
INSERT (
   TABLE_NAME
  ,CURRENT_ID
  ,PREVIOUS_ID
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
)
VALUES
(
   src.table_name
  ,src.current_id
  ,src.previous_id
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
)
;