import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class CarbsFactory implements FoodFactory<Carb> {
    private static final CarbsFactory INSTANCE = new CarbsFactory();
    private CarbsFactory() { }
    public static CarbsFactory getInstance() { return INSTANCE; }
    public Carb create(DietPlan diet, Random random) { return pick(Carb.values(), diet, random, "carb"); }
    static <T extends FoodItem> T pick(T[] foods, DietPlan diet, Random random, String category) {
        List<T> allowed = new ArrayList<T>();
        for (T food : foods) if (FoodRules.isAllowed(food, diet)) allowed.add(food);
        if (allowed.isEmpty()) throw new IllegalStateException("No allowed " + category + " for " + diet);
        return allowed.get(random.nextInt(allowed.size()));
    }
}
