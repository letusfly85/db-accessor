UPDATE RS_SQL_TEXT_EXP
SET
   HEAD_REVISION = ? /* 1, HEAD_REVISION */
  ,PROJECT_NAME = ?  /* 2, PROJECT_NAME */
  ,FILE_NAME = ?     /* 3, FILE_NAME */
  ,PATH = ?          /* 4, PATH */
  ,LINE = ?          /* 5, LINE */
  ,TEXT = ?          /* 6, TEXT */
  ,REVISION = ?      /* 7, REVISION */
  ,AUTHOR = ?        /* 8, AUTHOR */
  ,COMMIT_YMD = ?    /* 9, COMMIT_YMD */
  ,COMMIT_HMS = ?    /* 10, COMMIT_HMS */
  ,EXTENSION = ?     /* 11, EXTENSION */
  ,KOSINYMD	    =	 TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	    =	 TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	=	 SYS_CONTEXT('USERENV','MODULE')
WHERE
   PATH = ?