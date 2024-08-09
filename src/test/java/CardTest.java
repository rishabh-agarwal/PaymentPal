import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardTest {
  Card validCard;
  Card invalidCard;

  @BeforeEach
  public void resetCards() {
    validCard = new Card("Jimmy", "123456789031", 1000);
    invalidCard = new Card("Invalid", "52345678903", 1000);
  }

  @Test
  public void testCardName() {
    assertEquals("Jimmy", validCard.getName());
  }

  @Test
  public void testCardChargeDoesntIncreaseBalanceIfOverLimit() {
    validCard.charge(1300);
    assertEquals(Integer.valueOf(0), validCard.getBalance());
  }

  @Test
  public void testCardChargeIncreasesIfChargeAmountIsValid() {
    validCard.charge(100);
    assertEquals(Integer.valueOf(100), validCard.getBalance());
  }

  @Test
  public void testCardChargeShouldIgnoreChargesToAnInvalidCard() {
    invalidCard.charge(100);
    assertEquals(Integer.valueOf(0), invalidCard.getBalance()); // zero
  }

  @Test
  public void testCardCreditShouldDecrementValidBalanceByAmount() {
    validCard.credit(500);
    assertEquals(Integer.valueOf(-500), validCard.getBalance());
  }

  @Test
  public void testCardCreditShouldIgnoreCreditToInvalidCard() {
    invalidCard.credit(500);
    assertEquals(Integer.valueOf(0), invalidCard.getBalance());
  }

  @Test
  public void testCardToStringValid() {
    validCard.charge(500);
    assertEquals("Jimmy: $500", validCard.toString());
  }

  @Test
  public void testCardToStringInvalid() {
    assertEquals("Invalid: error", invalidCard.toString());
  }
}
