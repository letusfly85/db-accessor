MERGE INTO WK_CHANGE_SETS
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  REVISION = ?             /* 1, REVISION */
  ,COMMITTER = ?            /* 2, COMMITTER */
  ,COMMENTS = ?            /* 3, COMMENTS */
  ,ACTION = ?            /* 4, ACTION */
  ,PATH = ?            /* 5, PATH */
  ,FILE_NAME = ?            /* 6, FILE_NAME */
  ,COMMIT_DATE = ?            /* 7, COMMIT_DATE */
  ,COMMIT_HMS = ?            /* 8, COMMIT_HMS */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  REVISION
  ,COMMITTER
  ,COMMENTS
  ,ACTION
  ,PATH
  ,FILE_NAME
  ,COMMIT_DATE
  ,COMMIT_HMS
)
VALUES
(
  ?   /* 1, REVISION */
  ,?  /* 2, COMMITTER */
  ,?  /* 3, COMMENTS */
  ,?  /* 4, ACTION */
  ,?  /* 5, PATH */
  ,?  /* 6, FILE_NAME */
  ,?  /* 7, COMMIT_DATE */
  ,?  /* 8, COMMIT_HMS */
)