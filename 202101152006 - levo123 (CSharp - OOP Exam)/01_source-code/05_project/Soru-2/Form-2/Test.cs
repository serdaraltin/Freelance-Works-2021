namespace Form_2
{
    class Test<T> : ITest<T>
    {
        T[] degerler = new T[5];
        int count = 0;

        public void Ekle(T deger)
        {
            if (count + 1 < 6)
            {
                degerler[count] = deger;
            }
            count++;
        }

        public T this[int index]
        {
            get { return degerler[index]; }
            set { degerler[index] = value; }
        }
    }
}
