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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.halo9pan.blog.hello.core.Vocabulary;
import cn.halo9pan.blog.hello.data.IVocabularyManager;
import cn.halo9pan.blog.hello.service.IVocabularyService;

/**
 * @author panhao
 *
 */
@Service
public class VocabularyService implements IVocabularyService {
	
	@Autowired
	private IVocabularyManager repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.halo9pan.blog.hello.service.IVocabularyService#getAllVocabularies()
	 */
	@Override
	public List<Vocabulary> getAllVocabularies() {
		return this.repository.retrieveAll();
	}

	@Override
	public Vocabulary getVocabulary(String word) {
		return this.repository.retrieve(word);
	}

	@Override
	public List<Vocabulary> searchVocabularies(String character) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.halo9pan.blog.hello.service.IVocabularyService#AddVocabulary(cn.halo9pan.blog.hello.core
	 * .Vocabulary)
	 */
	@Override
	public boolean addVocabulary(Vocabulary v) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.halo9pan.blog.hello.service.IVocabularyService#removeVocabulary(cn.halo9pan.blog.hello
	 * .core.Vocabulary)
	 */
	@Override
	public boolean removeVocabulary(Vocabulary v) {
		// TODO Auto-generated method stub
		return false;
	}

}
