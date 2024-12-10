import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private List<Ingredient> mockIngredients;

    //
    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = new Bun("white Bun", 100);

        bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(100F); // Цена булочки


        ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(100F); // Цена первого ингредиента


        ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(100F); // Цена первого ингредиента


        mockIngredients = new ArrayList<>();
        mockIngredients.add(ingredient1);
        mockIngredients.add(ingredient2);

        // Создаем объект Burger
        burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients = mockIngredients;
    }

    @Test
    public void getPrice() {
        assertEquals(400f, burger.getPrice(), 0.001);
    }

    @Test
    public void testSetBun() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    // Проверка добавления ингредиента
    @Test
    public void addIngredient() {
        Ingredient newIngredient = mock(Ingredient.class);
        when(newIngredient.getPrice()).thenReturn(300f);


        burger.addIngredient(newIngredient);

        assertEquals(3, burger.ingredients.size());

        assertEquals(700f, burger.getPrice(), 0.001F);
    }
    // Проверка удаление инградиента
    @Test
    public void removeIngredient() {

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());

        assertEquals(300f, burger.getPrice(), 0.001);

    }
    //Проверка изменения ингредиентов
    @Test
    public void moveIngredient() {
        burger.moveIngredient(1, 0);

        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));

        assertEquals(400F, burger.getPrice(), 0.001F);
    }

    @Test
    public void getReceiptTest() {
        bun = new Bun("white bun", 100);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100F);


        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        String expectedReceipt = "(==== white bun ====)\r\n= sauce hot sauce =\r\n(==== white bun ====)\r\n\r\nPrice: 300,000000\r\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}