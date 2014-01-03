MERGE INTO MS_ERD_RELEASES
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  RELEASE_ID = ?             /* 1, RELEASE_ID */
  ,OBJECT_TYPE = ?            /* 2, OBJECT_TYPE */
  ,OBJECT_ID = ?            /* 3, OBJECT_ID */
  ,REVISION = ?            /* 4, REVISION */
  ,OBJECT_NAME = ?            /* 5, OBJECT_NAME */
  ,DIFF_TYPE = ?            /* 6, DIFF_TYPE */
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
  RELEASE_ID
  ,OBJECT_TYPE
  ,OBJECT_ID
  ,REVISION
  ,OBJECT_NAME
  ,DIFF_TYPE
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
  ,?  /* 2, OBJECT_TYPE */
  ,?  /* 3, OBJECT_ID */
  ,?  /* 4, REVISION */
  ,?  /* 5, OBJECT_NAME */
  ,?  /* 6, DIFF_TYPE */
  ,?  /* 7, TOROKUYMD */
  ,?  /* 8, TOROKUHMS */
  ,?  /* 9, TOROKUUSER */
  ,?  /* 10, KOSINYMD */
  ,?  /* 11, KOSINHMS */
  ,?  /* 12, KOSINUSER */
  ,?  /* 13, BIKO */
)