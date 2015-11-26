package cn.halo9pan.blog.hello.data;

import java.util.List;

import cn.halo9pan.blog.hello.core.Vocabulary;

public interface IVocabularyRetriever {

	/**
	 * TODO
	 * @return
	 */
	List<Vocabulary> retrieveAll();

	/**
	 * TODO
	 * @param word
	 * @return
	 */
	Vocabulary retrieve(String word);

	/**
	 * TODO
	 * @param character
	 * @return
	 */
	List<Vocabulary> query(String character);

}