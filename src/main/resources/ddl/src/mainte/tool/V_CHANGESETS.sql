create table v_changesets (
	 revision	number(38,0)
	,committer	varchar2(2000)
	,comments	varchar2(2000)
	,action		varchar2(5)
	,path		varchar2(2000)
	,file_name	varchar2(2000)
	,commit_date	varchar2(8)
	,commit_hms		varchar2(6)
)
;
