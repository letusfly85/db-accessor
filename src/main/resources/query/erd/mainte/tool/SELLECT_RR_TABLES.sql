SELECT
   TRKM_ID
  ,TAB_DEF_ID
  ,TABLE_ID
  ,REVISION_AF
  ,REVISION_BF
  ,LOGICAL_TABLE_TAG
  ,LOGICAL_TABLE_NAME
  ,PHYSICAL_TABLE_NAME
  ,TRKM_STATUS
  ,TABLE_COMMENT
  ,SEGOSEI_CHECK_STATUS
  ,TICKET_NUMBER
  ,EXISTS_FLG
FROM
  RR_TABLES
WHERE
  1 = 1
  --TODO