Insert into COIN (SHT_NAM, NAM_CN, SBL_CN) Values ('PEN', 'Nuevo Sol', 'S/');
Insert into COIN (SHT_NAM, NAM_CN, SBL_CN) Values ('USD', 'Dólar Americano', '$');

Insert Into CHANGE (ID_ORG_CN, ID_DST_CN, AMNT_CHG, DT_CHG) Values ((Select ID_CN From COIN Where SHT_NAM = 'PEN'), (Select ID_CN From COIN Where SHT_NAM = 'USD'), 4.080, Current_TimeStamp());