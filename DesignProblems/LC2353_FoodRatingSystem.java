//LC 2353
class FoodRatings {

    static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
    

    private HashMap<String, Food> foodToFoodObj;    
    private HashMap<String, TreeSet<Food>> cuisineToSet;
    
    private Comparator<Food> foodComparator = (a, b) -> {
        if (a.rating != b.rating) {
            return b.rating - a.rating;   // higher rating first
        }
        return a.name.compareTo(b.name);  // if tie, lexicographically smaller
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToFoodObj = new HashMap<>();    
        cuisineToSet = new HashMap<>(); 

        for(int i=0; i<foods.length; i++){
            Food foodObj = new Food(foods[i], cuisines[i], ratings[i]);

            foodToFoodObj.put(foods[i], foodObj);

            cuisineToSet.putIfAbsent(cuisines[i], new TreeSet<>(foodComparator));
            cuisineToSet.get(cuisines[i]).add(foodObj);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food foodObj = foodToFoodObj.get(food);
        String cuisine = foodObj.cuisine;

        cuisineToSet.get(cuisine).remove(foodObj);

        foodObj.rating = newRating;

        cuisineToSet.get(cuisine).add(foodObj);

    }
    
    public String highestRated(String cuisine) {
        return cuisineToSet.get(cuisine).first().name;     
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
