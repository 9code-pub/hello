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
package cn.halo9pan.blog.hello.core;

import java.util.Date;

import cn.halo9pan.blog.hello.core.feature.Browser;

/**
 * @author panhao
 *
 */
public class Click {

	private long id;
	
	private Guest guest;
	private Vocabulary vocabulary;
	private Browser browser;
	private String remote;
	private Date time;

	public long getId() {
		return id;
	}
	
    public Guest getGuest(){
		return guest;
	}

	public Vocabulary getVocabulary() {
		return vocabulary;
	}

	public Browser getBrowser() {
		return browser;
	}

	public String getRemote() {
		return remote;
	}

	public Date getTime() {
		return time;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	public void setRemote(String remote) {
		this.remote = remote;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
