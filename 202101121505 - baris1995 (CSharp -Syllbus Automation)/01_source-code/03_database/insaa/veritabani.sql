USE [master]
GO
/****** Object:  Database [syllabusdb]    Script Date: 12.01.2021 11:06:58 ******/
CREATE DATABASE [syllabusdb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'syllabusdb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\syllabusdb.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'syllabusdb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\syllabusdb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [syllabusdb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [syllabusdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [syllabusdb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [syllabusdb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [syllabusdb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [syllabusdb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [syllabusdb] SET ARITHABORT OFF 
GO
ALTER DATABASE [syllabusdb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [syllabusdb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [syllabusdb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [syllabusdb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [syllabusdb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [syllabusdb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [syllabusdb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [syllabusdb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [syllabusdb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [syllabusdb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [syllabusdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [syllabusdb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [syllabusdb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [syllabusdb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [syllabusdb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [syllabusdb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [syllabusdb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [syllabusdb] SET RECOVERY FULL 
GO
ALTER DATABASE [syllabusdb] SET  MULTI_USER 
GO
ALTER DATABASE [syllabusdb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [syllabusdb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [syllabusdb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [syllabusdb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [syllabusdb] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'syllabusdb', N'ON'
GO
USE [syllabusdb]
GO
/****** Object:  Table [dbo].[syllabus]    Script Date: 12.01.2021 11:06:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[syllabus](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](50) NULL,
	[fall] [varchar](50) NULL,
	[spring] [varchar](50) NULL,
	[theory] [varchar](50) NULL,
	[lab] [varchar](50) NULL,
	[credit] [int] NULL,
	[ects] [varchar](50) NULL,
 CONSTRAINT [PK_syllabus] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[Getir]    Script Date: 12.01.2021 11:06:58 ******/
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
/****** Object:  StoredProcedure [dbo].[Kayitlar]    Script Date: 12.01.2021 11:06:58 ******/
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
/****** Object:  StoredProcedure [dbo].[Sil]    Script Date: 12.01.2021 11:06:58 ******/
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
/****** Object:  StoredProcedure [dbo].[syllabus_Ekle]    Script Date: 12.01.2021 11:06:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[syllabus_Ekle]
@code varchar(50),
@fall varchar(50),
@spring varchar(50),
@theory varchar(50),
@lab varchar(50),
@credit int,
@ects varchar(50)

As
Begin
Insert Into syllabus (code,fall,spring,theory,lab,credit,ects) Values(@code,@fall,@spring,@theory,@lab,@credit,@ects)
End
GO
/****** Object:  StoredProcedure [dbo].[syllabus_Guncelle]    Script Date: 12.01.2021 11:06:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[syllabus_Guncelle]
@Id int,
@code varchar(50),
@fall varchar(50),
@spring varchar(50),
@theory varchar(50),
@lab varchar(50),
@credit int,
@ects varchar(50)

As
Begin
Update syllabus Set code=@code,fall=@fall,spring=@spring,theory=@theory,lab=@lab,credit=@credit,ects=@ects
Where Id=@Id
End
GO
USE [master]
GO
ALTER DATABASE [syllabusdb] SET  READ_WRITE 
GO
