package collections._1_checked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {

  public static void main(String[] args) {
    List myList = new ArrayList();


    List<String> myList2 = new ArrayList<>();
    myList2.add("str");
    myList2.add("str2");

//    ArrayList nonParametrized = new ArrayList(myList2);
    List nonParametrized = myList2;

    List<Integer> intList = nonParametrized;

    for (Integer i : intList) {

    }


    myList.add("one");
    myList.add("two");
    myList.add("three");
    myList.add("four");

    displayList(myList);


    List chkList = Collections.checkedList(myList, String.class);
    System.out.println("Checked list content: " + chkList);

    //you can add any type of elements to myList object
    myList.add(10);
    //you cannot add any type of elements to chkList object
    chkList.add(10); //throws ClassCastException, because it checks the element's type

    for (Object o : myList) {
      if (o instanceof String) {
        String myString = (String) o;
        System.out.println(myString);
      }
    }
  }

  private static <T> void displayList(List<T> list) {
    for (T element : list) {
      System.out.println(element);
    }
  }

  private static void displayList2(List<?> list) {
    for (Object element : list) {
      System.out.println(element);
    }
  }

  private static void clearList(List<?> list) {
    list.clear();
  }

}
