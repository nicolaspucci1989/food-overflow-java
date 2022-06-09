package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Difficulty {
  EASY("Easy", 0),
  NORMAL("Normal", 1),
  HARD("Hard", 2);

  private final String name;
  private final int value;

  @Override
  public String toString() {
    return getName();
  }

  public int compare(Difficulty that) {
    return Integer.compare(this.value, that.value);
  }
}
