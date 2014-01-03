UPDATE MS_ERD_RELEASES
SET
  RELEASE_ID = ?             /* 1, RELEASE_ID */
  ,OBJECT_TYPE = ?            /* 2, OBJECT_TYPE */
  ,OBJECT_ID = ?            /* 3, OBJECT_ID */
  ,REVISION = ?            /* 4, REVISION */
  ,OBJECT_NAME = ?            /* 5, OBJECT_NAME */
  ,DIFF_TYPE = ?            /* 6, DIFF_TYPE */
  ,TOROKUYMD = ?            /* 7, TOROKUYMD */
  ,TOROKUHMS = ?            /* 8, TOROKUHMS */
  ,TOROKUUSER = ?            /* 9, TOROKUUSER */
  ,KOSINYMD = ?            /* 10, KOSINYMD */
  ,KOSINHMS = ?            /* 11, KOSINHMS */
  ,KOSINUSER = ?            /* 12, KOSINUSER */
  ,BIKO = ?            /* 13, BIKO */
WHERE
  1 = 0