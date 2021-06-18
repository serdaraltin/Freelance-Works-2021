
--bilgisayar m�hendisli�i
Create view dekan_Bil_Muh_goruntu
As
SELECT        dbo.ogrenci.o_no AS '��renci No', dbo.ogrenci.adi AS '��renci Ad', dbo.ogrenci.soyadi AS '��renci Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu  AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.ogrenci INNER JOIN
                         dbo.bolum ON dbo.ogrenci.b_id = dbo.bolum.b_id INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ogrenci.o_no = dbo.ogrenci_ders.o_no AND dbo.ders.d_id = dbo.ogrenci_ders.d_id
						 where bolum.b_id = 1

SELECT        dbo.ogretmen.adi AS '��retmen Ad', dbo.ogretmen.soyadi AS '��retmen Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.bolum INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogretmen ON dbo.bolum.b_id = dbo.ogretmen.b_id
						 where bolum.b_id = 1

--elektronik m�hendisli�i
Create view dekan_Elo_Muh_goruntu
As
SELECT        dbo.ogrenci.o_no AS '��renci No', dbo.ogrenci.adi AS '��renci Ad', dbo.ogrenci.soyadi AS '��renci Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu  AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.ogrenci INNER JOIN
                         dbo.bolum ON dbo.ogrenci.b_id = dbo.bolum.b_id INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ogrenci.o_no = dbo.ogrenci_ders.o_no AND dbo.ders.d_id = dbo.ogrenci_ders.d_id
						 where bolum.b_id = 2

SELECT        dbo.ogretmen.adi AS '��retmen Ad', dbo.ogretmen.soyadi AS '��retmen Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.bolum INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogretmen ON dbo.bolum.b_id = dbo.ogretmen.b_id
						 where bolum.b_id = 

--�evre m�hendisli�i
Create view dekan_Cev_Muh_goruntu
As
SELECT        dbo.ogrenci.o_no AS '��renci No', dbo.ogrenci.adi AS '��renci Ad', dbo.ogrenci.soyadi AS '��renci Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu  AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.ogrenci INNER JOIN
                         dbo.bolum ON dbo.ogrenci.b_id = dbo.bolum.b_id INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ogrenci.o_no = dbo.ogrenci_ders.o_no AND dbo.ders.d_id = dbo.ogrenci_ders.d_id
						 where bolum.b_id = 3

SELECT        dbo.ogretmen.adi AS '��retmen Ad', dbo.ogretmen.soyadi AS '��retmen Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.bolum INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogretmen ON dbo.bolum.b_id = dbo.ogretmen.b_id
						 where bolum.b_id = 3		

--endit�ri m�hendisli�i
Create view dekan_End_Muh_goruntu
As
SELECT        dbo.ogrenci.o_no AS '��renci No', dbo.ogrenci.adi AS '��renci Ad', dbo.ogrenci.soyadi AS '��renci Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu  AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.ogrenci INNER JOIN
                         dbo.bolum ON dbo.ogrenci.b_id = dbo.bolum.b_id INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogrenci_ders ON dbo.ogrenci.o_no = dbo.ogrenci_ders.o_no AND dbo.ders.d_id = dbo.ogrenci_ders.d_id
						 where bolum.b_id = 4

SELECT        dbo.ogretmen.adi AS '��retmen Ad', dbo.ogretmen.soyadi AS '��retmen Soyad', dbo.ders.d_adi AS 'Ders Ad', dbo.ders.d_kodu AS 'Ders Kod', dbo.ders.kredi AS 'Ders Kredi'
FROM            dbo.bolum INNER JOIN
                         dbo.ders ON dbo.bolum.b_id = dbo.ders.b_id INNER JOIN
                         dbo.ogretmen ON dbo.bolum.b_id = dbo.ogretmen.b_id
						 where bolum.b_id = 4