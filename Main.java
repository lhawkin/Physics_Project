<<<<<<< HEAD
import java.util.*;

//Will ask for a specific scenario and call the proper  class
public class Main {
  
  private int problemCode;
  private double commission;
  

  
  public Main() {}

  //Automatically runs
  public static void main(String args[])   {
    
    
    
    System.out.println("Select you scenario \n");
    
    System.out.println("Atwood Pulley = 1");
    System.out.println("Table Pulley  = 2");
    System.out.println("Thrown Object = 3 \n");
    
    Scanner find = new Scanner(System.in);
    String scene = find.nextLine();
    
    int numSolve = Integer.parseInt(scene);
    
    while (numSolve != 1 && numSolve != 2 && numSolve != 3) {
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
        
      default:
        //returned = 0;
        System.out.println("Scenario = not found");
        return;
    }

  
  }
  
}

=======
import java.util.*;

//WIll ask for a specific scenario and call the proper  class
public class Main {
  
  private int problemCode;
  private double commission;
  

  
  public Main() {}

  //Automatically runs
  public static void main(String args[]) {
    
    Scanner find = new Scanner(System.in);
  
    System.out.println("Select you scenario \n");
    
    System.out.println("Atwood Pulley = 1 \n");
    
    String scene = find.nextLine();
    
    while (scene != "1"){
      System.out.println("Enter a valid number") ;
      scene = find.nextLine();
    }
      
    Object objSolve = (Object) scene;
    int numSolve = (int) objSolve;
    

    
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
        
      default:
        //returned = 0;
        System.out.println("Scenario = not found");
        return;
    }

  
  }
  
}

>>>>>>> ed5975b7967de04653f513d30fc5c5d3e48d6cf7
