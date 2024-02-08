package mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;


import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 * : 싱글톤 클래스로 생성 (private 생성자, 자기자신 멤버에서 생성, 현재 객체를 리턴하는 static 메소드 제공)
 */

public class ElectronicsServiceImpl implements ElectronicsService {

	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() { //싱글톤 클래스
		ResourceBundle rb = ResourceBundle.getBundle("mvc/service/InitInfo");
		for(String key:rb.keySet()){
			String value = rb.getString(key);
//			System.out.println(key+"="+value);
			String v [] = value.split(",");
			list.add(new Electronics(Integer.parseInt(v[0]),v[1],Integer.parseInt(v[2]),v[3]));
		}
//		System.out.println(list);
    }

	public static ElectronicsService getInstance(){
		return instance;
	}

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException {
		if(list.size()>MAX_SIZE) throw new ElectronicsArrayBoundsException("배열의 길이를 벗어나 더이상 등록 할수 없습니다.");
		for(Electronics e:list){
			if(e.getModelNo()==electronics.getModelNo()) throw new ElectronicsArrayBoundsException("모델 번호가 중복이므로 등록할 수 없습니다.");
		}
		list.add(electronics);
	}

	@Override
	public List<Electronics> selectAll() {
		return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for(Electronics e:list){
			if(e.getModelNo()==modelNo) return e;
		}
		throw new SearchNotFoundException(modelNo+"는 없는 모델번호로 검색할수 없습니다.");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		Electronics e = this.searchByModelNo(electronics.getModelNo());
		if(e == null) throw new SearchNotFoundException("해당 모델이 없습니다.");
		else e.setModelDetail(electronics.getModelDetail());
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		Electronics e = this.searchByModelNo(modelNo);
		if(e==null) throw new SearchNotFoundException("해당 모델이 없습니다.");
		else list.remove(e);
	}

	@Override
	public List<Electronics> selectSortByPrice() {
		List<Electronics> elist = new ArrayList<>(list);
		Collections.sort(elist);
		return elist;
	}
    
} // 클래스 끝 