package test.board;

public class UploadBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("UploadBoardServiceImpl insert");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("UploadBoardServiceImpl update");
		return true;
	}

	@Override
	public Board selectBno(int bno) {
		System.out.println("UploadBoardServiceImpl selectBno");
		return null;
	}

}
