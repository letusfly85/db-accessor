SELECT
   TABLE_NAME
  ,CURRENT_ID
  ,PREVIOUS_ID
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
  ,BIKO
FROM
  KR_NASA_TABLE_SEQ
WHERE
    1 = 1
AND TABLE_NAME = ?  /*  1,   TABLE_NAME  */