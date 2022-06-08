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

    public SimpleRecipe(User author, Set<User> collaborators, float calories, List<String> preparationSteps, Set<Ingredient> ingredients) {
        super(author, collaborators, calories, preparationSteps);
        this.ingredients = ingredients;
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}
