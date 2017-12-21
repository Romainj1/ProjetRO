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
	 *  4 : Parcelle
	 *  5 : Cadastre
	 *  */
	public static int getScale(){
		//Print text
		System.out.println("");
		System.out.println("A quelle �chelle voulez-vous voir les donn�es ? ");
		System.out.println("S�letionnez la lettre correspondant � l'�chelle que vous souhaitez, puis appuyez sur Entr�e");
		System.out.println("f  : France");
		System.out.println("d  : D�partement");
		System.out.println("c  : Commune");
		System.out.println("p  : D�partement");
		System.out.println("ca : Commune");
		
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
			case "p": scale = 4;
			selected = "Vous avez s�lectionn� l'�chelle de la parcelle";
				break;
			case "ca": scale = 5;
			selected = "Vous avez s�lectionn� l'�chelle du cadastre";
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
		case 4: //Commune 
			System.out.println("Quelle parcelle voulez-vous voir ? ");
			break;
		case 5: //Commune 
			System.out.println("Quel cadastre voulez-vous voir ? ");
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
	
	public static String getOneDate(boolean start){
		//Print text
		System.out.println("");
		String time;
		if (start){
			time = "d�but";
		}else
			time = "fin";
		System.out.println("Veuillez saisir la date de "+time+" de l'intervalle de temps");
		System.out.println("Ecrivez la date en respectant le format suivant 'AAAA-MM-JJ hh:mm:ss.cc' sans les guillements, puis appuyez sur Entr�e"); //A completer
		System.out.println("Par exemple, pour le 30 d�cembre 2010 � 18h50 et 21 secondes, �crivez '2010-12-30 18:50:21.00'");
				
		String date = "";
		String selected;
		
		//While the input is not correct, ask for another input
		while (date == ""){
			String str = sc.nextLine();
			if (str.matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9].[0-9][0-9]")){			//A completer  
				date = str;
				selected = "Vous avez saisi "+date;
			}
			else selected = "Entr�e invalide. Veuillez r�essayer";
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
		if (scale >1){ //For Departement or Commune or other small scale
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
