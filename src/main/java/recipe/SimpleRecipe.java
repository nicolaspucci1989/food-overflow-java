package recipe;

import enums.Difficulty;
import ingredient.Ingredient;
import user.User;

import java.util.List;
import java.util.Set;

public class SimpleRecipe extends Recipe{
    Set<Ingredient> ingredients;
    Float calories;
    List<String> preparationSteps;
    Difficulty difficulty;

    public SimpleRecipe(User author,
                        Set<User> collaborators,
                        float calories,
                        List<String> preparationSteps,
                        Set<Ingredient> ingredients,
                        Difficulty difficulty) {
        super(author, collaborators);
        this.ingredients = ingredients;
        this.calories = calories;
        this.preparationSteps = preparationSteps;
        this.difficulty = difficulty;
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    @Override
    public List<String> getPreparationSteps() {
        return preparationSteps;
    }

    @Override
    public Difficulty difficulty() {
        return difficulty;
    }
}
