using System;
using System.Collections.Generic;
using System.Text;

namespace eypakn
{
    class Ogrenci : Kisi
    {
    	//Fields
        private int ogrenciNo;
        private Sinif sinif;

        //Yapıcı method
        public Ogrenci(int _no, string _tcno, string _ad, string _soyad)
        {
            ogrenciNo = _no;
            TcNo = _tcno;
            Ad = _ad;
            Soyad = _soyad;
        }
        //Yapıcı method -> overloading
        public Ogrenci(int _no, string _tcno, string _ad, string _soyad, Sinif _sinif)
        {
            ogrenciNo = _no;
            TcNo = _tcno;
            Ad = _ad;
            Soyad = _soyad;
            sinif = _sinif;
        }
        //properties -> getter setter -> ogrenciNo
        public int OgrenciNo
        {
            get { return ogrenciNo; }
            set { ogrenciNo = value; }
        }
        //properties -> getter setter -> sinif
        public Sinif Sinif
        {
            get { return sinif; }
            set { sinif = value; }
        }
        //method
        public string OgrenciBilgisiGoster()
        {
            return "No =" + ogrenciNo +
                "\nTc No =" + TcNo +
                "\nAd =" + Ad +
                "\nSoyad =" + Soyad +
                "\nSinif =" + sinif.SinifAdi;
        }
    }
}
