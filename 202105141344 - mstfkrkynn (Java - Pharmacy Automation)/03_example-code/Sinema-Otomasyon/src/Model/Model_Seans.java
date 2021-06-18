package Model;

public class Model_Seans {

    private int Id;
    private int filmId;
    private int salonId;
    private String tarih;

    public Model_Seans() {
    }

    public Model_Seans(int Id, int filmId, int salonId, String tarih) {
        this.Id = Id;
        this.filmId = filmId;
        this.salonId = salonId;
        this.tarih = tarih;
    }
    public Model_Seans( int filmId, int salonId, String tarih) {
        this.filmId = filmId;
        this.salonId = salonId;
        this.tarih = tarih;
    }

    public Model_Seans(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getSalonId() {
        return salonId;
    }

    public void setSalonId(int salonId) {
        this.salonId = salonId;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "Model_Seans{" + "Id=" + Id + ", filmId=" + filmId + ", salonId=" + salonId + ", tarih=" + tarih + '}';
    }

    public Object[] toObject() {
        return new Object[]{Id, filmId, salonId, tarih};
    }

}
