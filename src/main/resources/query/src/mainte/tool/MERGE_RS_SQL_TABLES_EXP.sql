MERGE INTO RS_SQL_TABLES_EXP
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
  ,SUB_LINE = ?            /* 5, SUB_LINE */
  ,TABLE_NAME = ?            /* 6, TABLE_NAME */
  ,TABLE_ALIAS = ?            /* 7, TABLE_ALIAS */
  ,CALL_TYPE = ?            /* 8, CALL_TYPE */
  ,CRUD_TYPE = ?            /* 9, CRUD_TYPE */
  ,DEPTH = ?            /* 10, DEPTH */
  ,REVISION = ?            /* 11, REVISION */
  ,AUTHOR = ?            /* 12, AUTHOR */
  ,COMMIT_YMD = ?            /* 13, COMMIT_YMD */
  ,COMMIT_HMS = ?            /* 14, COMMIT_HMS */
  ,EXTENSION = ?            /* 15, EXTENSION */
  ,TOROKUYMD = ?            /* 16, TOROKUYMD */
  ,TOROKUHMS = ?            /* 17, TOROKUHMS */
  ,TOROKUUSER = ?            /* 18, TOROKUUSER */
  ,KOSINYMD = ?            /* 19, KOSINYMD */
  ,KOSINHMS = ?            /* 20, KOSINHMS */
  ,KOSINUSER = ?            /* 21, KOSINUSER */
  ,BIKO = ?            /* 22, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  HEAD_REVISION
  ,PROJECT_NAME
  ,FILE_NAME
  ,PATH
  ,SUB_LINE
  ,TABLE_NAME
  ,TABLE_ALIAS
  ,CALL_TYPE
  ,CRUD_TYPE
  ,DEPTH
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
  ,?  /* 5, SUB_LINE */
  ,?  /* 6, TABLE_NAME */
  ,?  /* 7, TABLE_ALIAS */
  ,?  /* 8, CALL_TYPE */
  ,?  /* 9, CRUD_TYPE */
  ,?  /* 10, DEPTH */
  ,?  /* 11, REVISION */
  ,?  /* 12, AUTHOR */
  ,?  /* 13, COMMIT_YMD */
  ,?  /* 14, COMMIT_HMS */
  ,?  /* 15, EXTENSION */
  ,?  /* 16, TOROKUYMD */
  ,?  /* 17, TOROKUHMS */
  ,?  /* 18, TOROKUUSER */
  ,?  /* 19, KOSINYMD */
  ,?  /* 20, KOSINHMS */
  ,?  /* 21, KOSINUSER */
  ,?  /* 22, BIKO */
)