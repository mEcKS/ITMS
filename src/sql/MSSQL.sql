/****** CREATE TABLE ******/

/*** Database name ITMS ******/
USE [ITMS]
GO


SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

/****** Object:  Table [dbo].[DocRepair] ******/
CREATE TABLE [dbo].[DocRepair](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[dateIn] [varchar](50) NULL,
	[InvNumder] [varchar](50) NULL,
	[SNNumber] [varchar](50) NULL,
	[Name] [varchar](100) NULL,
	[Branches] [nvarchar](100) NULL,
	[Type] [varchar](100) NULL,
	[dateOut] [date] NULL,
	[Status] [varchar](50) NULL,
	[CauseOfFailure] [varchar](50) NULL,
	[AcceptedForRepair] [int] NULL,
	[Info] [varchar](max) NULL,
	[GK] [varchar](50) NULL,
 CONSTRAINT [PK_DocRepair] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[DocMove] ******/
CREATE TABLE [dbo].[DocMove](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[date] [varchar](50) NULL,
	[name] [varchar](100) NULL,
	[department] [varchar](100) NULL,
	[type] [varchar](100) NULL,
	[status] [nchar](10) NULL,
	[info] [varchar](100) NULL,
	[employee] [varchar](100) NULL,
	[inventorynumber] [varchar](100) NULL,
	[serialnumber] [varchar](100) NULL
) ON [PRIMARY]

/****** Object:  Table [dbo].[DirTypeEquipment] ******/
CREATE TABLE [dbo].[DirTypeEquipment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[info] [nvarchar](max) NULL,
 CONSTRAINT [PK_DirTypeEquipment] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[DirBranches] ******/
CREATE TABLE [dbo].[DirBranches](
	[code] [nvarchar](5) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[type] [varchar](50) NOT NULL,
 CONSTRAINT [PK_branches] PRIMARY KEY CLUSTERED
(
	[code] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]


GO

SET ANSI_PADDING OFF
GO

/****** INSERT DEMO DATA ******/

INSERT INTO [dbo].[DirBranches]
           ([code]
           ,[name]
           ,[type])
     VALUES
           ('AC'
           ,'Бухгалтерия'
           , 'Подразделение')

GO

INSERT INTO [dbo].[DirBranches]
           ([code]
           ,[name]
           ,[type])
     VALUES
           ('IEV'
           ,'Киев'
           , 'Филиал')

GO

INSERT INTO [dbo].[DirBranches]
           ([code]
           ,[name]
           ,[type])
     VALUES
           ('DNP'
           ,'Днепропетровск'
           , 'Филиал')
GO

INSERT INTO [dbo].[DirBranches]
           ([code]
           ,[name]
           ,[type])
     VALUES
           ('LWO'
           ,'Львов'
           , 'Филиал')
GO

INSERT INTO [dbo].[DirTypeEquipment]
           ([name]
           )
     VALUES
           ('Системный блок'
           )
GO

INSERT INTO [dbo].[DirTypeEquipment]
           ([name]
           )
     VALUES
           ('Монитор'
           )
GO

INSERT INTO [dbo].[DirTypeEquipment]
           ([name]
           )
     VALUES
           ('Ноутбук'
           )
GO

INSERT INTO [dbo].[DirTypeEquipment]
           ([name]
           )
     VALUES
           ('Стационарный телефон'
           )
GO

INSERT INTO [dbo].[DirTypeEquipment]
           ([name]
           )
     VALUES
           ('МФУ'
           )
GO

INSERT INTO [dbo].[DirTypeEquipment]
           ([name]
           )
     VALUES
           ('Принтер'
           )
GO

INSERT INTO [dbo].[DocMove]
           ([date]
           ,[name]
           ,[department]
           ,[type]
           ,[status]
           ,[info]
           ,[employee]
           ,[inventorynumber]
           ,[serialnumber])
     VALUES
           ('2015-06-12'
           ,'Lenovo G590'
           ,'Киев'
           ,'Ноутбук'
           ,'minus'
           ,''
           ,'Иванов Иван'
           ,'0001'
           ,'678721368')
GO

INSERT INTO [dbo].[DocMove]
           ([date]
           ,[name]
           ,[department]
           ,[type]
           ,[status]
           ,[info]
           ,[employee]
           ,[inventorynumber]
           ,[serialnumber])
     VALUES
           ('2015-06-15'
           ,'Lenovo G590'
           ,'Киев'
           ,'Ноутбук'
           ,'plus'
           ,'пропадает изображение'
           ,'Иванов Иван'
           ,'0001'
           ,'678721368')
GO

INSERT INTO [dbo].[DocRepair]
           ([dateIn]
           ,[InvNumder]
           ,[SNNumber]
           ,[Name]
           ,[Branches]
           ,[Type]
           ,[dateOut]
           ,[Status]
           ,[CauseOfFailure]
           ,[AcceptedForRepair]
           ,[Info]
           ,[GK])
     VALUES
           ('2015-06-12'
           ,'0071'
           ,'0412K1300007'
           ,'Системный блок'
           ,'Львов'
           ,'Системный блок'
           ,'2015-06-15'
           ,'Отправлено'
           ,''
           , 1
           ,'Замена блока питания'
           ,'48000123004')
GO

INSERT INTO [dbo].[DocRepair]
           ([dateIn]
           ,[InvNumder]
           ,[SNNumber]
           ,[Name]
           ,[Branches]
           ,[Type]
           ,[dateOut]
           ,[Status]
           ,[CauseOfFailure]
           ,[AcceptedForRepair]
           ,[Info]
           ,[GK])
     VALUES
           ('2015-06-12'
           ,'0072'
           ,'0412K1300008'
           ,'Системный блок'
           ,'Киев'
           ,'Системный блок'
           ,'2015-06-15'
           ,'Отправлено'
           ,''
           , 1
           ,'Замена блока питания'
           ,'48000123005')
GO

INSERT INTO [dbo].[DocRepair]
           ([dateIn]
           ,[InvNumder]
           ,[SNNumber]
           ,[Name]
           ,[Branches]
           ,[Type]
           ,[dateOut]
           ,[Status]
           ,[CauseOfFailure]
           ,[AcceptedForRepair]
           ,[Info]
           ,[GK])
     VALUES
           ('2015-06-12'
           ,'0073'
           ,'0412K1300009'
           ,'Системный блок'
           ,'Днепропетровск'
           ,'Системный блок'
           ,'2015-06-15'
           ,'Отправлено'
           ,''
           , 1
           ,'Замена блока питания'
           ,'48000123006')
GO