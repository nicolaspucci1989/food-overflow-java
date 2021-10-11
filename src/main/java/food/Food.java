package food;

public class Food {
    public String name;
    public String description;

    public Food(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Food() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private boolean fieldIsValid(String field) {
        return field != null && field.length() > 0;
    }

    public boolean valid() {
        return fieldIsValid(name) && fieldIsValid(description);
    }
}
