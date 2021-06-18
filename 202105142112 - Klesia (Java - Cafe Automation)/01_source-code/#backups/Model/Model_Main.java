
package Model;

public abstract class Model_Main {
    private int Id;
    private String[] kolonlar;

    public Model_Main() {
    }

    public Model_Main(int Id) {
        this.Id = Id;
    }

    public Model_Main(int Id, String[] kolonlar) {
        this.Id = Id;
        this.kolonlar = kolonlar;
    }

    public Model_Main(String[] kolonlar) {
        this.kolonlar = kolonlar;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String[] getKolonlar() {
        return kolonlar;
    }

    public void setKolonlar(String[] kolonlar) {
        this.kolonlar = kolonlar;
    }

    @Override
    public String toString() {
        return "Model_Main{" + "Id=" + Id + ", kolonlar=" + kolonlar + '}';
    }
    
    public Object[] getNesne(){
        return new Object[] {Id};
    }
}
