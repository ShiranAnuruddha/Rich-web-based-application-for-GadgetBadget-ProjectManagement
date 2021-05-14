-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 06:42 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `projectID` int(10) NOT NULL,
  `authorName` varchar(200) NOT NULL,
  `projectCategory` varchar(100) NOT NULL,
  `projectName` varchar(100) NOT NULL,
  `projectPrice` decimal(5,2) NOT NULL,
  `authorEmail` varchar(100) NOT NULL,
  `projectDesc` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`projectID`, `authorName`, `projectCategory`, `projectName`, `projectPrice`, `authorEmail`, `projectDesc`) VALUES
(2, 'Shiran Fernando', 'Aircraft', 'How to fly a Aircraft', '300.00', 'shiran@gmail.com', 'This projects helps to beginers who loves to fly a aircraft'),
(5, 'Sesath Gajanayake', 'IT', 'Time table management', '200.00', 'gaje@gmail.com', 'This is a fully automated time table generated system. '),
(17, 'Nipul ', 'Web Design', 'How to create a web page', '40.00', 'anu@gmail.com', 'This is help to new learners to creating the simple web page');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`projectID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `projectID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
