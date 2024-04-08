import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import kosta.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

/*
ServletContextListener : 서버가 start/stop될 때 이벤트 처리하는 핸들러
 */
public class BoardListener implements ServletContextListener {
    public BoardListener() {
        System.out.println("BoardListener created");
    }

    // 서버 시작
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("BoardListener contextInitialized call");

        // 게시물 3개 저장
        List<BoardDTO> boardList = new ArrayList<BoardDTO>();
        boardList.add(new BoardDTO(10,"웹프로그래밍","신기하고 재밌어요"));
        boardList.add(new BoardDTO(20,"Spring프레임워크","이미 설계된 구조"));
        boardList.add(new BoardDTO(30,"jQuery란","javaScript 경량의 라이브러리"));

        // 모든 영역에서 사용하도록 application에 저장
        ServletContext application = sce.getServletContext();
        application.setAttribute("boardList",boardList); //모든 뷰(jsp) : ${applicationScope.boardList} & servlet : application.getAttribute("boardList")에서 사용 가능
        System.out.println("boardList = "+boardList);

        //Path 선언
        application.setAttribute("rootPath",application.getContextPath()); // ${rootPath}
    }

    //서버 종료
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("BoardListener contextDestroyed call");
    }
}
