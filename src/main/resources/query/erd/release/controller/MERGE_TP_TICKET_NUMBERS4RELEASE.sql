MERGE INTO TP_TICKET_NUMBERS4RELEASE
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  RELEASE_ID = ?             /* 1, RELEASE_ID */
  ,TRKM_ID = ?            /* 2, TRKM_ID */
  ,TICKET_NUMBER = ?            /* 3, TICKET_NUMBER */
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
  RELEASE_ID
  ,TRKM_ID
  ,TICKET_NUMBER
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
  ?   /* 1, RELEASE_ID */
  ,?  /* 2, TRKM_ID */
  ,?  /* 3, TICKET_NUMBER */
  ,?  /* 4, TOROKUYMD */
  ,?  /* 5, TOROKUHMS */
  ,?  /* 6, TOROKUUSER */
  ,?  /* 7, KOSINYMD */
  ,?  /* 8, KOSINHMS */
  ,?  /* 9, KOSINUSER */
  ,?  /* 10, BIKO */
)