declare @ogretmen_id int =3 --buraya ??retmenin id de?eri girilecek

declare @ders_id int
declare @ortalama float
declare @toplam float

declare dersler cursor for

select ogretmen_ders.d_id from ogretmen_ders where ogretmen_ders.o_id=@ogretmen_id

open dersler

fetch next from dersler into @ders_id

while @@FETCH_STATUS =0
	begin

	select (select ders.d_adi as 'Ders Ad?' from ders where d_id=@ders_id) as 'Ders', 
	COUNT(ogrenci_ders.notu) as 'Toplam', AVG(ogrenci_ders.notu) as 'Ortalama' 
	from ogrenci_ders where d_id=@ders_id

	fetch next from dersler into @ders_id
	end

close dersler
deallocate dersler

