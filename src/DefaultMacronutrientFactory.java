import java.util.Random;

public final class DefaultMacronutrientFactory implements MacronutrientFactory {
    private static final DefaultMacronutrientFactory INSTANCE = new DefaultMacronutrientFactory();
    private DefaultMacronutrientFactory() { }
    public static DefaultMacronutrientFactory getInstance() { return INSTANCE; }
    public CarbsFactory carbsFactory() { return CarbsFactory.getInstance(); }
    public ProteinFactory proteinFactory() { return ProteinFactory.getInstance(); }
    public FatsFactory fatsFactory() { return FatsFactory.getInstance(); }
    public Meal createMeal(Customer customer, Random random) {
        if (customer == null || random == null) throw new IllegalArgumentException("Customer and random source are required.");
        DietPlan diet = customer.getDietPlan();
        return new Meal(carbsFactory().create(diet, random), proteinFactory().create(diet, random), fatsFactory().create(diet, random));
    }
}
