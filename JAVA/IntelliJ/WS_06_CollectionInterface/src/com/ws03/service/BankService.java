package com.ws03.service;

import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;

import java.util.List;

public interface BankService {
    List<AccountDto> getAccountList(int userSeq);
    UserDto getUserDetail(int userSeq);
    List<AccountDto> getAccountList();
    List<AccountDto> getAccountListSortByBalance();
    List<AccountDto> getAccountListSortByUserSeq();

}
