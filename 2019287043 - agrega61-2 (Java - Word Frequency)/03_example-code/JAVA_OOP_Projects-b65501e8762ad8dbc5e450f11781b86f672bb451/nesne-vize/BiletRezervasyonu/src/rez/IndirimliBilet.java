package rez;

import java.time.LocalDate;
import java.util.Arrays;

public class IndirimliBilet extends Ticket {

	private String indirimKodu;
	private double indirimMiktarý;
	public IndirimliBilet(int sýraNo, int koltukNo, boolean durum, String filmAdý, String seans, LocalDate tarih,
			int salonNo, Koltuk[] koltuklar, String ad, String soyad, String tcno, double fiyat, Gösterim gösterim,
			String indirimKodu, double indirimMiktarý) {
		super(sýraNo, koltukNo, durum, filmAdý, seans, tarih, salonNo, koltuklar, ad, soyad, tcno, fiyat, gösterim);
		setIndirimKodu(indirimKodu);
		setIndirimMiktarý(indirimMiktarý);
		setFiyat(fiyat-indirimMiktarý);
	}
	public String getIndirimKodu() {
		return indirimKodu;
	}
	public void setIndirimKodu(String indirimKodu) {
		if(indirimKodu=="1234")
		this.indirimKodu = indirimKodu;
		else
			System.out.println("Yanlýþ indirim kodu!");
	}
	public double getIndirimMiktarý() {
		return indirimMiktarý;
	}
	public void setIndirimMiktarý(double indirimMiktarý) {
		if(indirimMiktarý>0)
		this.indirimMiktarý = indirimMiktarý;
	}
	@Override
	public String toString() {
		return "IndirimliBilet [getIndirimKodu()=" + getIndirimKodu() + ", getIndirimMiktarý()=" + getIndirimMiktarý()
				+ ", getAd()=" + getAd() + ", getSoyad()=" + getSoyad() + ", getTcno()=" + getTcno() + ", getFiyat()="
				+ getFiyat() + ", getGösterim()=" + getGösterim() + ", getFilmAdý()=" + getFilmAdý() + ", getSeans()="
				+ getSeans() + ", getTarih()=" + getTarih() + ", getSalonNo()=" + getSalonNo() + ", getSýraNo()="
				+ getSıraNo() + ", getKoltukNo()=" + getKoltukNo() + "]";
	}

	

}
