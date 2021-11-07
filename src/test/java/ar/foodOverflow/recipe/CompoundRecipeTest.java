package ar.foodOverflow.recipe;

import ar.foodOverflow.builders.FoodBuilder;
import ar.foodOverflow.builders.SimpleRecipeBuilder;
import ar.foodOverflow.enums.Difficulty;
import ar.foodOverflow.enums.FoodGroup;
import ar.foodOverflow.ingredient.Ingredient;
import ar.foodOverflow.nutritionalCondition.Diabetic;
import ar.foodOverflow.nutritionalCondition.Hypertensive;
import ar.foodOverflow.nutritionalCondition.Vegan;
import ar.foodOverflow.nutritionalCondition.Vegetarian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ar.foodOverflow.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Given a compound ar.foodOverflow.recipe")
public class CompoundRecipeTest {
    public User compoundUser;
    public User authorOne;
    public CompoundRecipe compoundRecipe;
    public FoodBuilder foodBd = new FoodBuilder();
    public SimpleRecipeBuilder simpleRecipeBd = new SimpleRecipeBuilder();
    private Recipe simpleRecipeOne;
    private Recipe simpleRecipeTwo;
    private Recipe compoundRecipeTwo;


    @Test
    @DisplayName("is inadequate for the set of nutritional conditions of its sub-recipes")
    public void inadequateCompoundRecipe() {
        var nutritionalConditions = Stream.of(Vegan.getInstance(),
                Vegetarian.getInstance(),
                Hypertensive.getInstance(),
                Diabetic.getInstance())
                    .collect(Collectors.toCollection(HashSet::new));

        compoundRecipe.addSubRecipe(simpleRecipeOne);
        compoundRecipe.addSubRecipe(simpleRecipeTwo);
        compoundRecipe.addSubRecipe(compoundRecipeTwo);

        assertEquals(nutritionalConditions, compoundRecipe.inadequateConditions());
    }

    @Test
    @DisplayName("its difficulty is equal to the maximum difficulty of its sub-recipes")
    public void compoundRecipeDifficulty() {

        compoundRecipe.addSubRecipe(simpleRecipeOne);
        compoundRecipe.addSubRecipe(simpleRecipeTwo);
        compoundRecipe.addSubRecipe(compoundRecipeTwo);

        assertEquals(Difficulty.NORMAL, compoundRecipe.difficulty());
    }

    @Test
    @DisplayName("its preparation process is equal to the set of the preparation process of its sub-recipes plus its own preparation steps")
    public void procesoRecetaCompuesta() {
        var steps = new ArrayList<String>();

        steps.addAll(simpleRecipeOne.getPreparationSteps());
        steps.addAll(simpleRecipeTwo.getPreparationSteps());
        steps.addAll(compoundRecipeTwo.getPreparationSteps());

        compoundRecipe.addSubRecipe(simpleRecipeOne);
        compoundRecipe.addSubRecipe(simpleRecipeTwo);
        compoundRecipe.addSubRecipe(compoundRecipeTwo);

        assertEquals(steps, compoundRecipe.getPreparationSteps());
    }

    @Test
    @DisplayName("sum of calories")
    public void composedOfCompoundRecipes() {
        var calories = simpleRecipeOne.getCalories() + simpleRecipeTwo.getCalories();

        compoundRecipe.addSubRecipe(simpleRecipeOne);
        compoundRecipe.addSubRecipe(simpleRecipeTwo);

        assertEquals(calories, compoundRecipe.getCalories());
    }

    @Test
    @DisplayName("valid")
    public void valid() {
        compoundRecipe.addSubRecipe(simpleRecipeOne);
        compoundRecipe.addSubRecipe(simpleRecipeTwo);
        compoundRecipe.addSubRecipe(compoundRecipeTwo);
        assertTrue(compoundRecipe.valid());
    }

    @BeforeEach
    public void init() {
        compoundUser = new User();
        authorOne = new User();

        var foodOne = foodBd
                .setName("ar.foodOverflow.food one")
                .setDescription("ar.foodOverflow.food one description")
                .setFoodGroup(FoodGroup.FATTY_OILS_SUGAR)
                .addInadequateCondition(Vegetarian.getInstance())
                .addInadequateCondition(Vegan.getInstance())
                .build();

        var foodTwo = foodBd
                .setName("ar.foodOverflow.food two")
                .setDescription("ar.foodOverflow.food two description")
                .setFoodGroup(FoodGroup.VEGETABLES_FRUITS_SEEDS)
                .addInadequateCondition(Hypertensive.getInstance())
                .build();

        var foodThree = foodBd
                .setName("ar.foodOverflow.food three")
                .setDescription("ar.foodOverflow.food two description")
                .setFoodGroup(FoodGroup.DAIRY_DERIVATIVES)
                .addInadequateCondition(Diabetic.getInstance())
                .build();

        var ingredientOne = new Ingredient(foodOne, "150 g");
        var ingredientTwo = new Ingredient(foodTwo, "150 g");
        var ingredientThree = new Ingredient(foodThree, "150 g");

        simpleRecipeOne = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(100f)
                .addPreparationStep("step one ar.foodOverflow.recipe one")
                .addIngredient(ingredientOne)
                .setDifficutly(Difficulty.EASY)
                .build();

        simpleRecipeTwo = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(200f)
                .addPreparationStep("step one ar.foodOverflow.recipe two")
                .addIngredient(ingredientTwo)
                .setDifficutly(Difficulty.EASY)
                .build();

        Recipe simpleRecipeThree = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(300f)
                .addPreparationStep("step one ar.foodOverflow.recipe three")
                .addIngredient(ingredientThree)
                .setDifficutly(Difficulty.NORMAL)
                .build();

        compoundRecipeTwo = new CompoundRecipe(authorOne,
                new HashSet<>(),
                new ArrayList<>(List.of(simpleRecipeThree)));

        compoundRecipe = new CompoundRecipe(compoundUser,
                new HashSet<>(),
                new ArrayList<>());
    }
}
