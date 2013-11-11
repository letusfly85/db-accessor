MERGE INTO RS_SQL_TEXT_EXP
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
  ,LINE = ?            /* 5, LINE */
  ,TEXT = ?            /* 6, TEXT */
  ,REVISION = ?            /* 7, REVISION */
  ,AUTHOR = ?            /* 8, AUTHOR */
  ,COMMIT_YMD = ?            /* 9, COMMIT_YMD */
  ,COMMIT_HMS = ?            /* 10, COMMIT_HMS */
  ,EXTENSION = ?            /* 11, EXTENSION */
  ,TOROKUYMD = ?            /* 12, TOROKUYMD */
  ,TOROKUHMS = ?            /* 13, TOROKUHMS */
  ,TOROKUUSER = ?            /* 14, TOROKUUSER */
  ,KOSINYMD = ?            /* 15, KOSINYMD */
  ,KOSINHMS = ?            /* 16, KOSINHMS */
  ,KOSINUSER = ?            /* 17, KOSINUSER */
  ,BIKO = ?            /* 18, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  HEAD_REVISION
  ,PROJECT_NAME
  ,FILE_NAME
  ,PATH
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
  ,BIKO
)
VALUES
(
  ?   /* 1, HEAD_REVISION */
  ,?  /* 2, PROJECT_NAME */
  ,?  /* 3, FILE_NAME */
  ,?  /* 4, PATH */
  ,?  /* 5, LINE */
  ,?  /* 6, TEXT */
  ,?  /* 7, REVISION */
  ,?  /* 8, AUTHOR */
  ,?  /* 9, COMMIT_YMD */
  ,?  /* 10, COMMIT_HMS */
  ,?  /* 11, EXTENSION */
  ,?  /* 12, TOROKUYMD */
  ,?  /* 13, TOROKUHMS */
  ,?  /* 14, TOROKUUSER */
  ,?  /* 15, KOSINYMD */
  ,?  /* 16, KOSINHMS */
  ,?  /* 17, KOSINUSER */
  ,?  /* 18, BIKO */
)