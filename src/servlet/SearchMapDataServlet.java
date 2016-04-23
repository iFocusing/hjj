package servlet;

import net.sf.json.JSONObject;
import service.DataService;
import service.LineService;
import service.PoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huojingjing on 16/4/23.
 */
@WebServlet(name = "SearchMapDataServlet" ,urlPatterns = {"/servlet/SearchMapDataServlet"})
public class SearchMapDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double longitude= Double.valueOf(request.getParameter("longitude"));
        Double latitude= Double.valueOf(request.getParameter("latitude"));
        DataService dataService=new DataService();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("rows",dataService.searchData(longitude,latitude));
            jsonObject.put("total",dataService.searchData(longitude,latitude).size());
            System.out.println(jsonObject);
            PrintWriter out = response.getWriter();
            out.write(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
