USE [master]
GO
/****** Object:  Database [dosya_icerik]    Script Date: 2.05.2021 00:02:42 ******/
CREATE DATABASE [dosya_icerik]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dosya_icerik', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\dosya_icerik.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'dosya_icerik_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\dosya_icerik_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [dosya_icerik] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dosya_icerik].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dosya_icerik] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dosya_icerik] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dosya_icerik] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dosya_icerik] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dosya_icerik] SET ARITHABORT OFF 
GO
ALTER DATABASE [dosya_icerik] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dosya_icerik] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [dosya_icerik] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dosya_icerik] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dosya_icerik] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dosya_icerik] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dosya_icerik] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dosya_icerik] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dosya_icerik] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dosya_icerik] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dosya_icerik] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dosya_icerik] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dosya_icerik] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dosya_icerik] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dosya_icerik] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dosya_icerik] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dosya_icerik] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dosya_icerik] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dosya_icerik] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [dosya_icerik] SET  MULTI_USER 
GO
ALTER DATABASE [dosya_icerik] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dosya_icerik] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dosya_icerik] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dosya_icerik] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [dosya_icerik]
GO
/****** Object:  Table [dbo].[dizin]    Script Date: 2.05.2021 00:02:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[dizin](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [varchar](50) NULL,
	[ust_dizin] [int] NULL,
	[tam_yol] [text] NULL,
 CONSTRAINT [PK_dizin] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[dosya]    Script Date: 2.05.2021 00:02:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[dosya](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [varchar](50) NULL,
	[tur_Id] [int] NULL,
	[dizin] [int] NULL,
	[boyut] [bigint] NULL,
 CONSTRAINT [PK_dosya] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[izin]    Script Date: 2.05.2021 00:02:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[izin](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[dosya_Id] [int] NULL,
	[okuma] [tinyint] NULL,
	[yazma] [tinyint] NULL,
	[yurutme] [tinyint] NULL,
 CONSTRAINT [PK_izin] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tur]    Script Date: 2.05.2021 00:02:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tur](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[uzanti] [varchar](20) NULL,
	[aciklama] [varchar](50) NULL,
	[program_ad] [varchar](50) NULL,
 CONSTRAINT [PK_tur] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[dizin] ON 

INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (1, N'/', 0, N'/')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (2, N'home', 1, N'/home')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (3, N'main', 2, N'/home/main')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (4, N'Downloads', 3, N'/home/Downloads')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (5, N'Desktop', 3, N'/home/Desktop')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (6, N'Documents', 3, N'/home/Documents')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (7, N'Music', 3, N'/home/Music')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (8, N'Pictures', 3, N'/home/Pictures')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (9, N'Videos', 3, N'/home/Videos')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (10, N'Archive', 4, N'/home/Downloads/Archive')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (11, N'Image', 4, N'/home/Downloads/Image')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (12, N'Program', 4, N'/home/Downloads/Program')
INSERT [dbo].[dizin] ([Id], [ad], [ust_dizin], [tam_yol]) VALUES (13, N'Video', 4, N'/home/Downloads/Video')
SET IDENTITY_INSERT [dbo].[dizin] OFF
SET IDENTITY_INSERT [dbo].[dosya] ON 

INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (1, N'age3-oyunindir.vip', 6, 10, 1700000)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (2, N'odev', 10, 6, 15000)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (3, N'modern-resume-template', 6, 10, 1600)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (4, N'invincible_S01E08_1080p', 4, 13, 834000)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (5, N'uzun ince bir yoldayım', 9, 7, 5600)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (6, N'doğa manzarası', 8, 3, 7000)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (7, N'ilksitem', 8, 6, 500)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (8, N'internet download manager', 1, 5, 89000)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (9, N'drawio', 1, 12, 78300)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (10, N'teamviewer', 1, 12, 14700)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (11, N'kutsal kitaplar', 7, 6, 8000)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (12, N'obs-2021-05-01', 4, 9, 12000)
INSERT [dbo].[dosya] ([Id], [ad], [tur_Id], [dizin], [boyut]) VALUES (13, N'filme listem', 2, 2, 300)
SET IDENTITY_INSERT [dbo].[dosya] OFF
SET IDENTITY_INSERT [dbo].[izin] ON 

INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (1, 1, 1, 1, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (2, 2, 1, 0, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (3, 3, 1, 1, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (4, 4, 1, 0, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (5, 5, 1, 1, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (6, 6, 1, 1, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (7, 7, 1, 0, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (8, 8, 1, 0, 1)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (9, 9, 1, 0, 1)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (10, 10, 1, 0, 1)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (11, 11, 1, 1, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (12, 12, 1, 1, 0)
INSERT [dbo].[izin] ([Id], [dosya_Id], [okuma], [yazma], [yurutme]) VALUES (13, 13, 1, 0, 0)
SET IDENTITY_INSERT [dbo].[izin] OFF
SET IDENTITY_INSERT [dbo].[tur] ON 

INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (1, N'exe', N'Uygulama', N'İşletim Sistemi')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (2, N'txt', N'Metin Dosyası', N'Notepad')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (3, N'jpg', N'Resim Dosyası', N'Windows Görüntüleyici')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (4, N'avi', N'Video Dosyası', N'SM Player')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (5, N'ppt', N'Microsoft Power Point Sunusu', N'Microsoft Power Point')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (6, N'zip', N'Sıkıştırılmış Dosya', N'Winrar')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (7, N'pdf', N'E-Kitap Dosyası', N'Adobe Acrobat')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (8, N'html', N'Web Sayfası', N'Chrome')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (9, N'mp3', N'Ses Dosyası', N'SM Player')
INSERT [dbo].[tur] ([Id], [uzanti], [aciklama], [program_ad]) VALUES (10, N'doc', N'Microsoft Word Belgesi', N'Microsoft Word')
SET IDENTITY_INSERT [dbo].[tur] OFF
ALTER TABLE [dbo].[dosya]  WITH CHECK ADD  CONSTRAINT [FK_dosya_dizin] FOREIGN KEY([dizin])
REFERENCES [dbo].[dizin] ([Id])
GO
ALTER TABLE [dbo].[dosya] CHECK CONSTRAINT [FK_dosya_dizin]
GO
ALTER TABLE [dbo].[dosya]  WITH CHECK ADD  CONSTRAINT [FK_dosya_tur] FOREIGN KEY([tur_Id])
REFERENCES [dbo].[tur] ([Id])
GO
ALTER TABLE [dbo].[dosya] CHECK CONSTRAINT [FK_dosya_tur]
GO
ALTER TABLE [dbo].[izin]  WITH CHECK ADD  CONSTRAINT [FK_izin_dosya] FOREIGN KEY([dosya_Id])
REFERENCES [dbo].[dosya] ([Id])
GO
ALTER TABLE [dbo].[izin] CHECK CONSTRAINT [FK_izin_dosya]
GO
USE [master]
GO
ALTER DATABASE [dosya_icerik] SET  READ_WRITE 
GO
