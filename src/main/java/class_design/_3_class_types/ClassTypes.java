package class_design._3_class_types;

public class ClassTypes {

  static class NestedClass {

  }

  class InnerClass {

  }

  abstract class AbstractClass {
    abstract void doStuff();
  }

  class ConcreteInnerClass extends AbstractClass {

    @Override
    void doStuff() {
      System.out.println("concreteInnerClass - doStuff");
    }
  }

  void m() {
    int i = 0;
    int j = 1;

    class LocalClass {

    }
  }

  void m2() {
    int k = 0;
    int l = 1;

    Runnable anonymousClass = new Runnable() {
      @Override
      public void run() {
        System.out.println("annonimousClass - run");
      }
    };
    anonymousClass.run();
  }

}

interface SomeRandomInterface {
  class NestedClass {

  }
}