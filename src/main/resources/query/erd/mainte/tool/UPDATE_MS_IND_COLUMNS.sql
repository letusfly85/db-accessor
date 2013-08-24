UPDATE MS_IND_COLUMNS
SET
  INDEX_NAME = ?             /* 1, INDEX_NAME */
  ,REVISION = ?            /* 2, REVISION */
  ,TABLE_ID = ?            /* 3, TABLE_ID */
  ,COLUMN_ID = ?            /* 4, COLUMN_ID */
  ,COLUMN_NAME = ?            /* 5, COLUMN_NAME */
  ,COLUMN_POSITION = ?            /* 6, COLUMN_POSITION */
  ,TOROKUYMD = ?            /* 7, TOROKUYMD */
  ,TOROKUHMS = ?            /* 8, TOROKUHMS */
  ,TOROKUUSER = ?            /* 9, TOROKUUSER */
  ,KOSINYMD = ?            /* 10, KOSINYMD */
  ,KOSINHMS = ?            /* 11, KOSINHMS */
  ,KOSINUSER = ?            /* 12, KOSINUSER */
  ,BIKO = ?            /* 13, BIKO */
WHERE
  1 = 0