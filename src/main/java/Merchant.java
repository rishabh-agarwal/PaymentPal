import java.util.*;
import java.util.stream.*;

class Merchant {
  Map<String, Card> cards = new HashMap<>();
  
  public void processCommand(String type, String name, String cardNumber, Integer amount) {
    switch(type) {
      case "Add": //create new card
        cards.put(name, new Card(name, cardNumber, amount));
        break;
      case "Charge": //increase the balance
        Card c = null;
        for (Map.Entry<String, Card> entry : cards.entrySet()) {
          Card card = entry.getValue();
          if (name.equals(card.getName())){
            c = card;
          } else {
            throw new RuntimeException("This shouldn't be happenning!");
            // This shoudldn't be happening! the card can't be found!
          }
        }
      
        if (c != null) {
          c.charge(amount);
        }
        break;
        
        
        
        
        
        
        
      
      case "Credit":
        Card ca = cards.get(name);
        if (ca != null) {
          ca.credit(amount);
        }
        break;
    }
  }
  
  public String generate_merchant_summary() {
    return cards.entrySet()
      .stream()
      .sorted(Map.Entry.<String, Card>comparingByKey())
      .map(Map.Entry::getValue)
      .map(card -> card.toString())
      .collect(Collectors.joining("\n"));
  }
}
