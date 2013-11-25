UPDATE RS_SUBJECTID_XQLPATH_IDX
SET
  SUBJECT_ID = ?       /* 1, SUBJECT_ID */
  ,PATH = ?            /* 2, PATH */
  ,REVISION = ?        /* 3, REVISION */
  ,COMMITER = ?        /* 4, COMMITER */
  ,UPDATE_FLG = ?      /* 5, UPDATE_FLG */
  ,NEW_FLG = ?         /* 6, NEW_FLG */
  ,FILE_NAME = ?       /* 7, FILE_NAME */
  ,KOSINYMD	    =	    TO_CHAR(SYSDATE,'YYYYMMDD')
  ,KOSINHMS	    =	    TO_CHAR(SYSDATE,'HH24MISS')
  ,KOSINUSER	=	    SYS_CONTEXT('USERENV','MODULE')
WHERE
    PATH = ?
AND SUBJECT_ID = ?