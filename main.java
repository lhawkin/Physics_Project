import java.util.*;

//Will ask for a specific scenario and call the proper  class
public class main {
  
  private int problemCode;
  private double commission;
 

  //Automatically runs
  public static void main(String args[])   {
    
    
    
    System.out.println("Select you scenario \n");
    
    System.out.println("Atwood Pulley = 1");
    System.out.println("Table Pulley  = 2");
    System.out.println("Thrown Object = 3");
    System.out.println("Force Equations = 4");
    System.out.println("Custom Equation = 5");
    
    Scanner find = new Scanner(System.in);
    String scene = find.nextLine();
    
    int numSolve = Integer.parseInt(scene);
    
    while (numSolve != 1 && numSolve != 2 && numSolve != 3 && numSolve != 4 && numSolve != 5) {
      System.out.println("Enter a valid number") ;
      scene = find.nextLine();
      numSolve = Integer.parseInt(scene);
    }

    
    switch (numSolve) {
      case 1:
        AtwoodPulley aP = new AtwoodPulley();
        System.out.println(aP.baseSolver());
        return;
        
      case 2:
        TablePulley tP = new TablePulley();
        System.out.println(tP.baseSolver());
        return;
        
      case 3:
        KinematicEquations kE = new KinematicEquations();
        System.out.println(kE.baseSolver());
        return;
        
      case 4:
        forceEquations fE = new forceEquations();
        System.out.println(fE.baseSolver());
        return;
        
      case 5:
        CustomFunction cF = new CustomFunction();
        System.out.println("Enter Function: ");
        System.out.println(cF.solve(find.next()));
        return;
        
      default:
        //returned = 0;
        System.out.println("Scenario = not found");
        return;
    }

  
  }
  
}
