
package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Person;

/**
 *
 * @author 657306
 */
@WebServlet(name = "Part2Servlet", urlPatterns = {"/part2"})
public class Part2Servlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        // open up file on server
        InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/list.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        // load data into arraylist
        ArrayList<Person> people = new ArrayList<>();
        String line;
        while ( (line = br.readLine()) != null )
        {
            people.add(new Person(line));
        }
        
        double avg = calcAvgAge(people);
        session.setAttribute("people", people);
        request.setAttribute("avgAge", avg);
        
        br.close();
        isr.close();
        getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        ArrayList<Person> people = (ArrayList<Person>) session.getAttribute("people");
        
        String path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        
        String name = request.getParameter("name");
        try
        {
            int age = Integer.parseInt( request.getParameter("age") );
            Person p = new Person(name, age);
            pw.print(p.toString());
            people.add(p);
        }
        catch (NumberFormatException e)
        {
            // entered age was not a number, no write
        }
        
        request.setAttribute("avgAge", calcAvgAge(people));
        
        pw.close();
        bw.close();
        fw.close();
        getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp")
                .forward(request, response);
    }
    
    private double calcAvgAge(ArrayList<Person> users)
    {
        int totalAge = 0;
        double avgAge;
        
        for (Person user : users)
        {
            totalAge += user.getAge();
        }
        avgAge = ((double)totalAge) / ((double)users.size());
        
        
        return avgAge;
    }
}
