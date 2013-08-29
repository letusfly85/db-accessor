MERGE INTO RR_TAB_DEF_INFO
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  TAB_DEF_ID = ?             /* 1, TAB_DEF_ID */
  ,TAB_DEF_NAME = ?            /* 2, TAB_DEF_NAME */
  ,TAB_DEF_REVISION_AF = ?            /* 3, TAB_DEF_REVISION_AF */
  ,TAB_DEF_REVISION_BF = ?            /* 4, TAB_DEF_REVISION_BF */
  ,SVN_REVISION = ?            /* 5, SVN_REVISION */
  ,AUTHOUR = ?            /* 6, AUTHOUR */
  ,UPDATOR = ?            /* 7, UPDATOR */
  ,LOGICAL_TABLE_NAME = ?            /* 8, LOGICAL_TABLE_NAME */
  ,PHYSICAL_TABLE_NAME = ?            /* 9, PHYSICAL_TABLE_NAME */
  ,TABLE_COMMENT = ?            /* 10, TABLE_COMMENT */
  ,COLUMN_ID = ?            /* 11, COLUMN_ID */
  ,LOGICAL_COLUMN_NAME = ?            /* 12, LOGICAL_COLUMN_NAME */
  ,PHYSICAL_COLUMN_NAME = ?            /* 13, PHYSICAL_COLUMN_NAME */
  ,COLUMN_COMMENT = ?            /* 14, COLUMN_COMMENT */
  ,DATA_TYPE = ?            /* 15, DATA_TYPE */
  ,DATA_LENGTH = ?            /* 16, DATA_LENGTH */
  ,DATA_PRECISION = ?            /* 17, DATA_PRECISION */
  ,DATA_SCALE = ?            /* 18, DATA_SCALE */
  ,PK_FLG = ?            /* 19, PK_FLG */
  ,NULLABLE = ?            /* 20, NULLABLE */
  ,DATA_DEFAULT = ?            /* 21, DATA_DEFAULT */
  ,TRKM_STATUS = ?            /* 22, TRKM_STATUS */
  ,SEGOSEI_CHECK_STATUS = ?            /* 23, SEGOSEI_CHECK_STATUS */
  ,SEGOSEI_CHECK_LOG_ID = ?            /* 24, SEGOSEI_CHECK_LOG_ID */
  ,EXISTS_FLG = ?            /* 25, EXISTS_FLG */
  ,TOROKUYMD = ?            /* 26, TOROKUYMD */
  ,TOROKUHMS = ?            /* 27, TOROKUHMS */
  ,TOROKUUSER = ?            /* 28, TOROKUUSER */
  ,KOSINYMD = ?            /* 29, KOSINYMD */
  ,KOSINHMS = ?            /* 30, KOSINHMS */
  ,KOSINUSER = ?            /* 31, KOSINUSER */
  ,BIKO = ?            /* 32, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  TAB_DEF_ID
  ,TAB_DEF_NAME
  ,TAB_DEF_REVISION_AF
  ,TAB_DEF_REVISION_BF
  ,SVN_REVISION
  ,AUTHOUR
  ,UPDATOR
  ,LOGICAL_TABLE_NAME
  ,PHYSICAL_TABLE_NAME
  ,TABLE_COMMENT
  ,COLUMN_ID
  ,LOGICAL_COLUMN_NAME
  ,PHYSICAL_COLUMN_NAME
  ,COLUMN_COMMENT
  ,DATA_TYPE
  ,DATA_LENGTH
  ,DATA_PRECISION
  ,DATA_SCALE
  ,PK_FLG
  ,NULLABLE
  ,DATA_DEFAULT
  ,TRKM_STATUS
  ,SEGOSEI_CHECK_STATUS
  ,SEGOSEI_CHECK_LOG_ID
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
  ,?  /* 2, TAB_DEF_NAME */
  ,?  /* 3, TAB_DEF_REVISION_AF */
  ,?  /* 4, TAB_DEF_REVISION_BF */
  ,?  /* 5, SVN_REVISION */
  ,?  /* 6, AUTHOUR */
  ,?  /* 7, UPDATOR */
  ,?  /* 8, LOGICAL_TABLE_NAME */
  ,?  /* 9, PHYSICAL_TABLE_NAME */
  ,?  /* 10, TABLE_COMMENT */
  ,?  /* 11, COLUMN_ID */
  ,?  /* 12, LOGICAL_COLUMN_NAME */
  ,?  /* 13, PHYSICAL_COLUMN_NAME */
  ,?  /* 14, COLUMN_COMMENT */
  ,?  /* 15, DATA_TYPE */
  ,?  /* 16, DATA_LENGTH */
  ,?  /* 17, DATA_PRECISION */
  ,?  /* 18, DATA_SCALE */
  ,?  /* 19, PK_FLG */
  ,?  /* 20, NULLABLE */
  ,?  /* 21, DATA_DEFAULT */
  ,?  /* 22, TRKM_STATUS */
  ,?  /* 23, SEGOSEI_CHECK_STATUS */
  ,?  /* 24, SEGOSEI_CHECK_LOG_ID */
  ,?  /* 25, EXISTS_FLG */
  ,?  /* 26, TOROKUYMD */
  ,?  /* 27, TOROKUHMS */
  ,?  /* 28, TOROKUUSER */
  ,?  /* 29, KOSINYMD */
  ,?  /* 30, KOSINHMS */
  ,?  /* 31, KOSINUSER */
  ,?  /* 32, BIKO */
)