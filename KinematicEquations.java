import java.util.ArrayList;
import java.util.Scanner;

class KinematicEquations implements requiredFunctions{
	private Object deltaX;
	private Double VNot;
	private Double T;
	private Double Acceleration;
	private Double finalVelocity;
	private String asking_for;
	Scanner scan = new Scanner(System.in);


	public KinematicEquations(){
		this.deltaX = null;
		this.VNot = null;
		this.T = null;
		this.Acceleration = null;
		this.finalVelocity = null;
	}
	//Finds which variable needs to be solved for calls the proper method to solve
	public String baseSolver() {
		System.out.println("Enter code for the value you need to solve for.   \n");
		System.out.println("Displacement = 1 \nInitial Velocity = 2 \nFinal Velocity = 3 \nAcceleration = 4  \nTime Interval = 5 \n\n");
		int solve = scan.nextInt();
		this.setAsking_for(asking_for);

		boolean cont = false;

		while (cont == false){
			if(solve != 1 && solve != 2 && solve != 3 && solve != 4 && solve != 5 && solve != 6) {
				System.out.println("Enter a valid number");
				solve = scan.nextInt();
			}
		    cont = true;
		}

		switch (solve) {
			case 1:
				this.setVNot();
				this.setAcceleration();
				this.setFinalVelocity();
				this.setT();
				break;
			case 2:
				this.setDeltaX();
				this.setAcceleration();
				this.setFinalVelocity();
				this.setT();
				break;
			case 3:
				this.setDeltaX();
				this.setAcceleration();
				this.setVNot();;
				this.setT();
				break;
			case 4:
				this.setDeltaX();
				this.setVNot();
				this.setFinalVelocity();
				this.setT();
				break;
			case 5:
				this.setDeltaX();
				this.setAcceleration();
				this.setFinalVelocity();
				this.setVNot();
				break;
			default:
				System.out.println("Nothing Happened.");
				break;
	    }
		System.out.println(this.getAllVariables().toString());
		return null;
	}

	public String getAsking_for() {
		return asking_for;
	}
	public void setAsking_for(String asking_for) {
		this.asking_for = asking_for;
	}
	public Double getDeltaX() {
		return deltaX;
	}
	public void setDeltaX() {
		System.out.print("Enter Displacement value, type NA if you dont have one: ") ;
		String input = scan.nextLine();
		if( input == "na") {
			this.deltaX = null;
		}
	    Object obj = (Object) input;
	    this.deltaX = obj;
	}
	public Double getVNot() {
		return VNot;
	}
	public void setVNot() {
		System.out.print("Enter Initial velocity value: ") ;
		double input = scan.nextDouble();
	    this.VNot = (Double) input;
	}
	public Double getT() {
		return T;
	}
	public void setT() {
		System.out.print("Enter Time interval value: ") ;
		double input = scan.nextDouble();
	    this.T = (Double) input;
	}
	public Double getAcceleration() {
		return Acceleration;
	}
	public void setAcceleration() {
		System.out.print("Enter Constant acceleration value: ") ;
		double input = scan.nextDouble();
	    this.Acceleration = (Double) input;
	}
	public Double getFinalVelocity() {
		return finalVelocity;
	}
	public void setFinalVelocity() {
		System.out.print("Enter Final velocity value: ") ;
		double input = scan.nextDouble();
	    this.finalVelocity = (Double) input;
	}


	// returns list of current variables.
	public ArrayList<Object> getAllVariables(){
		ArrayList<Object> ret = new ArrayList<Object>();
		ret.add(this.getAcceleration());
		ret.add(this.getDeltaX());
		ret.add(this.getVNot());
		ret.add(this.getT());
		ret.add(this.getFinalVelocity());
		return ret;
	}
	public static void main(String[] args) {
		KinematicEquations eq = new KinematicEquations();
		eq.baseSolver();
	}

}
