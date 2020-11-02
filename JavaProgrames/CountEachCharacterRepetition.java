import java.util.Scanner;
/*
* Question 3: Implement a method to perform basic string compression using the counts of repeated characters.
*  If the “compressed” string doesn’t become smaller than the original string,
* your method should return the original string.
* You can assume the string has only uppercase and lowercase letters(a-z).
* */
public class CountEachCharacterRepetition {

    public static void main(String[] args) {

        String userInputString;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        userInputString = in.nextLine();
        getTheRepeatedCharacterAndCount(userInputString);
    }

    /**
     * @method getTheRepeatedCharacterAndCount(String userString)
     * @param userString
     */
    public static void getTheRepeatedCharacterAndCount(String userString){
        userString.replaceAll("\\s","");
        StringBuilder sb = new StringBuilder();
        if(isStringRepeatedChar(userString)){
            int count = 1;
            for (int i = 1; i < userString.length()-1 ; i++) {
                if (userString.charAt(i) == userString.charAt(i - 1)) {
                    count++;
                }
                else {
                    sb.append(userString.charAt(i - 1));
                    sb.append(count);
                    count = 1;
                }
            }
            if (userString.length() > 1){
                //Compare the last two characters of the string
                if (userString.charAt(userString.length() - 1) == userString.charAt(userString.length() - 2)) {
                    count++;
                }else{
                    sb.append(userString.charAt(userString.length() - 2));
                    sb.append(count);
                    count = 1;
                }
                sb.append(userString.charAt(userString.length() - 1));
                sb.append(count);
            }
            userString= sb.toString();
            System.out.println("Counts of repeated characters is:" + "\n" +userString);
        }else{
            System.out.println("No repeated characters in the String:" + "\n" +userString);
        }

    }

    public static boolean isStringRepeatedChar(String inputString){
        boolean isStringRepetedChar =false;
        for (int i = 1; i < inputString.length() ; i++) {
            if (inputString.charAt(i) == inputString.charAt(i - 1)) {
                isStringRepetedChar = true;
                break;
            }

        }
        return isStringRepetedChar;
    }

}

