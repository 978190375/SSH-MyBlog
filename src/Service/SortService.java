package Service;

import java.util.Iterator;
import java.util.List;

import DAO.ArticleSortDao;
import DAO.SortDaoInterface;
import Pojo.Sort;

public class SortService {
	public SortDaoInterface sd;
	public ArticleSortDao asd;
	Sort s;
	public String getAllSort() {
		List sorts = sd.getAllSort();
		return makeJson(sorts);
	}
	public String addSort(String sort_value) {

		String returnMes = "[{\"result\":\"success\"},";
		String errorMes = "[{\"result\":\"error\"}]";
		if(sd.findSortBySortValue(sort_value)!=null) {
			return errorMes;
		}
		else{
			s.setSort(sort_value);
			sd.saveSort(s);
			returnMes += "{\"sort_id\":" + s.getId() + ",\"sort_sort\":\"" + s.getSort() + "\"}]";
			return returnMes;
		}
	}

	public String getSortByJson() {
		String returnMes = "[{\"result\":\"success\"},";
		String errorMes = "[{\"result\":\"error\"}]";
		List sorts = sd.getAllSort();

		if (sorts!=null&&sorts.size() > 0) {
			Iterator it=sorts.iterator();
			while(it.hasNext()) {
				Sort sort=(Sort)it.next();
				List ArticleSort=asd.getArticleSortBySortId(sort.getId());
				int count=0;
				if(ArticleSort!=null)
					count=ArticleSort.size();
				returnMes += "{\"sort_id\":" + sort.getId() 
				+ ",\"sort_sort\":\"" + sort.getSort() 
				+ "\",\"sort_num\":"+count+"},";
			}
			returnMes=returnMes.substring(0, returnMes.length()-1)+"]";
			return returnMes;
		}
		return errorMes;
	}
	public String makeJson(List sorts) {
		String returnMes = "[{\"result\":\"success\"},";
		String errorMes = "[{\"result\":\"error\"}]";
		
		if (sorts!=null&&sorts.size() > 0) {
			Iterator it = sorts.iterator();
			while (it.hasNext()) {
				Sort ss = (Sort) it.next();
				returnMes += "{\"sort_id\":" + ss.getId() + ",\"sort_sort\":\"" + ss.getSort() + "\"},";
			}
			returnMes=returnMes.substring(0, returnMes.length()-1)+"]";
			return returnMes;
		}
		return errorMes;
	}
	public void deleteSort(int sort_id) {
		sd.deleteSort(sd.getSortById(sort_id));
	}
	/**
	 * 更新Sort
	 * @param sort_id
	 */
	public String updateSort(int sort_id,String sort_value) {
		s=sd.getSortById(sort_id);
		s.setSort(sort_value);
		sd.updateSort(s);
		String returnMes = "[{\"result\":\"success\"}]";
		return returnMes;
	}
	public int getSortCount() {
		return	sd.getSortCount();
	}
	public SortDaoInterface getSd() {
		return sd;
	}

	public void setSd(SortDaoInterface sd) {
		this.sd = sd;
	}
	public Sort getS() {
		return s;
	}
	public void setS(Sort s) {
		this.s = s;
	}
	public ArticleSortDao getAsd() {
		return asd;
	}
	public void setAsd(ArticleSortDao asd) {
		this.asd = asd;
	}

}
