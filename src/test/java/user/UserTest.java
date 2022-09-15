package user;

import enums.Routine;
import nutritionalCondition.Diabetic;
import nutritionalCondition.Hypertensive;
import nutritionalCondition.NutritionalCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given a user")
public class UserTest {
  User user;
  NutritionalCondition diabetic = Diabetic.getInstance();
  NutritionalCondition hypertensive = Hypertensive.getInstance();

  @Test
  @DisplayName("its bmi is equal to the user's weight divided by it's squared height")
  public void bmi() {
    assertEquals(27.7508f, user.bmi(), 0.001f);
  }

  @Test
  @DisplayName("is healthy if he has no preexisting nutritional conditions and has a healthy bmi")
  public void healthyUserWithNoPreexistingNutritionalConditions() {
    assertTrue(user.healthy());
  }

  @Test
  @DisplayName("is healthy if all its nutritional conditions are corrected and has a healthy bmi")
  public void healthyUserCorrectedConditionsHealthyBmi() {
    user.addNutritionalCondition(diabetic);
    user.addNutritionalCondition(hypertensive);
    user.setRoutine(Routine.INTENSE);
    user.setWeight(70);
    assertTrue(user.healthy());
  }

  @Test
  @DisplayName("with an unhealthy bmi, is not healthy")
  public void unhealthyBmi() {
    user.setWeight(120);
    assertFalse(user.healthy());
  }

  @Test
  @DisplayName("is not healthy if has uncorrected nutritional conditions")
  public void notHealthyUserUncorrectedNutritionalConditions() {
    user.addNutritionalCondition(diabetic);
    user.addNutritionalCondition(hypertensive);
    user.setRoutine(Routine.NONE);
    assertFalse(user.healthy());
  }

  @Test
  @DisplayName("its age is equal to the period between his date of birth y the current date")
  public void userAge() {
    assertEquals(22, user.age());
  }

  @BeforeEach
  public void init() {
    user = User.builder()
        .routine(Routine.ACTIVE)
        .weight(80.2f)
        .height(1.7f)
        .dateOfBirth(LocalDate.now().minusYears(22))
        .build();
  }
}
