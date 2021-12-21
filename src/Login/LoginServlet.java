package Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pc on 12/21/2021.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    response.setContentType("text/html");

    //taking username and password from the user
    String uname = request.getParameter("username");
    String password = request.getParameter("password");

    //checking if the password and username is correctly matched
    if(uname.equals("shreejwalkaphle@gmail.com") && password.equals("java")){

        //set a cookie and add it to response
        Cookie cookie = new Cookie("cookieName",uname);

        response.addCookie(cookie);

        //forwarding the response to the dash servlet
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("dash");
        requestDispatcher.forward(request,response);
    }
    else {
        //displaying the login incalid credentials
        PrintWriter printWriter = response.getWriter();
        printWriter.println("incorrect login details");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
        requestDispatcher.include(request,response);
    }

    }
}
