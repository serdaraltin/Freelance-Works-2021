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


