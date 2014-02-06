UPDATE TR_COMMIT_HISTORY
SET
   REPOSITORY_KIND   = ?            /* 1, REPOSITORY_KIND */
  ,REPOSITORY_NAME   = ?            /* 2, REPOSITORY_NAME */
  ,ROOT_URL          = ?            /* 3, ROOT_URL */
  ,RIGHT_BASE_URL    = ?            /* 4, RIGHT_BASE_URL */
  ,LEFT_BASE_URL     = ?            /* 5, LEFT_BASE_URL */
  ,REVISION          = ?            /* 7, REVISION */
  ,COMMITTER         = ?            /* 8, COMMITTER */
  ,COMMENTS          = ?            /* 9, COMMENTS */
  ,ACTION            = ?            /* 10, ACTION */
  ,PATH              = ?            /* 11, PATH */
  ,FILE_NAME         = ?            /* 12, FILE_NAME */
  ,COMMIT_YMD        = ?            /* 13, COMMIT_YMD */
  ,COMMIT_HMS        = ?            /* 14, COMMIT_HMS */
  ,KOSINYMD	    =	 TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	    =	 TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	=	 SYS_CONTEXT('USERENV','MODULE')
WHERE
  1 = 0