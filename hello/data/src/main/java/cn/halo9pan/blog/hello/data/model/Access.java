/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 panhao
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
package cn.halo9pan.blog.hello.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author panhao
 *
 */
@Entity
@Table(name = "access")
public class Access {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
    @ManyToOne
    @JoinColumn(name="guest_id", insertable=false, updatable=false, nullable=false)
	private Guest guest;

	@Column(name = "browser")
	private Browser browser;

	@Column(name = "remote")
	private String remote;

	@Column(name = "time")
	private Date time;

	public long getId() {
		return id;
	}
	
    public Guest getGuest(){
		return guest;
	}

	@Enumerated(EnumType.ORDINAL)
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

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	public void setRemote(String remote) {
		this.remote = remote;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public static enum Browser {
		IE, Firefox, Chrome, Safari, Opera
	}
}
