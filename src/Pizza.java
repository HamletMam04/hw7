import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Pizza {
    private final Chain chain;
    private final Size size;
    private final List<Topping> toppings;

    private Pizza(Builder builder) {
        chain = builder.chain;
        size = builder.size;
        toppings = Collections.unmodifiableList(new ArrayList<Topping>(builder.toppings));
    }

    public Chain getChain() { return chain; }
    public Size getSize() { return size; }
    public List<Topping> getToppings() { return toppings; }

    public void eat() {
        System.out.println(chain + " " + size + " pizza with: " + toppings);
    }

    public static Builder pizzaHut(Size size) { return new Builder(Chain.PIZZA_HUT, size); }
    public static Builder littleCaesars(Size size) { return new Builder(Chain.LITTLE_CAESARS, size); }
    public static Builder dominos(Size size) { return new Builder(Chain.DOMINOS, size); }

    public static final class Builder {
        private final Chain chain;
        private final Size size;
        private final List<Topping> toppings = new ArrayList<Topping>();

        private Builder(Chain chain, Size size) {
            if (size == null) throw new IllegalArgumentException("Pizza size is required.");
            this.chain = chain;
            this.size = size;
        }
        private Builder add(Topping topping) { toppings.add(topping); return this; }
        public Builder pepperoni() { return add(Topping.PEPPERONI); }
        public Builder sausage() { return add(Topping.SAUSAGE); }
        public Builder mushrooms() { return add(Topping.MUSHROOMS); }
        public Builder bacon() { return add(Topping.BACON); }
        public Builder onions() { return add(Topping.ONIONS); }
        public Builder extraCheese() { return add(Topping.EXTRA_CHEESE); }
        public Builder peppers() { return add(Topping.PEPPERS); }
        public Builder chicken() { return add(Topping.CHICKEN); }
        public Builder olives() { return add(Topping.OLIVES); }
        public Builder spinach() { return add(Topping.SPINACH); }
        public Builder tomatoAndBasil() { return add(Topping.TOMATO_AND_BASIL); }
        public Builder beef() { return add(Topping.BEEF); }
        public Builder ham() { return add(Topping.HAM); }
        public Builder pesto() { return add(Topping.PESTO); }
        public Builder spicyPork() { return add(Topping.SPICY_PORK); }
        public Builder hamAndPineapple() { return add(Topping.HAM_AND_PINEAPPLE); }
        public Pizza build() { return new Pizza(this); }
    }
}
