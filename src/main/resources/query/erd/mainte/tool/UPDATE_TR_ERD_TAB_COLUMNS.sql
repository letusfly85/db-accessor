UPDATE TR_ERD_TAB_COLUMNS
SET
  TRKM_ID = ?             /* 1, TRKM_ID */
  ,TABLE_ID = ?            /* 2, TABLE_ID */
  ,LOGICAL_TABLE_NAME = ?            /* 3, LOGICAL_TABLE_NAME */
  ,PHYSICAL_TABLE_NAME = ?            /* 4, PHYSICAL_TABLE_NAME */
  ,TABLE_COMMENT = ?            /* 5, TABLE_COMMENT */
  ,DICT_COLUMN_ID = ?            /* 6, DICT_COLUMN_ID */
  ,COLUMN_ID = ?            /* 7, COLUMN_ID */
  ,LOGICAL_COLUMN_NAME = ?            /* 8, LOGICAL_COLUMN_NAME */
  ,PHYSICAL_COLUMN_NAME = ?            /* 9, PHYSICAL_COLUMN_NAME */
  ,COLUMN_COMMENT = ?            /* 10, COLUMN_COMMENT */
  ,DATA_TYPE = ?            /* 11, DATA_TYPE */
  ,DATA_LENGTH = ?            /* 12, DATA_LENGTH */
  ,DATA_PRECISION = ?            /* 13, DATA_PRECISION */
  ,DATA_DEFAULT = ?            /* 14, DATA_DEFAULT */
  ,NULLABLE = ?            /* 15, NULLABLE */
  ,PK_FLG = ?            /* 16, PK_FLG */
  ,EXISTS_FLG = ?            /* 17, EXISTS_FLG */
  ,TOROKUYMD = ?            /* 18, TOROKUYMD */
  ,TOROKUHMS = ?            /* 19, TOROKUHMS */
  ,TOROKUUSER = ?            /* 20, TOROKUUSER */
  ,KOSINYMD = ?            /* 21, KOSINYMD */
  ,KOSINHMS = ?            /* 22, KOSINHMS */
  ,KOSINUSER = ?            /* 23, KOSINUSER */
  ,BIKO = ?            /* 24, BIKO */
WHERE
  1 = 0