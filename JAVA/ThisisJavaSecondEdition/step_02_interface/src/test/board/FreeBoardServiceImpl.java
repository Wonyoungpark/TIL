package test.board;

//자유게시판에 관련된 buisness logic 담당

public class FreeBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println(super.getClass().getSimpleName()+"insert");
		return 0;
	}

	@Override
	public boolean update(Board board) {
		System.out.println(super.getClass().getSimpleName()+"update");
		return false;
	}

	@Override
	public Board selectBno(int bno) {
		System.out.println(super.getClass().getSimpleName()+"delete");
		return null;
	}

}
