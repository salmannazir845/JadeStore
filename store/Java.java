package store;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Java extends Product
{
    protected Darkness darkness;
    protected ArrayList<Shot> shots = new ArrayList<Shot>();
    public static final String ID = "store.Java";

    
    public Java(String name, double price, double cost, Darkness darkness)
    {
        super(name, price, cost);
        this.darkness = darkness;
    }
    
    public Java(BufferedReader in) throws IOException
    {
        super(in.readLine(), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()));
        this.darkness = Darkness.valueOf(in.readLine());
    }
    
    public void save(BufferedWriter out) throws IOException
    {
        out.write("" + name + '\n');
        out.write("" + price + '\n');
        out.write("" + cost + '\n');
        out.write("" + darkness + '\n');
    }
    
    public void addShot(Shot shot)
    {
        shots.add(shot);
    }
    
    @Override
    public String toString()
    {
        return String.format("Name: " + name + 
                             "\nPrice: " + price + 
                             "\nDarkness: " + darkness +
                             "\nShots: " + shots + "\n"); 
    }
    
}
