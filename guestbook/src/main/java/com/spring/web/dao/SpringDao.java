package com.spring.web.dao;
 
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.web.vo.page;
 
@Repository
public class SpringDao {
     
    @Autowired
    private SqlSession sql;
     
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<page> selectList() throws SQLException {
        return (ArrayList)sql.selectList("sql.selectList");
    }
    
    public int insertPage(page P) throws Exception{
		int count = sql.insert("sql.insertPage", P);
		sql.commit();
		return count;
	}
    
	public page selectPage(String no) throws Exception{
		return sql.selectOne("sql.selectPage", no);
	}
    
	public int updatePage(page P) throws Exception{
		int count = sql.update("sql.updatePage", P);
		sql.commit();
		return count;
	}
}