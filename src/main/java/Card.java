class Card {
  private String name;
  private String cardNumber;
  private Integer limit;
  private Integer balance = 0;
  private Boolean validCard;
  
  public Card(String name, String cardNumber, Integer limit) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.limit = limit;
    this.validCard = Luhn.isValid(cardNumber);
  }
  
  public String getName() {
    return name;
  }
  //decrese the balance by amount
  //if balance below 0, negative
  public Integer credit(Integer amount) {
    if(validCard){
      balance -= amount;
    }
    return balance;
  }
  //increase balance
  //over the limit - ignore the charges
  //charges against Luhn 10
  public void charge(Integer amount) {
    if (validCard) {
      Integer newBalance = balance + amount; //1300
      if (newBalance < limit) { //1300<1000
        balance = newBalance; // actually set Card's balance to new balance
      }
    }
  }
  
  public Integer getBalance() {
    return balance;
  }
  
  public String toString() {
    if(validCard){
      return String.format("%s: $%s", name, balance);
    }
    return String.format("%s: error", name);
  }
}