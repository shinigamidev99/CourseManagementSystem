/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopdothanhdat;

import coursemanagementsystempar2.Course;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SHINIGAMI99
 */
public final class HandlingFile
{
    public String readFile(String fileNameInput) throws FileNotFoundException
    { 
        String s = "";
        try
        {
            FileReader fr = new FileReader(fileNameInput);
            int k;
            char c;
            do
            {
                k = fr.read(); 
                if(k == -1) break;
                c = (char)k;
                s += c;
            }while(true);
            fr.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return s;
    }
    
    public void writeFile(String fileNameOutput, String s, boolean check)
    {
        try
        {
            FileWriter fw = new FileWriter(fileNameOutput, check);
            fw.write(s + "\n");
            fw.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    public List<Course> readFileList(String fileNameInput)
    {
        List<Course> list = new ArrayList<>();
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(fileNameInput));
            String st;
            while((st = bf.readLine()) != null)
            {
                String[] cc = st.split(";");
                list.add(new Course(cc[0], cc[1], Integer.parseInt(cc[2]), Boolean.parseBoolean(cc[3]), Double.parseDouble(cc[4])));
            }
            bf.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return list;
    }
    
    public void checkFileExist(String fileName)
    {
        File file = new File(fileName);
        if(!file.exists())
        {
            try 
            {
                file.createNewFile();
            } 
            catch (IOException ex) 
            {
                System.out.println(ex);
            }
        }
        return;
    }
}
