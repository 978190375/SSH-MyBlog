package DAO;

import java.util.List;

import Pojo.Tag;

public interface TagDaoInterface {
	/**
	 * 模糊查找
	 * @param input_value
	 * @return
	 */
	List getTagByInput(String input_value);
	
	/**
	 * 精确查找
	 * @param tag_key
	 * @return
	 */
	boolean getTagByTagKey(String tag_key);
	/**
	 * 精确查找
	 * @param input_value
	 * @return
	 */
	Tag getTagByTag(String input_value);
	
	/**
	 * 保存Tag对象
	 * @param t
	 */
	void saveTag(Tag t);
	
	/**
	 * Update Tag
	 * @param t
	 */
	void updateTag(Tag t);
	
	void deleteTag(Tag t);
	
	
	/**
	 * 根据tag_id获取tag对象
	 * @param id
	 * @return
	 */
	Tag getTagById(int id);
	
	/**
	 * 获取所有标签
	 * @return
	 */
	List getAllTag();
}
