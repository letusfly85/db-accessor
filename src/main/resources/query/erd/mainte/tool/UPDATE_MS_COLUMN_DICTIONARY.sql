UPDATE MS_COLUMN_DICTIONARY
SET
  DICT_COLUMN_ID = ?             /* 1, DICT_COLUMN_ID */
  ,PHYSICAL_COLUMN_NAME = ?            /* 2, PHYSICAL_COLUMN_NAME */
  ,DATA_TYPE = ?            /* 3, DATA_TYPE */
  ,DATA_LENGTH = ?            /* 4, DATA_LENGTH */
  ,DATA_PRECISION = ?            /* 5, DATA_PRECISION */
  ,DATA_DEFAULT = ?            /* 6, DATA_DEFAULT */
  ,ENTITY_FIELD_NAME = ?            /* 7, ENTITY_FIELD_NAME */
  ,ENTITY_FIELD_TYPE = ?            /* 8, ENTITY_FIELD_TYPE */
  ,TOROKUYMD = ?            /* 9, TOROKUYMD */
  ,TOROKUHMS = ?            /* 10, TOROKUHMS */
  ,TOROKUUSER = ?            /* 11, TOROKUUSER */
  ,KOSINYMD = ?            /* 12, KOSINYMD */
  ,KOSINHMS = ?            /* 13, KOSINHMS */
  ,KOSINUSER = ?            /* 14, KOSINUSER */
  ,BIKO = ?            /* 15, BIKO */
WHERE
  1 = 0