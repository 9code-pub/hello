package cn.halo9pan.blog.hello.data;

import java.util.List;

import cn.halo9pan.blog.hello.core.Guest;

public interface IGuestRetriever {

	List<Guest> retrieveAll();

}