package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Donut extends Product
{
    protected Frosting frosting;
    protected boolean sprinkles;
    protected Filling filling;
    public static final String ID = "store.Donut";

    public Donut(String name, double price, double cost, Frosting frosting, Filling filling, boolean sprinkles)
    {
        super(name, price, cost);
        this.frosting = frosting;
        if (frosting == Frosting.unfrosted && sprinkles == true)
            throw new IllegalArgumentException("Unfrosted donut cannot have sprinkles");
        this.sprinkles = sprinkles;
        this.filling = filling;
    }
    
    public Donut(BufferedReader in) throws IOException
    {
        super(in.readLine(), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()));
        this.frosting = Frosting.valueOf(in.readLine());
        if (frosting == Frosting.unfrosted && sprinkles == true)
            throw new IllegalArgumentException("Unfrosted donut cannot have sprinkles");
        this.sprinkles = Boolean.parseBoolean(in.readLine());
        this.filling = Filling.valueOf(in.readLine());
    }
    
    public void save(BufferedWriter out) throws IOException
    {
        out.write("" + name + '\n');
        out.write("" + price + '\n');
        out.write("" + cost + '\n');
        out.write("" + frosting + '\n');
        out.write("" + filling + '\n');
        out.write("" + sprinkles + '\n');
    }
    
    @Override
    public String toString()
    {
        return String.format("Name: " + name + 
                             "\nPrice: $" + price +
                             "\nFrosting: " + frosting +
                             "\nSprinkles: " + sprinkles +
                             "\nFilling: " + filling + "\n");
    }
    
}
