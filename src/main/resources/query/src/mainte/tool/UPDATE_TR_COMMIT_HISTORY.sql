UPDATE TR_COMMIT_HISTORY
SET
   REPOSITORY_KIND   = ?            /* 1, REPOSITORY_KIND */
  ,REPOSITORY_NAME   = ?            /* 2, REPOSITORY_NAME */
  ,ROOT_URL          = ?            /* 3, ROOT_URL */
  ,RIGHT_BASE_URL    = ?            /* 4, RIGHT_BASE_URL */
  ,LEFT_BASE_URL     = ?            /* 5, LEFT_BASE_URL */
  ,REVISION          = ?            /* 6, REVISION */
  ,COMMITTER         = ?            /* 7, COMMITTER */
  ,COMMENTS          = ?            /* 8, COMMENTS */
  ,ACTION            = ?            /* 9, ACTION */
  ,PATH              = ?            /* 10, PATH */
  ,FILE_NAME         = ?            /* 11, FILE_NAME */
  ,COMMIT_YMD        = ?            /* 12, COMMIT_YMD */
  ,COMMIT_HMS        = ?            /* 13, COMMIT_HMS */
  ,KOSINYMD	    =	 TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	    =	 TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	=	 SYS_CONTEXT('USERENV','MODULE')
WHERE
    1 = 1
AND REPOSITORY_NAME = ?             /* 14, REPOSITORY_NAME */
AND ROOT_URL        = ?             /* 15, ROOT_URL        */
AND RIGHT_BASE_URL  = ?             /* 16, RIGHT_BASE_URL  */
AND LEFT_BASE_URL   = ?             /* 17, LEFT_BASE_URL   */