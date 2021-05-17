package tracker.sort;
import org.junit.Assert;
import org.junit.Test;
import tracker.Item;

import java.util.ArrayList;
import java.util.Collections;



public class SortTest {


          Item item1 = new Item("1", "A Reboot server");
          Item item2 = new Item("2","B Fix bugs");
          Item item3 = new Item("3","C Impl task");
          Item item4 = new Item("4","D Drink some tea");

    @Test
    public void whenSortIncrease(){
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        expected.add(item4);
        ArrayList<Item> actual = new ArrayList<>();
        actual.add(item4);
        actual.add(item3);
        actual.add(item2);
        actual.add(item1);
        Collections.sort(actual, new SortByItemIncrease());

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void whenSortDecrease(){
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item4);
        expected.add(item3);
        expected.add(item2);
        expected.add(item1);
        ArrayList<Item> actual = new ArrayList<>();
        actual.add(item1);
        actual.add(item2);
        actual.add(item3);
        actual.add(item4);
        Collections.sort(actual, new SortByItemDecrease());

        Assert.assertEquals(expected.toString(), actual.toString());
    }



}
