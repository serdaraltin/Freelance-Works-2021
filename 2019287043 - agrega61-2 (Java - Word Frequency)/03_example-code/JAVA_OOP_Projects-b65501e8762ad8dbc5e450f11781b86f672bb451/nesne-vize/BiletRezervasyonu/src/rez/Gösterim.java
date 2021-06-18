package rez;

import java.time.LocalDate;

public class G�sterim extends Koltuk {
	private String filmAd�,seans;
	private LocalDate tarih;
	private int salonNo;
	
	public Koltuk [] koltuklar;
	

	public Koltuk[] getKoltuklar() {
		return koltuklar;
	}
	public void setKoltuklar(Koltuk[] koltuklar) {
		this.koltuklar = koltuklar;
	}
	public G�sterim(int s�raNo, int koltukNo, boolean durum, String filmAd�, String seans,
			LocalDate date, int salonNo, Koltuk[] koltuklar) {
		super(salonNo, salonNo, durum);
		setFilmAd�(filmAd�);
		setSeans(seans);
		setTarih(date);
		setSalonNo(salonNo);
		setKoltuklar(koltuklar);;

	}
	public String getFilmAd�() {
		return filmAd�;
	}
	public void setFilmAd�(String filmAd�) {
		this.filmAd� = filmAd�;
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
