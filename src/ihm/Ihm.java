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
	 *  2 : Departement
	 *  3 : Commune
	 *  4 : Parcelle
	 *  5 : Cadastre
	 *  */
	public static int getScale(){
		//Print text
		System.out.println("");
		System.out.println("A quelle echelle voulez-vous voir les donnees ? ");
		System.out.println("Seletionnez la lettre correspondant a l'echelle que vous souhaitez, puis appuyez sur Entree");
		System.out.println("f  : France");
		System.out.println("d  : Departement");
		System.out.println("c  : Commune");
		System.out.println("p  : Departement");
		System.out.println("ca : Commune");

		//Initialization
		int scale = 0;
		String selected;

		//While the input is not correct, ask for another input
		while (scale == 0){
			String str = sc.nextLine();
			switch(str){
			case "f": scale = 1;
					selected = "Vous avez selectionne l'echelle de la France";
				break;
			case "d": scale = 2;
					selected = "Vous avez selectionne l'echelle du departement";
				break;
			case "c": scale = 3;
					selected = "Vous avez selectionne l'echelle de la commune";
				break;
			case "p": scale = 4;
			selected = "Vous avez selectionne l'echelle de la parcelle";
				break;
			case "ca": scale = 5;
			selected = "Vous avez selectionne l'echelle du cadastre";
				break;
			default : selected = "Entree invalide. Veuillez reessayer";
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
		case 2: //Departement
			System.out.println("Quel departement voulez-vous voir ? ");
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
		System.out.println("Tapez le numero, puis appuyez sur Entree ");

		//Initialization
		String ID = "";
		String selected;

		//While the input is not correct, ask for another input
		while (ID == ""){
			String str = sc.nextLine();
			if (str.matches("[0-9]+")){
				ID = str;
				selected = "Vous avez selectionne "+ID;
			}
			else selected = "Entree invalide. Veuillez reessayer";
			System.out.println(selected);
		}

		return ID;

	}

	public static boolean filtreByDate(){
		//Print text
		System.out.println("");
		System.out.println("Voulez-vous preciser un intervalle de temps pour voir les donnees ? ");
		System.out.println("Seletionnez l'option desiree, puis appuyez sur Entree");
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
			default: System.out.println("Entree invalide. Veuillez reessayer");
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
			time = "debut";
		}else
			time = "fin";
		System.out.println("Veuillez saisir la date de "+time+" de l'intervalle de temps");
		System.out.println("Ecrivez la date en respectant le format suivant 'AAAA-MM-JJ hh:mm:ss.cc' sans les guillements, puis appuyez sur Entree"); //A completer
		System.out.println("Par exemple, pour le 30 decembre 2010 a 18h50 et 21 secondes, ecrivez '2010-12-30 18:50:21.00'");

		String date = "";
		String selected;

		//While the input is not correct, ask for another input
		while (date == ""){
			String str = sc.nextLine();
			if (str.matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9].[0-9][0-9]")){			//A completer
				date = str;
				selected = "Vous avez saisi "+date;
			}
			else selected = "Entree invalide. Veuillez reessayer";
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
