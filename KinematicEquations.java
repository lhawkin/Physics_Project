
import java.util.*;

class KinematicEquations implements requiredFunctions{
    private double deltaX = Double.NaN;
    private double VNot= Double.NaN;
    private double T= Double.NaN;
    private double Acceleration= Double.NaN;
    private double finalVelocity= Double.NaN;
    private String asking_for;
    Scanner scan = new Scanner(System.in);


    public KinematicEquations(){
        System.out.println("The Kinematic Equations are: \nv = v0 + at \nDeltaX = ((v+v0)/2)t \nDeltaX = v0(t) + 1/2(at^2) \nv^2 = v0^2 + 2a(DeltaX)\nDeltaX = v(t) + 1/2(at^2)");
    }
    //Finds which variable needs to be solved for calls the proper method to solve
    public String baseSolver() {
        System.out.println("---------------------\nWhich variable are you solving for?\n");
        System.out.println("Displacement = 1 \nInitial Velocity = 2 \nFinal Velocity = 3 \nAcceleration = 4  \nTime Interval = 5\n");
        System.out.println("Enter code here: ");
        int solve = scan.nextInt();

        boolean cont = false;

        while (!cont){
            if(solve != 1 && solve != 2 && solve != 3 && solve != 4 && solve != 5 && solve != 6) {
                System.out.println("Enter a valid number");
                solve = scan.nextInt();
            }
            cont = true;
        }
        this.setAsking_for(solve);
        String finalret = "";
        switch (solve) {
            case 1:
                finalret = "Displacement = " + this.solveDeltaX();
                break;
            case 2:
                finalret = "Initial Velocity = " + this.solveInitialVelocity();
                break;
            case 3:
                finalret = "Final Velocity = " + this.solveFinalVelocity();
                break;
            case 4:
                finalret = "Acceleration = " + this.solveAcceleration();
                break;
            case 5:
                finalret = "Time Interval = " + this.solveTimeInterval();
                break;
            default:
                System.out.println("Nothing Happened.");
                break;
        }
//        System.out.println(this.getAllVariables().toString());
        return finalret;
    }

    public String getAsking_for() {
        return asking_for;
    }
    public void setAsking_for(int solve) {
        if(solve == 1){
            this.asking_for = "Displacement";
        }
        if(solve == 2){
            this.asking_for = "Initial Velocity";
        }
        if(solve == 3){
            this.asking_for = "Final Velocity";
        }
        if(solve == 4){
            this.asking_for = "Acceleration";
        }
        if(solve == 5){
            this.asking_for = "Time Interval";
        }
    }
    public Double getDeltaX() {
        return deltaX;
    }
    public void setDeltaX() {
        //10001011 is sum of the number representation of ayousuf + 21 = 139
        System.out.print("Enter Displacement value or copy and paste .10001011: ") ;
        double input = Double.NaN;
        try{
            input = scan.nextDouble();
            if (input == .10001011 || input == 10001011){
                input = Double.NaN;
            }
        }catch (InputMismatchException ignored){

        }finally {
            this.deltaX = input;
        }
    }
    public Double getVNot() {
        return VNot;
    }
    public void setVNot() {
        //10001011 is sum of the number representation of ayousuf + 21 = 139
        System.out.print("Enter Initial velocity value or copy and paste .10001011: ") ;
        double input = Double.NaN;
        try{
            input = scan.nextDouble();
            if (input == .10001011 || input == 10001011){
                input = Double.NaN;
            }
        }catch (InputMismatchException e){

        }finally {
            this.VNot = input;
        }
    }
    public Double getT() {
        return T;
    }
    public void setT() {
        //10001011 is sum of the number representation of ayousuf + 21 = 139
        System.out.print("Enter Time interval value or copy and paste .10001011: ") ;
        double input = Double.NaN;
        try{
            input = scan.nextDouble();
            if (input == .10001011 || input == 10001011){
                input = Double.NaN;
            }
        }catch (InputMismatchException ignored){

        } finally {
            this.T = input;
        }
    }
    public Double getAcceleration() {
        return Acceleration;
    }
    public void setAcceleration() {
        //10001011 is sum of the number representation of ayousuf + 21 = 139
        System.out.print("Enter Constant acceleration value or copy and paste .10001011: ") ;
        double input = Double.NaN;
        try{
            input = scan.nextDouble();
            if (input == .10001011 || input == 10001011){
                input = Double.NaN;
            }
        }catch (InputMismatchException ignored){

        }finally {
            this.Acceleration = input;
        }
    }
    public Double getFinalVelocity() {
        return finalVelocity;
    }
    public void setFinalVelocity() {
        //10001011 is sum of the number representation of ayousuf + 21 = 139
        System.out.print("Enter Final velocity value or copy and paste .10001011: ") ;
        double input = Double.NaN;
        try{
            input = scan.nextDouble();
            if (input == .10001011 || input == 10001011){
                input = Double.NaN;
            }
        }catch (InputMismatchException ignored){

        }finally {
            this.finalVelocity = input;
        }
    }

    // returns list of current variables.
    public HashMap<Object, Object> getAllVariables(){
        HashMap<Object, Object> ret = new HashMap<Object, Object>();
        ret.put("Displacement", this.getDeltaX());
        ret.put("Acceleration", this.getAcceleration());
        ret.put("Initial Velocity", this.getVNot());
        ret.put("Final Velocity", this.getFinalVelocity());
        ret.put("Time Interval", this.getT());
        return ret;
    }

    public double solveDeltaX() {
        double ret = 0;
        setVNot();
        setAcceleration();
        setFinalVelocity();
        setT();
        HashMap<Object, Object> map = this.getAllVariables();
        String whatsMissing = "";
        int counter = 0;
        for (Map.Entry mapElement : map.entrySet()) {
            if(mapElement.getValue().equals(Double.NaN)) {
                if (mapElement.getKey() != this.getAsking_for()){
                    whatsMissing = (String) mapElement.getKey();
                }
                counter++;
            }
        }
        if(counter != 2){
            System.out.println("\n-------------------ERROR-------------------");
            System.out.println("You gave the calculator too many or too little numbers. Your question should only give you 3 three variables. Please start from the top.");
            System.out.println("-------------------ERROR--------------------");
            System.exit(1);
        }
        switch (whatsMissing) {
            case "Final Velocity":
                ret = this.getVNot() * this.getT() + 0.5 * (this.getAcceleration() * Math.pow(this.getT(), 2));
                break;
            case "Acceleration":
                double firstHalf = this.getFinalVelocity() + this.getVNot();
                ret = (firstHalf / 2) * this.getT();
                break;
            case "Time Interval":
                ret = (
                        (Math.pow(this.getFinalVelocity(), 2) / (2 * this.getAcceleration())) - (Math.pow(this.getVNot(), 2) / (2 * this.getAcceleration()))
                );
                break;
            case "Initial Velocity":
                ret = this.getFinalVelocity() * this.getT() + 0.5 * (this.getAcceleration() * Math.pow(this.getT(), 2));
                break;
            default:
                System.out.println("Im screwed");
                break;
        }

        return ret;
    }
    public double solveAcceleration(){
        double ret = 0;
        this.setDeltaX();
        this.setVNot();
        this.setFinalVelocity();
        this.setT();
        HashMap<Object, Object> map = this.getAllVariables();
        String whatsMissing = "";
        int counter = 0;
        for (Map.Entry mapElement : map.entrySet()) {
            if(mapElement.getValue().equals(Double.NaN)) {
                if (mapElement.getKey() != this.getAsking_for()){
                    whatsMissing = (String) mapElement.getKey();
                }
                counter++;
            }
        }
        if(counter != 2){
            System.out.println("\n-------------------ERROR-------------------");
            System.out.println("You gave the calculator too many or too little numbers. Your question should only give you 3 three variables. Please start from the top.");
            System.out.println("-------------------ERROR--------------------");
            System.exit(1);
        }

        switch (whatsMissing) {
            case "Displacement":
                ret = ((this.getFinalVelocity() / this.getT()) - (this.getVNot() / this.getT()));
                break;
            case "Final Velocity": {
                double firstHalf = (2 * this.getDeltaX()) / Math.pow(this.getT(), 2);
                double secondHalf = (2 * this.getVNot()) / this.getT();
                ret = firstHalf - secondHalf;
                break;
            }
            case "Time Interval": {
                double firstHalf = (Math.pow(this.getFinalVelocity(), 2) / (2 * this.getDeltaX()));
                double secondHalf = (Math.pow(this.getVNot(), 2) / (2 * this.getDeltaX()));
                ret = firstHalf - secondHalf;
                break;
            }
            case "Initial Velocity": {
                double firstHalf = (2 * this.getDeltaX()) / Math.pow(this.getT(), 2);
                double secondHalf = (2 * this.getFinalVelocity()) / this.getT();
                ret = firstHalf - secondHalf;

                break;
            }
            default:
                System.out.println("Im screwed");
                break;
        }

        return ret;
    }

    public double solveInitialVelocity(){
        double ret = 0;
        this.setDeltaX();
        this.setAcceleration();
        this.setFinalVelocity();
        this.setT();
        HashMap<Object, Object> map = this.getAllVariables();
        String whatsMissing = "";
        int counter = 0;
        for (Map.Entry mapElement : map.entrySet()) {
            if(mapElement.getValue().equals(Double.NaN)) {
                if (mapElement.getKey() != this.getAsking_for()){
                    whatsMissing = (String) mapElement.getKey();
                }
                counter++;
            }
        }
        if(counter != 2){
            System.out.println("\n-------------------ERROR-------------------");
            System.out.println("You gave the calculator too many or too little numbers. Your question should only give you 3 three variables. Please start from the top.");
            System.out.println("-------------------ERROR--------------------");
            System.exit(1);
        }

        switch (whatsMissing) {
            case "Displacement":
                ret = (this.getFinalVelocity() - (this.getAcceleration()*this.getT()));
                break;

            case "Final Velocity": {
                double firstHalf = this.getDeltaX()/this.getT();
                double secondHalf = (this.getAcceleration() * this.getT())/2;
                ret = firstHalf - secondHalf;
                break;
            }
            case "Time Interval": {
                double quadraticEquationOne = Math.sqrt((Math.pow(this.getFinalVelocity(),2)-(2*(this.getAcceleration()*this.getDeltaX()))));
                double quadraticEquationTwo = -1*quadraticEquationOne;
                if (quadraticEquationOne < 0 || quadraticEquationTwo < 0){
                    ret = Math.max(quadraticEquationOne,quadraticEquationTwo);
                }
                if (quadraticEquationOne > 0 && quadraticEquationTwo > 0){
                    ret = Math.min(quadraticEquationOne,quadraticEquationTwo);
                }
                break;
            }
            case "Acceleration": {
                double firstHalf = (2*this.getDeltaX())/this.getT();
                double secondHalf = this.getFinalVelocity();
                ret = firstHalf - secondHalf;
                break;
            }
            default:
                System.out.println("Im screwed");
                break;
        }

        return ret;
    }

    public double solveFinalVelocity(){
        double ret = 0;
        this.setDeltaX();
        this.setAcceleration();
        this.setVNot();;
        this.setT();
        HashMap<Object, Object> map = this.getAllVariables();
        String whatsMissing = "";
        int counter = 0;
        for (Map.Entry mapElement : map.entrySet()) {
            if(mapElement.getValue().equals(Double.NaN)) {
                if (mapElement.getKey() != this.getAsking_for()){
                    whatsMissing = (String) mapElement.getKey();
                }
                counter++;
            }
        }
        if(counter != 2){
            System.out.println("\n-------------------ERROR-------------------");
            System.out.println("You gave the calculator too many or too little numbers. Your question should only give you 3 three variables. Please start from the top.");
            System.out.println("-------------------ERROR--------------------");
            System.exit(1);
        }

        switch (whatsMissing) {
            case "Displacement":
                ret = this.getVNot() + (this.getAcceleration()*this.getT());
                break;

            case "Initial Velocity": {
                double firstHalf = this.getDeltaX()/this.getT();
                double secondHalf = (this.getAcceleration() * this.getT())/2;
                ret = firstHalf + secondHalf;
                break;
            }
            case "Time Interval": {
                double quadraticEquationOne = Math.sqrt((Math.pow(this.getVNot(),2)-(2*(this.getAcceleration()*this.getDeltaX()))));
                double quadraticEquationTwo = -1*quadraticEquationOne;
                if (quadraticEquationOne < 0 || quadraticEquationTwo < 0){
                    ret = Math.max(quadraticEquationOne,quadraticEquationTwo);
                }
                if (quadraticEquationOne > 0 && quadraticEquationTwo > 0){
                    ret = Math.min(quadraticEquationOne,quadraticEquationTwo);
                }
                break;
            }
            case "Acceleration": {
                double firstHalf = (2*this.getDeltaX())/this.getT();
                double secondHalf = this.getVNot();
                ret = firstHalf - secondHalf;
                break;
            }
            default:
                System.out.println("Im screwed");
                break;
        }

        return ret;
    }

    public double solveTimeInterval(){
        double ret = 0;
        this.setDeltaX();
        this.setAcceleration();
        this.setFinalVelocity();
        this.setVNot();
        HashMap<Object, Object> map = this.getAllVariables();
        String whatsMissing = "";
        int counter = 0;
        for (Map.Entry mapElement : map.entrySet()) {
            if(mapElement.getValue().equals(Double.NaN)) {
                if (mapElement.getKey() != this.getAsking_for()){
                    whatsMissing = (String) mapElement.getKey();
                }
                counter++;
            }
        }
        if(counter != 2){
            System.out.println("\n-------------------ERROR-------------------");
            System.out.println("You gave the calculator too many or too little numbers. Your question should only give you 3 three variables. Please start from the top.");
            System.out.println("-------------------ERROR--------------------");
            System.exit(1);
        }

        switch (whatsMissing) {
            case "Displacement":
                ret = (this.getFinalVelocity()/this.getAcceleration()) - (this.getVNot()/this.getAcceleration());
                break;

            case "Final Velocity": {
                double a = 0.5*this.getAcceleration();
                double b = this.getVNot();
                double c = this.getDeltaX()*-1;
                double[] secondHalf = this.quadraticFormula(a,b,c);
                if (secondHalf[0] < 0 || secondHalf[1] < 0){
                    ret = Math.max(secondHalf[0],secondHalf[1]);
                }
                if (secondHalf[0] > 0 && secondHalf[1] > 0){
                    ret = Math.min(secondHalf[0],secondHalf[1]);
                }
                break;
            }
            case "Initial Velocity": {
                double a = 0.5*this.getAcceleration();
                double b = this.getFinalVelocity();
                double c = this.getDeltaX();
                double[] secondHalf = this.quadraticFormula(a,b,c);
                if (secondHalf[0] < 0 || secondHalf[1] < 0){
                    ret = Math.max(secondHalf[0],secondHalf[1]);
                }
                if (secondHalf[0] > 0 && secondHalf[1] > 0){
                    ret = Math.min(secondHalf[0],secondHalf[1]);
                }
                break;
            }
            case "Acceleration": {
                ret = (2*this.getDeltaX()/(this.getVNot()+this.getFinalVelocity()));
                break;
            }
            default:
                System.out.println("Im screwed");
                break;
        }

        return ret;
    }

    public double[] quadraticFormula(double a, double b, double c){
        double[] roots = {0,0};
        double root1, root2;
        double determinant = b * b - 4 * a * c;
        // condition for real and different roots
        if(determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            roots[0] = root1;
            roots[1] = root2;
        }
        // Condition for real and equal roots
        if(determinant == 0) {
            root1 = root2 = -b / (2 * a);
            roots[0] = root1;
            roots[1] = root1;
        }
        // If roots are not real
        return roots;
    }
    
    public static void main (String[] args){
      KinematicEquations eq = new KinematicEquations();
      eq.baseSolver();
    }
}