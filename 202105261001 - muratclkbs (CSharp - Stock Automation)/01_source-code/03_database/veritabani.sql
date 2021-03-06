USE [master]
GO
/****** Object:  Database [stock]    Script Date: 5/25/2021 11:25:00 AM ******/
CREATE DATABASE [stock]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'stock', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\stock.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'stock_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\stock_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [stock] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [stock].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [stock] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [stock] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [stock] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [stock] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [stock] SET ARITHABORT OFF 
GO
ALTER DATABASE [stock] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [stock] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [stock] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [stock] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [stock] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [stock] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [stock] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [stock] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [stock] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [stock] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [stock] SET  DISABLE_BROKER 
GO
ALTER DATABASE [stock] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [stock] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [stock] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [stock] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [stock] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [stock] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [stock] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [stock] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [stock] SET  MULTI_USER 
GO
ALTER DATABASE [stock] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [stock] SET DB_CHAINING OFF 
GO
ALTER DATABASE [stock] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [stock] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [stock]
GO
/****** Object:  StoredProcedure [dbo].[brand_Add]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[category_Add]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[ControlReg]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[DataList]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[DeleteReg]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[GetReg]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[product_Add]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[product_Update]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[sales_Add]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[sales_Guncelle]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[stock_Add]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[stock_Update]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[user_Add]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  StoredProcedure [dbo].[UserControl]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  Table [dbo].[brand]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  Table [dbo].[category]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  Table [dbo].[product]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  Table [dbo].[sales]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  Table [dbo].[stock]    Script Date: 5/25/2021 11:25:00 AM ******/
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
/****** Object:  Table [dbo].[users]    Script Date: 5/25/2021 11:25:00 AM ******/
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

INSERT [dbo].[brand] ([Id], [brandName]) VALUES (1, N'sütas')
INSERT [dbo].[brand] ([Id], [brandName]) VALUES (2, N'ülker')
INSERT [dbo].[brand] ([Id], [brandName]) VALUES (3, N'eti')
INSERT [dbo].[brand] ([Id], [brandName]) VALUES (4, N'adidas')
INSERT [dbo].[brand] ([Id], [brandName]) VALUES (5, N'lcwaikiki')
SET IDENTITY_INSERT [dbo].[brand] OFF
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([Id], [categoryName]) VALUES (1, N'elbise')
INSERT [dbo].[category] ([Id], [categoryName]) VALUES (2, N'süt ürünleri')
INSERT [dbo].[category] ([Id], [categoryName]) VALUES (3, N'bakim malzemeleri')
INSERT [dbo].[category] ([Id], [categoryName]) VALUES (4, N'ayakkabi')
INSERT [dbo].[category] ([Id], [categoryName]) VALUES (5, N'elektronik')
SET IDENTITY_INSERT [dbo].[category] OFF
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([Id], [productName], [categoryId], [brandId], [unit], [amount], [price]) VALUES (1, N'Deneme Ürün', 1, 1, N'lt', 1, 15)
SET IDENTITY_INSERT [dbo].[product] OFF
SET IDENTITY_INSERT [dbo].[sales] ON 

INSERT [dbo].[sales] ([Id], [stockId], [piece], [date]) VALUES (1, 1, 1, CAST(0x8E420B00 AS Date))
SET IDENTITY_INSERT [dbo].[sales] OFF
SET IDENTITY_INSERT [dbo].[stock] ON 

INSERT [dbo].[stock] ([Id], [productId], [piece], [date]) VALUES (1, 1, 9, CAST(0x8E420B00 AS Date))
SET IDENTITY_INSERT [dbo].[stock] OFF
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([Id], [userName], [password]) VALUES (1, N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[users] OFF
USE [master]
GO
ALTER DATABASE [stock] SET  READ_WRITE 
GO
