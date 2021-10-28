package by.academy.it.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InfoServlet", urlPatterns = "/info")
public class InfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter out = resp.getWriter();
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String regexForName = "[a-zA-Z]+";
            String regexForPhone = "[0-9]+";
            String regexForEmail = "[^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$]";

            if (((!name.equals("") && name.matches(regexForName)) && (!phone.equals("") && phone.matches(regexForPhone)))
                    || (!email.equals("") && email.matches(regexForEmail))) {
                out.println("Name - " + name);
                out.println("Phone - " + phone);
                out.println("Email - " + email);
            } else {
                out.println("<html><center> Enter correct information </center></html>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}