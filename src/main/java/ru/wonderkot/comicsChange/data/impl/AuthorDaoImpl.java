/**
 * 
 */
package ru.wonderkot.comicsChange.data.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ru.wonderkot.comicsChange.data.AuthorDao;
import ru.wonderkot.comicsChange.model.Author;
import ru.wonderkot.comicsChange.utils.MyBatisUtil;

/**
 * @author Wonderkot
 *
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.wonderkot.comicsChange.data.AuthorDao#addNewAuthor(ru.wonderkot.
	 * comicsChange.model.Author)
	 */
	@Override
	public void addNewAuthor(Author author) {
		System.out.println(author.getName());
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(
				true);
		try {
			AuthorDao authorDao = sqlSession.getMapper(AuthorDao.class);
			authorDao.addNewAuthor(author);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.wonderkot.comicsChange.data.AuthorDao#deleteAuthor(ru.wonderkot.
	 * comicsChange.model.Author)
	 */
	@Override
	public void deleteAuthor(Author author) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(
				true);
		try {
			AuthorDao authorDao = sqlSession.getMapper(AuthorDao.class);
			authorDao.deleteAuthor(author);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ru.wonderkot.comicsChange.data.AuthorDao#findAuthor(ru.wonderkot.comicsChange
	 * .model.Author)
	 */
	@Override
	public ArrayList<Author> findAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.wonderkot.comicsChange.data.AuthorDao#getAllAuthors()
	 */
	@Override
	public ArrayList<Author> getAllAuthors() {
		ArrayList<Author> authors = new ArrayList<Author>();
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			AuthorDao authorDao = sqlSession.getMapper(AuthorDao.class);
			authors = authorDao.getAllAuthors();
		} finally {
			sqlSession.close();
		}
		return authors;
	}

	@Override
	public void updateAuthor(Author author) {
		if (author == null) {
			return;
		}

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(
				true);
		try {
			AuthorDao authorDao = sqlSession.getMapper(AuthorDao.class);
			authorDao.updateAuthor(author);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

}
