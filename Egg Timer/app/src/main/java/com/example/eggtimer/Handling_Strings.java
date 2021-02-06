package domain;
import java.util.Arrays;
import java.util.

public class HelloWorld {

    public static void main(String[] args) {
        
        // //1st       
        // String myStrings = "Vikram x Java x Cplusplus x Python";
        // String[] splitStrings = myStrings.split(" x ");
        // System.out.println(Arrays.toString(splitStrings));
        
        // 2nd
        //String myStrings = "missisipi";
        //String[] splitStrings = myStrings.split("s");
        //System.out.println(Arrays.toString(splitStrings));
        
        // 3rd
        // String myStrings = "Vikram x Java x Cplusplus x Python";
        // String splitStrings = myStrings.substring(2,5);
        // System.out.println(splitStrings);

        //4th

        String myStrings = "missisipi";
        Pattern p = Pattern.compile("mi(*?pi)pi");
        Matcher m = p.matcher(River);
        while(1){
           System.out.println(m.group(1));
        }
    }
}
