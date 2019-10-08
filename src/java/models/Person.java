/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 657306
 */
public class Person
{
    // attributes
    private String name;
    private int age;
    
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    
    public Person(String line)
    {
        String[] attr = line.split(",");
        
        name = attr[0];
        age = Integer.parseInt(attr[1]);
    }

    
    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    
    public String toString()
    {
        return name+","+age+"\n";
    }
}
