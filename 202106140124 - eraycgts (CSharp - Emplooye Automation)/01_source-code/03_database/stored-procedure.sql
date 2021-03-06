CREATE Proc [dbo].[departman_Ekle]
@ad varchar(50),
@amac varchar(50),
@aciklama text

As
Begin
Insert Into departman (ad,amac,aciklama) Values(@ad,@amac,@aciklama)
End

CREATE Proc [dbo].[departman_Guncelle]
@Id int,
@ad varchar(50),
@amac varchar(50),
@aciklama text

As
Begin
Update departman Set ad=@ad,amac=@amac,aciklama=@aciklama
Where Id=@Id
End

Create Proc [dbo].[Getir]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Select *From '+ @Tablo+' Where Id='+@Id)
End

Create Proc [dbo].[izin_Ekle]
@personelId int,
@tur varchar(50),
@aciklama text,
@baslangicTarih varchar(50),
@bitisTarih varchar(50)

As
Begin
Insert Into izin (personelId,tur,aciklama,baslangicTarih,bitisTarih) Values(@personelId,@tur,@aciklama,@baslangicTarih,@bitisTarih)
End

Create Proc [dbo].[izin_Guncelle]
@Id int,
@personelId int,
@tur varchar(50),
@aciklama text,
@baslangicTarih varchar(50),
@bitisTarih varchar(50)

As
Begin
Update izin Set personelId=@personelId,tur=@tur,aciklama=@aciklama,baslangicTarih=@baslangicTarih,bitisTarih=@bitisTarih
Where Id=@Id
End

Create Proc [dbo].[Kayitlar]
@Tablo varchar(50)
As
Begin
	EXEC('Select * From ' + @Tablo)
End

SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[kullanici_Ekle]
@kullaniciAd varchar(50),
@parola varchar(50)

As
Begin
Insert Into kullanici (kullaniciAd,parola) Values(@kullaniciAd,@parola)
End

Create Proc [dbo].[kullanici_Guncelle]
@Id int,
@kullaniciAd varchar(50),
@parola varchar(50)

As
Begin
Update kullanici Set kullaniciAd=@kullaniciAd,parola=@parola
Where Id=@Id
End

Create Proc [dbo].[Kullanici_Kontrol]
@kullaniciAd varchar(50),
@parola varchar(50)

As
Begin
Select *From kullanici Where kullaniciAd=@kullaniciAd and parola=@parola
End

Create Proc [dbo].[mesai_Ekle]
@personelId int,
@tarih varchar(50),
@sure int,
@ucret int

As
Begin
Insert Into mesai (personelId,tarih,sure,ucret) Values(@personelId,@tarih,@sure,@ucret)
End

Create Proc [dbo].[mesai_Guncelle]
@Id int,
@personelId int,
@tarih varchar(50),
@sure int,
@ucret int

As
Begin
Update mesai Set personelId=@personelId,tarih=@tarih,sure=@sure,ucret=@ucret
Where Id=@Id
End

Create Proc [dbo].[personel_Ekle]
@tcNo varchar(50),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(50),
@eposta varchar(50),
@adres text,
@departmanId int,
@maas int

As
Begin
Insert Into personel (tcNo,ad,soyad,telefon,eposta,adres,departmanId,maas) Values(@tcNo,@ad,@soyad,@telefon,@eposta,@adres,@departmanId,@maas)
End

Create Proc [dbo].[personel_Guncelle]
@Id int,
@tcNo varchar(50),
@ad varchar(50),
@soyad varchar(50),
@telefon varchar(50),
@eposta varchar(50),
@adres text,
@departmanId int,
@maas int

As
Begin
Update personel Set tcNo=@tcNo,ad=@ad,soyad=@soyad,telefon=@telefon,eposta=@eposta,adres=@adres,departmanId=@departmanId,maas=@maas
Where Id=@Id
End

Create Proc [dbo].[Sil]
@Tablo varchar(50),
@Id int

As
Begin
EXEC('Delete From '+ @Tablo+' Where Id='+@Id)
End