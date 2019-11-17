import java.util.Scanner;

class KinematicEquations implements requiredFunctions{
	private Double deltaX;
	private Double VNot;
	private Double T;
	private Double Acceleration;
	private Double finalVelocity;
	Scanner scan = new Scanner(System.in);

	
	public KinematicEquations(){
		this.deltaX = 0.0;
		this.VNot = 0.0;
		this.T = 0.0;
		this.Acceleration = 0.0;
		this.finalVelocity = 0.0;
	}
	//Finds which variable needs to be solved for calls the proper method to solve
	public String baseSolver() {
		System.out.println("Enter code for the value you need to solve for   \n");
		System.out.println("T = 1 \nm1 = 2 \nm2 = 3 \na = 4  \ng = 5 \n\n");
		System.out.println("Change gravity = 6");
		String solve = scan.nextLine();
		return null;
	}
	
	public Double getDeltaX() {
		return deltaX;
	}
	public void setDeltaX() {
		System.out.print("Enter Displacement value:  ") ;
	    String input = scan.nextLine();
	    Object obj = (Object) input;
	    this.deltaX = (Double) obj;
	}
	public Double getVNot() {
		return VNot;
	}
	public void setVNot() {
		System.out.print("Enter Initial velocity value:  ") ;
	    String input = scan.nextLine();
	    Object obj = (Object) input;
	    this.VNot = (Double) obj;
	}
	public Double getT() {
		return T;
	}
	public void setT(Double t) {
		System.out.print("Enter Time interval value:  ") ;
	    String input = scan.nextLine();
	    Object obj = (Object) input;
	    this.T = (Double) obj;
	}
	public Double getAcceleration() {
		return Acceleration;
	}
	public void setAcceleration(Double acceleration) {
		System.out.print("Enter Constant acceleration value:  ") ;
	    String input = scan.nextLine();
	    Object obj = (Object) input;
	    this.Acceleration = (Double) obj;
	}
	public Double getFinalVelocity() {
		return finalVelocity;
	}
	public void setFinalVelocity(Double finalVelocity) {
		System.out.print("Enter Final velocity value:  ") ;
	    String input = scan.nextLine();
	    Object obj = (Object) input;
	    this.finalVelocity = (Double) obj;
	}

}
