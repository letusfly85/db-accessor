UPDATE TP_TICKET_NUMBERS4RELEASE
SET
  RELEASE_ID = ?             /* 1, RELEASE_ID */
  ,TRKM_ID = ?            /* 2, TRKM_ID */
  ,TICKET_NUMBER = ?            /* 3, TICKET_NUMBER */
  ,TOROKUYMD = ?            /* 4, TOROKUYMD */
  ,TOROKUHMS = ?            /* 5, TOROKUHMS */
  ,TOROKUUSER = ?            /* 6, TOROKUUSER */
  ,KOSINYMD = ?            /* 7, KOSINYMD */
  ,KOSINHMS = ?            /* 8, KOSINHMS */
  ,KOSINUSER = ?            /* 9, KOSINUSER */
  ,BIKO = ?            /* 10, BIKO */
WHERE
  1 = 0