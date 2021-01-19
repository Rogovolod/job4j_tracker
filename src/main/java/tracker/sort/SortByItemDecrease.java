package tracker.sort;

import tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByItemDecrease implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o2.getName().compareTo(o1.getName());
    }



    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("B Fix bugs"),
                new Item("C Impl task"),
                new Item("A Reboot server"),
                new Item("D Drink some tea")
        );
        System.out.println(items);
        Collections.sort(items, new SortByItemIncrease());
        System.out.println(items);
        Collections.sort(items, new SortByItemDecrease());
        System.out.println(items);
//        [ID: null Name: A Reboot server, ID: null Name: B Fix bugs, ID: null Name: C Impl task, ID: null Name: D Drink some tea]
//        [ID: null Name: D Drink some tea, ID: null Name: C Impl task, ID: null Name: B Fix bugs, ID: null Name: A Reboot server]

    }

}
