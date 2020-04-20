/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursemanagementsystempar2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author SHINIGAMI99
 */
public class Main 
{
    void MenuSearch(List<Course> list, String id, boolean available, String name, int c)
    {
        Scanner in = new Scanner(System.in);
        MyCMS cms = new MyCMS();
        Menu menu = new Menu();
        boolean check = true;
        do
        {
            menu.MenuSearchDisplay();
            int choice = cms.checkInt(0, 2);
            switch(choice)
            {
                case 1:
                {
                    
                    break;
                }
                case 2:
                {
                    if(c == 1)
                    {
                        for(Course i : cms.SearchReturnObject(list, id))
                        {
                            System.out.println(i.Display());
                        }      
                    }         
                    if(c == 2)
                    {
                        for(Course i : cms.SearchReturnObject(list, available))
                        {
                            System.out.println(i.Display());
                        }   
                    }
                    if(c == 3)
                    {
                        for(Course i : cms.SearchReturnObjectByName(list, name))
                        {
                            System.out.println(i.Display());
                        } 
                    }
                    break;
                }
                case 0:
                {
                    check = false;
                    break;
                }
                default:
                {
                    break;
                }
            }  
        }while(check);
    }
    
    public static void main(String[] args) 
    {
        System.out.println("DESIGN BY DO THANH DAT - HE130593");
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        Menu menu = new Menu();
        MyCMS cms = new MyCMS();
        Display display = new Display();
        workshopdothanhdat.HandlingFile fl = new workshopdothanhdat.HandlingFile();
        String fileName = "Course.txt";
        String id = null;
        String name = null;
        int credit = 0;
        boolean available = false;
        double cost;
        boolean checkOut = true;
        do
        {
            menu.MenuMain();
            int choice = cms.checkInt(0, 8);
            switch(choice)
            {
                case 1:
                {
                    List<Course> list = new ArrayList();
                    cms.add(list);
                    for(int i = 0; i < list.size(); i++)
                    {
                        fl.writeFile(fileName, list.get(i).toString(), true);
                    }
                    break;
                }
                case 2:
                {
                    List<Course> listOut = new ArrayList<>();
                    listOut = fl.readFileList(fileName);
                    display.DisplayAll(listOut);
                    break;
                }
                case 3:
                {
                    List<Course> listOut = new ArrayList<>();
                    listOut = fl.readFileList(fileName);
                    for (Course course : listOut)
                    {
                        System.out.println(course.Display());
                    }
                    boolean check = true;
                    do
                    {
                        menu.MenuSearchBy();
                        choice = cms.checkInt(0, 3);
                        switch(choice)
                        {
                            case 1:
                            {
                                System.out.print("Enter id need search:");
                                id = in.nextLine();
                                if(!cms.isCourse(listOut, id))
                                    System.out.println("Not exsited");
                                else
                                    main.MenuSearch(listOut, id, available, name, 1);
                                break;
                            }
                            case 2:
                            {
                                System.out.print("Enter alivable need search:");
                                available = Boolean.parseBoolean(in.nextLine());
                                main.MenuSearch(listOut, id, available, name, 2);
                                break;
                            }
                            case 3: 
                            {
                                System.out.print("Enter name need search:");
                                name = in.nextLine();
                                if(!cms.isCourseName(listOut, name))
                                    System.out.println("Not exsited");
                                else
                                    main.MenuSearch(listOut, id, available, name, 3);
                                break;
                            }
                            case 0:
                            {
                                check = false;
                                break;
                            }
                            default:
                            {
                                break;
                            }
                        }
                    }while(check);
                    break;
                }
                case 4:
                {
                    List<Course> listOut = new ArrayList<>();
                    listOut = fl.readFileList(fileName);
                    boolean check = true;
                    do
                    {
                        menu.MenuRemove();
                        choice = cms.checkInt(0, 2);
                        switch(choice)
                        {
                            case 1:
                            {
                                System.out.print("Enter id need remove:");
                                id = in.nextLine();
                                if(!cms.isCourse(listOut, id))
                                    System.out.println("Not exsited");
                                else
                                    cms.remove(listOut, id);
                                break;
                            }
                            case 2:
                            {
                                System.out.print("Enter name need remove:");
                                name = in.nextLine();
                                if(!cms.isCourseName(listOut, name))
                                    System.out.println("Not exsited");
                                else
                                    cms.removeName(listOut, name);
                                break;
                            }
                            case 0:
                            {
                                check = false;
                                break;
                            }
                            default:
                            {
                                break;
                            }
                        }
                    }while(check);
                    fl.writeFile(fileName, listOut.get(0).toString(), false);
                    for(int i = 1; i < listOut.size(); i++)
                    {
                        fl.writeFile(fileName, listOut.get(i).toString(), true);
                    }
                    break;
                }
                case 5:
                {
                    List<Course> listOut = new ArrayList<>();
                    listOut = fl.readFileList(fileName);
                    boolean check = true;
                    do
                    {
                        menu.MenuSortBy();
                        choice = cms.checkInt(0, 4);
                        switch(choice)
                        {
                            case 1:
                            {
                                do
                                {
                                    menu.MenuSort();
                                    choice = cms.checkInt(0, 2);
                                    boolean type = choice == 1 ? true : false;
                                    cms.SortByCredit(listOut, type);
                                    display.DisplayAll(listOut);
                                }while(choice != 0);
                                break;
                            }
                            case 2:
                            {
                                do
                                {
                                    menu.MenuSort();
                                    choice = cms.checkInt(0, 2);
                                    boolean type = choice == 1 ? true : false;
                                    cms.SortByName(listOut, type);
                                    display.DisplayAll(listOut);
                                }while(choice != 0);
                                break;
                            }
                            case 3:
                            {
                                do
                                {
                                    menu.MenuSort();
                                    choice = cms.checkInt(0, 2);
                                    boolean type = choice == 1 ? true : false;
                                    cms.SortByID(listOut, type);
                                    display.DisplayAll(listOut);
                                }while(choice != 0);
                                break;
                            }
                            case 4:
                            {
                                do
                                {
                                    menu.MenuSort();
                                    choice = cms.checkInt(0, 2);
                                    boolean type = choice == 1 ? true : false;
                                    cms.sortBy2Cost_Id(listOut, type);
                                    display.DisplayAll(listOut);
                                }while(choice != 0);
                                break;
                            }
                            case 0:
                            {
                                check = false;
                                break;
                            }
                            default:
                            {
                                break;
                            }
                        }
                    }while(check);
                    break;
                }
                case 6:
                {
                    boolean check = true;
                    List<Course> listOut = new ArrayList<>();
                    listOut = fl.readFileList(fileName);
                    do
                    {
                        menu.MenuUpdate();
                        choice = cms.checkInt(0, 1);
                        switch(choice)
                        {
                            case 1:
                            {
                                System.out.print("Enter id need update:");
                                id = in.nextLine();
                                if(!cms.isCourse(listOut, id))
                                    System.out.println("Not exsited");
                                else
                                cms.Update(listOut, id);
                                break;
                            }
                            case 0:
                            {
                                check = false;
                                break;
                            }
                            default:
                            {
                                break;
                            }
                        }
                    }while(check);
                    fl.writeFile(fileName, listOut.get(0).toString(), false);
                    for(int i = 1; i < listOut.size(); i++)
                    {
                        fl.writeFile(fileName, listOut.get(i).toString(), true);
                    }
                    break;
                }
                case 7:
                {
                    String fileNameExcel = "result.xls";
                    List<Course> listOut = new ArrayList<>();
                    listOut = fl.readFileList(fileName);
                    fl.checkFileExist(fileName);
                    fl.writeFile(fileNameExcel, listOut.get(0).Display(), false);
                    for(int i = 1; i < listOut.size(); i++)
                    {
                        fl.writeFile(fileNameExcel, listOut.get(i).Display(), true);
                    }
                    break;
                }
                case 8:
                {
                    List<Course> listOut = new ArrayList<>();
                    listOut = fl.readFileList(fileName);
                    listOut.add(new Course("A", "ABC sad", 6, true, 6));
                    listOut.add(new Course("A", "ABC sad", 6, true, 6));
                    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
                    for (Course course : listOut)
                    {
                        cms.report(hashMap, course);
                    }
                    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) 
                    {
                        System.out.println(entry.getKey() + "|" + entry.getValue());
                    }
                    break;
                }
                case 0:
                {
                    checkOut = false;
                    break;
                }
                default:
                {
                    break;
                }
            }
        }while(checkOut);
    }
} 

