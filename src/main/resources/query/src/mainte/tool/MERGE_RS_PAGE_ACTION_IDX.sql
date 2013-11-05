MERGE INTO RS_PAGE_ACTION_IDX
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
  ,PAGE_NAME = ?            /* 9, PAGE_NAME */
  ,ACTION_NAME = ?            /* 10, ACTION_NAME */
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
  ,REVISION
  ,AUTHOR
  ,COMMIT_YMD
  ,COMMIT_HMS
  ,PAGE_NAME
  ,ACTION_NAME
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
  ,?  /* 5, REVISION */
  ,?  /* 6, AUTHOR */
  ,?  /* 7, COMMIT_YMD */
  ,?  /* 8, COMMIT_HMS */
  ,?  /* 9, PAGE_NAME */
  ,?  /* 10, ACTION_NAME */
  ,?  /* 11, EXTENSION */
  ,?  /* 12, TOROKUYMD */
  ,?  /* 13, TOROKUHMS */
  ,?  /* 14, TOROKUUSER */
  ,?  /* 15, KOSINYMD */
  ,?  /* 16, KOSINHMS */
  ,?  /* 17, KOSINUSER */
  ,?  /* 18, BIKO */
)