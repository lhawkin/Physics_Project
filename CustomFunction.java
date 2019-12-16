import java.util.*;
import java.io.*;

public class CustomFunction {
  String func;
  HashMap vars;
  Scanner input = new Scanner(System.in);


  public CustomFunction() {
    this.func = "";
  }

  public Double solve(String str){
    this.func = str;
    return compute(func);
  }

  public String normalize(String str){
    System.out.println("The equation given is " + str);
    String result = "";
    HashMap<Character, Double> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++){
      if (Character.isLetter(str.charAt(i))){
        if (map.containsKey(str.charAt(i))){
          result += map.get(str.charAt(i));
        }
        else {
          System.out.println("What is the value for " + str.charAt(i) + " ?");
          Double value = input.nextDouble();
          map.put(str.charAt(i), value);
          result += value;

        }

      }
      else{
        result += str.charAt(i);
      }
    }
    //System.out.println("The normalized equation is:"+ result);
    return result;
  }

  public Double compute(String str) {
    str = normalize(str);
    String tempFunc = str;
    Stack<Double> nums = new Stack<Double>();
    Stack<String> ops = new Stack<String>();
    String opers = "+-*/^()";
    int i;

    if (tempFunc.equals(""))
      return 0.0;

    while (tempFunc.length() > 0) {
      i = 1;
      if (opers.indexOf(tempFunc.substring(0,1)) >= 0) {
        if (opers.indexOf(tempFunc.substring(0,1)) == 5){
          nums.push(compute(tempFunc.substring(tempFunc.indexOf("(") + 1, tempFunc.indexOf(")"))));
          tempFunc = tempFunc.substring(tempFunc.indexOf(")"));
        }
        else if (opers.indexOf(tempFunc.substring(0,1)) == 4){
          String temp = tempFunc.substring(0,1);
          tempFunc = tempFunc.substring(1);

          i = 0;
          while (i < tempFunc.length() && opers.indexOf(tempFunc.substring(i, i+1)) < 0)
            i++;
          nums.push(Double.parseDouble(tempFunc.substring(0,i)));
          nums.push(operate(nums.pop(), nums.pop(), temp));
        }
        else if (ops.empty())
          ops.push(tempFunc.substring(0,1));
        else if (opers.indexOf(tempFunc.substring(0,1)) < 2){
          while (!ops.empty()) {
            nums.push(operate(nums.pop(), nums.pop(), ops.pop()));
          }
          ops.push(tempFunc.substring(0,1));
        }
        else if (opers.indexOf(ops.peek()) < 2)
          ops.push(tempFunc.substring(0,1));
        else {
          nums.push(operate(nums.pop(), nums.pop(), ops.pop()));
          ops.push(tempFunc.substring(0,1));
        }
      } else {
        while (i < tempFunc.length() && opers.indexOf(tempFunc.substring(i, i+1)) < 0)
          i++;
        nums.push(Double.parseDouble(tempFunc.substring(0,i)));
      }
      if (tempFunc.length() > 0)
        tempFunc = tempFunc.substring(i);
    }
    while (!ops.empty())
      nums.push(operate(nums.pop(), nums.pop(), ops.pop()));

    return nums.pop();
  }

  private Double operate(Double num1, Double num2, String op) {
    if (op.equals("*"))
      return num1*num2;
    if (op.equals("/"))
      return num2/num1;
    if (op.equals("-"))
      return num2-num1;
    if (op.equals("+"))
      return num1+num2;
    if (op.equals("^"))
      return Math.pow(num2,num1);
    return 0.0;
  }
}