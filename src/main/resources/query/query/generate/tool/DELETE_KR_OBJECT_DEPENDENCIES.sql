DELETE FROM KR_OBJECT_DEPENDENCIES
WHERE
    1 = 1
AND DEPENDENT_GRP_CD = ?
AND DEPENDENT_CD     = ?