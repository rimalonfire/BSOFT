-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2018 at 01:05 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clientdatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientpersonalinfo`
--

CREATE TABLE `clientpersonalinfo` (
  `ClientID` int(20) NOT NULL,
  `ClientFirstName` text NOT NULL,
  `ClientMiddleName` text NOT NULL,
  `ClientLastName` text NOT NULL,
  `ClientDateofBirth` date NOT NULL,
  `ClientSex` varchar(10) NOT NULL,
  `ClientDistrict` text NOT NULL,
  `ClientCity` text NOT NULL,
  `ClientWardNum` int(11) NOT NULL,
  `ClientCitizenshipNum` bigint(25) NOT NULL,
  `ClientContactNum` bigint(15) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientpersonalinfo`
--

INSERT INTO `clientpersonalinfo` (`ClientID`, `ClientFirstName`, `ClientMiddleName`, `ClientLastName`, `ClientDateofBirth`, `ClientSex`, `ClientDistrict`, `ClientCity`, `ClientWardNum`, `ClientCitizenshipNum`, `ClientContactNum`, `isDeleted`) VALUES
(100, 'Admin', 'Admin', 'Admin', '2016-01-01', 'Admin', 'Admin', 'Admin', 100, 100, 100, 0),
(111, 'Firstname', 'Middlename*', 'Lastname', '2018-07-22', 'Male', 'District', 'City', 0, 0, 0, 1),
(112, 'FirstName', 'Middlename*', 'Lastname', '2018-07-25', 'Male', 'District', 'City', 12, 15, 16, 1),
(113, 'Firstname', 'Middlename*', 'Lastname', '2018-07-31', 'Male', 'District', 'City', 0, 0, 0, 1),
(114, 'Firstname', 'Middlename*', 'Lastname', '2018-07-31', 'Male', 'District', 'City', 0, 0, 0, 1),
(115, 'Firstname', 'Middlename*', 'Lastname', '2018-08-01', 'Male', 'District', 'City', 0, 0, 0, 1),
(116, 'Firstname', 'Middlename*', 'Lastname', '2018-08-01', 'Male', 'District', 'City', 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientpersonalinfo`
--
ALTER TABLE `clientpersonalinfo`
  ADD PRIMARY KEY (`ClientID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientpersonalinfo`
--
ALTER TABLE `clientpersonalinfo`
  MODIFY `ClientID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
