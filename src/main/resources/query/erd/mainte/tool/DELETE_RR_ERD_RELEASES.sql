DELETE FROM RR_ERD_RELEASES
WHERE
      1 = 1
AND AF_RELEASE_ID = ?
AND OBJECT_TYPE   = ?
AND OBJECT_NAME   = ?