package builders;

import enums.Difficulty;
import ingredient.Ingredient;
import recipe.SimpleRecipe;
import user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleRecipeBuilder {
    private User author;
    private float calories;
    private Set<User> collaborators = new HashSet<>();
    List<String> preparationSteps = new ArrayList<>();
    Set<Ingredient> ingredients = new HashSet<>();
    private Difficulty difficulty;

    public SimpleRecipeBuilder setAuthor(User author) {
        this.author = author;
        return this;
    }

    public SimpleRecipeBuilder setCalories(float calories) {
        this.calories = calories;
        return this;
    }

    public SimpleRecipeBuilder addCollaborator(User collaborator) {
        collaborators.add(collaborator);
        return this;
    }

    public SimpleRecipeBuilder addPreparationStep(String step) {
        preparationSteps.add(step);
        return this;
    }

    public SimpleRecipeBuilder addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this;
    }

    public SimpleRecipeBuilder setDifficutly(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public SimpleRecipe build() {
        var recipe = new SimpleRecipe(author,
                collaborators,
                calories,
                preparationSteps,
                ingredients,
                difficulty);
        reset();
        return recipe;
    }

    private void reset() {
        collaborators = new HashSet<>();
        preparationSteps = new ArrayList<>();
        ingredients = new HashSet<>();
        difficulty = null;
    }

}
