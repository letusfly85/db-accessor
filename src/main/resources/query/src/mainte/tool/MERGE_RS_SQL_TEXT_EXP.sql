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
  ,SUB_LINE = ?            /* 6, SUB_LINE */
  ,TEXT = ?            /* 7, TEXT */
  ,REVISION = ?            /* 8, REVISION */
  ,AUTHOR = ?            /* 9, AUTHOR */
  ,COMMIT_YMD = ?            /* 10, COMMIT_YMD */
  ,COMMIT_HMS = ?            /* 11, COMMIT_HMS */
  ,EXTENSION = ?            /* 12, EXTENSION */
  ,TOROKUYMD = ?            /* 13, TOROKUYMD */
  ,TOROKUHMS = ?            /* 14, TOROKUHMS */
  ,TOROKUUSER = ?            /* 15, TOROKUUSER */
  ,KOSINYMD = ?            /* 16, KOSINYMD */
  ,KOSINHMS = ?            /* 17, KOSINHMS */
  ,KOSINUSER = ?            /* 18, KOSINUSER */
  ,BIKO = ?            /* 19, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  HEAD_REVISION
  ,PROJECT_NAME
  ,FILE_NAME
  ,PATH
  ,LINE
  ,SUB_LINE
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
  ,?  /* 6, SUB_LINE */
  ,?  /* 7, TEXT */
  ,?  /* 8, REVISION */
  ,?  /* 9, AUTHOR */
  ,?  /* 10, COMMIT_YMD */
  ,?  /* 11, COMMIT_HMS */
  ,?  /* 12, EXTENSION */
  ,?  /* 13, TOROKUYMD */
  ,?  /* 14, TOROKUHMS */
  ,?  /* 15, TOROKUUSER */
  ,?  /* 16, KOSINYMD */
  ,?  /* 17, KOSINHMS */
  ,?  /* 18, KOSINUSER */
  ,?  /* 19, BIKO */
)