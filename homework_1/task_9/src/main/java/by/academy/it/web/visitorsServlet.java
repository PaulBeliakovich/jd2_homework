package by.academy.it.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;


public class visitorsServlet extends HttpServlet {
    private String path;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter out = resp.getWriter();
            path = getServletContext().getInitParameter("log");
            int count;
            if (readCount() != null) {
                count = Integer.parseInt(readCount());
            } else {
                count = 0;
            }
            count++;
            writeCount(count);

            out.println("<html><center><h1>Count = " + count + "</h1></center></html>");
        } catch (IOException  e) {
            e.printStackTrace();
        }

    }

    private String readCount() {
        String count = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
            count = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void writeCount(int count) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(path)));
            writer.write(count);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
