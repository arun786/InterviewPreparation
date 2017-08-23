package StringManipulation;

/**
 * Created by Adwiti on 8/23/2017.
 */
public class StringDeciphered {

    public static void main(String[] args) {
        /*String is a final class which means it cannot be overridden*/
        /*Two ways to create String Objects*/

        /*Case 1 : it is created on String Constant Pool , in this case only 1 object will be created*/
        String s1 = "arun";
        String s2 = "sachin";
        String s3 = "arun";

        System.out.println(s1 == s3); /*will return true, it compares the reference value*/


        /*Case 2 : it is created in heap memory, here 2 objects are created, one will be in heap and the other String Constant Pool*/
        String h1 = new String("arun");
        String h2 = new String("sachin");
        String h3 = new String("arun");

        System.out.println(h1 == h3); //will return false
        System.out.println(h1.equals(h3)); //will return true, since tostring is overriden for content comparision

        //String is immutable, which means once we create String object, we cannot change it
        String s4 = new String("Immutable");
        s4.concat("son");
        System.out.println(s4); //Immutable


    }
}
