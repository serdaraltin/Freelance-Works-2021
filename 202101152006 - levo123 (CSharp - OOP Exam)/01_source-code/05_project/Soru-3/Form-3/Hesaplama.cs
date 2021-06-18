namespace Form_3
{
    class Hesaplama : KupIslemler, IFaktoriyel
    {
        public int fakt(int a)
        {
            int faktsonuc = 1;
            for (int i = 2; i <= a; i++)
            {
                faktsonuc = carp(faktsonuc, i);
            }
            return faktsonuc;
        }
    }
}
