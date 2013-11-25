UPDATE RS_SUBJECTID_XQLPATH_IDX
SET
  SUBJECT_ID = ?             /* 1, SUBJECT_ID */
  ,PATH = ?            /* 2, PATH */
  ,REVISION = ?            /* 3, REVISION */
  ,COMMITER = ?            /* 4, COMMITER */
  ,UPDATE_FLG = ?            /* 5, UPDATE_FLG */
  ,NEW_FLG = ?            /* 6, NEW_FLG */
  ,FILE_NAME = ?            /* 7, FILE_NAME */
  ,TOROKUYMD = ?            /* 8, TOROKUYMD */
  ,TOROKUHMS = ?            /* 9, TOROKUHMS */
  ,TOROKUUSER = ?            /* 10, TOROKUUSER */
  ,KOSINYMD = ?            /* 11, KOSINYMD */
  ,KOSINHMS = ?            /* 12, KOSINHMS */
  ,KOSINUSER = ?            /* 13, KOSINUSER */
  ,BIKO = ?            /* 14, BIKO */
WHERE
  1 = 0