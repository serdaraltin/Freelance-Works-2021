USE [master]
GO

CREATE DATABASE [udemy]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'udemy', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\udemy.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'udemy_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\udemy_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [udemy] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [udemy].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [udemy] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [udemy] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [udemy] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [udemy] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [udemy] SET ARITHABORT OFF 
GO
ALTER DATABASE [udemy] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [udemy] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [udemy] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [udemy] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [udemy] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [udemy] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [udemy] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [udemy] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [udemy] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [udemy] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [udemy] SET  DISABLE_BROKER 
GO
ALTER DATABASE [udemy] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [udemy] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [udemy] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [udemy] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [udemy] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [udemy] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [udemy] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [udemy] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [udemy] SET  MULTI_USER 
GO
ALTER DATABASE [udemy] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [udemy] SET DB_CHAINING OFF 
GO
ALTER DATABASE [udemy] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [udemy] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [udemy]
GO
/****** Object:  Table [dbo].[ders]    Script Date: 27.04.2021 13:04:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ders](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[egitimId] [int] NULL,
	[baslik] [varchar](100) NULL,
	[url] [text] NULL,
 CONSTRAINT [PK_ders] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[durum]    Script Date: 27.04.2021 13:04:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[durum](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kullaniciId] [int] NULL,
	[dersId] [int] NULL,
	[tamamlanma] [tinyint] NULL,
	[tarih] [date] NULL,
 CONSTRAINT [PK_durum] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[egitim]    Script Date: 27.04.2021 13:04:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[egitim](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kullaniciId] [int] NULL,
	[kategoriId] [int] NULL,
	[baslik] [varchar](100) NULL,
	[aciklama] [text] NULL,
 CONSTRAINT [PK_egitim] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kategori]    Script Date: 27.04.2021 13:04:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[kategori](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [varchar](50) NULL,
 CONSTRAINT [PK_kategori] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kullanici]    Script Date: 27.04.2021 13:04:56 ******/
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
	[ad] [varchar](50) NULL,
	[soyad] [varchar](50) NULL,
	[cinsiyet] [varchar](5) NULL,
	[dogumTarih] [date] NULL,
	[telNo] [varchar](12) NULL,
	[email] [varchar](100) NULL,
 CONSTRAINT [PK_kullanici] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[satinAlim]    Script Date: 27.04.2021 13:04:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[satinAlim](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[kullaniciId] [int] NULL,
	[egitimId] [int] NULL,
	[ucret] [float] NULL,
	[tarih] [date] NULL,
 CONSTRAINT [PK_satinAlim] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[ders] ON 

INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (1, 1, N'Yazılım Nedir ?', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (2, 1, N'Programlama Nedir ?
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (3, 1, N'Programlama Mantığını Anlamak
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (4, 1, N'Temel Değişken Yapısını Anlamak
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (5, 3, N'Java Temelleri Giriş
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (6, 3, N'Değişkenler', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (7, 3, N'Diziler', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (8, 3, N'Listeler', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (9, 2, N'Html Yapısı', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (10, 2, N'Başlık Etiketleri', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (11, 2, N'Forms', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (12, 2, N'Div & Span', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (13, 4, N'String Fonksiyonlar - Len Fonksiyonu
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (14, 5, N'Amazon FBA Yol Haritası
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (15, 6, N'Bireysel mi Kurumsal mı?
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (16, 7, N'Özgüven', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (17, 8, N'Fizibilite: Sayısal Analiz nasıl yapılır?
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (18, 9, N'Yapay Zekaya Transfer Oluyoruz!
', N'-')
INSERT [dbo].[ders] ([Id], [egitimId], [baslik], [url]) VALUES (19, 10, N'Temel Akor ve Ritimler - Metot 1 Bölüm 2', N'-')
SET IDENTITY_INSERT [dbo].[ders] OFF
SET IDENTITY_INSERT [dbo].[egitim] ON 

INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (1, 1, 1, N'Python | Sıfırdan İleri Seviye Programlama', N'Sıfırdan İleri Seviyeye Python ve Programlama öğrenmenin tadını çıkarın.

Bu kursta sıfırdan Python ve programlamanın temellerini öğrenerek , ileri seviyelere kadar Python''ın tüm güzelliklerini beraber görmeye başlayacağız. Eğer programlama hakkında hiçbir fikriniz yoksa bu kurs tam size göre!')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (2, 2, 1, N'Komple Uygulamalı Web Geliştirme Eğitimi', N'Yayınlandığı tarihten beri Udemy''nin en iyi 3 kursu içerisinde en yüksek değerlendirme oranına sahip olduğumuzu bilmenizi isterim. Bu başarının nedeni şüphesiz ki; sürekli güncel kalan bir kurs olmamız ve web geliştirme alanıyla alakalı en önemli ve en gerekli konuları sadece bir kursta yalın ve net bir şekilde öğreniyor olmanızdır.

Kursumuzdaki konu başlıkları sırasıyla; Html, Css, Sass & Scss, Flexbox, Javascript, Angular, Bootstrap, JQuery ve Asp.Net Core Mvc konu başlıklarıdır.

')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (3, 3, 1, N'Android Mobil Uygulama Kursu: Kotlin & Java', N'Android için Mobil Uygulama yazmayı sıfırdan ileri seviyeye kadar öğrenmek istiyorsanız bu kurs tam size göre!

Android geliştirmeyi son teknoloji ile öğreneceksiniz: Android + Java + Kotlin.

Google Android geliştirme için Java haricinde Kotlin''i de destekleyeceğini açıkladı. Daha da ötesi Kotlin''i birinci dil tercihi olarak belirtti. Dört dörtlük bir yazılımcı olmak istiyorsanız iki dili de öğrenmek için doğru yerdesiniz.')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (4, 4, 1, N'Aranan Programcı Olma Kamp Kursu| Python,Java,C#', N'Güncelleme (19 Kasım 2020) : Programlamaya giriş bölümleri en güncel haliyle sıfırdan çekildi.

Güncelleme (20 Kasım 2020) : 8 adet yeni ödev eklendi.

Programlamaya sıfırdan başlamak istiyor fakat nereden başlayacağınızı bilmiyorsanız,

Bir programlama teknolojisini öğrenirken, aniden diğerine geçtiğinizi görüyorsanız,

Sektörde aranan programcı olmak için temellerinizi sapasağlam yapmak istiyorsanız,

Şu an doğru kursu inceliyorsunuz.')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (5, 5, 2, N'Amazon FBA Eğitimi ', N'UDEMY PLATFORMUNDAKİ EN ÇOK İZLENEN (11.000 + ÖĞRENCİ) VE EN KAPSAMLI ( 30 SAAT ) TÜRKÇE "AMAZON FBA" KURSU



AMAZON''DA E-TİCARET İLE PARA KAZANARAK GİRİŞİMCİLİK DÜNYASINA ADIM ATMAK İSTİYORSANIZ BU KURS TAM SİZİN İÇİN

Herhangi bir ön bilgi olmadan yani sıfırdan Amazon FBA yaparak nasıl para kazanacağınızı öğreneceğiniz bu kursta sizleri çok geniş bir içerik bekliyor.')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (6, 6, 2, N'Amazon Satıcı FBA ve Dropshipping Eğitimi ', N'YENİ ÖZELLİK: HER SALI VE PERŞEMBE SAAT 17:00''DE BU KURSU SATIN ALANLARA ÖZEL CANLI YAYINDA BİREBİR TÜM SORULARINI YANITLIYORUZ, ONLARA YARDIMCI OLUYORUZ. UDEMY''NİN İLK VE TEK YAŞAYAN VE HER GÜN GÜNCELLENEN TEK KURSU!')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (7, 7, 2, N'Satış Eğitimi: A''dan Z''ye Bilmeniz Gerekenler', N'Satış Eğitim Setine hoşgeldiniz. Öncelikle güzel haber, eğitim setinin 1-2 değil bir çok videosu tamamen ücretsiz izlemeniz için açıktır. Dolayısı ile vaatlerimize değil, tecrübenize açık bu eğitim.')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (8, 8, 2, N'Ticaret Tecrübeleri: İşyeri Devralmak, Franchise Almak', N'Bu eğitimin amacı: Sizin doğru yatırmı farkedebilmenizi ve bir  yatırımda dışardan bakınca görünmeyen riskleri görebilmenizi sağlamaktır. Bu nedenle bu eğitim değeri parayla ölçülemeyecek tecrübeleri ve ödenmiş bedellerden çıkarılan dersleri size sunmaktadır.

Kurulu bir işyerini devralmak veya bir firmadan bayilik almak ticari hayata girmenin en hızlı yolu.  Bu hızlı yolda giderken yoldaki ışıkları ve virajları görebilmek ancak tecrübe ile elde edilebiliyor. Aksi takdirde bu yolu tercih eden insanların para kazanma isteğini suistmal eden ticari teroristlerin dürüst insanları aldattığına pek çok kez şahit olduk.')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (9, 9, 2, N'Yapay Zeka ve Dijital Dönüşüm', N'Yapay Zeka ve Dijital Dönüşüm

İş Dünyasında Dijital Dönüşüm Süreçleri ve Yapay Zeka Etkisi

Çağımızın en yaygın kullanılan teknoloji terimlerinden bir tanesi “YAPAY ZEKA ve İŞ üzerine konuşacağımız bu eğitimde, Dijital Dönüşüm ve Yapay Zeka başlığına uygun olarak “İŞ DÜNYASINDA YAPAY ZEKANIN DURUMU” hakkında detaylara değineceğiz.')
INSERT [dbo].[egitim] ([Id], [kullaniciId], [kategoriId], [baslik], [aciklama]) VALUES (10, 10, 12, N'Selim Işık ile Gitar Dersleri', N'-Doğaçlama gitar çalma, beste yapma ve müzik teorisi konusunda yetkinlik kazanacaksınız.



-Selim Işık Gitar Metodu 1. ve 2. kitapta anlatılan tüm konuları bu kursta bulacaksınız.

-Bu kursta, Selim Işık''ın 25 yıllık gitar eğitimini aktardığı 1. Ve 2. Gitar Metodu kitaplarında anlatılan tüm konuları bulacaksınız.')
SET IDENTITY_INSERT [dbo].[egitim] OFF
SET IDENTITY_INSERT [dbo].[kategori] ON 

INSERT [dbo].[kategori] ([Id], [ad]) VALUES (1, N'Yazılım Geliştirme')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (2, N'İşletme')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (3, N'Finans ve Muhasebe')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (4, N'BT ve Yazılım')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (5, N'Ofiste Verimlilik')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (6, N'Kişisel Gelişim')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (7, N'Tasarım')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (8, N'Pazarlama')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (9, N'Yaşam Tarzı')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (10, N'Fotoğraf ve Video')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (11, N'Sağlık ve Fitness')
INSERT [dbo].[kategori] ([Id], [ad]) VALUES (12, N'Müzik')
SET IDENTITY_INSERT [dbo].[kategori] OFF
SET IDENTITY_INSERT [dbo].[kullanici] ON 

INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (1, N'mustafamurat', N'12345678', N'Mustafa Murat', N'Coşkun', N'Erkek', CAST(0x7E070B00 AS Date), N'5455454545', N'mustafac@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (2, N'sadikturan', N'12345678', N'Sadık', N'Turan', N'Erkek', CAST(0xA10E0B00 AS Date), N'5465464646', N'sadikturan85@hotmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (3, N'atilsamancioglu', N'12345678', N'Atıl', N'Samancıoğlu', N'Erkek', CAST(0xE70A0B00 AS Date), N'5428963245', N'atil@samancioglu.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (4, N'engindemirog', N'12345678', N'Engin', N'Demiroğ', N'Erkek', CAST(0xC4110B00 AS Date), N'5458963214', N'enginde@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (5, N'mehmettek', N'12345678', N'Mehmet', N'Tek', N'Erkek', CAST(0x0D1D0B00 AS Date), N'5458964578', N'mehmettek1995@hotmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (6, N'tugerakkaya', N'12345678', N'Tuger', N'Akkaya', N'Erkek', CAST(0x6E160B00 AS Date), N'5453218569', N'tugerakkaya@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (7, N'haluktatar', N'12345678', N'Haluk', N'Tatar', N'Erkek', CAST(0x21160B00 AS Date), N'5463217854', N'haluktatar@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (8, N'gokhancaliskan', N'12345678', N'Gökhan', N'Çalışkan', N'Erkek', CAST(0x95110B00 AS Date), N'5415869354', N'gokhancaliskan@hotmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (9, N'behzeryildiz', N'12345678', N'Behzer', N'Yıldız', N'Kadın', CAST(0xC1000B00 AS Date), N'5462147563', N'behzeryildiz1975@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (10, N'selimisik', N'12345678', N'Selim', N'Işık', N'Erkek', CAST(0x82130B00 AS Date), N'5435627896', N'selimisik88@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (11, N'ahmetbalaban', N'12345678', N'Ahmet', N'Balaban', N'Erkek', CAST(0x81200B00 AS Date), N'5461597532', N'ahmetbal@hotmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (12, N'selindogan', N'12345678', N'Selin', N'Doğan', N'Kadın', CAST(0x55280B00 AS Date), N'5486321745', N'selindogan03@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (13, N'ferit2005', N'12345678', N'Ferit', N'Kuş', N'Erkek', CAST(0x612C0B00 AS Date), N'5432145369', N'ferit2003@hotmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (14, N'nurkucuk', N'12345678', N'Nur', N'Küçük', N'Kadın', CAST(0xF3250B00 AS Date), N'5489621456', N'nurkucuk@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (15, N'fadimeyaren', N'12345678', N'Fadime Yaren', N'Durmuş', N'Kadın', CAST(0x74240B00 AS Date), N'5486221454', N'fadimeyaren@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (16, N'mehmetdoganay', N'12345678', N'Mehmet', N'Doğanay', N'Erkek', CAST(0x34280B00 AS Date), N'5423659871', N'mehmetdog@hotmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (17, N'yasincakir', N'12345678', N'Yasin', N'Çakır', N'Erkek', CAST(0x371F0B00 AS Date), N'5426547785', N'yasincakir@hotmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (18, N'bekiryaman', N'12345678', N'Bekir', N'Yaman', N'Erkek', CAST(0x1A250B00 AS Date), N'5426548793', N'bekiryaman@gmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (19, N'hilalkayyum', N'12345678', N'Hilal', N'Kayyum', N'Kadın', CAST(0xA91D0B00 AS Date), N'5456221453', N'hilalkayyum@hotmail.com')
INSERT [dbo].[kullanici] ([Id], [kullaniciAd], [parola], [ad], [soyad], [cinsiyet], [dogumTarih], [telNo], [email]) VALUES (20, N'serhatkeles', N'12345678', N'Serhat', N'Keleş', N'Erkek', CAST(0x9C2C0B00 AS Date), N'5426589785', N'serhat2006@gmail.com')
SET IDENTITY_INSERT [dbo].[kullanici] OFF
SET IDENTITY_INSERT [dbo].[satinAlim] ON 

INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (1, 11, 1, 49.99, CAST(0x90400B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (2, 12, 2, 27.99, CAST(0x23420B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (3, 13, 3, 69.99, CAST(0xEB410B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (4, 13, 5, 34.99, CAST(0x66400B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (5, 14, 6, 49.99, CAST(0x1D420B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (6, 15, 7, 27.99, CAST(0xEE3F0B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (7, 16, 8, 34.99, CAST(0x45410B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (8, 17, 9, 27.99, CAST(0x2E3F0B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (9, 17, 1, 69.99, CAST(0x3F420B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (10, 17, 5, 34.99, CAST(0x6D400B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (11, 18, 10, 49.99, CAST(0x67410B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (12, 19, 8, 69.99, CAST(0x38400B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (13, 20, 9, 27.99, CAST(0x66420B00 AS Date))
INSERT [dbo].[satinAlim] ([Id], [kullaniciId], [egitimId], [ucret], [tarih]) VALUES (14, 20, 2, 49.99, CAST(0xB8400B00 AS Date))
SET IDENTITY_INSERT [dbo].[satinAlim] OFF
USE [master]
GO
ALTER DATABASE [udemy] SET  READ_WRITE 
GO
