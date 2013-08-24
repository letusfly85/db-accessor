MERGE INTO MS_IND_COLUMNS
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  INDEX_NAME = ?             /* 1, INDEX_NAME */
  ,REVISION = ?            /* 2, REVISION */
  ,TABLE_ID = ?            /* 3, TABLE_ID */
  ,COLUMN_ID = ?            /* 4, COLUMN_ID */
  ,COLUMN_NAME = ?            /* 5, COLUMN_NAME */
  ,COLUMN_POSITION = ?            /* 6, COLUMN_POSITION */
  ,TOROKUYMD = ?            /* 7, TOROKUYMD */
  ,TOROKUHMS = ?            /* 8, TOROKUHMS */
  ,TOROKUUSER = ?            /* 9, TOROKUUSER */
  ,KOSINYMD = ?            /* 10, KOSINYMD */
  ,KOSINHMS = ?            /* 11, KOSINHMS */
  ,KOSINUSER = ?            /* 12, KOSINUSER */
  ,BIKO = ?            /* 13, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  INDEX_NAME
  ,REVISION
  ,TABLE_ID
  ,COLUMN_ID
  ,COLUMN_NAME
  ,COLUMN_POSITION
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
  ?   /* 1, INDEX_NAME */
  ,?  /* 2, REVISION */
  ,?  /* 3, TABLE_ID */
  ,?  /* 4, COLUMN_ID */
  ,?  /* 5, COLUMN_NAME */
  ,?  /* 6, COLUMN_POSITION */
  ,?  /* 7, TOROKUYMD */
  ,?  /* 8, TOROKUHMS */
  ,?  /* 9, TOROKUUSER */
  ,?  /* 10, KOSINYMD */
  ,?  /* 11, KOSINHMS */
  ,?  /* 12, KOSINUSER */
  ,?  /* 13, BIKO */
)