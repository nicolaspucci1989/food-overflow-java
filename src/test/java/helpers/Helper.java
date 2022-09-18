package helpers;

import user.User;

import java.time.LocalDate;

public class Helper {
  static public User.UserBuilder getBasicUserBuilder() {
    return User.builder()
        .weight(80.2f)
        .height(1.7f)
        .dateOfBirth(LocalDate.now().minusYears(22));
  }
}
