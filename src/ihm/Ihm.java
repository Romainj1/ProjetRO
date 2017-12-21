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
	 *  2 : Département
	 *  3 : Commune
	 */
	public static int getScale(){
		//Print text
		System.out.println("");
		System.out.println("A quelle échelle voulez-vous voir les données ? ");
		System.out.println("Séletionnez la lettre correspondant à l'échelle que vous souhaitez, puis appuyez sur Entrée");
		System.out.println("f : France");
		System.out.println("d : Département");
		System.out.println("c : Commune");
		
		//Initialization
		int scale = 0;
		String selected;
		
		//While the input is not correct, ask for another input
		while (scale == 0){
			String str = sc.nextLine();
			switch(str){
			case "f": scale = 1;
					selected = "Vous avez sélectionné l'échelle de la France";
				break;
			case "d": scale = 2;
					selected = "Vous avez sélectionné l'échelle du département";
				break;
			case "c": scale = 3;
					selected = "Vous avez sélectionné l'échelle de la commune";
				break;
			default : selected = "Entrée invalide. Veuillez réessayer";
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
		case 2: //Département
			System.out.println("Quel département voulez-vous voir ? ");
			break;
		case 3: //Commune 
			System.out.println("Quelle commune voulez-vous voir ? ");
			break;
		default : 
			break;
		}
		System.out.println("Tapez le numéro, puis appuyez sur Entrée ");
		
		//Initialization
		String ID = "";
		String selected;
		
		//While the input is not correct, ask for another input
		while (ID == ""){
			String str = sc.nextLine();
			if (str.matches("[0-9]+")){
				ID = str;
				selected = "Vous avez séléctionné "+ID;
			}
			else selected = "Entrée invalide. Veuillez réessayer";
			System.out.println(selected);
		}
		
		return ID;
		
	}
	
	public static boolean filtreByDate(){
		//Print text
		System.out.println("");
		System.out.println("Voulez-vous préciser un intervalle de temps pour voir les données ? ");
		System.out.println("Séletionnez l'option désirée, puis appuyez sur Entrée");
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
			default: System.out.println("Entrée invalide. Veuillez réessayer"); 
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
			time = "début";
		}else
			time = "fin";
		System.out.println("Veuillez saisir la date de "+time+" de l'intervalle de temps");
		System.out.println("Ecrivez la date au format '         ', puis appuyez sur Entrée"); //A completer
		
		String date = "";
		String selected;
		
		//While the input is not correct, ask for another input
		while (date == ""){
			String str = sc.nextLine();
			//if (str.matches("[0-9]+")){			//A completer
				date = str;
				selected = "Vous avez saisi "+date;
			//}
			//else selected = "Entrée invalide. Veuillez réessayer";
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
