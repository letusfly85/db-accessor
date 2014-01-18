MERGE INTO KR_TRKM_STATUS
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  TRKM_ID = ?             /* 1, TRKM_ID */
  ,TRKM_STATUS = ?            /* 2, TRKM_STATUS */
  ,CURRENT_FLG = ?            /* 3, CURRENT_FLG */
  ,TRKM_YMD = ?            /* 4, TRKM_YMD */
  ,TRKM_HHMISS = ?            /* 5, TRKM_HHMISS */
  ,TOROKUYMD = ?            /* 6, TOROKUYMD */
  ,TOROKUHMS = ?            /* 7, TOROKUHMS */
  ,TOROKUUSER = ?            /* 8, TOROKUUSER */
  ,KOSINYMD = ?            /* 9, KOSINYMD */
  ,KOSINHMS = ?            /* 10, KOSINHMS */
  ,KOSINUSER = ?            /* 11, KOSINUSER */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  TRKM_ID
  ,TRKM_STATUS
  ,CURRENT_FLG
  ,TRKM_YMD
  ,TRKM_HHMISS
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
)
VALUES
(
  ?   /* 1, TRKM_ID */
  ,?  /* 2, TRKM_STATUS */
  ,?  /* 3, CURRENT_FLG */
  ,?  /* 4, TRKM_YMD */
  ,?  /* 5, TRKM_HHMISS */
  ,?  /* 6, TOROKUYMD */
  ,?  /* 7, TOROKUHMS */
  ,?  /* 8, TOROKUUSER */
  ,?  /* 9, KOSINYMD */
  ,?  /* 10, KOSINHMS */
  ,?  /* 11, KOSINUSER */
)