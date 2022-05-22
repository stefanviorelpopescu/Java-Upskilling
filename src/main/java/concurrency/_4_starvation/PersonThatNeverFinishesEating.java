package concurrency._4_starvation;


public class PersonThatNeverFinishesEating extends Person {
  public PersonThatNeverFinishesEating(String id, OnePersonKitchen onePersonKitchen) {
    super(id, onePersonKitchen);
  }

  @Override
  public void run() {
    synchronized (super.onePersonKitchen) {
      System.out.println(super.id + " eating ...");
      while (true) {
        //onePersonKitchen.notifyAll(); never notifies that the kitchen is free, will just continue eating ...
      }
    }
  }
}