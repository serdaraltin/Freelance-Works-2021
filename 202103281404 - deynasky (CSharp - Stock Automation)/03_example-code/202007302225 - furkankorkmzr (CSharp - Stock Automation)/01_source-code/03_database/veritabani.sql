USE [CRMDB]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](250) NULL,
	[Price] [int] NULL,
	[Stock] [int] NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USERS]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USERS](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [varchar](250) NULL,
	[LastName] [varchar](250) NULL,
	[UserName] [varchar](50) NULL,
	[Password] [varchar](50) NULL,
 CONSTRAINT [PK_USERS] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[SP_Delete]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_Delete](
@Id int
)
AS
BEGIN
Delete From Products
Where Id=@Id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_Insert]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_Insert](
@Name varchar(250),
@Price int,
@Stock int
)
AS
BEGIN
Insert Into Products (Name,Price,Stock)
Values (@Name,@Price,@Stock)
END

GO
/****** Object:  StoredProcedure [dbo].[SP_List]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_List]

AS
BEGIN
Select *From Products
END

GO
/****** Object:  StoredProcedure [dbo].[SP_Select]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_Select](
@Id int
)
AS
BEGIN
Select *From Products
Where Id=@Id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_Update]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_Update](
@Id int,
@Name varchar(250),
@Price int,
@Stock int
)
AS
BEGIN
Update Products Set Name=@Name,Price=@Price,Stock=@Stock
Where Id=@Id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_UserDelete]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_UserDelete]
(
@UserId int
)
AS
BEGIN
Delete From USERS
Where UserId=@UserId
END

GO
/****** Object:  StoredProcedure [dbo].[SP_UserInsert]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_UserInsert]
(
@FirstName varchar(250),
@LastName varchar(250),
@UserName varchar(50),
@Password varchar(250)
)
AS
BEGIN
Insert Into USERS (FirstName,LastName,UserName,Password)
Values (@FirstName,@LastName,@UserName,@Password)
END

GO
/****** Object:  StoredProcedure [dbo].[SP_UserLogin]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_UserLogin]
(
@UserName varchar(50),
@Password varchar(250),
@ReturnValue int output
)
AS
BEGIN

	IF EXISTS(SELECT UserId FROM USERS Where UserName=@UserName)
	BEGIN
		IF EXISTS(SELECT UserId FROM USERS Where UserName=@UserName and Password=@Password)
		BEGIN
			SET @ReturnValue = 1
			RETURN @ReturnValue
		END
		ELSE
		BEGIN
			SET @ReturnValue = -1
			RETURN @ReturnValue
		END
	END
	ELSE
	BEGIN
		SET @ReturnValue = 0
		RETURN @ReturnValue
	END


END

GO
/****** Object:  StoredProcedure [dbo].[SP_UserSelect]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_UserSelect]
(
@UserName varchar(50),
@Password varchar(250)
)
AS
BEGIN
Select *From USERS
Where UserName=@UserName and Password=@Password
END

GO
/****** Object:  StoredProcedure [dbo].[SP_UserUpdate]    Script Date: 30.07.2020 19:43:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[SP_UserUpdate]
(
@UserId int,
@FirstName varchar(250),
@LastName varchar(250),
@UserName varchar(50),
@Password varchar(250)
)
AS
BEGIN
Update USERS Set FirstName=@FirstName,LastName=@LastName,UserName=@UserName,Password=@Password
Where UserId=@UserId
END

GO
