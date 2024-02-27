package db.dao;

import db.util.DbManager;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO {
  /**
   * 계좌이체 기능 구현
   * */
	public void transfer(String inputAccount, String outputAccount, int money) {
		//로드
		Connection con=null;
		try{
			con = DbManager.getConnection();
			con.setAutoCommit(false); //자동 커밋 해지

			//출금
			int result = this.withdraw(con,outputAccount,money);
			if(result==0) throw new SQLException("출금 계좌번호 오류");

			//출금이 정상이면 입금
			result = this.deposit(con,inputAccount,money);
			if(result==0) throw new SQLException("입금 계좌번호 오류");

			//입금이 정상이면 잔액 확인
			if(!this.ischeckBalance(con,inputAccount))
				throw new SQLException("잔액이 1000원이 초과하여 계좌 이체를 할 수 없습니다.");
			//만약 여기서 rollback된다면, 출금과 입금 모두 롤백된다.

			//잔액 확인이 정상이면 commit
			con.commit();
			System.out.println("계좌이체 성공");

		}catch (SQLException e){
//			e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
			System.out.println(e.getMessage()); //'출금 계좌 오류' 메시지 출력
        }finally {
			DbManager.dbClose(con,null);
		}
		//연결
		//실행(update 2번, select)
		//닫기
	}

	//출금하기
	// update bank set balance=balance-? where account = ?;
	public int withdraw(Connection con, String outputAccount,int money) throws SQLException {
		String sql = "update bank set balance=balance-? where account = ?";
		PreparedStatement ps=null;
		int result = 0;

		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1,money);
			ps.setString(2,outputAccount);
			result = ps.executeUpdate(); //실행 후 결과 리턴
		}finally { //finally에서 닫아야 해서 try문 사용
			DbManager.dbClose(null,ps); //Connection이 유지되어야 하기 때문에 ps만 닫는다. //con은 transfer에서 닫는다.
		}
		System.out.println("출금 완료");
		return result;
	}

	//입금하기
	// update bank set balance=balance+인출금액 where account =입금계좌번호;
	public int deposit(Connection con, String inputAccount,int money) throws SQLException {
		String sql = "update bank set balance=balance+? where account =?";
		PreparedStatement ps = null;
		int result = 0;

		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1,money);
			ps.setString(2,inputAccount);
			result = ps.executeUpdate();
		}finally {
			DbManager.dbClose(null,ps);
		}
		System.out.println("입금 완료");
		return result;
	}

	//잔액 확인
	// select balance from bank where account=?;
	// @return : true이면 정상, false이면 잔액이 1000 초과
	public boolean ischeckBalance(Connection con, String inputAccount) throws SQLException {
		String sql = "select balance from bank where account=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1,inputAccount);
			rs = ps.executeQuery();

			if(rs.next())
				if(rs.getInt(1)<=1000) return true;
		}finally {
			DbManager.dbClose(null,ps,rs);
		}
		System.out.println("잔액 조회 완료");
		return result;
	}

	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		System.out.println("--1. 출금계좌 오류----");
		//dao.transfer("A02", "A05",200);//입금, 출금, 금액
		
		System.out.println("--2. 입금계좌 오류----");
		//dao.transfer("A04", "A01",200);//입금, 출금, 금액
		
		
		System.out.println("--3. 입금계좌의 총액 1000원 이상인경우----");
		//dao.transfer("A02", "A01",700);//입금, 출금, 금액
		
		System.out.println("--4. 성공----------");
		dao.transfer("A02", "A01",100);//입금, 출금, 금액
	}
}










