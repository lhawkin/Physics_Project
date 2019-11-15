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
  
  //Default constructor prints the general function for the user to view
  public AtwoodPulley() {
    
    System.out.println("T - m1*g - m1*a = m2*g + m2*a - T   \n");
 
  }

  //Finds which variable needs to be solved for calls the proper method to solve
  public String baseSolver() {
    System.out.println("Enter code for the value you need to solve for   \n");
    System.out.println("T = 1 \nm1 = 2 \nm2 = 3 \na = 4  \ng = 5 \n\n");
    
    String solve = scan.nextLine();
    
    while (solve != "1" && solve != "2" && solve != "3" && solve != "4" && solve != "5"){
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
        returned = solveG();
        return "g = " + returned;
      default:
        returned = 0;
        return "status = unsolved";
    }

  }
  
  //Below are the different methods for solving for different missing values
    
  public double solveT() {
    

    
  }
  
  public double solveM1() {
    

    return 0.0;
  }
    
  public double solveM2() {
        

    return 0.0;
  }
      
  public double solveA() {
    
    System.out.println("a = g*(m1 - m2) / (m1 + m2)");
    
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
    
    System.out.print("Enter gravity value:  ") ;
    input = scan.nextLine();
    obj = (Object) input;
    this.g = (Double) obj;

    this.a = g*(m1 - m2) / (m1 + m2);
    
    return a;
  }
        
  public double solveG() {
    

    return 0.0;
  }
    
}
