UPDATE RS_PAGE_ACTION_IDX
SET
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
WHERE
  1 = 0