package tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== All items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> find = tracker.findAll();
        if (find.size() > 0) {
            for (int i = 0; i < find.size(); i++) {
                out.println(find.get(i).toString());
            }
        } else {
            out.println("Tracker don't have any items.");
        }
        return true;
    }
}

