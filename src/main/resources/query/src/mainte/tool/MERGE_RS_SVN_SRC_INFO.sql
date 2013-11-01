MERGE INTO RS_SVN_SRC_INFO
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  HEAD_REVISION = ?             /* 1, HEAD_REVISION */
  ,FILE_NAME = ?            /* 2, FILE_NAME */
  ,PATH = ?            /* 3, PATH */
  ,REVISION = ?            /* 4, REVISION */
  ,AUTHOR = ?            /* 5, AUTHOR */
  ,COMMIT_DATE = ?            /* 6, COMMIT_DATE */
  ,COMMIT_HMS = ?            /* 7, COMMIT_HMS */
  ,EXTENSION = ?            /* 8, EXTENSION */
  ,TOROKUYMD = ?            /* 9, TOROKUYMD */
  ,TOROKUHMS = ?            /* 10, TOROKUHMS */
  ,TOROKUUSER = ?            /* 11, TOROKUUSER */
  ,KOSINYMD = ?            /* 12, KOSINYMD */
  ,KOSINHMS = ?            /* 13, KOSINHMS */
  ,KOSINUSER = ?            /* 14, KOSINUSER */
  ,BIKO = ?            /* 15, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  HEAD_REVISION
  ,FILE_NAME
  ,PATH
  ,REVISION
  ,AUTHOR
  ,COMMIT_DATE
  ,COMMIT_HMS
  ,EXTENSION
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
  ,BIKO
)
VALUES
(
  ?   /* 1, HEAD_REVISION */
  ,?  /* 2, FILE_NAME */
  ,?  /* 3, PATH */
  ,?  /* 4, REVISION */
  ,?  /* 5, AUTHOR */
  ,?  /* 6, COMMIT_DATE */
  ,?  /* 7, COMMIT_HMS */
  ,?  /* 8, EXTENSION */
  ,?  /* 9, TOROKUYMD */
  ,?  /* 10, TOROKUHMS */
  ,?  /* 11, TOROKUUSER */
  ,?  /* 12, KOSINYMD */
  ,?  /* 13, KOSINHMS */
  ,?  /* 14, KOSINUSER */
  ,?  /* 15, BIKO */
)