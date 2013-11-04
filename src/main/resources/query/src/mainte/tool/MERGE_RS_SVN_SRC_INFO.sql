MERGE INTO RS_SVN_SRC_INFO
USING DUAL
  ON (
    RS_SVN_SRC_INFO.PATH = ?    /* 1, PATH */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
   HEAD_REVISION    = ?     /* 2, HEAD_REVISION */
  ,PROJECT_NAME     = ?     /* 3, PROJECT_NAME */
  ,FILE_NAME        = ?     /* 4, FILE_NAME */
  ,PATH             = ?     /* 5, PATH */
  ,REVISION         = ?     /* 6, REVISION */
  ,AUTHOR           = ?     /* 7, AUTHOR */
  ,COMMIT_YMD       = ?     /* 8, COMMIT_YMD */
  ,COMMIT_HMS       = ?     /* 9, COMMIT_HMS */
  ,EXTENSION        = ?     /* 10, EXTENSION */
  ,KOSINYMD         = TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS         = TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER        = SYS_CONTEXT('USERENV','MODULE')
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
   HEAD_REVISION
  ,PROJECT_NAME
  ,FILE_NAME
  ,PATH
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
   ?  /* 11, HEAD_REVISION */
  ,?  /* 12, PROJECT_NAME */
  ,?  /* 13, FILE_NAME */
  ,?  /* 14, PATH */
  ,?  /* 15, REVISION */
  ,?  /* 16, AUTHOR */
  ,?  /* 17, COMMIT_YMD */
  ,?  /* 18, COMMIT_HMS */
  ,?  /* 19, EXTENSION */
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
)