MERGE INTO KR_NASA_TABLE_SEQ
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  TABLE_NAME = ?             /* 1, TABLE_NAME */
  ,CURRENT_ID = ?            /* 2, CURRENT_ID */
  ,PREVIOUS_ID = ?            /* 3, PREVIOUS_ID */
  ,TOROKUYMD = ?            /* 4, TOROKUYMD */
  ,TOROKUHMS = ?            /* 5, TOROKUHMS */
  ,TOROKUUSER = ?            /* 6, TOROKUUSER */
  ,KOSINYMD = ?            /* 7, KOSINYMD */
  ,KOSINHMS = ?            /* 8, KOSINHMS */
  ,KOSINUSER = ?            /* 9, KOSINUSER */
  ,BIKO = ?            /* 10, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
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
)
VALUES
(
  ?   /* 1, TABLE_NAME */
  ,?  /* 2, CURRENT_ID */
  ,?  /* 3, PREVIOUS_ID */
  ,?  /* 4, TOROKUYMD */
  ,?  /* 5, TOROKUHMS */
  ,?  /* 6, TOROKUUSER */
  ,?  /* 7, KOSINYMD */
  ,?  /* 8, KOSINHMS */
  ,?  /* 9, KOSINUSER */
  ,?  /* 10, BIKO */
)