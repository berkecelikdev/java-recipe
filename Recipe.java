import java.util.ArrayList;
import java.util.List;

public class Recipe implements RecipeInterface{
    private String title;
    private List<IngredientEntry> ingredientList;
    private List<String> directionList;

    public Recipe(){
        this.ingredientList = new ArrayList<>();
        this.directionList = new ArrayList<>();
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("---Recipe: ").append(title).append(" ---\n");
        sb.append("Ingredients:\n");
        for(IngredientEntry e : ingredientList){
            sb.append("- ").append(e.getAmount()).append(" ").append(e.getUnit()).append(" ").append(e.getDescription()).append("\n");
        }
        sb.append("Directions:\n");
        int step = 1;
        for(String d : directionList){
            sb.append(step++).append(". ").append(d).append("\n");
        }
        return sb.toString();
    }


    public static void main(String[] args){
        Recipe myRecipe = new Recipe();

        myRecipe.setTitle("Grandma's Cookies");

        myRecipe.addIngredient(new IngredientEntry(1.0, "cup", "Sugar"));
        myRecipe.addIngredient(new IngredientEntry(2.5, "cups", "Flour"));
        myRecipe.addIngredient(new IngredientEntry(0.5, "cup", "Sugar"));

        myRecipe.addDirection("Preheat oven to 180 C");
        myRecipe.addDirection("Mix ingredients and bake for 12 mins");

        System.out.println(myRecipe.toString());
    }
}
