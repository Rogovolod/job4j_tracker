package tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item name you want find: ");
        List<Item> findN = tracker.findByName(name);
        if (findN.size() > 0) {
            for (int i = 0; i < findN.size(); i++) {
                out.println(findN.get(i));
            }
        } else {
            out.println("Tracker don't have this name.");
        }
        return true;
    }
}