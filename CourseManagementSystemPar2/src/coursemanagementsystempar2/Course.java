/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemanagementsystempar2;

/**
 *
 * @author SHINIGAMI99
 */
public class Course
{
    private String id;
    private String name;
    private int credit;
    private boolean available;
    private double cost;

    public Course() 
    {
        
    }

    public Course(String id, String name, int credit, boolean available, double cost)
    {
        this.id = id.toUpperCase();
        this.name = name.toUpperCase();
        this.credit = credit;
        this.available = available;
        this.cost = cost;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCredit()
    {
        return credit;
    }

    public void setCredit(int credit)
    {
        this.credit = credit;
    }

    public boolean isAvailable() 
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost) 
    {
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return id + ";" + name + ";" + credit + ";" + available + ";" + cost;
    } 
    
    public String Display()
    {
        return id + "\t" + name + "\t" + credit + "\t" + available + "\t" + cost;
    }
}
