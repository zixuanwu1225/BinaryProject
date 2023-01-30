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
        this.number = 0;
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
    public int getBase(){
        return base;
    }
    public boolean convertInputError(){

        if(base==8){
            for(int i =0;digits.length>i;i++){
                if(digits[i]>7){
                    return true;
                }
            }
        }
        else if(base==2){
            for(int i =0;digits.length>i;i++){
                if(digits[i]>1){
                    return true;
                }
            }
        }
        return false;
    }

    public int[] convertToDecimal()
    {
        if(base==8){
            for(int i =digits.length-1;i!=-1;i--){
                if(digits[i]>0){
                    number = number+(int)Math.pow(8,i)*digits[digits.length-1-i];
                }
            }
            digits=new int[1];
            digits[0]=number;
        }
        if(base==2){
            for(int i =digits.length-1;i!=-1;i--){
                if(digits[i]==1){
                    number = number+(int)Math.pow(2,i);
                }
            }
            int highestPower = 0;
            for (int i = 0; number > Math.pow(10, i); i++) {
                highestPower = i;
                digits = new int[highestPower + 1];
            }
            digits = new int[1];
            originalNumber=number;
            for(int i =0;number>0;i++){
                int placeValue=0;
                while (number-Math.pow(10,i)>=0){
                    placeValue++;
                    number = number-(int)Math.pow(10,i);
                }
                digits[0]=placeValue;
            }
        }
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
        for (int i =0; highestPower!=-1;i++){
            int placeValue = 0;
            while (number-Math.pow(8,highestPower)>=0){

                number = number-(int)Math.pow(8,highestPower);
                placeValue++;

            }
            digits[i]=placeValue;
            highestPower--;
        }
        return digits;
    }
}
