package recipe;

import ingredient.Ingredient;
import lombok.Getter;
import lombok.Setter;
import user.User;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class SimpleRecipe extends Recipe{
    Set<Ingredient> ingredients;
    List<String> preparationSteps;

    public SimpleRecipe(User author, Set<User> collaborators, float calories, List<String> preparationSteps, Set<Ingredient> ingredients) {
        super(author, collaborators, calories);
        this.ingredients = ingredients;
        this.preparationSteps = preparationSteps;
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addPreparationStep(String preparationStep) {
        this.preparationSteps.add(preparationStep);
    }
}
