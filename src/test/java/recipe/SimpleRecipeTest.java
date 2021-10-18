package recipe;

import builders.FoodBuilder;
import enums.FoodGroup;
import ingredient.Ingredient;
import nutritionalCondition.NutritionalCondition;
import nutritionalCondition.Vegan;
import nutritionalCondition.Vegetarian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given a simple recipe")
public class SimpleRecipeTest {

    User author;
    User collaborator;
    User user;
    Recipe recipe;
    FoodBuilder foodBuilder = new FoodBuilder();

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

    @BeforeEach
    public void init() {
        author = new User();
        collaborator = new User();
        var food =  foodBuilder
                .setName("name")
                .setDescription("description")
                .setFoodGroup(FoodGroup.FATTY_OILS_SUGAR)
                .addInadequateCondition(Vegetarian.getInstance())
                .addInadequateCondition(Vegan.getInstance())
                .build();
        var ingredient = new Ingredient(food, "150 g");
        recipe = new SimpleRecipe(author, new HashSet<>(List.of(ingredient)));
    }
}
