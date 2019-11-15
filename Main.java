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
        AtwoodPully aP = new AtwoodPulley();
        System.out.println(d.baseSolver());
      default:
        returned = 0;
        return "Scenario = not found";
    }

  
  }
  
}

