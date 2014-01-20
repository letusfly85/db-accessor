UPDATE RR_ERD_RELEASES
SET
  AF_RELEASE_ID  = ?            /* 1, AF_RELEASE_ID */
  ,BF_RELEASE_ID = ?            /* 2, BF_RELEASE_ID */
  ,OBJECT_TYPE   = ?            /* 3, OBJECT_TYPE */
  ,OBJECT_ID     = ?            /* 4, OBJECT_ID */
  ,REVISION      = ?            /* 5, REVISION */
  ,OBJECT_NAME   = ?            /* 6, OBJECT_NAME */
  ,DIFF_TYPE     = ?            /* 7, DIFF_TYPE */
  ,KOSINYMD	     =	TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	     =	TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	 =	SYS_CONTEXT('USERENV','MODULE')
WHERE
      1 = 1
AND AF_RELEASE_ID = ?
AND OBJECT_TYPE   = ?
AND OBJECT_NAME   = ?