INSERT INTO RR_INDEXES
(
   INDEX_NAME
  ,REVISION_AF
  ,REVISION_BF
  ,TABLE_ID
  ,TAB_DEF_ID
  ,TICKET_NUMBER
  ,UNIQUENESS
  ,FUNCTION
  ,BITMAP
  ,REVERSE
  ,KEY_COMPRESS
  ,COMMIT_FLG
  ,FUNCTION_FOMULA
  ,LOCALITY
  ,PARTITIONED
  ,STATUS
  ,PK_INDEX_FLG
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
)
VALUES
(
   ? /* 1, INDEX_NAME */
  ,? /* 2, REVISION_AF */
  ,? /* 3, REVISION_BF */
  ,? /* 4, TABLE_ID */
  ,? /* 5, TAB_DEF_ID */
  ,? /* 6, TICKET_NUMBER */
  ,? /* 7, UNIQUENESS */
  ,? /* 8, FUNCTION */
  ,? /* 9, BITMAP */
  ,? /* 10, REVERSE */
  ,? /* 11, KEY_COMPRESS */
  ,? /* 12, COMMIT_FLG */
  ,? /* 13, FUNCTION_FOMULA */
  ,? /* 14, LOCALITY */
  ,? /* 15, PARTITIONED */
  ,? /* 16, STATUS */
  ,? /* 17, PK_INDEX_FLG */
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
)