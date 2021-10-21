package recipe;

import builders.FoodBuilder;
import builders.SimpleRecipeBuilder;
import enums.FoodGroup;
import food.Food;
import ingredient.Ingredient;
import nutritionalCondition.*;
import org.junit.jupiter.api.Assertions;
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
        var nutritionalConditions = Stream.of(Vegan.getInstance(),
                Vegetarian.getInstance(),
                Hypertensive.getInstance(),
                Diabetic.getInstance())
                    .collect(Collectors.toCollection(HashSet::new));

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
                .addPreparationStep("step one")
                .addIngredient(ingredientOne)
                .build();

        var simpleRecipeTwo = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(200f)
                .addPreparationStep("step one")
                .addIngredient(ingredientTwo)
                .build();

        var simpleRecipeThree = simpleRecipeBd
                .setAuthor(authorOne)
                .setCalories(300f)
                .addPreparationStep("step one")
                .addIngredient(ingredientThree)
                .build();

        var compoundRecipeTwo = new CompoundRecipe(authorOne,
                new HashSet<>(),
                new ArrayList<>(List.of(simpleRecipeThree)));

        compoundRecipe = new CompoundRecipe(compoundUser,
                new HashSet<>(),
                new ArrayList<>(Arrays.asList(simpleRecipeOne, simpleRecipeTwo, compoundRecipeTwo)));
    }
}
