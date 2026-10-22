import java.util.Random;

public interface MacronutrientFactory {
    Meal createMeal(Customer customer, Random random);
    CarbsFactory carbsFactory();
    ProteinFactory proteinFactory();
    FatsFactory fatsFactory();
}
