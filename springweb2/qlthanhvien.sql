-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 03, 2024 lúc 06:04 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlthanhvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thanhvien`
--

CREATE TABLE `thanhvien` (
  `MaTV` int(10) NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `Khoa` varchar(100) DEFAULT NULL,
  `Nganh` varchar(100) DEFAULT NULL,
  `SDT` int(10) DEFAULT NULL,
  `PassWord` varchar(10) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `nganh_string` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thanhvien`
--

INSERT INTO `thanhvien` (`MaTV`, `HoTen`, `Khoa`, `Nganh`, `SDT`, `PassWord`, `Email`, `nganh_string`, `pass_word`) VALUES
(1120010007, 'Nguyễn Gia Mai', 'Toán UD', 'Toán', 911200100, '1120010007', '1120010007@gmail.com', NULL, NULL),
(1120020019, 'Chu Phúc Ngọc', 'SP KHXH', 'Lí', 911200200, '1120020001', '11200200019@gmail.com', NULL, NULL),
(1120090014, 'Nguyễn Thị Mỹ Ngân', 'SP KHXH', 'Văn', 911200900, '1120090001', '11200900014@gmail.com', NULL, NULL),
(1120090018, 'Trần Thị Anh Ngọc', 'SP KHXH', 'Văn', 911200900, '1120090001', '11200900018@gmail.com', NULL, NULL),
(1120380064, 'Nguyễn Ngọc Quỳnh Lực', 'Ngoại Ngữ', 'NNA', 911203800, '1120380064', '1120380064@gmail.com', NULL, NULL),
(1120410311, 'Lê Việt Nga', 'CNTT', 'CNTT', 911204103, '1120411031', '11204110311@gmail.com', NULL, NULL),
(1120480015, 'Trần Phạm Ngọc Ly', 'Toán UD', 'Toán', 911204800, '1120480015', '1120480015@gmail.com', NULL, NULL),
(1120480216, 'Nguyễn Trần Thái Ngọc', 'Toán UD', 'Toán', 911204802, '1120480021', '11204800216@gmail.com', NULL, NULL),
(1120480217, 'Trần Minh Phúc Ngọc', 'Toán UD', 'Toán', 911204802, '1120480021', '11204800217@gmail.com', NULL, NULL),
(1121020009, 'Bùi Đình Thái My', 'SP KHTN', 'Lí', 911210200, '1121020009', '1121020009@gmail.com', NULL, NULL),
(1121100003, 'Nguyễn Đắc Phương Linh', 'SP KHXH', 'Sử', 911211000, '1121100003', '1121100003@gmail.com', NULL, NULL),
(1121100012, 'Trương Hoài Nga', 'SP KHXH', 'Sử', 911211000, '1121100001', '11211000012@gmail.com', NULL, NULL),
(1121110001, 'Phạm Thị Lan Khôi', 'SP KHXH', 'Địa', 911211100, '1121110001', '1121110001@gmail.com', NULL, NULL),
(1121130012, 'Lê Ngọc lan', 'Ngoại Ngữ', 'Anh', 911211300, '1121130012', '1121130012@gmail.com', NULL, NULL),
(1122090010, 'Lê Xuân Nam', 'SP KHXH', 'Văn', 911220900, '1122090001', '11220900010@gmail.com', NULL, NULL),
(1122090013, 'Nguyễn Mỹ Ngân', 'SP KHXH', 'Văn', 911220900, '1122090001', '11220900013@gmail.com', NULL, NULL),
(1122090015, 'Nguyễn Thủy Triều Ngọc', 'SP KHXH', 'Văn', 911220900, '1122090001', '11204800216@gmail.com', NULL, NULL),
(1122530016, 'Lê Thục Ly', 'QLGD', 'TLH', 911225300, '1122530016', '1122530016@gmail.com', NULL, NULL),
(1122550008, 'Nguyễn Gia My', 'QTKD', 'QTKD', 911225500, '1122550008', '1122550008@gmail.com', NULL, NULL),
(2147483647, 'Nguyễn Văn Nam', 'CNTT', 'HTTT', 123456789, '', '', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thietbi`
--

CREATE TABLE `thietbi` (
  `MaTB` int(10) NOT NULL,
  `TenTB` varchar(100) NOT NULL,
  `MoTaTB` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thietbi`
--

INSERT INTO `thietbi` (`MaTB`, `TenTB`, `MoTaTB`) VALUES
(120191, 'Micro không dây 01', 'JBL VM 2001'),
(120192, 'Micro có dây 01', 'MCCD 1001'),
(120203, 'Micro không dây 02', 'BCE 9001'),
(120214, 'Micro không dây 03', 'M3001'),
(120235, 'Micro không dây 03', 'BCE UGX12'),
(220191, 'Máy chiếu Panasonic', 'PNSN 031'),
(320201, 'Máy ảnh Fuji', 'FJ 20201'),
(420201, 'Cassette Sony', 'CN 20201'),
(420212, 'Cassette Sony', 'CN 20211'),
(420213, 'Cassette TQ', 'CSTQ 20211'),
(420224, 'Cassette Sony', 'CS 20221'),
(420236, 'Cassette Sony', 'CS 2023'),
(520221, 'Tivi LG', 'TVLG021'),
(520222, 'Tivi Samsung', 'TVSS20221'),
(620231, 'Quạt đứng', 'QD 20231'),
(620232, 'Quạt đứng', 'QD 20232'),
(620233, 'Quạt đứng', 'QD 20233'),
(620234, 'Quạt đứng', 'QD 20234');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinsd`
--

CREATE TABLE `thongtinsd` (
  `MaTT` int(10) NOT NULL,
  `MaTV` int(10) NOT NULL,
  `MaTB` int(10) DEFAULT NULL,
  `TGVao` datetime DEFAULT NULL,
  `TGMuon` datetime DEFAULT NULL,
  `TGTra` datetime DEFAULT NULL,
  `TGDatcho` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thongtinsd`
--

INSERT INTO `thongtinsd` (`MaTT`, `MaTV`, `MaTB`, `TGVao`, `TGMuon`, `TGTra`, `TGDatcho`) VALUES
(6, 1121110001, NULL, '0004-04-24 10:39:00', NULL, NULL, NULL),
(7, 1121130012, NULL, '0004-04-24 10:39:00', NULL, NULL, NULL),
(8, 1121100003, NULL, '0004-04-24 10:40:00', NULL, NULL, NULL),
(9, 1121110001, NULL, '0004-05-24 08:39:00', NULL, NULL, NULL),
(10, 1121130012, NULL, '0004-05-24 08:50:00', NULL, NULL, NULL),
(11, 1121100003, NULL, '0004-05-24 09:55:00', NULL, NULL, NULL),
(12, 1121110001, 220191, NULL, '0003-05-24 08:50:00', '0003-05-24 12:50:00', NULL),
(13, 2147483647, 120203, NULL, '0003-05-24 09:50:00', '0003-05-24 12:53:00', NULL),
(14, 2147483647, 320201, NULL, '0003-07-24 11:00:00', '0003-07-24 13:00:00', NULL),
(15, 2147483647, 420201, NULL, '0003-08-24 10:00:00', '0003-08-24 16:00:00', NULL),
(16, 2147483647, 120214, NULL, '0003-09-24 09:00:00', '0003-09-24 11:00:00', NULL),
(17, 2147483647, 420212, NULL, '0003-10-24 13:00:00', '0003-10-24 13:30:00', NULL),
(18, 2147483647, 420213, NULL, '0003-12-24 09:11:00', '0003-12-24 11:12:00', NULL),
(19, 2147483647, 520221, NULL, '0003-12-24 09:17:00', NULL, NULL),
(20, 1122550008, 620231, NULL, '0000-00-00 00:00:00', NULL, NULL),
(21, 1121020009, 620232, NULL, '0000-00-00 00:00:00', NULL, NULL),
(22, 2147483647, 620233, NULL, '0000-00-00 00:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `xuly`
--

CREATE TABLE `xuly` (
  `MaXL` int(10) NOT NULL,
  `MaTV` int(10) NOT NULL,
  `HinhThucXL` varchar(250) DEFAULT NULL,
  `SoTien` int(100) DEFAULT NULL,
  `NgayXL` datetime DEFAULT NULL,
  `TrangThaiXL` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `xuly`
--

INSERT INTO `xuly` (`MaXL`, `MaTV`, `HinhThucXL`, `SoTien`, `NgayXL`, `TrangThaiXL`) VALUES
(10, 1121110001, 'Khóa thẻ 1 tháng', NULL, '0002-01-24 10:00:00', 0),
(11, 1121130012, 'Khóa thẻ 1 tháng', NULL, '0002-02-24 10:59:00', 0),
(12, 1121100003, 'Khóa thẻ 1 tháng', NULL, '0002-03-24 10:58:00', 0),
(13, 1120380064, 'Khóa thẻ 2 tháng', NULL, '0003-04-24 10:58:00', 1),
(14, 1121110001, 'Bồi thường', 300000, '0003-05-24 10:58:00', 0),
(15, 1121130012, 'Bồi thường', 200000, '0003-06-24 10:58:00', 0),
(16, 1121100003, 'Khóa thẻ 1 tháng và bồi thường', 100000, '0003-07-24 10:58:00', 0),
(18, 2147483647, 'Khóa thẻ 2 tháng', NULL, '0003-09-24 10:58:00', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `thanhvien`
--
ALTER TABLE `thanhvien`
  ADD PRIMARY KEY (`MaTV`);

--
-- Chỉ mục cho bảng `thietbi`
--
ALTER TABLE `thietbi`
  ADD PRIMARY KEY (`MaTB`);

--
-- Chỉ mục cho bảng `thongtinsd`
--
ALTER TABLE `thongtinsd`
  ADD PRIMARY KEY (`MaTT`),
  ADD KEY `MaTV` (`MaTV`,`MaTB`),
  ADD KEY `MaTB` (`MaTB`);

--
-- Chỉ mục cho bảng `xuly`
--
ALTER TABLE `xuly`
  ADD PRIMARY KEY (`MaXL`),
  ADD KEY `MaTV` (`MaTV`),
  ADD KEY `MaTV_2` (`MaTV`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `thongtinsd`
--
ALTER TABLE `thongtinsd`
  ADD CONSTRAINT `thongtinsd_ibfk_1` FOREIGN KEY (`MaTV`) REFERENCES `thanhvien` (`MaTV`),
  ADD CONSTRAINT `thongtinsd_ibfk_2` FOREIGN KEY (`MaTB`) REFERENCES `thietbi` (`MaTB`);

--
-- Các ràng buộc cho bảng `xuly`
--
ALTER TABLE `xuly`
  ADD CONSTRAINT `xuly_ibfk_1` FOREIGN KEY (`MaTV`) REFERENCES `thanhvien` (`MaTV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
