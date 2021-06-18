public abstract class Hesap implements IGuvenlikKontrol {

    protected String acilisTarihi;
    protected boolean aktifMi;
    protected int numara;

    @Override
    public void yetkiKontrol() {
    }

    public int masrafHesapla() {
        return 0;
    }
}
