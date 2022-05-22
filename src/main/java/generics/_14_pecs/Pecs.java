package generics._14_pecs;

import java.util.ArrayList;
import java.util.List;

public class Pecs {

  public static void main(String[] args) {

    List<? extends Number> pe = new ArrayList<>();
    Integer int1 = Integer.valueOf(6);
    Double double1 = Double.valueOf(6);

//    pe.add(int1);





    List<? super Number> cs = new ArrayList<>();
    cs.add(int1);
    cs.add(double1);


    List<Integer> intList = new ArrayList<>();
    intList.add(Integer.valueOf(6));
//    intList.add(Double.valueOf(6));




//    pe.add(Integer.valueOf(1)); //compile-time error, why ?
    //this will not work because type <? extends Number> implies that we can add instances of classes that are not known

//    cs.add(Integer.valueOf(1)); //valid, why ?
  }

  private static double sum(List<? extends Number> list) {
    double sum = 0.0;
    for (Number number : list) {
      sum += number.doubleValue();
    }
    return sum;
  }
}
