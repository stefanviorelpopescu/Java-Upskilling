package generics._16_type_errasure;

public class Node2 extends Node<Integer> {
    //after type erasure, the method signatures do not match
    void setData(Integer data) {
        super.setData(data);
    }
}
