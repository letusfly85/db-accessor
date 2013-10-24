UPDATE RR_INDEXES
SET
  INDEX_NAME = ?             /* 1, INDEX_NAME */
  ,REVISION_AF = ?            /* 2, REVISION_AF */
  ,REVISION_BF = ?            /* 3, REVISION_BF */
  ,TABLE_ID = ?            /* 4, TABLE_ID */
  ,TAB_DEF_ID = ?            /* 5, TAB_DEF_ID */
  ,TICKET_NUMBER = ?            /* 6, TICKET_NUMBER */
  ,UNIQUENESS = ?            /* 7, UNIQUENESS */
  ,FUNCTION = ?            /* 8, FUNCTION */
  ,BITMAP = ?            /* 9, BITMAP */
  ,REVERSE = ?            /* 10, REVERSE */
  ,KEY_COMPRESS = ?            /* 11, KEY_COMPRESS */
  ,COMMIT_FLG = ?            /* 12, COMMIT_FLG */
  ,FUNCTION_FOMULA = ?            /* 13, FUNCTION_FOMULA */
  ,LOCALITY = ?            /* 14, LOCALITY */
  ,PARTITIONED = ?            /* 15, PARTITIONED */
  ,STATUS = ?            /* 16, STATUS */
  ,PK_INDEX_FLG = ?            /* 17, PK_INDEX_FLG */
  ,TOROKUYMD = ?            /* 18, TOROKUYMD */
  ,TOROKUHMS = ?            /* 19, TOROKUHMS */
  ,TOROKUUSER = ?            /* 20, TOROKUUSER */
  ,KOSINYMD = ?            /* 21, KOSINYMD */
  ,KOSINHMS = ?            /* 22, KOSINHMS */
  ,KOSINUSER = ?            /* 23, KOSINUSER */
  ,BIKO = ?            /* 24, BIKO */
WHERE
  1 = 0