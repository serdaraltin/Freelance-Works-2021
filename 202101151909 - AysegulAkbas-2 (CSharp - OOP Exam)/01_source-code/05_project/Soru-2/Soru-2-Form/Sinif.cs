namespace Soru_2_Form
{
    internal class Sinif<A>: inf<A>
    {
       public A[] dizi = new A[100];
        public int i = 0;
        public bool DiziyeAt(A eklenecek)
        {
            if (i >= 100)
                return false;
            dizi[i++] = eklenecek;
            return true;
        }

        public A this[int i]
        {
            get
            {
                return dizi[i];
            }
        }
    }
}