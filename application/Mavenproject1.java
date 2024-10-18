package application;
import java.util.*;
public class Mavenproject1 {
    public static void main(String []args){
            Scanner in = new Scanner(System.in);
                System.out.println("choose conversion type:\n0-Binary to Decimal\n1-Hex to Decimal");
                int y=in.nextInt();
            switch(y){
                case 0:
                        System.out.println("Enter a binary number : ");
                        String binaryString = in.next();
                        int decimal = binaryToDecimal(binaryString);
                        System.out.println("Decimal equivalent: " + decimal);
                    break;
                case 1:
                        System.out.println("Enter a hex number : ");
                        String hexString= in.next();
                        int decima2 = hexToDecimal(hexString);
                        System.out.println("Decimal equivalent: " + decima2);
                    break;
                    }       
    }
    public static int binaryToDecimal(String binaryString) {
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) != '0' && binaryString.charAt(i) != '1') {
                System.out.println("Invalid binary input");
            return -1; 
            }
        }
        int decimal = 0;
        int power = 0;
       
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }       
        return decimal;
}
     public static int hexToDecimal(String hex) {
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            int decimalValue = 0;
            if (hexChar >= '0' && hexChar <= '9') {
                decimalValue = hexChar - '0';
            } else if (hexChar >= 'A' && hexChar <= 'F') {
                decimalValue = hexChar - 'A' + 10;
            } else if (hexChar >= 'a' && hexChar <= 'f') {
                decimalValue = hexChar - 'a' + 10;
            } else {
                System.out.println("Invalid hex input");
            }
            decimal = decimal * 16 + decimalValue;
        }
        return decimal;
    }
}