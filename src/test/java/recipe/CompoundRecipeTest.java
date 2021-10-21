package recipe;

import builders.FoodBuilder;
import builders.SimpleRecipeBuilder;
import enums.FoodGroup;
import food.Food;
import ingredient.Ingredient;
import nutritionalCondition.Vegan;
import nutritionalCondition.Vegetarian;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@DisplayName("Given a compound recipe")
public class CompoundRecipeTest {
    public User compoundUser;
    public User authorOne;
    public Recipe compoundRecipe;
    public FoodBuilder foodBd = new FoodBuilder();
    public SimpleRecipeBuilder simpleRecipeBd = new SimpleRecipeBuilder();


    @Test
    @DisplayName("es inadecuada para el conjunto de condiciones alimenticias de sus subrecetas")
    public void inadequateCompoundRecipe() {
        var nutritionalConditions = new HashSet<>(Arrays.asList(Vegan.getInstance(),
                Vegetarian.getInstance()));
        Assertions.assertEquals(nutritionalConditions, compoundRecipe.inadequateConditions());
    }

    @BeforeEach
    public void init() {
        compoundUser = new User();
        authorOne = new User();

        var foodOne = foodBd
                .setName("food one")
                .setDescription("food one description")
                .setFoodGroup(FoodGroup.FATTY_OILS_SUGAR)
                .addInadequateCondition(Vegetarian.getInstance())
                .addInadequateCondition(Vegan.getInstance())
                .build();

        var ingredientOne = new Ingredient(foodOne, "150 g");

        var simpleRecipe = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(100f)
                .addPreparationStep("step one")
                .addIngredient(ingredientOne)
                .build();

        compoundRecipe = new CompoundRecipe(compoundUser,
                new HashSet<>(),
                new ArrayList<>(List.of(simpleRecipe)));
    }
}
