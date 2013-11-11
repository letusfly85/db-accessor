SELECT
   HEAD_REVISION
  ,PROJECT_NAME
  ,FILE_NAME
  ,PATH
  ,PERSISTER_NAME
  ,LINE
  ,TEXT
  ,REVISION
  ,AUTHOR
  ,COMMIT_YMD
  ,COMMIT_HMS
  ,EXTENSION
FROM
  RS_SQL_TEXT
WHERE
    1 = 1
AND PATH = ?
AND PERSISTER_NAME = ?
AND TRIM(TEXT) IS NOT NULL
ORDER BY
    LINE DESC
