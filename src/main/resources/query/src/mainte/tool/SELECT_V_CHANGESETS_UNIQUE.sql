select
	 cs.revision
	,c.from_revision
	,cs.repository_id
	,cs.committer
	,cs.comments
	,c.action
	,c.path
from
	 changesets cs
join changes c on cs.id = c.changeset_id
and cs.revision = ?
and c.path      = ?