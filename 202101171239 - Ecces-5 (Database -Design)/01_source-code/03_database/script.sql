USE [master]
GO
/****** Object:  Database [sinavdb]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  Table [dbo].[bolum]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  Table [dbo].[ders]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  Table [dbo].[donem]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  Table [dbo].[fakulte]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  Table [dbo].[ogretim_uyesi]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  Table [dbo].[sinav]    Script Date: 17.01.2021 11:03:21 ******/
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
SET IDENTITY_INSERT [dbo].[bolum] ON 

INSERT [dbo].[bolum] ([Id], [fakulte_Id], [bolum_baskan_Id], [bolum_ad], [lisans_turu]) VALUES (4, 3, 2, N'ELEKTRİK ELEKTRONİK MÜHENDİSLİĞİ', N'Lisans')
INSERT [dbo].[bolum] ([Id], [fakulte_Id], [bolum_baskan_Id], [bolum_ad], [lisans_turu]) VALUES (5, 3, 2, N'YAZILIM MÜHENDİSLİĞİ', N'Lisans')
INSERT [dbo].[bolum] ([Id], [fakulte_Id], [bolum_baskan_Id], [bolum_ad], [lisans_turu]) VALUES (6, 3, 2, N'İNŞAAT MÜHENDİSLİĞİ', N'Lisans')
INSERT [dbo].[bolum] ([Id], [fakulte_Id], [bolum_baskan_Id], [bolum_ad], [lisans_turu]) VALUES (7, 3, 2, N'GIDA MÜHENDİSLİĞİ', N'Lisans')
INSERT [dbo].[bolum] ([Id], [fakulte_Id], [bolum_baskan_Id], [bolum_ad], [lisans_turu]) VALUES (8, 3, 2, N'MAKİNE MÜHENDİSLİĞİ', N'Lisans')
SET IDENTITY_INSERT [dbo].[bolum] OFF
SET IDENTITY_INSERT [dbo].[ders] ON 

INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (5, 4, N'Elektrik Makinaları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (6, 4, N'Uygulamalı Elektromanyetik Teori', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (7, 4, N'Matematik-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (8, 4, N'Diferansiyel Denklemler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (9, 4, N'Lineer Cebir (Eski Müf.)', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (10, 4, N'Yapay Zeka', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (11, 4, N'İşaretler ve Sistemler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (12, 4, N'Ölçme Tekniği ve Algılayıcılar', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (13, 4, N'Bulanık Mantık', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (14, 4, N'İş Sağ. ve Güvenliği-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (15, 4, N'Devre Teorisi-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (16, 4, N'Fizik-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (17, 4, N'Elektromanyetik Dalga Teorisi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (18, 4, N'Elektriksel MAlzemeler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (19, 4, N'Mantık Devreleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (20, 4, N'EEM Giriş (Eski Müf.)', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (21, 4, N'Elektronik Devreler-II', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (22, 4, N'Antenler ve Propagasyon', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (23, 4, N'Algoritma Temelleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (24, 4, N'Araştırma Yöntem ve Teknikleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (25, 4, N'İngilizce-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (26, 4, N'İngilizce-III', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (27, 4, N'Elektrik Enerjisi Dağıtımı', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (28, 4, N'Enerji İletimi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (29, 4, N'Elektronik Laboratuvarı', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (30, 4, N'Atatürk İlkeleri ve İnkılap Tarihi-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (31, 4, N'C Programlama', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (32, 4, N'Türk Dili-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (33, 4, N'Mühendislikte Ofis Uygulamaları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (34, 4, N'Bitirme Projesi-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (35, 4, N'Akademik Türkçe', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (36, 5, N'Mesleki İngilizce-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (37, 5, N'Yazılım Mühendisliğine Giriş', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (38, 5, N'Formal Diller ve Otomatlar', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (39, 5, N'Bilgisayar Ağları ve İletişim', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (40, 5, N'FİZİK-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (41, 5, N'Araştırma Yöntem ve Teknikleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (42, 5, N'Algoritma ve Programlama', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (43, 5, N'Bilgisayar bilimlerinde Ayrık Yapılar', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (44, 5, N'Yönetim Bilişim Sistemleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (45, 5, N'İleri Web Programlama', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (46, 5, N'Nesneye Yönelik Programlama', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (47, 5, N'Yapay Zeka ve Uzman Sistemler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (48, 5, N'Üretim Planlama Tasarım Ve Kont. Prog.', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (49, 5, N'Bilgisayar Bilimlerinde Doğrusal', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (50, 5, N'İngilizce III', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (51, 5, N'Matematik I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (52, 5, N'Python Programlama', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (53, 5, N'Oyun Programlama', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (54, 5, N'Web Programlama I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (55, 5, N'Atatürk İlkeleri ve İnkılap Tarihi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (56, 5, N'İngilizce I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (57, 5, N'Görsel Programlama', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (58, 5, N'Türk Dili-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (59, 5, N'Mühendislikte Ofis Ugulamaları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (60, 5, N'Akademik Türkçe', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (61, 5, N'Veritabanı Yönetim Sistemleri I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (62, 5, N'Bilgisayar Grafikleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (63, 5, N'Yazılım Mimarisi ve Tasarımı', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (64, 5, N'Yazılım Ölçme ve Sınama', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (65, 6, N'Dinamik', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (66, 6, N'Mukavemet', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (67, 6, N'Yapı Dinamiği', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (68, 6, N'Zemin Mekaniği', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (69, 6, N'Temel İnşaat', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (70, 6, N'İnşaat Mühendisliğine Giriş', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (71, 6, N'Hidrolik', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (72, 6, N'Su Temini ve Çevre Sağlığı', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (73, 6, N'Diferansiyel Denklemler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (74, 6, N'Matematik-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (75, 6, N'Yapı Malzemesinde Durabilite Etkisi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (76, 6, N'Çelik Yapılar-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (77, 6, N'Malzeme Bilimi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (78, 6, N'Kimya-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (79, 6, N'Yapı Bilgisi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (80, 6, N'Topografya', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (81, 6, N'Araştırma Yöntem ve Teknikleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (82, 6, N'İngilizce-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (83, 6, N'İngilizce-III', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (84, 6, N'Beton Bileşimi Tasarımı (S)', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (85, 6, N'Karayolu Mühendisliği', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (86, 6, N'Fizik-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (87, 6, N'Yapı Statiği-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (88, 6, N'Sanat Tarihi (S)', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (89, 6, N'Atatürk İlkeleri ve İnkılap Tarihi-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (90, 6, N'Türk Dili-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (91, 6, N'Mühendislikte Ofis Uygulamaları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (92, 6, N'Betonarme-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (93, 6, N'Mühendislik Matematiği', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (94, 6, N'Beton Teknolojisi (S)', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (95, 7, N'Genel Kimya', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (96, 7, N'Gıda Analizleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (97, 7, N'Proses Kontrol', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (98, 7, N'Gıda Kimyasi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (99, 7, N'Fizik-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (100, 7, N'Isı ve Kütle Transferi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (101, 7, N'Gıda Maddelerinin Ambalajlanması', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (102, 7, N'Gıda Mühendisliğinde Isıl Olmayan İşlemler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (103, 7, N'Matematik I', 1)
GO
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (104, 7, N'Beslenme', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (105, 7, N'Özel Gıdalar Teknolojisi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (106, 7, N'Süt Teknolojisi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (107, 7, N'Diferansiyel Denklemler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (108, 7, N'Gıda Mühendisliğinde Temel İşlemler-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (109, 7, N'İngilizce I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (110, 7, N'İngilizce III', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (111, 7, N'Kalite Sistemleri ve Mevzuat', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (112, 7, N'Kütle ve Enerji Denklikleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (113, 7, N'Gıda Yan Ürünleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (114, 7, N'Atatürk İlkeleri ve İnkılap Tarihi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (115, 7, N'Gıda Mühendisliği Dizayn ve Ekonomisi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (116, 7, N'Türk Dili - I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (117, 7, N'Mühendislikte Ofis Uygulamaları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (118, 7, N'Gıda Mühendisliğine Giriş ve Etik', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (119, 7, N'Akademik Türkçe', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (120, 7, N'Biyoteknoloji', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (121, 7, N'Reaksiyon Kinetiği', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (122, 7, N'Mesleki İngilizce-I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (123, 7, N'Araştırma Yöntem ve Teknikleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (124, 7, N'Gıda Mikrobiyolojisi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (125, 7, N'Et Teknolojisi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (126, 7, N'Bitirme Projesi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (127, 8, N'Teknik Çizim', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (128, 8, N'Makine Mühendisliğine Giriş', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (129, 8, N'Fizik I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (130, 8, N'Matematik I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (131, 8, N'Mak. Müh. İçin Lineer Cebir', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (132, 8, N'İngilizce I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (133, 8, N'Türk Dili I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (134, 8, N'Atatürk İlkeleri ve İnkılap Tarihi I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (135, 8, N'Mühendislikte Ofis Uygulamaları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (136, 8, N'Akademik Türkçe', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (137, 8, N'Diferansiyal Denklemler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (138, 8, N'Malzeme Bilgisi I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (139, 8, N'Araştırma Yöntem ve Teknikleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (140, 8, N'Mekanik II', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (141, 8, N'Bilgisayar Destekli Tasarım I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (142, 8, N'Takım Tezgahları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (143, 8, N'Cisimlerin Dayanımı I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (144, 8, N'Termodinamik II', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (145, 8, N'Isı Geçişi', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (146, 8, N'Makine Elemanları I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (147, 8, N'Mesleki İngilizce', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (149, 8, N'İmal Usulleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (150, 8, N'Mekanizma Tekniği', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (151, 8, N'Akışkanlar Mekaniği II', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (152, 8, N'Müh. Bilg. Dest. An. Uyg.', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (153, 8, N'Laboratuvar I', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (154, 8, N'Kompozit Malzemeler', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (155, 8, N'Alternatif Enerji Kaynakları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (156, 8, N'Endüstri Robotları', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (157, 8, N'Makine Titreşimleri', 1)
INSERT [dbo].[ders] ([Id], [bolum_Id], [ders_ad], [kredi]) VALUES (158, 8, N'Bitirme Projesi I', 1)
SET IDENTITY_INSERT [dbo].[ders] OFF
SET IDENTITY_INSERT [dbo].[donem] ON 

INSERT [dbo].[donem] ([Id], [donem_ad], [baslangic_yil], [bitis_yil]) VALUES (3, N'Güz', 2020, 2021)
SET IDENTITY_INSERT [dbo].[donem] OFF
SET IDENTITY_INSERT [dbo].[fakulte] ON 

INSERT [dbo].[fakulte] ([Id], [fakulte_ad], [kurulus_tarih]) VALUES (3, N'MÜHENDİSLİK', CAST(N'2021-01-16' AS Date))
SET IDENTITY_INSERT [dbo].[fakulte] OFF
SET IDENTITY_INSERT [dbo].[ogretim_uyesi] ON 

INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (2, N'Dr.Öğr.', N'bilinmiyor', N'Engin', N'HÜNER', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (3, N'Dr.Öğr.', N'bilinmiyor', N'Sena Esen', N'BAYER KESKİN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (4, N'Dr. Öğr.', N'bilinmiyor', N'Muradiye', N'ÇİMDİKER ASLAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (5, N'Doç. Dr.', N'bilinmiyor', N'Özen', N'Özer', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (6, N'Araş. Gör. Dr.', N'bilinmiyor', N'Suzan', N'KANTARCI ŞAVAŞ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (7, N'Prof. Dr. A', N'bilinmiyor', N'Sabih', N'ATADAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (8, N'Öğr. Gör.', N'bilinmiyor', N'Eray', N'YILMAZLAR', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (9, N'Öğr. Gör.', N'bilinmiyor', N'Ömer', N'GÜLTEKİN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (10, N'Dr. Öğr', N'bilinmiyor', N'Sıtkı', N'KOCAOĞLU', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (11, N'Doç. Dr', N'bilinmiyor', N'Özlem', N'ÇELİK', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (12, N'Dr. Öğr', N'bilinmiyor', N'Burhan', N'ÇOŞKUN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (13, N'Dr. Öğr', N'bilinmiyor', N'Yılmaz', N'GÜBEN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (14, N'Öğr. Gör.', N'bilinmiyor', N'Ercan', N'ÇOŞKUN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (15, N'Araş. Gör. Dr.', N'bilinmiyor', N'Kevser', N'TÜTER ŞAHİNOĞLU', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (16, N'Öğr. Gör.', N'bilinmiyor', N'Ayfer', N'TANIŞ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (17, N'Öğr. Gör.', N'bilinmiyor', N'Volkan', N'ERDEMİR', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (18, N'Öğr. Gör.', N'bilinmiyor', N'Ali Osman', N'GÜNDÜZ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (19, N'Öğr. Gör.', N'bilinmiyor', N'Nadir', N'SUBAŞI', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (20, N'Öğr. Gör.', N'bilinmiyor', N'Ensar', N'ALEMDAR', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (21, N'Doç. Öğr', N'bilinmiyor', N'Murat Olcay', N'ÖZCAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (22, N'Öğr. Gör.', N'bilinmiyor', N'Tez', N'DANIŞMANI', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (23, N'Öğr. Gör.', N'bilinmiyor', N'Özlem', N'ŞUATAMAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (24, N'Dr. Öğr', N'bilinmiyor', N'Bora', N'ASLAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (25, N'Dr. Öğr', N'bilinmiyor', N'Edip Serdar', N'GÜNER', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (26, N'Dr. Arş. Gör.', N'bilinmiyor', N'Ufuk', N'PAKSU', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (27, N'Öğr. Gör.', N'bilinmiyor', N'Füsun', N'YAVUZER ASLAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (28, N'Öğr. Gör.', N'bilinmiyor', N'Hatice Büber', N'KAYA', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (29, N'Dr. Öğr', N'bilinmiyor', N'Ali', N'KANDEMİR', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (30, N'Dr. Öğr', N'bilinmiyor', N'Doğan', N'ÜNAL', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (31, N'Dr. Öğr', N'bilinmiyor', N'Hakan', N'ÜSTÜNEL', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (32, N'Dr. Öğr', N'bilinmiyor', N'Merve', N'ERMİŞ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (33, N'Dr. Öğr', N'bilinmiyor', N'Erdinç', N'KESKİN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (34, N'Dr. Öğr', N'bilinmiyor', N'Mustafa Utku', N'YILMAZ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (35, N'Dr. Öğr', N'bilinmiyor', N'Sinem', N'ŞİMŞEK', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (36, N'Dr. Öğr', N'bilinmiyor', N'Ramazan', N'EKMEKÇİ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (37, N'Dr. Öğr', N'bilinmiyor', N'Kadir', N'KILINÇ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (38, N'Prof. Dr.', N'bilinmiyor', N'Mensur', N'SÜMER', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (39, N'Doç. Dr', N'bilinmiyor', N'Mustafa', N'ARSLAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (40, N'Dr. Öğr', N'bilinmiyor', N'İsmail', N'KILIÇ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (41, N'Öğr. Gör.', N'bilinmiyor', N'Cevat', N'GÜLCÜ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (42, N'Araş. Gör. Dr.', N'bilinmiyor', N'Kevser', N'TÜTER ŞAHİNOĞLU', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (43, N'Öğr. Gör.', N'bilinmiyor', N'Tacettin', N'TURGAY', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (44, N'Dr. Öğr', N'bilinmiyor', N'Mustafa', N'ULAŞ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (45, N'Dr. Öğr', N'bilinmiyor', N'Ali', N'MÜLAYİM', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (46, N'Dr. Öğr', N'bilinmiyor', N'Emel', N'PELİT', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (47, N'Dr. Öğr', N'bilinmiyor', N'Buket', N'AŞKIN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (48, N'Dr. Öğr', N'bilinmiyor', N'Orhan Onur', N'AŞKIN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (49, N'Prof. Dr.', N'bilinmiyor', N'Hatice', N'ŞANLIDERE ALOĞLU', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (50, N'Dr. Araş. Gör.', N'bilinmiyor', N'Ufuk', N'PAKSU', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (51, N'Dr. Öğr.', N'bilinmiyor', N'Harun', N'URAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (52, N'Dr. Öğr.', N'bilinmiyor', N'Ramazan', N'EKMEKÇİ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (53, N'Dr. Öğr.', N'bilinmiyor', N'Özlem', N'KIRCI', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (54, N'Okt.', N'bilinmiyor', N'Tacettin', N'TURGAY', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (55, N'Dr. Öğr.', N'bilinmiyor', N'Bayram', N'ÇETİN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (56, N'-', N'bilinmiyor', N'Bölüm Öğretim', N'ELEMANI', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (57, N'Dr. Öğr', N'bilinmiyor', N'bilinmiyor', N'BİLİNMİYOR', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (58, N'Dr. Öğr', N'bilinmiyor', N'Mehmet', N'YEŞİLTAŞ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (59, N'Dr. Öğr', N'bilinmiyor', N'Serap', N'ÖZCAN', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (60, N'Dr. Öğr', N'bilinmiyor', N'Sinem', N'ŞİMŞEK', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (61, N'Dr. Öğr', N'bilinmiyor', N'Sences s.', N'KARABEYOĞLU', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (62, N'Prof. Dr.', N'bilinmiyor', N'Erol', N'TÜRKEŞ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (63, N'Doç. Dr.', N'bilinmiyor', N'Hale', N'KARAYER', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (64, N'Dr. Öğr', N'bilinmiyor', N'Osman', N'YÜKSEL', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (65, N'Doç. Dr.', N'bilinmiyor', N'Ümit', N'HÜNER', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
INSERT [dbo].[ogretim_uyesi] ([Id], [unvan], [tcno], [ad], [soyad], [telefon], [eposta], [adres]) VALUES (1057, N'Dr. Öğr', N'bilinmiyor', N'Olcay', N'EKŞİ', N'bilinmiyor', N'bilinmiyor', N'bilinmiyor')
SET IDENTITY_INSERT [dbo].[ogretim_uyesi] OFF
SET IDENTITY_INSERT [dbo].[sinav] ON 

INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (13, 4, 3, CAST(N'2020-11-30' AS Date), CAST(N'11:00:00' AS Time), 6, 3, 0, 0, 0, 1, N'Çevrimiçi', N'60 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (14, 4, 3, CAST(N'2020-11-30' AS Date), CAST(N'13:30:00' AS Time), 7, 4, 1, 0, 0, 1, N'Ödev', N'150 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (15, 4, 3, CAST(N'2020-11-30' AS Date), CAST(N'16:30:00' AS Time), 8, 4, 0, 1, 0, 0, N'Ödev', N'150 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (16, 4, 3, CAST(N'2020-11-30' AS Date), CAST(N'19:30:00' AS Time), 9, 5, 1, 1, 0, 0, N'Çevrimiçi', N'75 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (17, 4, 3, CAST(N'2020-12-01' AS Date), CAST(N'12:00:00' AS Time), 10, 6, 0, 0, 0, 1, N'Çevrimiçi', N'50 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (18, 4, 3, CAST(N'2020-12-01' AS Date), CAST(N'13:00:00' AS Time), 11, 7, 0, 0, 1, 1, N'Ödev', N'2 Gün*', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (19, 4, 3, CAST(N'2020-12-01' AS Date), CAST(N'14:00:00' AS Time), 12, 8, 1, 0, 1, 1, N'Çevrimiçi', N'30 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (20, 4, 3, CAST(N'2020-12-01' AS Date), CAST(N'15:30:00' AS Time), 13, 6, 1, 0, 1, 1, N'Çevrimiçi', N'50 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (21, 4, 3, CAST(N'2020-12-01' AS Date), CAST(N'17:00:00' AS Time), 14, 9, 1, 0, 1, 1, N'Çevrimiçi', N'20 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (22, 4, 3, CAST(N'2020-12-01' AS Date), CAST(N'18:00:00' AS Time), 15, 10, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (23, 4, 3, CAST(N'2020-12-02' AS Date), CAST(N'09:00:00' AS Time), 16, 11, 1, 1, 1, 1, N'Ödev', N'2 Gün*', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (24, 4, 3, CAST(N'2020-12-02' AS Date), CAST(N'10:00:00' AS Time), 17, 11, 1, 1, 1, 1, N'Ödev', N'2 Gün*', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (25, 4, 3, CAST(N'2020-12-02' AS Date), CAST(N'10:00:00' AS Time), 18, 12, 1, 0, 0, 0, N'Çevrimiçi', N'40 dk ', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (26, 4, 3, CAST(N'2020-12-02' AS Date), CAST(N'12:00:00' AS Time), 19, 13, 1, 1, 0, 0, N'Çevrimiçi', N'40 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (27, 4, 3, CAST(N'2020-12-02' AS Date), CAST(N'14:00:00' AS Time), 20, 14, 1, 1, 0, 0, N'Çevrimiçi', N'30 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (29, 4, 3, CAST(N'2020-12-02' AS Date), CAST(N'19:30:00' AS Time), 5, 3, 0, 0, 0, 1, N'Ödev', N'2 Gün*', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (30, 4, 3, CAST(N'2020-12-02' AS Date), CAST(N'15:00:00' AS Time), 21, 10, 0, 0, 1, 1, N'Çevrimiçi', N'30 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (31, 4, 3, CAST(N'2020-12-03' AS Date), CAST(N'09:00:00' AS Time), 23, 14, 1, 0, 1, 1, N'Çevrimiçi', N'30 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (32, 4, 3, CAST(N'2020-12-03' AS Date), CAST(N'12:00:00' AS Time), 24, 15, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (33, 4, 3, CAST(N'2020-12-03' AS Date), CAST(N'13:30:00' AS Time), 25, 16, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (34, 4, 3, CAST(N'2020-12-03' AS Date), CAST(N'14:30:00' AS Time), 26, 16, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (35, 4, 3, CAST(N'2020-12-03' AS Date), CAST(N'16:00:00' AS Time), 27, 17, 1, 1, 1, 1, N'Çevrimiçi', N'45 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (36, 4, 3, CAST(N'2020-12-03' AS Date), CAST(N'18:00:00' AS Time), 28, 17, 1, 1, 1, 1, N'Çevrimiçi', N'60 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (37, 4, 3, CAST(N'2020-12-04' AS Date), CAST(N'12:00:00' AS Time), 29, 10, 1, 1, 1, 1, N'Ödev', N'90 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (38, 4, 3, CAST(N'2020-12-04' AS Date), CAST(N'14:00:00' AS Time), 30, 18, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (39, 4, 3, CAST(N'2020-12-04' AS Date), CAST(N'15:00:00' AS Time), 31, 19, 1, 1, 1, 1, N'Çevrimiçi', N'45 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (40, 4, 3, CAST(N'2020-12-04' AS Date), CAST(N'16:00:00' AS Time), 32, 20, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (41, 4, 3, CAST(N'2020-12-04' AS Date), CAST(N'18:00:00' AS Time), 33, 21, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (42, 4, 3, CAST(N'2020-12-05' AS Date), CAST(N'09:00:00' AS Time), 34, 22, 1, 1, 1, 1, N'Ödev', N'** dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (43, 4, 3, CAST(N'2020-12-05' AS Date), CAST(N'14:00:00' AS Time), 35, 23, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (44, 5, 3, CAST(N'2020-11-30' AS Date), CAST(N'13:00:00' AS Time), 36, 16, 0, 0, 1, 0, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (45, 5, 3, CAST(N'2020-12-01' AS Date), CAST(N'10:00:00' AS Time), 37, 24, 1, 0, 0, 0, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (46, 5, 3, CAST(N'2020-12-01' AS Date), CAST(N'11:00:00' AS Time), 38, 25, 1, 0, 0, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (47, 5, 3, CAST(N'2020-12-01' AS Date), CAST(N'12:00:00' AS Time), 39, 24, 1, 0, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (48, 5, 3, CAST(N'2020-12-01' AS Date), CAST(N'13:00:00' AS Time), 40, 26, 1, 0, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (49, 5, 3, CAST(N'2020-12-01' AS Date), CAST(N'14:00:00' AS Time), 41, 27, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (50, 5, 3, CAST(N'2020-12-02' AS Date), CAST(N'11:00:00' AS Time), 42, 28, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (51, 5, 3, CAST(N'2020-12-02' AS Date), CAST(N'12:00:00' AS Time), 43, 28, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (52, 5, 3, CAST(N'2020-12-02' AS Date), CAST(N'13:00:00' AS Time), 44, 28, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (53, 5, 3, CAST(N'2020-12-02' AS Date), CAST(N'14:30:00' AS Time), 45, 21, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (54, 5, 3, CAST(N'2020-12-02' AS Date), CAST(N'16:00:00' AS Time), 46, 25, 1, 1, 1, 1, N'Çevrimiçi', N'45 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (55, 5, 3, CAST(N'2020-12-03' AS Date), CAST(N'10:00:00' AS Time), 47, 25, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (56, 5, 3, CAST(N'2020-12-03' AS Date), CAST(N'11:00:00' AS Time), 48, 29, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (57, 5, 3, CAST(N'2020-12-03' AS Date), CAST(N'12:00:00' AS Time), 49, 30, 1, 1, 1, 1, N'Çevrimiçi', N'75 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (58, 5, 3, CAST(N'2020-12-03' AS Date), CAST(N'13:30:00' AS Time), 56, 16, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (59, 5, 3, CAST(N'2020-12-03' AS Date), CAST(N'14:30:00' AS Time), 50, 16, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (60, 5, 3, CAST(N'2020-12-03' AS Date), CAST(N'16:00:00' AS Time), 51, 30, 1, 1, 1, 1, N'Çevrimiçi', N'75 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (61, 5, 3, CAST(N'2020-12-04' AS Date), CAST(N'10:00:00' AS Time), 52, 21, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (62, 5, 3, CAST(N'2020-12-04' AS Date), CAST(N'11:00:00' AS Time), 53, 31, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (63, 5, 3, CAST(N'2020-12-04' AS Date), CAST(N'12:00:00' AS Time), 54, 21, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (64, 5, 3, CAST(N'2020-12-04' AS Date), CAST(N'14:00:00' AS Time), 55, 18, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (65, 5, 3, CAST(N'2020-12-04' AS Date), CAST(N'15:00:00' AS Time), 57, 31, 1, 1, 1, 1, N'Çevrimiçi', N'45 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (66, 5, 3, CAST(N'2020-12-04' AS Date), CAST(N'16:00:00' AS Time), 58, 20, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (67, 5, 3, CAST(N'2020-12-04' AS Date), CAST(N'18:00:00' AS Time), 59, 21, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (68, 5, 3, CAST(N'2020-12-05' AS Date), CAST(N'14:00:00' AS Time), 60, 23, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (69, 5, 3, CAST(N'2020-12-05' AS Date), CAST(N'21:00:00' AS Time), 61, 27, 1, 1, 1, 1, N'Ödev', N'1 Gün*', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (70, 5, 3, CAST(N'2020-12-06' AS Date), CAST(N'19:00:00' AS Time), 62, 31, 1, 1, 1, 1, N'Ödev', N'1 Gün*', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (71, 5, 3, CAST(N'2020-12-06' AS Date), CAST(N'20:00:00' AS Time), 63, 24, 1, 1, 1, 1, N'Ödev', N'1 Gün*', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (72, 5, 3, CAST(N'2020-12-06' AS Date), CAST(N'21:00:00' AS Time), 64, 24, 1, 1, 1, 1, N'Ödev', N'1 Gün*', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (133, 6, 3, CAST(N'2020-11-30' AS Date), CAST(N'08:30:00' AS Time), 65, 32, 0, 1, 0, 0, N'Ödev', N'23:59', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (134, 6, 3, CAST(N'2020-11-30' AS Date), CAST(N'08:30:00' AS Time), 66, 32, 0, 1, 0, 0, N'Ödev', N'- 23:59', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (135, 6, 3, CAST(N'2020-11-30' AS Date), CAST(N'08:30:00' AS Time), 67, 32, 0, 1, 0, 1, N'Ödev', N'- 23:59', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (136, 6, 3, CAST(N'2020-11-30' AS Date), CAST(N'10:00:00' AS Time), 68, 33, 0, 1, 1, 1, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (137, 6, 3, CAST(N'2020-11-30' AS Date), CAST(N'14:00:00' AS Time), 69, 33, 0, 0, 0, 1, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (138, 6, 3, CAST(N'2020-12-01' AS Date), CAST(N'09:00:00' AS Time), 70, 34, 1, 0, 0, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (139, 6, 3, CAST(N'2020-12-01' AS Date), CAST(N'09:00:00' AS Time), 71, 34, 1, 0, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (140, 6, 3, CAST(N'2020-12-01' AS Date), CAST(N'09:00:00' AS Time), 72, 34, 1, 0, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (141, 6, 3, CAST(N'2020-12-01' AS Date), CAST(N'10:00:00' AS Time), 73, 35, 1, 1, 1, 1, N'Ödev', N'- 13:00 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (142, 6, 3, CAST(N'2020-12-02' AS Date), CAST(N'08:30:00' AS Time), 74, 36, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (143, 6, 3, CAST(N'2020-12-02' AS Date), CAST(N'09:00:00' AS Time), 75, 37, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (144, 6, 3, CAST(N'2020-12-02' AS Date), CAST(N'09:00:00' AS Time), 76, 37, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (145, 6, 3, CAST(N'2020-12-02' AS Date), CAST(N'12:00:00' AS Time), 77, 38, 1, 1, 1, 1, N'Çevrimiçi', N'120 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (146, 6, 3, CAST(N'2020-12-02' AS Date), CAST(N'15:00:00' AS Time), 78, 39, 1, 1, 1, 1, N'Çevrimiçi', N'90 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (147, 6, 3, CAST(N'2020-12-02' AS Date), CAST(N'15:00:00' AS Time), 79, 40, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (148, 6, 3, CAST(N'2020-12-03' AS Date), CAST(N'10:00:00' AS Time), 80, 41, 1, 1, 1, 1, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (149, 6, 3, CAST(N'2020-12-03' AS Date), CAST(N'12:00:00' AS Time), 81, 15, 1, 1, 1, 1, N'Ödev', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (150, 6, 3, CAST(N'2020-12-03' AS Date), CAST(N'13:30:00' AS Time), 82, 43, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (151, 6, 3, CAST(N'2020-12-03' AS Date), CAST(N'14:30:00' AS Time), 83, 43, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (152, 6, 3, CAST(N'2020-12-03' AS Date), CAST(N'15:00:00' AS Time), 84, 40, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (153, 6, 3, CAST(N'2020-12-03' AS Date), CAST(N'16:00:00' AS Time), 85, 33, 1, 1, 1, 1, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (154, 6, 3, CAST(N'2020-12-03' AS Date), CAST(N'17:30:00' AS Time), 86, 44, 1, 1, 1, 1, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (155, 6, 3, CAST(N'2020-12-04' AS Date), CAST(N'09:00:00' AS Time), 87, 38, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (156, 6, 3, CAST(N'2020-12-04' AS Date), CAST(N'10:00:00' AS Time), 88, 45, 1, 1, 1, 1, N'Çevrimiçi', N'20 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (157, 6, 3, CAST(N'2020-12-04' AS Date), CAST(N'14:00:00' AS Time), 89, 18, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (158, 6, 3, CAST(N'2020-12-04' AS Date), CAST(N'15:00:00' AS Time), 90, 20, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (159, 6, 3, CAST(N'2020-12-04' AS Date), CAST(N'18:00:00' AS Time), 91, 21, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (160, 6, 3, CAST(N'2020-12-05' AS Date), CAST(N'09:00:00' AS Time), 92, 37, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (161, 6, 3, CAST(N'2020-12-06' AS Date), CAST(N'09:00:00' AS Time), 93, 37, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (162, 6, 3, CAST(N'2020-12-06' AS Date), CAST(N'09:00:00' AS Time), 94, 37, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (163, 7, 3, CAST(N'2020-11-30' AS Date), CAST(N'10:30:00' AS Time), 95, 46, 1, 0, 0, 0, N'Ödev', N'- 12:30 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (164, 7, 3, CAST(N'2020-11-30' AS Date), CAST(N'11:00:00' AS Time), 96, 47, 1, 0, 1, 0, N'Ödev', N'- 12:00 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (165, 7, 3, CAST(N'2020-11-30' AS Date), CAST(N'14:00:00' AS Time), 97, 48, 1, 0, 1, 1, N'Ödev', N'- 16:00 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (166, 7, 3, CAST(N'2020-12-01' AS Date), CAST(N'11:00:00' AS Time), 98, 49, 1, 1, 1, 1, N'Çevrimiçi', N'50 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (167, 7, 3, CAST(N'2020-12-01' AS Date), CAST(N'13:00:00' AS Time), 99, 26, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (168, 7, 3, CAST(N'2020-12-01' AS Date), CAST(N'14:00:00' AS Time), 100, 49, 1, 1, 1, 1, N'Çevrimiçi', N'90 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (169, 7, 3, CAST(N'2020-12-01' AS Date), CAST(N'16:00:00' AS Time), 101, 51, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (170, 7, 3, CAST(N'2020-12-01' AS Date), CAST(N'18:00:00' AS Time), 102, 51, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (171, 7, 3, CAST(N'2020-12-02' AS Date), CAST(N'08:30:00' AS Time), 103, 36, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (172, 7, 3, CAST(N'2020-12-02' AS Date), CAST(N'11:00:00' AS Time), 104, 51, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
GO
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (173, 7, 3, CAST(N'2020-12-02' AS Date), CAST(N'13:00:00' AS Time), 105, 49, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (174, 7, 3, CAST(N'2020-12-02' AS Date), CAST(N'15:00:00' AS Time), 106, 49, 1, 1, 1, 1, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (175, 7, 3, CAST(N'2020-12-03' AS Date), CAST(N'08:30:00' AS Time), 107, 53, 1, 1, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (176, 7, 3, CAST(N'2020-12-03' AS Date), CAST(N'12:30:00' AS Time), 108, 51, 1, 1, 1, 1, N'Çevrimiçi', N'50 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (177, 7, 3, CAST(N'2020-12-03' AS Date), CAST(N'13:30:00' AS Time), 109, 43, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (178, 7, 3, CAST(N'2020-12-03' AS Date), CAST(N'14:30:00' AS Time), 110, 43, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (179, 7, 3, CAST(N'2020-12-03' AS Date), CAST(N'15:30:00' AS Time), 111, 49, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (180, 7, 3, CAST(N'2020-12-04' AS Date), CAST(N'11:00:00' AS Time), 112, 47, 1, 1, 1, 1, N'Ödev', N'- 12:00 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (181, 7, 3, CAST(N'2020-12-04' AS Date), CAST(N'13:00:00' AS Time), 113, 51, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (182, 7, 3, CAST(N'2020-12-04' AS Date), CAST(N'14:00:00' AS Time), 114, 18, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (183, 7, 3, CAST(N'2020-12-04' AS Date), CAST(N'15:00:00' AS Time), 115, 55, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (184, 7, 3, CAST(N'2020-12-04' AS Date), CAST(N'16:00:00' AS Time), 116, 20, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (185, 7, 3, CAST(N'2020-12-04' AS Date), CAST(N'18:00:00' AS Time), 117, 21, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (186, 7, 3, CAST(N'2020-12-05' AS Date), CAST(N'13:00:00' AS Time), 118, 51, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (187, 7, 3, CAST(N'2020-12-05' AS Date), CAST(N'14:00:00' AS Time), 119, 23, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (188, 7, 3, CAST(N'2020-12-05' AS Date), CAST(N'14:00:00' AS Time), 120, 48, 1, 1, 1, 1, N'Ödev', N'- 16:00 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (189, 7, 3, CAST(N'2020-12-05' AS Date), CAST(N'15:00:00' AS Time), 121, 47, 1, 1, 1, 1, N'Ödev', N'- 16:00 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (190, 7, 3, CAST(N'2020-12-05' AS Date), CAST(N'16:00:00' AS Time), 122, 51, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (191, 7, 3, CAST(N'2020-12-06' AS Date), CAST(N'14:00:00' AS Time), 123, 49, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (192, 7, 3, CAST(N'2020-12-06' AS Date), CAST(N'15:00:00' AS Time), 124, 55, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (193, 7, 3, CAST(N'2020-12-06' AS Date), CAST(N'17:30:00' AS Time), 125, 55, 1, 1, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (194, 7, 3, CAST(N'2020-12-06' AS Date), CAST(N'17:30:00' AS Time), 126, 56, 1, 1, 1, 1, N'Ödev', N'- 17:30 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (198, 8, 3, CAST(N'2020-12-02' AS Date), CAST(N'09:00:00' AS Time), 127, 57, 1, 0, 0, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (199, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'09:00:00' AS Time), 128, 57, 1, 0, 0, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (200, 8, 3, CAST(N'2020-12-01' AS Date), CAST(N'15:30:00' AS Time), 129, 57, 1, 0, 0, 0, N'Çevrimiçi', N'20 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (201, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'10:00:00' AS Time), 130, 57, 1, 0, 0, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (202, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'09:00:00' AS Time), 131, 57, 1, 0, 0, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (203, 8, 3, CAST(N'2020-12-03' AS Date), CAST(N'13:30:00' AS Time), 132, 57, 1, 0, 0, 0, N'Çevrimiçi', N'40 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (204, 8, 3, CAST(N'2020-12-04' AS Date), CAST(N'14:00:00' AS Time), 133, 57, 1, 0, 0, 0, N'Çevrimiçi', N'22 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (205, 8, 3, CAST(N'2020-12-04' AS Date), CAST(N'14:00:00' AS Time), 134, 57, 1, 0, 0, 0, N'Çevrimiçi', N'22 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (206, 8, 3, CAST(N'2020-12-04' AS Date), CAST(N'16:00:00' AS Time), 135, 57, 1, 0, 0, 0, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (207, 8, 3, CAST(N'2020-12-05' AS Date), CAST(N'14:00:00' AS Time), 136, 57, 1, 0, 0, 0, N'Çevrimiçi', N'30 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (208, 8, 3, CAST(N'2020-12-01' AS Date), CAST(N'13:30:00' AS Time), 137, 57, 1, 1, 0, 0, N'Ödev', N'- 160:30 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (209, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'14:00:00' AS Time), 138, 57, 1, 1, 0, 0, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (210, 8, 3, CAST(N'2020-12-02' AS Date), CAST(N'13:00:00' AS Time), 139, 57, 1, 1, 0, 0, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (211, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'09:00:00' AS Time), 140, 57, 0, 1, 0, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (212, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'09:00:00' AS Time), 141, 57, 0, 1, 0, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (213, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'10:00:00' AS Time), 142, 57, 0, 1, 0, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (214, 8, 3, CAST(N'2020-12-01' AS Date), CAST(N'10:00:00' AS Time), 143, 57, 0, 1, 0, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (215, 8, 3, CAST(N'2020-12-01' AS Date), CAST(N'11:00:00' AS Time), 144, 57, 0, 1, 1, 0, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (216, 8, 3, CAST(N'2020-12-02' AS Date), CAST(N'12:00:00' AS Time), 145, 57, 0, 1, 1, 0, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (217, 8, 3, CAST(N'2020-12-01' AS Date), CAST(N'09:00:00' AS Time), 146, 57, 0, 1, 1, 0, N'Ödev', N'- 23:59', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (218, 8, 3, CAST(N'2020-12-02' AS Date), CAST(N'10:00:00' AS Time), 147, 57, 0, 1, 1, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (219, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'10:00:00' AS Time), 149, 57, 0, 0, 1, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (220, 8, 3, CAST(N'2020-12-02' AS Date), CAST(N'09:00:00' AS Time), 150, 57, 0, 0, 1, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (221, 8, 3, CAST(N'2020-12-02' AS Date), CAST(N'11:00:00' AS Time), 151, 57, 0, 0, 1, 0, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (222, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'10:00:00' AS Time), 152, 57, 0, 0, 1, 1, N'Ödev', N'- 23:59 ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (223, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'00:00:00' AS Time), 153, 57, 0, 0, 1, 1, N'Ödev', N'- ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (224, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'13:00:00' AS Time), 154, 57, 0, 0, 1, 1, N'Çevrimiçi', N'60 dk', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (225, 8, 3, CAST(N'2020-11-30' AS Date), CAST(N'09:00:00' AS Time), 155, 57, 0, 0, 1, 1, N'Ödev', N'- 23:59', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (226, 8, 3, CAST(N'2020-12-01' AS Date), CAST(N'09:00:00' AS Time), 156, 57, 0, 0, 1, 1, N'Ödev', N'- 23:59', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (227, 8, 3, CAST(N'2020-12-02' AS Date), CAST(N'09:00:00' AS Time), 157, 57, 0, 0, 1, 1, N'Ödev', N'- 23:59', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (228, 8, 3, CAST(N'2020-12-02' AS Date), CAST(N'00:00:00' AS Time), 158, 57, 0, 0, 1, 1, N'Ödev', N'- ', N'Ara Sınav')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (232, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'10:30:00' AS Time), 37, 24, 1, 0, 0, 0, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (233, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'11:30:00' AS Time), 38, 25, 1, 0, 0, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (234, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'14:00:00' AS Time), 56, 16, 1, 0, 0, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (235, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'14:00:00' AS Time), 50, 16, 1, 1, 0, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (236, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'14:00:00' AS Time), 36, 16, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (237, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'15:30:00' AS Time), 42, 28, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (238, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'16:30:00' AS Time), 43, 28, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (239, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'17:30:00' AS Time), 44, 28, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (240, 5, 3, CAST(N'2020-12-22' AS Date), CAST(N'20:00:00' AS Time), 61, 27, 1, 1, 1, 1, N'Ödev', N'- 21:00', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (241, 5, 3, CAST(N'2020-12-23' AS Date), CAST(N'13:30:00' AS Time), 40, 26, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (242, 5, 3, CAST(N'2020-12-23' AS Date), CAST(N'16:00:00' AS Time), 46, 25, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (243, 5, 3, CAST(N'2020-12-23' AS Date), CAST(N'17:30:00' AS Time), 52, 21, 1, 1, 1, 1, N'Ödev', N'- 17:30', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (244, 5, 3, CAST(N'2020-12-23' AS Date), CAST(N'18:00:00' AS Time), 45, 21, 1, 1, 1, 1, N'Ödev', N'- 18:00', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (245, 5, 3, CAST(N'2020-12-24' AS Date), CAST(N'10:00:00' AS Time), 47, 25, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (246, 5, 3, CAST(N'2020-12-24' AS Date), CAST(N'11:00:00' AS Time), 49, 25, 1, 1, 1, 1, N'Çevrimiçi', N'75 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (247, 5, 3, CAST(N'2020-12-24' AS Date), CAST(N'13:00:00' AS Time), 48, 29, 1, 1, 1, 1, N'Çevrimiçi', N'50 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (248, 5, 3, CAST(N'2020-12-24' AS Date), CAST(N'14:00:00' AS Time), 51, 30, 1, 1, 1, 1, N'Çevrimiçi', N'75 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (249, 5, 3, CAST(N'2020-12-24' AS Date), CAST(N'19:00:00' AS Time), 57, 31, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (250, 5, 3, CAST(N'2020-12-24' AS Date), CAST(N'21:00:00' AS Time), 62, 31, 1, 1, 1, 1, N'Ödev', N'- 21:00', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (251, 5, 3, CAST(N'2020-12-24' AS Date), CAST(N'21:00:00' AS Time), 53, 31, 1, 1, 1, 1, N'Ödev', N'- 21:00', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (252, 5, 3, CAST(N'2020-12-25' AS Date), CAST(N'10:00:00' AS Time), 39, 24, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (254, 5, 3, CAST(N'2020-12-25' AS Date), CAST(N'11:00:00' AS Time), 41, 27, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (255, 5, 3, CAST(N'2020-12-25' AS Date), CAST(N'14:00:00' AS Time), 55, 18, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (256, 5, 3, CAST(N'2020-12-25' AS Date), CAST(N'16:00:00' AS Time), 58, 20, 1, 1, 1, 1, N'Çevrimiçi', N'22 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (257, 5, 3, CAST(N'2020-12-25' AS Date), CAST(N'17:30:00' AS Time), 54, 21, 1, 1, 1, 1, N'Ödev', N'- 17:30', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (258, 5, 3, CAST(N'2020-12-25' AS Date), CAST(N'18:00:00' AS Time), 59, 21, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (259, 5, 3, CAST(N'2020-12-25' AS Date), CAST(N'21:00:00' AS Time), 64, 24, 1, 1, 1, 1, N'Ödev', N'- 21:00', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (260, 5, 3, CAST(N'2020-12-26' AS Date), CAST(N'14:00:00' AS Time), 60, 23, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (261, 8, 3, CAST(N'2020-12-21' AS Date), CAST(N'09:30:00' AS Time), 144, 58, 0, 0, 1, 0, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (262, 8, 3, CAST(N'2020-12-21' AS Date), CAST(N'10:00:00' AS Time), 128, 59, 1, 0, 0, 0, N'Ödev', N'120 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (263, 8, 3, CAST(N'2020-12-21' AS Date), CAST(N'11:00:00' AS Time), 155, 2, 1, 0, 0, 1, N'Ödev', N'2 gün ', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (264, 8, 3, CAST(N'2020-12-21' AS Date), CAST(N'12:00:00' AS Time), 140, 64, 0, 1, 0, 0, N'Ödev', N'5 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (265, 8, 3, CAST(N'2020-12-21' AS Date), CAST(N'13:00:00' AS Time), 143, 64, 0, 1, 0, 0, N'Ödev', N'5 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (267, 8, 3, CAST(N'2020-12-21' AS Date), CAST(N'14:00:00' AS Time), 147, 64, 0, 1, 1, 0, N'Ödev', N'5 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (268, 8, 3, CAST(N'2020-12-21' AS Date), CAST(N'17:00:00' AS Time), 137, 35, 0, 1, 1, 0, N'Ödev', N'3 saat', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (269, 8, 3, CAST(N'2020-12-22' AS Date), CAST(N'09:00:00' AS Time), 142, 65, 0, 1, 0, 0, N'Ödev', N'2 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (270, 8, 3, CAST(N'2020-12-22' AS Date), CAST(N'10:00:00' AS Time), 139, 61, 0, 1, 0, 0, N'Çevrimiçi', N'1 saat', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (271, 8, 3, CAST(N'2020-12-22' AS Date), CAST(N'11:00:00' AS Time), 128, 65, 1, 1, 0, 0, N'Ödev', N'2 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (272, 8, 3, CAST(N'2020-12-22' AS Date), CAST(N'12:00:00' AS Time), 146, 62, 1, 1, 1, 0, N'Ödev', N'4 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (273, 8, 3, CAST(N'2020-12-22' AS Date), CAST(N'13:00:00' AS Time), 151, 64, 1, 1, 1, 0, N'Ödev', N'5 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (274, 8, 3, CAST(N'2020-12-22' AS Date), CAST(N'14:00:00' AS Time), 154, 61, 1, 1, 1, 1, N'Çevrimiçi', N'1 saat', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (275, 8, 3, CAST(N'2020-12-22' AS Date), CAST(N'15:00:00' AS Time), 157, 64, 1, 1, 1, 1, N'Çevrimiçi', N'30 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (276, 8, 3, CAST(N'2020-12-22' AS Date), CAST(N'17:00:00' AS Time), 129, 63, 1, 1, 1, 1, N'Çevrimiçi', N'30', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (277, 8, 3, CAST(N'2020-12-23' AS Date), CAST(N'09:30:00' AS Time), 145, 58, 1, 1, 1, 1, N'Çevrimiçi', N'30', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (278, 8, 3, CAST(N'2020-12-23' AS Date), CAST(N'10:30:00' AS Time), 130, 4, 1, 1, 1, 1, N'Ödev', N'2.5 saat', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (279, 8, 3, CAST(N'2020-12-23' AS Date), CAST(N'11:00:00' AS Time), 150, 62, 1, 1, 1, 1, N'Ödev', N'4 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1165, 8, 3, CAST(N'2020-12-23' AS Date), CAST(N'12:00:00' AS Time), 149, 1057, 0, 0, 1, 0, N'Ödev', N'4 gün', N'Ara Sınav Mazeret')
GO
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1166, 8, 3, CAST(N'2020-12-23' AS Date), CAST(N'13:00:00' AS Time), 127, 61, 1, 0, 1, 0, N'Ödev', N'12 saat', N'Vize')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1167, 8, 3, CAST(N'2020-12-23' AS Date), CAST(N'14:00:00' AS Time), 158, 22, 1, 0, 1, 1, N'Ödev', N'3 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1168, 8, 3, CAST(N'2020-12-24' AS Date), CAST(N'13:30:00' AS Time), 132, 43, 1, 0, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1169, 8, 3, CAST(N'2020-12-24' AS Date), CAST(N'11:00:00' AS Time), 135, 62, 1, 0, 1, 1, N'Ödev', N'3 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1170, 8, 3, CAST(N'2020-12-24' AS Date), CAST(N'13:30:00' AS Time), 132, 43, 1, 0, 1, 1, N'Çevrimiçi', N'40 dk', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1171, 8, 3, CAST(N'2020-12-24' AS Date), CAST(N'14:30:00' AS Time), 156, 62, 1, 0, 1, 1, N'Ödev', N'3 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1172, 8, 3, CAST(N'2020-12-24' AS Date), CAST(N'15:00:00' AS Time), 141, 1057, 1, 0, 1, 1, N'Ödev', N'3 gün', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1173, 8, 3, CAST(N'2020-12-25' AS Date), CAST(N'14:00:00' AS Time), 134, 18, 1, 0, 1, 1, N'Çevrimiçi', N'22', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1174, 8, 3, CAST(N'2020-12-25' AS Date), CAST(N'16:00:00' AS Time), 133, 20, 1, 0, 1, 1, N'Çevrimiçi', N'22', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1175, 8, 3, CAST(N'2020-12-25' AS Date), CAST(N'18:00:00' AS Time), 135, 21, 1, 0, 1, 1, N'Çevrimiçi', N'30', N'Ara Sınav Mazeret')
INSERT [dbo].[sinav] ([Id], [bolum_Id], [donem_Id], [sinav_tarihi], [sinav_saati], [ders_Id], [ogretim_uyesi_Id], [birinci_sinif], [ikinci_sinif], [ucuncu_sinif], [dorduncu_sinif], [sinav_turu], [sinav_suresi], [sinav_sekli]) VALUES (1176, 8, 3, CAST(N'2020-12-26' AS Date), CAST(N'14:00:00' AS Time), 136, 23, 1, 0, 1, 1, N'Çevrimiçi', N'30', N'Ara Sınav Mazeret')
SET IDENTITY_INSERT [dbo].[sinav] OFF
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
/****** Object:  StoredProcedure [dbo].[bolum_Ekle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[bolum_Guncelle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[ders_Ekle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[ders_Guncelle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[donem_Ekle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[donem_Guncelle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[fakulte_Ekle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[fakulte_Guncelle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[ogretim_uyesi_Ekle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[ogretim_uyesi_Guncelle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[sinav_Ekle]    Script Date: 17.01.2021 11:03:21 ******/
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
/****** Object:  StoredProcedure [dbo].[sinav_Guncelle]    Script Date: 17.01.2021 11:03:21 ******/
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
