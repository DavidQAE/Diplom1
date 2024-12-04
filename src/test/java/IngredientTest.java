import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    //тесты методов класса
    @Test
    public void getPrice() {

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100f);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100f);
        Assert.assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100f);
        Assert.assertEquals(100f, ingredient.getPrice(), 0.001f);
    }
}