UPDATE RS_SQL_CDATA
SET
   HEAD_REVISION = ?    /* 1, HEAD_REVISION */
  ,PROJECT_NAME = ?    /* 2, PROJECT_NAME */
  ,FILE_NAME = ?       /* 3, FILE_NAME */
  ,PATH = ?            /* 4, PATH */
  ,PERSISTER_NAME = ?  /* 5, PERSISTER_NAME */
  ,LINE = ?            /* 6, LINE */
  ,TEXT = ?            /* 7, TEXT */
  ,REVISION = ?        /* 8, REVISION */
  ,AUTHOR = ?          /* 9, AUTHOR */
  ,COMMIT_YMD = ?      /* 10, COMMIT_YMD */
  ,COMMIT_HMS = ?      /* 11, COMMIT_HMS */
  ,EXTENSION = ?       /* 12, EXTENSION */
  ,KOSINYMD	    =	 TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	    =	 TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	=	 SYS_CONTEXT('USERENV','MODULE')
WHERE
    PATH           = ?  /* 13, PATH */
AND PERSISTER_NAME = ?  /* 14, PERSISTER_NAME */