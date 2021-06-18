package rez;

public class Koltuk implements Bilet{
	private int sıraNo,koltukNo;
	private boolean durum;
	
	public Koltuk(int sıraNo, int koltukNo, boolean durum) {
		super();
		setSıraNo(sıraNo);
		setKoltukNo(koltukNo);
		setDurum(durum);
	}
	
	@Override
	public void yerAyırma(int sıraNo,int koltukNo) {
		if(!durum)
		{
			setSıraNo(sıraNo);
			setKoltukNo(koltukNo);
			setDurum(true);
		}
		else
		{
			System.out.println("Bu koltuk dolu!");
		}
	}

	public int getSıraNo() {
		return sıraNo;
	}

	public void setSıraNo(int sıraNo) {
		this.sıraNo = sıraNo;
	}

	public int getKoltukNo() {
		return koltukNo;
	}

	public void setKoltukNo(int koltukNo) {
		this.koltukNo = koltukNo;
	}

	public boolean isDurum() {
		return durum;
	}

	public void setDurum(boolean durum) {
		this.durum = durum;
	}


}
