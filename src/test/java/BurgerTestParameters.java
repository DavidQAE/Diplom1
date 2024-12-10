import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
////
@RunWith(Parameterized.class)
public class BurgerTestParameters {

    private Burger burger;
    private Bun mockBun;
    private List<Ingredient> mockIngredients;

    private int numIngredients;
    private float expectedPrice;


    public BurgerTestParameters(int numIngredients, float expectedPrice) {
        this.numIngredients = numIngredients;
        this.expectedPrice = expectedPrice;

    }

    @Before
    public void setup() {
        mockBun = mock(Bun.class);
        mockIngredients = new ArrayList<>();
        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 400f},  // no ingredients
                {1, 500f},  // one ingredient
                {2, 600f}  // two ingredients
        });
    }
    //Параметризированный тест
    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(200f);
        for (int i = 0; i < numIngredients; i++) {
            Ingredient mockIngredient = mock(Ingredient.class);
            when(mockIngredient.getPrice()).thenReturn(100f);
            mockIngredients.add(mockIngredient);
        }

        for (Ingredient ingredient : mockIngredients) {
            burger.addIngredient(ingredient);
        }

        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }


}
