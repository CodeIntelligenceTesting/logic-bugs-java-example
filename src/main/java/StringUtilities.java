public class StringUtilities {

    public static String myReverseString(String input){
        String output = "";

        for(int i = input.length(); i > 0; i--){
            output = output + input.charAt(i);
        }

        return output;
    }
}
