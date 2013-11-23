SELECT
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
FROM
  RS_SUBJECTID_BLPATH_IDX
WHERE
    1 = 1
ORDER BY
    PATH,
    SUBJECT_GROUP_ID,
    SUBJECT_ID