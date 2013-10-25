INSERT INTO V_CHANGESETS
(
   REVISION
  ,COMMITTER
  ,COMMENTS
  ,ACTION
  ,PATH
  ,FILE_NAME
  ,COMMIT_DATE
  ,COMMIT_HMS
)
VALUES
(
   ? /* 1, REVISION */
  ,? /* 2, COMMITTER */
  ,? /* 3, COMMENTS */
  ,? /* 4, ACTION */
  ,? /* 5, PATH */
  ,? /* 6, FILE_NAME */
  ,? /* 7, COMMIT_DATE */
  ,? /* 8, COMMIT_HMS */
)