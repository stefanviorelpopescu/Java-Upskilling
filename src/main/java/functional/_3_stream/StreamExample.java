package functional._3_stream;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.*;

public class StreamExample {

    private static Logger logger = Logger.getLogger(StreamExample.class.getName());

    private final int increment = 5;

    public static void main(String[] args)
    {
        StreamExample se = new StreamExample();
        se.createStreamFromCollection();

        User user = new User();

        Integer eldestChildAge = user.getEldestChildAge();
        if (eldestChildAge != null)
        {
            System.out.println(2022 - eldestChildAge);
        }

        user.getOptionalEldestChildAge().ifPresent(maxAge -> System.out.println(2022 - maxAge));

        Optional<Integer> optionalEldestChildAge = user.getOptionalEldestChildAge();
        if (optionalEldestChildAge.isPresent()) {
            System.out.println(2022 - optionalEldestChildAge.get());
        } else {

        }

    }

    private void createStreamFromCollection() {
        List<Integer> famousNumbers = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55));

        famousNumbers.removeIf(number -> number % 2 == 1);

        for (Integer famousNumber : famousNumbers)
        {
            System.out.println(famousNumber + increment);
        }

        famousNumbers.forEach(integer -> System.out.println(integer + increment));

        famousNumbers.stream()
                .mapToInt(famousNumber -> famousNumber + increment)
                .forEach(System.out::println);

        logger.warning(this::buildMessage);


        famousNumbers.replaceAll(integer -> integer + 5);

        List<User> users = new ArrayList<>();

        users.sort(Comparator.comparingInt(User::getAge));

        Collections.sort(users, (user1, user2) -> user1.getAge() - user2.getAge());

        Collections.sort(users, Comparator.comparingInt(User::getAge));

        Stream<Integer> numbersStream = famousNumbers.stream();

        Set<String> usefulConcepts = new HashSet<>(Arrays.asList("functions", "lazy", "immutability"));
        Stream<String> conceptsStream = usefulConcepts.stream();
    }

    private String buildMessage()
    {
        return "message";
    }

    private void createStreamFromArray() {
        Stream<Double> doubleStream = Arrays.stream(new Double[]{ 1.01, 1d, 0.99, 1.02, 1d, 0.99 });
    }

    private void createStreamFromString() {
        IntStream stream = "aibohphobia".chars(); // It returns IntStream!
    }

    private void createStreamFromValues() {
        LongStream longStream = LongStream.of(111_111_111L, 333_333_333L);
    }

    private void createStreamFromOtherStreams() {
        //From another streams
        Stream<BigInteger> concatedStream = Stream.concat(Stream.empty(), Stream.empty());

        // Use Stream.generate()
        Stream<User> userStream = Stream.generate(User::new);
        DoubleStream randomStream = DoubleStream.generate(Math::random);

        // Use Stream.iterate()
        IntStream oddNumbersStream = IntStream.iterate(1, x -> x + 2);

        //Use Stream.range() or Stream.rangeClosed(). Method rangeClosed() includes an upper bound.
        LongStream rangedStream = LongStream.rangeClosed(100_000, 1_000_000);
    }

}
