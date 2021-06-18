


import java.sql.Connection;

public interface IDb {
    public boolean Sorgu(String sorgu);
    public boolean TabloOlustur();
    public Connection Baglanti();
    public boolean Sifirla();
}
