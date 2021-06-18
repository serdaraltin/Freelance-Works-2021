namespace Form_3
{
    class TemelIslemler : ITemelIslemler
    {
        public int topla(int a, int b)
        {
            return a + b;
        }
        public int cikar(int a, int b)
        {
            return a - b;
        }
        public int carp(int a, int b)
        {
            return a * b;
        }
        public int bol(int a, int b)
        {
            return a / b;
        }
    }
}
