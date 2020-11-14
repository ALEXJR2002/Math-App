package ui;
import java.util.Scanner;
import model.MathApp;
public class Main{
	
	//Constants
	private final int EXIT = 0;
	private final int CREATE_SET = 1;
	private final int REMOVE_SET = 2;
	private final int ADD_ELEMENT = 3;
	private final int REMOVE_ELEMENT = 4;
	private final int UNION = 5;
	private final int DIFFERENCE = 6;	
	private final int INTERSECTION = 7;
	private final int SYMMETRIC_DIFFERENCE = 8;
	private final int SHOW_SET = 9;
	private final int SHOW_SETS = 10;
	
	private Scanner sc = new Scanner(System.in);
	private MathApp app = new MathApp();
	
	public static void main (String[]args){
		Main m;
		m = new Main();
		m.startProgram();
		
	}
	
	public void startProgram(){
		int option;
			do{
				showMenu();
				option = readOption();
				doOperation(option);
				System.out.print("\n");
			} while(option > 0);
	}
	
	public void showMenu (){
		System.out.println("[1] Crear conjunto.\n" +
							"[2] Borrar conjunto.\n" +
							"[3] Añadir elemento.\n" +
							"[4] Eliminar elemento.\n" +
							"[5] Union.\n" +
							"[6] Diferencia.\n" +
							"[7] Interseccion.\n" +
							"[8] Diferencia simetrica.\n" +
							"[9] Mostrar un conjunto.\n" +
							"[10] Mostrar todos los conjuntos.\n" +
							"[0] Salir");
	}
	
	public int readOption(){
		System.out.print("Opcion: ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.print("\n");
		return choice;
	}
	
	public void doOperation(int choice){
		switch (choice){
			case EXIT:
				System.out.println("!Adios!");
				break;
			case CREATE_SET:
				createSet ();
				break;
			case REMOVE_SET:
				removeSet ();
				break;
			case ADD_ELEMENT:
				addElement ();
				break;
			case REMOVE_ELEMENT:
				removeElement ();
				break;
			case UNION:
				union ();
				break;
			case DIFFERENCE:
				difference ();
				break;
			case INTERSECTION:
				intersection ();
				break;
			case SYMMETRIC_DIFFERENCE:
				symmetricDifference ();
				break;
			case SHOW_SET:
				showInfoSet ();
				break;
			case SHOW_SETS:
				showInfoSets ();
				break;
			default:
				System.out.println("Ingresa una opcion valida");
		}
	}
	
	public void createSet () {
		System.out.print("Ingrese el nombre del conjunto que desea crear: ");
		String name = sc.nextLine();
		app.addSet(name);
	}
	public void removeSet () {	
		System.out.print("Ingrese el nombre del conjunto que desea remover: ");
		String name = sc.nextLine();
		app.removeSet(name);
	}
	public void addElement () {
		System.out.print("Ingrese el nombre del conjunto al que desea agregar un elemento: ");
		String name = sc.nextLine();
		System.out.print("Ahora ingrese el numero que va a agregar: ");
		int element = sc.nextInt(); sc.nextLine();
		app.addElementToSet (name, element);
	}
	public void removeElement () {
		System.out.print("Ingrese el nombre del conjunto del que desea remover un elemento: ");
		String name = sc.nextLine();
		System.out.print("Ahora ingrese el numero que va a remover: ");
		int element = sc.nextInt(); sc.nextLine();
		app.removeElementFromSet (name, element);
	}
	public void union () {
		System.out.print("Ingrese el nombre del primer conjunto: ");
		String name1 = sc.nextLine();
		System.out.print("Ingrese el nombre del segundo conjunto: ");
		String name2 = sc.nextLine();
		System.out.print("Ingrese el nombre del nuevo conjunto: ");
		String newName = sc.nextLine();
		app.union(name1, name2, newName);
	}
	public void difference () {
		System.out.print("Ingrese el nombre del primer conjunto: ");
		String name1 = sc.nextLine();
		System.out.print("Ingrese el nombre del segundo conjunto: ");
		String name2 = sc.nextLine();
		System.out.print("Ingrese el nombre del nuevo conjunto: ");
		String newName = sc.nextLine();
		app.difference(name1, name2, newName);
	}
	public void intersection () {
		System.out.print("Ingrese el nombre del primer conjunto: ");
		String name1 = sc.nextLine();
		System.out.print("Ingrese el nombre del segundo conjunto: ");
		String name2 = sc.nextLine();
		System.out.print("Ingrese el nombre del nuevo conjunto: ");
		String newName = sc.nextLine();
		app.intersection(name1, name2, newName);
	}
	public void symmetricDifference () {
		System.out.print("Ingrese el nombre del primer conjunto: ");
		String name1 = sc.nextLine();
		System.out.print("Ingrese el nombre del segundo conjunto: ");
		String name2 = sc.nextLine();
		System.out.print("Ingrese el nombre del nuevo conjunto: ");
		String newName = sc.nextLine();
		app.symmetricDifference(name1, name2, newName);
	}
	public void showInfoSet () {
		System.out.print("Ingrese el nombre del conjunto que desea mostrar.");
		String name = sc.nextLine();
		System.out.println(app.showInfoSet (name));
	}
	public void showInfoSets () {
		System.out.println(app.showInfoSets ());
	}
	
	
}