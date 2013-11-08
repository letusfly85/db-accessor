UPDATE RS_SQL_TABLES
SET
  HEAD_REVISION = ?             /* 1, HEAD_REVISION */
  ,PROJECT_NAME = ?            /* 2, PROJECT_NAME */
  ,FILE_NAME = ?            /* 3, FILE_NAME */
  ,PATH = ?            /* 4, PATH */
  ,PERSISTER_NAME = ?            /* 5, PERSISTER_NAME */
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
WHERE
  1 = 0