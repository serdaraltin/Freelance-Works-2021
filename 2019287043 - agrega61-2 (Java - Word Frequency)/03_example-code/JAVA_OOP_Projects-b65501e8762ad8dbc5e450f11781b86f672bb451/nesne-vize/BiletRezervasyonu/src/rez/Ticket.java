package rez;

import java.time.LocalDate;

public class Ticket extends Gösterim {
	private String ad, soyad,tcno;
	private double fiyat;
	private Gösterim gösterim;

	public Ticket(int sýraNo, int koltukNo, boolean durum, String filmAdý, String seans, LocalDate tarih,
			int salonNo, Koltuk[] koltuklar, String ad, String soyad, String tcno, double fiyat, Gösterim gösterim) {
		super(sýraNo, koltukNo, durum, filmAdý, seans, tarih, salonNo, koltuklar);
		setAd(ad);
		setSoyad(soyad);
		setTcno(tcno);
		setFiyat(fiyat);
		setGösterim(gösterim);
	}


	@Override
	public String toString() {
		return "Ticket ["+"getAd()=" + getAd() + ", getSoyad()=" + getSoyad()
				+ ", getTcno()=" + getTcno() + ", getFiyat()=" + getFiyat() + ", getFilmAdý()=" + getFilmAdý()
				+ ", getSeans()=" + getSeans() + ", getTarih()=" + getTarih() + ", getSalonNo()=" + getSalonNo()
				+ ", getSýraNo()=" + getSıraNo() + ", getKoltukNo()=" + getKoltukNo() + "]";
	}


	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public double getFiyat() {
		return fiyat;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	
	public Gösterim getGösterim() {
		return gösterim;
	}


	public void setGösterim(Gösterim gösterim) {
		this.gösterim = gösterim;
	}
}
