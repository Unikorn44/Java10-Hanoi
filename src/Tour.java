import java.util.LinkedList;

public class Tour {

	public String nom;
	LinkedList<Disque> list  = new LinkedList<>();
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public LinkedList<Disque> getList() {
		return list;
	}

	public void setList(LinkedList<Disque> list) {
		this.list = list;
	}
	
	public Tour(String nom) {
		this.setNom(nom);
		this.setList(new LinkedList<Disque>());
	}
	
	public Tour(String nom, LinkedList<Disque> list) {
		this.setNom(nom);
		this.setList(list);
	}
	
	public void add(Disque disque) {
		list.add(disque);
	}
	
	public Disque sommet() {
		return this.getList().getLast();
	}
	
	public void remove() {
		this.getList().removeLast();
	}

	public int size() {
		return this.getList().size();
	}

}
