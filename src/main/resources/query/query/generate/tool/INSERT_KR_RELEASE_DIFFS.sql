INSERT INTO KR_RELEASE_DIFFS
(
   TAG_NAME
  ,FROM_REVISION
  ,TO_REVISION
  ,HEADER_FLG
  ,TARGET_ENV_NAME
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
)
VALUES
(
   ? /* 1, TAG_NAME */
  ,? /* 2, FROM_REVISION */
  ,? /* 3, TO_REVISION */
  ,? /* 4, HEADER_FLG */
  ,? /* 5, TARGET_ENV_NAME */
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
)