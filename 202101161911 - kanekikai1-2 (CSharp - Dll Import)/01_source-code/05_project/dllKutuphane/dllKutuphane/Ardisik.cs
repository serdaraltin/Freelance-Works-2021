using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace dllKutuphane
{
    public class Ardisik
    {
        private int ilkTerim;
        private int sonTerim;
        private int artisMiktari;
        
        public int IlkTerim
        {
            get { return ilkTerim; }
            set { ilkTerim = value; }
        }
        public int SonTerim
        {
            get { return sonTerim; }
            set { sonTerim = value; }
        }
        public int ArtisMiktari
        {
            get { return artisMiktari; }
            set { artisMiktari = value; }
        }

        public static object Console { get; private set; }

        public int ortancaTerim()
        {
            int[] sayilar = new int[sonTerim];
            int eleman = 0;
            for (int i = ilkTerim; i <= sonTerim; i+=artisMiktari)
            {
                sayilar[eleman++] = i;
            }
            return sayilar[eleman/2];
        }

        public int terimSayisi()
        {
            int eleman = 0;
            for (int i = ilkTerim; i <= sonTerim; i += artisMiktari)
            {
                eleman++;
            }
            return eleman;
        }

        public int diziToplam()
        {
            int toplam = 0;

            for (int i = ilkTerim; i <= sonTerim; i+=artisMiktari)
            {
                toplam += i;
            }
            return toplam;
        }

  
    }
}
