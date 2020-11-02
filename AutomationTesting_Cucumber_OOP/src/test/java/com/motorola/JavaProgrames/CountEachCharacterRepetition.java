import java.util.Scanner;
/*
* Question 3: Implement a method to perform basic string compression using the counts of repeated characters.
*  If the “compressed” string doesn’t become smaller than the original string,
* your method should return the original string.
* You can assume the string has only uppercase and lowercase letters(a-z).
* */
public class CountEachCharacterRepetition {

    public static void main(String[] args) {

        String userString,withoutSpaceUserString;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        userString = in.nextLine();
        //System.out.println("User Entered String: "+userString);
        withoutSpaceUserString =userString.replaceAll("\\s", "");
       // System.out.println("String: "+withoutSpaceUserString);
        getRepeatedCharacterCount(withoutSpaceUserString , userString);

    }

    public static void getRepeatedCharacterCount(String withoutSpaceUserString, String userString) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        //System.out.println(userString.length());
        for (int i = 1; i < withoutSpaceUserString.length() - 1; i++) {
            if (withoutSpaceUserString.charAt(i) == withoutSpaceUserString.charAt(i - 1)) {
                count++;
            } else {
                sb.append(withoutSpaceUserString.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }
        if (withoutSpaceUserString.length() > 1) {
            //Compare the last two characters of the string
            if (withoutSpaceUserString.charAt(withoutSpaceUserString.length() - 1) == withoutSpaceUserString.charAt(withoutSpaceUserString.length() - 2)) {
                count++;
            } else {
                sb.append(withoutSpaceUserString.charAt(withoutSpaceUserString.length() - 2));
                sb.append(count);
                count = 1;
            }
            sb.append(withoutSpaceUserString.charAt(withoutSpaceUserString.length() - 1));
            sb.append(count);
        }
        withoutSpaceUserString = sb.toString();
            System.out.println("Counts of repeated characters is:" + "\n" + withoutSpaceUserString);
    }

}

