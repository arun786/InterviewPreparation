package StringManipulation;

/**
 * Created by Adwiti on 8/23/2017.
 */
public class StringBufferDeciphered {
    public static void main(String[] args) {
        /*StringBuffer is mutable, which means we can modify the object*/
        StringBuffer sb = new StringBuffer("India");
        sb.append("isgreat");
        System.out.println(sb); //o/p will be Indiaisgreat

        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println(sb1.equals(sb2)); //false, since to string method is not overridden in Stringbuffer
        System.out.println(sb1 == sb2); //false
    }
}
