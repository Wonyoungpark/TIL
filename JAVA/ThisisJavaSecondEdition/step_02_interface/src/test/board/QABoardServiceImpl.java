package test.board;

//QA Buisness logic 담당
public class QABoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("QABoardServiceImpl insert");
		return 0;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("QABoardServiceImpl update");
		return false;
	}

	@Override
	public Board selectBno(int bno) {
		System.out.println("QABoardServiceImpl selectbno");
		return null;
	}

}
