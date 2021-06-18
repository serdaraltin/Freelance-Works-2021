package Model;

public class Model_Film {

    private int Id;
    private String Ad;
    private String kategori;
    private String yonetmen;
    private int yil;

    public Model_Film() {
    }

    public Model_Film(int Id, String Ad, String kategori, String yonetmen, int yil) {
        this.Id = Id;
        this.Ad = Ad;
        this.kategori = kategori;
        this.yonetmen = yonetmen;
        this.yil = yil;
    }

    public Model_Film(String Ad) {
        this.Ad = Ad;
    }

    public Model_Film(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    @Override
    public String toString() {
        return "Model_Film{" + "Id=" + Id + ", Ad=" + Ad + ", kategori=" + kategori + ", yonetmen=" + yonetmen + ", yil=" + yil + '}';
    }

    public Object[] toObject() {
        return new Object[]{Id, Ad, kategori, yonetmen, yil};
    }

}
