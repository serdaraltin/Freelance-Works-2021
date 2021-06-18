using System;
using System.Collections.Generic;
using System.Text;

namespace eypakn
{
    class Kisi
    {
    	//Fields
        private string tcNo;
        private string ad;
        private string soyad;

        //Yapıcı Method (Constractor)
        public Kisi()
        {

        }
        //Yapıcı Method (Constractor) -> Overloading
        public Kisi(string _tcno, string _ad, string _soyad)
        {
            tcNo = _tcno;
            ad = _ad;
            soyad = _soyad;
        }
        //properties -> getter setter -> tcno
        public string TcNo
        {
            get { return tcNo; }
            set { tcNo = value; }
        }
         //properties -> getter setter -> ad
        public string Ad
        {
            get { return ad; }
            set { ad = value; }
        }
         //properties -> getter setter -> soyad
        public string Soyad
        {
            get { return soyad; }
            set { soyad = value; }
        }

    }
}
