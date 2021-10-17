package user;

import enums.FoodGroup;
import enums.Routine;
import food.Food;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    public Routine routine;
    public float weight;
    public float height;
    public Set<Food> favoriteFoods = new HashSet<>();
    public LocalDate dateOfBirth;

    public User() {
    }

    public User(Routine routine, float weight, float height, Set<Food> favoriteFoods, LocalDate dateOfBirth) {
        this.routine = routine;
        this.weight = weight;
        this.height = height;
        this.favoriteFoods = favoriteFoods;
        this.dateOfBirth = dateOfBirth;
    }

    public float bmi() {
        return weight / (height * height);
    }

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

    private float age() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public boolean isYoungerThan(float _age) {
        return age() < _age;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
