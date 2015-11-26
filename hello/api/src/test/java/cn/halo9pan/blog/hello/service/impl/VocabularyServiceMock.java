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
package cn.halo9pan.blog.hello.service.impl;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import cn.halo9pan.blog.hello.core.Vocabulary;
import cn.halo9pan.blog.hello.data.IVocabularyManager;

/**
 * @author panhao
 *
 */
@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(locations = "classpath:spring-business.xml")
public class VocabularyServiceMock {

	@Mock
    private IVocabularyManager repository;
	
	@InjectMocks
    private VocabularyService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.service.impl.VocabularyService#getAllVocabularies()}.
	 */
	@Test
	public void testGetAllVocabularies() {
		List<String> origin = Arrays.asList("One", "Two");
		List<Vocabulary> list = origin.stream().map(word -> new Vocabulary(word)).collect(Collectors.toList());
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.service.impl.VocabularyService#getVocabulary(java.lang.String)}.
	 */
	@Test
	public void testGetVocabulary() {
		when(repository.retrieve(anyString())).thenReturn(new Vocabulary(""));

        assertEquals(service.getVocabulary("Hello").getWord(), "");
        assertThat(service.getVocabulary("Hello"), is(new Vocabulary("")));
        verify(repository, times(2)).retrieve(anyString());
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.service.impl.VocabularyService#searchVocabularies(java.lang.String)}.
	 */
	@Test
	public void testSearchVocabularies() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.service.impl.VocabularyService#addVocabulary(cn.halo9pan.blog.hello.core.Vocabulary)}.
	 */
	@Test
	public void testAddVocabulary() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.halo9pan.blog.hello.service.impl.VocabularyService#removeVocabulary(cn.halo9pan.blog.hello.core.Vocabulary)}.
	 */
	@Test
	public void testRemoveVocabulary() {
		fail("Not yet implemented");
	}

}
