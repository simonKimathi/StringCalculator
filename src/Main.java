import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome \n --------------");
        System.out.println("Enter the first number:");
        String num1=scanner.nextLine();
        System.out.println("Enter the second number:");
        String num2=scanner.nextLine();
        String sum=addString(num1,num2);
        String multiplication=multiply(num1,num2);
        //print output
        printOutput(num1,num2,sum,multiplication);

    }

    //algorithm to add strings
    private static String addString(String num1, String num2) {

        if (num1.length() > num2.length()){
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        String str = "";
        int n1 = num1.length(), n2 = num2.length();
        num1=new StringBuilder(num1).reverse().toString();
        num2=new StringBuilder(num2).reverse().toString();
        int carry = 0;
        for (int i = 0; i < n1; i++) {

            int sum = ((num1.charAt(i) - '0') +
                    (num2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        for (int i = n1; i < n2; i++)
        {
            int sum = ((num2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        if (carry > 0) {
            str += (char) (carry + '0');
        }
        str = new StringBuilder(str).reverse().toString();
        return formartOutput(str);
    }

    private static String formartOutput(String sum){
        String result = "";
        for (int i=1; i <= sum.length(); ++i) {
            char ch = sum.charAt(sum.length() - i);
            if (i % 3 == 1 && i > 1) {
                result = "," + result;
            }
            result = ch + result;
        }

        return result;
    }
    // Multiplication algorithm string
    private static String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0)
            return "0";

        int result[] = new int[len1 + len2];

        int indexOfNum1 = 0;
        int indexOfNum2 = 0;

        for (int i = len1 - 1; i >= 0; i--)
        {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';

            indexOfNum2 = 0;

            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + result[indexOfNum1 + indexOfNum2] + carry;
                carry = sum / 10;
                result[indexOfNum1 + indexOfNum2] = sum % 10;

                indexOfNum2++;
            }
            if (carry > 0)
                result[indexOfNum1 + indexOfNum2] += carry;
            indexOfNum1++;
        }
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }
        if (i == -1) {
            return "0";
        }
        String finalResult = "";

        while (i >= 0) {
            finalResult += (result[i--]);
        }
        return formartOutput(finalResult);
    }

    private static void printOutput(String num1,String num2,String sum,String multiplication){
        System.out.println("results are \n");
        System.out.println(formartOutput(num1));
        System.out.println("                             +");
        System.out.println(formartOutput(num2));
        System.out.println("_________________________________________");
        System.out.println(sum);
        System.out.println();

        System.out.println(formartOutput(num1));
        System.out.println("                             X");
        System.out.println(formartOutput(num2));
        System.out.println("___________________________________________________________________________________");
        System.out.println(multiplication);




    }
}