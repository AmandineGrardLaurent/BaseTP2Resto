import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Resto {
	
	// Mettre en place prochainement la vérification de la saisie dans le terminal
	
	/**
	 * Affiche les options d'une catégorie de menu (ex: entrées, plats)
	 * @param options : tableau contenant les éléments de la catégorie
	 * @param categoryName : nom de la catégorie
	 */
	public static void displayMenuOptions(String [] options, String categoryName) {
		System.out.printf("Choix %s : \n", categoryName.toLowerCase());	
		for (int i = 0; i < options.length; i++) {
				// Affiche chaque option avec un numéro associé
				System.out.printf("[%s - %s]", (i+1), options[i].toUpperCase());
			}
			System.out.println("");
			System.out.printf("Que souhaitez-vous comme %s ? [saisir le chiffre correspondant] \n", categoryName);
	}
		
	/**
	 * Convertit le choix de l'utilisateur (numéro) en l'élément correspondant du tableau
	 * @param selectedIndex : numéro saisi par l'utilisateur
	 * @param options : tableau contenant les éléments de la catégorie
	 * @return retourne l'élément (string) correspondante au numéro saisi 
	 */
	public static String getCustomerSelection(int selectedIndex, String[] options) {	
		
		if (selectedIndex >= 1 && selectedIndex <= options.length) {
		    return options[selectedIndex - 1];
		} else {
		    System.out.printf("Merci de saisir un chiffre entre 1 et %s \n", options.length ); 
		    return "";
		}
	}
	
	/**
	 * Affiche le résumé des choix du client pour une commande
	 * @param customerSelections : tableau contenant les choix du client
	 * @param nbOrder : numéro de la commande
	 */
	public static void displayCustomerSelections(String [] customerSelections, int nbOrder) {	
		// Convertit le tableau en liste 
		List<String> customerSelectionsList = new ArrayList<>(Arrays.asList(customerSelections));
		
		// On supprime les éléments "aucun" ou "aucune" de la liste
		customerSelectionsList.remove("aucun");
		customerSelectionsList.remove("aucune");
		
		// Convertit la liste filtrée de nouveau en tableau
		customerSelections = customerSelectionsList.toArray(new String[customerSelectionsList.size()]);
		
		// Affiche le résumé de la commande
		System.out.printf("Résumé de la commande n°%s : \n", nbOrder);
		System.out.println(Arrays.toString(customerSelections));
		System.out.println("");
	}
	
	/**
	 * Collecte les choix du client pour toutes les catégories de menu
	 * @param menu : Map contenant les catégories et leurs options
	 * @param scan : Scanner pour récupérer la saisie utilisateur
	 * @param customerSelections : tableau où seront stockés les choix
	 */
	public static void collectCustomerChoices(Map<String, String []> menu, Scanner scan, String[] customerSelections ) {
		int customerChoice;
		// Index pour ajouter le choix de l'utilisateur dans le tableau de séléction 
		int i = 0;
		
		for (Map.Entry<String, String[]> entry : menu.entrySet()) {
			// Nom de la catégorie 
	        String categoryName = entry.getKey(); 
	        // Tableau des options de cette catégorie
	        String[] options = entry.getValue();     

	        // Affiche les options 
	        displayMenuOptions(options, categoryName);   
	        // Récupère le choix du client
	        customerChoice = scan.nextInt();
	        // Stock le choix
	        customerSelections[i] = getCustomerSelection(customerChoice,options);
	        i++; 
	    }
	}
	
	// main----------------------------------------------------------------------------
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Un tableau pour chaque catégorie de menu
		String [] starter = { "salade", "soupe", "quiche", "aucune" };
		String [] mainDish = { "poulet", "boeuf", "poisson", "végétarien", "vegan", "aucun" };
		String [] sideDish = { "riz", "pates", "frites", "legumes", "aucun" };
		String [] dessert = { "tarte maison", "mousse au chocolat", "tiramisu", "aucun" };
		String [] drink = { "eau plate", "eau gazeuse", "soda", "vin", "aucune" };
		
		// Création du menu du restaurant en conservant l'ordre des catégories avec le LinkedHashMap
		Map<String, String []> restaurantMenu = new LinkedHashMap<>();
		restaurantMenu.put("entrées", starter);
		restaurantMenu.put("plats", mainDish);
		restaurantMenu.put("accompagnements", sideDish);
		restaurantMenu.put("dessert", dessert);
		restaurantMenu.put("boisson", drink);
		
		// Tableau pour stocker les choix du client
		String [] customerSelections = new String [5];
		
		System.out.println("Bonjour, bienvenue dans notre restaurant");
		System.out.println("------------------------------------");
		System.out.println("Combien de menus souhaitez-vous ?");
		int nbOrder = scan.nextInt();
		
		// Boucle pour chaque commande
		for (int i = 1; i <= nbOrder; i++) {
			System.out.printf("----------- Commande n°%s -----------\n", i);
			collectCustomerChoices(restaurantMenu, scan, customerSelections);
			displayCustomerSelections(customerSelections, nbOrder);
		}
		
		System.out.println("");
		System.out.println("Commande terminée. Bon appétit !!");
		scan.close();

	}
}