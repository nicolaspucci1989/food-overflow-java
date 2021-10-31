package recipe;

import builders.FoodBuilder;
import builders.SimpleRecipeBuilder;
import enums.Difficulty;
import enums.FoodGroup;
import ingredient.Ingredient;
import nutritionalCondition.Diabetic;
import nutritionalCondition.Hypertensive;
import nutritionalCondition.Vegan;
import nutritionalCondition.Vegetarian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Given a compound recipe")
public class CompoundRecipeTest {
    public User compoundUser;
    public User authorOne;
    public CompoundRecipe compoundRecipe;
    public FoodBuilder foodBd = new FoodBuilder();
    public SimpleRecipeBuilder simpleRecipeBd = new SimpleRecipeBuilder();


    @Test
    @DisplayName("is inadequate for the set of nutritional conditions of its sub-recipes")
    public void inadequateCompoundRecipe() {
        var nutritionalConditions = Stream.of(Vegan.getInstance(),
                Vegetarian.getInstance(),
                Hypertensive.getInstance(),
                Diabetic.getInstance())
                    .collect(Collectors.toCollection(HashSet::new));

        assertEquals(nutritionalConditions, compoundRecipe.inadequateConditions());
    }

    @Test
    @DisplayName("its difficulty is equal to the maximum difficulty of its sub-recipes")
    public void compoundRecipeDifficulty() {
        assertEquals(Difficulty.NORMAL, compoundRecipe.difficulty());
    }

    @Test
    @DisplayName("its preparation process is equal to the set of the preparation process of its sub-recipes plus its own preparation steps")
    public void procesoRecetaCompuesta() {
        var steps = new ArrayList<String>();
        steps.add("step one recipe one");
        steps.add("step one recipe two");
        steps.add("step one recipe three");

        assertEquals(steps, compoundRecipe.getPreparationSteps());
    }

    @Test
    @DisplayName("sum of calories")
    public void composedOfCompoundRecipes() {
        var calories = 100f + 200f + 300;
        assertEquals(calories, compoundRecipe.getCalories());
    }

    @Test
    @DisplayName("valid")
    public void valid() {
        assertTrue(compoundRecipe.valid());
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

        var foodTwo = foodBd
                .setName("food two")
                .setDescription("food two description")
                .setFoodGroup(FoodGroup.VEGETABLES_FRUITS_SEEDS)
                .addInadequateCondition(Hypertensive.getInstance())
                .build();

        var foodThree = foodBd
                .setName("food three")
                .setDescription("food two description")
                .setFoodGroup(FoodGroup.DAIRY_DERIVATIVES)
                .addInadequateCondition(Diabetic.getInstance())
                .build();

        var ingredientOne = new Ingredient(foodOne, "150 g");
        var ingredientTwo = new Ingredient(foodTwo, "150 g");
        var ingredientThree = new Ingredient(foodThree, "150 g");

        var simpleRecipeOne = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(100f)
                .addPreparationStep("step one recipe one")
                .addIngredient(ingredientOne)
                .setDifficutly(Difficulty.EASY)
                .build();

        var simpleRecipeTwo = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(200f)
                .addPreparationStep("step one recipe two")
                .addIngredient(ingredientTwo)
                .setDifficutly(Difficulty.EASY)
                .build();

        var simpleRecipeThree = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(300f)
                .addPreparationStep("step one recipe three")
                .addIngredient(ingredientThree)
                .setDifficutly(Difficulty.NORMAL)
                .build();

        var compoundRecipeTwo = new CompoundRecipe(authorOne,
                new HashSet<>(),
                new ArrayList<>(List.of(simpleRecipeThree)));

        compoundRecipe = new CompoundRecipe(compoundUser,
                new HashSet<>(),
                new ArrayList<>(Arrays.asList(simpleRecipeOne, simpleRecipeTwo, compoundRecipeTwo)));
    }
}
