public class Day4_1 {
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
    while (password > 0) {
      int digit = password % 10;
      password = password / 10;
      if (digit > prevDigit) {
        return false;
      } else if (digit == prevDigit) {
        twoSame = true;
      }
      prevDigit = digit;
    }
    if (!twoSame) {
      return false;
    }
    return true;
  }
}
