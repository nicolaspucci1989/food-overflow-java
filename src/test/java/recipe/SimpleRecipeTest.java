package recipe;

import builders.SimpleRecipeBuilder;
import enums.Difficulty;
import enums.FoodGroup;
import food.Food;
import ingredient.Ingredient;
import nutritionalCondition.Vegan;
import nutritionalCondition.Vegetarian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given a simple recipe")
public class SimpleRecipeTest {

  User author;
  User collaborator;
  User user;
  SimpleRecipe recipe;
  Recipe nonValidRecipe;
  SimpleRecipeBuilder simpleRecipeBuilder = new SimpleRecipeBuilder();

  @Test
  @DisplayName("can be edited by an author or collaborator user")
  public void editableRecipe() {
    recipe.addCollaborator(collaborator);
    assertTrue(recipe.editable(author));
    assertTrue(recipe.editable(collaborator));
  }

  @Test
  @DisplayName("can not be edited by a user, if the user is not the author or a collaborator")
  public void nonEditableRecipe() {
    recipe.addCollaborator(collaborator);
    assertFalse(recipe.editable(user));
  }

  @Test
  @DisplayName("is inadequate for the set of nutritional conditions of its ingredients")
  public void inadequateForNutritionalConditions() {
    var conditions = new HashSet<>(Arrays.asList(Vegan.getInstance(), Vegetarian.getInstance()));
    assertEquals(conditions, recipe.inadequateConditions());
  }

  @Test
  @DisplayName("with no ingredients is not valid")
  public void recipeNotValid() {
    assertFalse(nonValidRecipe.valid());
  }

  @Test
  @DisplayName("is valid if is valid")
  public void validRecipe() {
    assertTrue(recipe.valid());
  }

  @Test
  @DisplayName("is not valid if it has a number of calories outside of the valid range")
  public void nonValidCaloriesRecipe() {
    recipe.setCalories(5f);
    recipe.addIngredient(new Ingredient());
    recipe.addPreparationStep("step one");
    assertFalse(recipe.valid());
  }

  @Test
  @DisplayName("is not valid if it has zero preparation steps")
  public void noStepsRecipe() throws Exception {
    nonValidRecipe.setCalories(100f);
    nonValidRecipe.addIngredient(new Ingredient());
    assertFalse(nonValidRecipe.valid());
  }


  @BeforeEach
  public void init() {
    author = new User();
    collaborator = new User();
    var food = Food.builder()
        .name("name")
        .description("description")
        .foodGroup(FoodGroup.FATTY_OILS_SUGAR)
        .inadequateConditions(new HashSet<>(Arrays.asList(Vegetarian.getInstance(), Vegan.getInstance())))
        .build();
    var ingredient = new Ingredient(food, "150 g");

    recipe = simpleRecipeBuilder
        .setAuthor(author)
        .setCalories(100f)
        .addCollaborator(collaborator)
        .addPreparationStep("step one")
        .addIngredient(ingredient)
        .setDifficutly(Difficulty.EASY)
        .build();

    nonValidRecipe = simpleRecipeBuilder
        .setAuthor(author)
        .build();
  }
}
