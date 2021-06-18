<?php

class Hayvan{
  public $ad;
  public $tur;
  public $ayakSayi;
  public $solunumTur;
  public $beslenmeSekil;
  
  public function __construct( $ad,$tur,$ayakSayi,$solunumTur,$beslenmeSekil){
    $this->ad = $ad;
    $this->tur =$tur;
    $this->ayakSayi = $ayakSayi;
    $this->solunumTur = $solunumTur;
    $this->beslenmeSekil = $beslenmeSekil;
  }
  public function Bilgiler(){
    echo "\nHayvan\n";
    echo "Ad             : ".$this->ad."\n";
    echo "Tur            : ".$this->tur."\n";
    echo "Ayak Sayisi    : ".$this->ayakSayi."\n";
    echo "Solunum Turu   : ".$this->solunumTur."\n";
    echo "Beslenme Sekli : ".$this->beslenmeSekil."\n";
  }

  public function SesCikar(){
    echo "\nSes cikaramiyorum.\n";
  }

  public function Besle(){
    echo "\nBeslenemiyorum.\n";
  }

  public function Ye(){
    echo "\nYenmiyorum.\n";
  }
}

class Kopek extends Hayvan{
  public $renk;
  public $cins;
  public $fiyat;
  public $tasma;

  public function __construct($ad,$tur,$ayakSayi,$solunumTur,$beslenmeSekil,
  $renk,$cins,$fiyat,$tasma){
    parent::__construct($ad,$tur,$ayakSayi,$solunumTur,$beslenmeSekil);
    
    $this->renk = $renk;
    $this->cins = $cins;
    $this->fiyat = $fiyat;
    $this->tasma = $tasma;
  }

  public function Bilgiler(){
    parent::Bilgiler();
    echo "Kopek\n";
    echo "Rengi          : ".$this->renk."\n";
    echo "Cinsi          : ".$this->cins."\n";
    echo "Fiyati         : ".$this->fiyat."\n";
    echo "Tasma Durumu   : ".$this->tasma."\n";
  }

  public function SesCikar(){
    echo "\nHav hav hav.\n";
  }

  public function Besle(){
    echo "\nMama verildi.\n";
  }

  public function Oksa(){
    echo "\nHırıldıyor ve seviniyor.\n";
  }

}

class Tavuk extends Hayvan{
  public $yumurtaDurumu;
  public $yumurtaRendi;
  public $ucmaDurumu;
  

  public function __construct($ad,$tur,$ayakSayi,$solunumTur,$beslenmeSekil,
  $yumurtaDurumu,$yumurtaRendi,$ucmaDurumu){
    parent::__construct($ad,$tur,$ayakSayi,$solunumTur,$beslenmeSekil);
    
    $this->yumurtaDurumu = $yumurtaDurumu;
    $this->yumurtaRendi = $yumurtaRendi;
    $this->ucmaDurumu = $ucmaDurumu;
  }

  public function Bilgiler(){
    parent::Bilgiler();
    echo "Tavuk\n";
    echo "Yumurta Durumu : ".$this->yumurtaDurumu."\n";
    echo "Yumurta Rengi  : ".$this->yumurtaRendi."\n";
    echo "Ucma Durumu    : ".$this->ucmaDurumu."\n";
  }

  public function SesCikar(){
    echo "\nGıt gıt gıdak.\n";
  }

  public function Besle(){
    echo "\nYem verildi.\n";
  }

  public function Ye(){
    echo "\nPişti ve yemeye hazır.\n";
  }

  public function YumurtaAl(){
    echo "\nTaze bir yumurtamız var.\n";
  }

}

$kopek1 = new Kopek("Garip Kont(Amir)","4 Ayaklılar",4,"Akciğer","Etobur","Kahverengi","K9",38000,"Gerek Yok");
$kopek1->Bilgiler();
$kopek1->SesCikar();

$kopek2 = new Kopek("Taci","4 Ayaklılar",4,"Akciğer","Etobur","Beyaz","BullDog","Paha biçilemez","Takılı");
$kopek2->Bilgiler();
$kopek2->Besle();

$kopek3 = new Kopek("Karabaş","4 Ayaklılar",4,"Akciğer","Etobur","Beyaz-Siyah","Kangal",1700,"Çivili");
$kopek3->Bilgiler();
$kopek3->Oksa();


$tavuk1 = new Tavuk("Necati","Kuş",2,"Akciğer","Otobur ve Etobur", "Veriyor","Kahverengi","Kısa Mesafe");
$tavuk1->Bilgiler();
$tavuk1->YumurtaAl();

$tavuk2 = new Tavuk("Abdi","Kuş",2,"Akciğer","Otobur ve Etobur", "Vermiyor","Beyaz","Fazla Kilolu Uçamaz");
$tavuk2->Bilgiler();
$tavuk2->Besle();

$tavuk3 = new Tavuk("Abuzer","Kuş",2,"Akciğer","Otobur ve Etobur","Veriyor","Beyaz","Kanatları Kesik");
$tavuk3->Bilgiler();
$tavuk3->SesCikar();

?>