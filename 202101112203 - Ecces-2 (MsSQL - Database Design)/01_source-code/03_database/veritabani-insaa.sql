USE [master]
GO
/****** Object:  Database [sinavdb]    Script Date: 9.01.2021 14:00:07 ******/
CREATE DATABASE [sinavdb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'sinavdb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\sinavdb.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'sinavdb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\sinavdb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [sinavdb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [sinavdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [sinavdb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [sinavdb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [sinavdb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [sinavdb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [sinavdb] SET ARITHABORT OFF 
GO
ALTER DATABASE [sinavdb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [sinavdb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [sinavdb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [sinavdb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [sinavdb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [sinavdb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [sinavdb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [sinavdb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [sinavdb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [sinavdb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [sinavdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [sinavdb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [sinavdb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [sinavdb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [sinavdb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [sinavdb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [sinavdb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [sinavdb] SET RECOVERY FULL 
GO
ALTER DATABASE [sinavdb] SET  MULTI_USER 
GO
ALTER DATABASE [sinavdb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [sinavdb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [sinavdb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [sinavdb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [sinavdb] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'sinavdb', N'ON'
GO
USE [sinavdb]
GO
/****** Object:  Table [dbo].[bolum]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[bolum](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[fakulte_Id] [int] NULL,
	[bolum_baskan_Id] [int] NULL,
	[bolum_ad] [varchar](50) NULL,
	[lisans_turu] [varchar](50) NULL,
 CONSTRAINT [PK_bolum] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ders]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ders](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[bolum_Id] [int] NULL,
	[ders_ad] [varchar](50) NULL,
	[kredi] [int] NULL,
 CONSTRAINT [PK_ders] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[donem]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[donem](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[donem_ad] [varchar](50) NULL,
	[baslangic_yil] [int] NULL,
	[bitis_yil] [int] NULL,
 CONSTRAINT [PK_donem] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[fakulte]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[fakulte](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[fakulte_ad] [varchar](50) NULL,
	[kurulus_tarih] [date] NULL,
 CONSTRAINT [PK_fakulte] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ogretim_uyesi]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ogretim_uyesi](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[unvan] [varchar](50) NULL,
	[tcno] [varchar](12) NULL,
	[ad] [varchar](50) NULL,
	[soyad] [varchar](50) NULL,
	[telefon] [varchar](12) NULL,
	[eposta] [varchar](12) NULL,
	[adres] [text] NULL,
 CONSTRAINT [PK_ogretim_uyesi] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[sinav]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sinav](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[bolum_Id] [int] NULL,
	[donem_Id] [int] NULL,
	[sinav_tarihi] [date] NULL,
	[sinav_saati] [time](7) NULL,
	[ders_Id] [int] NULL,
	[ogretim_uyesi_Id] [int] NULL,
	[birinci_sinif] [tinyint] NULL,
	[ikinci_sinif] [tinyint] NULL,
	[ucuncu_sinif] [tinyint] NULL,
	[dorduncu_sinif] [tinyint] NULL,
	[sinav_turu] [varchar](50) NULL,
	[sinav_suresi] [varchar](50) NULL,
	[sinav_sekli] [varchar](50) NULL,
 CONSTRAINT [PK_sinav] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[bolum]  WITH CHECK ADD  CONSTRAINT [FK_bolum_fakulte] FOREIGN KEY([fakulte_Id])
REFERENCES [dbo].[fakulte] ([Id])
GO
ALTER TABLE [dbo].[bolum] CHECK CONSTRAINT [FK_bolum_fakulte]
GO
ALTER TABLE [dbo].[bolum]  WITH CHECK ADD  CONSTRAINT [FK_bolum_ogretim_uyesi] FOREIGN KEY([bolum_baskan_Id])
REFERENCES [dbo].[ogretim_uyesi] ([Id])
GO
ALTER TABLE [dbo].[bolum] CHECK CONSTRAINT [FK_bolum_ogretim_uyesi]
GO
ALTER TABLE [dbo].[sinav]  WITH CHECK ADD  CONSTRAINT [FK_sinav_bolum] FOREIGN KEY([bolum_Id])
REFERENCES [dbo].[bolum] ([Id])
GO
ALTER TABLE [dbo].[sinav] CHECK CONSTRAINT [FK_sinav_bolum]
GO
ALTER TABLE [dbo].[sinav]  WITH CHECK ADD  CONSTRAINT [FK_sinav_ders] FOREIGN KEY([ders_Id])
REFERENCES [dbo].[ders] ([Id])
GO
ALTER TABLE [dbo].[sinav] CHECK CONSTRAINT [FK_sinav_ders]
GO
ALTER TABLE [dbo].[sinav]  WITH CHECK ADD  CONSTRAINT [FK_sinav_donem] FOREIGN KEY([donem_Id])
REFERENCES [dbo].[donem] ([Id])
GO
ALTER TABLE [dbo].[sinav] CHECK CONSTRAINT [FK_sinav_donem]
GO
ALTER TABLE [dbo].[sinav]  WITH CHECK ADD  CONSTRAINT [FK_sinav_ogretim_uyesi] FOREIGN KEY([ogretim_uyesi_Id])
REFERENCES [dbo].[ogretim_uyesi] ([Id])
GO
ALTER TABLE [dbo].[sinav] CHECK CONSTRAINT [FK_sinav_ogretim_uyesi]
GO
/****** Object:  StoredProcedure [dbo].[bolum_Ekle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[bolum_Ekle]
@fakulte_Id int,
@bolum_baskan_Id int,
@bolum_ad varchar(50),
@lisans_turu varchar(50)

As
Begin
Insert Into bolum (fakulte_Id,bolum_baskan_Id,bolum_ad,lisans_turu) Values(@fakulte_Id,@bolum_baskan_Id,@bolum_ad,@lisans_turu)
End
GO
/****** Object:  StoredProcedure [dbo].[bolum_Guncelle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[bolum_Guncelle]
@Id int,
@fakulte_Id int,
@bolum_baskan_Id int,
@bolum_ad varchar(50),
@lisans_turu varchar(50)

As
Begin
Update bolum Set fakulte_Id=@fakulte_Id,bolum_baskan_Id=@bolum_baskan_Id,bolum_ad=@bolum_ad,lisans_turu=@lisans_turu
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[ders_Ekle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[ders_Ekle]
@bolum_Id int,
@ders_ad varchar(50),
@kredi int

As
Begin
Insert Into ders (bolum_Id,ders_ad,kredi) Values(@bolum_Id,@ders_ad,@kredi)
End
GO
/****** Object:  StoredProcedure [dbo].[ders_Guncelle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[ders_Guncelle]
@Id int,
@bolum_Id int,
@ders_ad varchar(50),
@kredi int

As
Begin
Update ders Set bolum_Id=@bolum_Id,ders_ad=@ders_ad,kredi=@kredi
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[donem_Ekle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[donem_Ekle]
@donem_ad varchar(50),
@baslangic_yil int,
@bitis_yil int

As
Begin
Insert Into donem (donem_ad,baslangic_yil,bitis_yil) Values(@donem_ad,@baslangic_yil,@bitis_yil)
End
GO
/****** Object:  StoredProcedure [dbo].[donem_Guncelle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[donem_Guncelle]
@Id int,
@donem_ad varchar(50),
@baslangic_yil int,
@bitis_yil int

As
Begin
Update donem Set donem_ad=@donem_ad,baslangic_yil=@baslangic_yil,bitis_yil=@bitis_yil
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[fakulte_Ekle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[fakulte_Ekle]
@fakulte_ad varchar(50),
@kurulus_tarih date

As
Begin
Insert Into fakulte (fakulte_ad,kurulus_tarih) Values(@fakulte_ad,@kurulus_tarih)
End
GO
/****** Object:  StoredProcedure [dbo].[fakulte_Guncelle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[fakulte_Guncelle]
@Id int,
@fakulte_ad varchar(50),
@kurulus_tarih date

As
Begin
Update fakulte Set fakulte_ad=@fakulte_ad,kurulus_tarih=@kurulus_tarih
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 9.01.2021 14:00:07 ******/
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
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 9.01.2021 14:00:07 ******/
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
/****** Object:  StoredProcedure [dbo].[ogretim_uyesi_Ekle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[ogretim_uyesi_Ekle]
@unvan varchar(50),
@tcno varchar(50),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(12),
@eposta varchar(12),
@adres text

As
Begin
Insert Into ogretim_uyesi (unvan,tcno,ad,soyad,telefon,eposta,adres) Values(@unvan,@tcno,@ad,@soyad,@telefon,@eposta,@adres)
End
GO
/****** Object:  StoredProcedure [dbo].[ogretim_uyesi_Guncelle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[ogretim_uyesi_Guncelle]
@Id int,
@unvan varchar(50),
@tcno varchar(12),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(12),
@eposta varchar(12),
@adres text

As
Begin
Update ogretim_uyesi Set unvan=@unvan,tcno=@tcno,ad=@ad,soyad=@soyad,telefon=@telefon,eposta=@eposta,adres=@adres
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 9.01.2021 14:00:07 ******/
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
/****** Object:  StoredProcedure [dbo].[sinav_Ekle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[sinav_Ekle]
@bolum_Id int,
@donem_Id int,
@sinav_tarihi date,
@sinav_saati time,
@ders_Id int,
@ogretim_uyesi_Id int,
@birinci_sinif tinyint,
@ikinci_sinif tinyint,
@ucuncu_sinif tinyint,
@dorduncu_sinif tinyint,
@sinav_turu varchar(50),
@sinav_suresi varchar(50),
@sinav_sekli varchar(50)

As
Begin
Insert Into sinav (bolum_Id,donem_Id,sinav_tarihi,sinav_saati,ders_Id,ogretim_uyesi_Id,birinci_sinif,ikinci_sinif,ucuncu_sinif,dorduncu_sinif,sinav_turu,sinav_suresi,sinav_sekli) Values(@bolum_Id,@donem_Id,@sinav_tarihi,@sinav_saati,@ders_Id,@ogretim_uyesi_Id,@birinci_sinif,@ikinci_sinif,@ucuncu_sinif,@dorduncu_sinif,@sinav_turu,@sinav_suresi,@sinav_sekli)
End
GO
/****** Object:  StoredProcedure [dbo].[sinav_Guncelle]    Script Date: 9.01.2021 14:00:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[sinav_Guncelle]
@Id int,
@bolum_Id int,
@donem_Id int,
@sinav_tarihi date,
@sinav_saati time,
@ders_Id int,
@ogretim_uyesi_Id int,
@birinci_sinif tinyint,
@ikinci_sinif tinyint,
@ucuncu_sinif tinyint,
@dorduncu_sinif tinyint,
@sinav_turu varchar(50),
@sinav_suresi varchar(50),
@sinav_sekli varchar(50)

As
Begin
Update sinav Set bolum_Id=@bolum_Id,donem_Id=@donem_Id,sinav_tarihi=@sinav_tarihi,sinav_saati=@sinav_saati,ders_Id=@ders_Id,ogretim_uyesi_Id=@ogretim_uyesi_Id,birinci_sinif=@birinci_sinif,ikinci_sinif=@ikinci_sinif,ucuncu_sinif=@ucuncu_sinif,dorduncu_sinif=@dorduncu_sinif,sinav_turu=@sinav_turu,sinav_suresi=@sinav_suresi,sinav_sekli=@sinav_sekli
Where Id=@Id
End
GO
USE [master]
GO
ALTER DATABASE [sinavdb] SET  READ_WRITE 
GO
