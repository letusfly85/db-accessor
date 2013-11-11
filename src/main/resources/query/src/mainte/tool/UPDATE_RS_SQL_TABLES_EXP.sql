UPDATE RS_SQL_TABLES_EXP
SET
  HEAD_REVISION = ?  /* 1, HEAD_REVISION */
  ,PROJECT_NAME = ?  /* 2, PROJECT_NAME */
  ,FILE_NAME = ?     /* 3, FILE_NAME */
  ,PATH = ?          /* 4, PATH */
  ,SUB_LINE = ?      /* 5, SUB_LINE */
  ,TABLE_NAME = ?    /* 6, TABLE_NAME */
  ,TABLE_ALIAS = ?   /* 7, TABLE_ALIAS */
  ,CALL_TYPE = ?     /* 8, CALL_TYPE */
  ,CRUD_TYPE = ?     /* 9, CRUD_TYPE */
  ,DEPTH = ?         /* 10, DEPTH */
  ,REVISION = ?      /* 11, REVISION */
  ,AUTHOR = ?        /* 12, AUTHOR */
  ,COMMIT_YMD = ?    /* 13, COMMIT_YMD */
  ,COMMIT_HMS = ?    /* 14, COMMIT_HMS */
  ,EXTENSION = ?     /* 15, EXTENSION */
  ,KOSINYMD	    =	 TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	    =	 TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	=	 SYS_CONTEXT('USERENV','MODULE')
WHERE
    1 = 1
AND PATH = ?
AND SUB_LINE = ?