package model;
import java.util.ArrayList;

public class MathApp {
	//Attributes
	private int amount;
	
	ArrayList<IntegerSet> sets;		//Relationship
	
	//Constructor
	public MathApp () {
		amount = 0;
		sets = new ArrayList<IntegerSet>();
	}
	
	public void addSet (String name) {
		IntegerSet newSet = new IntegerSet (name);
		sets.add(newSet);
		amount = sets.size();
	}
	public void removeSet (String name) { 
		IntegerSet setToRemove = null;
		for (IntegerSet set : sets){
			if (set.getName().equalsIgnoreCase(name))
				setToRemove = set;
		}
		sets.remove(setToRemove);
		amount = sets.size();
	}
	public void addElementToSet (String setName, int element) {
		for (IntegerSet set : sets){
			if (set.getName().equalsIgnoreCase(setName))
				set.addElement(element);
		}
	}
	public void removeElementFromSet (String setName, int element) {
		for (IntegerSet set : sets){
			if (set.getName().equalsIgnoreCase(setName))
				set.removeElement(element);
		}
	}	
	public void union (String name1, String name2, String newName) {
		IntegerSet set1 = null, set2 = null;
		for (IntegerSet set : sets){
			if (set.getName().equalsIgnoreCase(name1))
				set1 = set;
			else if (set.getName().equalsIgnoreCase(name2))
				set2 = set;
		}
		sets.add(set2.union(set1, newName));
		amount = sets.size();
	}	
	public void difference (String name1, String name2, String newName) {
		IntegerSet set1 = null, set2 = null;
		for (IntegerSet set : sets){
			if (set.getName().equalsIgnoreCase(name1))
				set1 = set;
			else if (set.getName().equalsIgnoreCase(name2))
				set2 = set;
		}
		sets.add(set2.difference(set1, newName));
		amount = sets.size();
	}	
	public void intersection (String name1, String name2, String newName) {
		IntegerSet set1 = null, set2 = null;
		for (IntegerSet set : sets){
			if (set.getName().equalsIgnoreCase(name1))
				set1 = set;
			else if (set.getName().equalsIgnoreCase(name2))
				set2 = set;
		}
		sets.add(set2.intersection(set1, newName));
		amount = sets.size();
	}	
	public void symmetricDifference (String name1, String name2, String newName) {
		IntegerSet set1 = null, set2 = null;
		for (IntegerSet set : sets){
			if (set.getName().equalsIgnoreCase(name1))
				set1 = set;
			else if (set.getName().equalsIgnoreCase(name2))
				set2 = set;
		}
		sets.add(set2.symmetricDifference(set1, newName));
		amount = sets.size();
	}	
	public String showInfoSet (String name) {
		String message = "";
		for (IntegerSet set : sets){
			if (set.getName().equalsIgnoreCase(name))
				message = set.showContents();
		}
		return message;
	}
	public String showInfoSets () {
		String message = "";
		if (amount > 0){
			for (IntegerSet set : sets){
				message += "\n" + set.showContents();
			}
		}else 
			message += "No existen conjuntos para mostrar.";
		
		return message;
	}
	
	
	
}