public final class FoodRules {
    private FoodRules() { }
    public static boolean isAllowed(FoodItem item, DietPlan diet) {
        if (diet == DietPlan.NO_RESTRICTION) return true;
        if (diet == DietPlan.PALEO)
            return item == Carb.PISTACHIO || item == Protein.FISH || item == Protein.CHICKEN
                || item == Protein.BEEF || item == Fat.AVOCADO || item == Fat.TUNA;
        if (diet == DietPlan.VEGAN)
            return item == Carb.BREAD || item == Carb.LENTILS || item == Carb.PISTACHIO
                || item == Protein.TOFU || item == Fat.AVOCADO || item == Fat.PEANUTS;
        return item != Carb.PISTACHIO && item != Fat.PEANUTS;
    }
}
