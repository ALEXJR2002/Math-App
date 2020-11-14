package model;
import java.util.ArrayList;
public class IntegerSet{
	//Attributes
	private String name;
	private int cardinality;
	ArrayList<Integer> elements;
	
	//Constructor
	public IntegerSet (String name){
		this.name = name;
		cardinality = 0;
		elements = new ArrayList<Integer>();
	}
	// Get Methods
	public String getName () {
		return name;
	}
	public int getCardinality () {
		return cardinality;
	}
	public ArrayList<Integer> getElements () {
		return elements;
	}
	// End Get Methods
	
	public void addElement (int element) {
		if (!elements.contains(element))
			elements.add(element);
		cardinality = elements.size();
	}
	public void removeElement (int element) {
		if (elements.contains(element))
			elements.remove(elements.indexOf(element));
		cardinality = elements.size();
	}
	public IntegerSet union (IntegerSet set, String newName) {	
		IntegerSet resultSet = new IntegerSet (newName);
		resultSet.getElements().addAll(set.getElements()); 
		for (int element : elements) {
			if (!resultSet.getElements().contains(element))
				resultSet.getElements().add(element);
		}
		return resultSet;
	}
	public IntegerSet difference (IntegerSet set, String newName) {	
		IntegerSet resultSet = new IntegerSet (newName);
		for (int element : set.getElements()) {
			if (!elements.contains(element))
				resultSet.getElements().add(element); 
		}
		return resultSet;
	}
	public IntegerSet intersection (IntegerSet set, String newName) {	
		IntegerSet resultSet = new IntegerSet (newName);
		for (int element : set.getElements()) {
			if (elements.contains(element))
				resultSet.getElements().add(element); 
		}
		return resultSet;
	}
	public IntegerSet symmetricDifference (IntegerSet set, String newName) {	
		IntegerSet resultSet = new IntegerSet (newName);
		for (int element : set.getElements()) {
			if (!elements.contains(element))
				resultSet.getElements().add(element); 
		}
		for (int element : elements) {
			if (!set.getElements().contains(element))
				resultSet.getElements().add(element); 
		}
		return resultSet;
	}
	public String showContents () {
		String numbers = "";
		for (int element : elements)
			numbers += element + " ";
		return "*************  Conjunto **************" +
				"\n**  Nombre: " + name +
				"\n**  Numero de Elementos: " + cardinality +
				"\n**  Elementos: [ " + numbers + " ]" +
				"\n***********************************";
	}
	
	
}