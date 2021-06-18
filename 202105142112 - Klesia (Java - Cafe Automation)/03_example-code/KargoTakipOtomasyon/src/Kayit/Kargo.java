package Kayit;

public class Kargo {
    private int Id;
    private int gondericiId;
    private int aliciId;
    private String gondericiAdres;
    private String aliciAdres;
    private float ucret;

    public Kargo(int Id, int gondericiId, int aliciId, String gondericiAdres, String aliciAdres, float ucret) {
        this.Id = Id;
        this.gondericiId = gondericiId;
        this.aliciId = aliciId;
        this.gondericiAdres = gondericiAdres;
        this.aliciAdres = aliciAdres;
        this.ucret = ucret;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getGondericiId() {
        return gondericiId;
    }

    public void setGondericiId(int gondericiId) {
        this.gondericiId = gondericiId;
    }

    public int getAliciId() {
        return aliciId;
    }

    public void setAliciId(int aliciId) {
        this.aliciId = aliciId;
    }

    public String getGondericiAdres() {
        return gondericiAdres;
    }

    public void setGondericiAdres(String gondericiAdres) {
        this.gondericiAdres = gondericiAdres;
    }

    public String getAliciAdres() {
        return aliciAdres;
    }

    public void setAliciAdres(String aliciAdres) {
        this.aliciAdres = aliciAdres;
    }

    public float getUcret() {
        return ucret;
    }

    public void setUcret(float ucret) {
        this.ucret = ucret;
    }

    @Override
    public String toString() {
        return Id + "	"+ gondericiId + "	"+ aliciId +   "	" + gondericiAdres + "	"+ aliciAdres + "	"+ ucret;
    }
   
}
