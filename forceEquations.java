package com.finalproj;
import java.lang.Math;
import java.util.*;

public class forceEquations implements requiredFunctions{

    Scanner input = new Scanner(System.in);
    private int choice;
    //All variables associated with force
    //For now, spring and applied force is assumed to be horizontal

    private double appliedF;
    private double normalF;
    private double fG;
    private double frictionS;
    private double frictionK;
    // mu = coefficient of friction (static or kinetic)
    private double mu;
    private double springF;
    private double springX;
    private double springK;
    private double accel;
    private double mass;


    public double getAppliedF() {
        return appliedF;
    }

    public double getNormalF() {
        return normalF;
    }

    public double getfG() {
        return fG;
    }

    public double getFrictionS() {
        return frictionS;
    }

    public double getFrictionK() {
        return frictionK;
    }

    public double getMu() {
        return mu;
    }

    public double getSpringF() {
        return springF;
    }

    public double getAccel() {
        return accel;
    }

    public double getMass() {
        return mass;
    }

    public double getSpringK() {
        return springK;
    }

    public void setSpringK(double springK) {
        this.springK = springK;
    }

    public double getSpringX() {
        return springX;
    }

    public void setSpringX(double springX) {
        this.springX = springX;
    }

    public void setAppliedF(double appliedF) {
        this.appliedF = appliedF;
    }

    public void setNormalF(double normalF) {
        this.normalF = normalF;
    }

    public void setfG(double fG) {
        this.fG = fG;
    }

    public void setFrictionS(double frictionS) {
        this.frictionS = frictionS;
    }

    public void setFrictionK(double frictionK) {
        this.frictionK = frictionK;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public void setSpringF(double springF) {
        this.springF = springF;
    }

    public void setAccel(double accel) {
        this.accel = accel;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    //Default constructor will print out formulas for the user to see
    public forceEquations(){
        System.out.println("The equations that may be used are: ");
        System.out.println("F = m*a");
        System.out.println("Fg = m*g");
        System.out.println("Fnormal = |m*g|");
        System.out.println("Fstatic = Ms * Fn");
        System.out.println("Fkinetic = Mk * Fn");
        System.out.println("Fspring = -k*x");
    }


    @Override
    public String baseSolver() {
        System.out.println("Enter the number that matches the variable you need solved\n");
        System.out.println("Force = 1 \nForce of gravity = 2\nNormal Force = 3");
        System.out.println("Force of Static Friction = 4\n Force of Kinetic Friction = 5");
        System.out.println("Spring Force = 6");


        choice = input.nextInt();

        while(choice < 1 || choice > 6){
            System.out.println("Please enter a valid number");
            choice = input.nextInt();


        }
        double output;
        switch (choice){
            case 1:
                output = solveF();
                return "F = " + output;
            case 2:
                output = solveFg();
                return "Fg = " + output;
            case 3:
                output = solveFNorm();
                return "Fnormal = " + output;
            case 4:
                output = solveStatic();
                return "Force of Static Friction = " + output;
            case 5:
                output = solveKinetic();
                return "Force of Kinetic Friction = " + output;
            case 6:
                output = solveSpring();
                return "Spring Force = " + output;
            default:
                return "Unsolved";

        }
    }

    public double solveF(){
        System.out.println("F = m*a");
        System.out.println("Please provide all values as decimals (ex: '4.0')");

        System.out.println("Enter value for mass");

        mass = input.nextDouble();

        System.out.println("Enter value for acceleration");

        accel = input.nextDouble();

        double result = mass * accel;
        return result;


    }

    public double solveFg(){
        System.out.println("Fg = m*g");
        System.out.println("Please provide all values as decimals (ex: '4.0')");

        System.out.println("Enter value for mass");
        mass = input.nextDouble();

        double result = mass * 9.8 * -1.0;
        return result;
    }

    public double solveFNorm(){
        System.out.println("FNorm = |m*g|");
        System.out.println("Please provide all values as decimals (ex: '4.0')");

        System.out.println("Enter value for mass");
        mass = input.nextDouble();

        double result = mass * 9.8;
        return result;
    }

    public double solveStatic(){
        System.out.println("Fstatic = Ms * Fn");
        System.out.println("Please provide all values as decimals (ex: '4.0')");

        System.out.println("Enter value for Mu Static (The coefficient of Static Friction");
        mu = input.nextDouble();

        System.out.println("Enter the value for Normal Force");
        normalF = input.nextDouble();
        return mu * normalF;
    }

    public double solveKinetic(){
        System.out.println("Fkinetic = Mk * Fn");
        System.out.println("Please provide all values as decimals (ex: '4.0')");

        System.out.println("Enter value for Mu Kinetic (The coefficient of Kinetic Friction");
        mu = input.nextDouble();

        System.out.println("Enter the value for Normal Force");
        normalF = input.nextDouble();
        return mu * normalF;
    }

    public double solveSpring(){
        System.out.println("Fspring = -k*x");
        System.out.println("Please provide all values as decimals (ex: '4.0')");

        System.out.println("Enter the value for K (The spring constant)");
        springK = input.nextDouble();

        System.out.println("Enter the value for x (The distance of the Spring's extension");
        springX = input.nextDouble();

        double result = springK * springX * (double)(-1);
        return result;

    }


}






































