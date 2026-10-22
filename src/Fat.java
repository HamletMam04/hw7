public enum Fat implements FoodItem {
    AVOCADO("Avocado"), SOUR_CREAM("Sour cream"), TUNA("Tuna"), PEANUTS("Peanuts");
    private final String name;
    Fat(String name) { this.name = name; }
    public String getName() { return name; }
    @Override public String toString() { return name; }
}
