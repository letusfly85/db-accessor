MERGE INTO RR_ERD_RELEASES
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  AF_RELEASE_ID = ?             /* 1, AF_RELEASE_ID */
  ,BF_RELEASE_ID = ?            /* 2, BF_RELEASE_ID */
  ,OBJECT_TYPE = ?            /* 3, OBJECT_TYPE */
  ,OBJECT_ID = ?            /* 4, OBJECT_ID */
  ,REVISION = ?            /* 5, REVISION */
  ,OBJECT_NAME = ?            /* 6, OBJECT_NAME */
  ,DIFF_TYPE = ?            /* 7, DIFF_TYPE */
  ,TOROKUYMD = ?            /* 8, TOROKUYMD */
  ,TOROKUHMS = ?            /* 9, TOROKUHMS */
  ,TOROKUUSER = ?            /* 10, TOROKUUSER */
  ,KOSINYMD = ?            /* 11, KOSINYMD */
  ,KOSINHMS = ?            /* 12, KOSINHMS */
  ,KOSINUSER = ?            /* 13, KOSINUSER */
  ,BIKO = ?            /* 14, BIKO */
-- 新規レコードの作成
WHEN NOT MATCHED THEN
INSERT (
  AF_RELEASE_ID
  ,BF_RELEASE_ID
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
  ?   /* 1, AF_RELEASE_ID */
  ,?  /* 2, BF_RELEASE_ID */
  ,?  /* 3, OBJECT_TYPE */
  ,?  /* 4, OBJECT_ID */
  ,?  /* 5, REVISION */
  ,?  /* 6, OBJECT_NAME */
  ,?  /* 7, DIFF_TYPE */
  ,?  /* 8, TOROKUYMD */
  ,?  /* 9, TOROKUHMS */
  ,?  /* 10, TOROKUUSER */
  ,?  /* 11, KOSINYMD */
  ,?  /* 12, KOSINHMS */
  ,?  /* 13, KOSINUSER */
  ,?  /* 14, BIKO */
)