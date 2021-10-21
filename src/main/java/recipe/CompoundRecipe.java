package recipe;

import ingredient.Ingredient;
import user.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CompoundRecipe extends Recipe{
    public List<Recipe> subRecipes;

    public CompoundRecipe(User author,
                          Set<User> collaborators,
                          List<Recipe> subRecipes) {
        super(author, collaborators);
        this.subRecipes = subRecipes;
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return subRecipes
                .stream()
                .flatMap(recipe -> recipe.getIngredients().stream())
                .collect(Collectors.toSet());
    }

    @Override
    public float getCalories() {
        return subRecipes
                .stream()
                .map(recipe -> getCalories())
                .reduce(0f, Float::sum);
    }

    @Override
    public List<String> getPreparationSteps() {
        return subRecipes
                .stream()
                .flatMap(recipe -> getPreparationSteps().stream())
                .collect(Collectors.toList());
    }
}
