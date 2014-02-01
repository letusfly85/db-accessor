UPDATE KR_RELEASE_DIFFS
SET
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
WHERE
  1 = 0