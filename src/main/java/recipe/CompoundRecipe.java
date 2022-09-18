package recipe;

import enums.Difficulty;
import food.Food;
import ingredient.Ingredient;
import user.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CompoundRecipe extends Recipe {
  public List<Recipe> subRecipes;

  public CompoundRecipe(User author,
                        Set<User> collaborators,
                        List<Recipe> subRecipes) {
    super(author, collaborators);
    this.subRecipes = subRecipes;
  }

  @Override
  public Set<Ingredient> getIngredients() {
    return subRecipes
        .stream()
        .flatMap(recipe -> recipe.getIngredients().stream())
        .collect(Collectors.toSet());
  }

  @Override
  public Float getCalories() {
    return subRecipes
        .stream()
        .map(Recipe::getCalories)
        .reduce(0f, Float::sum);
  }

  @Override
  public void setCalories(Float calories) throws Exception {
    throw new Exception();
  }

  @Override
  public List<String> getPreparationSteps() {
    return subRecipes
        .stream()
        .map(Recipe::getPreparationSteps)
        .flatMap(List::stream)
        .collect(Collectors.toList());
  }

  @Override
  public Difficulty difficulty() {
    // TODO: use flatMap
    return subRecipes
        .stream()
        .map(Recipe::difficulty)
        .collect(Collectors.toSet())
        .stream()
        .max(Difficulty::compare)
        .orElse(null);
  }

  @Override
  public void addIngredient(Ingredient ingredient) throws Exception {
    throw new Exception();
  }

  @Override
  public void addPreparationStep(String step_one) throws Exception {
    throw new Exception();
  }

  @Override
  public Set<Food> getFoods() {
    return this.subRecipes.stream()
            .map(Recipe::getFoods)
            .flatMap(Collection::stream)
            .collect(Collectors.toSet());
  }

  public void addSubRecipe(Recipe recipe) {
    subRecipes.add(recipe);
  }
}
