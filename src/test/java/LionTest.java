import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline mockFeline;

    @Test
    void testGetKittensDelegation() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);

        int kittens = lion.getKittens();

        assertEquals(3, kittens);
        verify(mockFeline).getKittens();
    }

    @Test
    void testGetFoodDelegation() throws Exception {
        List<String> food = List.of("Антилопа", "Зебра");

        when(mockFeline.getFood("Хищник")).thenReturn(food);
        Lion lion = new Lion("Самец", mockFeline);

        List<String> result = lion.getFood();

        assertEquals(food, result);
        verify(mockFeline).getFood("Хищник");
    }

    @Test
    void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", mockFeline));

        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}

