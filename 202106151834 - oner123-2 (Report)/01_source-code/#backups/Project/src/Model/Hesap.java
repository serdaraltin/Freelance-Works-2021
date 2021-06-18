package Model;

public class Hesap {

    private int no;
    private String parola;
    

    public Hesap() {
    }

    public Hesap(int no, String parola) {
        this.no = no;
        this.parola = parola;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return no + ", " + parola;
    }

    public String[] getColumn() {
        return new String[]{"No", "Parola"};
    }

    public Object[] getObject() {
        return new Object[]{no, parola};
    }

}
