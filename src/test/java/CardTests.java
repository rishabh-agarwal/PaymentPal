import org.junit.jupiter.api.BeforeAll;

public class CardTests {
    Card validCard;
    Card invalidCard;

    @BeforeAll
    public void resetCards() {
        validCard = new Card("Jimmy", "123456789031" , 1000);
        invalidCard = new Card("Invalid", "52345678903" , 1000);
    }
}
