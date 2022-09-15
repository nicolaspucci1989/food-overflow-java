import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Smoke test")
public class SmokeTest {
  @Test
  @DisplayName("should not fail")
  public void smokeTest() {
    Number number = 1;
    Assertions.assertEquals(number, 1);
  }
}
