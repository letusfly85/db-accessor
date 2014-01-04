select
	*
from
(
select
	 rank() over (partition by s.FILE_NAME order by s.REVISION desc) rank
	,s.*
from
	v_changesets s
where
	s.COMMIT_DATE > ?
and s.ACTION <> 'D'
and s.PATH like     ?
)
where
	rank = 1