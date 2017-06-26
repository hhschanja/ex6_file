package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;

@Repository
public class MemoDAO {

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "MemoMapper.";
	
	
	//list
	public List<MemoDTO> list(ListInfo listInfo){
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
		
	}
	
	//view
	public MemoDTO view(int num){
	
		return sqlSession.selectOne(NAMESPACE+"view", num);
	}
	
	//write
	public int write(MemoDTO memoDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"write", memoDTO);
	}
	
	//update
	public int update(MemoDTO memoDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"update", memoDTO);
	}
	
	//delete
	public int delete(int num){
		return sqlSession.delete(NAMESPACE+"delete", num);
	}
	
	//count 
	public int count(ListInfo listInfo){
		return sqlSession.selectOne(NAMESPACE+"count",listInfo);
	}
	
	
	
	
	
	
}
