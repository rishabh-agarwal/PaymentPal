    // Copied from: https://java2blog.com/luhn-algorithm-java/

    import java.util.*;

class Luhn {
  public static Boolean isValid(String cardNumber) {    
    int[] cardIntArray = new int[cardNumber.length()];
 
    for (int i=0; i < cardNumber.length(); i++) {
      char c= cardNumber.charAt(i);
      cardIntArray[i]=  Integer.parseInt(""+c);
    }
 
    for(int i = cardIntArray.length-2; i >= 0; i = i - 2) {
      int num = cardIntArray[i];
      num = num * 2;
      if (num > 9) {
        num = num % 10 + num / 10;
      }
      cardIntArray[i]=num;
    }
 
    int sum = sumDigits(cardIntArray);
 
 
    if (sum%10 == 0) {
      return true;
    }
 
    return false;
 
  }
 
  private static int sumDigits(int[] arr) {
    return Arrays.stream(arr).sum();
  }
}