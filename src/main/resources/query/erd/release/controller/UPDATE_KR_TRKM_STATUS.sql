UPDATE KR_TRKM_STATUS
SET
   TRKM_ID     = ?            /* 1, TRKM_ID */
  ,TRKM_STATUS = ?            /* 2, TRKM_STATUS */
  ,CURRENT_FLG = ?            /* 3, CURRENT_FLG */
  ,KOSINYMD	     = TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	     = TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	 = SYS_CONTEXT('USERENV','MODULE')
WHERE
    1 = 1
AND TRKM_ID = ?