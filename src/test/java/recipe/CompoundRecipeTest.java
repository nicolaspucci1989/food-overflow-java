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

import java.util.*;
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
    private Recipe easyRecipeOne;
    private Recipe easyRecipeTwo;
    private Recipe compoundRecipeTwo;


    @Test
    @DisplayName("is inadequate for the set of nutritional conditions of its sub-recipes")
    public void inadequateCompoundRecipe() {
        var nutritionalConditions = Stream.of(Vegan.getInstance(),
                Vegetarian.getInstance(),
                Hypertensive.getInstance(),
                Diabetic.getInstance())
                    .collect(Collectors.toCollection(HashSet::new));

        compoundRecipe.addSubRecipe(easyRecipeOne);
        compoundRecipe.addSubRecipe(easyRecipeTwo);
        compoundRecipe.addSubRecipe(compoundRecipeTwo);

        assertEquals(nutritionalConditions, compoundRecipe.inadequateConditions());
    }

    @Test
    @DisplayName("its difficulty is equal to the maximum difficulty of its sub-recipes")
    public void compoundRecipeDifficulty() {

        compoundRecipe.addSubRecipe(easyRecipeOne);
        compoundRecipe.addSubRecipe(easyRecipeTwo);
        compoundRecipe.addSubRecipe(compoundRecipeTwo);

        assertEquals(Difficulty.NORMAL, compoundRecipe.difficulty());
    }

    @Test
    @DisplayName("its preparation process is equal to the set of the preparation process of its sub-recipes plus its own preparation steps")
    public void procesoRecetaCompuesta() {
        var steps = new ArrayList<String>();

        steps.addAll(easyRecipeOne.getPreparationSteps());
        steps.addAll(easyRecipeTwo.getPreparationSteps());
        steps.addAll(compoundRecipeTwo.getPreparationSteps());

        compoundRecipe.addSubRecipe(easyRecipeOne);
        compoundRecipe.addSubRecipe(easyRecipeTwo);
        compoundRecipe.addSubRecipe(compoundRecipeTwo);

        assertEquals(steps, compoundRecipe.getPreparationSteps());
    }

    @Test
    @DisplayName("sum of calories")
    public void composedOfCompoundRecipes() {
        var calories = easyRecipeOne.getCalories() + easyRecipeTwo.getCalories();

        compoundRecipe.addSubRecipe(easyRecipeOne);
        compoundRecipe.addSubRecipe(easyRecipeTwo);

        assertEquals(calories, compoundRecipe.getCalories());
    }

    @Test
    @DisplayName("valid")
    public void valid() {
        compoundRecipe.addSubRecipe(easyRecipeOne);
        compoundRecipe.addSubRecipe(easyRecipeTwo);
        compoundRecipe.addSubRecipe(compoundRecipeTwo);
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

        easyRecipeOne = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(100f)
                .addPreparationStep("step one recipe one")
                .addIngredient(ingredientOne)
                .setDifficutly(Difficulty.EASY)
                .build();

        easyRecipeTwo = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(200f)
                .addPreparationStep("step one recipe two")
                .addIngredient(ingredientTwo)
                .setDifficutly(Difficulty.EASY)
                .build();

        Recipe normalRecipe = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(300f)
                .addPreparationStep("step one recipe three")
                .addIngredient(ingredientThree)
                .setDifficutly(Difficulty.NORMAL)
                .build();

        compoundRecipeTwo = new CompoundRecipe(authorOne,
                new HashSet<>(),
                new ArrayList<>(List.of(normalRecipe)));

        compoundRecipe = new CompoundRecipe(compoundUser,
                new HashSet<>(),
                new ArrayList<>());
    }
}
