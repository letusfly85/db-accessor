MERGE INTO KR_OBJECT_DEPENDENCIES
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  DEPENDENT_GRP_CD = ?             /* 1, DEPENDENT_GRP_CD */
  ,DEPENDENT_CD = ?            /* 2, DEPENDENT_CD */
  ,REFFERED_OWNER = ?            /* 3, REFFERED_OWNER */
  ,OBJECT_OWNER = ?            /* 4, OBJECT_OWNER */
  ,BACKUP_OWNER = ?            /* 5, BACKUP_OWNER */
  ,IF_FLG = ?            /* 6, IF_FLG */
  ,MASTER_DATA_CHECK_FLG = ?            /* 7, MASTER_DATA_CHECK_FLG */
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
  DEPENDENT_GRP_CD
  ,DEPENDENT_CD
  ,REFFERED_OWNER
  ,OBJECT_OWNER
  ,BACKUP_OWNER
  ,IF_FLG
  ,MASTER_DATA_CHECK_FLG
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
  ?   /* 1, DEPENDENT_GRP_CD */
  ,?  /* 2, DEPENDENT_CD */
  ,?  /* 3, REFFERED_OWNER */
  ,?  /* 4, OBJECT_OWNER */
  ,?  /* 5, BACKUP_OWNER */
  ,?  /* 6, IF_FLG */
  ,?  /* 7, MASTER_DATA_CHECK_FLG */
  ,?  /* 8, TOROKUYMD */
  ,?  /* 9, TOROKUHMS */
  ,?  /* 10, TOROKUUSER */
  ,?  /* 11, KOSINYMD */
  ,?  /* 12, KOSINHMS */
  ,?  /* 13, KOSINUSER */
  ,?  /* 14, BIKO */
)