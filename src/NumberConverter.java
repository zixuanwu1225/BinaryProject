public class NumberConverter {
    int number;
    int originalNumber;
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
        this.number = number;
        this.originalNumber = number;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        return digits;
    }

    public int[] convertToBinary() {
        number = originalNumber;
        int highestPower = 0;
        for (int i = 0; number > Math.pow(2, i); i++) {
            highestPower = i;
            digits = new int[highestPower + 1];
        }
        for (int i = 0; highestPower != -1; i++) {
            if (number - Math.pow(2, highestPower) >= 0) {
                number = number - (int) Math.pow(2, highestPower);
                digits[i] = 1;
                highestPower = highestPower - 1;
            } else {
                digits[i] = 0;
                highestPower = highestPower - 1;
            }
        }
        return digits;
    }

    public int[] convertToOctal() {
        number = originalNumber;
        int highestPower = 0;
        for (int i = 0; number > Math.pow(8, i); i++) {
            highestPower = i;
            digits = new int[highestPower+1];
        }
        for (int i =0; highestPower+1>=i;i++){
            int placeValue = 0;
            while (number-Math.pow(8,highestPower)>=0){
                placeValue++;
                number = number-(int)Math.pow(8,highestPower);
                digits[i]=placeValue;
            }
            highestPower--;
        }
        return digits;
    }
}
