import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kosta.dto.BoardDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/board",loadOnStartup = 1)
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<BoardDTO> boardList;

    public BoardServlet() {
        System.out.println("Board Servlet constructor called");
    }

    //게시물 3개 초기화해서 ServletContext 영역에 저장
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("BoardServlet init call");

        ServletContext application = config.getServletContext();
        boardList = (List<BoardDTO>)application.getAttribute("boardList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String no = req.getParameter("no");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");

        BoardDTO boardDTO = new BoardDTO(Integer.parseInt(no), subject, content);
        boardList.add(boardDTO);

        resp.sendRedirect("center");
    }
}
