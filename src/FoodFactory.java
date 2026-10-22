import java.util.Random;

public interface FoodFactory<T extends FoodItem> {
    T create(DietPlan diet, Random random);
}
