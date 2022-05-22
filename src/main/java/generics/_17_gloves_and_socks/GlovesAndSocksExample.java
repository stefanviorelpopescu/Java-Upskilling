package generics._17_gloves_and_socks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GlovesAndSocksExample {

  public static void main(String[] args) {
    Sock blueSock = new Sock(10, "blue");
    Sock redSock  = new Sock(10, "red");
    Glove yellowGlove = new Glove(15, "yellow");
    Glove bigYellowGlove = new Glove(17, "yellow");

    //Pair socksPair01 = new Pair(blueSock, yellowGlove); //should not be allowed, but is for backwards compatibility
    //Pair<Sock> socksPair02 = new Pair<>(blueSock, yellowGlove); //compile-time error
    //Pair<Sock> socksPair03 = new Pair<>(blueSock, redSock); //should throw run-time error, colors do not match
    //Pair<Glove> glovesPair01 = new Pair<>(yellowGlove, bigYellowGlove); //should throw run-time error, sizes do not match

    Sock left = new Sock(10, "green");
    Sock right  = new Sock(10, "green");
    Pair<Sock> socksPair04 = new Pair<>(left, right); //pairs match so no error


    List<GlovesAndSocksExample> list = new ArrayList<>();
    for (GlovesAndSocksExample element : list) {

    }
  }

}
