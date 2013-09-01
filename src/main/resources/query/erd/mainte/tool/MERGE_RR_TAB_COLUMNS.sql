MERGE INTO RR_TAB_COLUMNS
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  TAB_DEF_ID = ?             /* 1, TAB_DEF_ID */
  ,TABLE_ID = ?            /* 2, TABLE_ID */
  ,REVISION_AF = ?            /* 3, REVISION_AF */
  ,REVISION_BF = ?            /* 4, REVISION_BF */
  ,AUTHOUR = ?            /* 5, AUTHOUR */
  ,UPDATOR = ?            /* 6, UPDATOR */
  ,LOGICAL_TABLE_TAG = ?            /* 7, LOGICAL_TABLE_TAG */
  ,LOGICAL_TABLE_NAME = ?            /* 8, LOGICAL_TABLE_NAME */
  ,PHYSICAL_TABLE_NAME = ?            /* 9, PHYSICAL_TABLE_NAME */
  ,TABLE_COMMENT = ?            /* 10, TABLE_COMMENT */
  ,COLUMN_ID = ?            /* 11, COLUMN_ID */
  ,LOGICAL_COLUMN_TAG = ?            /* 12, LOGICAL_COLUMN_TAG */
  ,LOGICAL_COLUMN_NAME = ?            /* 13, LOGICAL_COLUMN_NAME */
  ,PHYSICAL_COLUMN_NAME = ?            /* 14, PHYSICAL_COLUMN_NAME */
  ,COLUMN_COMMENT = ?            /* 15, COLUMN_COMMENT */
  ,DATA_TYPE = ?            /* 16, DATA_TYPE */
  ,DATA_LENGTH = ?            /* 17, DATA_LENGTH */
  ,DATA_PRECISION = ?            /* 18, DATA_PRECISION */
  ,DATA_DEFAULT = ?            /* 19, DATA_DEFAULT */
  ,DATA_SCALE = ?            /* 20, DATA_SCALE */
  ,PK_FLG = ?            /* 21, PK_FLG */
  ,NULLABLE = ?            /* 22, NULLABLE */
  ,TRKM_STATUS = ?            /* 23, TRKM_STATUS */
  ,SEGOSEI_CHECK_STATUS = ?            /* 24, SEGOSEI_CHECK_STATUS */
  ,SEGOSEI_CHECK_LOG_ID = ?            /* 25, SEGOSEI_CHECK_LOG_ID */
  ,TICKET_NUMBER = ?            /* 26, TICKET_NUMBER */
  ,EXISTS_FLG = ?            /* 27, EXISTS_FLG */
  ,TOROKUYMD = ?            /* 28, TOROKUYMD */
  ,TOROKUHMS = ?            /* 29, TOROKUHMS */
  ,TOROKUUSER = ?            /* 30, TOROKUUSER */
  ,KOSINYMD = ?            /* 31, KOSINYMD */
  ,KOSINHMS = ?            /* 32, KOSINHMS */
  ,KOSINUSER = ?            /* 33, KOSINUSER */
  ,BIKO = ?            /* 34, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  TAB_DEF_ID
  ,TABLE_ID
  ,REVISION_AF
  ,REVISION_BF
  ,AUTHOUR
  ,UPDATOR
  ,LOGICAL_TABLE_TAG
  ,LOGICAL_TABLE_NAME
  ,PHYSICAL_TABLE_NAME
  ,TABLE_COMMENT
  ,COLUMN_ID
  ,LOGICAL_COLUMN_TAG
  ,LOGICAL_COLUMN_NAME
  ,PHYSICAL_COLUMN_NAME
  ,COLUMN_COMMENT
  ,DATA_TYPE
  ,DATA_LENGTH
  ,DATA_PRECISION
  ,DATA_DEFAULT
  ,DATA_SCALE
  ,PK_FLG
  ,NULLABLE
  ,TRKM_STATUS
  ,SEGOSEI_CHECK_STATUS
  ,SEGOSEI_CHECK_LOG_ID
  ,TICKET_NUMBER
  ,EXISTS_FLG
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
  ?   /* 1, TAB_DEF_ID */
  ,?  /* 2, TABLE_ID */
  ,?  /* 3, REVISION_AF */
  ,?  /* 4, REVISION_BF */
  ,?  /* 5, AUTHOUR */
  ,?  /* 6, UPDATOR */
  ,?  /* 7, LOGICAL_TABLE_TAG */
  ,?  /* 8, LOGICAL_TABLE_NAME */
  ,?  /* 9, PHYSICAL_TABLE_NAME */
  ,?  /* 10, TABLE_COMMENT */
  ,?  /* 11, COLUMN_ID */
  ,?  /* 12, LOGICAL_COLUMN_TAG */
  ,?  /* 13, LOGICAL_COLUMN_NAME */
  ,?  /* 14, PHYSICAL_COLUMN_NAME */
  ,?  /* 15, COLUMN_COMMENT */
  ,?  /* 16, DATA_TYPE */
  ,?  /* 17, DATA_LENGTH */
  ,?  /* 18, DATA_PRECISION */
  ,?  /* 19, DATA_DEFAULT */
  ,?  /* 20, DATA_SCALE */
  ,?  /* 21, PK_FLG */
  ,?  /* 22, NULLABLE */
  ,?  /* 23, TRKM_STATUS */
  ,?  /* 24, SEGOSEI_CHECK_STATUS */
  ,?  /* 25, SEGOSEI_CHECK_LOG_ID */
  ,?  /* 26, TICKET_NUMBER */
  ,?  /* 27, EXISTS_FLG */
  ,?  /* 28, TOROKUYMD */
  ,?  /* 29, TOROKUHMS */
  ,?  /* 30, TOROKUUSER */
  ,?  /* 31, KOSINYMD */
  ,?  /* 32, KOSINHMS */
  ,?  /* 33, KOSINUSER */
  ,?  /* 34, BIKO */
)