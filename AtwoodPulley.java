import java.util.*;

public class AtwoodPulley implements requiredFunctions {
  
  private int problemCode;
  
  Scanner scan = new Scanner(System.in);
  
  //list of all variables associated with a weighted pulley
  
  private double t;
  private double m1;
  private double m2;
  private double a;
  private double g = 9.8;
  private boolean gravityApp = false;
  
  //Default constructor prints the general function for the user to view
  public AtwoodPulley() {
    
    System.out.println("T - m1*g - m1*a = m2*g + m2*a - T   \n");
 
  }
  
  //setters and getters
  public void setT(double t) { this.t = t; }
  public double getT() { return t; }
  public void inputT(double t) { 
    System.out.print("Enter Tension force value:  ") ;
    Double input = scan.nextDouble();
    this.t = input; 
  }
  
  public void setM1(double m1) { this.m1 = m1; }
  public double getM1() { return m1; }
  public void inputM1() { 
    System.out.print("Enter Mass 1 (m1) value:  ") ;
    Double input = scan.nextDouble();
    this.m1 = input; 
  }
  
  public void setM2(double m2) { this.m2 = m2; }
  public double getM2() { return m2; }
  public void inputM2() { 
    System.out.print("Enter Mass 2 (m2) value:  ") ;
    Double input = scan.nextDouble();
    this.m2 = input; 
  }
  
  public void setA(double a) { this.a = a; }
  public double getA() { return a; }
  public void inputA() { 
    System.out.print("Enter Acceleration (a) value:  ") ;
    Double input = scan.nextDouble();
    this.a = input; 
  }
  
  public void setG(double t) { this.g = g; }
  public double getG() { return g; }
  public void inputG() { 
    System.out.print("Enter Gravity (g) value:  ") ;
    Double input = scan.nextDouble();
    this.g = input; 
  }
  
  
  //Finds which variable needs to be solved for calls the proper method to solve
  public String baseSolver() {
    System.out.println("Enter code for the value you need to solve for   \n");
    System.out.println("Tension (T)      = 1 \nMass 1 (m1)      = 2 \nMass (m2)        = 3 \nAcceleration (a) = 4 \nGravity (g)      = 5 \n");
    System.out.println("Change gravity = 6   \n");
    
    int solve = scan.nextInt();
    
    while (solve != 1 && solve != 2 && solve != 3 && solve != 4 && solve != 5 && solve != 6){
      System.out.println("Enter a valid number") ;
      solve = scan.nextInt();
    }
    
    while (solve == 6) {
      System.out.print("Enter new gravity: ");
      inputG();
      System.out.println("");
      System.out.println("Enter code for value \n");
      solve = scan.nextInt();
    }
    
    double returned;
    
    switch (solve) {
      case 1:
        returned = solveT();
        return "T = " + returned + "  Newtons";
      case 2:
        returned = solveM1();
        return "m1 = " + returned + "  kilograms";
      case 3:
        returned = solveM2();
        return "m2 = " + returned + "  kilograms";
      case 4:
        returned = solveA();
        return "a = " + returned + "  m/s^2";
      case 5:
        returned = solveG();
        return "g = " + returned + "  m/s^2";
      default:
        returned = 0;
        return "status = unsolved";
    }

  }
  
  //Below are the different methods for solving for different missing values
    
  public double solveT() {
    
    System.out.println("T = (2*m1*m2*g) / (m1 + m2) /n");
    
    inputM1();
    inputM2();
    
    this.t = (2*m1*m2*g) / (m1 + m2);
    
    return t;
    }

    
  
  
  public double solveM1() {
    System.out.println("m1  = (m2*g + m2*a) / (g - a) /n");
    
    inputA();
    inputM2();
 
    this.m1 = (m2*g + m2*a) / (g - a);
    
    return m1;
  }
    
  public double solveM2() {
    System.out.println("m2  = (m1*g + m1*a) / (g - a) /n");
    
    inputA();
    inputM1();
 
    this.m2 = (m1*g + m1*a) / (g - a);
    
    return m2;
  }
      
  public double solveA() {
    
    System.out.println("a = g*(m1 - m2) / (m1 + m2) /n");
    
    String input;
    Object obj;

    inputM1();
    inputM2();
    
    this.a = g*(m1 - m2) / (m1 + m2);
    
    return a;
  }
        
  public double solveG() {
    
    System.out.println("g  = (m1*a + m2*a) / (m1 - m2) /n");
    
    inputM1();
    inputM2();
    inputA();
    
    if (gravityApp = true) { inputG(); }
 
    this.g  = (m1*a + m2*a) / (m1 - m2);
    
    return g;
  }
}
    