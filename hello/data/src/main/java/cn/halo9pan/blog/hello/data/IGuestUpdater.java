package cn.halo9pan.blog.hello.data;

import cn.halo9pan.blog.hello.core.Click;

public interface IGuestUpdater {

	void updateName(Integer id, String nickName);

	void increaseClick(Integer id, Click click);

}