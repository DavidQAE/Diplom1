import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    // Тесты на количество
    @Test
    public void values() {
        // Проверяем, что все значения перечисления присутствуют
        assertEquals("Количество значений не совпадает", 2, IngredientType.values().length);

        // Проверка каждого значения по отдельности
        assertTrue("Значение SAUCE отсутствует", IngredientType.SAUCE != null);
        assertTrue("Значение FILLING отсутствует", IngredientType.FILLING != null);
    }


}