MERGE INTO RS_SVN_SRC_INFO
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  HEAD_REVISION = ?             /* 1, HEAD_REVISION */
  ,PROJECT_NAME = ?            /* 2, PROJECT_NAME */
  ,FILE_NAME = ?            /* 3, FILE_NAME */
  ,PATH = ?            /* 4, PATH */
  ,REVISION = ?            /* 5, REVISION */
  ,AUTHOR = ?            /* 6, AUTHOR */
  ,COMMIT_YMD = ?            /* 7, COMMIT_YMD */
  ,COMMIT_HMS = ?            /* 8, COMMIT_HMS */
  ,EXTENSION = ?            /* 9, EXTENSION */
  ,TOROKUYMD = ?            /* 10, TOROKUYMD */
  ,TOROKUHMS = ?            /* 11, TOROKUHMS */
  ,TOROKUUSER = ?            /* 12, TOROKUUSER */
  ,KOSINYMD = ?            /* 13, KOSINYMD */
  ,KOSINHMS = ?            /* 14, KOSINHMS */
  ,KOSINUSER = ?            /* 15, KOSINUSER */
  ,BIKO = ?            /* 16, BIKO */
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
  ?   /* 1, HEAD_REVISION */
  ,?  /* 2, PROJECT_NAME */
  ,?  /* 3, FILE_NAME */
  ,?  /* 4, PATH */
  ,?  /* 5, REVISION */
  ,?  /* 6, AUTHOR */
  ,?  /* 7, COMMIT_YMD */
  ,?  /* 8, COMMIT_HMS */
  ,?  /* 9, EXTENSION */
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
)