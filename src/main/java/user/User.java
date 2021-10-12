package user;

import enums.Routine;

public class User {
    public Routine routine;
    public float weight;

    public boolean routineIs(Routine _routine) {
        return routine == _routine;
    }

    public boolean exceedsWeight(float _weight) {
        return weight <= _weight;
    }
}
