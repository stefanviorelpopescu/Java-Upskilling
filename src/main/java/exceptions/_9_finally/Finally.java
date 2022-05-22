package exceptions._9_finally;

public class Finally {

  public static void main(String[] args) {
    Finally ex2 = new Finally();
    int result = ex2.test();

//    System.out.println("before");
    System.out.println(result);
//    System.out.println("after");
  }

  public int test() { //what will this method return ?
    try {
//      throw new RuntimeException("something bad happened");

      return 0;
    } catch (Exception e) {

      return 1;
    } finally {
      System.out.println("finally");

//      return 2;
    }
  }

}
