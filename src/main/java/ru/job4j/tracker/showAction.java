package ru.job4j.tracker;

public class showAction implements UserAction {
    @Override
    public String name() {
        return "=== All items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] find = tracker.findAll();
        if (find.length > 0) {
            for (int i = 0; i < find.length; i++) {
                System.out.println(find[i]);
            }
        } else {
            System.out.println("Tracker don't have any items.");
        }
        return true;
    }
}
