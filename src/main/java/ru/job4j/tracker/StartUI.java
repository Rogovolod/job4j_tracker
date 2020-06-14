package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItem(Input input, Tracker tracker) {
        System.out.println("=== All items ====");
        Item[] find = tracker.findAll();
        if (find.length > 0) {
            for (int i = 0; i < find.length; i++) {
                System.out.println(find[i]);
            }
        } else {
                    System.out.println("Tracker don't have any items.");
                }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Enter item id you want edit: ");
        System.out.println("Try to found: " + id);
        String name = input.askStr("Type new item: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Done.");
        } else {
            System.out.println("Error.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Enter item id you want delete: ");
        if (tracker.delete(id)) {
            System.out.println("Done.");
        } else {
            System.out.println("Error.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String id = input.askStr("Enter item id you want find: ");
        Item itemId = tracker.findById(id);
        if (itemId != null) {
            System.out.println(itemId);
        } else {
            System.out.println("Tracker don't have this ID.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter item name you want find: ");
        Item[] findN =  tracker.findByName(name);
        if (findN.length > 0) {
            for (int i = 0; i < findN.length; i++) {
                System.out.println(findN[i]);
            }
        } else {
            System.out.println("Tracker don't have this name.");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItem(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}