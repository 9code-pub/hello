package cn.halo9pan.blog.hello.data;

import cn.halo9pan.blog.hello.core.Guest;

public interface IGuestManager extends IGuestUpdater, IAllRetriever {

	Guest create();

	void delete(Integer id);

	Guest retrieve(Integer id);

	Guest fetch(Integer id);

}