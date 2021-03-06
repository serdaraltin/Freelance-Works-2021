USE [master]
GO
/****** Object:  Database [arackiradb]    Script Date: 12.01.2021 06:32:40 ******/
CREATE DATABASE [arackiradb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'arackiradb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\arackiradb.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'arackiradb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\arackiradb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [arackiradb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [arackiradb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [arackiradb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [arackiradb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [arackiradb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [arackiradb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [arackiradb] SET ARITHABORT OFF 
GO
ALTER DATABASE [arackiradb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [arackiradb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [arackiradb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [arackiradb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [arackiradb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [arackiradb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [arackiradb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [arackiradb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [arackiradb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [arackiradb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [arackiradb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [arackiradb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [arackiradb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [arackiradb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [arackiradb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [arackiradb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [arackiradb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [arackiradb] SET RECOVERY FULL 
GO
ALTER DATABASE [arackiradb] SET  MULTI_USER 
GO
ALTER DATABASE [arackiradb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [arackiradb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [arackiradb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [arackiradb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [arackiradb] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'arackiradb', N'ON'
GO
USE [arackiradb]
GO
/****** Object:  Table [dbo].[arac]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[arac](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[marka] [varchar](50) NULL,
	[model] [varchar](50) NULL,
	[yil] [int] NULL,
	[renk] [varchar](50) NULL,
	[fiyat] [float] NULL,
 CONSTRAINT [PK_arac] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kiralama]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[kiralama](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[arac_Id] [int] NULL,
	[musteri_Id] [int] NULL,
	[gun] [int] NULL,
	[tutar] [float] NULL,
 CONSTRAINT [PK_kiralama] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[kullanici]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[kullanici](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kullanici_ad] [varchar](50) NULL,
	[parola] [varchar](50) NULL,
 CONSTRAINT [PK_kullanici] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[musteri]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[musteri](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[tcno] [varchar](50) NULL,
	[ad] [varchar](50) NULL,
	[soyad] [varchar](50) NULL,
	[telefon] [varchar](50) NULL,
	[eposta] [varchar](50) NULL,
	[adres] [varchar](50) NULL,
 CONSTRAINT [PK_musteri] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[arac_Ekle]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[arac_Ekle]
@marka varchar(50),
@model varchar(50),
@yil int,
@renk varchar(50),
@fiyat float

As
Begin
Insert Into arac (marka,model,yil,renk,fiyat) Values(@marka,@model,@yil,@renk,@fiyat)
End
GO
/****** Object:  StoredProcedure [dbo].[arac_Guncelle]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[arac_Guncelle]
@Id int,
@marka varchar(50),
@model varchar(50),
@yil int,
@renk varchar(50),
@fiyat float

As
Begin
Update arac Set marka=@marka,model=@model,yil=@yil,renk=@renk,fiyat=@fiyat
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 12.01.2021 06:32:40 ******/
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
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 12.01.2021 06:32:40 ******/
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
/****** Object:  StoredProcedure [dbo].[kiralama_Ekle]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[kiralama_Ekle]
@arac_Id int,
@musteri_Id int,
@gun int,
@tutar float

As
Begin
Insert Into kiralama (arac_Id,musteri_Id,gun,tutar) Values(@arac_Id,@musteri_Id,@gun,@tutar)
End
GO
/****** Object:  StoredProcedure [dbo].[kiralama_Guncelle]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[kiralama_Guncelle]
@Id int,
@arac_Id int,
@musteri_Id int,
@gun int,
@tutar float

As
Begin
Update kiralama Set arac_Id=@arac_Id,musteri_Id=@musteri_Id,gun=@gun,tutar=@tutar
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[kullanici_Ekle]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[kullanici_Ekle]
@kullanici_ad varchar(50),
@parola varchar(50)

As
Begin
Insert Into kullanici (kullanici_ad,parola) Values(@kullanici_ad,@parola)
End
GO
/****** Object:  StoredProcedure [dbo].[kullanici_Guncelle]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[kullanici_Guncelle]
@Id int,
@kullanici_ad varchar(50),
@parola varchar(50)

As
Begin
Update kullanici Set kullanici_ad=@kullanici_ad,parola=@parola
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[musteri_Ekle]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[musteri_Ekle]
@tcno varchar(12),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(12),
@eposta varchar(12),
@adres text

As
Begin
Insert Into musteri (tcno,ad,soyad,telefon,eposta,adres) Values(@tcno,@ad,@soyad,@telefon,@eposta,@adres)
End
GO
/****** Object:  StoredProcedure [dbo].[musteri_Guncelle]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[musteri_Guncelle]
@Id int,
@tcno varchar(12),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(12),
@eposta varchar(12),
@adres text

As
Begin
Update musteri Set tcno=@tcno,ad=@ad,soyad=@soyad,telefon=@telefon,eposta=@eposta,adres=@adres
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 12.01.2021 06:32:40 ******/
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
/****** Object:  StoredProcedure [dbo].[Yonetici_Kontrol]    Script Date: 12.01.2021 06:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Yonetici_Kontrol]
@kullanici_ad varchar(50),
@parola varchar(50)

As
Begin
Select * From kullanici Where kullanici_ad=@kullanici_ad and parola=@parola
End
GO
USE [master]
GO
ALTER DATABASE [arackiradb] SET  READ_WRITE 
GO
