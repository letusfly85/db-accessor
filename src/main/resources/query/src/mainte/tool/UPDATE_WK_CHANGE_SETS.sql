UPDATE WK_CHANGE_SETS
SET
  REVISION = ?             /* 1, REVISION */
  ,COMMITTER = ?            /* 2, COMMITTER */
  ,COMMENTS = ?            /* 3, COMMENTS */
  ,ACTION = ?            /* 4, ACTION */
  ,PATH = ?            /* 5, PATH */
  ,FILE_NAME = ?            /* 6, FILE_NAME */
  ,COMMIT_DATE = ?            /* 7, COMMIT_DATE */
  ,COMMIT_HMS = ?            /* 8, COMMIT_HMS */
WHERE
  1 = 0