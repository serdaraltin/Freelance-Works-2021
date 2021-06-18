Create Trigger yoneticiSilme on kullanici
after delete
as
begin
	if(exists(select *from deleted where kullaniciAd='admin' and parola='admin'))
	begin
	raiserror('Yonetici silinemez',0,0)
	rollback transaction
	end
end