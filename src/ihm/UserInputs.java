package ihm;

public class UserInputs {
	
	private int scale;
	/*  1 : France
	 *  2 : D�partement
	 *  3 : Commune
	 *  4 : Parcelle
	 *  5 : Cadastre
	 *  */
	
	private String zoneID;
	/*  num�ro de d�partement ou code postal, 
	 *  �ventuellement id de parcelle ou de cadastre */
	
	private boolean useDates;
	/*  True si des dates ont �t� pr�cis�es, False sinon */
	
	private String startDate; 
	/*  Date de d�but de l'intervalle de temps */
	private String endDate;
	/*  Date de fin de l'intervalle de temps */
	
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public String getZoneID() {
		return zoneID;
	}
	public void setZoneID(String zoneID) {
		this.zoneID = zoneID;
	}
	public boolean isUseDates() {
		return useDates;
	}
	public void setUseDates(boolean useDates) {
		this.useDates = useDates;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}


