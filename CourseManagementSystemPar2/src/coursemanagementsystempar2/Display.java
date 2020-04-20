/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemanagementsystempar2;

import java.util.List;

/**
 *
 * @author SHINIGAMI99
 */
public class Display 
{
    public void DisplayAll(List<Course> list)
    {
        for (Course course : list) 
        {
            System.out.println(course.Display());
        }
    }
}
