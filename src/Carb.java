public enum Carb implements FoodItem {
    CHEESE("Cheese"), BREAD("Bread"), LENTILS("Lentils"), PISTACHIO("Pistachio");
    private final String name;
    Carb(String name) { this.name = name; }
    public String getName() { return name; }
    @Override public String toString() { return name; }
}
