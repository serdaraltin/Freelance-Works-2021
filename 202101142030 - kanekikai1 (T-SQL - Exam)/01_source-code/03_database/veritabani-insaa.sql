USE [master]
GO
/****** Object:  Database [Bisiklet_Dünyası]    Script Date: 14.01.2021 18:13:36 ******/
CREATE DATABASE [Bisiklet_Dünyası]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'bisikletdb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\bisikletdb.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'bisikletdb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\bisikletdb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Bisiklet_Dünyası] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Bisiklet_Dünyası].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Bisiklet_Dünyası] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET ARITHABORT OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET RECOVERY FULL 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET  MULTI_USER 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Bisiklet_Dünyası] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Bisiklet_Dünyası] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Bisiklet_Dünyası', N'ON'
GO
USE [Bisiklet_Dünyası]
GO
/****** Object:  Table [dbo].[çalışanlar]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[çalışanlar](
	[çalışan_id] [int] IDENTITY(1,1) NOT NULL,
	[müşteri_adı] [varchar](50) NOT NULL,
	[müşteri_soyadı] [varchar](50) NOT NULL,
	[e_posta] [varchar](255) NOT NULL,
	[telefon] [varchar](25) NOT NULL,
	[aktiflik] [tinyint] NOT NULL,
	[depo_id] [int] NOT NULL,
	[yönetici_id] [int] NOT NULL,
 CONSTRAINT [PK_çalışanlar] PRIMARY KEY CLUSTERED 
(
	[çalışan_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[depolar]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[depolar](
	[depo_id] [int] IDENTITY(1,1) NOT NULL,
	[depo_ismi] [varchar](255) NOT NULL,
	[telefon] [varchar](25) NOT NULL,
	[e_posta] [varchar](255) NOT NULL,
	[cadde] [varchar](255) NOT NULL,
	[şehir] [varchar](255) NOT NULL,
	[bölgeler] [varchar](10) NOT NULL,
	[alan_kodu] [varchar](5) NOT NULL,
 CONSTRAINT [PK_satışlar.depolar] PRIMARY KEY CLUSTERED 
(
	[depo_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kategoriler]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[kategoriler](
	[kategori_id] [int] IDENTITY(1,1) NOT NULL,
	[kategori_ismi] [varchar](255) NULL,
 CONSTRAINT [PK_kategoriler] PRIMARY KEY CLUSTERED 
(
	[kategori_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[markalar]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[markalar](
	[marka_id] [int] IDENTITY(1,1) NOT NULL,
	[marka_ismi] [varchar](255) NOT NULL,
 CONSTRAINT [PK_üretim.markalar] PRIMARY KEY CLUSTERED 
(
	[marka_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[müşteriler]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[müşteriler](
	[müşteri_id] [int] IDENTITY(1,1) NOT NULL,
	[müşteri_adı] [varchar](255) NULL,
	[müşteri_soyadı] [varchar](255) NULL,
	[telefon] [varchar](25) NULL,
	[e_posta] [varchar](255) NULL,
	[cadde] [varchar](255) NULL,
	[şehir] [varchar](50) NULL,
	[bölgeler] [varchar](25) NULL,
	[alan_kodu] [varchar](5) NULL,
 CONSTRAINT [PK_müşteriler] PRIMARY KEY CLUSTERED 
(
	[müşteri_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[siparis_nesneleri]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[siparis_nesneleri](
	[siparis_id] [int] NOT NULL,
	[nesne_id] [int] NOT NULL,
	[ürün_id] [int] NOT NULL,
	[miktar] [int] NOT NULL,
	[liste_fiyati] [decimal](10, 2) NOT NULL,
	[indirim] [decimal](4, 2) NOT NULL,
 CONSTRAINT [PK_sipariş_nesneleri] PRIMARY KEY CLUSTERED 
(
	[nesne_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[siparişler]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[siparişler](
	[siparis_id] [int] IDENTITY(1,1) NOT NULL,
	[müşteri_id] [int] NOT NULL,
	[sipariş_durumu] [tinyint] NOT NULL,
	[sipariş_tarihi] [date] NOT NULL,
	[gerekli_zaman] [date] NOT NULL,
	[gönderim_tarihi] [date] NOT NULL,
	[depo_id] [int] NOT NULL,
	[calisan_id] [int] NOT NULL,
 CONSTRAINT [PK_siparişler] PRIMARY KEY CLUSTERED 
(
	[siparis_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[stoklar]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[stoklar](
	[depo_id] [int] NOT NULL,
	[ürün_id] [int] NOT NULL,
	[miktar] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ürünler]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ürünler](
	[ürün_id] [int] IDENTITY(1,1) NOT NULL,
	[ürün_ismi] [varchar](255) NOT NULL,
	[marka_id] [int] NOT NULL,
	[kategori_id] [int] NOT NULL,
	[model_yılı] [smallint] NOT NULL,
	[liste_fiyatı] [decimal](10, 2) NOT NULL,
 CONSTRAINT [PK_ürünler] PRIMARY KEY CLUSTERED 
(
	[ürün_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[çalışanlar] ON 

INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (1, N'Jena', N'Thomas', N'hymenaeos.Mauris@etnetuset.ca', N'(614) 218-7009', 1, 13, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (2, N'Kirk', N'Kirby', N'urna.justo.faucibus@ridiculusmus.org', N'(982) 630-0616', 1, 13, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (3, N'Jana', N'Potter', N'in.consequat@idmollisnec.com', N'(466) 625-9785', 1, 9, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (4, N'Cedric', N'Cain', N'lorem@ametmetus.ca', N'(549) 427-0061', 1, 4, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (5, N'Hakeem', N'Chavez', N'Donec.felis.orci@lectusconvallis.co.uk', N'(761) 239-7226', 1, 6, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (6, N'Cyrus', N'Lester', N'massa.Integer.vitae@Maurismolestiepharetra.net', N'(166) 414-7828', 1, 19, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (7, N'Laith', N'Weiss', N'Suspendisse.dui@diamProin.ca', N'(225) 786-8708', 1, 10, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (8, N'Amaya', N'Torres', N'tellus.Suspendisse.sed@Sedeunibh.net', N'(743) 112-1591', 1, 1, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (9, N'August', N'Knowles', N'dui.Suspendisse@atrisusNunc.ca', N'(293) 980-6350', 1, 18, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (10, N'Sybill', N'Noel', N'Nullam@Donecluctus.ca', N'(664) 263-5052', 1, 3, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (11, N'Kamal', N'Schmidt', N'Nunc@Nunc.ca', N'(573) 910-5901', 1, 13, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (12, N'Ciaran', N'Nielsen', N'In@orcitinciduntadipiscing.com', N'(726) 438-8054', 0, 4, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (13, N'Noah', N'Vazquez', N'urna.Ut.tincidunt@Nulladignissim.ca', N'(663) 673-3912', 1, 5, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (15, N'Whoopi', N'Coleman', N'mollis@aultriciesadipiscing.co.uk', N'(874) 674-5394', 1, 15, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (16, N'Ainsley', N'Zamora', N'Etiam.imperdiet@sodales.net', N'(408) 151-3213', 1, 15, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (17, N'Hedley', N'Wong', N'in.consequat.enim@dictumProin.co.uk', N'(787) 337-1205', 0, 8, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (18, N'Axel', N'Richardson', N'eget@leo.org', N'(776) 741-7199', 0, 5, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (19, N'Tucker', N'Bowen', N'scelerisque@enim.edu', N'(389) 967-1820', 1, 13, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (20, N'Shad', N'Gordon', N'rutrum@nonmagna.net', N'(219) 627-0179', 0, 26, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (21, N'Colorado', N'Conrad', N'tristique.neque@Phasellus.net', N'(535) 649-5435', 0, 12, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (22, N'Murphy', N'Swanson', N'mauris.sapien.cursus@morbitristiquesenectus.net', N'(212) 185-2407', 0, 7, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (24, N'Martena', N'Suarez', N'id.mollis.nec@Fuscefeugiat.org', N'(417) 517-5493', 1, 12, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (25, N'Abel', N'Perez', N'odio@porttitortellus.net', N'(401) 438-2743', 0, 15, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (26, N'Stewart', N'Swanson', N'Donec@tempus.net', N'(843) 626-4143', 1, 10, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (27, N'Arden', N'Obrien', N'mi.Aliquam@ante.org', N'(559) 511-3057', 1, 25, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (28, N'Linus', N'Cooley', N'et.netus.et@purus.com', N'(970) 514-2588', 1, 11, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (29, N'Bo', N'Barker', N'Donec.egestas.Duis@egetdictumplacerat.org', N'(781) 309-1080', 1, 4, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (30, N'Alexa', N'Burris', N'est.vitae@sitametnulla.ca', N'(480) 100-4405', 0, 23, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (31, N'Donovan', N'Peterson', N'dis.parturient@nisi.org', N'(543) 112-1590', 0, 19, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (32, N'Lana', N'Schroeder', N'diam.Sed@euaugueporttitor.net', N'(461) 618-4592', 1, 20, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (33, N'Myra', N'Valentine', N'molestie@pellentesque.edu', N'(356) 845-6753', 0, 6, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (34, N'Kelsie', N'Tran', N'mi.enim@et.net', N'(668) 846-7544', 1, 17, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (35, N'Winifred', N'Galloway', N'interdum@nuncnulla.ca', N'(546) 792-0079', 1, 3, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (36, N'Jermaine', N'Pittman', N'vulputate.risus@semNullainterdum.ca', N'(194) 570-6554', 1, 20, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (37, N'Gavin', N'Steele', N'Curabitur.vel.lectus@justoPraesentluctus.org', N'(471) 308-2343', 0, 24, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (38, N'Autumn', N'Hull', N'a@rhoncus.edu', N'(601) 657-0925', 0, 25, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (39, N'Norman', N'Stanton', N'ipsum.dolor@Pellentesque.org', N'(542) 932-1466', 0, 4, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (40, N'Mohammad', N'Patton', N'magna@fringilla.net', N'(593) 174-3821', 1, 16, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (41, N'Dalton', N'Langley', N'aliquet.nec.imperdiet@arcu.com', N'(371) 473-2733', 1, 6, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (42, N'Fuller', N'Edwards', N'diam@massaSuspendisseeleifend.com', N'(946) 734-5486', 0, 12, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (43, N'Palmer', N'Daugherty', N'est.Nunc@nonummy.org', N'(114) 575-7052', 0, 12, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (44, N'Kirby', N'Valenzuela', N'vulputate@Proin.com', N'(707) 363-8962', 1, 26, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (45, N'Tatiana', N'Turner', N'purus.Nullam@etmalesuadafames.org', N'(860) 715-3837', 0, 13, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (46, N'Oleg', N'Rose', N'risus.quis.diam@nonleo.edu', N'(482) 170-4280', 0, 22, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (47, N'Wynter', N'Shields', N'eget.mollis.lectus@vulputateposuerevulputate.net', N'(675) 103-1546', 1, 24, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (48, N'Ulric', N'Santos', N'odio.Phasellus.at@nascetur.net', N'(345) 259-3484', 1, 19, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (49, N'Jin', N'Williamson', N'nunc.nulla@sit.org', N'(626) 331-9886', 0, 9, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (50, N'Tobias', N'Goodwin', N'mauris.sapien.cursus@acmattis.com', N'(425) 858-4189', 1, 1, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (51, N'Vivien', N'Thompson', N'Sed@cursusa.com', N'(125) 919-4377', 1, 15, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (52, N'Wade', N'Terry', N'libero.Proin@commodo.com', N'(848) 687-2591', 1, 18, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (53, N'Quentin', N'Workman', N'Praesent@fermentum.co.uk', N'(535) 372-2274', 0, 17, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (54, N'Macon', N'Mckinney', N'lacinia.Sed@eleifendvitaeerat.ca', N'(282) 693-5867', 1, 19, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (55, N'Blair', N'Gaines', N'Nunc.sollicitudin.commodo@gravidaPraesent.org', N'(361) 963-7442', 0, 19, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (56, N'Mia', N'Boyer', N'purus@Ut.org', N'(989) 902-9330', 0, 17, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (57, N'Hall', N'Savage', N'ultrices@consequatnecmollis.com', N'(518) 383-1803', 0, 13, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (58, N'Yardley', N'Blackburn', N'Mauris@convallis.edu', N'(355) 513-1062', 0, 9, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (59, N'Ferris', N'Sawyer', N'rutrum.lorem.ac@aceleifendvitae.ca', N'(973) 107-7857', 1, 14, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (60, N'Delilah', N'Whitaker', N'leo.elementum@fringillaporttitorvulputate.net', N'(413) 699-4408', 1, 5, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (61, N'Liberty', N'Alexander', N'semper@nonmagna.ca', N'(869) 504-8324', 1, 19, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (62, N'Cedric', N'Chan', N'mauris.elit.dictum@ac.edu', N'(799) 347-1336', 0, 24, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (63, N'Urielle', N'Garner', N'non.egestas@quam.com', N'(382) 149-8092', 0, 7, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (64, N'Neve', N'Church', N'Ut@necurna.ca', N'(996) 553-5108', 0, 11, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (65, N'Wendy', N'Oneal', N'nulla.at.sem@duiCumsociis.net', N'(682) 544-6929', 1, 8, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (66, N'Vaughan', N'Alvarez', N'sagittis.Nullam@fermentumrisus.com', N'(977) 607-3178', 0, 19, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (67, N'Shaine', N'Kirkland', N'a.dui.Cras@Phasellus.org', N'(717) 576-2533', 0, 24, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (68, N'Harrison', N'Dawson', N'convallis.dolor@mipede.co.uk', N'(486) 290-0919', 1, 1, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (69, N'Xenos', N'Leon', N'felis@pretium.ca', N'(152) 497-1033', 0, 19, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (70, N'Jack', N'Ellison', N'id.sapien.Cras@nisidictumaugue.edu', N'(523) 182-2062', 1, 6, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (71, N'Hilary', N'Lewis', N'ac.mattis.semper@malesuadafamesac.org', N'(490) 129-6001', 1, 12, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (72, N'Buckminster', N'Gallagher', N'faucibus@Sedmalesuada.edu', N'(701) 340-1843', 0, 9, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (73, N'Kendall', N'Conway', N'tempor.bibendum.Donec@adipiscinglacus.ca', N'(625) 103-9017', 1, 20, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (74, N'Alika', N'Diaz', N'est@sitamet.edu', N'(680) 113-6457', 0, 15, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (75, N'Ivana', N'Tate', N'in.consectetuer@tempor.co.uk', N'(512) 443-6217', 0, 22, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (76, N'David', N'Melton', N'et.magnis.dis@parturient.com', N'(755) 207-6135', 1, 6, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (77, N'Tatyana', N'Alford', N'nisl.elementum@pedenonummyut.co.uk', N'(790) 947-9822', 1, 18, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (78, N'Hammett', N'Randolph', N'sagittis.felis@Duisvolutpatnunc.net', N'(291) 931-9133', 1, 23, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (79, N'Timothy', N'Best', N'tristique.senectus.et@metus.co.uk', N'(136) 800-9278', 1, 24, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (80, N'Steven', N'Reilly', N'Sed.nunc@leo.co.uk', N'(452) 947-7850', 0, 1, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (81, N'Hakeem', N'Maynard', N'pede.sagittis@risusaultricies.net', N'(664) 287-4046', 1, 26, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (82, N'Cameron', N'Orr', N'eget@Vivamus.ca', N'(667) 878-9770', 1, 11, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (83, N'Magee', N'Galloway', N'ac.tellus.Suspendisse@velit.net', N'(848) 752-6670', 0, 7, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (84, N'Gannon', N'Williamson', N'leo.elementum.sem@metus.co.uk', N'(284) 942-8268', 1, 15, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (85, N'Chiquita', N'Vaughan', N'nascetur.ridiculus.mus@euismodmauris.org', N'(161) 104-5623', 1, 9, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (86, N'Odysseus', N'Ellis', N'aliquet@Integervulputate.com', N'(252) 637-2129', 0, 6, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (87, N'Conan', N'Mason', N'elit.erat.vitae@Aenean.org', N'(384) 562-7922', 0, 10, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (88, N'William', N'Burgess', N'Mauris.nulla@risusDuisa.net', N'(491) 271-4493', 1, 20, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (89, N'Paul', N'Heath', N'mattis.ornare.lectus@risusatfringilla.co.uk', N'(176) 859-1237', 1, 4, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (90, N'Ignacia', N'Sweeney', N'litora@Loremipsumdolor.net', N'(832) 520-9881', 1, 1, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (91, N'Lunea', N'Townsend', N'nec.leo@molestiepharetranibh.com', N'(883) 713-7787', 0, 3, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (92, N'India', N'Trujillo', N'Donec@enimSednulla.org', N'(649) 375-2234', 0, 5, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (93, N'Quamar', N'Singleton', N'luctus@utipsum.edu', N'(709) 793-3322', 0, 25, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (94, N'Chantale', N'Foley', N'in@sempererat.com', N'(784) 705-5078', 1, 20, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (95, N'Odysseus', N'Sykes', N'egestas.a.scelerisque@utcursusluctus.edu', N'(969) 952-1103', 1, 23, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (96, N'Rhonda', N'Fields', N'lacinia@etnuncQuisque.ca', N'(941) 869-1378', 0, 20, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (97, N'Clementine', N'Marquez', N'faucibus.orci.luctus@utquamvel.org', N'(227) 480-3141', 0, 13, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (99, N'Hilda', N'Mooney', N'Nam@mollis.co.uk', N'(564) 976-2304', 0, 5, 1)
INSERT [dbo].[çalışanlar] ([çalışan_id], [müşteri_adı], [müşteri_soyadı], [e_posta], [telefon], [aktiflik], [depo_id], [yönetici_id]) VALUES (100, N'Judah', N'Alford', N'semper.pretium@pedeCumsociis.net', N'(315) 670-8318', 0, 11, 1)
SET IDENTITY_INSERT [dbo].[çalışanlar] OFF
SET IDENTITY_INSERT [dbo].[depolar] ON 

INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (1, N'Depo1', N'05426987412', N'depo1@mail.com', N'cadde1', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (3, N'Depo2', N'05469874523', N'depo2@mail.com', N'cadde2', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (4, N'Depo3', N'05786321456', N'depo3@mail.com', N'cadde3', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (5, N'Depo4', N'05457891401', N'depo4@mail.com', N'cadde4', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (6, N'Depo5', N'05457891402', N'depo5@mail.com', N'cadde5', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (7, N'Depo6', N'05457891403', N'depo6@mail.com', N'cadde6', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (8, N'Depo7', N'05457891404', N'depo7@mail.com', N'cadde7', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (9, N'Depo8', N'05457891405', N'depo8@mail.com', N'cadde8', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (10, N'Depo9', N'05457891406', N'depo9@mail.com', N'cadde9', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (11, N'Depo10', N'05457891407', N'depo10@mail.com', N'cadde10', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (12, N'Depo11', N'05457891408', N'depo11@mail.com', N'cadde11', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (13, N'Depo12', N'05457891409', N'depo12@mail.com', N'cadde12', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (14, N'Depo13', N'05457891410', N'depo13@mail.com', N'cadde13', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (15, N'Depo14', N'05457891411', N'depo14@mail.com', N'cadde14', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (16, N'Depo15', N'05457891412', N'depo15@mail.com', N'cadde15', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (17, N'Depo16', N'05457891413', N'depo16@mail.com', N'cadde16', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (18, N'Depo17', N'05457891414', N'depo17@mail.com', N'cadde17', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (19, N'Depo18', N'05457891415', N'depo18@mail.com', N'cadde18', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (20, N'Depo19', N'05457891416', N'depo19@mail.com', N'cadde19', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (21, N'Depo20', N'05457891417', N'depo20@mail.com', N'cadde20', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (22, N'Depo21', N'05457891418', N'depo21@mail.com', N'cadde21', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (23, N'Depo22', N'05457891419', N'depo22@mail.com', N'cadde22', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (24, N'Depo23', N'05457891420', N'depo23@mail.com', N'cadde23', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (25, N'Depo24', N'05457891421', N'depo24@mail.com', N'cadde24', N'Istanbul', N'Merkez', N'34000')
INSERT [dbo].[depolar] ([depo_id], [depo_ismi], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (26, N'Depo25', N'05457891422', N'depo25@mail.com', N'cadde25', N'Istanbul', N'Merkez', N'34000')
SET IDENTITY_INSERT [dbo].[depolar] OFF
SET IDENTITY_INSERT [dbo].[kategoriler] ON 

INSERT [dbo].[kategoriler] ([kategori_id], [kategori_ismi]) VALUES (1, N'Şehir')
INSERT [dbo].[kategoriler] ([kategori_id], [kategori_ismi]) VALUES (2, N'Dağ')
INSERT [dbo].[kategoriler] ([kategori_id], [kategori_ismi]) VALUES (3, N'Özel')
INSERT [dbo].[kategoriler] ([kategori_id], [kategori_ismi]) VALUES (4, N'Çocuk')
SET IDENTITY_INSERT [dbo].[kategoriler] OFF
SET IDENTITY_INSERT [dbo].[markalar] ON 

INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (1, N'B-Twin')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (2, N'Bianchi')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (3, N'BMc')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (4, N'Carraro')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (5, N'Corelli')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (6, N'Creme')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (7, N'Cube')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (8, N'Feit')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (9, N'Fuji')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (10, N'Gazelle')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (11, N'Ghost')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (12, N'Giant')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (13, N'Goccia')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (14, N'Gomax')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (15, N'Kron')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (16, N'KTM')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (17, N'Lapierre')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (18, N'Merida')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (19, N'Mosso')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (20, N'Nirve')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (21, N'Orbea')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (22, N'Orbis')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (23, N'Raleigh')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (24, N'Salcano')
INSERT [dbo].[markalar] ([marka_id], [marka_ismi]) VALUES (25, N'Skoda')
SET IDENTITY_INSERT [dbo].[markalar] OFF
SET IDENTITY_INSERT [dbo].[müşteriler] ON 

INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (202, N'Kevin', N'Schultz', N'(581) 555-0864', N'lorem.vehicula@cursusa.com', N'3598 Augue Rd.', N'Campbelltown', N'NSW', N'25007')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (203, N'Xenos', N'Pate', N'(968) 199-6013', N'arcu.vel.quam@Donecegestas.org', N'P.O. Box 191, 5178 Sed Road', N'Langholm', N'DF', N'39156')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (204, N'Cain', N'Martin', N'(297) 496-5528', N'Cras.convallis.convallis@sedest.edu', N'Ap #899-1433 Nunc Rd.', N'Kursk', N'KRS', N'35438')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (205, N'Idola', N'Finch', N'(310) 288-9362', N'at.lacus@Vivamus.net', N'P.O. Box 608, 229 Aliquet Rd.', N'Bexbach', N'SL', N'74654')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (206, N'Ifeoma', N'Hurley', N'(317) 375-8771', N'mi.Duis@lectusa.ca', N'Ap #859-5207 Ut Av.', N'Bala', N'Merionethshire', N'18351')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (207, N'Ashton', N'Monroe', N'(760) 732-3461', N'amet@sit.ca', N'546-3677 Adipiscing Road', N'Sabanalarga', N'Atlántico', N'47319')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (208, N'Ross', N'Mooney', N'(599) 731-4066', N'vel.venenatis@AliquamnislNulla.ca', N'P.O. Box 843, 8857 Est, Rd.', N'Norfolk County', N'Ontario', N'40205')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (209, N'Tate', N'Day', N'(147) 616-0799', N'tortor@consequat.co.uk', N'4164 Curabitur Road', N'Yeosu', N'Jeo', N'20776')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (210, N'Dexter', N'Blackwell', N'(556) 548-8678', N'nec.leo.Morbi@dolor.ca', N'P.O. Box 508, 3993 Blandit Road', N'Tonalá', N'Jal', N'44000')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (211, N'Lois', N'Rollins', N'(858) 299-7031', N'erat.semper@Praesent.co.uk', N'495-6407 Proin Ave', N'Xalapa', N'Veracruz', N'34066')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (212, N'Hyatt', N'Zimmerman', N'(557) 266-0992', N'semper@etmagna.net', N'2793 In Street', N'Lidköping', N'O', N'41068')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (213, N'Tatyana', N'Haley', N'(135) 215-5106', N'neque.et@Suspendissesagittis.ca', N'7513 Vitae, St.', N'Boo', N'AB', N'65205')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (214, N'Nomlanga', N'Foley', N'(790) 866-9422', N'Donec.egestas.Duis@Nullamutnisi.org', N'P.O. Box 856, 2044 Sagittis St.', N'Penna San Giovanni', N'MAR', N'42664')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (215, N'Rhonda', N'Curtis', N'(147) 108-1351', N'orci@rutrumeu.net', N'710-6575 Eu, St.', N'Essex', N'VT', N'52572')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (216, N'Ora', N'Bernard', N'(715) 419-1778', N'scelerisque.scelerisque.dui@congue.edu', N'955-6323 Ipsum Av.', N'Tauranga', N'NI', N'18299')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (217, N'Ray', N'Duke', N'(374) 646-8091', N'lacinia.at@Sedauctorodio.com', N'224-5850 Quisque Rd.', N'Orizaba', N'Ver', N'25032')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (218, N'Cassandra', N'Farmer', N'(537) 303-2007', N'ridiculus.mus@Etiamimperdietdictum.co.uk', N'7310 Nullam Avenue', N'Märsta', N'Stockholms län', N'75677')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (219, N'Coby', N'Mcdaniel', N'(295) 578-8816', N'arcu.Aliquam.ultrices@et.edu', N'P.O. Box 429, 9502 Ac Road', N'Magangué', N'Bolívar', N'30039')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (220, N'Dai', N'Mckinney', N'(174) 865-6545', N'tempor.lorem@metusfacilisis.ca', N'P.O. Box 280, 978 Velit Rd.', N'Kech', N'Balochistan', N'24666')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (221, N'Julie', N'Ortega', N'(918) 508-1254', N'arcu@temporest.org', N'Ap #676-2989 Sodales St.', N'Tebing Tinggi', N'SU', N'53356')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (222, N'Uta', N'Woodward', N'(913) 493-6538', N'et@et.edu', N'P.O. Box 354, 9692 Ornare Road', N'Betim', N'MG', N'54196')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (223, N'Meredith', N'Duran', N'(659) 534-2679', N'malesuada.vel@quam.com', N'P.O. Box 206, 8950 Sed Rd.', N'Banjar', N'JB', N'21920')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (224, N'Orson', N'Henson', N'(803) 837-4185', N'et.magna.Praesent@Nunc.co.uk', N'492-2365 Dictum Rd.', N'Vienna', N'Vienna', N'71061')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (225, N'Macaulay', N'Doyle', N'(294) 912-4399', N'hymenaeos.Mauris.ut@dignissimmagnaa.edu', N'Ap #104-9016 Nunc St.', N'Bad Homburg v. d. Höhe', N'Hessen', N'64799')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (226, N'Honorato', N'Todd', N'(646) 118-6860', N'eu.dui.Cum@hendrerit.net', N'P.O. Box 468, 721 Sollicitudin St.', N'Pirque', N'RM', N'28228')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (227, N'Josiah', N'Gilbert', N'(131) 357-0711', N'a@enimEtiamimperdiet.co.uk', N'244-2189 Diam. Avenue', N'Zwolle', N'Overijssel', N'56976')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (228, N'Rashad', N'James', N'(791) 622-7797', N'amet.faucibus@lacusCrasinterdum.com', N'6048 Sed St.', N'Auckland', N'North Island', N'34808')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (229, N'Kibo', N'Neal', N'(537) 899-1619', N'nibh@id.edu', N'979 Enim. St.', N'Whakatane', N'NI', N'69876')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (230, N'Jerome', N'Stanton', N'(802) 149-4104', N'ligula.consectetuer.rhoncus@lorem.org', N'5936 Nullam St.', N'Berlin', N'BE', N'45121')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (231, N'Porter', N'Henry', N'(892) 317-4959', N'Vivamus.molestie.dapibus@Nunclectuspede.com', N'Ap #571-7370 Convallis Avenue', N'Mokpo', N'Jeo', N'53497')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (232, N'Hayden', N'Cameron', N'(215) 363-0494', N'neque.vitae.semper@Vivamuseuismodurna.net', N'P.O. Box 179, 5949 Pretium Av.', N'San José de Alajuela', N'A', N'11201')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (233, N'Nita', N'York', N'(963) 102-3641', N'dui.nec@atfringillapurus.ca', N'P.O. Box 118, 4998 Molestie St.', N'Shipshaw', N'Quebec', N'39804')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (234, N'Nevada', N'Ortiz', N'(125) 603-2749', N'mollis.vitae.posuere@elitpharetra.org', N'P.O. Box 514, 5103 Pharetra. St.', N'Torrejón de Ardoz', N'Madrid', N'60233')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (235, N'Erasmus', N'Gill', N'(911) 540-7550', N'Curabitur@euismodestarcu.org', N'6670 Ut Rd.', N'Navojoa', N'Sonora', N'19639')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (236, N'Rooney', N'Stark', N'(307) 362-8301', N'lectus@at.ca', N'145-414 Eu Road', N'Waitara', N'NI', N'18488')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (237, N'Liberty', N'Gomez', N'(454) 593-5719', N'montes.nascetur@sitametrisus.com', N'714-2234 At Avenue', N'Calco', N'Lombardia', N'64790')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (238, N'Dominique', N'Carey', N'(781) 240-5912', N'odio.Aliquam@aliquam.ca', N'Ap #928-1494 Adipiscing Ave', N'Saint-Hilarion', N'QC', N'65512')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (239, N'Jessamine', N'Koch', N'(263) 239-8846', N'mi@aliquetPhasellusfermentum.ca', N'9636 Pellentesque Street', N'Shenkursk', N'Arkhangelsk Oblast', N'11872')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (240, N'Cole', N'Bullock', N'(793) 111-2717', N'at@eudui.net', N'P.O. Box 180, 4177 Volutpat St.', N'Vienna', N'Vienna', N'30467')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (241, N'McKenzie', N'Osborn', N'(333) 923-7063', N'metus.vitae@ipsumPhasellus.co.uk', N'Ap #328-355 Ac Av.', N'Dehradun', N'Uttarakhand', N'36499')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (242, N'Adrienne', N'Schultz', N'(391) 743-8574', N'dis.parturient@dolordolor.edu', N'P.O. Box 228, 3524 Nunc Av.', N'Oldenzaal', N'Ov', N'46676')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (243, N'Stella', N'Reese', N'(614) 934-5781', N'vitae@congue.org', N'P.O. Box 886, 1084 Eget St.', N'Istanbul', N'Istanbul', N'35589')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (244, N'Raven', N'Norton', N'(288) 882-4656', N'libero@nullaIntegervulputate.com', N'P.O. Box 727, 6269 Pede. St.', N'Santa Rita', N'PB', N'73060')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (245, N'Vernon', N'Ball', N'(741) 538-7096', N'nonummy@tempuslorem.net', N'Ap #527-710 Imperdiet Street', N'Yekaterinburg', N'Sverdlovsk Oblast', N'26813')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (246, N'Ralph', N'Petty', N'(207) 231-7568', N'ipsum.primis.in@Phasellus.ca', N'4692 Ante. Ave', N'Astrakhan', N'AST', N'56294')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (247, N'Brenden', N'Fitzpatrick', N'(696) 996-5276', N'Sed.malesuada@feugiatnecdiam.com', N'Ap #741-9763 Luctus Av.', N'María Pinto', N'RM', N'64748')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (248, N'Abra', N'Bass', N'(147) 539-6131', N'et@felisDonec.edu', N'Ap #165-5143 Sem, St.', N'Warszawa', N'Mazowieckie', N'36648')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (249, N'Berk', N'Heath', N'(714) 774-0014', N'consequat.dolor@Sednulla.edu', N'1991 Augue St.', N'Belfast', N'U', N'29208')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (250, N'Miriam', N'Cameron', N'(761) 550-7372', N'Mauris@montes.org', N'6425 Vel Avenue', N'Istanbul', N'Ist', N'79850')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (251, N'Imelda', N'Mcdaniel', N'(370) 969-2947', N'velit.justo.nec@Proin.edu', N'4121 Vitae Av.', N'Bear', N'Delaware', N'68462')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (252, N'Ciara', N'Rios', N'(102) 171-1144', N'rutrum@Sednunc.org', N'9116 Varius Av.', N'Pukekohe', N'North Island', N'65557')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (253, N'Farrah', N'Mueller', N'(743) 708-6437', N'dapibus.gravida.Aliquam@et.co.uk', N'Ap #662-3349 Libero Street', N'StrZe', N'Henegouwen', N'23751')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (254, N'Ursula', N'Cote', N'(186) 632-9062', N'convallis.dolor@interdum.ca', N'P.O. Box 336, 7023 Integer Rd.', N'Amsterdam', N'N.', N'27825')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (255, N'Henry', N'Brewer', N'(422) 390-3766', N'interdum.Sed.auctor@mollis.net', N'953-2305 Nec Rd.', N'San Rafael', N'A', N'30568')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (256, N'Alvin', N'Crawford', N'(827) 301-6444', N'Integer.mollis.Integer@maurisipsumporta.org', N'Ap #492-6325 Nibh. St.', N'Hamburg', N'Hamburg', N'23701')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (257, N'Zenia', N'Brown', N'(682) 384-7823', N'nisi.Cum.sociis@VivamusnisiMauris.co.uk', N'4301 Felis. St.', N'Kaneohe', N'HI', N'29770')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (258, N'Rogan', N'David', N'(932) 748-9574', N'lectus@dictumplacerataugue.net', N'P.O. Box 824, 6714 Auctor Street', N'Lagos', N'LA', N'35116')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (259, N'Todd', N'Humphrey', N'(864) 435-2570', N'dui.in.sodales@aauctornon.com', N'P.O. Box 844, 7278 Vehicula Avenue', N'Itajaí', N'Santa Catarina', N'27845')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (260, N'Shad', N'Gutierrez', N'(929) 351-2178', N'nec.diam.Duis@imperdietnecleo.co.uk', N'Ap #145-5437 Maecenas Rd.', N'Fortaleza', N'Ceará', N'30109')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (261, N'Charlotte', N'Baird', N'(685) 106-0148', N'cursus@Sed.edu', N'854-6984 Ultrices St.', N'Maranguape', N'CE', N'80204')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (262, N'Deanna', N'Dixon', N'(964) 280-1609', N'Proin@afelis.ca', N'Ap #532-4070 Tellus St.', N'Uruapan', N'Michoacán', N'27684')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (263, N'Tallulah', N'Mckee', N'(865) 501-3168', N'Lorem.ipsum.dolor@ornaretortor.ca', N'2395 Aliquet Rd.', N'Balfour', N'Orkney', N'10869')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (264, N'Dillon', N'Rosario', N'(808) 108-1412', N'eu.accumsan.sed@non.org', N'P.O. Box 113, 2896 Orci Avenue', N'Idaho Falls', N'ID', N'79472')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (265, N'Breanna', N'Holden', N'(603) 659-0752', N'velit.Sed@mauriserateget.com', N'573-7552 Eu, Rd.', N'Pachuca', N'Hidalgo', N'73984')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (266, N'Kiona', N'Sweet', N'(906) 933-3315', N'Donec.sollicitudin@aliquam.ca', N'Ap #899-4054 Mauris Avenue', N'Bear', N'DE', N'44092')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (267, N'Patrick', N'Castaneda', N'(977) 782-2265', N'purus@aliquamenimnec.com', N'P.O. Box 666, 2908 Vulputate Rd.', N'Huaral', N'Lima', N'38404')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (268, N'Joel', N'Meyers', N'(560) 684-5807', N'nunc.est.mollis@Aliquamerat.net', N'7807 Fringilla Road', N'Ahrensburg', N'SH', N'49906')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (269, N'Ingrid', N'Deleon', N'(885) 598-7971', N'semper.rutrum.Fusce@Fuscediam.com', N'6956 Ligula Road', N'Galway', N'C', N'55076')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (270, N'Colin', N'Rosales', N'(463) 515-0337', N'nunc.ullamcorper@est.com', N'Ap #991-102 Duis Av.', N'Rouvreux', N'LU', N'16847')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (271, N'Marshall', N'Morrow', N'(678) 617-4988', N'eget@Suspendissealiquetmolestie.co.uk', N'768-158 Egestas. St.', N'Yeongju', N'Gye', N'53060')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (272, N'Elaine', N'Melendez', N'(367) 525-2662', N'Phasellus.libero@antedictum.net', N'677 Pharetra Rd.', N'Qualicum Beach', N'BC', N'66212')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (273, N'Jamalia', N'Richardson', N'(117) 651-5175', N'enim.Mauris@nonmagnaNam.ca', N'P.O. Box 888, 1378 Cras Street', N'Beverley', N'Yorkshire', N'58147')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (274, N'Nissim', N'Baker', N'(849) 486-4055', N'in.tempus.eu@bibendumsedest.org', N'3945 A Rd.', N'Brampton', N'Cumberland', N'15709')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (275, N'Hayden', N'Hurley', N'(376) 863-5460', N'natoque.penatibus@acsem.co.uk', N'983-6663 Luctus Road', N'Rochester', N'MN', N'21694')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (276, N'Miriam', N'Martin', N'(310) 616-9357', N'nec.tellus@luctusetultrices.co.uk', N'4131 Quam, St.', N'Vertou', N'PA', N'64164')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (277, N'Axel', N'Conley', N'(413) 370-4164', N'Morbi.metus.Vivamus@habitantmorbi.edu', N'Ap #901-9773 Interdum. Road', N'Suwalki', N'Podlaskie', N'18932')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (278, N'Angela', N'Vazquez', N'(995) 337-7485', N'vel@idrisusquis.co.uk', N'6995 Suspendisse Avenue', N'Vienna', N'Wie', N'52123')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (279, N'Cyrus', N'Cortez', N'(457) 255-9060', N'gravida.nunc.sed@ac.co.uk', N'422-8371 Elit St.', N'Creil', N'Picardie', N'38983')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (280, N'Hilel', N'Gray', N'(706) 851-5885', N'tempus@ipsum.org', N'107-6807 Scelerisque St.', N'Hattem', N'Gelderland', N'41673')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (281, N'Lareina', N'Joyner', N'(924) 133-2986', N'non.bibendum.sed@felisorci.net', N'P.O. Box 497, 2292 Luctus St.', N'Vezirköprü', N'Sam', N'57695')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (282, N'Quamar', N'Blankenship', N'(345) 970-7462', N'Lorem@sitamet.com', N'876-4222 Faucibus Road', N'Hilo', N'Hawaii', N'80250')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (283, N'Berk', N'Patel', N'(153) 236-3771', N'nec@sagittislobortismauris.co.uk', N'713-5771 Mauris Rd.', N'Cagnes-sur-Mer', N'PR', N'56780')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (284, N'Suki', N'Wilkinson', N'(716) 326-3682', N'eu@non.co.uk', N'P.O. Box 368, 7652 Tincidunt St.', N'Agartala', N'Tripura', N'45906')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (285, N'Octavius', N'Cooper', N'(999) 756-0762', N'Proin@luctusipsumleo.net', N'628-5385 Ligula St.', N'San Ignacio', N'Biobío', N'19059')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (286, N'Zorita', N'Fuller', N'(311) 514-9470', N'iaculis@Donec.co.uk', N'Ap #983-4886 Et Av.', N'Sakhalin', N'SAK', N'24315')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (287, N'Zahir', N'Ingram', N'(914) 608-7106', N'arcu.Vestibulum@tortoratrisus.ca', N'P.O. Box 282, 1265 Egestas. Avenue', N'Campinas', N'SP', N'54787')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (288, N'Geoffrey', N'Faulkner', N'(103) 371-5560', N'Nam@libero.edu', N'Ap #625-6862 Pede Ave', N'Manukau', N'North Island', N'57482')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (289, N'Elton', N'Summers', N'(305) 395-3852', N'Mauris@etmagnis.ca', N'Ap #554-3606 Accumsan Rd.', N'Guápiles', N'Limón', N'14348')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (290, N'Celeste', N'Witt', N'(338) 251-6510', N'fames.ac.turpis@Duis.com', N'451-4652 Et Road', N'Fishguard', N'Pembrokeshire', N'44462')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (291, N'Xandra', N'Park', N'(251) 927-7851', N'enim.commodo.hendrerit@quis.org', N'122-3620 Mauris. St.', N'Ciudad Victoria', N'Tam', N'73467')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (292, N'Amena', N'Spears', N'(801) 107-0280', N'diam@ametloremsemper.edu', N'Ap #178-969 Turpis Street', N'Iseyin', N'OY', N'45998')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (293, N'Ivor', N'Bass', N'(578) 771-6745', N'Quisque.porttitor.eros@fringilla.ca', N'P.O. Box 868, 3614 Arcu Ave', N'Siedlce', N'Mazowieckie', N'11529')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (294, N'Callie', N'Singleton', N'(381) 831-2238', N'ut.sem.Nulla@anteipsumprimis.org', N'P.O. Box 115, 121 Sem Road', N'Radom', N'MA', N'66992')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (295, N'Evangeline', N'Franco', N'(925) 215-3502', N'eu.ultrices.sit@sapien.org', N'1305 Vitae St.', N'Huelva', N'Andalucía', N'58628')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (296, N'Tanner', N'Campbell', N'(948) 959-1390', N'id.blandit.at@arcuetpede.co.uk', N'149-5581 Nunc Road', N'Uluberia', N'West Bengal', N'55069')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (297, N'Alma', N'Dickerson', N'(690) 416-5862', N'vitae@iaculis.co.uk', N'P.O. Box 161, 9995 Mauris Av.', N'Whakatane', N'North Island', N'25201')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (298, N'Jocelyn', N'Mccullough', N'(878) 813-8431', N'Integer.urna@pharetranibhAliquam.org', N'7322 Ipsum Rd.', N'Multan', N'PU', N'65209')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (299, N'Declan', N'Curry', N'(493) 404-8154', N'magna.Phasellus.dolor@penatibusetmagnis.ca', N'424-9463 Felis Av.', N'San Felipe', N'San José', N'46993')
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (300, N'Felix', N'Patel', N'(839) 800-4381', N'Sed@enim.org', N'Ap #790-9865 Erat Rd.', N'Heredia', N'Heredia', N'77264')
GO
INSERT [dbo].[müşteriler] ([müşteri_id], [müşteri_adı], [müşteri_soyadı], [telefon], [e_posta], [cadde], [şehir], [bölgeler], [alan_kodu]) VALUES (301, N'Savannah', N'House', N'(866) 422-4689', N'luctus.aliquet.odio@amet.edu', N'Ap #461-6071 Feugiat Av.', N'Morelia', N'Mic', N'69796')
SET IDENTITY_INSERT [dbo].[müşteriler] OFF
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (48, 1, 30, 34, CAST(16711.00 AS Decimal(10, 2)), CAST(20.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (24, 2, 14, 24, CAST(12179.00 AS Decimal(10, 2)), CAST(42.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (7, 4, 25, 34, CAST(7455.00 AS Decimal(10, 2)), CAST(26.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (20, 5, 26, 10, CAST(3890.00 AS Decimal(10, 2)), CAST(46.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (33, 6, 34, 3, CAST(13304.00 AS Decimal(10, 2)), CAST(20.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (30, 9, 34, 24, CAST(7056.00 AS Decimal(10, 2)), CAST(50.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (72, 10, 35, 15, CAST(10929.00 AS Decimal(10, 2)), CAST(16.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (44, 11, 16, 8, CAST(4135.00 AS Decimal(10, 2)), CAST(45.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (50, 12, 35, 35, CAST(16283.00 AS Decimal(10, 2)), CAST(24.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (35, 13, 30, 7, CAST(15959.00 AS Decimal(10, 2)), CAST(7.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (22, 14, 34, 10, CAST(8237.00 AS Decimal(10, 2)), CAST(17.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (31, 15, 31, 19, CAST(4147.00 AS Decimal(10, 2)), CAST(38.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (13, 16, 25, 1, CAST(1999.00 AS Decimal(10, 2)), CAST(43.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (59, 17, 26, 29, CAST(4643.00 AS Decimal(10, 2)), CAST(42.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (54, 18, 23, 1, CAST(9201.00 AS Decimal(10, 2)), CAST(5.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (95, 20, 32, 37, CAST(9218.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (14, 21, 15, 28, CAST(16825.00 AS Decimal(10, 2)), CAST(5.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (47, 22, 32, 21, CAST(16304.00 AS Decimal(10, 2)), CAST(38.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (35, 23, 39, 1, CAST(18558.00 AS Decimal(10, 2)), CAST(18.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (75, 24, 33, 3, CAST(13196.00 AS Decimal(10, 2)), CAST(49.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (76, 27, 25, 30, CAST(11761.00 AS Decimal(10, 2)), CAST(42.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (58, 28, 22, 7, CAST(5947.00 AS Decimal(10, 2)), CAST(41.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (38, 29, 29, 6, CAST(12251.00 AS Decimal(10, 2)), CAST(22.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (77, 30, 32, 11, CAST(12926.00 AS Decimal(10, 2)), CAST(48.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (83, 32, 16, 23, CAST(8110.00 AS Decimal(10, 2)), CAST(10.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (22, 33, 17, 15, CAST(2988.00 AS Decimal(10, 2)), CAST(25.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (52, 35, 28, 30, CAST(8232.00 AS Decimal(10, 2)), CAST(3.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (18, 36, 19, 9, CAST(10433.00 AS Decimal(10, 2)), CAST(49.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (51, 40, 30, 13, CAST(6901.00 AS Decimal(10, 2)), CAST(43.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (53, 44, 26, 41, CAST(14592.00 AS Decimal(10, 2)), CAST(8.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (83, 45, 14, 45, CAST(3849.00 AS Decimal(10, 2)), CAST(1.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (60, 46, 28, 15, CAST(14752.00 AS Decimal(10, 2)), CAST(38.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (23, 47, 33, 15, CAST(19726.00 AS Decimal(10, 2)), CAST(15.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (64, 49, 23, 26, CAST(17979.00 AS Decimal(10, 2)), CAST(42.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (40, 51, 24, 18, CAST(16614.00 AS Decimal(10, 2)), CAST(39.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (46, 52, 33, 50, CAST(8773.00 AS Decimal(10, 2)), CAST(16.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (73, 53, 21, 3, CAST(12341.00 AS Decimal(10, 2)), CAST(18.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (69, 54, 15, 6, CAST(1935.00 AS Decimal(10, 2)), CAST(18.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (41, 55, 17, 9, CAST(3378.00 AS Decimal(10, 2)), CAST(11.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (89, 56, 21, 24, CAST(9852.00 AS Decimal(10, 2)), CAST(37.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (33, 58, 24, 4, CAST(6330.00 AS Decimal(10, 2)), CAST(50.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (42, 59, 16, 22, CAST(18732.00 AS Decimal(10, 2)), CAST(49.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (95, 62, 29, 17, CAST(5718.00 AS Decimal(10, 2)), CAST(19.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (84, 64, 30, 26, CAST(1747.00 AS Decimal(10, 2)), CAST(34.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (6, 65, 18, 24, CAST(13627.00 AS Decimal(10, 2)), CAST(46.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (37, 66, 15, 34, CAST(18956.00 AS Decimal(10, 2)), CAST(1.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (96, 67, 35, 25, CAST(1357.00 AS Decimal(10, 2)), CAST(33.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (84, 68, 24, 5, CAST(10314.00 AS Decimal(10, 2)), CAST(20.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (70, 70, 20, 43, CAST(13134.00 AS Decimal(10, 2)), CAST(31.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (54, 77, 24, 49, CAST(19504.00 AS Decimal(10, 2)), CAST(16.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (81, 79, 29, 15, CAST(16078.00 AS Decimal(10, 2)), CAST(10.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (38, 80, 14, 49, CAST(14318.00 AS Decimal(10, 2)), CAST(25.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (93, 82, 18, 19, CAST(13317.00 AS Decimal(10, 2)), CAST(35.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (40, 83, 17, 26, CAST(8924.00 AS Decimal(10, 2)), CAST(33.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (31, 84, 22, 38, CAST(17527.00 AS Decimal(10, 2)), CAST(25.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (58, 93, 33, 44, CAST(15407.00 AS Decimal(10, 2)), CAST(44.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (89, 94, 31, 17, CAST(3000.00 AS Decimal(10, 2)), CAST(31.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (12, 96, 20, 22, CAST(7141.00 AS Decimal(10, 2)), CAST(3.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (82, 97, 28, 15, CAST(19448.00 AS Decimal(10, 2)), CAST(47.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (36, 98, 26, 13, CAST(9275.00 AS Decimal(10, 2)), CAST(43.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (52, 99, 21, 19, CAST(11156.00 AS Decimal(10, 2)), CAST(35.00 AS Decimal(4, 2)))
INSERT [dbo].[siparis_nesneleri] ([siparis_id], [nesne_id], [ürün_id], [miktar], [liste_fiyati], [indirim]) VALUES (30, 100, 15, 4, CAST(3652.00 AS Decimal(10, 2)), CAST(44.00 AS Decimal(4, 2)))
SET IDENTITY_INSERT [dbo].[siparişler] ON 

INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (2, 236, 0, CAST(N'2017-09-20' AS Date), CAST(N'2014-08-14' AS Date), CAST(N'2014-08-07' AS Date), 9, 81)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (3, 211, 0, CAST(N'2013-02-20' AS Date), CAST(N'2014-11-28' AS Date), CAST(N'2017-03-10' AS Date), 14, 53)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (4, 284, 0, CAST(N'2018-04-07' AS Date), CAST(N'2016-09-25' AS Date), CAST(N'2016-09-14' AS Date), 11, 34)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (5, 215, 1, CAST(N'2013-05-22' AS Date), CAST(N'2015-03-29' AS Date), CAST(N'2017-09-21' AS Date), 4, 90)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (6, 286, 1, CAST(N'2013-08-08' AS Date), CAST(N'2015-05-03' AS Date), CAST(N'2013-02-14' AS Date), 19, 49)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (7, 209, 1, CAST(N'2018-09-15' AS Date), CAST(N'2019-10-02' AS Date), CAST(N'2014-01-05' AS Date), 10, 86)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (8, 224, 0, CAST(N'2014-09-15' AS Date), CAST(N'2019-08-30' AS Date), CAST(N'2014-03-10' AS Date), 11, 100)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (9, 289, 0, CAST(N'2013-09-13' AS Date), CAST(N'2014-05-11' AS Date), CAST(N'2018-07-24' AS Date), 14, 7)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (10, 207, 1, CAST(N'2018-03-16' AS Date), CAST(N'2014-09-11' AS Date), CAST(N'2014-11-13' AS Date), 12, 27)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (11, 214, 0, CAST(N'2014-03-23' AS Date), CAST(N'2019-06-29' AS Date), CAST(N'2019-01-07' AS Date), 9, 85)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (12, 287, 0, CAST(N'2015-09-20' AS Date), CAST(N'2019-01-24' AS Date), CAST(N'2014-01-25' AS Date), 21, 54)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (13, 208, 1, CAST(N'2015-11-16' AS Date), CAST(N'2014-02-10' AS Date), CAST(N'2014-05-08' AS Date), 23, 7)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (14, 263, 1, CAST(N'2016-02-06' AS Date), CAST(N'2016-03-23' AS Date), CAST(N'2014-03-26' AS Date), 3, 85)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (15, 204, 1, CAST(N'2019-09-24' AS Date), CAST(N'2015-07-01' AS Date), CAST(N'2013-01-09' AS Date), 17, 17)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (16, 295, 0, CAST(N'2017-02-04' AS Date), CAST(N'2018-04-24' AS Date), CAST(N'2017-04-10' AS Date), 1, 6)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (17, 252, 0, CAST(N'2017-07-26' AS Date), CAST(N'2013-09-22' AS Date), CAST(N'2016-11-20' AS Date), 25, 87)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (18, 299, 0, CAST(N'2015-11-04' AS Date), CAST(N'2016-10-26' AS Date), CAST(N'2016-07-14' AS Date), 1, 69)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (19, 229, 0, CAST(N'2013-09-29' AS Date), CAST(N'2015-09-23' AS Date), CAST(N'2013-12-04' AS Date), 19, 48)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (20, 254, 0, CAST(N'2013-05-24' AS Date), CAST(N'2016-09-04' AS Date), CAST(N'2019-02-25' AS Date), 17, 91)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (21, 214, 1, CAST(N'2015-09-19' AS Date), CAST(N'2013-09-25' AS Date), CAST(N'2017-10-05' AS Date), 20, 17)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (22, 247, 0, CAST(N'2017-10-11' AS Date), CAST(N'2019-07-06' AS Date), CAST(N'2015-03-23' AS Date), 20, 81)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (23, 298, 0, CAST(N'2017-11-29' AS Date), CAST(N'2016-01-13' AS Date), CAST(N'2017-02-09' AS Date), 12, 26)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (24, 212, 0, CAST(N'2015-04-07' AS Date), CAST(N'2017-03-12' AS Date), CAST(N'2018-02-13' AS Date), 24, 2)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (25, 256, 1, CAST(N'2014-02-05' AS Date), CAST(N'2013-10-17' AS Date), CAST(N'2016-09-20' AS Date), 15, 36)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (26, 250, 0, CAST(N'2016-05-17' AS Date), CAST(N'2019-02-17' AS Date), CAST(N'2015-06-26' AS Date), 15, 34)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (27, 278, 0, CAST(N'2014-10-16' AS Date), CAST(N'2013-10-28' AS Date), CAST(N'2017-09-04' AS Date), 10, 10)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (28, 221, 1, CAST(N'2013-08-02' AS Date), CAST(N'2018-03-29' AS Date), CAST(N'2013-03-16' AS Date), 14, 71)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (29, 261, 1, CAST(N'2016-08-07' AS Date), CAST(N'2016-09-07' AS Date), CAST(N'2015-11-22' AS Date), 19, 48)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (30, 298, 1, CAST(N'2019-08-01' AS Date), CAST(N'2019-12-14' AS Date), CAST(N'2017-09-17' AS Date), 25, 96)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (31, 202, 1, CAST(N'2014-03-27' AS Date), CAST(N'2017-02-25' AS Date), CAST(N'2014-07-23' AS Date), 7, 60)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (32, 242, 1, CAST(N'2015-11-03' AS Date), CAST(N'2013-11-20' AS Date), CAST(N'2014-11-09' AS Date), 16, 5)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (33, 231, 1, CAST(N'2019-08-15' AS Date), CAST(N'2015-11-03' AS Date), CAST(N'2016-08-06' AS Date), 24, 95)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (35, 247, 1, CAST(N'2014-09-02' AS Date), CAST(N'2013-08-27' AS Date), CAST(N'2016-02-15' AS Date), 15, 65)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (36, 287, 0, CAST(N'2019-03-26' AS Date), CAST(N'2016-02-10' AS Date), CAST(N'2016-07-11' AS Date), 3, 88)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (37, 240, 1, CAST(N'2019-04-26' AS Date), CAST(N'2018-08-29' AS Date), CAST(N'2016-08-05' AS Date), 20, 36)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (38, 276, 1, CAST(N'2013-10-22' AS Date), CAST(N'2017-01-31' AS Date), CAST(N'2018-02-17' AS Date), 8, 46)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (39, 226, 0, CAST(N'2016-12-07' AS Date), CAST(N'2018-11-06' AS Date), CAST(N'2018-04-08' AS Date), 10, 30)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (40, 233, 1, CAST(N'2015-09-29' AS Date), CAST(N'2014-04-08' AS Date), CAST(N'2016-12-12' AS Date), 1, 33)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (41, 214, 1, CAST(N'2017-08-13' AS Date), CAST(N'2018-10-27' AS Date), CAST(N'2019-10-11' AS Date), 9, 24)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (42, 223, 1, CAST(N'2016-07-19' AS Date), CAST(N'2018-10-21' AS Date), CAST(N'2018-02-07' AS Date), 24, 35)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (43, 267, 1, CAST(N'2013-09-15' AS Date), CAST(N'2016-11-12' AS Date), CAST(N'2018-01-25' AS Date), 23, 68)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (44, 283, 0, CAST(N'2016-04-21' AS Date), CAST(N'2016-07-01' AS Date), CAST(N'2015-11-17' AS Date), 19, 86)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (45, 221, 1, CAST(N'2014-09-12' AS Date), CAST(N'2013-03-09' AS Date), CAST(N'2016-08-20' AS Date), 11, 20)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (46, 235, 1, CAST(N'2019-06-05' AS Date), CAST(N'2019-03-21' AS Date), CAST(N'2015-02-21' AS Date), 24, 95)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (47, 276, 1, CAST(N'2016-04-17' AS Date), CAST(N'2013-08-02' AS Date), CAST(N'2016-10-11' AS Date), 21, 36)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (48, 224, 1, CAST(N'2014-03-02' AS Date), CAST(N'2013-10-27' AS Date), CAST(N'2019-05-10' AS Date), 8, 67)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (49, 246, 0, CAST(N'2019-01-30' AS Date), CAST(N'2018-07-10' AS Date), CAST(N'2016-05-05' AS Date), 23, 65)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (50, 285, 1, CAST(N'2018-01-02' AS Date), CAST(N'2018-06-23' AS Date), CAST(N'2019-01-18' AS Date), 8, 100)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (51, 231, 0, CAST(N'2019-06-28' AS Date), CAST(N'2018-11-27' AS Date), CAST(N'2013-09-05' AS Date), 7, 24)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (52, 268, 1, CAST(N'2013-02-08' AS Date), CAST(N'2014-02-25' AS Date), CAST(N'2013-03-18' AS Date), 17, 88)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (53, 257, 0, CAST(N'2014-04-11' AS Date), CAST(N'2016-10-14' AS Date), CAST(N'2014-01-15' AS Date), 11, 96)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (54, 271, 0, CAST(N'2015-09-01' AS Date), CAST(N'2016-07-31' AS Date), CAST(N'2014-01-25' AS Date), 23, 85)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (55, 292, 0, CAST(N'2017-07-13' AS Date), CAST(N'2018-12-27' AS Date), CAST(N'2015-10-21' AS Date), 3, 93)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (56, 238, 0, CAST(N'2019-02-19' AS Date), CAST(N'2015-06-27' AS Date), CAST(N'2019-05-21' AS Date), 21, 74)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (57, 245, 1, CAST(N'2014-07-20' AS Date), CAST(N'2014-09-27' AS Date), CAST(N'2015-07-06' AS Date), 11, 8)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (58, 289, 0, CAST(N'2018-04-03' AS Date), CAST(N'2015-10-13' AS Date), CAST(N'2018-01-12' AS Date), 6, 71)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (59, 207, 0, CAST(N'2014-10-18' AS Date), CAST(N'2016-04-24' AS Date), CAST(N'2013-07-21' AS Date), 23, 58)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (60, 246, 0, CAST(N'2015-08-29' AS Date), CAST(N'2013-12-27' AS Date), CAST(N'2016-10-22' AS Date), 5, 53)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (61, 209, 0, CAST(N'2013-08-25' AS Date), CAST(N'2019-02-26' AS Date), CAST(N'2016-01-02' AS Date), 18, 79)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (62, 237, 1, CAST(N'2018-09-21' AS Date), CAST(N'2013-06-20' AS Date), CAST(N'2017-04-07' AS Date), 21, 9)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (63, 281, 0, CAST(N'2016-07-25' AS Date), CAST(N'2019-09-20' AS Date), CAST(N'2019-07-27' AS Date), 1, 82)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (64, 204, 1, CAST(N'2014-06-15' AS Date), CAST(N'2017-12-26' AS Date), CAST(N'2016-04-28' AS Date), 11, 83)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (65, 237, 0, CAST(N'2019-07-15' AS Date), CAST(N'2013-07-05' AS Date), CAST(N'2017-10-24' AS Date), 1, 45)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (66, 278, 0, CAST(N'2016-08-20' AS Date), CAST(N'2013-07-04' AS Date), CAST(N'2019-03-05' AS Date), 8, 79)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (67, 270, 0, CAST(N'2014-07-24' AS Date), CAST(N'2013-11-22' AS Date), CAST(N'2017-04-10' AS Date), 17, 39)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (69, 274, 0, CAST(N'2019-10-03' AS Date), CAST(N'2015-11-13' AS Date), CAST(N'2015-07-23' AS Date), 11, 61)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (70, 261, 1, CAST(N'2016-02-22' AS Date), CAST(N'2013-10-15' AS Date), CAST(N'2019-09-13' AS Date), 14, 86)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (71, 287, 1, CAST(N'2015-02-25' AS Date), CAST(N'2015-05-29' AS Date), CAST(N'2018-10-29' AS Date), 19, 18)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (72, 217, 0, CAST(N'2018-02-24' AS Date), CAST(N'2013-03-13' AS Date), CAST(N'2019-10-20' AS Date), 4, 17)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (73, 280, 0, CAST(N'2017-05-26' AS Date), CAST(N'2014-04-04' AS Date), CAST(N'2013-03-28' AS Date), 14, 41)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (74, 277, 1, CAST(N'2018-04-15' AS Date), CAST(N'2017-04-03' AS Date), CAST(N'2013-01-14' AS Date), 25, 9)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (75, 243, 0, CAST(N'2013-07-21' AS Date), CAST(N'2017-02-18' AS Date), CAST(N'2015-04-28' AS Date), 11, 72)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (76, 294, 0, CAST(N'2014-08-30' AS Date), CAST(N'2018-12-09' AS Date), CAST(N'2016-05-22' AS Date), 19, 53)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (77, 233, 1, CAST(N'2018-05-10' AS Date), CAST(N'2016-05-25' AS Date), CAST(N'2014-04-19' AS Date), 6, 18)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (78, 296, 0, CAST(N'2013-03-11' AS Date), CAST(N'2019-06-29' AS Date), CAST(N'2015-03-01' AS Date), 14, 39)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (79, 208, 1, CAST(N'2016-12-15' AS Date), CAST(N'2013-04-04' AS Date), CAST(N'2014-05-05' AS Date), 18, 52)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (80, 209, 0, CAST(N'2015-07-26' AS Date), CAST(N'2017-08-16' AS Date), CAST(N'2017-02-25' AS Date), 19, 88)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (81, 214, 0, CAST(N'2016-10-10' AS Date), CAST(N'2017-04-03' AS Date), CAST(N'2016-03-10' AS Date), 17, 72)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (82, 266, 1, CAST(N'2019-04-22' AS Date), CAST(N'2016-09-26' AS Date), CAST(N'2019-08-25' AS Date), 1, 42)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (83, 282, 0, CAST(N'2019-08-21' AS Date), CAST(N'2013-07-09' AS Date), CAST(N'2015-08-30' AS Date), 10, 55)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (84, 271, 0, CAST(N'2014-10-13' AS Date), CAST(N'2015-04-11' AS Date), CAST(N'2016-10-06' AS Date), 15, 56)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (85, 286, 1, CAST(N'2017-10-24' AS Date), CAST(N'2013-08-16' AS Date), CAST(N'2019-03-20' AS Date), 7, 13)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (86, 248, 0, CAST(N'2019-06-24' AS Date), CAST(N'2015-07-25' AS Date), CAST(N'2018-01-01' AS Date), 22, 29)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (87, 265, 0, CAST(N'2018-03-29' AS Date), CAST(N'2014-07-05' AS Date), CAST(N'2016-08-01' AS Date), 15, 76)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (88, 224, 0, CAST(N'2019-02-23' AS Date), CAST(N'2014-02-17' AS Date), CAST(N'2018-02-08' AS Date), 25, 29)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (89, 214, 1, CAST(N'2019-05-02' AS Date), CAST(N'2019-01-14' AS Date), CAST(N'2019-09-14' AS Date), 18, 62)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (90, 286, 0, CAST(N'2015-06-03' AS Date), CAST(N'2019-10-02' AS Date), CAST(N'2019-01-09' AS Date), 1, 71)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (91, 260, 1, CAST(N'2013-11-02' AS Date), CAST(N'2014-03-17' AS Date), CAST(N'2014-10-23' AS Date), 18, 43)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (92, 218, 0, CAST(N'2014-07-21' AS Date), CAST(N'2014-06-23' AS Date), CAST(N'2013-03-05' AS Date), 22, 70)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (93, 231, 1, CAST(N'2016-03-09' AS Date), CAST(N'2013-12-03' AS Date), CAST(N'2015-08-17' AS Date), 24, 76)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (94, 284, 0, CAST(N'2017-01-14' AS Date), CAST(N'2015-01-02' AS Date), CAST(N'2014-03-02' AS Date), 19, 44)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (95, 269, 1, CAST(N'2015-11-06' AS Date), CAST(N'2013-11-09' AS Date), CAST(N'2014-04-30' AS Date), 3, 97)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (96, 214, 0, CAST(N'2017-04-18' AS Date), CAST(N'2013-01-12' AS Date), CAST(N'2016-12-28' AS Date), 4, 78)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (97, 234, 1, CAST(N'2014-02-05' AS Date), CAST(N'2018-01-23' AS Date), CAST(N'2018-06-26' AS Date), 12, 3)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (98, 214, 1, CAST(N'2016-08-02' AS Date), CAST(N'2013-11-11' AS Date), CAST(N'2014-11-23' AS Date), 7, 39)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (99, 250, 0, CAST(N'2017-10-19' AS Date), CAST(N'2016-07-15' AS Date), CAST(N'2014-01-10' AS Date), 4, 72)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (100, 282, 0, CAST(N'2013-07-21' AS Date), CAST(N'2013-03-06' AS Date), CAST(N'2019-11-12' AS Date), 7, 89)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (101, 221, 1, CAST(N'2018-11-30' AS Date), CAST(N'2018-02-24' AS Date), CAST(N'2018-12-04' AS Date), 18, 31)
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (106, 202, 1, CAST(N'2013-12-04' AS Date), CAST(N'2013-12-10' AS Date), CAST(N'2013-12-25' AS Date), 5, 64)
GO
INSERT [dbo].[siparişler] ([siparis_id], [müşteri_id], [sipariş_durumu], [sipariş_tarihi], [gerekli_zaman], [gönderim_tarihi], [depo_id], [calisan_id]) VALUES (107, 202, 1, CAST(N'2013-12-04' AS Date), CAST(N'2013-12-10' AS Date), CAST(N'2013-12-25' AS Date), 5, 64)
SET IDENTITY_INSERT [dbo].[siparişler] OFF
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (1, 13, 20)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (3, 14, 50)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (4, 15, 5)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (5, 16, 15)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (6, 17, 17)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (7, 18, 26)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (8, 19, 1)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (9, 20, 29)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (10, 21, 45)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (11, 22, 24)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (12, 23, 7)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (13, 24, 9)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (14, 25, 7)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (15, 26, 3)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (16, 28, 12)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (17, 29, 15)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (18, 30, 32)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (19, 31, 6)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (20, 32, 9)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (21, 33, 19)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (22, 34, 21)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (23, 35, 2)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (24, 36, 5)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (25, 38, 36)
INSERT [dbo].[stoklar] ([depo_id], [ürün_id], [miktar]) VALUES (26, 39, 22)
SET IDENTITY_INSERT [dbo].[ürünler] ON 

INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (13, N'TILT 500', 1, 1, 2021, CAST(1560.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (14, N'KATLANIR BİSİKLET ', 1, 1, 2020, CAST(1250.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (15, N'DAĞ BİSİKLETİ - 27,5'''' - GRİ - ST 100', 1, 2, 2019, CAST(150000.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (16, N'DAĞ BİSİKLETİ - 29''', 2, 2, 2017, CAST(12000.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (17, N'ÇOCUK BİSİKLETİ - 4,5 / 6 YAŞ - 16 JANT - TURUNCU - 500', 13, 4, 2016, CAST(1050.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (18, N'ÇOCUK DAĞ BİSİKLETİ 9 - 12 YAŞ / 24 İNÇ - BEYAZ - ROCKRIDER ST 100', 23, 4, 2021, CAST(1200.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (19, N'DAĞ BİSİKLETİ - 27,5'''' - BEYAZ / PEMBE - ST 100', 19, 2, 2020, CAST(1890.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (20, N'ŞEHİR BİSİKLETİ - ALÇAK KADRO - MAVİ - ELOPS 120', 7, 1, 2006, CAST(1950.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (21, N'YOL BİSİKLETİ - SİYAH - RC500', 5, 3, 2020, CAST(6000.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (22, N'KIZ ÇOCUK HİBRİT BİSİKLETİ / 9 - 12 YAŞ 24 İNÇ ORIGINAL 500', 17, 4, 2021, CAST(1550.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (23, N'ÇOCUK HİBRİT BİSİKLET - 20 İNÇ - ORIGINAL 500', 12, 4, 2019, CAST(1450.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (24, N'KATLANIR BİSİKLET - SİYAH - TILT 100', 20, 3, 2020, CAST(1700.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (25, N'500 BİSİKLET - 16 İNÇ - 4,5 / 6 YAŞ - DOCTO GİRL DESENLİ', 9, 4, 2018, CAST(1050.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (26, N'HİBRİT BİSİKLET - SİYAH - 100', 23, 1, 2017, CAST(1400.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (28, N'KATLANIR BİSİKLET- 7 VİTES - 20 JANT - TURUNCU -', 1, 3, 2016, CAST(2500.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (29, N'ÇOCUK DAĞ BİSİKLETİ 9 - 12 YAŞ 24 İNÇ 18 VİTES SARI - ROCKRIDER ST 500', 1, 2, 2017, CAST(1500.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (30, N'KATLANIR BİSİKLET - 6 VİTES - 20 JANT - KIRMIZI ', 1, 3, 2016, CAST(2100.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (31, N'ŞEHİR BİSİKLETİ - ALÇAK KADRO - SİYAH - 100', 3, 1, 2021, CAST(1500.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (32, N'ŞEHİR BİSİKLETİ - MAVİ - ALÇAK KADRO', 18, 1, 2010, CAST(2300.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (33, N'DAĞ BİSİKLETİ - 29'''' - EAGLE / MAVİ ', 16, 2, 2019, CAST(13000.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (34, N'DAĞ BİSİKLETİ - 27,5 JANT 21 VİTES - KIRMIZI - ST100', 2, 2, 2020, CAST(1950.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (35, N'DAĞ BİSİKLETİ - 29'''' - EAGLE / SARI', 12, 2, 2021, CAST(13000.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (36, N'ERKEK BİSİKLETLE SEYAHAT YOL BİSİKLETİ - GRİ', 5, 1, 2020, CAST(2600.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (38, N'DAĞ BİSİKLETİ - 27,5'''' - BEYAZ / PEMBE - ST 100', 22, 2, 2014, CAST(12500.00 AS Decimal(10, 2)))
INSERT [dbo].[ürünler] ([ürün_id], [ürün_ismi], [marka_id], [kategori_id], [model_yılı], [liste_fiyatı]) VALUES (39, N'KIZ ÇOCUK HİBRİT BİSİKLETİ / 9 - 12 YAŞ 24 İNÇ ORIGINAL 500', 6, 1, 2012, CAST(1550.00 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[ürünler] OFF
/****** Object:  Index [IX_sipariş_nesneleri]    Script Date: 14.01.2021 18:13:36 ******/
CREATE NONCLUSTERED INDEX [IX_sipariş_nesneleri] ON [dbo].[siparis_nesneleri]
(
	[siparis_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[çalışanlar]  WITH CHECK ADD  CONSTRAINT [FK_çalışanlar_çalışanlar1] FOREIGN KEY([yönetici_id])
REFERENCES [dbo].[çalışanlar] ([çalışan_id])
GO
ALTER TABLE [dbo].[çalışanlar] CHECK CONSTRAINT [FK_çalışanlar_çalışanlar1]
GO
ALTER TABLE [dbo].[çalışanlar]  WITH CHECK ADD  CONSTRAINT [FK_çalışanlar_depolar] FOREIGN KEY([depo_id])
REFERENCES [dbo].[depolar] ([depo_id])
GO
ALTER TABLE [dbo].[çalışanlar] CHECK CONSTRAINT [FK_çalışanlar_depolar]
GO
ALTER TABLE [dbo].[siparis_nesneleri]  WITH CHECK ADD  CONSTRAINT [FK_sipariş_nesneleri_siparişler] FOREIGN KEY([siparis_id])
REFERENCES [dbo].[siparişler] ([siparis_id])
GO
ALTER TABLE [dbo].[siparis_nesneleri] CHECK CONSTRAINT [FK_sipariş_nesneleri_siparişler]
GO
ALTER TABLE [dbo].[siparis_nesneleri]  WITH CHECK ADD  CONSTRAINT [FK_sipariş_nesneleri_ürünler] FOREIGN KEY([ürün_id])
REFERENCES [dbo].[ürünler] ([ürün_id])
GO
ALTER TABLE [dbo].[siparis_nesneleri] CHECK CONSTRAINT [FK_sipariş_nesneleri_ürünler]
GO
ALTER TABLE [dbo].[siparişler]  WITH CHECK ADD  CONSTRAINT [FK_siparişler_çalışanlar] FOREIGN KEY([calisan_id])
REFERENCES [dbo].[çalışanlar] ([çalışan_id])
GO
ALTER TABLE [dbo].[siparişler] CHECK CONSTRAINT [FK_siparişler_çalışanlar]
GO
ALTER TABLE [dbo].[siparişler]  WITH CHECK ADD  CONSTRAINT [FK_siparişler_depolar] FOREIGN KEY([depo_id])
REFERENCES [dbo].[depolar] ([depo_id])
GO
ALTER TABLE [dbo].[siparişler] CHECK CONSTRAINT [FK_siparişler_depolar]
GO
ALTER TABLE [dbo].[siparişler]  WITH CHECK ADD  CONSTRAINT [FK_siparişler_müşteriler] FOREIGN KEY([müşteri_id])
REFERENCES [dbo].[müşteriler] ([müşteri_id])
GO
ALTER TABLE [dbo].[siparişler] CHECK CONSTRAINT [FK_siparişler_müşteriler]
GO
ALTER TABLE [dbo].[stoklar]  WITH CHECK ADD  CONSTRAINT [FK_stoklar_depolar] FOREIGN KEY([depo_id])
REFERENCES [dbo].[depolar] ([depo_id])
GO
ALTER TABLE [dbo].[stoklar] CHECK CONSTRAINT [FK_stoklar_depolar]
GO
ALTER TABLE [dbo].[stoklar]  WITH CHECK ADD  CONSTRAINT [FK_stoklar_ürünler] FOREIGN KEY([ürün_id])
REFERENCES [dbo].[ürünler] ([ürün_id])
GO
ALTER TABLE [dbo].[stoklar] CHECK CONSTRAINT [FK_stoklar_ürünler]
GO
ALTER TABLE [dbo].[ürünler]  WITH CHECK ADD  CONSTRAINT [FK_ürünler_kategoriler] FOREIGN KEY([kategori_id])
REFERENCES [dbo].[kategoriler] ([kategori_id])
GO
ALTER TABLE [dbo].[ürünler] CHECK CONSTRAINT [FK_ürünler_kategoriler]
GO
ALTER TABLE [dbo].[ürünler]  WITH CHECK ADD  CONSTRAINT [FK_ürünler_markalar] FOREIGN KEY([marka_id])
REFERENCES [dbo].[markalar] ([marka_id])
GO
ALTER TABLE [dbo].[ürünler] CHECK CONSTRAINT [FK_ürünler_markalar]
GO
/****** Object:  StoredProcedure [dbo].[EncokSatan]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[EncokSatan]
AS
BEGIN
declare @calisan_id INT
declare @musteri_id INT
declare @musteri_adet INT

Select TOP(1) @calisan_id=calisan_id
From siparişler

Select * from çalışanlar Where çalışan_id=@calisan_id

Select @musteri_adet=COUNT(*) from siparişler Where calisan_id=@calisan_id


while @musteri_adet > 0
BEGIN
	Select @musteri_id=müşteri_id from siparişler Where calisan_id=@calisan_id
	Select * from müşteriler Where müşteri_id=@musteri_id
	SET @musteri_adet=@musteri_adet-1;
END

END
GO
/****** Object:  StoredProcedure [dbo].[EnCokSatinAlan]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[EnCokSatinAlan]
AS
BEGIN
declare @calisan_id INT
declare @musteri_id INT

Select TOP(1) @musteri_id=müşteri_id, @calisan_id=calisan_id
From siparişler

Select * from müşteriler Where müşteri_id=@musteri_id

Select * from çalışanlar Where çalışan_id=@calisan_id
END
GO
/****** Object:  StoredProcedure [dbo].[StokDurumu]    Script Date: 14.01.2021 18:13:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[StokDurumu]  
AS
declare @urun_id INT
SELECT @urun_id=ürün_id FROM stoklar 
WHERE ürün_id < 50

Select * from ürünler Where ürün_id=@urun_id
GO
USE [master]
GO
ALTER DATABASE [Bisiklet_Dünyası] SET  READ_WRITE 
GO
