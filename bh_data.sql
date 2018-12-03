-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2018 at 12:16 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bh_data`
--

-- --------------------------------------------------------

--
-- Table structure for table `area`
--

CREATE TABLE `area` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `area` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `area`
--

INSERT INTO `area` (`id`, `area`) VALUES
(1, 'Aceh'),
(2, 'Sumatera Utara'),
(3, 'Sumatera Barat'),
(4, 'Riau'),
(5, 'Kepulauan Riau (Kepri)'),
(6, 'Bengkulu'),
(7, 'Jambi'),
(8, 'Kep. Bangka Belitung'),
(9, 'Sumatera Selatan'),
(10, 'Lampung'),
(11, 'Banten'),
(12, 'DKI Jakarta'),
(13, 'Jawa Barat'),
(14, 'Jawa Tengah'),
(15, 'Jawa Timur'),
(16, 'Daerah Istimewa Yogyakarta (DIY)'),
(17, 'Bali'),
(18, 'Nusa Tenggara Barat'),
(19, 'Nusa Tenggara Timur'),
(20, 'Kalimantan Barat'),
(21, 'Kalimantan Utara'),
(22, 'Kalimantan Tengah'),
(23, 'Kalimantan Timur'),
(24, 'Kalimantan Selatan'),
(25, 'Sulawesi Barat'),
(26, 'Sulawesi Selatan'),
(27, 'Sulawesi Tengah'),
(28, 'Sulawesi Tenggara'),
(29, 'Sulawesi Utara'),
(30, 'Gorontalo'),
(31, 'Maluku'),
(32, 'Maluku Utara'),
(33, 'Papua'),
(34, 'Papua Barat');

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nama` varchar(50) NOT NULL,
  `des` varchar(300) NOT NULL,
  `atk` int(2) NOT NULL,
  `def` int(2) NOT NULL,
  `area` int(2) NOT NULL,
  `grade` int(2) NOT NULL,
  `skil` varchar(50) NOT NULL,
  `pic` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`id`, `nama`, `des`, `atk`, `def`, `area`, `grade`, `skil`, `pic`) VALUES
(1, 'K. H. Ahmad Rifai', 'Compek', 12, 11, 14, 3, 'Compek Kill', '/battle/of/hero/image/kartu/a.rifai.png'),
(2, 'Abdul Halim', 'Compek2', 26, 6, 13, 2, 'Kill Compek', '/battle/of/hero/image/kartu/ABDUL HALIM.png'),
(3, 'Aceh', 'compek', 6, 3, 1, 4, 'Booster', '/battle/of/hero/image/kartu/aceh.png'),
(4, 'Jendral A Yani', 'compek', 19, 6, 14, 2, 'pek', '/battle/of/hero/image/kartu/AHMAD YANI.png'),
(5, 'Christina Martha Siahahu', 'Compek', 4, 1, 31, 3, 'Compek Kill', '/battle/of/hero/image/kartu/christina martha.png'),
(6, 'Raden Dewi Sartika', 'Compek2', 14, 12, 13, 2, 'Kill Compek', '/battle/of/hero/image/kartu/DEWI SARTIKA.png'),
(7, 'Gatot Soebroto', 'compek', 10, 10, 14, 2, 'com', '/battle/of/hero/image/kartu/GATOT SOEBROTO.png'),
(8, 'Tuanku Imam Bonjol', 'compek', 8, 11, 3, 3, 'pek', '/battle/of/hero/image/kartu/imam bonjol.png'),
(9, 'Jawa Barat', 'Compek', 6, 3, 13, 4, 'Booster', '/battle/of/hero/image/kartu/jabar.png'),
(10, 'Jawa Tengah', 'Compek2', 6, 3, 14, 4, 'Booster', '/battle/of/hero/image/kartu/jateng.png'),
(11, 'Jawa Timur', 'compek', 6, 3, 15, 4, 'Booster', '/battle/of/hero/image/kartu/jatim.png'),
(12, 'Jenderal Sudirman', 'compek', 24, 1, 14, 2, 'pek', '/battle/of/hero/image/kartu/JENDERAL SUDIRMAN.png'),
(13, 'Ki Hajar Dewantoro', 'Compek', 2, 5, 16, 2, 'Compek Kill', '/battle/of/hero/image/kartu/KI HAJAR DEWANTORO.png'),
(14, 'Pahlawan Aceh', 'Compek2', 6, 6, 1, 1, 'Kill Compek', '/battle/of/hero/image/kartu/p.aceh.png'),
(15, 'Pahlawan DKI Jakarta', 'compek', 6, 6, 12, 1, 'com', '/battle/of/hero/image/kartu/p.dki jakarta.png'),
(16, 'Pahlawan Jawa Barat', '', 6, 6, 13, 1, '', '/battle/of/hero/image/kartu/p.jabar.png'),
(17, 'Pahlawan Jawa Tengah', '', 6, 6, 14, 1, '', '/battle/of/hero/image/kartu/p.jateng.png'),
(18, 'Pahlawan Jawa Timur', '', 6, 6, 15, 1, '', '/battle/of/hero/image/kartu/p.jatim.png'),
(19, 'Pahlawan Maluku', '', 6, 6, 31, 1, '', '/battle/of/hero/image/kartu/p.maluku.png'),
(20, 'Pahlawan Sulawesi Selatan', '', 6, 6, 26, 1, '', '/battle/of/hero/image/kartu/p.sulsel.png'),
(21, 'Pahlawan Sumatera Barat', '', 6, 6, 3, 1, '', '/battle/of/hero/image/kartu/p.sumbar.png'),
(22, 'Pahlawan Sumatera Utara', '', 6, 6, 2, 1, '', '/battle/of/hero/image/kartu/p.sumut.png'),
(23, 'Pahlawan Yogyakarta', '', 6, 6, 16, 1, '', '/battle/of/hero/image/kartu/p.yogya.png'),
(24, 'Pangeran Antasari', '', 11, 10, 24, 3, '', '/battle/of/hero/image/kartu/pangeran antasari.png'),
(25, 'Pangeran Diponegoro', '', 11, 11, 16, 3, '', '/battle/of/hero/image/kartu/pangeran diponegoro.png'),
(26, 'Kapiten Pattimura', '', 16, 12, 31, 3, '', '/battle/of/hero/image/kartu/pattimura.png'),
(27, 'Raden Suprapto', '', 20, 6, 14, 2, '', '/battle/of/hero/image/kartu/RADEN SUPAPTO.png'),
(28, 'Ir. Soekarno', '', 6, 6, 15, 2, '', '/battle/of/hero/image/kartu/SOEKARNO.png'),
(29, 'Soepeno', '', 12, 6, 14, 2, '', '/battle/of/hero/image/kartu/SOEPENO.png'),
(30, 'Sultan Mahmud Badaruddin II', '', 26, 9, 9, 3, '', '/battle/of/hero/image/kartu/sultan badar.png'),
(31, 'Sultan Hasanuddin', '', 12, 1, 26, 3, '', '/battle/of/hero/image/kartu/sultan hasanudin.png'),
(32, 'Sumatera Barat', '', 6, 3, 3, 4, '', '/battle/of/hero/image/kartu/sumbar.png'),
(33, 'Sumatera Selatan', '', 6, 3, 9, 4, '', '/battle/of/hero/image/kartu/sumsel.png'),
(34, 'Sumatera Utara', '', 6, 3, 2, 4, '', '/battle/of/hero/image/kartu/sumut.png'),
(35, 'Tengku Tjik Ditiro', '', 21, 1, 1, 2, '', '/battle/of/hero/image/kartu/TENGKU TJIK DITIRO.png'),
(36, 'Teuku Umar', '', 11, 2, 1, 3, '', '/battle/of/hero/image/kartu/TEUKU UMAR.png'),
(37, 'D.I. Yogyakarta', '', 6, 3, 16, 4, '', '/battle/of/hero/image/kartu/yogya.png'),
(38, 'Yusuf Al-Makasari', '', 3, 7, 26, 3, '', '/battle/of/hero/image/kartu/yusuf al makasari.png');

-- --------------------------------------------------------

--
-- Table structure for table `deck`
--

CREATE TABLE `deck` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_card` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deck`
--

INSERT INTO `deck` (`id`, `id_card`) VALUES
(1, 2),
(2, 2),
(3, 37),
(4, 7),
(5, 7),
(6, 28),
(7, 28),
(8, 10),
(9, 9),
(10, 12),
(11, 13),
(12, 14),
(13, 13),
(14, 11),
(15, 9),
(16, 14),
(17, 15),
(18, 15),
(19, 16),
(20, 16),
(21, 17),
(22, 17),
(23, 18),
(24, 18),
(25, 19),
(26, 19),
(27, 20),
(28, 20),
(29, 21),
(30, 22),
(31, 21),
(32, 22),
(33, 23),
(34, 23),
(35, 25),
(36, 6),
(37, 27),
(38, 29),
(39, 29),
(40, 32),
(41, 32),
(42, 33),
(43, 33),
(44, 34),
(45, 35),
(46, 35);

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `grade` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`id`, `grade`) VALUES
(1, 'Rare'),
(2, 'Epic'),
(3, 'Legend'),
(4, 'Spell');

-- --------------------------------------------------------

--
-- Table structure for table `koleksi`
--

CREATE TABLE `koleksi` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_card` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `koleksi`
--

INSERT INTO `koleksi` (`id`, `id_card`) VALUES
(1, 14),
(2, 14),
(3, 14),
(4, 14),
(5, 14),
(6, 14),
(7, 14),
(8, 14),
(9, 14),
(10, 14),
(11, 15),
(12, 15),
(13, 16),
(14, 16),
(15, 17),
(16, 17),
(17, 17),
(18, 18),
(19, 18),
(20, 18),
(21, 18),
(22, 18),
(23, 19),
(24, 19),
(25, 19),
(26, 19),
(27, 20),
(28, 20),
(29, 20),
(30, 20),
(31, 20),
(32, 20),
(33, 20),
(34, 20),
(35, 20),
(36, 21),
(37, 21),
(38, 21),
(39, 21),
(40, 22),
(41, 22),
(42, 22),
(43, 23),
(44, 23),
(45, 23),
(46, 29),
(47, 29),
(48, 35);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `pts` int(11) NOT NULL DEFAULT '1000'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`pts`) VALUES
(6799000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `deck`
--
ALTER TABLE `deck`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `koleksi`
--
ALTER TABLE `koleksi`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area`
--
ALTER TABLE `area`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `card`
--
ALTER TABLE `card`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `deck`
--
ALTER TABLE `deck`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `koleksi`
--
ALTER TABLE `koleksi`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
