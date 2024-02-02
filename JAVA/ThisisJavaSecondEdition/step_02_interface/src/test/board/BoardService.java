package test.board;

//모든 게시판의 공통 메소드 정의 (규격서)

public interface BoardService {
	//등록하기
	int insert(Board board); // QABoard/UploadBoard/FreeBoard 모두 가능
	
	//수정하기
	boolean update(Board board);
	
	//글번호로 게시물 조회하기
	Board selectBno(int bno);

	//답변 기능 메소드 추가
	default void replyInsert(){ //제한자 정의가 없으면 자동 public
		System.out.println("BoardService replyInsert()");
	}

    static void selectAll() {
		System.out.println("BoardService selectAll()");
    }
}
