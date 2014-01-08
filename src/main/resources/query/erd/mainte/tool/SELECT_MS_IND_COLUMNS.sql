SELECT
   INDEX_NAME
  ,REVISION
  ,TABLE_ID
  ,COLUMN_ID
  ,COLUMN_NAME
  ,COLUMN_POSITION
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
  ,BIKO
FROM
  MS_IND_COLUMNS
WHERE
    1 = 1
AND INDEX_NAME = ?
ORDER BY
    COLUMN_POSITION DESC