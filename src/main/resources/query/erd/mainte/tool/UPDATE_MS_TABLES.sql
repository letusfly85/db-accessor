UPDATE MS_TABLES
SET
  TRKM_ID               = ?            /* 1, TRKM_ID */
  ,TAB_DEF_ID           = ?            /* 2, TAB_DEF_ID */
  ,TABLE_ID             = ?            /* 3, TABLE_ID */
  ,SERVICE_NAME         = ?            /* 4, SERVICE_NAME */
  ,SUBSYSTEM_NAME       = ?            /* 5, SUBSYSTEM_NAME */
  ,REVISION             = ?            /* 6, REVISION */
  ,LOGICAL_TABLE_TAG    = ?            /* 7, LOGICAL_TABLE_TAG */
  ,LOGICAL_TABLE_NAME   = ?            /* 8, LOGICAL_TABLE_NAME */
  ,PHYSICAL_TABLE_NAME  = ?            /* 9, PHYSICAL_TABLE_NAME */
  ,TRKM_STATUS          = ?            /* 10, TRKM_STATUS */
  ,TABLE_COMMENT        = ?            /* 11, TABLE_COMMENT */
  ,SEGOSEI_CHECK_STATUS = ?            /* 12, SEGOSEI_CHECK_STATUS */
  ,TICKET_NUMBER        = ?            /* 13, TICKET_NUMBER */
  ,EXISTS_FLG           = ?            /* 14, EXISTS_FLG */
  ,KOSINYMD	            = TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	            = TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	        = SYS_CONTEXT('USERENV','MODULE')
WHERE
  1 = 0