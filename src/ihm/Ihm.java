package ihm;
import java.util.Scanner;

public class Ihm {
	
	private static UserInputs userInputs;
	
	private static Scanner sc;
	
	private static void openScanner(){
		sc = new Scanner(System.in);
	}
	
	private static void closeScanner(){
		sc.close();
	}
	
	/* returns scale 
	 *  1 : France
	 *  2 : D�partement
	 *  3 : Commune
	 */
	public static int getScale(){
		//Print text
		System.out.println("");
		System.out.println("A quelle �chelle voulez-vous voir les donn�es ? ");
		System.out.println("S�letionnez la lettre correspondant � l'�chelle que vous souhaitez, puis appuyez sur Entr�e");
		System.out.println("f : France");
		System.out.println("d : D�partement");
		System.out.println("c : Commune");
		
		//Initialization
		int scale = 0;
		String selected;
		
		//While the input is not correct, ask for another input
		while (scale == 0){
			String str = sc.nextLine();
			switch(str){
			case "f": scale = 1;
					selected = "Vous avez s�lectionn� l'�chelle de la France";
				break;
			case "d": scale = 2;
					selected = "Vous avez s�lectionn� l'�chelle du d�partement";
				break;
			case "c": scale = 3;
					selected = "Vous avez s�lectionn� l'�chelle de la commune";
				break;
			default : selected = "Entr�e invalide. Veuillez r�essayer";
				break;
			}
			System.out.println(selected);
		}
		
		return scale;
	}

	public static String getLocalID(int scale){
		//Print text
		System.out.println("");
		switch(scale){
		case 2: //D�partement
			System.out.println("Quel d�partement voulez-vous voir ? ");
			break;
		case 3: //Commune 
			System.out.println("Quelle commune voulez-vous voir ? ");
			break;
		default : 
			break;
		}
		System.out.println("Tapez le num�ro, puis appuyez sur Entr�e ");
		
		//Initialization
		String ID = "";
		String selected;
		
		//While the input is not correct, ask for another input
		while (ID == ""){
			String str = sc.nextLine();
			if (str.matches("[0-9]+")){
				ID = str;
				selected = "Vous avez s�l�ctionn� "+ID;
			}
			else selected = "Entr�e invalide. Veuillez r�essayer";
			System.out.println(selected);
		}
		
		return ID;
		
	}
	
	public static boolean filtreByDate(){
		//Print text
		System.out.println("");
		System.out.println("Voulez-vous pr�ciser un intervalle de temps pour voir les donn�es ? ");
		System.out.println("S�letionnez l'option d�sir�e, puis appuyez sur Entr�e");
		System.out.println("o : Oui");
		System.out.println("n : Non");
		
		//Initialization
		boolean askForDates = false;
		boolean userHasAnswered = false;
				
		//While the input is not correct, ask for another input
		while (!userHasAnswered){
			String str = sc.nextLine();
			switch(str){
			case "o": userHasAnswered = true;
				askForDates = true;
				break;
			case "n": userHasAnswered = true;
				break;
			default: System.out.println("Entr�e invalide. Veuillez r�essayer"); 
				break;
			}
			
		}		
		return askForDates;
	}
	
	//A completer
	public static String getOneDate(boolean start){
		//Print text
		System.out.println("");
		String time;
		if (start){
			time = "d�but";
		}else
			time = "fin";
		System.out.println("Veuillez saisir la date de "+time+" de l'intervalle de temps");
		System.out.println("Ecrivez la date au format '         ', puis appuyez sur Entr�e"); //A completer
		
		String date = "";
		String selected;
		
		//While the input is not correct, ask for another input
		while (date == ""){
			String str = sc.nextLine();
			//if (str.matches("[0-9]+")){			//A completer
				date = str;
				selected = "Vous avez saisi "+date;
			//}
			//else selected = "Entr�e invalide. Veuillez r�essayer";
			System.out.println(selected);
		}	
		return date;
	}
	
	public static UserInputs getUserInputs(){
		askUserInputs();
		return userInputs;
	}
	
	public static void askUserInputs(){
		openScanner();
		userInputs = new UserInputs();
		int scale = getScale();
		userInputs.setScale(scale);
		if (scale >1){ //For Departement or Commune
			userInputs.setZoneID(getLocalID(scale));
		}
		boolean useDates = filtreByDate();
		userInputs.setUseDates(useDates);
		if (useDates){
			userInputs.setStartDate(getOneDate(true));
			userInputs.setEndDate(getOneDate(false));
		}
		closeScanner();
	}
	
	
	public static void main(String [ ] args){
		UserInputs ui = getUserInputs();
	}
	
	
	
}