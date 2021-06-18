
package Interface;

import java.sql.Connection;

public interface Interface_Veritabani {
    public boolean Sorgu(String sorgu);
    public boolean TabloOlustur();
    public Connection Baglanti();
    public boolean Sifirla();
}
