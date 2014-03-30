update	ms_tables m
set m.SYSTEM_NAME =
	case
		when substr(m.PHYSICAL_TABLE_NAME,1,2) = 'C_'     then 'BI'
		when substr(m.PHYSICAL_TABLE_NAME,1,2) = 'H_'     then 'BI'
		when substr(m.PHYSICAL_TABLE_NAME,1,3) = 'WH_'    then 'BI'
		when substr(m.PHYSICAL_TABLE_NAME,1,4) = 'M_IK'   then 'IKO'
		when substr(m.PHYSICAL_TABLE_NAME,1,6) = 'WI_IK_' then 'IKO'
		when substr(m.PHYSICAL_TABLE_NAME,1,6) = 'WR_IK_' then 'IKO'
		when substr(m.PHYSICAL_TABLE_NAME,1,2) = 'WR'     then 'IF'
		when substr(m.PHYSICAL_TABLE_NAME,1,2) = 'WS'     then 'IF'
		when substr(m.PHYSICAL_TABLE_NAME,1,3) = 'WI'     then 'YUS'
		when substr(m.PHYSICAL_TABLE_NAME,1,2) = 'T_'     then 'YUS'
		when substr(m.PHYSICAL_TABLE_NAME,1,2) = 'M_'     then 'YUS'
		when substr(m.PHYSICAL_TABLE_NAME,1,2) = 'E_'     then 'YUS'
		else 'YUS' end
;

update ms_tables m
set m.SYSTEM_NAME = 'IKO'
where
	m.PHYSICAL_TABLE_NAME in
(
'KNRKKINF_1',
'ANKBKSRK',
'ANKNINF',
'MMINF',
'TKYKNMS',
'TKKRKNMS',
'HJNINF',
'SKKTKYK',
'SKKTKTK',
'SKKTKZK',
'SKKTKSS',
'SKKTKTR',
'SKKTKJG',
'SKKTKGS',
'SKKTKKG',
'KSYRRK',
'KKKHNINF_1',
'KNKSINF'
)
;

