UPDATE KR_OBJECT_DEPENDENCIES
SET
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
WHERE
  1 = 0