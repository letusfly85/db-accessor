UPDATE RS_CONFIG_ATTRIBUTES
SET
  HEAD_REVISION = ?             /* 1, HEAD_REVISION */
  ,PROJECT_NAME = ?            /* 2, PROJECT_NAME */
  ,FILE_NAME = ?            /* 3, FILE_NAME */
  ,PATH = ?            /* 4, PATH */
  ,REVISION = ?            /* 5, REVISION */
  ,AUTHOR = ?            /* 6, AUTHOR */
  ,COMMIT_YMD = ?            /* 7, COMMIT_YMD */
  ,COMMIT_HMS = ?            /* 8, COMMIT_HMS */
  ,ACTION_NAME = ?            /* 9, ACTION_NAME */
  ,SUBJECT_ID = ?            /* 10, SUBJECT_ID */
  ,FROM_ID = ?            /* 11, FROM_ID */
  ,TO_ID = ?            /* 12, TO_ID */
  ,NEXT_ACTION_NAME = ?            /* 13, NEXT_ACTION_NAME */
  ,EXTENSION = ?            /* 14, EXTENSION */
  ,TOROKUYMD = ?            /* 15, TOROKUYMD */
  ,TOROKUHMS = ?            /* 16, TOROKUHMS */
  ,TOROKUUSER = ?            /* 17, TOROKUUSER */
  ,KOSINYMD = ?            /* 18, KOSINYMD */
  ,KOSINHMS = ?            /* 19, KOSINHMS */
  ,KOSINUSER = ?            /* 20, KOSINUSER */
  ,BIKO = ?            /* 21, BIKO */
WHERE
  1 = 0