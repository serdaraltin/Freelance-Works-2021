<?php

class Arac {
  public $model;
  public $marka;
  public $agirlik;
  public $tekerSayi;
  public $yil;
  public function __construct($model, $marka,$agirlik,$tekerSayi,$yil) {
    $this->model = $model;
    $this->marka = $marka;
    $this->agirlik = $agirlik;
    $this->tekerSayi = $tekerSayi;
    $this->yil = $yil;
  }
  public function yazdir() {
    echo "Marka        : ".$this->marka."\n";
    echo "Model        : ".$this->model."\n";
    echo "Yil          : ".$this->yil."\n";
    echo "Agirlik      : ".$this->agirlik." kg\n";
    echo "Teker Sayisi : ".$this->tekerSayi." adet\n";
  
  }

  public function ModelDegistir($yeni){
    $this->model = $yeni;
    echo "Model degistirildi.\n";
  }

  public function MarkaDegistir($yeni){
    $this->marka = $yeni;
    echo "Marka degistirildi.\n";
  }

  public function YilDegistir($yeni){
    $this->yil = $yeni;
    echo "Yil degistirildi.\n";
  }
}

class Otomobil extends Arac {
  public $tip;
  public $havaYastigi;
  public $yakitTuru;

  public function __construct($model, $marka,$agirlik,$tekerSayi,$yil,$tip,$havaYastigi,$yakitTuru){
      parent::__construct($model, $marka,$agirlik,$tekerSayi,$yil);
      $this->tip = $tip;
      $this->havaYastigi = $havaYastigi;
      $this->yakitTuru = $yakitTuru;
  }

  public function yazdir() {
    echo "\nOtomobil.\n";
    parent::yazdir();
    echo "Tip          : ".$this->tip."\n";
    echo "Hava Yastigi : ".$this->havaYastigi."\n";
    echo "Yakit Turu   : ".$this->yakitTuru."\n";
  
  }
}

class Tir extends Arac {
    public $tasimaKapasitesi;
    public $lisansTuru;
  
    public function __construct($model, $marka,$agirlik,$tekerSayi,$yil,$tasimaKapasitesi,$lisansTuru){
        parent::__construct($model, $marka,$agirlik,$tekerSayi,$yil);
        $this->tasimaKapasitesi = $tasimaKapasitesi;
        $this->lisansTuru = $lisansTuru;
    }
  
    public function yazdir() {
       echo "\nTir.\n";
      parent::yazdir();
      echo "Tasima Kapasitesi : ".$this->tasimaKapasitesi." ton\n";
      echo "Lisans Turu       : ".$this->lisansTuru."\n";
  
    }
  }



$otomobil1 = new Otomobil("veyron","bugatti",2750,4,2015,"spor","var","dizel");
$otomobil1->yazdir();

$otomobil2 = new Otomobil("corolla","toyota",2100,4,2012,"normal","var","benzin");
$otomobil2->yazdir();

$otomobil3 = new Otomobil("nemo","citroen",2500,4,2019,"ticari","var","dizel");
$otomobil3->yazdir();


$tir1 = new Tir("BM303","Benza",12000,10,2015,27,"yurt ici");
$tir1->yazdir();

$tir2 = new Tir("Benz","Mersedes",8000,8,2012,14,"uluslararasi");
$tir2->yazdir();

$tir3 = new Tir("AC32","Tesla",22000,12,2019,45,"yurt ici");
$tir3->yazdir();


?>