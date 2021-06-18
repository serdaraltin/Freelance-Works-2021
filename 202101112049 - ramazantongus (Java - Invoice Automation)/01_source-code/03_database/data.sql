-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CARI_KART`
--

DROP TABLE IF EXISTS `CARI_KART`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CARI_KART` (
  `ID` varchar(0) DEFAULT NULL,
  `UNVANI` varchar(0) DEFAULT NULL,
  `ADRES_1` varchar(0) DEFAULT NULL,
  `ADRES_2` varchar(0) DEFAULT NULL,
  `VERGI_DAIRESI` varchar(0) DEFAULT NULL,
  `VERGI_NO` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CARI_KART`
--

LOCK TABLES `CARI_KART` WRITE;
/*!40000 ALTER TABLE `CARI_KART` DISABLE KEYS */;
/*!40000 ALTER TABLE `CARI_KART` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SABLON`
--

DROP TABLE IF EXISTS `SABLON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SABLON` (
  `ID` tinyint(4) DEFAULT NULL,
  `ACIKLAMA` varchar(46) DEFAULT NULL,
  `DOSYA_YOLU` varchar(52) DEFAULT NULL,
  `ISLEM_YERI` tinyint(4) DEFAULT NULL,
  `SORGU_GRUP` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SABLON`
--

LOCK TABLES `SABLON` WRITE;
/*!40000 ALTER TABLE `SABLON` DISABLE KEYS */;
INSERT INTO `SABLON` VALUES (1,'1- Fatura Açýklamalý (A4)','C:Ebs YazilimFaturaV208Rapor1.fr3',1,0),(2,'2- Fatura Açýklamalý Toplam Sayfa Sonunda (A4)','C:Ebs YazilimFaturaV208Rapor2.fr3',1,0),(3,'3- Fatura Açýklamalý (A5)','C:Ebs YazilimFaturaV208Rapor3.fr3',1,0),(4,'4- Fatura Açýklamalý Toplam Sayfa Sonunda (A5)','C:Ebs YazilimFaturaV208Rapor4.fr3',1,0),(5,'5- Fatura Standart (A4)','C:Ebs YazilimFaturaV208Rapor5.fr3',1,0),(6,'6- Fatura Standart Toplam Sayfa Sonunda (A4)','C:Ebs YazilimFaturaV208Rapor6.fr3',1,0),(7,'7- Fatura Standart (A5)','C:Ebs YazilimFaturaV208Rapor7.fr3',1,0),(8,'8- Fatura Standart Toplam Sayfa Sonunda (A5)','C:Ebs YazilimFaturaV208Rapor8.fr3',1,0),(9,'9- Ýrsaliye Standart (A4)','C:Ebs YazilimFaturaV208Rapor9.fr3',1,0),(10,'10- Ýrsaliye Standart (A5)','C:Ebs YazilimFaturaV208Rapor10.fr3',1,0),(11,'11-Fatura Kdv Grup (A4)','C:Ebs YazilimFaturaV208Rapor11.fr3',1,0),(12,'12- Fatura Kdv Grup Toplam Sayfa Sonunda (A4)','C:Ebs YazilimFaturaV208Rapor12.fr3',1,0),(13,'13-Fatura Kdv Grup (A5)','C:Ebs YazilimFaturaV208Rapor13.fr3',1,0),(14,'14- Fatura Kdv Grup Toplam Sayfa Sonunda (A5)','C:Ebs YazilimFaturaV208Rapor14.fr3',1,0),(15,'15- Fatura Devirli- Tasarým 1','C:Ebs YazilimFaturaV208Rapor15.fr3',1,0),(16,'16- Fatura Devirli- Tasarým 2','C:Ebs YazilimFaturaV208Rapor16.fr3',1,0),(17,'17- Fatura Devirli- Tasarým 3','C:Ebs YazilimFaturaV208Rapor17.fr3',1,0),(18,'18- Fatura Devirli- Tasarým 4','C:Ebs YazilimFaturaV208Rapor18.fr3',1,0),(19,'19-  Fatura Tevkifatlý - Tasarým 1','C:Ebs YazilimFaturaV208Rapor19.fr3',1,0),(20,'20-  Fatura Tevkifatlý - Tasarým 2','C:Ebs YazilimFaturaV208Rapor20.fr3',1,0),(21,'21-  Fatura Tevkifatlý - Tasarým 3','C:Ebs YazilimFaturaV208Rapor21.fr3',1,0),(22,'22-  Fatura Tevkifatlý - Tasarým 4','C:Ebs YazilimFaturaV208Rapor22.fr3',1,0),(23,'23-Fatura Alan Vergi - Tasarým 1','C:Ebs YazilimFaturaV208Rapor23.fr3',1,0),(24,'24-Fatura Alan Vergi - Tasarým 2','C:Ebs YazilimFaturaV208Rapor24.fr3',1,0),(25,'25-Fatura Alan Vergi - Tasarým 3','C:Ebs YazilimFaturaV208Rapor25.fr3',1,0),(26,'26-Fatura Alan Vergi - Tasarým 4','C:Ebs YazilimFaturaV208Rapor26.fr3',1,0),(27,'27-Proforma Fatura','C:Ebs YazilimFaturaV208RaporProforma_Fatura.fr3',1,0);
/*!40000 ALTER TABLE `SABLON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SATIS_FATURASI_ALT`
--

DROP TABLE IF EXISTS `SATIS_FATURASI_ALT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SATIS_FATURASI_ALT` (
  `ID` varchar(0) DEFAULT NULL,
  `TARIH` varchar(0) DEFAULT NULL,
  `FATURA_ID` varchar(0) DEFAULT NULL,
  `STOK_KART_ID` varchar(0) DEFAULT NULL,
  `STOK_KODU` varchar(0) DEFAULT NULL,
  `STOK_ADI` varchar(0) DEFAULT NULL,
  `MIKTAR` varchar(0) DEFAULT NULL,
  `BIRIM` varchar(0) DEFAULT NULL,
  `BIRIM_FIYAT` varchar(0) DEFAULT NULL,
  `ISKONTO_ORANI` varchar(0) DEFAULT NULL,
  `ISK_TUTAR` varchar(0) DEFAULT NULL,
  `ALT_ISK` varchar(0) DEFAULT NULL,
  `ALT_ISK_TUTAR` varchar(0) DEFAULT NULL,
  `KDV_DURUM` varchar(0) DEFAULT NULL,
  `KDV_ORANI` varchar(0) DEFAULT NULL,
  `TUTAR` varchar(0) DEFAULT NULL,
  `KDV_TUTARI` varchar(0) DEFAULT NULL,
  `INDIRIM_TUTARI` varchar(0) DEFAULT NULL,
  `MATRAH` varchar(0) DEFAULT NULL,
  `KDVLI_MATRAH` varchar(0) DEFAULT NULL,
  `SATIR_FIYAT` varchar(0) DEFAULT NULL,
  `SATIR_TUTAR` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SATIS_FATURASI_ALT`
--

LOCK TABLES `SATIS_FATURASI_ALT` WRITE;
/*!40000 ALTER TABLE `SATIS_FATURASI_ALT` DISABLE KEYS */;
/*!40000 ALTER TABLE `SATIS_FATURASI_ALT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SATIS_FATURASI_UST`
--

DROP TABLE IF EXISTS `SATIS_FATURASI_UST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SATIS_FATURASI_UST` (
  `ID` varchar(0) DEFAULT NULL,
  `CARI_KART_ID` varchar(0) DEFAULT NULL,
  `TARIH` varchar(0) DEFAULT NULL,
  `SAAT` varchar(0) DEFAULT NULL,
  `SERI` varchar(0) DEFAULT NULL,
  `EVRAK_NO` varchar(0) DEFAULT NULL,
  `VADE_TARIHI` varchar(0) DEFAULT NULL,
  `VADE` varchar(0) DEFAULT NULL,
  `SEVK_TARIHI` varchar(0) DEFAULT NULL,
  `SEVK_NO` varchar(0) DEFAULT NULL,
  `UNVANI` varchar(0) DEFAULT NULL,
  `ADRES_1` varchar(0) DEFAULT NULL,
  `ADRES_2` varchar(0) DEFAULT NULL,
  `VERGI_DAIRESI` varchar(0) DEFAULT NULL,
  `VERGI_NO` varchar(0) DEFAULT NULL,
  `TOPLAM` varchar(0) DEFAULT NULL,
  `ISKONTO_TOPLAM` varchar(0) DEFAULT NULL,
  `MATRAH` varchar(0) DEFAULT NULL,
  `KDV_TOPLAM` varchar(0) DEFAULT NULL,
  `GENEL_TOPLAM` varchar(0) DEFAULT NULL,
  `TESLIM_EDEN` varchar(0) DEFAULT NULL,
  `TESLIM_ALAN` varchar(0) DEFAULT NULL,
  `ACIKLAMA` varchar(0) DEFAULT NULL,
  `OZEL_ALAN_1` varchar(0) DEFAULT NULL,
  `OZEL_ALAN_2` varchar(0) DEFAULT NULL,
  `ALT_ISK_ORAN` varchar(0) DEFAULT NULL,
  `ALT_ISK_TUTAR` varchar(0) DEFAULT NULL,
  `ISLEM` varchar(0) DEFAULT NULL,
  `YUVARLA` varchar(0) DEFAULT NULL,
  `TEVKIFAT_PAY` varchar(0) DEFAULT NULL,
  `TEVKIFAT_PAYDA` varchar(0) DEFAULT NULL,
  `TEVKIFAT` varchar(0) DEFAULT NULL,
  `ALAN_VERGISI` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SATIS_FATURASI_UST`
--

LOCK TABLES `SATIS_FATURASI_UST` WRITE;
/*!40000 ALTER TABLE `SATIS_FATURASI_UST` DISABLE KEYS */;
/*!40000 ALTER TABLE `SATIS_FATURASI_UST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STOK_KARTI`
--

DROP TABLE IF EXISTS `STOK_KARTI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STOK_KARTI` (
  `ID` varchar(0) DEFAULT NULL,
  `STOK_KODU` varchar(0) DEFAULT NULL,
  `STOK_ADI` varchar(0) DEFAULT NULL,
  `KDV` varchar(0) DEFAULT NULL,
  `BIRIM` varchar(0) DEFAULT NULL,
  `BIRIM_FIYAT` varchar(0) DEFAULT NULL,
  `KDV_DURUM` varchar(0) DEFAULT NULL,
  `OZEL_ALAN` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STOK_KARTI`
--

LOCK TABLES `STOK_KARTI` WRITE;
/*!40000 ALTER TABLE `STOK_KARTI` DISABLE KEYS */;
/*!40000 ALTER TABLE `STOK_KARTI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TANIMLAR`
--

DROP TABLE IF EXISTS `TANIMLAR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TANIMLAR` (
  `ID` tinyint(4) DEFAULT NULL,
  `SERI` varchar(1) DEFAULT NULL,
  `FATURA_NO` smallint(6) DEFAULT NULL,
  `PARA_ONDALIK` tinyint(4) DEFAULT NULL,
  `MIKTAR_ONDALIK` tinyint(4) DEFAULT NULL,
  `VARSAYILAN_KDV` tinyint(4) DEFAULT NULL,
  `VARSAYILAN_KDV_DURUM` tinyint(4) DEFAULT NULL,
  `DIP_NOTLAR` bigint(20) DEFAULT NULL,
  `VARSAYILAN_ACIKLAMA` bigint(20) DEFAULT NULL,
  `TEVKIFAT_PAY` tinyint(4) DEFAULT NULL,
  `TEVKIFAT_PAYDA` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TANIMLAR`
--

LOCK TABLES `TANIMLAR` WRITE;
/*!40000 ALTER TABLE `TANIMLAR` DISABLE KEYS */;
INSERT INTO `TANIMLAR` VALUES (4,'A',1011,2,2,18,1,566935683080,566935683084,0,0);
/*!40000 ALTER TABLE `TANIMLAR` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-22 15:20:26
