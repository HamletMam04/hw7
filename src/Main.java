import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Part 1: Pizza Builder ===");
        Pizza[] allPizzas = {
            Pizza.pizzaHut(Size.SMALL).pepperoni().mushrooms().olives().build(),
            Pizza.pizzaHut(Size.MEDIUM).sausage().bacon().onions().extraCheese().peppers().chicken().build(),
            Pizza.pizzaHut(Size.LARGE).pepperoni().sausage().mushrooms().bacon().onions().extraCheese().peppers().chicken().olives().build(),
            Pizza.pizzaHut(Size.LARGE).spinach().tomatoAndBasil().pesto().build(),
            Pizza.pizzaHut(Size.SMALL).hamAndPineapple().extraCheese().build(),
            Pizza.littleCaesars(Size.MEDIUM).pepperoni().sausage().mushrooms().bacon().onions().peppers().olives().beef().build(),
            Pizza.littleCaesars(Size.SMALL).chicken().spinach().tomatoAndBasil().pesto().spicyPork().ham().build(),
            Pizza.dominos(Size.SMALL).extraCheese().build(),
            Pizza.dominos(Size.LARGE).pepperoni().ham().hamAndPineapple().build() };
        for (Pizza pizza : allPizzas) pizza.eat();

        System.out.println("\n=== Part 2: Macronutrient Meals ===");
        Customer[] customers = { new Customer("Ava", DietPlan.NO_RESTRICTION), new Customer("Ben", DietPlan.PALEO),
            new Customer("Cora", DietPlan.VEGAN), new Customer("Diego", DietPlan.NUT_ALLERGY),
            new Customer("Emma", DietPlan.VEGAN), new Customer("Finn", DietPlan.NO_RESTRICTION) };
        MacronutrientFactory factory = DefaultMacronutrientFactory.getInstance();
        Random random = new Random();
        for (Customer customer : customers)
            System.out.println(customer.getName() + " (" + customer.getDietPlan() + "): " + factory.createMeal(customer, random));
        Checks.run(allPizzas, customers);
    }
}
