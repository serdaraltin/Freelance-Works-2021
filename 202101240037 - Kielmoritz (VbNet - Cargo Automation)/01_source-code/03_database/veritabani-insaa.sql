USE [master]
GO
/****** Object:  Database [G2FinalKargo]    Script Date: 24.01.2021 00:11:52 ******/
CREATE DATABASE [G2FinalKargo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'G2FinalKargo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\G2FinalKargo.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'G2FinalKargo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\G2FinalKargo_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [G2FinalKargo] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [G2FinalKargo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [G2FinalKargo] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [G2FinalKargo] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [G2FinalKargo] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [G2FinalKargo] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [G2FinalKargo] SET ARITHABORT OFF 
GO
ALTER DATABASE [G2FinalKargo] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [G2FinalKargo] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [G2FinalKargo] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [G2FinalKargo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [G2FinalKargo] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [G2FinalKargo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [G2FinalKargo] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [G2FinalKargo] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [G2FinalKargo] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [G2FinalKargo] SET  DISABLE_BROKER 
GO
ALTER DATABASE [G2FinalKargo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [G2FinalKargo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [G2FinalKargo] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [G2FinalKargo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [G2FinalKargo] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [G2FinalKargo] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [G2FinalKargo] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [G2FinalKargo] SET RECOVERY FULL 
GO
ALTER DATABASE [G2FinalKargo] SET  MULTI_USER 
GO
ALTER DATABASE [G2FinalKargo] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [G2FinalKargo] SET DB_CHAINING OFF 
GO
ALTER DATABASE [G2FinalKargo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [G2FinalKargo] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [G2FinalKargo] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'G2FinalKargo', N'ON'
GO
USE [G2FinalKargo]
GO
/****** Object:  Table [dbo].[Gonderi_Tablosu_F]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gonderi_Tablosu_F](
	[Gonderi_No] [bigint] IDENTITY(1,1) NOT NULL,
	[Gonderi_Tarihi] [datetime] NULL,
	[Sube_No] [int] NULL,
	[Personel_No] [int] NULL,
	[Musteri_No] [int] NULL,
 CONSTRAINT [PK_Gonderi_Tablosu_F] PRIMARY KEY CLUSTERED 
(
	[Gonderi_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Gonderilen_Paket_Tablosu_F]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gonderilen_Paket_Tablosu_F](
	[Gonderi_Paket_No] [bigint] IDENTITY(1,1) NOT NULL,
	[Tur_No] [int] NULL,
	[Tarih] [datetime] NULL,
	[Adres] [nvarchar](250) NULL,
	[Paket_Adedi] [real] NULL,
	[Gonderi_No] [bigint] NULL,
 CONSTRAINT [PK_Gonderilen_Paket_Tablosu_F] PRIMARY KEY CLUSTERED 
(
	[Gonderi_Paket_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Login_Tablosu_F]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Login_Tablosu_F](
	[Kayit_No] [int] IDENTITY(1,1) NOT NULL,
	[User_Name] [nvarchar](20) NULL,
	[Password] [nvarchar](128) NULL,
	[Question] [nvarchar](128) NULL,
	[Answer] [nvarchar](128) NULL,
 CONSTRAINT [PK_Login_Tablosu_F] PRIMARY KEY CLUSTERED 
(
	[Kayit_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Musteri_Tablosu_F]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Musteri_Tablosu_F](
	[Musteri_No] [int] IDENTITY(1,1) NOT NULL,
	[TC_KimlikNo] [nvarchar](11) NULL,
	[Adi] [nvarchar](30) NULL,
	[Soyadi] [nvarchar](25) NULL,
	[Adres] [nvarchar](250) NULL,
 CONSTRAINT [PK_Musteri_Tablosu_F] PRIMARY KEY CLUSTERED 
(
	[Musteri_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Paket_Turleri_Tablosu_F]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Paket_Turleri_Tablosu_F](
	[Tur_No] [int] IDENTITY(1,1) NOT NULL,
	[Tur_Adi] [nvarchar](40) NULL,
	[Paket_Birimi] [nvarchar](20) NULL,
	[Birim_Fiyati] [money] NULL,
 CONSTRAINT [PK_Paket_Turleri_Tablosu_F] PRIMARY KEY CLUSTERED 
(
	[Tur_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Personel_Tablosu_F]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Personel_Tablosu_F](
	[Personel_No] [int] IDENTITY(1,1) NOT NULL,
	[Personel_Adi] [nvarchar](30) NULL,
	[Personel_Soyadi] [nvarchar](25) NULL,
 CONSTRAINT [PK_Personel_Tablosu_F] PRIMARY KEY CLUSTERED 
(
	[Personel_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sube_Tablosu_F]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sube_Tablosu_F](
	[Sube_No] [int] IDENTITY(1,1) NOT NULL,
	[Sube_Adi] [nvarchar](150) NULL,
 CONSTRAINT [PK_Sube_Tablosu_F] PRIMARY KEY CLUSTERED 
(
	[Sube_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Gonderi_Tablosu_F] ON 

INSERT [dbo].[Gonderi_Tablosu_F] ([Gonderi_No], [Gonderi_Tarihi], [Sube_No], [Personel_No], [Musteri_No]) VALUES (1, CAST(N'2021-01-23 21:21:25.947' AS DateTime), 1, 1, 3)
INSERT [dbo].[Gonderi_Tablosu_F] ([Gonderi_No], [Gonderi_Tarihi], [Sube_No], [Personel_No], [Musteri_No]) VALUES (2, CAST(N'2021-01-02 21:21:25.000' AS DateTime), 4, 1, 3)
INSERT [dbo].[Gonderi_Tablosu_F] ([Gonderi_No], [Gonderi_Tarihi], [Sube_No], [Personel_No], [Musteri_No]) VALUES (3, CAST(N'2021-01-07 21:21:25.000' AS DateTime), 2, 1, 4)
INSERT [dbo].[Gonderi_Tablosu_F] ([Gonderi_No], [Gonderi_Tarihi], [Sube_No], [Personel_No], [Musteri_No]) VALUES (4, CAST(N'2021-01-04 23:23:07.000' AS DateTime), 3, 2, 4)
SET IDENTITY_INSERT [dbo].[Gonderi_Tablosu_F] OFF
SET IDENTITY_INSERT [dbo].[Gonderilen_Paket_Tablosu_F] ON 

INSERT [dbo].[Gonderilen_Paket_Tablosu_F] ([Gonderi_Paket_No], [Tur_No], [Tarih], [Adres], [Paket_Adedi], [Gonderi_No]) VALUES (1, 2, CAST(N'2021-01-23 21:52:52.453' AS DateTime), N'deneme Adres', 11, 2)
INSERT [dbo].[Gonderilen_Paket_Tablosu_F] ([Gonderi_Paket_No], [Tur_No], [Tarih], [Adres], [Paket_Adedi], [Gonderi_No]) VALUES (3, 2, CAST(N'2021-01-06 23:22:26.000' AS DateTime), N'sasdasd', 6, 3)
INSERT [dbo].[Gonderilen_Paket_Tablosu_F] ([Gonderi_Paket_No], [Tur_No], [Tarih], [Adres], [Paket_Adedi], [Gonderi_No]) VALUES (4, 2, CAST(N'2021-01-03 23:23:17.000' AS DateTime), N'asdasd', 8, 4)
SET IDENTITY_INSERT [dbo].[Gonderilen_Paket_Tablosu_F] OFF
SET IDENTITY_INSERT [dbo].[Login_Tablosu_F] ON 

INSERT [dbo].[Login_Tablosu_F] ([Kayit_No], [User_Name], [Password], [Question], [Answer]) VALUES (1, N'admin', N'E10ADC3949BA59ABBE56E057F20F883E', N'Anne Adı', N'Medine')
SET IDENTITY_INSERT [dbo].[Login_Tablosu_F] OFF
SET IDENTITY_INSERT [dbo].[Musteri_Tablosu_F] ON 

INSERT [dbo].[Musteri_Tablosu_F] ([Musteri_No], [TC_KimlikNo], [Adi], [Soyadi], [Adres]) VALUES (3, N'12345678910', N'Ahmet', N'Bal', N'denemeAdres')
INSERT [dbo].[Musteri_Tablosu_F] ([Musteri_No], [TC_KimlikNo], [Adi], [Soyadi], [Adres]) VALUES (4, N'12345678911', N'Seda', N'Solgun', N'Adana')
SET IDENTITY_INSERT [dbo].[Musteri_Tablosu_F] OFF
SET IDENTITY_INSERT [dbo].[Paket_Turleri_Tablosu_F] ON 

INSERT [dbo].[Paket_Turleri_Tablosu_F] ([Tur_No], [Tur_Adi], [Paket_Birimi], [Birim_Fiyati]) VALUES (1, N'Tür1', N'Birim1', 17.2500)
INSERT [dbo].[Paket_Turleri_Tablosu_F] ([Tur_No], [Tur_Adi], [Paket_Birimi], [Birim_Fiyati]) VALUES (2, N'Tür2', N'Birim2', 21.2100)
SET IDENTITY_INSERT [dbo].[Paket_Turleri_Tablosu_F] OFF
SET IDENTITY_INSERT [dbo].[Personel_Tablosu_F] ON 

INSERT [dbo].[Personel_Tablosu_F] ([Personel_No], [Personel_Adi], [Personel_Soyadi]) VALUES (1, N'Kadir', N'Yavuz')
INSERT [dbo].[Personel_Tablosu_F] ([Personel_No], [Personel_Adi], [Personel_Soyadi]) VALUES (2, N'Ahmet', N'Kavuş')
INSERT [dbo].[Personel_Tablosu_F] ([Personel_No], [Personel_Adi], [Personel_Soyadi]) VALUES (3, N'Şükrü', N'Yılmaz')
SET IDENTITY_INSERT [dbo].[Personel_Tablosu_F] OFF
SET IDENTITY_INSERT [dbo].[Sube_Tablosu_F] ON 

INSERT [dbo].[Sube_Tablosu_F] ([Sube_No], [Sube_Adi]) VALUES (1, N'A1')
INSERT [dbo].[Sube_Tablosu_F] ([Sube_No], [Sube_Adi]) VALUES (2, N'B1')
INSERT [dbo].[Sube_Tablosu_F] ([Sube_No], [Sube_Adi]) VALUES (3, N'A2')
INSERT [dbo].[Sube_Tablosu_F] ([Sube_No], [Sube_Adi]) VALUES (4, N'B2')
SET IDENTITY_INSERT [dbo].[Sube_Tablosu_F] OFF
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Id='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Gonderi_Tablosu_F_Ekle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Gonderi_Tablosu_F_Ekle]
@Gonderi_Tarihi datetime,
@Sube_No int,
@Personel_No int,
@Musteri_No int

As
Begin
Insert Into Gonderi_Tablosu_F (Gonderi_Tarihi,Sube_No,Personel_No,Musteri_No) Values(@Gonderi_Tarihi,@Sube_No,@Personel_No,@Musteri_No)
End
GO
/****** Object:  StoredProcedure [dbo].[Gonderi_Tablosu_F_Getir]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Gonderi_Tablosu_F_Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Gonderi_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Gonderi_Tablosu_F_Guncelle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[Gonderi_Tablosu_F_Guncelle]
@Id int,
@Gonderi_Tarihi datetime,
@Sube_No int,
@Personel_No int,
@Musteri_No int

As
Begin
Update Gonderi_Tablosu_F Set Gonderi_Tarihi=@Gonderi_Tarihi,Sube_No=@Sube_No,Personel_No=@Personel_No,Musteri_No=@Musteri_No
Where Gonderi_No=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Gonderi_Tablosu_F_Sil]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Gonderi_Tablosu_F_Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Gonderi_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Gonderilen_Paket_Tablosu_F_Ekle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Gonderilen_Paket_Tablosu_F_Ekle]
@Tur_No int,
@Tarih datetime,
@Adres nvarchar(250),
@Paket_Adedi real,
@Gonderi_No bigint

As
Begin
Insert Into Gonderilen_Paket_Tablosu_F (Tur_No,Tarih,Adres,Paket_Adedi,Gonderi_No) Values(@Tur_No,@Tarih,@Adres,@Paket_Adedi,@Gonderi_No)
End
GO
/****** Object:  StoredProcedure [dbo].[Gonderilen_Paket_Tablosu_F_Getir]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Gonderilen_Paket_Tablosu_F_Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Gonderi_Paket_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Gonderilen_Paket_Tablosu_F_Guncelle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[Gonderilen_Paket_Tablosu_F_Guncelle]
@Id int,
@Tur_No int,
@Tarih datetime,
@Adres nvarchar(250),
@Paket_Adedi real,
@Gonderi_No bigint

As
Begin
Update Gonderilen_Paket_Tablosu_F Set Tur_No=@Tur_No,Tarih=@Tarih,Adres=@Adres,Paket_Adedi=@Paket_Adedi,Gonderi_No=@Gonderi_No
Where Gonderi_Paket_No=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Gonderilen_Paket_Tablosu_F_Sil]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Gonderilen_Paket_Tablosu_F_Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Gonderi_Paket_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Kayitlar]
@Tablo varchar(50)
As
Begin
	EXEC('Select * From ' + @Tablo)
End

GO
/****** Object:  StoredProcedure [dbo].[Login_Tablosu_F_Ekle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Login_Tablosu_F_Ekle]
@User_Name nvarchar(20),
@Password nvarchar(128),
@Question nvarchar(128),
@Answer nvarchar(128)

As
Begin
Insert Into Login_Tablosu_F (User_Name,Password,Question,Answer) Values(@User_Name,@Password,@Question,@Answer)
End
GO
/****** Object:  StoredProcedure [dbo].[Login_Tablosu_F_Getir]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Login_Tablosu_F_Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Kayit_No='+@Id)
End

GO
/****** Object:  StoredProcedure [dbo].[Login_Tablosu_F_Guncelle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[Login_Tablosu_F_Guncelle]
@Id int,
@User_Name nvarchar(20),
@Password nvarchar(128),
@Question nvarchar(128),
@Answer nvarchar(128)

As
Begin
Update Login_Tablosu_F Set User_Name=@User_Name,Password=@Password,Question=@Question,Answer=@Answer
Where Kayit_No=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Login_Tablosu_F_Sil]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Login_Tablosu_F_Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Kayit_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Musteri_Tablosu_F_Ekle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Musteri_Tablosu_F_Ekle]
@TC_KimlikNo nvarchar(11),
@Adi nvarchar(30),
@Soyadi nvarchar(30),
@Adres nvarchar(250)

As
Begin
Insert Into Musteri_Tablosu_F (TC_KimlikNo,Adi,Soyadi,Adres) Values(@TC_KimlikNo,@Adi,@Soyadi,@Adres)
End
GO
/****** Object:  StoredProcedure [dbo].[Musteri_Tablosu_F_Getir]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Musteri_Tablosu_F_Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Musteri_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Musteri_Tablosu_F_Guncelle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[Musteri_Tablosu_F_Guncelle]
@Id int,
@TC_KimlikNo nvarchar(11),
@Adi nvarchar(30),
@Soyadi nvarchar(30),
@Adres nvarchar(250)

As
Begin
Update Musteri_Tablosu_F Set TC_KimlikNo=@TC_KimlikNo,Adi=@Adi,Soyadi=@Soyadi,Adres=@Adres
Where Musteri_No=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Musteri_Tablosu_F_Sil]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Musteri_Tablosu_F_Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Musteri_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Paket_Turleri_Tablosu_F_Ekle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Paket_Turleri_Tablosu_F_Ekle]
@Tur_Adi nvarchar(40),
@Paket_Birimi nvarchar(20),
@Birim_Fiyati money

As
Begin
Insert Into Paket_Turleri_Tablosu_F (Tur_Adi,Paket_Birimi,Birim_Fiyati) Values(@Tur_Adi,@Paket_Birimi,@Birim_Fiyati)
End
GO
/****** Object:  StoredProcedure [dbo].[Paket_Turleri_Tablosu_F_Getir]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Paket_Turleri_Tablosu_F_Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Tur_No='+@Id)
End

GO
/****** Object:  StoredProcedure [dbo].[Paket_Turleri_Tablosu_F_Guncelle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[Paket_Turleri_Tablosu_F_Guncelle]
@Id int,
@Tur_Adi nvarchar(40),
@Paket_Birimi nvarchar(20),
@Birim_Fiyati money

As
Begin
Update Paket_Turleri_Tablosu_F Set Tur_Adi=@Tur_Adi,Paket_Birimi=@Paket_Birimi,Birim_Fiyati=@Birim_Fiyati
Where Tur_No=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Paket_Turleri_Tablosu_F_Sil]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Paket_Turleri_Tablosu_F_Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Tur_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Personel_Tablosu_F_Ekle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Personel_Tablosu_F_Ekle]
@Personel_Adi nvarchar(30),
@Personel_Soyadi nvarchar(25)

As
Begin
Insert Into Personel_Tablosu_F (Personel_Adi,Personel_Soyadi) Values(@Personel_Adi,@Personel_Soyadi)
End
GO
/****** Object:  StoredProcedure [dbo].[Personel_Tablosu_F_Getir]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Personel_Tablosu_F_Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Personel_No='+@Id)
End

GO
/****** Object:  StoredProcedure [dbo].[Personel_Tablosu_F_Guncelle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[Personel_Tablosu_F_Guncelle]
@Id int,
@Personel_Adi nvarchar(30),
@Personel_Soyadi nvarchar(25)

As
Begin
Update Personel_Tablosu_F Set Personel_Adi=@Personel_Adi,Personel_Soyadi=@Personel_Soyadi
Where Personel_No=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Personel_Tablosu_F_Sil]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Personel_Tablosu_F_Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Personel_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Id='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Sube_Tablosu_F_Ekle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Sube_Tablosu_F_Ekle]
@Sube_Adi nvarchar(150)

As
Begin
Insert Into Sube_Tablosu_F (Sube_Adi) Values(@Sube_Adi)
End
GO
/****** Object:  StoredProcedure [dbo].[Sube_Tablosu_F_Getir]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Sube_Tablosu_F_Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Sube_No='+@Id)
End
GO
/****** Object:  StoredProcedure [dbo].[Sube_Tablosu_F_Guncelle]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[Sube_Tablosu_F_Guncelle]
@Id int,
@Sube_Adi nvarchar(150)

As
Begin
Update Sube_Tablosu_F Set Sube_Adi=@Sube_Adi
Where Sube_No=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Sube_Tablosu_F_Sil]    Script Date: 24.01.2021 00:11:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Sube_Tablosu_F_Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Sube_No='+@Id)
End
GO
USE [master]
GO
ALTER DATABASE [G2FinalKargo] SET  READ_WRITE 
GO
