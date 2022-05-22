package class_design.composition;

public class Main
{
    public static void main(String[] args)
    {
        Student student = new Student("Ion");
        student.getLibraryMembership().addLocationMembership(2546L);
        student.getCantinaMembership().addLocationMembership(12356L);
//        student.getCourse().enroll();

        FileProcessor fileProcessor = new FileProcessor();
        new Thread(fileProcessor).start();

        Runnable fileProcessor2 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("7");
            }
        };

        new Thread(fileProcessor2).start();
    }
}
