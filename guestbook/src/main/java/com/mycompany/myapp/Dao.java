package com.mycompany.myapp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Dao {
	SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public List<page> selectList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectList("com.mycompany.myapp.Dao.selectList");
		} finally{
			sqlSession.close();
		}
	}
	public int insertPage(page P) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			int count = sqlSession.insert("com.mycompany.myapp.Dao.insertPage", P);
			sqlSession.commit();
			return count;
		} finally{
			sqlSession.close();
		}
	}
	public page selectPage(int no) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectOne("com.mycompany.myapp.Dao.selectPage", no);
		} finally {
			sqlSession.close();
		}
	}
	public int updatePage(page P) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			int count = sqlSession.update("com.mycompany.myapp.Dao.updatePage", P);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
}
