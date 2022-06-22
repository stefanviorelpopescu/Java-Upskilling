package functional._3_stream;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

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

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user);

        Optional<Integer> max = users.stream()
                .filter(user1 -> user1.getAge() < 30)
                .sorted(Comparator.reverseOrder())
//                .sorted(Comparator.comparingInt(User::getScore).reversed())
                .map(User::getScore)
                .max(Integer::compareTo);

        flatMapsUserChildren(users);

        users.stream()
                .map(User::getAge)
                .reduce(Integer::sum)
                .get();

        int sum = users.stream().mapToInt(User::getAge).sum();


        Map<Integer, List<User>> collect = users.stream()
                .collect(groupingBy(User::getAge));

        Map<Integer, List<String>> userNamesByAge = users.stream()
                .collect(toMap(User::getAge,
                        user1 -> Collections.singletonList(user1.getName()),
                        (nameList1, nameList2) -> {
                            nameList1.addAll(nameList2);
                            return nameList1;
                        }));

        System.out.println(max);

    }

    private static void flatMapsUserChildren(List<User> users)
    {
        //generate a stream consisting of the children of all users
        users.stream()
                .flatMap(user -> user.getChildren().stream())
                .collect(Collectors.toList());

        users.stream()
                .map(user -> user.getChildren().stream())
                .reduce(Stream::concat)
                .ifPresent(userStream -> userStream.collect(Collectors.toList()));
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
