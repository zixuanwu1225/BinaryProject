public class NumberConverter {
    int number;
    int originalNumber;
    int[] digits;
    String[] hexa;
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
            originalNumber=number;
            digits[0]=number;
        }
        if(base==2){
            int placeValue=0;
            for(int i =digits.length-1;i!=-1;i--){
                if(digits[i]==1){
                    number = number+(int)Math.pow(2,placeValue);
                }
                placeValue++;
            }
            digits=new int[1];
            originalNumber=number;
            digits[0]=number;
        }
        else{
            for(int i =digits.length-1;i!=-1;i--){
                if(digits[i]>0){
                    number = number+(int)Math.pow(base,i)*digits[digits.length-1-i];
                }
            }
            digits=new int[1];
            originalNumber=number;
            digits[0]=number;
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
    public String[] convertToHexa(){
        number = originalNumber;
        int highestPower = 0;
        for (int i = 0; number > Math.pow(16, i); i++) {
            highestPower = i;
            hexa = new String[highestPower+1];
        }
        for (int i =0; highestPower!=-1;i++){
            int placeValue = 0;
            while (number-Math.pow(16,highestPower)>=0){

                number = number-(int)Math.pow(16,highestPower);
                placeValue++;

            }
            if(placeValue==10){
                hexa[i]= "A";
            }
            else if(placeValue==11){
                hexa[i]="B";
            }
            else if(placeValue==12){
                hexa[i]="C";
            }
            else if (placeValue == 13){
                hexa[i]="D";
            }
            else if(placeValue==14){
                hexa[i]="E";
            }
            else if(placeValue==15){
                hexa[i]="F";
            }
            else {
                hexa[i] = String.valueOf(placeValue);
            }
            highestPower--;
        }
        return hexa;
    }
    public int[] convertAny(){
        number = originalNumber;
        int highestPower = 0;
        for (int i = 0; number > Math.pow(base, i); i++) {
            highestPower = i;
            digits = new int[highestPower+1];
        }
        for (int i =0; highestPower!=-1;i++){
            int placeValue = 0;
            while (number-Math.pow(base,highestPower)>=0){

                number = number-(int)Math.pow(base,highestPower);
                placeValue++;

            }
            digits[i]=placeValue;
            highestPower--;
        }
        return digits;
    }
}
