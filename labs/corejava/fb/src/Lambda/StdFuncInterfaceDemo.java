import java.util.List;
import java.util.function.*;

public class StdFuncInterfaceDemo {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> condition = (a) -> a > 10;
        System.out.println(condition.test(5));

        // BiPredicate
        BiPredicate<Integer, Integer> condition1 = (a, b) -> a > b;
        System.out.println(condition1.test(20, 10));

        // Function
        Function<Integer, Double> compute = a -> Double.valueOf(a / 10);
        System.out.println(compute.apply(50));

        // UnaryOperator
        UnaryOperator<Integer> square = a -> a * a;
        System.out.println(square.apply(5));

        // BiFunction
        BiFunction<Integer, Double, Double> addition = (a, b) -> a + b;
        System.out.println(addition.apply(30, 70.5));

        BinaryOperator<Integer> area = (a, b) -> a * b;
        System.out.println(area.apply(30, 40));

        // Consumer
        Consumer<String> greetings = message -> System.out.println(message);
        greetings.accept("Hello Lambda!!!");

        // BiConsumer
        BiConsumer<String, String> greetings1 = (msg1, msg2) -> System.out.println(msg1 + " " + msg2);
        greetings1.accept("Hello", "Java!!!");

        // Supplier
        Supplier<List> skills = () -> {return List.of("Java", "Python", "Node JS");};
        System.out.println(skills.get());
    }
}