import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FelineTest {

    @Test
    void testGetFamily() {
        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testGetKittensDefault() {
        Feline feline = new Feline();

        assertEquals(1, feline.getKittens());
    }

    @Test
    void testDefaultEatMeat() throws Exception {
        Feline feline = new Feline();

        List<String> food = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void testGetFoodForUnknownThrowsException() {
        Feline feline = new Feline();

        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}
