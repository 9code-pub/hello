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

import java.util.List;


/**
 * @author panhao
 *
 */
public class Guest {

	private int id;

	private String nickName;
	private int visitTime;
	private Feature feature;
	private List<Access> access;

	public int getId() {
		return id;
	}

	public String getNickName() {
		return nickName;
	}

	public int getVisitTime() {
		return visitTime;
	}

	public Feature getFeature() {
		return feature;
	}

	public List<Access> getAccess() {
		return access;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setVisitTime(int visitTime) {
		this.visitTime = visitTime;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public void setAccess(List<Access> access) {
		this.access = access;
	}

}
