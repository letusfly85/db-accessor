MERGE INTO KR_RELEASE_DIFFS
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  TAG_NAME = ?             /* 1, TAG_NAME */
  ,FROM_REVISION = ?            /* 2, FROM_REVISION */
  ,TO_REVISION = ?            /* 3, TO_REVISION */
  ,HEADER_FLG = ?            /* 4, HEADER_FLG */
  ,TARGET_ENV_NAME = ?            /* 5, TARGET_ENV_NAME */
  ,TOROKUYMD = ?            /* 6, TOROKUYMD */
  ,TOROKUHMS = ?            /* 7, TOROKUHMS */
  ,TOROKUUSER = ?            /* 8, TOROKUUSER */
  ,KOSINYMD = ?            /* 9, KOSINYMD */
  ,KOSINHMS = ?            /* 10, KOSINHMS */
  ,KOSINUSER = ?            /* 11, KOSINUSER */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  TAG_NAME
  ,FROM_REVISION
  ,TO_REVISION
  ,HEADER_FLG
  ,TARGET_ENV_NAME
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
)
VALUES
(
  ?   /* 1, TAG_NAME */
  ,?  /* 2, FROM_REVISION */
  ,?  /* 3, TO_REVISION */
  ,?  /* 4, HEADER_FLG */
  ,?  /* 5, TARGET_ENV_NAME */
  ,?  /* 6, TOROKUYMD */
  ,?  /* 7, TOROKUHMS */
  ,?  /* 8, TOROKUUSER */
  ,?  /* 9, KOSINYMD */
  ,?  /* 10, KOSINHMS */
  ,?  /* 11, KOSINUSER */
)