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
public final class Menu 
{
    void MenuMain()
    {
        System.out.println("== COURSE MANAGEMENT SYSTEM ==");
        System.out.println("1. Add information of course.");
        System.out.println("2. Display all of course.");
        System.out.println("3. Search of course");
        System.out.println("4. Remove information of course.");
        System.out.println("5. Sort all courses");
        System.out.println("6. Update information of a specific course");
        System.out.println("7. Print to excel");
        System.out.println("8. Report");
        System.out.println("0. Exit.");
        System.out.print("Select your choice:");
    }
        
    void MenuSearchBy()
    {
        System.out.println("== DO YOU WANT SEARCH BY ==");
        System.out.println("1. By course id.");
        System.out.println("2. By available.");
        System.out.println("3. By name.");
        System.out.println("0. Exit.");
        System.out.print("Select your choice:");
    }
    
    void MenuSearchDisplay()
    {
        System.out.println("== YOU WANT DISPLAY ==");
        System.out.println("1. Display indext.");
        System.out.println("2. Display all information.");
        System.out.println("0. Exit.");
        System.out.print("Select your choice:");
    }
    

    
    void MenuRemove()
    {
        System.out.println("== DO YOU WANT REMOVE BY ==");
        System.out.println("1. By course id.");
        System.out.println("2. By name");
        System.out.println("0. Exit.");
        System.out.print("Select your choice:");
    }
    
    void MenuSort()
    {
        System.out.println("== HOW DO YOU WANT SORT ==");
        System.out.println("1. Ascending.");
        System.out.println("2. Decreasing.");
        System.out.println("0. Exit.");
        System.out.print("Select your choice:");
    }
    
    void MenuSortBy()
    {
        System.out.println("== DO YOU WANT SORT BY ==");
        System.out.println("1. By number of credit.");
        System.out.println("2. By name.");
        System.out.println("3. By course id.");
        System.out.println("4. By course cost and id.");
        System.out.println("0. Exit.");
        System.out.print("Select your choice:");
    }
    
    void MenuUpdate()
    {
        System.out.println("== DO YOU WANT UPDATE BY ==");
        System.out.println("1. By course id");
        System.out.println("0. Exit.");
        System.out.print("Select your choice:");
    }
}
