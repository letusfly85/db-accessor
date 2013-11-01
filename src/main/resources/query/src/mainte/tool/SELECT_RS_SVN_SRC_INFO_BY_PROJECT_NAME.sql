SELECT
   HEAD_REVISION
  ,PROJECT_NAME
  ,FILE_NAME
  ,PATH
  ,REVISION
  ,AUTHOR
  ,COMMIT_DATE
  ,COMMIT_HMS
  ,EXTENSION
FROM
  RS_SVN_SRC_INFO
WHERE
  PROJECT_NAME = ?