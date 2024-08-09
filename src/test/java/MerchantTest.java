import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MerchantTest {
    Merchant merchant;
    Card card;

    @BeforeEach
    public void setupMerchant() {
        merchant = new Merchant();
    }

    @Test
    public void testMerchantCorrectlyAddsACard() {
        merchant.processCommand("Add", "new_card", "4111111111111111", 5000);
        Card card = merchant.cards.get("new_card");
        assertNotNull(card);
        assertEquals("new_card: $0", card.toString());
    }

    @Test
    public void testMerchantChargesCardWithSpecificName() {
        merchant.processCommand("Add", "Jimmy", "4111111111111111", 1000);
        merchant.processCommand("Charge", "Jimmy", null, 500);

        Card card = merchant.cards.get("Jimmy");
        assertNotNull(card);
        assertEquals("Jimmy: $500", card.toString());
    }

    @Test
    public void testMerchantCreditsCardWithSpecificName() {
        merchant.processCommand("Add", "Jimmy", "4111111111111111", 1000);
        merchant.processCommand("Credit", "Jimmy", null, 500);

        Card card = merchant.cards.get("Jimmy");
        assertNotNull(card);
        assertEquals("Jimmy: $-500", card.toString());
    }


    @Test
    public void testSummary() {
        merchant.processCommand("Add", "B", "4111111111111111", 1000);
        merchant.processCommand("Charge", "B", null, 500);
        merchant.processCommand("Add", "A", "5454545454545454", 1000);
        merchant.processCommand("Add", "C", "123465789031", 3000);

        String expectedOutput = "A: $0\n" +
                "B: $500\n" +
                "C: error";

        assertEquals(expectedOutput.trim(), merchant.generate_merchant_summary().trim());
    }


}
