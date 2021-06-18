package Interface;

//Bu interface diğer Model sınıfları için bir şablon görevi görmektedir
public interface Interface_Model {
    //Kaydın Id değerinin geriye döndürülmesi
    public int getId();
    //Kaydın Id değerinin set (ayarlama) edilmesi
    public void setId(int Id);
    //Sınıfa ait objelerin (değerlerin) bir dizi halinde döndürülmesi
    public Object[] getObject();
}
