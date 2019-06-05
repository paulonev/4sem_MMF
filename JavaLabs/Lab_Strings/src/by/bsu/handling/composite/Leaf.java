package by.bsu.handling.composite;

public class Leaf implements Component {

    private String content;
    private LeafType type;

    public Leaf(String content, LeafType type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public LeafType getType() {
        return type;
    }

    @Override
    public String toString() {
        return content;
    }
}
