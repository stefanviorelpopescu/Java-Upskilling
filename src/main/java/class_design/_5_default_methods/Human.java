package class_design._5_default_methods;

public class Human {

  public void name() {
    System.out.println("Human name");
  }
}

class Student extends Human{

  @Override
  public void name() {
    System.out.println("Student name");
  }

  public static void main(String[] args) {
    Human h = new Human();
    h.name();
    Human s = new Student();
    s.name();
    Human sh = new Student();
    sh.name();
  }
}