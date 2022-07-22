import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Jeu {
	
	Tour tourA;
	Tour tourB;
	Tour tourC;
	int nbreTours = 0;
	Ecriteur ecriteur;
	
	
	public Jeu() {
		tourA = new Tour("A");
		tourB = new Tour("B");
		tourC = new Tour("C");
		this.ecriteur = new Ecriteur();
	}
	
	

	public void run() {
		
		this.creationDisques(tourA);
		this.ecriteur.brosse();
		this.bilanTour();
		hanoi(getTourA().size(), tourA, tourC, tourB);
	}

	
	public Tour getTourA() {
		return tourA;
	}

	public void setTourA(Tour tourA) {
		this.tourA = tourA;
	}


	public Tour getTourB() {
		return tourB;
	}

	public void setTourB(Tour tourB) {
		this.tourB = tourB;
	}


	public Tour getTourC() {
		return tourC;
	}

	public void setTourC(Tour tourC) {
		this.tourC = tourC;
	}


	//fonction création disques
	private void creationDisques(Tour tourA) {
		System.out.println("Avec combien de disques voulez-vous jouer ?");
		//lecture console
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		//try catch pour lecture console
		try {
			this.setNbreDisque(Integer.parseInt(buff.readLine()), tourA);			
		} catch(Exception err) {
			
		}
	}
	
	public void hanoi(int nbreDisque, Tour tourDepart, Tour tourArrivee, Tour tourIntermediaire) {
		if(nbreDisque>0) {
			hanoi((nbreDisque-1), tourDepart, tourIntermediaire, tourArrivee);
			this.deplacement(tourDepart, tourArrivee);
			nbreTours += 1;
			bilanTour();
			hanoi((nbreDisque-1), tourIntermediaire, tourArrivee, tourDepart);
		}
	}
	
	public void deplacement(Tour tourDepart, Tour tourArrivee) {
		tourArrivee.add(tourDepart.sommet());
		tourDepart.remove();
	}
	
	//fonction création des disques différentes largeurs
	private void setNbreDisque(int nBreDisque, Tour tourA) {
		for(int i=nBreDisque; i>=1; i--) {
			Disque disque  = new Disque(i);
			tourA.add(disque);
		}
	}

	private void bilanTour() {
		
		//System.out.println("--Etape n° " + nbreTours + "--");
		//System.out.println("--Tour A--");
		ecriteur.run("--Etape n° " + nbreTours + "--");
		ecriteur.run("--Tour A--");
		for(Disque d : tourA.getList()) {			
			//System.out.print("-" +  d.getLargeur() + "- ");
			ecriteur.run("-" +  d.getLargeur() + "- ");
		}
		//System.out.println(" ");
		//System.out.println("--Tour B--");
		ecriteur.run(" ");
		ecriteur.run("--Tour B--");
		for(Disque d : tourB.getList()) {			
			//System.out.print("-" +  d.getLargeur() + "- ");
			ecriteur.run("-" +  d.getLargeur() + "- ");
		}
		//System.out.println(" ");
		//System.out.println("--Tour C--");
		ecriteur.run(" ");
		ecriteur.run("--Tour C--");
		for(Disque d : tourC.getList()) {			
			//System.out.print("-" +  d.getLargeur() + "- ");
			ecriteur.run("-" +  d.getLargeur() + "- ");
		}
		//System.out.println(" ");
		//System.out.println("------");
		ecriteur.run("  ");
		ecriteur.run("------");
		
	}

	
}
