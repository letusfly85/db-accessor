MERGE INTO TR_COMMIT_HISTORY
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  REPOSITORY_KIND = ?             /* 1, REPOSITORY_KIND */
  ,REPOSITORY_NAME = ?            /* 2, REPOSITORY_NAME */
  ,ROOT_URL = ?            /* 3, ROOT_URL */
  ,RIGHT_BASE_URL = ?            /* 4, RIGHT_BASE_URL */
  ,LEFT_BASE_URL = ?            /* 5, LEFT_BASE_URL */
  ,REVISION = ?            /* 7, REVISION */
  ,COMMITTER = ?            /* 8, COMMITTER */
  ,COMMENTS = ?            /* 9, COMMENTS */
  ,ACTION = ?            /* 10, ACTION */
  ,PATH = ?            /* 11, PATH */
  ,FILE_NAME = ?            /* 12, FILE_NAME */
  ,COMMIT_YMD = ?            /* 13, COMMIT_YMD */
  ,COMMIT_HMS = ?            /* 14, COMMIT_HMS */
  ,TOROKUYMD = ?            /* 15, TOROKUYMD */
  ,TOROKUHMS = ?            /* 16, TOROKUHMS */
  ,TOROKUUSER = ?            /* 17, TOROKUUSER */
  ,KOSINYMD = ?            /* 18, KOSINYMD */
  ,KOSINHMS = ?            /* 19, KOSINHMS */
  ,KOSINUSER = ?            /* 20, KOSINUSER */
  ,BIKO = ?            /* 21, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  REPOSITORY_KIND
  ,REPOSITORY_NAME
  ,ROOT_URL
  ,RIGHT_BASE_URL
  ,LEFT_BASE_URL
  ,HISTORY_ID
  ,REVISION
  ,COMMITTER
  ,COMMENTS
  ,ACTION
  ,PATH
  ,FILE_NAME
  ,COMMIT_YMD
  ,COMMIT_HMS
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
  ?   /* 1, REPOSITORY_KIND */
  ,?  /* 2, REPOSITORY_NAME */
  ,?  /* 3, ROOT_URL */
  ,?  /* 4, RIGHT_BASE_URL */
  ,?  /* 5, LEFT_BASE_URL */
  ,?  /* 7, REVISION */
  ,?  /* 8, COMMITTER */
  ,?  /* 9, COMMENTS */
  ,?  /* 10, ACTION */
  ,?  /* 11, PATH */
  ,?  /* 12, FILE_NAME */
  ,?  /* 13, COMMIT_YMD */
  ,?  /* 14, COMMIT_HMS */
  ,?  /* 15, TOROKUYMD */
  ,?  /* 16, TOROKUHMS */
  ,?  /* 17, TOROKUUSER */
  ,?  /* 18, KOSINYMD */
  ,?  /* 19, KOSINHMS */
  ,?  /* 20, KOSINUSER */
  ,?  /* 21, BIKO */
)