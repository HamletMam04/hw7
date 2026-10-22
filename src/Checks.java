import java.util.Random;

public final class Checks {
    private Checks() { }
    public static void run(Pizza[] pizzas, Customer[] customers) {
        require(pizzas[0].getSize() == Size.SMALL && pizzas[1].getSize() == Size.MEDIUM && pizzas[2].getSize() == Size.LARGE, "required Pizza Hut sizes");
        int[] counts = {3, 6, 9, 3, 2, 8, 6, 1, 3};
        for (int i = 0; i < counts.length; i++) require(pizzas[i].getToppings().size() == counts[i], "pizza topping count " + (i + 1));
        require(DefaultMacronutrientFactory.getInstance() == DefaultMacronutrientFactory.getInstance()
            && CarbsFactory.getInstance() == CarbsFactory.getInstance() && ProteinFactory.getInstance() == ProteinFactory.getInstance()
            && FatsFactory.getInstance() == FatsFactory.getInstance(), "singleton identity");
        MacronutrientFactory factory = DefaultMacronutrientFactory.getInstance();
        Random reproducible = new Random(2026);
        for (int generation = 0; generation < 30; generation++) for (Customer customer : customers) {
            Meal meal = factory.createMeal(customer, reproducible);
            require(FoodRules.isAllowed(meal.getCarb(), customer.getDietPlan()) && FoodRules.isAllowed(meal.getProtein(), customer.getDietPlan()) && FoodRules.isAllowed(meal.getFat(), customer.getDietPlan()), "meal restrictions for " + customer.getDietPlan());
        }
        System.out.println("\nChecks passed: sizes, all topping counts, singleton identity, and 180 diet-safe generated meals.");
    }
    private static void require(boolean condition, String description) { if (!condition) throw new AssertionError("Failed: " + description); }
}
