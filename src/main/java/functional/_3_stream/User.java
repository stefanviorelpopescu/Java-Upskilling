package functional._3_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class User implements Comparable<User>{

    private List<User> children = new ArrayList<>();
    private int age;
    private int score;
    private String name;

    public String getName()
    {
        return name;
    }

    public List<User> getChildren()
    {
        return children;
    }

    public int getScore()
    {
        return score;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public int compareTo(User o)
    {
        return 0;
    }

    public Integer getEldestChildAge() {
        int maxAge = -1;
        for (User child : children)
        {
            if (child.getAge() > maxAge) {
                maxAge = child.getAge();
            }
        }

        if (maxAge == -1) {
            return null;
        }
        return maxAge;
    }

    public Optional<Integer> getOptionalEldestChildAge() {
        int maxAge = -1;
        for (User child : children)
        {
            if (child.getAge() > maxAge) {
                maxAge = child.getAge();
            }
        }

        if (maxAge == -1) {
            return Optional.empty();
        }
        return Optional.of(maxAge);
    }
}
