USE [master]
GO
/****** Object:  Database [appCoffee]    Script Date: 3/11/2018 3:26:50 PM ******/
CREATE DATABASE [appCoffee]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'appCoffee', FILENAME = N'E:\appCoffee.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'appCoffee_log', FILENAME = N'E:\appCoffee_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [appCoffee] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [appCoffee].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [appCoffee] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [appCoffee] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [appCoffee] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [appCoffee] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [appCoffee] SET ARITHABORT OFF 
GO
ALTER DATABASE [appCoffee] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [appCoffee] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [appCoffee] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [appCoffee] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [appCoffee] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [appCoffee] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [appCoffee] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [appCoffee] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [appCoffee] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [appCoffee] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [appCoffee] SET  DISABLE_BROKER 
GO
ALTER DATABASE [appCoffee] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [appCoffee] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [appCoffee] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [appCoffee] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [appCoffee] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [appCoffee] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [appCoffee] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [appCoffee] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [appCoffee] SET  MULTI_USER 
GO
ALTER DATABASE [appCoffee] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [appCoffee] SET DB_CHAINING OFF 
GO
ALTER DATABASE [appCoffee] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [appCoffee] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [appCoffee]
GO
/****** Object:  Table [dbo].[Ban]    Script Date: 3/11/2018 3:26:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ban](
	[MaBan] [varchar](50) NOT NULL,
	[LoaiBan] [varchar](50) NOT NULL,
	[MaKhachDatBan] [varchar](15) NULL,
	[ThoiGianDat] [varchar](15) NULL,
	[TrangThaiBan] [bit] NULL DEFAULT ((0)),
PRIMARY KEY CLUSTERED 
(
	[MaBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 3/11/2018 3:26:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHD] [varchar](15) NOT NULL,
	[MaDoUong] [varchar](50) NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[ThanhTien]  AS ([SoLuong]*[DonGia]),
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaDoUong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DoUong]    Script Date: 3/11/2018 3:26:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DoUong](
	[MaDoUong] [varchar](50) NOT NULL,
	[TenDoUong] [varchar](50) NOT NULL,
	[LoaiDoUong] [varchar](50) NOT NULL,
	[GiaDoUong] [smallmoney] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDoUong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 3/11/2018 3:26:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [varchar](15) NOT NULL,
	[MaNV] [varchar](15) NOT NULL,
	[MaKH] [varchar](15) NOT NULL,
	[NgayBan] [varchar](50) NULL,
	[TongTien] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 3/11/2018 3:26:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [varchar](15) NOT NULL,
	[HoTen] [varchar](50) NOT NULL,
	[SoDienThoai] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[DiaChi] [varchar](50) NOT NULL,
	[TaiKhoanKhach] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 3/11/2018 3:26:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](15) NOT NULL,
	[HoTen] [varchar](50) NOT NULL,
	[NgaySinh] [varchar](50) NOT NULL,
	[DiaChi] [varchar](50) NOT NULL,
	[GioiTinh] [varchar](50) NOT NULL,
	[ChucVu] [varchar](50) NOT NULL,
	[MucLuong] [float] NOT NULL,
	[SoNgayLam] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 3/11/2018 3:26:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenDangNhap] [varchar](15) NOT NULL,
	[MatKhau] [varchar](15) NOT NULL,
	[TinhTrangDangNhap] [bit] NULL DEFAULT ((0)),
	[QuyenHan] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Ban] ([MaBan], [LoaiBan], [MaKhachDatBan], [ThoiGianDat], [TrangThaiBan]) VALUES (N'Ban1', N'Bàn 2', N'mkyong35', N'09:33:54', 1)
INSERT [dbo].[Ban] ([MaBan], [LoaiBan], [MaKhachDatBan], [ThoiGianDat], [TrangThaiBan]) VALUES (N'Ban2', N'Bàn 2', N'NULL', N'NULL', 0)
INSERT [dbo].[Ban] ([MaBan], [LoaiBan], [MaKhachDatBan], [ThoiGianDat], [TrangThaiBan]) VALUES (N'Ban3', N'Bàn 2', N'NULL', N'NULL', 0)
INSERT [dbo].[Ban] ([MaBan], [LoaiBan], [MaKhachDatBan], [ThoiGianDat], [TrangThaiBan]) VALUES (N'Ban4', N'Bàn 4', NULL, NULL, 0)
INSERT [dbo].[Ban] ([MaBan], [LoaiBan], [MaKhachDatBan], [ThoiGianDat], [TrangThaiBan]) VALUES (N'Ban5', N'Bàn 4', N'null', N'10:19:11', 1)
INSERT [dbo].[Ban] ([MaBan], [LoaiBan], [MaKhachDatBan], [ThoiGianDat], [TrangThaiBan]) VALUES (N'Ban6', N'Bàn 6', N'mkyong35', N'09:26:22', 1)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaDoUong], [SoLuong], [DonGia]) VALUES (N'HD001', N'DU01', 2, 15000)
INSERT [dbo].[ChiTietHoaDon] ([MaHD], [MaDoUong], [SoLuong], [DonGia]) VALUES (N'HD001', N'DU02', 1, 8000)
INSERT [dbo].[DoUong] ([MaDoUong], [TenDoUong], [LoaiDoUong], [GiaDoUong]) VALUES (N'TD3', N'thao duoc', N'nuoc', 15.5010)
INSERT [dbo].[DoUong] ([MaDoUong], [TenDoUong], [LoaiDoUong], [GiaDoUong]) VALUES (N'TD4', N'thao duoc', N'nuoc', 150.5000)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayBan], [TongTien]) VALUES (N'HD001', N'NV01', N'KH01', N'2018-10-2', 38000)
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH100690', N'Nguyen Van Thao', N'01657658965', N'vanthao10a8@gmail.com', N'Quan 9, TpHCM', N'admin')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH103630', N'ueflkm', N'ulfkm', N'qudl', N'uerflkm', N'qqwnd')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH145507', N'123', N'123', N'123', N'123', N'123')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH156355', N'123', N'123', N'123', N'123', N'12345')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH161149', N'123', N'123', N'123', N'123', N'123')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH301832', N'', N'', N'', N'', N'')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH354042', N'', N'', N'', N'', N'')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH395096', N'ueflkm', N'ulfkm', N'qudl', N'uerflkm', N'qqwnd')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH400121', N'thao', N'123', N'van', N'123', N'mkyong37')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH423837', N'', N'', N'', N'', N'')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH424003', N'123', N'123', N'123', N'123', N'123')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH437367', N'aaaaaaaaaaa', N'aaaaaaaaaa', N'aaaaaaaaaa', N'aaaaaaaaaa', N'aaaaaaaaaaaaa')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH443733', N'123', N'123', N'123', N'123', N'12345')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH449329', N'123aqsd', N'qudqwd', N'vantrh', N'qudqwd', N'mkyong34')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH530604', N'ueflkm', N'ulfkm', N'qudl', N'uerflkm', N'qqwnd')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH561395', N'ueflkm', N'ulfkm', N'qudl', N'uerflkm', N'qqwnd')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH778738', N'1234', N'123', N'1234', N'123', N'1234')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH787962', N'12345', N'12345', N'12345', N'12345', N'12345')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH950421', N'123aqsd', N'qudqwd', N'vantrh', N'qudqwd', N'mkyong34')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH952440', N'?egn', N'ugln', N'anj', N'uefln', N'mkyong37')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [SoDienThoai], [Email], [DiaChi], [TaiKhoanKhach]) VALUES (N'KH971178', N'thao', N'thao', N'thao', N'thao', N'mkyong38')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [DiaChi], [GioiTinh], [ChucVu], [MucLuong], [SoNgayLam]) VALUES (N'nhanvien0', N'Nguyen Van Thao', N'02-10-1997', N'Quan 9, TpHCM', N'Nam', N'Nhan Vien', 150000, 10)
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [DiaChi], [GioiTinh], [ChucVu], [MucLuong], [SoNgayLam]) VALUES (N'nhanvien1', N'Nguyen Van H', N'02-10-1995', N'Quan 10, TpHCM', N'Nam', N'Nhan Vien', 15000, 10)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [TinhTrangDangNhap], [QuyenHan]) VALUES (N'admin', N'123456', 0, N'Quan Ly')
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [TinhTrangDangNhap], [QuyenHan]) VALUES (N'nhanvien0', N'123456', 0, N'Nhan Vien')
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [TinhTrangDangNhap], [QuyenHan]) VALUES (N'nhanvien1', N'123456', 0, N'Nhan Vien')
USE [master]
GO
ALTER DATABASE [appCoffee] SET  READ_WRITE 
GO
