USE [master]
GO
/****** Object:  Database [arackiradb]    Script Date: 5/26/2021 3:37:09 AM ******/
CREATE DATABASE [arackiradb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'arackiradb', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\arackiradb.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'arackiradb_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\arackiradb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [arackiradb] SET COMPATIBILITY_LEVEL = 110
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
ALTER DATABASE [arackiradb] SET AUTO_CREATE_STATISTICS ON 
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
USE [arackiradb]
GO
/****** Object:  StoredProcedure [dbo].[arac_Ekle]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  StoredProcedure [dbo].[arac_Guncelle]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  StoredProcedure [dbo].[GetirSon]    Script Date: 5/26/2021 3:37:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[GetirSon]
@Tablo varchar(50)

As
Begin
EXEC('Select TOP 1 * From '+ @Tablo+' Order By Id Desc')
End



GO
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  StoredProcedure [dbo].[kiralama_Ekle]    Script Date: 5/26/2021 3:37:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[kiralama_Ekle]
@arac_Id int,
@musteri_Id int,
@gun int,
@tutar float,
@baslangicTarih varchar(50),
@bitisTarih varchar(50)

As
Begin
Insert Into kiralama (arac_Id,musteri_Id,gun,tutar,baslangicTarih,bitisTarih) Values(@arac_Id,@musteri_Id,@gun,@tutar,@baslangicTarih,@bitisTarih)
End



GO
/****** Object:  StoredProcedure [dbo].[kiralama_Guncelle]    Script Date: 5/26/2021 3:37:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[kiralama_Guncelle]
@Id int,
@arac_Id int,
@musteri_Id int,
@gun int,
@tutar float,
@baslangicTarih varchar(50),
@bitisTarih varchar(50)

As
Begin
Update kiralama Set arac_Id=@arac_Id,musteri_Id=@musteri_Id,gun=@gun,tutar=@tutar,baslangicTarih=@baslangicTarih,bitisTarih=@bitisTarih
Where Id=@Id
End



GO
/****** Object:  StoredProcedure [dbo].[kullanici_Ekle]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  StoredProcedure [dbo].[kullanici_Guncelle]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  StoredProcedure [dbo].[musteri_Ekle]    Script Date: 5/26/2021 3:37:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[musteri_Ekle]
@tcno varchar(12),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(50),
@eposta varchar(50),
@adres text

As
Begin
Insert Into musteri (tcno,ad,soyad,telefon,eposta,adres) Values(@tcno,@ad,@soyad,@telefon,@eposta,@adres)
End



GO
/****** Object:  StoredProcedure [dbo].[musteri_Guncelle]    Script Date: 5/26/2021 3:37:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[musteri_Guncelle]
@Id int,
@tcno varchar(12),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(50),
@eposta varchar(50),
@adres text

As
Begin
Update musteri Set tcno=@tcno,ad=@ad,soyad=@soyad,telefon=@telefon,eposta=@eposta,adres=@adres
Where Id=@Id
End



GO
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  StoredProcedure [dbo].[Yonetici_Kontrol]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  Table [dbo].[arac]    Script Date: 5/26/2021 3:37:09 AM ******/
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
	[fiyat] [int] NULL,
 CONSTRAINT [PK_arac] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kiralama]    Script Date: 5/26/2021 3:37:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[kiralama](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[arac_Id] [int] NULL,
	[musteri_Id] [int] NULL,
	[gun] [int] NULL,
	[tutar] [int] NULL,
	[baslangicTarih] [varchar](50) NULL,
	[bitisTarih] [varchar](50) NULL,
 CONSTRAINT [PK_kiralama] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kullanici]    Script Date: 5/26/2021 3:37:09 AM ******/
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
/****** Object:  Table [dbo].[musteri]    Script Date: 5/26/2021 3:37:09 AM ******/
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
	[adres] [text] NULL,
 CONSTRAINT [PK_musteri] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[arac] ON 

INSERT [dbo].[arac] ([Id], [marka], [model], [yil], [renk], [fiyat]) VALUES (1, N'Fiat', N'Fiorino', 2019, N'Siyah', 350)
INSERT [dbo].[arac] ([Id], [marka], [model], [yil], [renk], [fiyat]) VALUES (2, N'Citroen', N'Nemo', 2014, N'Gri', 210)
INSERT [dbo].[arac] ([Id], [marka], [model], [yil], [renk], [fiyat]) VALUES (3, N'Toyota', N'Corolla', 2017, N'Siyah', 300)
INSERT [dbo].[arac] ([Id], [marka], [model], [yil], [renk], [fiyat]) VALUES (4, N'Opel', N'Corsa', 2008, N'Siyah', 120)
INSERT [dbo].[arac] ([Id], [marka], [model], [yil], [renk], [fiyat]) VALUES (5, N'Renoult', N'Clio', 2018, N'Gri', 200)
INSERT [dbo].[arac] ([Id], [marka], [model], [yil], [renk], [fiyat]) VALUES (6, N'Jaguar', N'Deneme', 2021, N'Siyah', 650)
SET IDENTITY_INSERT [dbo].[arac] OFF
SET IDENTITY_INSERT [dbo].[kiralama] ON 

INSERT [dbo].[kiralama] ([Id], [arac_Id], [musteri_Id], [gun], [tutar], [baslangicTarih], [bitisTarih]) VALUES (8, 1, 1, 2, 700, N'5/26/2021 3:31:22 AM', N'5/29/2021 3:31:22 AM')
INSERT [dbo].[kiralama] ([Id], [arac_Id], [musteri_Id], [gun], [tutar], [baslangicTarih], [bitisTarih]) VALUES (9, 6, 6, 70, 45500, N'5/26/2021 3:33:53 AM', N'8/4/2021 3:33:53 AM')
SET IDENTITY_INSERT [dbo].[kiralama] OFF
SET IDENTITY_INSERT [dbo].[kullanici] ON 

INSERT [dbo].[kullanici] ([Id], [kullanici_ad], [parola]) VALUES (1, N'admin', N'admin')
INSERT [dbo].[kullanici] ([Id], [kullanici_ad], [parola]) VALUES (2, N'alperendaloglu1', N'ahmetalperen')
SET IDENTITY_INSERT [dbo].[kullanici] OFF
SET IDENTITY_INSERT [dbo].[musteri] ON 

INSERT [dbo].[musteri] ([Id], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (1, N'12345678910', N'Ahmet', N'Balaban', N'(545) 626-5485', N'ahmet@gmail.com', N'test adresi')
INSERT [dbo].[musteri] ([Id], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (2, N'12345678911', N'Kadir', N'Dündar', N'(545) 656-5974', N'kadir@hotmail.com', N'adres test')
INSERT [dbo].[musteri] ([Id], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (3, N'12345678912', N'Burak', N'Güngör', N'(545) 698-7464', N'burakgungor@mail.com', N'deneme adresi')
INSERT [dbo].[musteri] ([Id], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (5, N'12345678914', N'Rauf', N'Yildiz', N'(545) 963-7412', N'raufyildiz@gmail.com', N'deneme adresi')
INSERT [dbo].[musteri] ([Id], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (6, N'12345678915', N'Recep', N'Ivedik', N'(545) 646-8749', N'recepivedik@gmail.com', N'test adres')
SET IDENTITY_INSERT [dbo].[musteri] OFF
USE [master]
GO
ALTER DATABASE [arackiradb] SET  READ_WRITE 
GO
