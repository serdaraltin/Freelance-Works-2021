package rez;

import java.time.LocalDate;

public class Gösterim extends Koltuk {
	private String filmAdý,seans;
	private LocalDate tarih;
	private int salonNo;
	
	public Koltuk [] koltuklar;
	

	public Koltuk[] getKoltuklar() {
		return koltuklar;
	}
	public void setKoltuklar(Koltuk[] koltuklar) {
		this.koltuklar = koltuklar;
	}
	public Gösterim(int sýraNo, int koltukNo, boolean durum, String filmAdý, String seans,
			LocalDate date, int salonNo, Koltuk[] koltuklar) {
		super(salonNo, salonNo, durum);
		setFilmAdý(filmAdý);
		setSeans(seans);
		setTarih(date);
		setSalonNo(salonNo);
		setKoltuklar(koltuklar);;

	}
	public String getFilmAdý() {
		return filmAdý;
	}
	public void setFilmAdý(String filmAdý) {
		this.filmAdý = filmAdý;
	}
	public String getSeans() {
		return seans;
	}
	public void setSeans(String seans) {
		this.seans = seans;
	}
	public LocalDate getTarih() {
		return tarih;
	}
	public void setTarih(LocalDate date) {
		this.tarih = date;
	}
	public int getSalonNo() {
		return salonNo;
	}
	public void setSalonNo(int salonNo) {
		this.salonNo = salonNo;
	}

}
