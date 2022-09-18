package suggestion;

import builders.SimpleRecipeBuilder;
import food.Food;
import ingredient.Ingredient;
import nutritionalCondition.Diabetic;
import nutritionalCondition.Hypertensive;
import nutritionalCondition.Vegan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import recipe.Recipe;
import user.User;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given and individual recipe suggestion")
public class IndividualRecipeSuggestionTest {
    SimpleRecipeBuilder simpleRecipeBuilder = new SimpleRecipeBuilder();
    Recipe suggestibleRecipe;
    Food favoriteFood;
    Food dislikedFood;
    User veganUser;

    @Test
    @DisplayName("is suggestible")
    public void sugerenciaAdecuada() {
        assertTrue(veganUser.isSuggestible(suggestibleRecipe));
    }

    @BeforeEach
    public void init() {
        favoriteFood = Food.builder().inadequateCondition(Hypertensive.getInstance()).build();
        dislikedFood = Food.builder().inadequateCondition(Diabetic.getInstance()).build();
        veganUser = User.builder()
                .nutritionalCondition(Vegan.getInstance())
                .favoriteFood(favoriteFood)
                .dislikedFood(dislikedFood)
                .build();
        suggestibleRecipe = this.simpleRecipeBuilder
                .setCalories(200f)
                .addPreparationStep("step one")
                .addIngredient(new Ingredient(favoriteFood, "200 g"))
                .build();
    }
}
