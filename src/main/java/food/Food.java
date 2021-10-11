package food;

public class Food {
    public String name;
    public String description;

    public Food(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public boolean valid() {
        return name.length() > 0 && description.length() > 0;
    }
}
