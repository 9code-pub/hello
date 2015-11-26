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

import cn.halo9pan.blog.hello.core.Click;
import cn.halo9pan.blog.hello.core.Guest;
import cn.halo9pan.blog.hello.data.IGuestManager;

/**
 * @author Halo9Pan
 *
 */
public class GuestManager implements IGuestManager {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestManager.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	/* (non-Javadoc)
	 * @see cn.halo9pan.blog.hello.data.hibernate.IGuestManager#create()
	 */
	@Override
	public Guest create() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Guest guest = null;
		try {
			tx = session.beginTransaction();
			guest = new Guest();
			session.save(guest);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.error("Can't create guest.", e);
		} finally {
			session.close();
		}
		return guest;
	}

	/* (non-Javadoc)
	 * @see cn.halo9pan.blog.hello.data.hibernate.IGuestManager#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Guest guest = (Guest) session.get(Guest.class, id);
			session.delete(guest);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.error("Can't remove guest.", e);
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see cn.halo9pan.blog.hello.data.hibernate.IGuestManager#retrieveAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Guest> retrieveAll() {
		Session session = sessionFactory.openSession();
		List<Guest> guests = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			guests = session.createQuery("FROM cn.halo9pan.blog.hello.core.Guest").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.error("Can't retrieve guests.", e);
		} finally {
			session.close();
		}
		return guests;
	}

	/* (non-Javadoc)
	 * @see cn.halo9pan.blog.hello.data.hibernate.IGuestManager#retrieve(java.lang.Integer)
	 */
	@Override
	public Guest retrieve(Integer id) {
		Session session = sessionFactory.openSession();
		Guest guest = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			guest = (Guest)session.load(Guest.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.error("Can't retrieve guests.", e);
		}
		return guest;
	}

	/* (non-Javadoc)
	 * @see cn.halo9pan.blog.hello.data.hibernate.IGuestManager#fetch(java.lang.Integer)
	 */
	@Override
	public Guest fetch(Integer id) {
		Session session = sessionFactory.openSession();
		Guest guest = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			guest = (Guest)session.get(Guest.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.error("Can't retrieve guests.", e);
		}
		return guest;
	}

	/* (non-Javadoc)
	 * @see cn.halo9pan.blog.hello.data.hibernate.IGuestManager#updateName(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void updateName(Integer id, String nickName) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Guest guest = (Guest) session.get(Guest.class, id);
			guest.setNickName(nickName);
			session.update(guest);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			logger.error("Can't update guest.", e);
			session.close();
		}
	}

	@Override
	public void increaseClick(Integer id, Click click) {
		// TODO Auto-generated method stub
		
	}
}
