/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Halo9Pan
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cn.halo9pan.blog.hello.data.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.halo9pan.blog.hello.core.Vocabulary;
import cn.halo9pan.blog.hello.data.IVocabularyManager;

/**
 * @author Halo9Pan
 *
 */
@Repository
public class VocabularyManager implements IVocabularyManager {
	
	private static final Logger logger = LoggerFactory.getLogger(VocabularyManager.class);

	@Autowired
	private SessionFactory sessionFactory;
	private Session usedSession;

	@Override
	@SuppressWarnings("unchecked")
	public List<Vocabulary> retrieveAll() {
		Session session = this.usingSession();
		List<Vocabulary> vocabularies = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			vocabularies = session.createQuery("FROM cn.halo9pan.blog.hello.core.Vocabulary").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.error("Can't retrieve vocabularies.", e);
		}
		return vocabularies;
	}

	@Override
	public Vocabulary retrieve(String word) {
		Session session = this.usingSession();
		Vocabulary vocabulary = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			vocabulary = (Vocabulary)session.createQuery("FROM cn.halo9pan.blog.hello.core.Vocabulary v WHERE v.word = :word")
					.setString("word", word).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.warn("Can't retrieve vocabulary with word [" + word + "].", e);
		}
		return vocabulary;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vocabulary> query(String character) {
		Session session = this.usingSession();
		List<Vocabulary> vocabularies = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			vocabularies = session.createQuery("FROM cn.halo9pan.blog.hello.core.Vocabulary v WHERE v.word LIKE :character")
					.setString("character", character).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.warn("Can't retrieve vocabulary like word [" + character + "].", e);
		}
		return vocabularies;
	}

	private Session usingSession(){
		if(this.usedSession == null){
			this.usedSession = this.sessionFactory.getCurrentSession();
			if(this.usedSession == null){
				this.usedSession = this.sessionFactory.openSession();
			}
		}
		return this.usedSession;
	}
}
