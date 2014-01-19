select
	 x.TICKET_NUMBER
	,x.TRKM_ID
from
(
	SELECT
		 M.TICKET_NUMBER
		,M.TRKM_ID
		,row_number() over (partition by TICKET_NUMBER order by TRKM_ID desc) rank
	FROM
		MS_TABLES M
	WHERE
		1 = 1
	and M.TRKM_ID >=  ?
	and M.TRKM_ID <= ?
) x
where
	x.RANK = 1
