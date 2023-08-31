public class CommandLineCalculator {
    public static void main(String[] args) {
        int a =Integer.valueOf(args[0]);
        char operator = args[1].charAt(0);
        int b = Integer.valueOf(args[2]);
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


