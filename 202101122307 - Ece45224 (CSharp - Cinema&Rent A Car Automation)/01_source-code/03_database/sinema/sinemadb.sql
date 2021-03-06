
USE [sinemadb]
GO
/****** Object:  Table [dbo].[bilet]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[bilet](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[musteri_tipi] [varchar](50) NULL,
	[seans_Id] [int] NULL,
	[koltuk_no] [int] NULL,
 CONSTRAINT [PK__bilet__3214EC07E98B4369] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[film]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[film](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [varchar](50) NULL,
	[kategori] [varchar](50) NULL,
	[yonetmen] [varchar](50) NULL,
	[yil] [int] NULL,
 CONSTRAINT [PK__film__3214EC070F97B297] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[kullanici]    Script Date: 12.01.2021 06:32:19 ******/
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
 CONSTRAINT [PK__kullanic__3214EC0769DC5E79] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[salon]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[salon](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ad] [varchar](50) NULL,
	[koltuk_adet] [int] NULL,
 CONSTRAINT [PK__salon__3214EC07A974A919] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[seans]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[seans](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[film_Id] [int] NULL,
	[salon_Id] [int] NULL,
	[tarih] [datetime] NULL,
 CONSTRAINT [PK__seans__3214EC0704EB881C] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  StoredProcedure [dbo].[bilet_Ekle]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[bilet_Ekle]
@musteri_tipi varchar(50),
@seans_Id int,
@koltuk_no int

As
Begin
Insert Into bilet (musteri_tipi,seans_Id,koltuk_no) Values(@musteri_tipi,@seans_Id,@koltuk_no)
End
GO
/****** Object:  StoredProcedure [dbo].[bilet_Guncelle]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[bilet_Guncelle]
@Id int,
@musteri_tipi varchar(50),
@seans_Id int,
@koltuk_no int

As
Begin
Update bilet Set musteri_tipi=@musteri_tipi,seans_Id=@seans_Id,koltuk_no=@koltuk_no
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[film_Ekle]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[film_Ekle]
@ad varchar(50),
@kategori varchar(50),
@yonetmen varchar(50),
@yil int

As
Begin
Insert Into film (ad,kategori,yonetmen,yil) Values(@ad,@kategori,@yonetmen,@yil)
End
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 12.01.2021 06:32:19 ******/
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
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 12.01.2021 06:32:19 ******/
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
/****** Object:  StoredProcedure [dbo].[kullanici_Ekle]    Script Date: 12.01.2021 06:32:19 ******/
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
/****** Object:  StoredProcedure [dbo].[kullanici_Guncelle]    Script Date: 12.01.2021 06:32:19 ******/
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
/****** Object:  StoredProcedure [dbo].[salon_Ekle]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[salon_Ekle]
@ad varchar(50),
@koltuk_adet int

As
Begin
Insert Into salon (ad,koltuk_adet) Values(@ad,@koltuk_adet)
End
GO
/****** Object:  StoredProcedure [dbo].[salon_Guncelle]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[salon_Guncelle]
@Id int,
@ad varchar(50),
@koltuk_adet int

As
Begin
Update salon Set ad=@ad,koltuk_adet=@koltuk_adet
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[seans_Ekle]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[seans_Ekle]
@film_Id int,
@salon_Id int,
@tarih datetime

As
Begin
Insert Into seans (film_Id,salon_Id,tarih) Values(@film_Id,@salon_Id,@tarih)
End
GO
/****** Object:  StoredProcedure [dbo].[seans_Guncelle]    Script Date: 12.01.2021 06:32:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[seans_Guncelle]
@Id int,
@film_Id int,
@salon_Id int,
@tarih datetime

As
Begin
Update seans Set film_Id=@film_Id,salon_Id=@salon_Id,tarih=@tarih
Where Id=@Id
End
GO
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 12.01.2021 06:32:19 ******/
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
/****** Object:  StoredProcedure [dbo].[Yonetici_Kontrol]    Script Date: 12.01.2021 06:32:19 ******/
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
USE [master]
GO
ALTER DATABASE [sinemadb] SET  READ_WRITE 
GO
