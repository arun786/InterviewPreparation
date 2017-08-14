package PredicateExplained;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Adwiti on 8/13/2017.
 */
public class PredicateExplained {
    public static void main(String[] args) {
        List<Apple> lstApple = Arrays.asList(new Apple("Green", 100), new Apple("Red", 150), new Apple("Green", 160), new Apple("Blue", 200));

        System.out.println("Green Apple");
        filterApple(lstApple, Apple::isGreen).forEach(v -> System.out.println(v));
        System.out.println("Heavy Apple");
        filterApple(lstApple,Apple :: isHeavyApple).forEach(v-> System.out.println(v));
    }

    public static List<Apple> filterApple(List<Apple> lstOfApples, Predicate<Apple> p) {
        return lstOfApples.stream().filter(v -> p.test(v)).collect(Collectors.toList());
    }


}

class Apple {
    private String color;
    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public static boolean isGreen(Apple apple) {
        return "green".equalsIgnoreCase(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Apple{");
        sb.append("color='").append(color).append('\'');
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
