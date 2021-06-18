CREATE DATABASE VT_Okul

USE VT_Okul
--
-- bolum tablosu
--

CREATE TABLE bolum (
  b_id  int PRIMARY KEY,
  b_adi nvarchar(30)NOT NULL,
  aciklama nvarchar(50),
  eposta nvarchar(30),
)

--
-- bolum verileri
--

INSERT INTO bolum (b_id, b_adi, aciklama, eposta) VALUES
(1, 'Bil. Müh.', 'Bilgisayar Mühendisliği Bölümü', 'ceng@gelisim.edu.tr'),
(2, 'Elo. Müh.', 'Elektronik Mühendisliği Bölümü', 'ee@gelisim.edu.tr'),
(3, 'Çev. Müh.', 'Çevre Mühendisliği Bölümü', 'env@gelisim.edu.tr'),
(4, 'End. Müh.', 'Endüstri Mühendisliği Bölümü', 'ie@gelisim.edu.tr');

-- --------------------------------------------------------

--
-- ders tablosu
--

CREATE TABLE ders (
  d_id int PRIMARY Key,
  d_adi nvarchar(30),
  d_kodu nvarchar(50),
  kredi int,
  b_id int foreign key references bolum(b_id),
) 

--
-- ders verileri
--

INSERT INTO ders (d_id, d_adi, d_kodu, kredi, b_id) VALUES
(1, 'Veritabanı', 'CENG 351', 3, 1),
(2, 'İşletim Sistemleri', 'CENG 341', 3, 1),
(3, 'Programlamaya Giriş', 'CENG 101', 4, 1),
(4, 'Elektroniğe Giriş', 'EE 101', 2, 2),
(5, 'İstatistik', 'IE 301', 4, 4),
(6, 'Devre Teorisi', 'EE 202', 3, 2),
(7, 'Çevre Bilgisi', 'ENV 102', 3, 3),
(8, 'Yöneylem Araştırması', 'IE 208', 3, 4),
(9, 'Yaz Stajı', 'IE 299', 2, 4),
(10, 'Yaz Stajı', 'ENV 299', 3, 3),
(11, 'Yaz Stajı', 'CENG 299', 3, 1),
(12, 'Yaz Stajı', 'EE 299', 3, 2),
(13, 'Test Course', 'TEST 101', 9, 1);

-- --------------------------------------------------------

--
-- ogrenci tablosu
--

CREATE TABLE ogrenci (
  o_no int primary key,
  adi nvarchar(30),
  soyadi nvarchar(30),
  d_yeri nvarchar(50),
  b_id int foreign key references bolum(b_id),
) 

--
-- ogrenci verileri
--

INSERT INTO ogrenci (o_no, adi, soyadi, d_yeri, b_id) VALUES
(1, 'Ali', 'Turan', 'İstanbul', 1),
(2, 'Ahmet', 'Büyük', 'Ankara', 1),
(3, 'Leyla', 'Şahin', 'İzmir', 1),
(4, 'Can', 'Türkoğlu', 'Manisa', 2),
(5, 'Aziz', 'Keskin', 'İstanbul', 2),
(6, 'Talat', 'Şanlı', 'İzmir', 3),
(7, 'Kamuran', 'Kece', 'Adana', 3),
(8, 'Turgut', 'Cemal', 'Bursa', 4),
(9, 'Öznur', 'Güneş', 'Bolu', 2),
(10, 'Pelin', 'Tugay', 'İzmir', 4),
(11, 'Savaş', 'Tan', 'İzmir', 4);

-- --------------------------------------------------------

--
-- ogrenci_ders tablosu
--

CREATE TABLE ogrenci_ders (
  o_no int foreign key references ogrenci(o_no),
  d_id int foreign key references ders(d_id),
  notu float,
)


--
-- ogrenci_ders verileri
--

INSERT INTO ogrenci_ders (o_no, d_id, notu) VALUES
(1, 1, 3),
(1, 3, 2.5),
(1, 4, 3.5),
(1, 6, 3),
(1, 9, 4),
(1, 10, 3),
(2, 1, 4),
(2, 2, 4),
(2, 3, 4),
(2, 4, 4),
(2, 5, 4),
(2, 6, 4),
(2, 7, 4),
(2, 8, 4),
(2, 9, 4),
(2, 10, 3),
(2, 11, 4),
(3, 1, 4),
(3, 2, 4),
(3, 3, 4),
(3, 4, 4),
(3, 5, 4),
(3, 6, 4),
(3, 7, 4),
(3, 8, 4),
(3, 9, 4),
(3, 10, 3),
(3, 11, 3.5),
(4, 1, 2.5),
(4, 5, 1.5),
(5, 1, 3),
(5, 2, NULL),
(5, 3, NULL),
(5, 5, 1.5),
(5, 11, 3.5),
(5, 13, NULL),
(6, 2, 4),
(7, 1, 2.5),
(7, 2, 3),
(7, 5, 1.5),
(7, 8, 1.5),
(8, 2, 3.5),
(8, 7, 1.5),
(9, 1, NULL),
(10, 2, 4),
(10, 8, 3),
(11, 8, 1);

-- --------------------------------------------------------

--
-- ogretmen tablosu
--

CREATE TABLE ogretmen (
  o_id int primary key,
  adi nvarchar(30),
  soyadi nvarchar(30),
  d_yeri nvarchar(50),
  b_id int foreign key references bolum(b_id),

)

--
-- ogretmen verileri
--

INSERT INTO ogretmen (o_id, adi, soyadi, d_yeri, b_id) VALUES
(1, 'Selami', 'Durgun', 'Amasya', 1),
(2, 'Cengiz', 'Tahir', 'İstanbul', 1),
(3, 'Derya', 'Seçkin', 'Mersin', 1),
(4, 'Doğan', 'Gedikli', 'İstanbul', 2),
(5, 'Ayten', 'Kahraman', 'İstanbul', 3),
(6, 'Tahsin', 'Uğur', 'İzmir', 4),
(7, 'Selçuk', 'Ozan', 'Amasya', 4);

-- --------------------------------------------------------

--
-- ogretmen_ders tablosu
--

CREATE TABLE ogretmen_ders (
  o_id int foreign key references ogretmen(o_id),
  d_id int foreign key references ders(d_id),
)

--
-- ogretmen_ders verileri
--

INSERT INTO ogretmen_ders (o_id, d_id) VALUES
(1, 1),
(3, 2),
(2, 3),
(4, 4),
(7, 5),
(4, 6),
(5, 7),
(6, 8),
(7, 9),
(5, 10),
(1, 11),
(4, 12);


