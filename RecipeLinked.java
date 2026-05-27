import java.util.LinkedList;
import java.util.List;

public class RecipeLinked implements RecipeInterface{
    private String title;
    private List<IngredientEntry> ingredientList;
    private List<String> directionList;

    public RecipeLinked(){
        this.ingredientList = new LinkedList<>();
        this.directionList = new LinkedList<>();
    }

    @Override
    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String getTitle(){
        return this.title;
    }

    @Override
    public void addIngredient(IngredientEntry newEntry){
        boolean found = false;
        for(IngredientEntry entry : ingredientList){
            if(entry.getDescription().equalsIgnoreCase(newEntry.getDescription())){
                entry.setAmount(entry.getAmount() + newEntry.getAmount());
                found = true;
                break;
            }
        }
        if(!found){
            ingredientList.add(newEntry);
        }
    }

    @Override
    public IngredientEntry getIngredient(int index){
        return ingredientList.get(index);
    }

    @Override
    public int getIngredientCount(){
        return ingredientList.size();
    }

    @Override
    public void addDirection(String direction){
        directionList.add(direction);
    }


    public static void main(String[] args){
        RecipeLinked myRecipe = new RecipeLinked();

        myRecipe.setTitle("Omelette");
        System.out.println("Title: " + myRecipe.getTitle());

        IngredientEntry egg = new IngredientEntry(2.0, "units", "Eggs");
        myRecipe.addIngredient(egg);
        System.out.println("First Item: " + myRecipe.getIngredient(0).getDescription());

        System.out.println("Amount: " + myRecipe.getIngredient(0).getAmount());

        myRecipe.addIngredient(new IngredientEntry(1.0, "pinch", "Salt"));
        System.out.println("Total Ingredients: " + myRecipe.getIngredientCount());
    }
}

