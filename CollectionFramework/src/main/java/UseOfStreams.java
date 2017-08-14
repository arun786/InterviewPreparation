import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Adwiti on 7/30/2017.
 */
public class UseOfStreams {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("one", "two", "three", "", "five", "", "seven");
        long count = strList.stream().count();
        System.out.println("Count of words : " + count); //o/p will be 7

        long empCount = strList.stream().filter(v -> null != v && v.isEmpty()).count();
        System.out.println("Count of words which are empty : " + empCount);  //o/p will be 2

        long lengthCountMorethan3Characters = strList.stream().filter(v -> v.length() > 3).count();
        System.out.println("count of words which has more than 3 characters : " + lengthCountMorethan3Characters); //o/p will be 3

        long countofwordsStartingWithT = strList.stream().filter(v -> v.startsWith("t")).count();
        System.out.println("count of words starting with t : " + countofwordsStartingWithT);

        List<String> lstNotempty = strList.stream().filter(v -> v != null && !v.isEmpty()).collect(Collectors.toList());
        System.out.println("List not having empty values :  " + lstNotempty);

        List<String> lstWithMoreThan3Letters = strList.stream().filter(v -> v.length() > 3).collect(Collectors.toList());
        System.out.println("Words having characters more than 3 characters : " + lstWithMoreThan3Letters);

        String strOfWords = strList.stream().map(v -> v.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(strOfWords);

        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(distinct);

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 19);
        IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stats);
       /* o/p will be
        IntSummaryStatistics{count=10, sum=119, min=2, average=11.900000, max=23}*/

    }
}
