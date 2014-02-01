SELECT
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
FROM
  KR_RELEASE_DIFFS
WHERE
    1 = 1
AND TAG_NAME   = ?
AND HEADER_FLG = 1