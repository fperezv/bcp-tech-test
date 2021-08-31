Create Table CHANGE(
    ID_CHG           Integer         Not Null    Auto_Increment,
    ID_ORG_CN        Integer         Not Null,
    ID_DST_CN        Integer         Not Null,
    IN_CHG           TinyInt(1)      Not Null    Default 1,
    AMNT_CHG         Decimal(4,3)    Not Null,
    DT_CHG           TimeStamp       Not Null,
    DAT_CRE          TimeStamp       Not Null    Default Current_TimeStamp(),
    DAT_UPD          TimeStamp       Null,
    Primary Key (ID_CHG)
);

Create Table COIN(
    ID_CN        Integer         Not Null    Auto_Increment,
    SHT_NAM      Varchar(30)     Not Null,
    NAM_CN       Varchar(100)    Not Null,
    SBL_CN       Varchar(5)      Null,
    DAT_CRE      TimeStamp       Not Null    Default Current_TimeStamp(),
    DAT_UPD      TimeStamp       Null,
    Primary Key (ID_CN)
);

Create Table Exchange(
    ID_EXC       Integer         Not Null    Auto_Increment,
    AMNT         Decimal(7,2)    Not Null,
    AMNT_EXCD    Decimal(7,2)    Not Null,
    ID_ORG_CN    Integer         Not Null,
    ID_DST_CN    Integer         Not Null,
    ID_CHG       Integer         Not Null,
    EXCD_AMNT    Decimal(4,3)    Not Null,
    DAT_CRE      TimeStamp       Not Null    Default Current_TimeStamp(),
    DAT_UPD      TimeStamp       Null,
    Primary Key (ID_EXC)
);