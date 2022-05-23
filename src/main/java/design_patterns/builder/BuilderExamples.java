package design_patterns.builder;

public class BuilderExamples
{
    public static void main(String[] args)
    {
        PersonWithActualBuilder personWithActualBuilder = new PersonWithActualBuilder("Gigel", 33, false, false, "123456", null);
        PersonWithActualBuilder personWithActualBuilder2 = new PersonWithActualBuilder("Gigel", 33, false, false, "123456");
        PersonWithActualBuilder personWithActualBuilder3 = new PersonWithActualBuilder("Gigel", false, true, "123456");

        PersonWithActualBuilder p4 = new PersonWithActualBuilder.PersonBuilder("Doru", "123456")
                .withAge(45)
                .isEmployed(false)
//                .withAddress("address")
//                .isMarried(true)
                .build();
        System.out.println("test");

        Person p5 = new Person.PersonBuilder()
                .withName("Doru")
                .withCnp("123456")
                .withAge(45)
                .withEmployed(false)
                .build();

        Person p6 = p5.toBuilder()
                .withEmployed(true)
                .build();

    }
}
