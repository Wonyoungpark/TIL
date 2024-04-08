package kosta.dao;

import kosta.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    /*
    전체 검색
    select * from member;
     */
    List<MemberDTO> selectAll();

    /*
    회원 가입 (등록)
    insert into member values(?,?,?,?,date);
     */
    int insert(MemberDTO memberDTO);

    /*
    상세보기(id 기반 회원정보 검색)
    select * from member where id=?;
     */
    MemberDTO getSelectById(String id);

    /*
    id에 해당하는 회원 삭제
    delete from member where id=?
     */
    int delete(String id);

    /*
    id에 해당하는 정보 수정(비밀번호, 나이, 주소, 연락처)
    update member set pwd=?, age=?, addr=?,phone=? where id=?;
     */
    int update(MemberDTO memberDTO);

    /*
    조건 검색(keyField, keyWord)에 해당하는 조건 검색)
    "select * from member where "+ keyField +" like ? ;"
     */
    List<MemberDTO> findByKeyFieldWord(String keyField, String keyWord);
}
