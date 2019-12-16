import java.lang.Math;
import java.util.Scanner;

public class TablePulley implements requiredFunctions {
  
  private int problemCode;
  
  Scanner scan = new Scanner(System.in);
  
  //list of all variables associated with a weighted pulley
  
  private double t;
  private double m1;
  private double m2;
  private double a;
  private double mu = 0;
  private double ang;
  
  //Default constructor prints the general function for the user to view
  public TablePulley() {
    
    System.out.println("m1*g - T = m1*a"); 
    System.out.println("T - m2*g*cos(ang) * m2*g*Mu = m2*a");
 
  }

  //Finds which variable needs to be solved for calls the proper method to solve
  public String baseSolver() {
    System.out.println("Enter code for the value you need to solve for   \n");
    System.out.println("T = 1 \nm1 = 2 \nm2 = 3 \na = 4  \nmu = 5 \nA = 6 \n\n");
    
    String solve = scan.nextLine();
    
    while (solve != "1" && solve != "2" && solve != "3" && solve != "4" && solve != "5" && solve != "6"){
      System.out.println("Enter a valid number") ;
      solve = scan.nextLine();
    }
      
    Object objSolve = (Object) solve;
    int numSolve = (int) objSolve;
    
    double returned;
    
    switch (numSolve) {
      case 1:
        returned = solveT();
        return "T = " + returned;
      case 2:
        returned = solveM1();
        return "m1 = " + returned;
      case 3:
        returned = solveM2();
        return "m2 = " + returned;
      case 4:
        returned = solveA();
        return "a = " + returned;
      case 5:
        returned = solveMu();
        return "mu = " + returned;
      case 6:
        returned = solveAng();
        return "ang = " + returned;
      default:
        returned = 0;
        return "status = unsolved";
    }

  }
  
  //Below are the different methods for solving for different missing values
    
  public double solveT() {
    
    System.out.println("T = (m2*g - m2*a + m1*a + u*m1*g) / 2");
    
    String input;
    Object obj;
       
    System.out.print("Enter acceleration value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.a = (Double) obj;
    
    System.out.print("Enter mass 1 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m1 = (Double) obj;
    
    System.out.print("Enter mass 2 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m2 = (Double) obj;
    
    System.out.print("Enter mu value (if frictionless enter 0):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.mu = (Double) obj;

    System.out.print("Enter theta value (in degrees):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.ang = (Double) obj;
    
    t = (m2*9.8 - m2*a + m1*a + mu*m1*9.8) / 2;
    
    return t;
    
  }
  
  public double solveM1() {
    System.out.println("m1 = m2 * (a + g * cos(ang) + mu * g) / (g - a)");
    
    String input;
    Object obj;
       
    System.out.print("Enter acceleration value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.a = (Double) obj;
    
    System.out.print("Enter mass 2 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m2 = (Double) obj;
    
    System.out.print("Enter mu value (if frictionless enter 0):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.mu = (Double) obj;

    System.out.print("Enter theta value (in degrees):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.ang = (Double) obj;
    
    m1 = m2 * (a + (9.8 * Math.cos(ang)) + (mu * 9.8)) / (9.8 - a);
    
    return m1;
  }
    
  public double solveM2() {
    System.out.println("m2 = m1 * (g - a) / (a + g * cos(ang) + mu * g)");
    
    String input;
    Object obj;
    
    System.out.print("Enter acceleration value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.a = (Double) obj;
    
    System.out.print("Enter mass 1 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m1 = (Double) obj;
    
    System.out.print("Enter mu value (if frictionless enter 0):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.mu = (Double) obj;

    System.out.print("Enter theta value (in degrees):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.ang = (Double) obj;
    
    m2 = m1 * (9.8 - a) / (a + (9.8 * Math.cos(ang)) + (mu * 9.8));
    
    return m2;
  }
      
  public double solveA() {
    
    System.out.println("a = g * (m1 - m2 * cos(ang) - m2 * mu) / (m1 + m2)");
    
    String input;
    Object obj;
      
    System.out.print("Enter mass 1 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m1 = (Double) obj;    
    
    System.out.print("Enter mass 2 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m2 = (Double) obj;
    
    System.out.print("Enter mu value (if frictionless enter 0):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.mu = (Double) obj;

    System.out.print("Enter theta value (in degrees):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.ang = (Double) obj;
    
    a = 9.8 * ((m1) - (m2 * Math.cos(Math.toRadians(ang))) - (m2*mu)) / (m2+m1);
    
    return a;
  }
        
  public double solveMu() {
    System.out.println("mu = (m1 * g - m1 * a - m2 * a - m2 * 9.8 * Math.cos(ang)) / (m2 * g))");
    
    String input;
    Object obj;
      
    System.out.print("Enter mass 1 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m1 = (Double) obj;    
    
    System.out.print("Enter mass 2 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m2 = (Double) obj;
    
    System.out.print("Enter acceleration value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.a = (Double) obj;

    System.out.print("Enter theta value (in degrees):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.ang = (Double) obj;
    
    mu = ((m1 * 9.8) - (m1 * a) - (m2 * a) - (m2 * 9.8 * Math.cos(ang))) / (m2 * 9.8);
    
    return mu;
  }
   
  public double solveAng() {
    System.out.println("theta = arccos((m1 * g - m1 * a - m2 * a - mu * m2 * g) / (m2 * g))");
    
    String input;
    Object obj;
      
    System.out.print("Enter mass 1 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m1 = (Double) obj;    
    
    System.out.print("Enter mass 2 value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.m2 = (Double) obj;
    
    System.out.print("Enter acceleration value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.a = (Double) obj;

    System.out.print("Enter mu value (if frictionless enter 0):  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.mu = (Double) obj;
    
    ang = Math.acos(((m1 * 9.8) - (m1 * a) - (m2 * a) - (mu * m2 * 9.8)) / (m2 * 9.8));
    
    return ang;
  }
}