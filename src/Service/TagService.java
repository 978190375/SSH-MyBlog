package Service;

import java.util.Iterator;
import java.util.List;

import DAO.ArticleTagDaoInterface;
import DAO.TagDaoInterface;
import Pojo.Tag;

public class TagService {
	TagDaoInterface td;
	ArticleTagDaoInterface atd;
	Tag t;
	public String getTagByInput(String input_value) {
		String returnMes="[{\"result\":\"success\"},";
		String errorMes="[{\"result\":\"error\"}]";
		List tags=td.getTagByInput(input_value);
		System.out.println(tags.size());
		if(tags.size()>0)
		{
			Iterator it=tags.iterator();
			while(it.hasNext())
			{
				Tag t=(Tag) it.next();
				returnMes+="{\"tag_id\":"+t.getId()+",\"tag_value\":"+"\""+t.getTag()+"\"},";
			}
				
			returnMes=returnMes.substring(0, returnMes.length()-1)+"]";
			return returnMes;
		}
		else return errorMes;
	}
	public String getTagByJson() {
		String returnMes="[{\"result\":\"success\"},";
		String errorMes="[{\"result\":\"error\"}]";
		List tags=td.getAllTag();
		if(tags!=null&tags.size()>0)
		{
			Iterator it=tags.iterator();
			while(it.hasNext())
			{
				Tag t=(Tag) it.next();
				List ArticleTags=atd.getArticleTagByTagId(t.getId());
				int count=0;
				if(ArticleTags!=null)
					count=ArticleTags.size();
				returnMes+="{\"tag_id\":"+t.getId()
				+",\"tag_value\":\""+t.getTag()
				+"\",\"tag_num\":"+count+"},";
			}
				
			returnMes=returnMes.substring(0, returnMes.length()-1)+"]";
			return returnMes;
		}
		else return errorMes;
	}
	public String addTag(String input_value) {
		String returnMes="[{\"result\":\"success\"}]";
		String errorMes="[{\"result\":\"error\"}]";
		if(td.getTagByTagKey(input_value))
			return errorMes;
		else {
			t.setTag(input_value);
			td.saveTag(t);
			return returnMes;
		}
	}
	public void deleteTag(int tag_id) {
		td.deleteTag(td.getTagById(tag_id));
	}
	public String updateTag(int tag_id,String tag_value) {
		t=td.getTagById(tag_id);
		t.setTag(tag_value);
		td.updateTag(t);
		String returnMes="[{\"result\":\"success\"}]";
		return returnMes;
	}
	public TagDaoInterface getTd() {
		return td;
	}
	public void setTd(TagDaoInterface td) {
		this.td = td;
	}
	public ArticleTagDaoInterface getAtd() {
		return atd;
	}
	public void setAtd(ArticleTagDaoInterface atd) {
		this.atd = atd;
	}
	public Tag getT() {
		return t;
	}
	public void setT(Tag t) {
		this.t = t;
	}
	
	
}
