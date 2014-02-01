UPDATE KR_RELEASE_DIFFS
SET
   TAG_NAME        = ?            /* 1, TAG_NAME */
  ,FROM_REVISION   = ?            /* 2, FROM_REVISION */
  ,TO_REVISION     = ?            /* 3, TO_REVISION */
  ,HEADER_FLG      = ?            /* 4, HEADER_FLG */
  ,TARGET_ENV_NAME = ?            /* 5, TARGET_ENV_NAME */
  ,KOSINYMD	    =	 TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	    =	 TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	=	 SYS_CONTEXT('USERENV','MODULE')
WHERE
    TAG_NAME    = ?
AND TO_REVISION = ?