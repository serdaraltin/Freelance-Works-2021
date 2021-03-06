USE [master]
GO
/****** Object:  Database [caridb]    Script Date: 9.01.2021 02:24:36 ******/
CREATE DATABASE [caridb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'caridb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\caridb.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'caridb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\caridb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [caridb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [caridb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [caridb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [caridb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [caridb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [caridb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [caridb] SET ARITHABORT OFF 
GO
ALTER DATABASE [caridb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [caridb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [caridb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [caridb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [caridb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [caridb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [caridb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [caridb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [caridb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [caridb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [caridb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [caridb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [caridb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [caridb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [caridb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [caridb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [caridb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [caridb] SET RECOVERY FULL 
GO
ALTER DATABASE [caridb] SET  MULTI_USER 
GO
ALTER DATABASE [caridb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [caridb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [caridb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [caridb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [caridb] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'caridb', N'ON'
GO
USE [caridb]
GO
/****** Object:  UserDefinedFunction [dbo].[fn_alt_kategori_adet]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create function [dbo].[fn_alt_kategori_adet](@kategori_Id int)
returns int
as
Begin
return (select count(*) from kategori where ust_kategori_Id=@kategori_Id)
End
GO
/****** Object:  UserDefinedFunction [dbo].[fn_fatura_toplam]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create function [dbo].[fn_fatura_toplam](@fatura_Id int)
returns int
as
Begin
return (select SUM(tutar) from fatura_urun where fatura_Id=@fatura_Id)
End
GO
/****** Object:  UserDefinedFunction [dbo].[fn_marka_urun_adet]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create function [dbo].[fn_marka_urun_adet](@marka_Id int)
returns int
as
Begin
return (select count(*) from urun where marka_Id=@marka_Id)
End
GO
/****** Object:  UserDefinedFunction [dbo].[fn_tedarik_toplam]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create function [dbo].[fn_tedarik_toplam](@tedarik_Id int)
returns int
as
Begin
return (select SUM(tutar) from stok where tedarik_Id=@tedarik_Id)
End
GO
/****** Object:  UserDefinedFunction [dbo].[karakterDegistir]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[karakterDegistir] (@metin VARCHAR(30))
RETURNS VARCHAR(30)
AS
BEGIN
	SET @metin = LOWER(@metin);
	SET @metin = REPLACE(@metin,'ü','u');
	SET @metin = REPLACE(@metin,'ş','s');
	SET @metin = REPLACE(@metin,'ç','c');
	SET @metin = REPLACE(@metin,'ö','o');
	SET @metin = REPLACE(@metin,'ı','i');
	SET @metin = REPLACE(@metin,'İ','i');
	SET @metin = REPLACE(@metin,'ğ','g');
	RETURN @metin;
END;
GO
/****** Object:  UserDefinedFunction [dbo].[mailAdresi]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[mailAdresi] (@adres VARCHAR(30), @uzanti VARCHAR(30))
RETURNS VARCHAR(50)
AS
BEGIN
	RETURN dbo.karakterDegistir(@adres)+'@'+@uzanti;
END;
GO
/****** Object:  Table [dbo].[fatura]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[fatura](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[musteri_Id] [int] NULL,
	[toplam_tutar] [float] NULL,
	[tarih] [datetime] NULL,
 CONSTRAINT [PK_fatura] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[fatura_urun]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[fatura_urun](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[fatura_Id] [int] NULL,
	[urun_Id] [int] NULL,
	[adet] [datetime] NULL,
	[tutar] [float] NULL,
 CONSTRAINT [PK__fatura__3214EC073B7EE233] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[giris]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[giris](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kullanici_Id] [int] NULL,
	[giris_tarih] [datetime] NULL,
 CONSTRAINT [PK__giris__3214EC07A1FD92DD] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ilce]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ilce](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[sehir_Id] [int] NULL,
	[ad] [varchar](50) NULL,
 CONSTRAINT [PK__ilce__3214EC0782B9006F] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kategori]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[kategori](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ust_kategori_Id] [int] NULL,
	[ad] [varchar](50) NULL,
 CONSTRAINT [PK__kategori__3214EC07AFD8C2EB] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kullanici]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[kullanici](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[yetki] [varchar](50) NULL,
	[kullanici_ad] [varchar](50) NULL,
	[parola] [varchar](50) NULL,
 CONSTRAINT [PK__kullanic__3214EC077ACBA7C8] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kullanici_detay]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[kullanici_detay](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kullanici_Id] [int] NULL,
	[tcno] [varchar](50) NULL,
	[ad] [varchar](50) NULL,
	[soyad] [varchar](50) NULL,
	[dogum_tarih] [date] NULL,
	[telefon] [varchar](50) NULL,
	[eposta] [varchar](50) NULL,
	[sehir_Id] [int] NULL,
	[ilce_Id] [int] NULL,
 CONSTRAINT [PK__kullanic__3214EC07FDA73E3A] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[marka]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[marka](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ust_marka_Id] [int] NULL,
	[ad] [varchar](50) NULL,
	[slogan] [text] NULL,
	[telefon] [varchar](50) NULL,
	[eposta] [varchar](50) NULL,
	[hakkinda] [text] NULL,
 CONSTRAINT [PK__marka__3214EC074A38F72B] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[musteri]    Script Date: 9.01.2021 02:24:36 ******/
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
 CONSTRAINT [PK__musteri__3214EC0712EF76EE] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[musteri_detay]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[musteri_detay](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[musteri_Id] [int] NULL,
	[dogum_tarih] [date] NULL,
	[meslek] [varchar](50) NULL,
	[telefon] [varchar](50) NULL,
	[eposta] [varchar](50) NULL,
	[sehir_Id] [int] NULL,
	[ilce_Id] [int] NULL,
	[adres] [text] NULL,
	[kayit_tarih] [date] NULL,
 CONSTRAINT [PK__musteri___3214EC0780AE7382] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[sehir]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sehir](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [varchar](50) NULL,
	[bolge] [varchar](50) NULL,
	[plaka] [int] NULL,
 CONSTRAINT [PK__sehir__3214EC073ECB1596] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[stok]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[stok](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[urun_Id] [int] NULL,
	[tedarik_Id] [int] NULL,
	[adet] [int] NULL,
	[tutar] [float] NULL,
	[eklenme_tarih] [datetime] NULL,
 CONSTRAINT [PK__stok__3214EC0743E75EA0] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tedarik]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tedarik](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[tedarikci_Id] [int] NULL,
	[cesit] [int] NULL,
	[tutar] [float] NULL,
	[eklenme_tarih] [datetime] NULL,
 CONSTRAINT [PK__tedarik__3214EC078D1D58F0] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tedarikci]    Script Date: 9.01.2021 02:24:36 ******/
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
 CONSTRAINT [PK__tedarikc__3214EC070FD30EA8] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[urun]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[urun](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kategori_Id] [int] NULL,
	[marka_Id] [int] NULL,
	[barkod] [int] NULL,
	[ad] [float] NULL,
 CONSTRAINT [PK__fatura_u__3214EC07B788B55D] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[urun_detay]    Script Date: 9.01.2021 02:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[urun_detay](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[urun_Id] [int] NULL,
	[ozellik] [text] NULL,
	[birim] [varchar](50) NULL,
	[miktar] [float] NULL,
	[aciklama] [text] NULL,
	[eklenme_tarih] [datetime] NULL,
 CONSTRAINT [PK__urun_det__3214EC0760BB1754] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[fatura]  WITH CHECK ADD  CONSTRAINT [FK_fatura_musteri_detay] FOREIGN KEY([musteri_Id])
REFERENCES [dbo].[musteri_detay] ([Id])
GO
ALTER TABLE [dbo].[fatura] CHECK CONSTRAINT [FK_fatura_musteri_detay]
GO
ALTER TABLE [dbo].[fatura_urun]  WITH CHECK ADD  CONSTRAINT [FK_fatura_urun_fatura] FOREIGN KEY([fatura_Id])
REFERENCES [dbo].[fatura] ([Id])
GO
ALTER TABLE [dbo].[fatura_urun] CHECK CONSTRAINT [FK_fatura_urun_fatura]
GO
ALTER TABLE [dbo].[fatura_urun]  WITH CHECK ADD  CONSTRAINT [FK_fatura_urun_urun] FOREIGN KEY([urun_Id])
REFERENCES [dbo].[urun] ([Id])
GO
ALTER TABLE [dbo].[fatura_urun] CHECK CONSTRAINT [FK_fatura_urun_urun]
GO
ALTER TABLE [dbo].[giris]  WITH CHECK ADD  CONSTRAINT [FK_giris_kullanici] FOREIGN KEY([kullanici_Id])
REFERENCES [dbo].[kullanici] ([Id])
GO
ALTER TABLE [dbo].[giris] CHECK CONSTRAINT [FK_giris_kullanici]
GO
ALTER TABLE [dbo].[ilce]  WITH CHECK ADD  CONSTRAINT [FK_ilce_sehir] FOREIGN KEY([sehir_Id])
REFERENCES [dbo].[sehir] ([Id])
GO
ALTER TABLE [dbo].[ilce] CHECK CONSTRAINT [FK_ilce_sehir]
GO
ALTER TABLE [dbo].[kategori]  WITH CHECK ADD  CONSTRAINT [FK_kategori_kategori] FOREIGN KEY([ust_kategori_Id])
REFERENCES [dbo].[kategori] ([Id])
GO
ALTER TABLE [dbo].[kategori] CHECK CONSTRAINT [FK_kategori_kategori]
GO
ALTER TABLE [dbo].[kullanici_detay]  WITH CHECK ADD  CONSTRAINT [FK_kullanici_detay_ilce] FOREIGN KEY([ilce_Id])
REFERENCES [dbo].[ilce] ([Id])
GO
ALTER TABLE [dbo].[kullanici_detay] CHECK CONSTRAINT [FK_kullanici_detay_ilce]
GO
ALTER TABLE [dbo].[kullanici_detay]  WITH CHECK ADD  CONSTRAINT [FK_kullanici_detay_kullanici] FOREIGN KEY([kullanici_Id])
REFERENCES [dbo].[kullanici] ([Id])
GO
ALTER TABLE [dbo].[kullanici_detay] CHECK CONSTRAINT [FK_kullanici_detay_kullanici]
GO
ALTER TABLE [dbo].[kullanici_detay]  WITH CHECK ADD  CONSTRAINT [FK_kullanici_detay_sehir] FOREIGN KEY([sehir_Id])
REFERENCES [dbo].[sehir] ([Id])
GO
ALTER TABLE [dbo].[kullanici_detay] CHECK CONSTRAINT [FK_kullanici_detay_sehir]
GO
ALTER TABLE [dbo].[marka]  WITH CHECK ADD  CONSTRAINT [FK_marka_marka] FOREIGN KEY([ust_marka_Id])
REFERENCES [dbo].[marka] ([Id])
GO
ALTER TABLE [dbo].[marka] CHECK CONSTRAINT [FK_marka_marka]
GO
ALTER TABLE [dbo].[musteri_detay]  WITH CHECK ADD  CONSTRAINT [FK_musteri_detay_ilce] FOREIGN KEY([ilce_Id])
REFERENCES [dbo].[ilce] ([Id])
GO
ALTER TABLE [dbo].[musteri_detay] CHECK CONSTRAINT [FK_musteri_detay_ilce]
GO
ALTER TABLE [dbo].[musteri_detay]  WITH CHECK ADD  CONSTRAINT [FK_musteri_detay_musteri] FOREIGN KEY([musteri_Id])
REFERENCES [dbo].[musteri] ([Id])
GO
ALTER TABLE [dbo].[musteri_detay] CHECK CONSTRAINT [FK_musteri_detay_musteri]
GO
ALTER TABLE [dbo].[musteri_detay]  WITH CHECK ADD  CONSTRAINT [FK_musteri_detay_sehir] FOREIGN KEY([sehir_Id])
REFERENCES [dbo].[sehir] ([Id])
GO
ALTER TABLE [dbo].[musteri_detay] CHECK CONSTRAINT [FK_musteri_detay_sehir]
GO
ALTER TABLE [dbo].[stok]  WITH CHECK ADD  CONSTRAINT [FK_stok_tedarik] FOREIGN KEY([tedarik_Id])
REFERENCES [dbo].[tedarik] ([Id])
GO
ALTER TABLE [dbo].[stok] CHECK CONSTRAINT [FK_stok_tedarik]
GO
ALTER TABLE [dbo].[stok]  WITH CHECK ADD  CONSTRAINT [FK_stok_urun] FOREIGN KEY([urun_Id])
REFERENCES [dbo].[urun] ([Id])
GO
ALTER TABLE [dbo].[stok] CHECK CONSTRAINT [FK_stok_urun]
GO
ALTER TABLE [dbo].[tedarik]  WITH CHECK ADD  CONSTRAINT [FK_tedarik_tedarikci] FOREIGN KEY([tedarikci_Id])
REFERENCES [dbo].[tedarikci] ([Id])
GO
ALTER TABLE [dbo].[tedarik] CHECK CONSTRAINT [FK_tedarik_tedarikci]
GO
ALTER TABLE [dbo].[urun]  WITH CHECK ADD  CONSTRAINT [FK_urun_kategori] FOREIGN KEY([kategori_Id])
REFERENCES [dbo].[kategori] ([Id])
GO
ALTER TABLE [dbo].[urun] CHECK CONSTRAINT [FK_urun_kategori]
GO
ALTER TABLE [dbo].[urun]  WITH CHECK ADD  CONSTRAINT [FK_urun_marka] FOREIGN KEY([marka_Id])
REFERENCES [dbo].[marka] ([Id])
GO
ALTER TABLE [dbo].[urun] CHECK CONSTRAINT [FK_urun_marka]
GO
ALTER TABLE [dbo].[urun_detay]  WITH CHECK ADD  CONSTRAINT [FK_urun_detay_urun] FOREIGN KEY([urun_Id])
REFERENCES [dbo].[urun] ([Id])
GO
ALTER TABLE [dbo].[urun_detay] CHECK CONSTRAINT [FK_urun_detay_urun]
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 9.01.2021 02:24:36 ******/
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
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 9.01.2021 02:24:36 ******/
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
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 9.01.2021 02:24:36 ******/
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
USE [master]
GO
ALTER DATABASE [caridb] SET  READ_WRITE 
GO
