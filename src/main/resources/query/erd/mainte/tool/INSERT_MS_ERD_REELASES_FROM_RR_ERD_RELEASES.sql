INSERT INTO MS_ERD_RELEASES RR(
    RELEASE_ID,
    OBJECT_TYPE,
    OBJECT_ID,
    REVISION,
    OBJECT_NAME,
    DIFF_TYPE,
    TOROKUYMD,
    TOROKUHMS,
    TOROKUUSER,
    KOSINYMD,
    KOSINHMS,
    KOSINUSER
)
SELECT
    ?   /* 1, release_id */,
    'TABLE',
    RR.OBJECT_ID,
    RR.REVISION,
    RR.OBJECT_NAME,
    'S',
    RR.TOROKUYMD,
    RR.TOROKUHMS,
    RR.TOROKUUSER,
    TO_CHAR(SYSDATE,'yyyymmdd'),
    TO_CHAR(SYSDATE,'hh24miss'),
    SYS_CONTEXT('USERENV','MODULE')
FROM
     RR_ERD_RELEASES RR
WHERE
    RR.AF_RELEASE_ID  = ?   /* 2, release_id */
AND RR.OBJECT_TYPE    = 'TABLE'
AND RR.OBJECT_ID NOT IN
(
    SELECT
        M.OBJECT_ID
    FROM
        MS_ERD_RELEASES M
    WHERE
        M.RELEASE_ID = ?   /* 3, release_id */
)