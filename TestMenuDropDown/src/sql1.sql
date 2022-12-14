USE [master]
GO
/****** Object:  Database [QuanLyTiemSach]    Script Date: 10/14/2022 11:29:45 AM ******/
CREATE DATABASE [QuanLyTiemSach]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyTiemSach', FILENAME = N'D:\App_HocTap\sql\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyTiemSach.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyTiemSach_log', FILENAME = N'D:\App_HocTap\sql\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyTiemSach_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyTiemSach] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyTiemSach].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyTiemSach] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyTiemSach] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyTiemSach] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyTiemSach] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyTiemSach] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyTiemSach] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyTiemSach] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyTiemSach] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyTiemSach] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyTiemSach] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyTiemSach] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyTiemSach] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyTiemSach] SET QUERY_STORE = OFF
GO
USE [QuanLyTiemSach]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [nchar](10) NOT NULL,
	[maSach] [nchar](10) NOT NULL,
	[soLuong] [int] NULL,
	[donGia] [money] NULL,
	[tongDonGia] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuMuaHang]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuMuaHang](
	[maPhieu] [nchar](10) NOT NULL,
	[maSach] [nchar](10) NOT NULL,
	[soLuong] [int] NULL,
	[ngayLap] [date] NULL,
	[tongTien] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](10) NOT NULL,
	[maKhachHang] [nchar](10) NOT NULL,
	[maNhanVien] [nchar](10) NOT NULL,
	[ngayLapHoaDon] [date] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nchar](10) NOT NULL,
	[tenKhachHang] [nchar](50) NULL,
	[sdtKhachHang] [nchar](10) NULL,
	[email] [nchar](50) NULL,
	[gioiTinh] [nchar](10) NULL,
	[tenTaiKhoan] [nchar](20) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](10) NOT NULL,
	[tenNhanVien] [nchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [nchar](10) NULL,
	[diaChi] [nchar](100) NULL,
	[sdtNhanVien] [nchar](10) NULL,
	[email] [nchar](50) NULL,
	[tenTaiKhoan] [nchar](20) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaXuatBan]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaXuatBan](
	[maNhaXuatBan] [nchar](10) NOT NULL,
	[tenNhaXuatBan] [nchar](50) NULL,
	[diaChi] [nchar](100) NULL,
 CONSTRAINT [PK_NhaXuatBan] PRIMARY KEY CLUSTERED 
(
	[maNhaXuatBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuMuaHang]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuMuaHang](
	[maPhieu] [nchar](10) NOT NULL,
	[maKhachHang] [nchar](10) NOT NULL,
	[maNhanVien] [nchar](10) NOT NULL,
	[ngayLapPhieu] [date] NULL,
 CONSTRAINT [PK_PhieuMuaHang] PRIMARY KEY CLUSTERED 
(
	[maPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[maSach] [nchar](10) NOT NULL,
	[maNhaXuatBan] [nchar](10) NOT NULL,
	[maTacGia] [nchar](10) NOT NULL,
	[tenSach] [nchar](100) NULL,
	[donGia] [money] NULL,
	[tenLoaiSach] [nchar](50) NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_Sach] PRIMARY KEY CLUSTERED 
(
	[maSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TacGia]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TacGia](
	[maTacGia] [nchar](10) NOT NULL,
	[tenTacGia] [nchar](50) NULL,
 CONSTRAINT [PK_TacGia] PRIMARY KEY CLUSTERED 
(
	[maTacGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/14/2022 11:29:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTaiKhoan] [nchar](10) NOT NULL,
	[loaiTaiKhoan] [nchar](10) NULL,
	[tenTaiKhoan] [nchar](20) NOT NULL,
	[matKhau] [nchar](20) NULL,
	[email] [nchar](50) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_Sach] FOREIGN KEY([maSach])
REFERENCES [dbo].[Sach] ([maSach])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_Sach]
GO
ALTER TABLE [dbo].[ChiTietPhieuMuaHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuMuaHang_PhieuMuaHang] FOREIGN KEY([maPhieu])
REFERENCES [dbo].[PhieuMuaHang] ([maPhieu])
GO
ALTER TABLE [dbo].[ChiTietPhieuMuaHang] CHECK CONSTRAINT [FK_ChiTietPhieuMuaHang_PhieuMuaHang]
GO
ALTER TABLE [dbo].[ChiTietPhieuMuaHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuMuaHang_Sach] FOREIGN KEY([maSach])
REFERENCES [dbo].[Sach] ([maSach])
GO
ALTER TABLE [dbo].[ChiTietPhieuMuaHang] CHECK CONSTRAINT [FK_ChiTietPhieuMuaHang_Sach]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_TaiKhoan] FOREIGN KEY([tenTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([tenTaiKhoan])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_TaiKhoan]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([tenTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([tenTaiKhoan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[PhieuMuaHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuaHang_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[PhieuMuaHang] CHECK CONSTRAINT [FK_PhieuMuaHang_KhachHang]
GO
ALTER TABLE [dbo].[PhieuMuaHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuaHang_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuMuaHang] CHECK CONSTRAINT [FK_PhieuMuaHang_NhanVien]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_NhaXuatBan] FOREIGN KEY([maNhaXuatBan])
REFERENCES [dbo].[NhaXuatBan] ([maNhaXuatBan])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_NhaXuatBan]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_TacGia] FOREIGN KEY([maTacGia])
REFERENCES [dbo].[TacGia] ([maTacGia])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_TacGia]
GO
USE [master]
GO
ALTER DATABASE [QuanLyTiemSach] SET  READ_WRITE 
GO
