package recipe;

import ingredient.Ingredient;
import nutritionalCondition.NutritionalCondition;
import user.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Recipe {
    User author;
    Set<User> collaborators = new HashSet<>();

    public Recipe(User author) {
        this.author = author;
    }

    public boolean editable(User user) {
       return isAuthor(user) || collaborators.contains(user);
    }

    private boolean isAuthor(User user) {
        return author == user;
    }

    public void addCollaborator(User user) {
        collaborators.add(user);
    }

    public Set<NutritionalCondition> inadequateConditions() {
        return getIngredients()
                .stream()
                .flatMap(ingredient -> ingredient.inadequateConditions().stream())
                .collect(Collectors.toSet());
    }

    public abstract Set<Ingredient> getIngredients();
}
