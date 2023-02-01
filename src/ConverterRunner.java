import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.println("Would you like to choose between 2,8,or 10, or select your own base? 1(2,8,10) or 2(your choice)");
        Scanner b = new Scanner(System.in);
        int selection = b.nextInt();
        if(selection == 1) {
            System.out.print("Enter the base of your number (2, 8 or 10): ");
            Scanner s = new Scanner(System.in);
            String choice = s.nextLine();
            int base = Integer.parseInt(choice);

            System.out.print("Enter your number: ");
            String number = s.nextLine();
            int n = Integer.parseInt(number);

            s.close();

            NumberConverter nc = new NumberConverter(n, base);
            int[] digits = nc.getDigits();
            if(!nc.convertInputError()) {
                System.out.println("\n\nDigit array: " + Arrays.toString(digits));
                System.out.println("Number: " + nc.displayOriginalNumber());
                if(nc.getBase()==2){
                    System.out.println("Decimal Form:"+ Arrays.toString(nc.convertToDecimal()));
                    System.out.println("Octal Form:"+ Arrays.toString(nc.convertToOctal()));
                }
                if(nc.getBase()==8){
                    System.out.println("Decimal Form:"+ Arrays.toString(nc.convertToDecimal()));
                    System.out.println("Binary Form:"+ Arrays.toString(nc.convertToBinary()));
                }
                if(nc.getBase()==10){
                    System.out.println("Octal Form:"+ Arrays.toString(nc.convertToOctal()));
                    System.out.println("Binary Form:"+ Arrays.toString(nc.convertToBinary()));
                }
            }
            else{
                System.out.println("You have entered an invalid value in a parameter.");
            }
        }
        else if(selection==2){
            Scanner s = new Scanner(System.in);
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            int n = Integer.parseInt(number);

            System.out.print("Enter the base of your number: ");
            String choice = s.nextLine();
            int base = Integer.parseInt(choice);
            s.close();

            NumberConverter nc = new NumberConverter(n, base);
            int[] digits = nc.getDigits();
            if(!nc.convertInputError()) {
                System.out.println("\n\nDigit array: " + Arrays.toString(digits));
                System.out.println("Number: " + nc.displayOriginalNumber());
                System.out.println("New format:"+ Arrays.toString(nc.convertAny()));
            }
            else{
                System.out.println("You have entered an invalid value in a parameter.");
            }
        }

    }
}
