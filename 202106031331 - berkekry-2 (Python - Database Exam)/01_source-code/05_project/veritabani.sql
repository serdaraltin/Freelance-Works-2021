BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "kategori" (
	"Id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"ad" TEXT	
);
CREATE TABLE IF NOT EXISTS "egitim" (
	"Id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"kullaniciId" INTEGER	,
	"kategoriId" INTEGER	,
	"baslik" TEXT	,
	"aciklama" TEXT	
);
CREATE TABLE IF NOT EXISTS "kullanici" (
	"Id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"kullaniciAd" TEXT	,
	"parola" TEXT	,
	"ad" TEXT	,
	"soyad" TEXT	,
	"cinsiyet" TEXT	,
	"dogumTarih" TEXT	,
	"telNo" TEXT	,
	"email" TEXT	
);
CREATE TABLE IF NOT EXISTS "satinAlim" (
	"Id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"kullaniciId" INTEGER	,
	"egitimId" INTEGER	,
	"ucret" REAL	,
	"tarih" TEXT	
);

CREATE TABLE IF NOT EXISTS "ders" (
	"Id" INTEGER PRIMARY KEY AUTOINCREMENT,
	"egitimId" INTEGER	,
	"baslik" TEXT	,
	"url" TEXT	
);

INSERT INTO "kategori" ("ad") 
VALUES 
 ('Yazılım Geliştirme'),
 ('İşletme'),
 ('Finans ve Muhasebe'),
 ('BT ve Yazılım'),
 ('Ofiste Verimlilik'),
 ('Kişisel Gelişim'),
 ('Tasarım'),
 ('Pazarlama'),
 ('Yaşam Tarzı'),
 ('Fotoğraf ve Video'),
 ('Sağlık ve Fitness'),
 ('Müzik');

INSERT INTO "egitim" ("kullaniciId","kategoriId","baslik","aciklama") VALUES 
 (1,1,'Python | Sıfırdan İleri Seviye Programlama','Sıfırdan İleri Seviyeye Python ve Programlama öğrenmenin tadını çıkarın.

Bu kursta sıfırdan Python ve programlamanın temellerini öğrenerek , ileri seviyelere kadar Python''ın tüm güzelliklerini beraber görmeye başlayacağız. Eğer programlama hakkında hiçbir fikriniz yoksa bu kurs tam size göre!'),
 (2,1,'Komple Uygulamalı Web Geliştirme Eğitimi','Yayınlandığı tarihten beri Udemy''nin en iyi 3 kursu içerisinde en yüksek değerlendirme oranına sahip olduğumuzu bilmenizi isterim. Bu başarının nedeni şüphesiz ki; sürekli güncel kalan bir kurs olmamız ve web geliştirme alanıyla alakalı en önemli ve en gerekli konuları sadece bir kursta yalın ve net bir şekilde öğreniyor olmanızdır.

Kursumuzdaki konu başlıkları sırasıyla; Html, Css, Sass & Scss, Flexbox, Javascript, Angular, Bootstrap, JQuery ve Asp.Net Core Mvc konu başlıklarıdır.

'),
 (3,1,'Android Mobil Uygulama Kursu: Kotlin & Java','Android için Mobil Uygulama yazmayı sıfırdan ileri seviyeye kadar öğrenmek istiyorsanız bu kurs tam size göre!

Android geliştirmeyi son teknoloji ile öğreneceksiniz: Android + Java + Kotlin.

Google Android geliştirme için Java haricinde Kotlin''i de destekleyeceğini açıkladı. Daha da ötesi Kotlin''i birinci dil tercihi olarak belirtti. Dört dörtlük bir yazılımcı olmak istiyorsanız iki dili de öğrenmek için doğru yerdesiniz.'),
 (4,1,'Aranan Programcı Olma Kamp Kursu| Python,Java,C#','Güncelleme (19 Kasım 2020) : Programlamaya giriş bölümleri en güncel haliyle sıfırdan çekildi.

Güncelleme (20 Kasım 2020) : 8 adet yeni ödev eklendi.

Programlamaya sıfırdan başlamak istiyor fakat nereden başlayacağınızı bilmiyorsanız,

Bir programlama teknolojisini öğrenirken, aniden diğerine geçtiğinizi görüyorsanız,

Sektörde aranan programcı olmak için temellerinizi sapasağlam yapmak istiyorsanız,

Şu an doğru kursu inceliyorsunuz.'),
 (5,2,'Amazon FBA Eğitimi ','UDEMY PLATFORMUNDAKİ EN ÇOK İZLENEN (11.000 + ÖĞRENCİ) VE EN KAPSAMLI ( 30 SAAT ) TÜRKÇE "AMAZON FBA" KURSU



AMAZON''DA E-TİCARET İLE PARA KAZANARAK GİRİŞİMCİLİK DÜNYASINA ADIM ATMAK İSTİYORSANIZ BU KURS TAM SİZİN İÇİN

Herhangi bir ön bilgi olmadan yani sıfırdan Amazon FBA yaparak nasıl para kazanacağınızı öğreneceğiniz bu kursta sizleri çok geniş bir içerik bekliyor.'),
 (6,2,'Amazon Satıcı FBA ve Dropshipping Eğitimi ','YENİ ÖZELLİK: HER SALI VE PERŞEMBE SAAT 17:00''DE BU KURSU SATIN ALANLARA ÖZEL CANLI YAYINDA BİREBİR TÜM SORULARINI YANITLIYORUZ, ONLARA YARDIMCI OLUYORUZ. UDEMY''NİN İLK VE TEK YAŞAYAN VE HER GÜN GÜNCELLENEN TEK KURSU!'),
 (7,2,'Satış Eğitimi: A''dan Z''ye Bilmeniz Gerekenler','Satış Eğitim Setine hoşgeldiniz. Öncelikle güzel haber, eğitim setinin 1-2 değil bir çok videosu tamamen ücretsiz izlemeniz için açıktır. Dolayısı ile vaatlerimize değil, tecrübenize açık bu eğitim.'),
 (8,2,'Ticaret Tecrübeleri: İşyeri Devralmak, Franchise Almak','Bu eğitimin amacı: Sizin doğru yatırmı farkedebilmenizi ve bir  yatırımda dışardan bakınca görünmeyen riskleri görebilmenizi sağlamaktır. Bu nedenle bu eğitim değeri parayla ölçülemeyecek tecrübeleri ve ödenmiş bedellerden çıkarılan dersleri size sunmaktadır.

Kurulu bir işyerini devralmak veya bir firmadan bayilik almak ticari hayata girmenin en hızlı yolu.  Bu hızlı yolda giderken yoldaki ışıkları ve virajları görebilmek ancak tecrübe ile elde edilebiliyor. Aksi takdirde bu yolu tercih eden insanların para kazanma isteğini suistmal eden ticari teroristlerin dürüst insanları aldattığına pek çok kez şahit olduk.'),
 (9,2,'Yapay Zeka ve Dijital Dönüşüm','Yapay Zeka ve Dijital Dönüşüm

İş Dünyasında Dijital Dönüşüm Süreçleri ve Yapay Zeka Etkisi

Çağımızın en yaygın kullanılan teknoloji terimlerinden bir tanesi “YAPAY ZEKA ve İŞ üzerine konuşacağımız bu eğitimde, Dijital Dönüşüm ve Yapay Zeka başlığına uygun olarak “İŞ DÜNYASINDA YAPAY ZEKANIN DURUMU” hakkında detaylara değineceğiz.'),
 (10,12,'Selim Işık ile Gitar Dersleri','-Doğaçlama gitar çalma, beste yapma ve müzik teorisi konusunda yetkinlik kazanacaksınız.



-Selim Işık Gitar Metodu 1. ve 2. kitapta anlatılan tüm konuları bu kursta bulacaksınız.

-Bu kursta, Selim Işık''ın 25 yıllık gitar eğitimini aktardığı 1. Ve 2. Gitar Metodu kitaplarında anlatılan tüm konuları bulacaksınız.');
INSERT INTO "kullanici" ("kullaniciAd","parola","ad","soyad","cinsiyet","dogumTarih","telNo","email") VALUES 
 ('mustafamurat','12345678','Mustafa Murat','Coşkun','Erkek','1980-01-01','5455454545','mustafac@gmail.com'),
 ('sadikturan','12345678','Sadık','Turan','Erkek','1985-01-01','5465464646','sadikturan85@hotmail.com'),
 ('atilsamancioglu','12345678','Atıl','Samancıoğlu','Erkek','1982-05-23','5428963245','atil@samancioglu.com'),
 ('engindemirog','12345678','Engin','Demiroğ','Erkek','1987-03-15','5458963214','enginde@gmail.com'),
 ('mehmettek','12345678','Mehmet','Tek','Erkek','1995-02-10','5458964578','mehmettek1995@hotmail.com'),
 ('tugerakkaya','12345678','Tuger','Akkaya','Erkek','1990-06-21','5453218569','tugerakkaya@gmail.com'),
 ('haluktatar','12345678','Haluk','Tatar','Erkek','1990-04-05','5463217854','haluktatar@gmail.com'),
 ('gokhancaliskan','12345678','Gökhan','Çalışkan','Erkek','1987-01-27','5415869354','gokhancaliskan@hotmail.com'),
 ('behzeryildiz','12345678','Behzer','Yıldız','Kadın','1975-04-12','5462147563','behzeryildiz1975@gmail.com'),
 ('selimisik','12345678','Selim','Işık','Erkek','1988-06-03','5435627896','selimisik88@gmail.com'),
 ('ahmetbalaban','12345678','Ahmet','Balaban','Erkek','1997-07-13','5461597532','ahmetbal@hotmail.com'),
 ('selindogan','12345678','Selin','Doğan','Kadın','2003-01-07','5486321745','selindogan03@gmail.com'),
 ('ferit2005','12345678','Ferit','Kuş','Erkek','2005-11-08','5432145369','ferit2003@hotmail.com'),
 ('nurkucuk','12345678','Nur','Küçük','Kadın','2001-05-07','5489621456','nurkucuk@gmail.com'),
 ('fadimeyaren','12345678','Fadime Yaren','Akkaya','Kadın','2000-04-19','5486221454','fadimeyaren@gmail.com'),
 ('mehmetdoganay','12345678','Mehmet','Doğanay','Erkek','2002-12-05','5423659871','mehmetdog@hotmail.com'),
 ('yasincakir','12345678','Yasin','Çakır','Erkek','1996-08-17','5426547785','yasincakir@hotmail.com'),
 ('bekiryaman','12345678','Bekir','Yaman','Erkek','2000-10-02','5426548793','bekiryaman@gmail.com'),
 ('hilalkayyum','12345678','Hilal','Kayyum','Kadın','1995-07-16','5456221453','hilalkayyum@hotmail.com'),
 ('serhatkeles','12345678','Serhat','Keleş','Erkek','2006-01-06','5426589785','serhat2006@gmail.com');
INSERT INTO "satinAlim" ("kullaniciId","egitimId","ucret","tarih") VALUES 
 (11,1,49.99,'2020-01-01'),
 (12,2,27.99,'2021-02-07'),
 (13,3,69.99,'2020-12-13'),
 (13,5,34.99,'2019-11-20'),
 (14,6,49.99,'2021-02-01'),
 (15,7,27.99,'2019-07-23'),
 (16,8,34.99,'2020-06-30'),
 (17,9,27.99,'2019-01-12'),
 (17,1,69.99,'2021-03-07'),
 (17,5,34.99,'2019-11-27'),
 (18,9,49.99,'2020-08-03'),
 (19,8,69.99,'2019-10-05'),
 (20,9,27.99,'2021-04-15'),
 (20,2,49.99,'2020-02-10');

INSERT INTO "ders" ("egitimId","baslik","url") VALUES 
 (1,'Yazılım Nedir ?','-'),
 (1,'Programlama Nedir ?
','-'),
 (1,'Programlama Mantığını Anlamak
','-'),
 (1,'Temel Değişken Yapısını Anlamak
','-'),
 (3,'Java Temelleri Giriş
','-'),
 (3,'Değişkenler','-'),
 (3,'Diziler','-'),
 (3,'Listeler','-'),
 (2,'Html Yapısı','-'),
 (2,'Başlık Etiketleri','-'),
 (2,'Forms','-'),
 (2,'Div & Span','-'),
 (4,'String Fonksiyonlar - Len Fonksiyonu
','-'),
 (5,'Amazon FBA Yol Haritası
','-'),
 (6,'Bireysel mi Kurumsal mı?
','-'),
 (7,'Özgüven','-'),
 (8,'Fizibilite: Sayısal Analiz nasıl yapılır?
','-'),
 (9,'Yapay Zekaya Transfer Oluyoruz!
','-');
COMMIT;
