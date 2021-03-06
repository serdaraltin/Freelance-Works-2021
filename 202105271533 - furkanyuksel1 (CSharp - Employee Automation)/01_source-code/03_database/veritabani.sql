USE [master]
GO
/****** Object:  Database [personeltakip]    Script Date: 5/26/2021 5:35:49 PM ******/
CREATE DATABASE [personeltakip]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'personeltakip', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\personeltakip.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'personeltakip_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\personeltakip_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [personeltakip] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [personeltakip].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [personeltakip] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [personeltakip] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [personeltakip] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [personeltakip] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [personeltakip] SET ARITHABORT OFF 
GO
ALTER DATABASE [personeltakip] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [personeltakip] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [personeltakip] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [personeltakip] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [personeltakip] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [personeltakip] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [personeltakip] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [personeltakip] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [personeltakip] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [personeltakip] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [personeltakip] SET  DISABLE_BROKER 
GO
ALTER DATABASE [personeltakip] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [personeltakip] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [personeltakip] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [personeltakip] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [personeltakip] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [personeltakip] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [personeltakip] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [personeltakip] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [personeltakip] SET  MULTI_USER 
GO
ALTER DATABASE [personeltakip] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [personeltakip] SET DB_CHAINING OFF 
GO
ALTER DATABASE [personeltakip] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [personeltakip] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [personeltakip]
GO
/****** Object:  StoredProcedure [dbo].[departman_Ekle]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[departman_Ekle]
@ad varchar(50),
@amac varchar(50),
@aciklama text

As
Begin
Insert Into departman (ad,amac,aciklama) Values(@ad,@amac,@aciklama)
End
GO
/****** Object:  StoredProcedure [dbo].[departman_Guncelle]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Proc [dbo].[departman_Guncelle]
@Id int,
@ad varchar(50),
@amac varchar(50),
@aciklama text

As
Begin
Update departman Set ad=@ad,amac=@amac,aciklama=@aciklama
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 5/26/2021 5:35:49 PM ******/
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
/****** Object:  StoredProcedure [dbo].[izin_Ekle]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[izin_Ekle]
@personelId int,
@tur varchar(50),
@aciklama text,
@baslangicTarih varchar(50),
@bitisTarih varchar(50)

As
Begin
Insert Into izin (personelId,tur,aciklama,baslangicTarih,bitisTarih) Values(@personelId,@tur,@aciklama,@baslangicTarih,@bitisTarih)
End
GO
/****** Object:  StoredProcedure [dbo].[izin_Guncelle]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[izin_Guncelle]
@Id int,
@personelId int,
@tur varchar(50),
@aciklama text,
@baslangicTarih varchar(50),
@bitisTarih varchar(50)

As
Begin
Update izin Set personelId=@personelId,tur=@tur,aciklama=@aciklama,baslangicTarih=@baslangicTarih,bitisTarih=@bitisTarih
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 5/26/2021 5:35:49 PM ******/
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
/****** Object:  StoredProcedure [dbo].[kullanici_Ekle]    Script Date: 5/26/2021 5:35:49 PM ******/
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
/****** Object:  StoredProcedure [dbo].[kullanici_Guncelle]    Script Date: 5/26/2021 5:35:49 PM ******/
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
/****** Object:  StoredProcedure [dbo].[Kullanici_Kontrol]    Script Date: 5/26/2021 5:35:49 PM ******/
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
/****** Object:  StoredProcedure [dbo].[mesai_Ekle]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[mesai_Ekle]
@personelId int,
@tarih varchar(50),
@sure int,
@ucret int

As
Begin
Insert Into mesai (personelId,tarih,sure,ucret) Values(@personelId,@tarih,@sure,@ucret)
End
GO
/****** Object:  StoredProcedure [dbo].[mesai_Guncelle]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[mesai_Guncelle]
@Id int,
@personelId int,
@tarih varchar(50),
@sure int,
@ucret int

As
Begin
Update mesai Set personelId=@personelId,tarih=@tarih,sure=@sure,ucret=@ucret
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[personel_Ekle]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[personel_Ekle]
@tcNo varchar(50),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(50),
@eposta varchar(50),
@adres text,
@departmanId int,
@maas int

As
Begin
Insert Into personel (tcNo,ad,soyad,telefon,eposta,adres,departmanId,maas) Values(@tcNo,@ad,@soyad,@telefon,@eposta,@adres,@departmanId,@maas)
End
GO
/****** Object:  StoredProcedure [dbo].[personel_Guncelle]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[personel_Guncelle]
@Id int,
@tcNo varchar(50),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(50),
@eposta varchar(50),
@adres text,
@departmanId int,
@maas int

As
Begin
Update personel Set tcNo=@tcNo,ad=@ad,soyad=@soyad,telefon=@telefon,eposta=@eposta,adres=@adres,departmanId=@departmanId,maas=@maas
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 5/26/2021 5:35:49 PM ******/
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
/****** Object:  Table [dbo].[departman]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[departman](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [varchar](50) NULL,
	[amac] [varchar](50) NULL,
	[aciklama] [text] NULL,
 CONSTRAINT [PK_departman] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[izin]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[izin](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[personelId] [int] NULL,
	[tur] [varchar](50) NULL,
	[aciklama] [text] NULL,
	[baslangicTarih] [varchar](50) NULL,
	[bitisTarih] [varchar](50) NULL,
 CONSTRAINT [PK_izin] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kullanici]    Script Date: 5/26/2021 5:35:49 PM ******/
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
/****** Object:  Table [dbo].[mesai]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[mesai](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[personelId] [int] NULL,
	[tarih] [varchar](50) NULL,
	[sure] [int] NULL,
	[ucret] [int] NULL,
 CONSTRAINT [PK_mesai] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[personel]    Script Date: 5/26/2021 5:35:49 PM ******/
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
	[telefon] [varchar](50) NULL,
	[eposta] [varchar](50) NULL,
	[adres] [text] NULL,
	[departmanId] [int] NULL,
	[maas] [int] NULL,
 CONSTRAINT [PK_personel] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[DepartmanaAitPersoneller]    Script Date: 5/26/2021 5:35:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[DepartmanaAitPersoneller]
AS
SELECT        dbo.departman.ad AS 'Departman Adı', dbo.personel.tcNo, dbo.personel.ad AS Expr1, dbo.personel.soyad, dbo.personel.maas
FROM            dbo.departman INNER JOIN
                         dbo.personel ON dbo.departman.Id = dbo.personel.Id

GO
SET IDENTITY_INSERT [dbo].[departman] ON 

INSERT [dbo].[departman] ([Id], [ad], [amac], [aciklama]) VALUES (1, N'Muhasebe', N'Gelir gider hesaplanmasi', N'deneme aciklamasi deneme')
SET IDENTITY_INSERT [dbo].[departman] OFF
SET IDENTITY_INSERT [dbo].[izin] ON 

INSERT [dbo].[izin] ([Id], [personelId], [tur], [aciklama], [baslangicTarih], [bitisTarih]) VALUES (1, 1, N'Ücretsiz', N'deneme açiklama', N'5/26/2021 5:09:54 PM', N'5/27/2021 5:09:54 PM')
SET IDENTITY_INSERT [dbo].[izin] OFF
SET IDENTITY_INSERT [dbo].[kullanici] ON 

INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola]) VALUES (1, N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[kullanici] OFF
SET IDENTITY_INSERT [dbo].[mesai] ON 

INSERT [dbo].[mesai] ([Id], [personelId], [tarih], [sure], [ucret]) VALUES (1, 1, N'5/26/2021 5:15:11 PM', 12, 170)
SET IDENTITY_INSERT [dbo].[mesai] OFF
SET IDENTITY_INSERT [dbo].[personel] ON 

INSERT [dbo].[personel] ([Id], [tcNo], [ad], [soyad], [telefon], [eposta], [adres], [departmanId], [maas]) VALUES (1, N'12345678911', N'Ahmet', N'bal', N'(545) 789-2123', N'ahmet@mail.com', N'deneme adres', 1, 3000)
SET IDENTITY_INSERT [dbo].[personel] OFF
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "departman"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 136
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "personel"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 136
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 5
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 2010
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'DepartmanaAitPersoneller'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'DepartmanaAitPersoneller'
GO
USE [master]
GO
ALTER DATABASE [personeltakip] SET  READ_WRITE 
GO
