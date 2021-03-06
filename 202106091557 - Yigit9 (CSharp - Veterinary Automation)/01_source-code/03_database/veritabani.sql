USE [master]
GO
/****** Object:  Database [veteriner]    Script Date: 6/8/2021 5:08:48 PM ******/
CREATE DATABASE [veteriner]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'veteriner', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\veteriner.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'veteriner_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\veteriner_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [veteriner] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [veteriner].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [veteriner] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [veteriner] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [veteriner] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [veteriner] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [veteriner] SET ARITHABORT OFF 
GO
ALTER DATABASE [veteriner] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [veteriner] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [veteriner] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [veteriner] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [veteriner] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [veteriner] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [veteriner] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [veteriner] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [veteriner] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [veteriner] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [veteriner] SET  DISABLE_BROKER 
GO
ALTER DATABASE [veteriner] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [veteriner] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [veteriner] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [veteriner] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [veteriner] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [veteriner] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [veteriner] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [veteriner] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [veteriner] SET  MULTI_USER 
GO
ALTER DATABASE [veteriner] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [veteriner] SET DB_CHAINING OFF 
GO
ALTER DATABASE [veteriner] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [veteriner] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [veteriner]
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 6/8/2021 5:08:48 PM ******/
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
/****** Object:  StoredProcedure [dbo].[hasta_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[hasta_Ekle]
@sahipId int,
@kimlikNo varchar(50),
@ad varchar(50),
@tur varchar(50),
@cins varchar(50),
@renk varchar(50),
@cinsiyet varchar(5),
@dogumTarih varchar(50)

As
Begin
Insert Into hasta (sahipId,kimlikNo,ad,tur,cins,renk,cinsiyet,dogumTarih) Values(@sahipId,@kimlikNo,@ad,@tur,@cins,@renk,@cinsiyet,@dogumTarih)
End
GO
/****** Object:  StoredProcedure [dbo].[hasta_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[hasta_Guncelle]
@Id int,
@sahipId int,
@kimlikNo varchar(50),
@ad varchar(50),
@tur varchar(50),
@cins varchar(50),
@renk varchar(50),
@cinsiyet varchar(5),
@dogumTarih varchar(50)

As
Begin
Update hasta Set sahipId=@sahipId,kimlikNo=@kimlikNo,ad=@ad,tur=@tur,cins=@cins,renk=@renk,cinsiyet=@cinsiyet,dogumTarih=@dogumTarih
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[hesap_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[hesap_Ekle]
@tarih varchar(50),
@toplam int

As
Begin
Insert Into hesap (tarih,toplam) Values(@tarih,@toplam)
End
GO
/****** Object:  StoredProcedure [dbo].[hesap_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[hesap_Guncelle]
@Id int,
@tarih varchar(50),
@toplam int

As
Begin
Update hesap Set tarih=@tarih,toplam=@toplam
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[ilac_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[ilac_Ekle]
@barkod varchar(50),
@ad varchar(50),
@tur varchar(50),
@yanEtkiler varchar(50)

As
Begin
Insert Into ilac (barkod,ad,tur,yanEtkiler) Values(@barkod,@ad,@tur,@yanEtkiler)
End
GO
/****** Object:  StoredProcedure [dbo].[ilac_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[ilac_Guncelle]
@Id int,
@barkod varchar(50),
@ad varchar(50),
@tur varchar(50),
@yanEtkiler varchar(50)

As
Begin
Update ilac Set barkod=@barkod,ad=@ad,tur=@tur,yanEtkiler=@yanEtkiler
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 6/8/2021 5:08:48 PM ******/
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
/****** Object:  StoredProcedure [dbo].[kullanici_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
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
/****** Object:  StoredProcedure [dbo].[kullanici_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
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
/****** Object:  StoredProcedure [dbo].[Kullanici_Kontrol]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Kullanici_Kontrol]
@kullaniciAd varchar(50),
@parola varchar(50)

As
Begin
Select *From kullanici Where kullaniciAd=@kullaniciAd and parola=@parola
End

GO
/****** Object:  StoredProcedure [dbo].[operasyon_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[operasyon_Ekle]
@hastaId int,
@aciklama text,
@teshis text,
@ilacId int,
@sonuc text,
@tarih varchar(50),
@ucret int

As
Begin
Insert Into operasyon (hastaId,aciklama,teshis,ilacId,sonuc,tarih,ucret) Values(@hastaId,@aciklama,@teshis,@ilacId,@sonuc,@tarih,@ucret)
End
GO
/****** Object:  StoredProcedure [dbo].[operasyon_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[operasyon_Guncelle]
@Id int,
@hastaId int,
@aciklama text,
@teshis text,
@ilacId int,
@sonuc text,
@tarih varchar(50),
@ucret int

As
Begin
Update operasyon Set hastaId=@hastaId,aciklama=@aciklama,teshis=@teshis,ilacId=@ilacId,sonuc=@sonuc,tarih=@tarih,ucret=@ucret
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[personel_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[personel_Ekle]
@tcNo varchar(50),
@ad varchar(50),
@soyad varchar(50),
@cinsiyet varchar(5),
@telefon varchar(50),
@eposta varchar(50),
@adres text,
@meslek varchar(50),
@maas int

As
Begin
Insert Into personel (tcNo,ad,soyad,cinsiyet,telefon,eposta,adres,meslek,maas) Values(@tcNo,@ad,@soyad,@cinsiyet,@telefon,@eposta,@adres,@meslek,@maas)
End
GO
/****** Object:  StoredProcedure [dbo].[personel_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[personel_Guncelle]
@Id int,
@tcNo varchar(50),
@ad varchar(50),
@soyad varchar(50),
@cinsiyet varchar(5),
@telefon varchar(50),
@eposta varchar(50),
@adres text,
@meslek varchar(50),
@maas int

As
Begin
Update personel Set tcNo=@tcNo,ad=@ad,soyad=@soyad,cinsiyet=@cinsiyet,telefon=@telefon,eposta=@eposta,adres=@adres,meslek=@meslek,maas=@maas
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[randevu_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[randevu_Ekle]
@hastaId int,
@tarih varchar(50)

As
Begin
Insert Into randevu (hastaId,tarih) Values(@hastaId,@tarih)
End
GO
/****** Object:  StoredProcedure [dbo].[randevu_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[randevu_Guncelle]
@Id int,
@hastaId int,
@tarih varchar(50)

As
Begin
Update randevu Set hastaId=@hastaId,tarih=@tarih
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[sahip_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[sahip_Ekle]
@hesapId int,
@tcNo varchar(50),
@ad varchar(50),
@soyad varchar(50),
@cinsiyet varchar(5),
@telefon varchar(50),
@eposta varchar(50),
@adres text,
@meslek varchar(50)

As
Begin
Insert Into sahip (hesapId,tcNo,ad,soyad,cinsiyet,telefon,eposta,adres,meslek) Values(@hesapId,@tcNo,@ad,@soyad,@cinsiyet,@telefon,@eposta,@adres,@meslek)
End
GO
/****** Object:  StoredProcedure [dbo].[sahip_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[sahip_Guncelle]
@Id int,
@hesapId int,
@tcNo varchar(50),
@ad varchar(50),
@soyad varchar(50),
@cinsiyet varchar(5),
@telefon varchar(50),
@eposta varchar(50),
@adres text,
@meslek varchar(50)

As
Begin
Update sahip Set hesapId=@hesapId,tcNo=@tcNo,ad=@ad,soyad=@soyad,cinsiyet=@cinsiyet,telefon=@telefon,eposta=@eposta,adres=@adres,meslek=@meslek
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 6/8/2021 5:08:48 PM ******/
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
/****** Object:  StoredProcedure [dbo].[tedarikci_Ekle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tedarikci_Ekle]
@ad varchar(50),
@telefon varchar(50),
@eposta varchar(50),
@adres text

As
Begin
Insert Into tedarikci (ad,telefon,eposta,adres) Values(@ad,@telefon,@eposta,@adres)
End
GO
/****** Object:  StoredProcedure [dbo].[tedarikci_Guncelle]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tedarikci_Guncelle]
@Id int,
@ad varchar(50),
@telefon varchar(50),
@eposta varchar(50),
@adres text

As
Begin
Update tedarikci Set ad=@ad,telefon=@telefon,eposta=@eposta,adres=@adres
Where Id=@Id
End
GO
/****** Object:  Table [dbo].[hasta]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[hasta](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[sahipId] [int] NULL,
	[kimlikNo] [varchar](50) NULL,
	[ad] [varchar](50) NULL,
	[tur] [varchar](50) NULL,
	[cins] [varchar](50) NULL,
	[renk] [varchar](50) NULL,
	[cinsiyet] [varchar](50) NULL,
	[dogumTarih] [varchar](50) NULL,
 CONSTRAINT [PK_hasta] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[hesap]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[hesap](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[tarih] [varchar](50) NULL,
	[toplam] [int] NULL,
 CONSTRAINT [PK_hesap] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ilac]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ilac](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[barkod] [varchar](50) NULL,
	[ad] [varchar](50) NULL,
	[tur] [varchar](50) NULL,
	[yanEtkiler] [text] NULL,
 CONSTRAINT [PK_ilac] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kullanici]    Script Date: 6/8/2021 5:08:48 PM ******/
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
/****** Object:  Table [dbo].[operasyon]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[operasyon](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[hastaId] [int] NULL,
	[aciklama] [text] NULL,
	[teshis] [text] NULL,
	[ilacId] [int] NULL,
	[sonuc] [varchar](50) NULL,
	[tarih] [varchar](50) NULL,
	[ucret] [int] NULL,
 CONSTRAINT [PK_operasyon] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[personel]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[personel](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[tcNo] [varchar](50) NULL,
	[ad] [varchar](50) NULL,
	[soyad] [varchar](50) NULL,
	[cinsiyet] [varchar](5) NULL,
	[telefon] [varchar](50) NULL,
	[eposta] [varchar](50) NULL,
	[adres] [text] NULL,
	[meslek] [varchar](50) NULL,
	[maas] [int] NULL,
 CONSTRAINT [PK_personel] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[randevu]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[randevu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[hastaId] [int] NULL,
	[tarih] [varchar](50) NULL,
 CONSTRAINT [PK_randevu] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[sahip]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sahip](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[hesapId] [int] NULL,
	[tcNo] [varchar](50) NULL,
	[ad] [varchar](50) NULL,
	[soyad] [varchar](50) NULL,
	[cinsiyet] [varchar](5) NULL,
	[telefon] [varchar](50) NULL,
	[eposta] [varchar](50) NULL,
	[adres] [text] NULL,
	[meslek] [varchar](50) NULL,
 CONSTRAINT [PK_sahip] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tedarikci]    Script Date: 6/8/2021 5:08:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tedarikci](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [varchar](50) NULL,
	[telefon] [varchar](50) NULL,
	[eposta] [varchar](50) NULL,
	[adres] [text] NULL,
 CONSTRAINT [PK_tedarikci] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[hasta] ON 

INSERT [dbo].[hasta] ([Id], [sahipId], [kimlikNo], [ad], [tur], [cins], [renk], [cinsiyet], [dogumTarih]) VALUES (1, 1, N'45678912345', N'Yelnaz', N'Köpek', N'K9', N'Kahverengi', N'Disi', N'6/14/2005 3:43:18 PM')
SET IDENTITY_INSERT [dbo].[hasta] OFF
SET IDENTITY_INSERT [dbo].[hesap] ON 

INSERT [dbo].[hesap] ([Id], [tarih], [toplam]) VALUES (1, N'6/3/2021 2:49:11 PM', 252)
SET IDENTITY_INSERT [dbo].[hesap] OFF
SET IDENTITY_INSERT [dbo].[ilac] ON 

INSERT [dbo].[ilac] ([Id], [barkod], [ad], [tur], [yanEtkiler]) VALUES (1, N'1234567', N'Aspirin', N'Tablet', N'ates')
INSERT [dbo].[ilac] ([Id], [barkod], [ad], [tur], [yanEtkiler]) VALUES (2, N'1234578', N'Bioksin', N'Tablet', N'bas dönmesi')
SET IDENTITY_INSERT [dbo].[ilac] OFF
SET IDENTITY_INSERT [dbo].[kullanici] ON 

INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola]) VALUES (1, N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[kullanici] OFF
SET IDENTITY_INSERT [dbo].[operasyon] ON 

INSERT [dbo].[operasyon] ([Id], [hastaId], [aciklama], [teshis], [ilacId], [sonuc], [tarih], [ucret]) VALUES (1, 1, N'deneme açiklama', N'deneme teshis', 1, N'Basarili', N'6/8/2021 4:55:31 PM', 152)
SET IDENTITY_INSERT [dbo].[operasyon] OFF
SET IDENTITY_INSERT [dbo].[personel] ON 

INSERT [dbo].[personel] ([Id], [tcNo], [ad], [soyad], [cinsiyet], [telefon], [eposta], [adres], [meslek], [maas]) VALUES (1, N'12345678910', N'Ahmet', N'Bal', N'Erkek', N'(542) 1259- 5623', N'ahmet@mail.com', N'deneme adres', N'yardimci', 7000)
SET IDENTITY_INSERT [dbo].[personel] OFF
SET IDENTITY_INSERT [dbo].[randevu] ON 

INSERT [dbo].[randevu] ([Id], [hastaId], [tarih]) VALUES (1, 1, N'5/30/2021 3:57:45 PM')
INSERT [dbo].[randevu] ([Id], [hastaId], [tarih]) VALUES (2, 1, N'6/11/2021 3:57:49 PM')
SET IDENTITY_INSERT [dbo].[randevu] OFF
SET IDENTITY_INSERT [dbo].[sahip] ON 

INSERT [dbo].[sahip] ([Id], [hesapId], [tcNo], [ad], [soyad], [cinsiyet], [telefon], [eposta], [adres], [meslek]) VALUES (1, 1, N'12345678911', N'Kadir', N'Dündar', N'Erkek', N'(545) 654-8798', N'kadir@mail.com', N'adana', N'spiker')
SET IDENTITY_INSERT [dbo].[sahip] OFF
SET IDENTITY_INSERT [dbo].[tedarikci] ON 

INSERT [dbo].[tedarikci] ([Id], [ad], [telefon], [eposta], [adres]) VALUES (1, N'Urtasan', N'(545) 887-9879', N'urtasan@mail.com', N'istanbul')
SET IDENTITY_INSERT [dbo].[tedarikci] OFF
USE [master]
GO
ALTER DATABASE [veteriner] SET  READ_WRITE 
GO
