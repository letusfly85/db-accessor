SELECT
   TRKM_ID
  ,TABLE_ID
  ,LOGICAL_TABLE_NAME
  ,PHYSICAL_TABLE_NAME
  ,TABLE_COMMENT
  ,DICT_COLUMN_ID
  ,COLUMN_ID
  ,LOGICAL_COLUMN_NAME
  ,PHYSICAL_COLUMN_NAME
  ,COLUMN_COMMENT
  ,DATA_TYPE
  ,DATA_LENGTH
  ,DATA_PRECISION
  ,DATA_DEFAULT
  ,NULLABLE
  ,PK_FLG
  ,EXISTS_FLG
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
  ,BIKO
FROM
  TR_ERD_TAB_COLUMNS
WHERE
  1 = 1
  --TODO