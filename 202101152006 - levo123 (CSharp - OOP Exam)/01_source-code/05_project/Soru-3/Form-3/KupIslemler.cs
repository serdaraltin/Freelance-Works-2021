namespace Form_3
{
    class KupIslemler : KareIslemler, kup
    {
        public int kup(int a)
        {
            return carp(a, kare(a));
        }
    }
}
