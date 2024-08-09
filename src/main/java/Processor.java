import java.io.*;
import java.util.*;

class Processor {
 
  public String process(List<String> input) {
    Merchant merchant = new Merchant();
    for (String line : input) {
      String[] parameter = line.split(" ");
      if (parameter.length == 4) { //Add new card
        merchant.processCommand(parameter[0], parameter[1], parameter[2], getAmount(parameter[3]));
      } else if (parameter.length == 3) { //charge credit
        merchant.processCommand(parameter[0], parameter[1], null, getAmount(parameter[2]));
      }
    }
    return merchant.generate_merchant_summary();
  }
  
  Integer getAmount(String value) {
    return Integer.parseInt(value.substring(1));
  }
  
  static public void main(String[] args) {
    List<String> lines = new ArrayList<>();
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    scanner.useDelimiter(System.getProperty("line.separator"));
    while (scanner.hasNext()) {
      lines.add(scanner.next());
    }
    scanner.close();
  
    Processor processor = new Processor();
    String result = processor.process(lines);   
    System.out.println(result);
  }
  
}

//Tom 500+800 
//Lisa 7 - 100 = 
