package by.bsu.handling.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite implements Component {
    private CompositeType type;
    private ArrayList<Component> components;


    public Composite(CompositeType type) {
        this.type = type;
        components = new ArrayList<>();
    }

    public CompositeType getType() {
        return type;
    }

    public boolean addComponent(Component component) {
        return components.add(component);
    }

    public Component getChild(int i) {
        return components.get(i);
    }

    public List<Component> getComponents() {
        //Collections.unmodifiableList возвращает список только для чтения.
        // Чтобы быть уверенным что мы полностью контролируем состояние данных.
        // Это очень полезно, если над программой работает более одного программиста.
        return Collections.unmodifiableList(components);
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        String result;
        if (type == CompositeType.LEXEME) {
            for (Component c : components) {
                content.append(c);
            }
            result = content.toString();
        } else if (type == CompositeType.TEXT) {
            for (Component c : components) {
                content.append(c).append("\n\t");//Параграфы отделяются табуляцией
            }
            result = "\t" + content.toString().trim();
        } else {
            for (Component c : components) {
                content.append(c).append(" ");
            }
            result = content.toString().trim();
        }
        return result;
    }
}