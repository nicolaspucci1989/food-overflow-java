package recipe;

import ingredient.Ingredient;
import user.User;

import java.util.Set;

public class SimpleRecipe extends Recipe{
    Set<Ingredient> ingredients;

    public SimpleRecipe(User author, Set<Ingredient> ingredients) {
        super(author);
        this.ingredients = ingredients;
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}
