package Dash;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pc on 12/21/2021.
 */
@WebServlet(name = "DashServlet")
public class DashServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    //getting the cookie that was set at the time of successful login

        Cookie[] cookie = request.getCookies();


        //printing the cookie value in the browser
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Welcome "+cookie[0].getValue());

        //logout option
        printWriter.println("<a href='index.jsp'>logout</a>");
        for (Cookie item:cookie)
        {
            item.setMaxAge(0);
            item.setValue(null);
            response.addCookie(item);
        }
        printWriter.close();
    }
}
