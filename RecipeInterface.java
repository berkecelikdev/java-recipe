public interface RecipeInterface{
    void setTitle(String title);
    String getTitle();
    void addIngredient(IngredientEntry newEntry);
    IngredientEntry getIngredient(int index);
    int getIngredientCount();
    void addDirection(String direction);
}
