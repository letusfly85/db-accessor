MERGE INTO RS_SUBJECTID_BLPATH_IDX
USING DUAL
  ON (
    /* TODO */
  )
-- 既存レコードの更新
WHEN MATCHED THEN
UPDATE SET
  SUBJECT_GROUP_ID = ?             /* 1, SUBJECT_GROUP_ID */
  ,SUBJECT_ID = ?            /* 2, SUBJECT_ID */
  ,PATH = ?            /* 3, PATH */
  ,REVISION = ?            /* 4, REVISION */
  ,UPDATE_FLG = ?            /* 5, UPDATE_FLG */
  ,NEW_FLG = ?            /* 6, NEW_FLG */
  ,FILE_NAME = ?            /* 7, FILE_NAME */
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
  SUBJECT_GROUP_ID
  ,SUBJECT_ID
  ,PATH
  ,REVISION
  ,UPDATE_FLG
  ,NEW_FLG
  ,FILE_NAME
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
  ?   /* 1, SUBJECT_GROUP_ID */
  ,?  /* 2, SUBJECT_ID */
  ,?  /* 3, PATH */
  ,?  /* 4, REVISION */
  ,?  /* 5, UPDATE_FLG */
  ,?  /* 6, NEW_FLG */
  ,?  /* 7, FILE_NAME */
  ,?  /* 8, TOROKUYMD */
  ,?  /* 9, TOROKUHMS */
  ,?  /* 10, TOROKUUSER */
  ,?  /* 11, KOSINYMD */
  ,?  /* 12, KOSINHMS */
  ,?  /* 13, KOSINUSER */
  ,?  /* 14, BIKO */
)