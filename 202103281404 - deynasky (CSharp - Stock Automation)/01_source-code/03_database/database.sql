USE [stock]
GO
/****** Object:  StoredProcedure [dbo].[brand_Add]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[brand_Add]
@brandName varchar(50)

As
Begin
Insert Into brand(brandName) Values(@brandName)
End
GO
/****** Object:  StoredProcedure [dbo].[category_Add]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[category_Add]
@categoryName varchar(50)

As
Begin
Insert Into category (categoryName) Values(@categoryName)
End
GO
/****** Object:  StoredProcedure [dbo].[ControlReg]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[ControlReg]
@TableName varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @TableName+' Where Id='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[DataList]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[DataList]
@TableName varchar(50)
As
Begin
	EXEC('Select * From ' + @TableName)
End
GO
/****** Object:  StoredProcedure [dbo].[DeleteReg]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[DeleteReg]
@TableName varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @TableName+' Where Id='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[GetReg]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[GetReg]
@TableName varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @TableName+' Where Id='+@Id)
End

GO
/****** Object:  StoredProcedure [dbo].[product_Add]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[product_Add]

@productName varchar(50),
@categoryId int,
@brandId int,
@unit varchar(50),
@amount float,
@price float

As
Begin
Insert Into product (productName,categoryId,brandId,unit,amount,price) Values(@productName,@categoryId,@brandId,@unit,@amount,@price)
End
GO
/****** Object:  StoredProcedure [dbo].[product_Update]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[product_Update]
@Id int,
@productName varchar(50),
@categoryId int,
@brandId int,
@unit varchar(50),
@amount float,
@price float

As
Begin
Update product Set productName=@productName,categoryId=@categoryId,brandId=@brandId,unit=@unit,amount=@amount,price=@price
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[sales_Add]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create Proc [dbo].[sales_Add]
@stockId int,
@piece int,
@date date

As
Begin
Insert Into sales (stockId,piece,date) Values(@stockId,@piece,@date)
End
GO
/****** Object:  StoredProcedure [dbo].[sales_Guncelle]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[sales_Guncelle]
@Id int,
@stockId int,
@piece int,
@date date

As
Begin
Update sales Set stockId=@stockId,piece=@piece,date=@date
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[stock_Add]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[stock_Add]
@productId int,
@piece int,
@date date

As
Begin
Insert Into stock (productId,piece,date) Values(@productId,@piece,@date)
End
GO
/****** Object:  StoredProcedure [dbo].[stock_Update]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[stock_Update]
@Id int,
@productId int,
@piece int,
@date date

As
Begin
Update stock Set productId=@productId,piece=@piece,date=@date
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[user_Add]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[user_Add]
@userName varchar(50),
@password varchar(50)

As
Begin
Insert Into users (userName,password) Values(@userName,@password)
End
GO
/****** Object:  StoredProcedure [dbo].[UserControl]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[UserControl]
@userName varchar(50),
@password varchar(50)

As
Begin
Select * From users Where userName=@userName and password=@password
End
GO
/****** Object:  Table [dbo].[brand]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[brand](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[brandName] [varchar](50) NULL,
 CONSTRAINT [PK_marka] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[category]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[category](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[categoryName] [varchar](50) NULL,
 CONSTRAINT [PK_kategori] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[productName] [varchar](100) NULL,
	[categoryId] [int] NULL,
	[brandId] [int] NULL,
	[unit] [varchar](50) NULL,
	[amount] [float] NULL,
	[price] [float] NOT NULL,
 CONSTRAINT [PK_urun] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[sales]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sales](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[stockId] [int] NULL,
	[piece] [int] NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_satis] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[stock]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[stock](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[productId] [int] NULL,
	[piece] [int] NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_stok] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[users]    Script Date: 28.03.2021 00:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[userName] [varchar](50) NULL,
	[password] [varchar](50) NULL,
 CONSTRAINT [PK_kullanici] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[brand] ON 

INSERT [dbo].[brand] ([Id], [brandName]) VALUES (1, N'sütaş')
INSERT [dbo].[brand] ([Id], [brandName]) VALUES (2, N'ülker')
INSERT [dbo].[brand] ([Id], [brandName]) VALUES (3, N'eti')
INSERT [dbo].[brand] ([Id], [brandName]) VALUES (4, N'adidas')
INSERT [dbo].[brand] ([Id], [brandName]) VALUES (5, N'lcwaikiki')
SET IDENTITY_INSERT [dbo].[brand] OFF
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([Id], [categoryName]) VALUES (1, N'elbise')
INSERT [dbo].[category] ([Id], [categoryName]) VALUES (2, N'süt ürünleri')
INSERT [dbo].[category] ([Id], [categoryName]) VALUES (3, N'bakım malzemeleri')
INSERT [dbo].[category] ([Id], [categoryName]) VALUES (4, N'ayakkabı')
INSERT [dbo].[category] ([Id], [categoryName]) VALUES (5, N'elektronik')
SET IDENTITY_INSERT [dbo].[category] OFF
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([Id], [userName], [password]) VALUES (1, N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[users] OFF
