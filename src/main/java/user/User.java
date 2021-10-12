package user;

import enums.FoodGroup;
import enums.Routine;
import food.Food;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class User {
    public Routine routine;
    public float weight;
    public Set<Food> favoriteFoods = new HashSet<>();

    public boolean routineIs(Routine _routine) {
        return routine == _routine;
    }

    public boolean exceedsWeight(float _weight) {
        return weight <= _weight;
    }

    public boolean amountOfFavoriteFoods(FoodGroup foodGroup, int amount) {
        return amount <= favoriteFoods.stream()
                .filter(food -> food.isFoodGroup(foodGroup))
                .collect(Collectors.toSet())
                .size();
    }

    public void addFavoriteFood(Food food) {
        this.favoriteFoods.add(food);
    }

    /*
    *   Getters and setters
    */
    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

}
