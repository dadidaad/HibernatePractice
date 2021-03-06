USE [master]
GO
/****** Object:  Database [Product_Tracking]    Script Date: 6/30/2022 2:07:47 PM ******/
CREATE DATABASE [Product_Tracking] ON  PRIMARY 
( NAME = N'Product_Tracking', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Product_Tracking.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Product_Tracking_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Product_Tracking_log.LDF' , SIZE = 504KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Product_Tracking] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Product_Tracking].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Product_Tracking] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Product_Tracking] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Product_Tracking] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Product_Tracking] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Product_Tracking] SET ARITHABORT OFF 
GO
ALTER DATABASE [Product_Tracking] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Product_Tracking] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Product_Tracking] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Product_Tracking] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Product_Tracking] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Product_Tracking] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Product_Tracking] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Product_Tracking] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Product_Tracking] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Product_Tracking] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Product_Tracking] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Product_Tracking] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Product_Tracking] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Product_Tracking] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Product_Tracking] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Product_Tracking] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Product_Tracking] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Product_Tracking] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Product_Tracking] SET  MULTI_USER 
GO
ALTER DATABASE [Product_Tracking] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Product_Tracking] SET DB_CHAINING OFF 
GO
USE [Product_Tracking]
GO
/****** Object:  Table [dbo].[Brand]    Script Date: 6/30/2022 2:07:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Brand](
	[BrandId] [int] IDENTITY(1,1) NOT NULL,
	[BrandName] [varchar](100) NOT NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[BrandId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 6/30/2022 2:07:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductId] [varchar](10) NOT NULL,
	[ProductName] [varchar](100) NOT NULL,
	[ModelYear] [varchar](100) NULL,
	[ListPrice] [money] NULL,
	[BrandId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Brand] ON 

INSERT [dbo].[Brand] ([BrandId], [BrandName], [Status]) VALUES (1, N'Gucci', 1)
INSERT [dbo].[Brand] ([BrandId], [BrandName], [Status]) VALUES (3, N'Zara', 0)
SET IDENTITY_INSERT [dbo].[Brand] OFF
GO
INSERT [dbo].[Product] ([ProductId], [ProductName], [ModelYear], [ListPrice], [BrandId]) VALUES (N'Product001', N'T-Shirt', N'2020', 18.0000, 1)
INSERT [dbo].[Product] ([ProductId], [ProductName], [ModelYear], [ListPrice], [BrandId]) VALUES (N'Product004', N'Apparel', N'2021', 18.9000, 3)
INSERT [dbo].[Product] ([ProductId], [ProductName], [ModelYear], [ListPrice], [BrandId]) VALUES (N'Product006', N'Hoodie', N'2019', 45.0000, 3)
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([BrandId])
REFERENCES [dbo].[Brand] ([BrandId])
GO
USE [master]
GO
ALTER DATABASE [Product_Tracking] SET  READ_WRITE 
GO
