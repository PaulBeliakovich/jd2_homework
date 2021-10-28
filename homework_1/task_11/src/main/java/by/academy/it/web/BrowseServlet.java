package by.academy.it.web;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "browseServlet", urlPatterns = "/browser")
public class BrowseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter out = resp.getWriter();
            UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
            Browser browser = userAgent.getBrowser();
            String browserName = browser.getName();

            out.println("<html lang=ru><center><meta charset=UTF-8 /><h1>Приветсвую пользователя "
                    + browserName
                    + "</h1></center></html>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}