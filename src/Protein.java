public enum Protein implements FoodItem {
    FISH("Fish"), CHICKEN("Chicken"), BEEF("Beef"), TOFU("Tofu");
    private final String name;
    Protein(String name) { this.name = name; }
    public String getName() { return name; }
    @Override public String toString() { return name; }
}
