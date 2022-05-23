package design_patterns.builder;

import lombok.*;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class Person
{
    @NonNull
    String name;

    int age;
    boolean married;
    boolean employed;

    @NonNull
    String cnp;

    String address;

}
