import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter first numbers");
        int a =scanner.nextInt();
        System.out.println("enter second number");
        int b = scanner.nextInt();
        System.out.println("Choose an operator: +, -, *, or /");
        char operator = scanner.next().charAt(0);
        int result;
        switch (operator){
            case '+':
                result=a+b;
                System.out.println(a + "+" + b +"=" + result);
                break;
            case '-':
                result=a-b;
                System.out.println(a + "-" + b +"=" + result);
                break;
            case '*':
                result=a*b;
                System.out.println(a + "*" + b +"=" + result);
                break;
            case '/':
                result=a/b;
                System.out.println(a + "/" + b +"=" + result);
                break;
            default:
                System.out.println("Error: Invalid operator!");


        }




        }
    }


