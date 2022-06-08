package recipe;

import ingredient.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import nutritionalCondition.NutritionalCondition;
import user.User;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public abstract class Recipe {
    private User author;
    private Set<User> collaborators;
    private float calories;
    private List<String> preparationSteps;

    public boolean editable(User user) {
       return isAuthor(user) || collaborators.contains(user);
    }

    private boolean isAuthor(User user) {
        return author == user;
    }

    public void addCollaborator(User user) {
        collaborators.add(user);
    }

    public Set<NutritionalCondition> inadequateConditions() {
        return getIngredients()
                .stream()
                .flatMap(ingredient -> ingredient.inadequateConditions().stream())
                .collect(Collectors.toSet());
    }

    public abstract Set<Ingredient> getIngredients();

    public boolean valid() {
        return hasIngredients() && hasValidCalories() && hasValidProcess();
    }

    private boolean hasValidProcess() {
        return !getPreparationSteps().isEmpty();
    }

    private boolean hasValidCalories() {
        var calories = getCalories();
        return calories >= 10 && calories <= 5000;
    }

    private boolean hasIngredients() {
        return !getIngredients().isEmpty();
    }

    public abstract Float getCalories();

    public abstract List<String> getPreparationSteps();

    public abstract Difficulty difficulty();
}
