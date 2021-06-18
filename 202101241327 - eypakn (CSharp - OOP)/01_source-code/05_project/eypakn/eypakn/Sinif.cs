using System;
using System.Collections.Generic;
using System.Text;

namespace eypakn
{
    class Sinif
    {
        //Fields
        private int ogrenciSayisi;
        private string sinifAdi;
        private string bolumAdi;

        //Yapıcı Method (Constractor)
        public Sinif()
        {

        }
        //Yapıcı Method (Constractor) -> Overloading
        public Sinif(string _sinifAdi, string _bolumAdi, int _ogrenciSayisi)
        {
            sinifAdi = _sinifAdi;
            bolumAdi = _bolumAdi;
            ogrenciSayisi = _ogrenciSayisi;
        }
        //properties -> getter setter -> ogrenciSayisi
        public int OgrenciSayisi
        {
            get { return ogrenciSayisi; }
            set { ogrenciSayisi = value; }
        }
        //properties -> getter setter -> sinifAdi
        public string SinifAdi
        {
            get { return sinifAdi; }
            set { sinifAdi = value; }
        }
        //properties -> getter setter -> bolumAdi
        public string BolumAdi
        {
            get { return bolumAdi; }
            set { bolumAdi = value; }
        }
        //method
        public string SinifBilgisiOku()
        {
            return "Sınıf Adı=" + sinifAdi + "\nOgrenci Sayisi = " + ogrenciSayisi + "\nBolum Adı=" + bolumAdi;
        }

    }
}
