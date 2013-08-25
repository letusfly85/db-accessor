MERGE INTO KR_TAB_DEF_REVISION
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  TAB_DEF_ID = ?             /* 1, TAB_DEF_ID */
  ,TAB_DEF_REVISION = ?            /* 2, TAB_DEF_REVISION */
  ,TAB_DEF_NAME = ?            /* 3, TAB_DEF_NAME */
  ,LAST_UPDATE_YMD = ?            /* 4, LAST_UPDATE_YMD */
  ,LAST_UPDATE_HHMISS = ?            /* 5, LAST_UPDATE_HHMISS */
  ,UPDATE_FLG = ?            /* 6, UPDATE_FLG */
  ,NEW_FLG = ?            /* 7, NEW_FLG */
  ,SVN_REVISION = ?            /* 8, SVN_REVISION */
  ,SVN_PATH = ?            /* 9, SVN_PATH */
  ,EXISTS_FLG = ?            /* 10, EXISTS_FLG */
  ,TRKM_STATUS = ?            /* 11, TRKM_STATUS */
  ,TOROKUYMD = ?            /* 12, TOROKUYMD */
  ,TOROKUHMS = ?            /* 13, TOROKUHMS */
  ,TOROKUUSER = ?            /* 14, TOROKUUSER */
  ,KOSINYMD = ?            /* 15, KOSINYMD */
  ,KOSINHMS = ?            /* 16, KOSINHMS */
  ,KOSINUSER = ?            /* 17, KOSINUSER */
  ,BIKO = ?            /* 18, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  TAB_DEF_ID
  ,TAB_DEF_REVISION
  ,TAB_DEF_NAME
  ,LAST_UPDATE_YMD
  ,LAST_UPDATE_HHMISS
  ,UPDATE_FLG
  ,NEW_FLG
  ,SVN_REVISION
  ,SVN_PATH
  ,EXISTS_FLG
  ,TRKM_STATUS
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
  ,?  /* 2, TAB_DEF_REVISION */
  ,?  /* 3, TAB_DEF_NAME */
  ,?  /* 4, LAST_UPDATE_YMD */
  ,?  /* 5, LAST_UPDATE_HHMISS */
  ,?  /* 6, UPDATE_FLG */
  ,?  /* 7, NEW_FLG */
  ,?  /* 8, SVN_REVISION */
  ,?  /* 9, SVN_PATH */
  ,?  /* 10, EXISTS_FLG */
  ,?  /* 11, TRKM_STATUS */
  ,?  /* 12, TOROKUYMD */
  ,?  /* 13, TOROKUHMS */
  ,?  /* 14, TOROKUUSER */
  ,?  /* 15, KOSINYMD */
  ,?  /* 16, KOSINHMS */
  ,?  /* 17, KOSINUSER */
  ,?  /* 18, BIKO */
)