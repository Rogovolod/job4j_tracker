package tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter item id you want edit: ");
        out.println("Try to found: " + id);
        String name = input.askStr("Type new item name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            out.println("Done.");
        } else {
            out.println("Error.");
        }
        return true;
    }
}