using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp2
{
    class dortgen
    {
        private int kenar_1;
        private int kenar_2;
        private int kenar_3;
        private int kenar_4;

        public int cevreHesapla()
        {
            int cevre = kenar_1 + kenar_2 + kenar_3 + kenar_4;

            return cevre;
        }
        public dortgen(int kenar_1, int kenar_2, int kenar_3, int kenar_4)
        {
            this.kenar_1 = kenar_1;
            this.kenar_2 = kenar_2;
            this.kenar_3 = kenar_3;
            this.kenar_4 = kenar_4;
        }

        public dortgen(int kenar_1, int kenar_2, int kenar_3)
        {
            this.kenar_1 = kenar_1;
            this.kenar_2 = kenar_2;
            this.kenar_3 = kenar_1;
            this.kenar_4 = kenar_2;
        }

        public dortgen(int kenar_1, int kenar_2)
        {
            this.kenar_1 = kenar_1;
            this.kenar_2 = kenar_2;
            this.kenar_3 = kenar_1;
            this.kenar_4 = kenar_2;
        }

        public dortgen(int kenar_1)
        {
            this.kenar_1 = kenar_1;
            this.kenar_2 = kenar_1;
            this.kenar_3 = kenar_1;
            this.kenar_4 = kenar_1;
        }

        public dortgen()
        {
            this.kenar_1 = 0;
            this.kenar_2 = 0;
            this.kenar_3 = 0;
            this.kenar_4 = 0;
        }
    }
}
