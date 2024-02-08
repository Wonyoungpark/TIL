package com.ws03.service;
/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

import com.ws03.dto.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BankServiceImpl implements BankService{
	List<UserDto> userList;
	List<AccountDto> accountList;
	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
	 * */
	public BankServiceImpl() {

		userList = new ArrayList<UserDto>();
	 	accountList = new ArrayList<AccountDto>();

		userList.add( new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false) );
		userList.add( new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true) );
		userList.add( new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false) );

		accountList.add( new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000) );

		accountList.add( new SavingAccountDto(10, "00100101001001", 500, 111, 100) );

		accountList.add( new LoanAccountDto(60, "00600606006006", 500, 333, "House") );
		accountList.add( new LoanAccountDto(30, "00300303003003", 0, 111, "Building") );

		accountList.add( new SavingAccountDto(70, "00700707007007", 500, 333, 200) );

		accountList.add( new LoanAccountDto(50, "00500505005005", 200, 222, "Car") );
		accountList.add( new SavingAccountDto(40, "00400404004004", 1000, 222, 50) );

		System.out.println("---세팅완료!!----");
	}//생성자 끝
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	@Override
	public List<AccountDto> getAccountList(int userSeq) { // 100 200  ...
		List<AccountDto> searchAccountDtoList = new ArrayList<AccountDto>();

		for(AccountDto acDto:accountList) {
			if( acDto.getUserSeq()  == userSeq) searchAccountDtoList.add(acDto);
		}

		return searchAccountDtoList;
	}
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	@Override
	public UserDto getUserDetail(int userSeq) {
		for(UserDto uDto:userList) {
			if(uDto.getUserSeq() == userSeq) return uDto;
		}
		
		return null;
	}

	/**
	 * 신규로, 모든 계좌 목록을 리턴
	 * **/
	@Override
	public List<AccountDto> getAccountList() {
		return accountList;
	}

	/**
	 * 신규로, 잔고 기준으로 정렬한 모든 계좌 목록을 리턴
	 * Comparable Interface 이용
	 * **/
	@Override
	public List<AccountDto> getAccountListSortByBalance() {
		List<AccountDto> sortByBalanceList = new ArrayList<AccountDto>(accountList); //복사

		//AccountDto에 Comparator 정렬
		Collections.sort(sortByBalanceList);
		return sortByBalanceList;
	}

	/**
	 * 신규로, 사용자 일련번호 기준으로 정렬
	 * Comparator Interface 이용
	 * **/
	@Override
	public List<AccountDto> getAccountListSortByUserSeq() {
		List<AccountDto> sortByUserList = new ArrayList<AccountDto>(accountList);//복사
		Collections.sort(sortByUserList, new Comparator<AccountDto>() { //인터페이스 생성이 아닌 익명 구현체
			@Override
			public int compare(AccountDto o1, AccountDto o2) {
				return o2.getUserSeq()-o1.getUserSeq();
			}
		});

		return sortByUserList;
	}
}