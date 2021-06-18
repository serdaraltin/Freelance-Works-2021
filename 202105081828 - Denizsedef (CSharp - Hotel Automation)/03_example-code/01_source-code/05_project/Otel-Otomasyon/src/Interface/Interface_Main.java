package Interface;

import Model.Model_Main;

public interface Interface_Main extends Interface_Sub<Model_Main>{

    public boolean Kontrol(int Id);

    public boolean Sil(int Id);

    public void Guncelle(int Id);

    public void Ac();

}
