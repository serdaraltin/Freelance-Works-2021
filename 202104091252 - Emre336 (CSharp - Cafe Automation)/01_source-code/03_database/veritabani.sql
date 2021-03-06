USE [master]
GO
/****** Object:  Database [cafe]    Script Date: 7.04.2021 16:17:38 ******/
CREATE DATABASE [cafe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'cafe', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\cafe.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'cafe_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\cafe_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [cafe] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [cafe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [cafe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [cafe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [cafe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [cafe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [cafe] SET ARITHABORT OFF 
GO
ALTER DATABASE [cafe] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [cafe] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [cafe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [cafe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [cafe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [cafe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [cafe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [cafe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [cafe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [cafe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [cafe] SET  DISABLE_BROKER 
GO
ALTER DATABASE [cafe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [cafe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [cafe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [cafe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [cafe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [cafe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [cafe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [cafe] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [cafe] SET  MULTI_USER 
GO
ALTER DATABASE [cafe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [cafe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [cafe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [cafe] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [cafe]
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 7.04.2021 16:17:38 ******/
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
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 7.04.2021 16:17:38 ******/
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
/****** Object:  StoredProcedure [dbo].[kullanici_Ekle]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[kullanici_Ekle]
@kullaniciAd varchar(50),
@parola varchar(50)

As
Begin
Insert Into kullanici (kullaniciAd,parola) Values(@kullaniciAd,@parola)
End
GO
/****** Object:  StoredProcedure [dbo].[kullanici_Guncelle]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[kullanici_Guncelle]
@Id int,
@kullaniciAd varchar(50),
@parola varchar(50)

As
Begin
Update kullanici Set kullaniciAd=@kullaniciAd,parola=@parola
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[masa_Ekle]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[masa_Ekle]
@no int,
@kapasite int

As
Begin
Insert Into masa (no,kapasite) Values(@no,@kapasite)
End
GO
/****** Object:  StoredProcedure [dbo].[masa_Guncelle]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[masa_Guncelle]
@Id int,
@no int,
@kapasite int

As
Begin
Update masa Set no=@no,kapasite=@kapasite
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[personel_Ekle]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[personel_Ekle]
@tcNo varchar(12),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(12),
@eposta varchar(12),
@adres text,
@maas int

As
Begin
Insert Into personel (tcNo,ad,soyad,telefon,eposta,adres,maas) Values(@tcNo,@ad,@soyad,@telefon,@eposta,@adres,@maas)
End
GO
/****** Object:  StoredProcedure [dbo].[personel_Guncelle]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[personel_Guncelle]
@Id int,
@tcNo varchar(12),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(12),
@eposta varchar(12),
@adres text,
@maas int

As
Begin
Update personel Set tcNo=@tcNo,ad=@ad,soyad=@soyad,telefon=@telefon,eposta=@eposta,adres=@adres,maas=@maas
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 7.04.2021 16:17:38 ******/
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
/****** Object:  StoredProcedure [dbo].[siparis_Ekle]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[siparis_Ekle]
@masaId int,
@personelId int,
@siparisler text,
@tutar int,
@tarih datetime

As
Begin
Insert Into siparis (masaId,personelId,siparisler,tutar,tarih) Values(@masaId,@personelId,@siparisler,@tutar,@tarih)
End
GO
/****** Object:  StoredProcedure [dbo].[siparis_Guncelle]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[siparis_Guncelle]
@Id int,
@masaId int,
@personelId int,
@siparisler text,
@tutar int,
@tarih datetime

As
Begin
Update siparis Set masaId=@masaId,personelId=@personelId,siparisler=@siparisler,tutar=@tutar,tarih=@tarih
Where Id=@Id
End
GO
/****** Object:  Table [dbo].[kullanici]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[kullanici](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kullaniciAd] [varchar](50) NULL,
	[parola] [varchar](50) NULL,
 CONSTRAINT [PK_kullanici] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[masa]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[masa](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[no] [int] NULL,
	[kapasite] [int] NULL,
 CONSTRAINT [PK_masa] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[personel]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[personel](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[tcNo] [varchar](12) NULL,
	[ad] [varchar](50) NULL,
	[soyad] [varchar](50) NULL,
	[telefon] [varchar](12) NULL,
	[eposta] [varchar](12) NULL,
	[adres] [text] NULL,
	[maas] [int] NULL,
 CONSTRAINT [PK_personel] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[siparis]    Script Date: 7.04.2021 16:17:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[siparis](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[masaId] [int] NULL,
	[personelId] [int] NULL,
	[siparisler] [text] NULL,
	[tutar] [int] NULL,
	[tarih] [datetime] NULL,
 CONSTRAINT [PK_siparis] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[kullanici] ON 

INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola]) VALUES (1, N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[kullanici] OFF
SET IDENTITY_INSERT [dbo].[masa] ON 

INSERT [dbo].[masa] ([Id], [no], [kapasite]) VALUES (1, 12, 4)
INSERT [dbo].[masa] ([Id], [no], [kapasite]) VALUES (2, 11, 3)
SET IDENTITY_INSERT [dbo].[masa] OFF
SET IDENTITY_INSERT [dbo].[personel] ON 

INSERT [dbo].[personel] ([Id], [tcNo], [ad], [soyad], [telefon], [eposta], [adres], [maas]) VALUES (1, N'12345678910', N'Ahmet', N'Boran', N'(548) 623-12', N'ahmet@gmail.', N'istanbul esenler', 3200)
INSERT [dbo].[personel] ([Id], [tcNo], [ad], [soyad], [telefon], [eposta], [adres], [maas]) VALUES (2, N'12345678911', N'Veli', N'Kanat', N'(545) 545-55', N'veli@hotmail', N'deneme adres', 3500)
SET IDENTITY_INSERT [dbo].[personel] OFF
SET IDENTITY_INSERT [dbo].[siparis] ON 

INSERT [dbo].[siparis] ([Id], [masaId], [personelId], [siparisler], [tutar], [tarih]) VALUES (1, 1, 1, N'asdasdasd', 45, CAST(0x0000ADFC00C90CC0 AS DateTime))
INSERT [dbo].[siparis] ([Id], [masaId], [personelId], [siparisler], [tutar], [tarih]) VALUES (2, 1, 1, N'deneme sipariş', 100, CAST(0x0000AC5000A78AA0 AS DateTime))
INSERT [dbo].[siparis] ([Id], [masaId], [personelId], [siparisler], [tutar], [tarih]) VALUES (3, 2, 2, N'deneme2 sipariş', 100, CAST(0x0000AF0B0096C990 AS DateTime))
SET IDENTITY_INSERT [dbo].[siparis] OFF
USE [master]
GO
ALTER DATABASE [cafe] SET  READ_WRITE 
GO
