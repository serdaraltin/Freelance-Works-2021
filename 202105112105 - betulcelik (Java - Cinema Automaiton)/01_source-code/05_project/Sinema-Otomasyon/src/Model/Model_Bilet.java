package Model;

public class Model_Bilet {

    //tabloda bulunan değerlerin tanımlanması
    private int Id;
    private String musteriTip;
    private int seansId;
    private int koltukNo;

    //tüm değerleri alan kurucu method
    public Model_Bilet(int Id, String musteriTip, int seansId, int koltukNo) {
        this.Id = Id;
        this.musteriTip = musteriTip;
        this.seansId = seansId;
        this.koltukNo = koltukNo;
    }

    //spesifik değerleri alan kurucu method
    public Model_Bilet(String musteriTip, int seansId, int koltukNo) {
        this.musteriTip = musteriTip;
        this.seansId = seansId;
        this.koltukNo = koltukNo;
    }

    //spesifik değerleri alan kurucu method
    public Model_Bilet(int seansId, int koltukNo) {
        this.seansId = seansId;
        this.koltukNo = koltukNo;
    }

    //değer almayan
    public Model_Bilet() {
    }

    //sadece Id değerini alan kurucu method
    public Model_Bilet(int Id) {
        this.Id = Id;
    }

    //get ve set ile başlayanlar getter ve setter lardır, bunlar kapsülleme içindir
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMusteriTip() {
        return musteriTip;
    }

    public void setMusteriTip(String musteriTip) {
        this.musteriTip = musteriTip;
    }

    public int getSeansId() {
        return seansId;
    }

    public void setSeansId(int seansId) {
        this.seansId = seansId;
    }

    public int getKoltukNo() {
        return koltukNo;
    }

    public void setKoltukNo(int koltukNo) {
        this.koltukNo = koltukNo;
    }

    //tabloya verileri ekleme sırasında object kullanıldığı için mevcut sınıfın verilerini bir object dizisi olarak döndüren method
    public Object[] toObject() {
        return new Object[]{Id, musteriTip, seansId, koltukNo};
    }
    
    //mevcut sınıfın değerlerini bir String olarak döndüren method
    @Override
    public String toString() {
        return "Model_Bilet{" + "Id=" + Id + ", musteriTip=" + musteriTip + ", seansId=" + seansId + ", koltukNo=" + koltukNo + '}';
    }
}
