/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 halo9pan.cn
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

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.halo9pan.blog.hello.core.Guest;

/**
 * @author panhao
 *
 */
public class GuestManagerTest extends HibernateTest {
	
	static final Logger logger = LoggerFactory.getLogger(GuestManager.class);

    private GuestManager manager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	      try{
	          this.sessionFactory = configureSessionFactory();
	          this.manager = new GuestManager();
	          this.manager.setSessionFactory(this.sessionFactory);
	       }catch (HibernateException ex) { 
	    	   logger.error("Failed to create sessionFactory object.", ex);
	          throw new ExceptionInInitializerError(ex); 
	       }
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.data.hibernate.GuestManager#create()}.
	 */
	@Test
	public void testCreate() {
		assertNotNull(this.manager.create());
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.data.hibernate.GuestManager#retrieveAll()}.
	 */
	@Test
	public void testRead() {
		List<Guest> list = this.manager.retrieveAll();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.data.hibernate.GuestManager#updateName(java.lang.Integer, java.lang.String)}.
	 */
	@Test
	public void testUpdate() {
		String newName = "Update";
		Guest guest = this.manager.create();
		Integer id = guest.getId();
		this.manager.updateName(id, newName);
		Guest g = this.manager.retrieve(id);
		String name = g.getNickName();
		assertEquals(newName, name);
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.data.hibernate.GuestManager#delete(java.lang.Integer)}.
	 */
	@Test
	public void testDelete() {
		Guest guest = this.manager.create();
		Integer id = guest.getId();
		List<Guest> list = this.manager.retrieveAll();
		int newSize = list.size();
		this.manager.delete(id);
		list = this.manager.retrieveAll();
		assertEquals(newSize - 1, list.size());
	}

}
