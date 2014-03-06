select
   tl.REPOSITORY_KIND
  ,tl.REPOSITORY_NAME
  ,tl.ROOT_URL
  ,tl.RIGHT_BASE_URL
  ,tl.LEFT_BASE_URL
  ,tl.REVISION
  ,tl.COMMITTER
  ,tl.COMMENTS
  ,tr.ACTION
  ,tl.PATH
  ,tl.FILE_NAME
  ,tl.COMMIT_YMD
  ,tl.COMMIT_HMS
  ,tl.CHECKSUM_LEFT
  ,tl.CHECKSUM_RIGHT
from
(
select
	t1.*
from
	TR_COMMIT_HISTORY t1
where
	t1.LEFT_BASE_URL = ?
) tl,
(
select
	t1.*
from
	TR_COMMIT_HISTORY t1
where
	t1.RIGHT_BASE_URL = ?
) tr
where
	replace(tl.PATH, tl.LEFT_BASE_URL) = replace(tr.PATH, tr.LEFT_BASE_URL)
and tl.CHECKSUM_LEFT <> tl.CHECKSUM_RIGHT
order by
	 tl.REVISION desc
	,tl.PATH