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
package cn.halo9pan.blog.hello.service;

import java.util.List;

import cn.halo9pan.blog.hello.core.Vocabulary;

/**
 * @author panhao
 *
 */
public interface IVocabularyService {

	/**
	 * @return
	 */
	List<Vocabulary> getAllVocabularies();

	/**
	 * @param word
	 * @return
	 */
	Vocabulary getVocabulary(String word);

	/**
	 * @param character
	 * @return
	 */
	List<Vocabulary> searchVocabularies(String character);

	/**
	 * @param v
	 * @return
	 */
	boolean addVocabulary(Vocabulary v);

	/**
	 * @param v
	 * @return
	 */
	boolean removeVocabulary(Vocabulary v);

}
