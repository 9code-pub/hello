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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.halo9pan.blog.hello.core.Vocabulary;
import cn.halo9pan.blog.hello.data.IVocabularyManager;

/**
 * @author panhao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-data-hibernate.xml")
public class VocabularyManagerTest {
	
	@Autowired
	IVocabularyManager manager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.data.hibernate.VocabularyManager#retrieveAll()}
	 * .
	 */
	@Test
	public void testRetrieveAll() {
		List<Vocabulary> list = manager.retrieveAll();
		assertNotNull(list);
		assertNotEquals(0, list.size());
	}

	/**
	 * Test method for
	 * {@link cn.halo9pan.blog.hello.data.hibernate.VocabularyManager#retrieve(java.lang.Long)}.
	 */
	@Test
	public void testRetrieveLong() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link cn.halo9pan.blog.hello.data.hibernate.VocabularyManager#retrieve(java.lang.String)}.
	 */
	@Test
	public void testRetrieveString() {
		fail("Not yet implemented");
	}

}
