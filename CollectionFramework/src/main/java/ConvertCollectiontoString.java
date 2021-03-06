import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Adwiti on 7/31/2017.
 */
public class ConvertCollectiontoString {
    public static void main(String[] args) {
        List<String> strLst = Arrays.asList("mon","tue","wed","thur","fri","sat","sun");
        String strList = StringUtils.collectionToCommaDelimitedString(strLst);
        System.out.println(strList);

        String strListWithColon = StringUtils.collectionToDelimitedString(strLst,":");
        System.out.println(strListWithColon);

        String strListWithPipe = StringUtils.collectionToDelimitedString(strLst,"|");
        System.out.println(strListWithPipe);

        System.out.println("Convert set to a String");
        Set<String> strSet = new HashSet<>(strLst);
        String strSets = StringUtils.collectionToCommaDelimitedString(strSet);
        System.out.println("Sets to String " + strSets);

        String strSetToStringWithPipe = StringUtils.collectionToDelimitedString(strSet,"|");
        System.out.println("set to String using pipe " + strSetToStringWithPipe);

        System.out.println("use of Java 8 to convert collection to a string");

        String converttoAStrng = strLst.stream().map(v -> v.toString()).collect(Collectors.joining("|"));
        System.out.println("using Java 8 to convert to String " + converttoAStrng);

    }
}
