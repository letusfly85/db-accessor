UPDATE MS_TAB_COLUMNS
SET
   TAB_DEF_ID = ?               /* 1, TAB_DEF_ID */
  ,TABLE_ID = ?                 /* 2, TABLE_ID */
  ,REVISION = ?                 /* 3, REVISION */
  ,AUTHOUR = ?                  /* 4, AUTHOUR */
  ,UPDATOR = ?                  /* 5, UPDATOR */
  ,LOGICAL_TABLE_TAG = ?        /* 6, LOGICAL_TABLE_TAG */
  ,LOGICAL_TABLE_NAME = ?       /* 7, LOGICAL_TABLE_NAME */
  ,PHYSICAL_TABLE_NAME = ?      /* 8, PHYSICAL_TABLE_NAME */
  ,TABLE_COMMENT = ?            /* 9, TABLE_COMMENT */
  ,COLUMN_ID = ?                /* 10, COLUMN_ID */
  ,LOGICAL_COLUMN_TAG = ?       /* 11, LOGICAL_COLUMN_TAG */
  ,LOGICAL_COLUMN_NAME = ?      /* 12, LOGICAL_COLUMN_NAME */
  ,PHYSICAL_COLUMN_NAME = ?     /* 13, PHYSICAL_COLUMN_NAME */
  ,COLUMN_COMMENT = ?           /* 14, COLUMN_COMMENT */
  ,DATA_TYPE = ?                /* 15, DATA_TYPE */
  ,DATA_LENGTH = ?              /* 16, DATA_LENGTH */
  ,DATA_PRECISION = ?           /* 17, DATA_PRECISION */
  ,DATA_DEFAULT = ?             /* 18, DATA_DEFAULT */
  ,DATA_SCALE = ?               /* 19, DATA_SCALE */
  ,PK_FLG = ?                   /* 20, PK_FLG */
  ,NULLABLE = ?                 /* 21, NULLABLE */
  ,TRKM_STATUS = ?              /* 22, TRKM_STATUS */
  ,SEGOSEI_CHECK_STATUS = ?     /* 23, SEGOSEI_CHECK_STATUS */
  ,SEGOSEI_CHECK_LOG_ID = ?     /* 24, SEGOSEI_CHECK_LOG_ID */
  ,TICKET_NUMBER = ?            /* 25, TICKET_NUMBER */
  ,EXISTS_FLG = ?               /* 26, EXISTS_FLG */
  ,KOSINYMD	    =	TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	    =	TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	=	SYS_CONTEXT('USERENV','MODULE')
WHERE
    TABLE_ID             = ?    /* 27, TABLE_ID */
AND PHYSICAL_TABLE_NAME  = ?    /* 28, PHYSICAL_TABLE_NAME */
AND PHYSICAL_COLUMN_NAME = ?    /* 29, PHYSICAL_COLUMN_NAME */