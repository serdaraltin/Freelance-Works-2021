USE [master]
GO
/****** Object:  Database [tezdb]    Script Date: 7.01.2021 01:08:45 ******/
CREATE DATABASE [tezdb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'tezdb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\tezdb.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'tezdb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\tezdb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [tezdb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [tezdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [tezdb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [tezdb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [tezdb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [tezdb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [tezdb] SET ARITHABORT OFF 
GO
ALTER DATABASE [tezdb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [tezdb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [tezdb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [tezdb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [tezdb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [tezdb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [tezdb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [tezdb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [tezdb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [tezdb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [tezdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [tezdb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [tezdb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [tezdb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [tezdb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [tezdb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [tezdb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [tezdb] SET RECOVERY FULL 
GO
ALTER DATABASE [tezdb] SET  MULTI_USER 
GO
ALTER DATABASE [tezdb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [tezdb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [tezdb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [tezdb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [tezdb] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'tezdb', N'ON'
GO
USE [tezdb]
GO
/****** Object:  Table [dbo].[tbl_baslik]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_baslik](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[baslik] [text] NULL,
 CONSTRAINT [PK__tbl_basl__3214EC073BE2EF95] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_danisman]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_danisman](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [text] NULL,
	[soyad] [text] NULL,
 CONSTRAINT [PK__tbl_dani__3214EC071C64B459] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_enstitu]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_enstitu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[universite_Id] [int] NULL,
	[ad] [text] NULL,
 CONSTRAINT [PK__tbl_enst__3214EC071BDD0CB2] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_tez]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_tez](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[yazar_Id] [int] NULL,
	[danisman_Id] [int] NULL,
	[universite_Id] [int] NULL,
	[enstitu_Id] [int] NULL,
	[baslik_Id] [int] NULL,
	[tur] [text] NULL,
	[ozet] [text] NULL,
	[dil] [text] NULL,
	[anahtar_kelime] [text] NULL,
	[yil] [int] NULL,
	[sayfa_sayisi] [int] NULL,
	[teslim_tarihi] [date] NULL,
 CONSTRAINT [PK_tbl_tez] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_universite]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_universite](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [text] NULL,
 CONSTRAINT [PK__tbl_univ__3214EC07758E9119] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_yazar]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_yazar](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [text] NULL,
	[soyad] [text] NULL,
 CONSTRAINT [PK__tbl_yaza__3214EC0758837166] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
ALTER TABLE [dbo].[tbl_enstitu]  WITH CHECK ADD  CONSTRAINT [FK_tbl_enstitu_tbl_universite] FOREIGN KEY([universite_Id])
REFERENCES [dbo].[tbl_universite] ([Id])
GO
ALTER TABLE [dbo].[tbl_enstitu] CHECK CONSTRAINT [FK_tbl_enstitu_tbl_universite]
GO
ALTER TABLE [dbo].[tbl_tez]  WITH CHECK ADD  CONSTRAINT [FK_tbl_tez_tbl_baslik] FOREIGN KEY([baslik_Id])
REFERENCES [dbo].[tbl_baslik] ([Id])
GO
ALTER TABLE [dbo].[tbl_tez] CHECK CONSTRAINT [FK_tbl_tez_tbl_baslik]
GO
ALTER TABLE [dbo].[tbl_tez]  WITH CHECK ADD  CONSTRAINT [FK_tbl_tez_tbl_danisman] FOREIGN KEY([danisman_Id])
REFERENCES [dbo].[tbl_danisman] ([Id])
GO
ALTER TABLE [dbo].[tbl_tez] CHECK CONSTRAINT [FK_tbl_tez_tbl_danisman]
GO
ALTER TABLE [dbo].[tbl_tez]  WITH CHECK ADD  CONSTRAINT [FK_tbl_tez_tbl_enstitu] FOREIGN KEY([enstitu_Id])
REFERENCES [dbo].[tbl_enstitu] ([Id])
GO
ALTER TABLE [dbo].[tbl_tez] CHECK CONSTRAINT [FK_tbl_tez_tbl_enstitu]
GO
ALTER TABLE [dbo].[tbl_tez]  WITH CHECK ADD  CONSTRAINT [FK_tbl_tez_tbl_universite] FOREIGN KEY([universite_Id])
REFERENCES [dbo].[tbl_universite] ([Id])
GO
ALTER TABLE [dbo].[tbl_tez] CHECK CONSTRAINT [FK_tbl_tez_tbl_universite]
GO
ALTER TABLE [dbo].[tbl_tez]  WITH CHECK ADD  CONSTRAINT [FK_tbl_tez_tbl_yazar] FOREIGN KEY([yazar_Id])
REFERENCES [dbo].[tbl_yazar] ([Id])
GO
ALTER TABLE [dbo].[tbl_tez] CHECK CONSTRAINT [FK_tbl_tez_tbl_yazar]
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 7.01.2021 01:08:45 ******/
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
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 7.01.2021 01:08:45 ******/
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
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 7.01.2021 01:08:45 ******/
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
/****** Object:  StoredProcedure [dbo].[tbl_baslik_Ekle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_baslik_Ekle]
@baslik text

As
Begin
Insert Into tbl_baslik (baslik) Values(@baslik)
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_baslik_Guncelle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_baslik_Guncelle]
@Id int,
@baslik text

As
Begin
Update tbl_baslik Set baslik=@baslik
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_danisman_Ekle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_danisman_Ekle](
@ad text,
@soyad text)

As
Begin
Insert Into tbl_danisman (ad,soyad) Values(@ad,@soyad)
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_danisman_Guncelle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_danisman_Guncelle]
@Id int,
@ad text,
@soyad text

As
Begin
Update tbl_danisman Set ad=@ad,soyad=@soyad
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_enstitu_Ekle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_enstitu_Ekle]
@universite_Id int,
@ad text

As
Begin
Insert Into tbl_enstitu (universite_Id,ad) Values(@universite_Id,@ad)
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_enstitu_Guncelle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_enstitu_Guncelle]
@Id int,
@universite_Id int,
@ad text

As
Begin
Update tbl_enstitu Set universite_Id=@universite_Id,ad=@ad
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_tez_Ekle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_tez_Ekle]
@yazar_Id int,
@danisman_Id int,
@universite_Id int,
@enstitu_Id int,
@baslik_Id int,
@tur text,
@ozet text,
@yil int,
@dil text,
@sayfa_sayisi int,
@teslim_tarihi date,
@anahtar_kelime text

As
Begin
Insert Into tbl_tez (yazar_Id,danisman_Id,universite_Id,enstitu_Id,baslik_Id,tur,ozet,yil,dil,sayfa_sayisi,teslim_tarihi,anahtar_kelime) Values(@yazar_Id,@danisman_Id,@universite_Id,@enstitu_Id,@baslik_Id,@tur,@ozet,@yil,@dil,@sayfa_sayisi,@teslim_tarihi,@anahtar_kelime)
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_tez_Guncelle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_tez_Guncelle]
@Id int,
@yazar_Id int,
@danisman_Id int,
@universite_Id int,
@enstitu_Id int,
@baslik_Id int,
@tur text,
@ozet text,
@yil int,
@dil text,
@sayfa_sayisi int,
@teslim_tarihi date,
@anahtar_kelime text

As
Begin
Update tbl_tez Set yazar_Id=@yazar_Id,danisman_Id=@danisman_Id,universite_Id=@universite_Id,enstitu_Id=@enstitu_Id,baslik_Id=@baslik_Id,tur=@tur,ozet=@ozet,yil=@yil,dil=@dil,sayfa_sayisi=@sayfa_sayisi,teslim_tarihi=@teslim_tarihi,anahtar_kelime=@anahtar_kelime
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_universite_Ekle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_universite_Ekle]
@ad text

As
Begin
Insert Into tbl_universite (ad) Values(@ad)
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_universite_Guncelle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_universite_Guncelle]
@Id int,
@ad text

As
Begin
Update tbl_universite Set ad=@ad
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_yazar_Ekle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_yazar_Ekle]
@ad text,
@soyad text

As
Begin
Insert Into tbl_yazar (ad,soyad) Values(@ad,@soyad)
End
GO
/****** Object:  StoredProcedure [dbo].[tbl_yazar_Guncelle]    Script Date: 7.01.2021 01:08:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[tbl_yazar_Guncelle]
@Id int,
@ad text,
@soyad text

As
Begin
Update tbl_yazar Set ad=@ad,soyad=@soyad
Where Id=@Id
End
GO
USE [master]
GO
ALTER DATABASE [tezdb] SET  READ_WRITE 
GO
