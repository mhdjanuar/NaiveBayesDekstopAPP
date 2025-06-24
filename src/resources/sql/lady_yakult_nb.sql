-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2025 at 02:14 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lady_yakult_nb`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_training`
--

CREATE TABLE `data_training` (
  `id` int(11) NOT NULL,
  `kriteria1` varchar(255) DEFAULT NULL,
  `kriteria2` varchar(255) DEFAULT NULL,
  `kriteria3` varchar(255) DEFAULT NULL,
  `kriteria4` varchar(255) DEFAULT NULL,
  `kriteria5` varchar(255) DEFAULT NULL,
  `label` varchar(20) DEFAULT NULL,
  `lady_yakult_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_training`
--

INSERT INTO `data_training` (`id`, `kriteria1`, `kriteria2`, `kriteria3`, `kriteria4`, `kriteria5`, `label`, `lady_yakult_id`) VALUES
(1, 'Tinggi', 'Tinggi', 'Baik', 'Tepat Waktu', 'Menengah', 'Terbaik', 1),
(2, 'Tinggi', 'Sedang', 'Buruk', 'Kadang Telat', 'Menengah', 'Tidak Terbaik', 2),
(3, 'Rendah', 'Rendah', 'Buruk', 'Sering Telat', 'Baru', 'Tidak Terbaik', 3),
(4, 'Tinggi', 'Tinggi', 'Baik', 'Sering Telat', 'Lama', 'Terbaik', 4),
(5, 'Sedang', 'Sedang', 'Baik', 'Kadang Telat', 'Baru', 'Terbaik', 5),
(6, 'Tinggi', 'Jarang', 'Sangat Baik', 'Tepat Waktu', 'Baru', 'Tidak Terbaik', 1),
(7, 'Rendah', 'Sedang', 'Buruk', 'Sering Telat', 'Lama', 'Tidak Terbaik', 2),
(8, 'Tinggi', 'Jarang', 'Sangat Baik', 'Tepat Waktu', 'Baru', 'Tidak Terbaik', 1),
(9, 'Sedang', 'Sedang', 'Buruk', 'Sering Telat', 'Lama', 'Tidak Terbaik', 4);

-- --------------------------------------------------------

--
-- Table structure for table `lady_yakult`
--

CREATE TABLE `lady_yakult` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `umur` int(11) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `telepon` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lady_yakult`
--

INSERT INTO `lady_yakult` (`id`, `nama`, `umur`, `alamat`, `telepon`, `email`, `tanggal_lahir`) VALUES
(1, 'Rogayah', 25, 'Jl. Merdeka No. 12, Jakarta', '08123456789', 'andi@email.com', '1998-05-15'),
(2, 'Sukimah', 30, 'Jl. Cendana No. 8, Bandung', '08223456789', 'budi@email.com', '1993-02-20'),
(3, 'Siti Aisyah', 22, 'Jl. Raya No. 5, Surabaya', '08323456789', 'siti@email.com', '2001-08-10'),
(4, 'Rina Anggraini', 28, 'Jl. Mangga No. 15, Yogyakarta', '08423456789', 'rina@email.com', '1995-11-25'),
(5, 'Nurbayan', 35, 'Jl. Pahlawan No. 3, Semarang', '08523456789', 'joko@email.com', '1988-03-02'),
(6, 'Rachma', 24, 'Jakarta', '089123123123', 'rachmazi@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `password`, `fullname`, `created_at`, `updated_at`) VALUES
(1, 'john_doe', 'john@example.com', 'password123', 'John Doe', '2025-05-14 12:34:16', '2025-05-14 12:34:16'),
(2, 'jane_smith', 'jane@example.com', 'password456', 'Jane Smith', '2025-05-14 12:34:16', '2025-05-14 12:34:16'),
(3, 'admin', 'admin@example.com', 'admin', 'Administrator', '2025-05-14 12:34:16', '2025-05-14 12:36:02'),
(4, 'budi123', 'budi@example.com', 'rahasiabudi', 'Budi Santoso', '2025-05-14 12:34:16', '2025-05-14 12:34:16'),
(5, 'sari89', 'sari@example.com', 'sari12345', 'Sari Indah', '2025-05-14 12:34:16', '2025-05-14 12:34:16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_training`
--
ALTER TABLE `data_training`
  ADD PRIMARY KEY (`id`),
  ADD KEY `lady_yakult_id` (`lady_yakult_id`);

--
-- Indexes for table `lady_yakult`
--
ALTER TABLE `lady_yakult`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_training`
--
ALTER TABLE `data_training`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `lady_yakult`
--
ALTER TABLE `lady_yakult`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_training`
--
ALTER TABLE `data_training`
  ADD CONSTRAINT `data_training_ibfk_1` FOREIGN KEY (`lady_yakult_id`) REFERENCES `lady_yakult` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
