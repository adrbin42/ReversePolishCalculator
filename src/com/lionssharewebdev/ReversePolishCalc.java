package com.lionssharewebdev;

/**
 * Created by adrienne on 7/20/17.
 */
public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
    //when push increases and when you pop decreases
    int topOfStack = 0;

    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {
        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(",");
        System.out.println(tokens);

        // 2. Allocate a stack as big as the number of tokens
        stack = new String[tokens.length];

        // 3. write the algorithm
        for (int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
            if(isNumeric( tokens[i] )) {
                double number = Double.parseDouble(tokens[i]);
                push(number);
            } else {
                double number2 = pop();
                double number1 = pop();
                String oper = tokens[i];
                switch (oper) {
                    case "+":
//                        System.out.println("Adding " + num1 + " and " + num2);
                        push(number1 + number2);
                        break;
                    case "-":
//                        System.out.println("Subtracting " + num1 + " and " + num2);
                        push(number1 - number2);
                        break;
                    case "*":
//                        System.out.println("Multiplying " + num1 + " and " + num2);
                        push(number1 * number2);
                        break;
                    case "/":
//                        System.out.println("Dividing " + num1 + " and " + num2);
                        push(number1 / number2);
                        break;
                }
            }
        }
            // 4. return the result
            return pop();
    }


    private void push(String number) {
        stack[topOfStack++] = number;
    }

    //Is input a number
    public static boolean isNumeric(String string){
      try{
          double stringDouble = Double.parseDouble(string);
      }catch (NumberFormatException ex){
          return false;
      }
      return true;
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        push(d+"");
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        double removeParse = Double.parseDouble(stack[--topOfStack]);
        return  removeParse;
    }
}
