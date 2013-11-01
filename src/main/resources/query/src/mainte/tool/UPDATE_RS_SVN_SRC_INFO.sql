UPDATE RS_SVN_SRC_INFO
SET
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
WHERE
  1 = 0