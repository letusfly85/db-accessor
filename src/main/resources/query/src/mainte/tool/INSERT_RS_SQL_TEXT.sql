INSERT INTO RS_SQL_TEXT
(
   HEAD_REVISION
  ,PROJECT_NAME
  ,FILE_NAME
  ,PATH
  ,PERSISTER_NAME
  ,LINE
  ,TEXT
  ,REVISION
  ,AUTHOR
  ,COMMIT_YMD
  ,COMMIT_HMS
  ,EXTENSION
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
)
VALUES
(
   ? /* 1, HEAD_REVISION */
  ,? /* 2, PROJECT_NAME */
  ,? /* 3, FILE_NAME */
  ,? /* 4, PATH */
  ,? /* 5, PERSISTER_NAME */
  ,? /* 6, LINE */
  ,? /* 7, TEXT */
  ,? /* 8, REVISION */
  ,? /* 9, AUTHOR */
  ,? /* 10, COMMIT_YMD */
  ,? /* 11, COMMIT_HMS */
  ,? /* 12, EXTENSION */
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
)