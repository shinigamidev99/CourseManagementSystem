/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemanagementsystempar2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author SHINIGAMI99
 */
public class MyCMS implements ICMS
{
    private Scanner in;
    public MyCMS()
    {
        in = new Scanner(System.in);
    }

    
    @Override
    public String checkID(List<Course> list) 
    {
        String id = "";
        boolean check = true;
        do
        { 
            System.out.print("Enter course id:");
            id = in.nextLine();
            check = id.matches("[a-zA-Z]{3}\\d{3}") && !(isCourse(list, id));
        }while(!check);
        return id;
    }
    
    @Override
    public int checkInt(int min,  int max) 
    {
        int number = 0;
        String s = null;
        boolean check = true;
        boolean checkRange = true;
        do 
        {      
            s = in.nextLine();
            if(!(check = s.matches("\\d+")))
            {
                System.out.println("Error input!");
            }
            else
            {
                number = Integer.parseInt(s);
                if(!(checkRange = number >= min && number <= max))
                {
                    System.out.println("Out of range!");
                }
            }   
        }while(!check || !checkRange);
        number = Integer.parseInt(s);
        return number;
    }

    @Override
    public boolean isCourse(List<Course> list, String id)
    {
        for(int i =0; i < list.size(); i++)
        {
            if(list.get(i).getId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }
    
    @Override
    public boolean isCourseName(List<Course> list, String name)
    {
        for(int i =0; i < list.size(); i++)
        {
            if(list.get(i).getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    @Override
    public boolean add(List<Course> list) 
    {
        int min = 1<<31;
        int max = ~min;
        String id = checkID(list);
        System.out.print("Enter course name:");
        String name = in.nextLine();
        System.out.print("Enter course credit:");
        int credit = checkInt(min, max);
        System.out.print("Enter available (true or false):");
        boolean available = Boolean.parseBoolean(in.nextLine());
        System.out.print("Enter cost:");
        int cost = checkInt(min, max);
        return list.add(new Course(id, name, credit, available, cost));
    }

    @Override
    public int[] SearchReturnIndex(List<Course> list, String id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Course> SearchReturnObject(List<Course> list, String id) 
    {
        List l = new ArrayList();
        String s = id.toUpperCase();
        int n = 0;
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId().contains(s))
            {
                l.add(list.get(i));
            }
        }
        return l;
    }

    @Override
    public List<Course> SearchReturnObject(List<Course> list, boolean alivable)
    {
        List l = new ArrayList();
        int n = 0;
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).isAvailable() == alivable)
            {
                l.add(list.get(i));
            }
        }
        return l;
    }

    @Override
    public List<Course> SearchReturnObjectByName(List<Course> list, String name) 
    {
        List l = new ArrayList();
        String s = name.toUpperCase();
        int n = 0;
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getName().contains(s))
            {
                System.out.println("3");
                l.add(list.get(i));
            }
        }
        return l;
    }
    
    @Override
    public void remove(List<Course> list, String id) 
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId().equalsIgnoreCase(id))
            {
                list.remove(i);
                break;
            }
        }
    }

    
    @Override
    public void removeName(List<Course> list, String name) 
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getName().equalsIgnoreCase(name))
            {
                list.remove(i);
                break;
            }
        }
    }
    
    @Override
    public void SortByCredit(List<Course> list, boolean type)
    {
        Collections.sort(list, new Comparator<Course>() 
        {
            @Override
            public int compare(Course o1, Course o2)
            {
                if(type)
                    return (o1.getCredit() - o2.getCredit());
                else
                    return (o2.getCredit() - o1.getCredit());
            }
        });
    }

    @Override
    public void SortByName(List<Course> list, boolean type)
    {
        Collections.sort(list, new Comparator<Course>() 
        {
            @Override
            public int compare(Course o1, Course o2)
            {
                if(type)
                    return (o1.getName().compareToIgnoreCase(o2.getName()));
                else
                    return (o2.getName().compareToIgnoreCase(o1.getName()));
            }
        });
    }

    @Override
    public void SortByID(List<Course> list, boolean type) 
    {
        Collections.sort(list, new Comparator<Course>() 
        {
            @Override
            public int compare(Course o1, Course o2)
            {
                if(type)
                    return (o1.getId().compareToIgnoreCase(o2.getId()));
                else
                    return (o2.getId().compareToIgnoreCase(o1.getId()));
            }
        });
    }

    @Override
    public void sortBy2Cost_Id(List<Course> list, boolean type)
    {
        Collections.sort(list, new Comparator<Course>() 
        {
            @Override
            public int compare(Course o1, Course o2)
            {
                if(o1.getCost() == o2.getCost())
                {
                    if(type)
                        return o1.getId().compareToIgnoreCase(o2.getId());
                    else
                        return o2.getId().compareToIgnoreCase(o1.getId());
                }
                if(type)
                    return (int)(o1.getCost() - o2.getCost());
                else
                    return (int)(o2.getCost() - o1.getCost());
            }
        });
    }

    @Override
    public void Update(List<Course> list, String id) 
    {
        String s = id.toUpperCase();
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId().equals(s))
            { 
                int min = 1<<31;
                int max = ~min;
                id = checkID(list);
                System.out.print("Enter course name:");
                String name = in.nextLine();
                System.out.print("Enter course credit:");
                int credit = checkInt(min, max);
                System.out.print("Enter available (true or false):");
                boolean available = Boolean.parseBoolean(in.nextLine());
                System.out.print("Enter cost:");
                int cost = checkInt(min, max);
                list.get(i).setId(id);
                list.get(i).setName(name);
                list.get(i).setCredit(credit);
                list.get(i).setAvailable(available);
                list.get(i).setCost(cost);
            }
        }
    }
    
    void report(HashMap<String, Integer> hashMap, Course course)
    {
//        for(int i = 0; i< list.size(); i++)
//        {
//            System.out.println(hashMap.containsKey(list.get(i)));
//            if(hashMap.containsKey(list.get(i)))
//            {
//                hashMap.put(list.get(i), hashMap.get(list.get(i)) + 1);
//            }
//            else
//                hashMap.put(list.get(i), 1);
//        } 
           if(hashMap.containsKey(course.toString()))
            {
                hashMap.put(course.toString(), hashMap.get(course.toString()) + 1);
            }
            else
                hashMap.put(course.toString(), 1);
    }
}
