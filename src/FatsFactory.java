import java.util.Random;

public final class FatsFactory implements FoodFactory<Fat> {
    private static final FatsFactory INSTANCE = new FatsFactory();
    private FatsFactory() { }
    public static FatsFactory getInstance() { return INSTANCE; }
    public Fat create(DietPlan diet, Random random) { return CarbsFactory.pick(Fat.values(), diet, random, "fat"); }
}
