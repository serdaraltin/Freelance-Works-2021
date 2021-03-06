USE [master]
GO
/****** Object:  Database [hotel]    Script Date: 8.05.2021 04:51:17 ******/
CREATE DATABASE [hotel]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'hotel', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\hotel.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'hotel_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\hotel_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [hotel] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [hotel].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [hotel] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [hotel] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [hotel] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [hotel] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [hotel] SET ARITHABORT OFF 
GO
ALTER DATABASE [hotel] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [hotel] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [hotel] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [hotel] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [hotel] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [hotel] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [hotel] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [hotel] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [hotel] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [hotel] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [hotel] SET  DISABLE_BROKER 
GO
ALTER DATABASE [hotel] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [hotel] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [hotel] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [hotel] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [hotel] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [hotel] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [hotel] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [hotel] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [hotel] SET  MULTI_USER 
GO
ALTER DATABASE [hotel] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [hotel] SET DB_CHAINING OFF 
GO
ALTER DATABASE [hotel] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [hotel] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [hotel]
GO
/****** Object:  StoredProcedure [dbo].[ControlReg]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[ControlReg]
@Table varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Table+' Where Id='+@Id)
End

GO
/****** Object:  StoredProcedure [dbo].[customer_Add]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[customer_Add]
@secnum varchar(15),
@name varchar(50),
@surname varchar(50),
@sex varchar(6),
@phone varchar(50),
@email varchar(100),
@address text

As
Begin
Insert Into customer (secnum,name,surname,sex,phone,email,address) Values(@secnum,@name,@surname,@sex,@phone,@email,@address)
End

GO
/****** Object:  StoredProcedure [dbo].[customer_Update]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[customer_Update]
@Id int,
@secnum varchar(15),
@name varchar(50),
@surname varchar(50),
@sex varchar(6),
@phone varchar(50),
@email varchar(100),
@address text

As
Begin
Update customer Set secnum=@secnum,name=@name,surname=@surname,sex=@sex,phone=@phone,email=@email,address=@address
Where Id=@Id
End

GO
/****** Object:  StoredProcedure [dbo].[DataList]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[DataList]
@Table varchar(50)
As
Begin
	EXEC('Select * From ' + @Table)
End
GO
/****** Object:  StoredProcedure [dbo].[DeleteReg]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[DeleteReg]
@Table varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Table+' Where Id='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[employees_Add]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[employees_Add]
@secnum varchar(50),
@name varchar(50),
@surname varchar(50),
@phone varchar(50),
@email varchar(100),
@address text,
@salary int

As
Begin
Insert Into employees (secnum,name,surname,phone,email,address,salary) Values(@secnum,@name,@surname,@phone,@email,@address,@salary)
End

GO
/****** Object:  StoredProcedure [dbo].[employees_Update]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[employees_Update]
@Id int,
@secnum varchar(50),
@name varchar(50),
@surname varchar(50),
@phone varchar(50),
@email varchar(100),
@address text,
@salary int

As
Begin
Update employees Set secnum=@secnum,name=@name,surname=@surname,phone=@phone,email=@email,address=@address,salary=@salary
Where Id=@Id
End

GO
/****** Object:  StoredProcedure [dbo].[GetReg]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[GetReg]
@Table varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Table+' Where Id='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[rezarvation_Add]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[rezarvation_Add]
@roomId int,
@customerId int,
@entryDate date,
@releaseDate date,
@price float

As
Begin
Insert Into rezarvation (roomId,customerId,entryDate,releaseDate,price) Values(@roomId,@customerId,@entryDate,@releaseDate,@price)
End

GO
/****** Object:  StoredProcedure [dbo].[rezarvation_Update]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[rezarvation_Update]
@Id int,
@roomId int,
@customerId int,
@entryDate date,
@releaseDate date,
@price float

As
Begin
Update rezarvation Set roomId=@roomId,customerId=@customerId,entryDate=@entryDate,releaseDate=@releaseDate,price=@price
Where Id=@Id
End

GO
/****** Object:  StoredProcedure [dbo].[room_Add]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[room_Add]
@number int,
@layer int,
@type varchar(50)

As
Begin
Insert Into room (number,layer,type) Values(@number,@layer,@type)
End
GO
/****** Object:  StoredProcedure [dbo].[room_Update]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[room_Update]
@Id int,
@number int,
@layer int,
@type varchar(50)

As
Begin
Update room Set number=@number,layer=@layer,type=@type
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[UserControl]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[UserControl]
@username varchar(50),
@password varchar(50)

As
Begin
Select * From users Where username=@username and password=@password
End
GO
/****** Object:  StoredProcedure [dbo].[users_Add]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[users_Add]
@username varchar(50),
@password varchar(50),
@employeesId int

As
Begin
Insert Into users (username,password,employeesId) Values(@username,@password,@employeesId)
End
GO
/****** Object:  StoredProcedure [dbo].[users_Update]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[users_Update]
@Id int,
@username varchar(50),
@password varchar(50),
@employeesId int

As
Begin
Update users Set username=@username,password=@password,employeesId=@employeesId
Where Id=@Id
End
GO
/****** Object:  Table [dbo].[customer]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customer](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[secnum] [varchar](15) NULL,
	[name] [varchar](50) NULL,
	[surname] [varchar](50) NULL,
	[sex] [varchar](6) NULL,
	[phone] [varchar](50) NULL,
	[email] [varchar](100) NULL,
	[address] [text] NULL,
 CONSTRAINT [PK_customers] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[employees]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[employees](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[secnum] [varchar](15) NULL,
	[name] [varchar](50) NULL,
	[surname] [varchar](50) NULL,
	[phone] [varchar](50) NULL,
	[email] [varchar](100) NULL,
	[address] [text] NULL,
	[salary] [int] NULL,
 CONSTRAINT [PK_employees] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[rezarvation]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[rezarvation](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[roomId] [int] NULL,
	[customerId] [int] NULL,
	[entryDate] [date] NULL,
	[releaseDate] [date] NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_rezarvation] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[room]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[room](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[number] [int] NULL,
	[layer] [int] NULL,
	[type] [varchar](50) NULL,
 CONSTRAINT [PK_rooms] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users]    Script Date: 8.05.2021 04:51:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[password] [varchar](50) NULL,
	[employeesId] [int] NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[customer] ON 

INSERT [dbo].[customer] ([Id], [secnum], [name], [surname], [sex], [phone], [email], [address]) VALUES (1, N'12345678910', N'ahmet', N'kivi', N'Man', N'(054) 554-5454', N'ev@gmail.com', N'istanbul')
SET IDENTITY_INSERT [dbo].[customer] OFF
SET IDENTITY_INSERT [dbo].[employees] ON 

INSERT [dbo].[employees] ([Id], [secnum], [name], [surname], [phone], [email], [address], [salary]) VALUES (2, N'12345678912', N'Ferhat', N'Gökçe', N'(546) 975-2132', N'ferhat.gokce@gmail.com', N'adana', 3500)
SET IDENTITY_INSERT [dbo].[employees] OFF
SET IDENTITY_INSERT [dbo].[rezarvation] ON 

INSERT [dbo].[rezarvation] ([Id], [roomId], [customerId], [entryDate], [releaseDate], [price]) VALUES (1, 1, 1, CAST(0x79420B00 AS Date), CAST(0x7D420B00 AS Date), 750)
INSERT [dbo].[rezarvation] ([Id], [roomId], [customerId], [entryDate], [releaseDate], [price]) VALUES (2, 2, 1, CAST(0x78420B00 AS Date), CAST(0x7D420B00 AS Date), 890)
INSERT [dbo].[rezarvation] ([Id], [roomId], [customerId], [entryDate], [releaseDate], [price]) VALUES (3, 3, 2, CAST(0x75420B00 AS Date), CAST(0x7D420B00 AS Date), 1000)
SET IDENTITY_INSERT [dbo].[rezarvation] OFF
SET IDENTITY_INSERT [dbo].[room] ON 

INSERT [dbo].[room] ([Id], [number], [layer], [type]) VALUES (1, 1, 1, N'Single')
INSERT [dbo].[room] ([Id], [number], [layer], [type]) VALUES (2, 2, 3, N'Double')
INSERT [dbo].[room] ([Id], [number], [layer], [type]) VALUES (3, 12, 4, N'Double')
SET IDENTITY_INSERT [dbo].[room] OFF
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([Id], [username], [password], [employeesId]) VALUES (1, N'ev', N'123456', 1)
INSERT [dbo].[users] ([Id], [username], [password], [employeesId]) VALUES (2, N'deneme', N'123456', 1)
INSERT [dbo].[users] ([Id], [username], [password], [employeesId]) VALUES (3, N'admin', N'admin', 1)
SET IDENTITY_INSERT [dbo].[users] OFF
USE [master]
GO
ALTER DATABASE [hotel] SET  READ_WRITE 
GO
