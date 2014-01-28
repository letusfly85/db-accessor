select
	 m.TRKM_ID
	,m.TAB_DEF_ID
	,m.TABLE_ID
	,m.SERVICE_NAME
    ,m.SUBSYSTEM_NAME
	,m.REVISION
	,m.LOGICAL_TABLE_TAG
	,m.LOGICAL_TABLE_NAME
	,m.PHYSICAL_TABLE_NAME
	,m.TRKM_STATUS
	,m.TABLE_COMMENT
	,m.SEGOSEI_CHECK_STATUS
	,m.TICKET_NUMBER
	,m.EXISTS_FLG
from
ms_tables m
,(
select
	cur_object_name
from
	(
	select
		*
	from
	(
		select
			 cur.OBJECT_NAME cur_object_name
			,cur.REVISION    cur_revision
			,pre.OBJECT_NAME pre_object_name
			,pre.REVISION    pre_revision
		from
		(
			select
				 s.OBJECT_NAME
				,s.REVISION
			from
				RR_ERD_RELEASES s
			where
				s.AF_RELEASE_ID = 9999999999
			) cur,
			(
			select
				 s.OBJECT_NAME
				,s.REVISION
			from
				RR_ERD_RELEASES s
		where
			s.BF_RELEASE_ID = ?
		) pre
		where
			pre.OBJECT_NAME(+) =  cur.OBJECT_NAME
		) mst
	where
		mst.PRE_OBJECT_NAME is null
	or	mst.CUR_REVISION <> mst.PRE_REVISION
)
group by
	cur_object_name
) r
where
	m.PHYSICAL_TABLE_NAME = r.CUR_OBJECT_NAME