import processing.core.PApplet;

class Main {
	  	public static void main(String[] args) {

    	String[] processingArgs = {"Fracture"};
		Fracture mySketch = new Fracture();
	    PApplet.runSketch(processingArgs, mySketch);
		PApplet.main("Fracture");
	}
}
