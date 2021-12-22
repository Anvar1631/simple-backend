import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("First app");

        resp
                .getWriter()
                .write(getResponseAsJson());
    }

    protected String getResponseAsJson(){
        var jsonObject = new JsonObject();

        for (var i=0; i<10; i++){
            jsonObject.addProperty("key-"+i, "value " + i);
        }

        return jsonObject.toString();
    }
}
