public class Day4_2 {
  public static void main(String[] args){
    int lowerBound = 123257;
    int higherBound = 647015;
    System.out.println(calPasswordPermutations(lowerBound, higherBound));
  }

  static int calPasswordPermutations(int lowerBound, int higherBound) {
    int times = 0;
    for (int i = lowerBound; i <= higherBound; i++) {
      if (isPassword(i)) {
        times++;
      }
    }
    return times;
  }

  static boolean isPassword(int password) {
    int prevDigit = 10;
    boolean twoSame = false;
    int repeated = 0;
    while (password > 0) {
      int digit = password % 10;
      password = password / 10;
      if (digit > prevDigit) {
        return false;
      } else if (digit == prevDigit) {
        if (repeated == 0) {
          repeated = 2;
        } else {
          repeated++;
        }
      } else {
        if (repeated == 2) {
          twoSame = true;
        }
        repeated = 0;
      }
      prevDigit = digit;
    }
    if (repeated == 2) {
      return true;
    }
    if (!twoSame) {
      return false;
    }
    return true;
  }
}
