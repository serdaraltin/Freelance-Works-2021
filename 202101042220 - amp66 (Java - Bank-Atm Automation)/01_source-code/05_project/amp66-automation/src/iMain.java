

public interface iMain extends iSub<amlMain>{

   /*id bilgisine göre kayidin olup olmamasi kontrolü*/ public boolean KayitKontrol(int id);

    /*id bilgisine göre kayidin silinmesi*/ public boolean KayitSil(int id);

    /*ilgili kaydın id bilgisine göre güncellenmesi*/ public void KayitGuncelle(int id);

    /*ilgili pencerenin gösterilmesi*/ public void PencereAc();

}
