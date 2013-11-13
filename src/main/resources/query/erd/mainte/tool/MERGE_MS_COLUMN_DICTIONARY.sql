MERGE INTO MS_COLUMN_DICTIONARY
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
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
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  DICT_COLUMN_ID
  ,PHYSICAL_COLUMN_NAME
  ,DATA_TYPE
  ,DATA_LENGTH
  ,DATA_PRECISION
  ,DATA_DEFAULT
  ,ENTITY_FIELD_NAME
  ,ENTITY_FIELD_TYPE
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
  ,BIKO
)
VALUES
(
  ?   /* 1, DICT_COLUMN_ID */
  ,?  /* 2, PHYSICAL_COLUMN_NAME */
  ,?  /* 3, DATA_TYPE */
  ,?  /* 4, DATA_LENGTH */
  ,?  /* 5, DATA_PRECISION */
  ,?  /* 6, DATA_DEFAULT */
  ,?  /* 7, ENTITY_FIELD_NAME */
  ,?  /* 8, ENTITY_FIELD_TYPE */
  ,?  /* 9, TOROKUYMD */
  ,?  /* 10, TOROKUHMS */
  ,?  /* 11, TOROKUUSER */
  ,?  /* 12, KOSINYMD */
  ,?  /* 13, KOSINHMS */
  ,?  /* 14, KOSINUSER */
  ,?  /* 15, BIKO */
)