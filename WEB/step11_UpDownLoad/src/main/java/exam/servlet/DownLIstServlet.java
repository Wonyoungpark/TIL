package exam.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/downList")
public class DownLIstServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //save폴더에 있는 파일의 정보를 가져와서 저장한후 뷰쪽으로 이동한다.

        String saveDir = request.getServletContext().getRealPath("/save");

        File file = new File(saveDir);
        if (file.exists()) {//존재한다면...
            String[] fileNames = file.list();
            request.setAttribute("fileNames", fileNames);//뷰에서 ${fileNames}
        }

        //이동
        request.getRequestDispatcher("downList.jsp").forward(request, response);
    }

}
