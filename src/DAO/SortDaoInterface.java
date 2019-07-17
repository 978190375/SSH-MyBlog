package DAO;
import java.util.List;

import Pojo.Sort;
public interface SortDaoInterface {
	List getAllSort();
	void saveSort(Sort s);//返回保存后的sort
	void saveSortNoReturn(Sort s);
	void updateSort(Sort s);
	void deleteSort(Sort s);
	/**
	 * 根据sort_id查找sort
	 * @param 分类id
	 * @return 分类
	 */
	Sort getSortById(int id);
	/**
	 * 根据sort关键词查找sort对象，找到返回该对象，否则返回null
	 * @param value
	 * @return 
	 */
	Sort findSortBySortValue(String value);
	/**
	 * 获取分类数目
	 * @return
	 */
	int getSortCount();
	
}
