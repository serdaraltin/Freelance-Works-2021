using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Sertuguler
{
    class Kayıt
    { 
        public void KayıtEkle(string KanGrubu)
        {
            FileStream fs = new FileStream("VeriEkleme.txt", FileMode.Append, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs);
            sw.WriteLine(KanGrubu);
            sw.Close();
        }
        /*public void KayıtGörüntüle()
        {
            FileStream fs = new FileStream("VeriEkleme.txt", FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader sr = new StreamReader(fs);
            string yazi = sr.ReadLine();
            while (yazi != null)
            {
                Console.WriteLine(yazi);
                yazi = sr.ReadLine();
            }
            sr.Close();

        }*/
        /*public void dosyadanOku()
        {
            string dosya_yolu = @"VeriEkleme.txt";
            FileStream fs = new FileStream(dosya_yolu, FileMode.OpenOrCreate, FileAccess.Read);
            StreamReader sw = new StreamReader(fs);
            string yazi = sw.ReadLine();
            while (yazi != null)
            {
                Console.WriteLine(yazi);
                yazi = sw.ReadLine();
            }
            sw.Close();
        }*/
        public void KayıtGüncelle(string KanGrubu)
        {
            FileStream fs = new FileStream("VeriEkleme.txt", FileMode.Append, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs);
            sw.WriteLine(KanGrubu);
            sw.Close();
        }
        public void dosyadanOku()
        {
            StreamReader sr = new StreamReader(@"VeriEkleme.txt");
            string Veri = sr.ReadToEnd();
            sr.Close();
            Console.WriteLine(Veri);
            Console.ReadLine();
        }
        

    }
}
