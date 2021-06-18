--soru-1 kýsým 1

--bilgisayar mühendisliði
Create view dekan_Bil_Muh_goruntu
As
SELECT        dbo.ogrenci.o_no AS 'Öðrenci No', dbo.ogrenci.adi AS 'Öðrenci Ad', dbo.ogrenci.soyadi AS 'Öðrenci Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu  AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.ogrenci INNER JOIN
                         dbo.bolum ON dbo.ogrenci.b_id = dbo.bolum.b_id INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ogrenci.o_no = dbo.ogrenci_ders.o_no AND dbo.ders.d_id = dbo.ogrenci_ders.d_id
						 where bolum.b_id = 1

SELECT        dbo.ogretmen.adi AS 'Öðretmen Ad', dbo.ogretmen.soyadi AS 'Öðretmen Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.bolum INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogretmen ON dbo.bolum.b_id = dbo.ogretmen.b_id
						 where bolum.b_id = 1

--elektronik mühendisliði
Create view dekan_Elo_Muh_goruntu
As
SELECT        dbo.ogrenci.o_no AS 'Öðrenci No', dbo.ogrenci.adi AS 'Öðrenci Ad', dbo.ogrenci.soyadi AS 'Öðrenci Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu  AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.ogrenci INNER JOIN
                         dbo.bolum ON dbo.ogrenci.b_id = dbo.bolum.b_id INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ogrenci.o_no = dbo.ogrenci_ders.o_no AND dbo.ders.d_id = dbo.ogrenci_ders.d_id
						 where bolum.b_id = 2

SELECT        dbo.ogretmen.adi AS 'Öðretmen Ad', dbo.ogretmen.soyadi AS 'Öðretmen Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.bolum INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogretmen ON dbo.bolum.b_id = dbo.ogretmen.b_id
						 where bolum.b_id = 

--çevre mühendisliði
Create view dekan_Cev_Muh_goruntu
As
SELECT        dbo.ogrenci.o_no AS 'Öðrenci No', dbo.ogrenci.adi AS 'Öðrenci Ad', dbo.ogrenci.soyadi AS 'Öðrenci Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu  AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.ogrenci INNER JOIN
                         dbo.bolum ON dbo.ogrenci.b_id = dbo.bolum.b_id INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ogrenci.o_no = dbo.ogrenci_ders.o_no AND dbo.ders.d_id = dbo.ogrenci_ders.d_id
						 where bolum.b_id = 3

SELECT        dbo.ogretmen.adi AS 'Öðretmen Ad', dbo.ogretmen.soyadi AS 'Öðretmen Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.bolum INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogretmen ON dbo.bolum.b_id = dbo.ogretmen.b_id
						 where bolum.b_id = 3		

--enditüri mühendisliði
Create view dekan_End_Muh_goruntu
As
SELECT        dbo.ogrenci.o_no AS 'Öðrenci No', dbo.ogrenci.adi AS 'Öðrenci Ad', dbo.ogrenci.soyadi AS 'Öðrenci Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu  AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.ogrenci INNER JOIN
                         dbo.bolum ON dbo.ogrenci.b_id = dbo.bolum.b_id INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ogrenci.o_no = dbo.ogrenci_ders.o_no AND dbo.ders.d_id = dbo.ogrenci_ders.d_id
						 where bolum.b_id = 4

SELECT        dbo.ogretmen.adi AS 'Öðretmen Ad', dbo.ogretmen.soyadi AS 'Öðretmen Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.bolum INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogretmen ON dbo.bolum.b_id = dbo.ogretmen.b_id
						 where bolum.b_id = 4

----------------------------------------------------------

--soru-1 kýsým 2

--öðretmen Cengiz Tahir
Create view ogretmen_cengiz_gortuntu
As
SELECT        dbo.ogretmen.adi AS [Öðretmen Ad], dbo.ogretmen.soyadi AS [Öðretmen Soyad], dbo.ogrenci.o_no AS [Öðrenci No], dbo.ogrenci.adi AS [Öðrenci Ad], dbo.ogrenci.soyadi AS [Öðrenci Soyad], dbo.ders.d_adi AS [Ders Ad], 
                         dbo.ders.d_kodu AS [Ders Kodu]
FROM            dbo.ogretmen_ders INNER JOIN
                         dbo.ogretmen ON dbo.ogretmen_ders.o_id = dbo.ogretmen.o_id INNER JOIN
                         dbo.ders ON dbo.ogretmen_ders.d_id = dbo.ders.d_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ders.d_id = dbo.ogrenci_ders.d_id INNER JOIN
                         dbo.ogrenci ON dbo.ogrenci_ders.o_no = dbo.ogrenci.o_no
WHERE        (dbo.ogretmen.o_id = 2) 

--öðretmen Derya Seçkin
Create view ogretmen_cengiz_gortuntu
As
SELECT        dbo.ogretmen.adi AS [Öðretmen Ad], dbo.ogretmen.soyadi AS [Öðretmen Soyad], dbo.ogrenci.o_no AS [Öðrenci No], dbo.ogrenci.adi AS [Öðrenci Ad], dbo.ogrenci.soyadi AS [Öðrenci Soyad], dbo.ders.d_adi AS [Ders Ad], 
                         dbo.ders.d_kodu AS [Ders Kodu]
FROM            dbo.ogretmen_ders INNER JOIN
                         dbo.ogretmen ON dbo.ogretmen_ders.o_id = dbo.ogretmen.o_id INNER JOIN
                         dbo.ders ON dbo.ogretmen_ders.d_id = dbo.ders.d_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ders.d_id = dbo.ogrenci_ders.d_id INNER JOIN
                         dbo.ogrenci ON dbo.ogrenci_ders.o_no = dbo.ogrenci.o_no
WHERE        (dbo.ogretmen.o_id = 3) 


--öðretmen Ayten Kahraman
Create view ogretmen_cengiz_gortuntu
As
SELECT        dbo.ogretmen.adi AS [Öðretmen Ad], dbo.ogretmen.soyadi AS [Öðretmen Soyad], dbo.ogrenci.o_no AS [Öðrenci No], dbo.ogrenci.adi AS [Öðrenci Ad], dbo.ogrenci.soyadi AS [Öðrenci Soyad], dbo.ders.d_adi AS [Ders Ad], 
                         dbo.ders.d_kodu AS [Ders Kodu]
FROM            dbo.ogretmen_ders INNER JOIN
                         dbo.ogretmen ON dbo.ogretmen_ders.o_id = dbo.ogretmen.o_id INNER JOIN
                         dbo.ders ON dbo.ogretmen_ders.d_id = dbo.ders.d_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ders.d_id = dbo.ogrenci_ders.d_id INNER JOIN
                         dbo.ogrenci ON dbo.ogrenci_ders.o_no = dbo.ogrenci.o_no
WHERE        (dbo.ogretmen.o_id = 5) 


--soru-2
declare @ogretmen_id int =3 --buraya öðretmenin id deðeri girilecek

declare @ders_id int
declare @ortalama float
declare @toplam float

declare dersler cursor for

select ogretmen_ders.d_id from ogretmen_ders where ogretmen_ders.o_id=@ogretmen_id

open dersler

fetch next from dersler into @ders_id

while @@FETCH_STATUS =0
	begin

	select (select ders.d_adi as 'Ders Adý' from ders where d_id=@ders_id) as 'Ders', 
	COUNT(ogrenci_ders.notu) as 'Toplam', AVG(ogrenci_ders.notu) as 'Ortalama' 
	from ogrenci_ders where d_id=@ders_id

	fetch next from dersler into @ders_id
	end

close dersler
deallocate dersler
 
 
--soru3

--ogretmen tablosu icin
Create TRIGGER trg_ogretmen_ekleme
   ON ogretmen
   AFTER INSERT
AS 
BEGIN
	Select * From ogretmen
END

--ogrenci tablosu icin
Create TRIGGER trg_ogrenci_ekleme
   ON ogrenci
   AFTER INSERT
AS 
BEGIN
	Select * From ogrenci
END

