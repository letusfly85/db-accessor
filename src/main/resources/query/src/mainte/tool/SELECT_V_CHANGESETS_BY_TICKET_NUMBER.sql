select
		file_name
	,	revision
	,	COMMITTER
	,	COMMENTS
	,	ACTION
	,	PATH
	,	FILE_NAME
	,	COMMIT_DATE
	,	COMMIT_HMS
from
(
select
	 	REVISION
	,	row_number() over (partition by file_name order by v.REVISION desc) rnk
	,	COMMITTER
	,	COMMENTS
	,	ACTION
	,	PATH
	,	FILE_NAME
	,	COMMIT_DATE
	,	COMMIT_HMS
from
	 v_changesets v
where
	1 = 1
and action <> 'D'
and regexp_substr(v.COMMENTS, '([0-9]+)', 1, 1, 'i') = ?
)
where
	rnk = 1
