INSERT INTO MS_COLUMN_DICTIONARY
(
   DICT_COLUMN_ID
  ,PHYSICAL_COLUMN_NAME
  ,DATA_TYPE
  ,DATA_LENGTH
  ,DATA_PRECISION
  ,DATA_DEFAULT
  ,ENTITY_FIELD_NAME
  ,ENTITY_FIELD_TYPE
  ,TOROKUYMD
  ,TOROKUHMS
  ,TOROKUUSER
  ,KOSINYMD
  ,KOSINHMS
  ,KOSINUSER
)
VALUES
(
   ? /* 1, DICT_COLUMN_ID */
  ,? /* 2, PHYSICAL_COLUMN_NAME */
  ,? /* 3, DATA_TYPE */
  ,? /* 4, DATA_LENGTH */
  ,? /* 5, DATA_PRECISION */
  ,? /* 6, DATA_DEFAULT */
  ,? /* 7, ENTITY_FIELD_NAME */
  ,? /* 8, ENTITY_FIELD_TYPE */
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
  ,TO_CHAR(SYSDATE,'YYYYMMDD')
  ,TO_CHAR(SYSDATE,'HH24MISS')
  ,SYS_CONTEXT('USERENV','MODULE')
)