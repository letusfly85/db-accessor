MERGE INTO RR_TABLES
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  TRKM_ID = ?             /* 1, TRKM_ID */
  ,TAB_DEF_ID = ?            /* 2, TAB_DEF_ID */
  ,TABLE_ID = ?            /* 3, TABLE_ID */
  ,REVISION_AF = ?            /* 4, REVISION_AF */
  ,REVISION_BF = ?            /* 5, REVISION_BF */
  ,LOGICAL_TABLE_TAG = ?            /* 6, LOGICAL_TABLE_TAG */
  ,LOGICAL_TABLE_NAME = ?            /* 7, LOGICAL_TABLE_NAME */
  ,PHYSICAL_TABLE_NAME = ?            /* 8, PHYSICAL_TABLE_NAME */
  ,TRKM_STATUS = ?            /* 9, TRKM_STATUS */
  ,TABLE_COMMENT = ?            /* 10, TABLE_COMMENT */
  ,SEGOSEI_CHECK_STATUS = ?            /* 11, SEGOSEI_CHECK_STATUS */
  ,TICKET_NUMBER = ?            /* 12, TICKET_NUMBER */
  ,EXISTS_FLG = ?            /* 13, EXISTS_FLG */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  TRKM_ID
  ,TAB_DEF_ID
  ,TABLE_ID
  ,REVISION_AF
  ,REVISION_BF
  ,LOGICAL_TABLE_TAG
  ,LOGICAL_TABLE_NAME
  ,PHYSICAL_TABLE_NAME
  ,TRKM_STATUS
  ,TABLE_COMMENT
  ,SEGOSEI_CHECK_STATUS
  ,TICKET_NUMBER
  ,EXISTS_FLG
)
VALUES
(
  ?   /* 1, TRKM_ID */
  ,?  /* 2, TAB_DEF_ID */
  ,?  /* 3, TABLE_ID */
  ,?  /* 4, REVISION_AF */
  ,?  /* 5, REVISION_BF */
  ,?  /* 6, LOGICAL_TABLE_TAG */
  ,?  /* 7, LOGICAL_TABLE_NAME */
  ,?  /* 8, PHYSICAL_TABLE_NAME */
  ,?  /* 9, TRKM_STATUS */
  ,?  /* 10, TABLE_COMMENT */
  ,?  /* 11, SEGOSEI_CHECK_STATUS */
  ,?  /* 12, TICKET_NUMBER */
  ,?  /* 13, EXISTS_FLG */
)