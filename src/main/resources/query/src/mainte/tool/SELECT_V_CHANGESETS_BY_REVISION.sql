select
	 cs.revision
	,c.from_revision
	,cs.repository_id
	,cs.committer
	,cs.comments
	,c.action
	,c.path
	,cs.committed_on as "commit_date"
from
	 changesets cs
join changes c on cs.id = c.changeset_id
and cs.repository_id = 3
and cs.revision >= ?