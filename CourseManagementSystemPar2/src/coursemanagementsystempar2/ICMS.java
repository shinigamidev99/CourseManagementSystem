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
public interface ICMS 
{ 
    public int checkInt(int min,  int max);
    public String checkID(List<Course> list);
    public boolean isCourse(List<Course> list, String id);
    public boolean isCourseName(List<Course> list, String name);
    public boolean add(List<Course> list);
    public int[] SearchReturnIndex(List<Course> list, String id);
    public List<Course> SearchReturnObject(List<Course> list, String id);
    public List<Course> SearchReturnObject(List<Course> list, boolean alivable);
    public List<Course> SearchReturnObjectByName(List<Course> list, String name);
    public void remove(List<Course> list, String id);
    public void removeName(List<Course> list, String name);
    public void SortByCredit(List<Course> list, boolean type);
    public void SortByName(List<Course> list, boolean type);
    public void SortByID(List<Course> list, boolean type);
    public void sortBy2Cost_Id(List<Course> list, boolean type);
    public void Update(List<Course> list, String id);
}
