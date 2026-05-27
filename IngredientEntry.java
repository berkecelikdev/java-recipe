public class IngredientEntry{
    private double amount;
    private String unit;
    private String description;

    public IngredientEntry(double amount, String unit, String description){
        this.amount = amount;
        this.unit = unit;
        this.description = description;
    }

    public double getAmount(){
        return amount;
    }

    public String getUnit(){
        return unit;
    }

    public String getDescription(){
        return description;
    }

    public void setAmount(double newAmount){
        this.amount = newAmount;
    }
}
