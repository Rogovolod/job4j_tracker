package ru.job4j.tracker;

public class deleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter item id you want delete: ");
        if (tracker.delete(id)) {
            System.out.println("Done.");
        } else {
            System.out.println("Error.");
        }
        return true;
    }
}
