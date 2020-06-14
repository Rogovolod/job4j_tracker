package ru.job4j.tracker;

public class editAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter item id you want edit: ");
        System.out.println("Try to found: " + id);
        String name = input.askStr("Type new item name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Done.");
        } else {
            System.out.println("Error.");
        }
        return true;
    }
}
