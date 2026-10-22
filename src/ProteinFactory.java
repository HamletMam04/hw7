import java.util.Random;

public final class ProteinFactory implements FoodFactory<Protein> {
    private static final ProteinFactory INSTANCE = new ProteinFactory();
    private ProteinFactory() { }
    public static ProteinFactory getInstance() { return INSTANCE; }
    public Protein create(DietPlan diet, Random random) { return CarbsFactory.pick(Protein.values(), diet, random, "protein"); }
}
