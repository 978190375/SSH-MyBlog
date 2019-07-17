package Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.ArticleDaoInterface;
import DAO.ArticleSortDaoInterface;
import DAO.ArticleTagDaoInterface;
import DAO.SortDaoInterface;
import DAO.TagDaoInterface;
import Pojo.Article;
import Pojo.ArticleSort;
import Pojo.ArticleTag;
import Pojo.Sort;
import Pojo.Tag;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.GetSrc;
import util.IsInteger;

public class ArticleService {
	ArticleDaoInterface ad;
	SortDaoInterface sd;
	ArticleSortDaoInterface asd;
	Article a;
	ArticleSort article_sort;
	Sort s;
	TagDaoInterface td;
	ArticleTagDaoInterface atd;
	ArticleTag article_tag; //文章标签
	Tag t; //标签

	/**
	 * 添加文章
	 * @param title
	 * @param content
	 * @param sort
	 * @param tag
	 * @param image_url
	 * @param summary
	 */
	public void saveArticle(String title, String content, String sort, String tag, String image_url, String summary) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext-bean.xml");

		System.out.println("保存"+"-"+title+"-"+content+"-"+sort+"-"+tag+"-"+image_url+"-"+summary);
		//文章标题
		a.setTitle(title);
		
		//文章作者
		a.setAuthor("admin");
		
		//文章内容
		a.setContent(content);
		
		//文章时间戳
		a.setTime((new Date()).getTime());
		
		//文章摘要
		a.setSummary(summary);
		
		//文章点赞数
		a.setStar(0);
		
		//文章阅读人数
		a.setVisit(0);
		
		//文章特色图片
		a.setImage_url(GetSrc.getSrcByImg(image_url));
		System.out.println(GetSrc.getSrcByImg(image_url));
		//保存文章
		ad.save(a);
		
		//保存sort分类
		String[] sorts=sort.trim().replace(" ","" ).split(",");
		for(int i=0;i<sorts.length;i++) {
			article_sort=(ArticleSort) ctx.getBean("article_sort"); //获取新的文章分类对象
			s=sd.getSortById(Integer.parseInt(sorts[i]));
			article_sort.setSort(s);
			article_sort.setArticle(a);
			asd.saveArticleSort(article_sort);
			a.getArticleSorts().add(article_sort);
			s.getArticleSorts().add(article_sort);
			sd.updateSort(s);

		}
		ad.updateArticle(a);
		//保存标签
		String[] tags=tag.trim().replace(" ","" ).substring(0, tag.length()-1).split(",");
		for(int i=0;i<tags.length;i++) {
			article_tag=(ArticleTag) ctx.getBean("article_tag"); //获取新的文章分类对象
			
			if(IsInteger.isInteger(tags[i])) {
				t=td.getTagById(Integer.parseInt(tags[i]));
				article_tag.setArticle(a);
				article_tag.setTag(t);
				atd.saveArticleTag(article_tag);
				a.getArticleTags().add(article_tag);
				t.getArticleTags().add(article_tag);
				td.updateTag(t);
			}
			else {
				if(td.getTagByTag(tags[i])==null){
					System.out.println("no tag!!!!!");
					t=(Tag) ctx.getBean("tag");
					t.setTag(tags[i]);
					article_tag.setArticle(a);
					article_tag.setTag(t);
					atd.saveArticleTag(article_tag);
					a.getArticleTags().add(article_tag);
					t.getArticleTags().add(article_tag);
					td.saveTag(t);
				}
				else {
					System.out.println("has tag!!!!!");
					t=td.getTagByTag(tags[i]);
					article_tag.setArticle(a);
					article_tag.setTag(t);
					atd.saveArticleTag(article_tag);
					a.getArticleTags().add(article_tag);
					t.getArticleTags().add(article_tag);
					td.updateTag(t);
				}
			}
			
			ad.updateArticle(a);
		}
	}
	public void updateArticle(int article_id,String title, String content, String sort, String tag, String image_url, String summary) {
		System.out.println("更新文章"+article_id+"-"+title+"-"+content+"-"+sort+"-"+tag+"-"+image_url+"-"+summary);
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext-bean.xml");
		a=ad.getArticleByArticleId(article_id);
		//文章标题
		a.setTitle(title);
		
		//文章作者
		a.setAuthor("admin");
		
		//文章内容
		a.setContent(content);
		
		//文章时间戳
		a.setTime((new Date()).getTime());
		
		//文章摘要
		a.setSummary(summary);
		
		//文章点赞数
		a.setStar(0);
		
		//文章阅读人数
		a.setVisit(0);
		
		//文章特色图片
		if(image_url==null)
			a.setImage_url("");
		else {
		a.setImage_url(image_url);
		}
		//更新文章
		ad.updateArticle(a);
		
		//删除原来的
		Iterator article_sort_it=a.getArticleSorts().iterator();
		while(article_sort_it.hasNext()) {
			asd.deleteArticleSort((ArticleSort)article_sort_it.next());
		}
		//保存新sort分类
		String[] sorts=sort.trim().replace(" ","" ).split(",");
		for(int i=0;i<sorts.length;i++) {
			article_sort=(ArticleSort) ctx.getBean("article_sort"); //获取新的文章分类对象
			s=sd.getSortById(Integer.parseInt(sorts[i]));
			article_sort.setSort(s);
			article_sort.setArticle(a);
			asd.saveArticleSort(article_sort);
			a.getArticleSorts().add(article_sort);
			s.getArticleSorts().add(article_sort);
			sd.updateSort(s);
		
		}
		ad.updateArticle(a);
		
		Iterator article_tag_it=a.getArticleTags().iterator();
		while(article_tag_it.hasNext()) {
			atd.deleteArticleTag((ArticleTag)article_tag_it.next());
		}
		//保存标签
		String[] tags=tag.trim().replace(" ","" ).substring(0, tag.length()-1).split(",");
		for(int i=0;i<tags.length;i++) {
			article_tag=(ArticleTag) ctx.getBean("article_tag"); //获取新的文章分类对象
			
			if(IsInteger.isInteger(tags[i])) {
				t=td.getTagById(Integer.parseInt(tags[i]));
				article_tag.setArticle(a);
				article_tag.setTag(t);
				atd.saveArticleTag(article_tag);
				a.getArticleTags().add(article_tag);
				t.getArticleTags().add(article_tag);
				td.updateTag(t);
			}
			else {
				if(td.getTagByTag(tags[i])==null){
					System.out.println("no tag!!!!!");
					t=(Tag) ctx.getBean("tag");
					t.setTag(tags[i]);
					article_tag.setArticle(a);
					article_tag.setTag(t);
					atd.saveArticleTag(article_tag);
					a.getArticleTags().add(article_tag);
					t.getArticleTags().add(article_tag);
					td.saveTag(t);
				}
				else {
					System.out.println("has tag!!!!!");
					t=td.getTagByTag(tags[i]);
					article_tag.setArticle(a);
					article_tag.setTag(t);
					atd.saveArticleTag(article_tag);
					a.getArticleTags().add(article_tag);
					t.getArticleTags().add(article_tag);
					td.updateTag(t);
				}
			}
			
			ad.updateArticle(a);
		}
	}
	public String deleteArticle(int article_id) {
		ad.deleteArticle(ad.getArticleByArticleId(article_id));;
		return "[{\"result\":\"success\"}]";
	}
	/**
	 * 获取文章总数量
	 * @return
	 */
	public int getArticleCount() {
		return ad.getArticleCount();
	}
	
	/**
	 * 获取count篇最新文章
	 * @param count
	 * @return
	 */
	public List getArticle(int count) {
		return	ad.getArticle(count);
	}
	
	/**
	 * Ajax通过page获取文章
	 * @param page
	 * @return
	 */
	public String GetArticleByPageJ(int page) {
		List articles =GetArticleBtPage(page); //提取page对应的list

		String returnMes = "[{\"result\":\"success\"},";
		String errorMes = "[{\"result\":\"error\"}]";
		List sorts = sd.getAllSort();
		if (articles.size() > 0) {  //成功提取出数据
			Iterator it = articles.iterator();
			while (it.hasNext()) {
				Article a = (Article) it.next();
				String outSorts="";
				String outTags="";
				
				//文章对应的sort放在outSorts中
				Iterator articleSort=a.getArticleSorts().iterator();
				if(articleSort.hasNext()) {
					while(articleSort.hasNext())
					{
						article_sort=(ArticleSort) articleSort.next();
						outSorts+=article_sort.getSort().getSort()+" | ";
					}
					outSorts=outSorts.substring(0, outSorts.length()-3);
				}
				//文章对应的tag放在outTags中
				Iterator articleTag=a.getArticleTags().iterator();
				if(articleTag.hasNext()) {
					while(articleTag.hasNext()) {
						article_tag=(ArticleTag) articleTag.next();
						outTags+=article_tag.getTag().getTag()+" | ";
					}
					outTags=outTags.substring(0, outTags.length()-3);
				}
				//设置返回的json消息字符串
				returnMes += "{\"article_id\":" + a.getId() + ",\"article_title\":\"" + a.getTitle() + "\",\"article_author\":\"" + a.getAuthor() + "\","
				+"\"article_sort\":\""+outSorts+"\",\"article_tag\":\""+outTags+"\",\"article_time\":"+a.getTime()+"},";
			}
			returnMes=returnMes.substring(0, returnMes.length()-1)+"]";
			return returnMes;
		}
		return errorMes;
	}
	/**
	 * 首页获取文章
	 * @param page
	 * @return
	 */
	public String GetArticleByPageIndex(int page,int sort_id,int tag_id) {
		List<Article> articles=new ArrayList();
		if(sort_id!=0)   //分类
		{
			s=sd.getSortById(sort_id);
			List as=asd.getArticleSortBySortId(sort_id);
			List<Article> art=new ArrayList();
			Iterator it=as.iterator();
			while(it.hasNext()) {
				article_sort=(ArticleSort)it.next();
				art.add(article_sort.getArticle());
			}
			articles =GetArticleByPageList(page,art); //提取page对应的list
		}
		else if(tag_id!=0) {  //标签
			t=td.getTagById(tag_id);
			List at=atd.getArticleTagByTagId(tag_id);
			List<Article> art=new ArrayList();
			Iterator it=at.iterator();
			while(it.hasNext()) {
				article_tag=(ArticleTag)it.next();
				art.add(article_tag.getArticle());
			}
			articles =GetArticleByPageList(page,art); //提取page对应的list
		}
		else {  //正常首页
			articles =GetArticleBtPage(page); //提取page对应的list	
		}
		String returnMes = "[{\"result\":\"success\"},";
		String errorMes = "[{\"result\":\"error\"}]";
		List sorts = sd.getAllSort();
		if (articles!=null&&articles.size() > 0) {  //成功提取出数据
			Iterator it = articles.iterator();
			while (it.hasNext()) {
				Article a = (Article) it.next();
				//设置返回的json消息字符串
				returnMes += "{\"article_id\":" + a.getId() + ",\"article_title\":\"" + a.getTitle() + "\",\"article_author\":\"" + a.getAuthor() + "\","
				+"\"article_summary\":\""+a.getSummary()+"\",\"article_time\":"+a.getTime()+",\"article_image\":\""+a.getImage_url()+"\"},";
			}
			returnMes=returnMes.substring(0, returnMes.length()-1)+"]";
			return returnMes;
		}
		return errorMes;
	}
	
	/**
	 * 通过文章ID获取文章对象
	 * @param article_id
	 * @return
	 */
	public Article GetArticleByArticleId(int article_id) {
		return ad.getArticleByArticleId(article_id);
		/*
		//ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext-bean.xml");
		//a=(Article)ctx.getBean("article");
		JSONArray ja = new JSONArray();
		JSONObject outJ=new JSONObject();
		a=ad.getArticleByArticleId(article_id);
		System.out.println(a.getAuthor());
		String returnMes = "[{\"result\":\"success\"},";
		String errorMes = "[{\"result\":\"error\"}]";
		JSONObject message = new JSONObject();
		if(a!=null)
		{
			message.put("result", "success");
			outJ.put("article_id", a.getId());
			outJ.put("article_title", a.getTitle());
			outJ.put("article_author", a.getAuthor());
			outJ.put("article_content", a.getContent());
			outJ.put("article_summary", a.getSummary());
			outJ.put("article_time", a.getTime());
			outJ.put("article_star", a.getStar());
			outJ.put("article_visit", a.getVisit());
			outJ.put("article_image", a.getImage_url());
			ja.add(message);
			ja.add(outJ);
		}
		else {

			message.put("result", "error");
			ja.add(message);
		}
		System.out.println(ja.toString());
		return ja.toString();
		*/
	}
	
	/**
	 * 通过文章ID获取文章JSON格式
	 * @param article_id
	 * @return
	 */
	public String GetArticleJSONByArticleId(int article_id) {
		JSONArray ja = new JSONArray();
		JSONObject outJ=new JSONObject();
		JSONArray sortA= new JSONArray();
		JSONObject sortJ=new JSONObject();
		JSONArray tagA= new JSONArray();
		JSONObject tagJ=new JSONObject();
		a=ad.getArticleByArticleId(article_id);
		String returnMes = "[{\"result\":\"success\"},";
		String errorMes = "[{\"result\":\"error\"}]";
		JSONObject message = new JSONObject();
		if(a!=null)
		{
			message.put("result", "success");
			outJ.put("article_id", a.getId());
			outJ.put("article_title", a.getTitle());
			outJ.put("article_author", a.getAuthor());
			outJ.put("article_content", a.getContent());
			outJ.put("article_summary", a.getSummary());
			outJ.put("article_time", a.getTime());
			outJ.put("article_star", a.getStar());
			outJ.put("article_visit", a.getVisit());
			outJ.put("article_image", a.getImage_url());
			Iterator articleSorts=a.getArticleSorts().iterator();
			while(articleSorts.hasNext())
			{
				article_sort=(ArticleSort) articleSorts.next();
				sortJ.put("sortId", article_sort.getSort().getId());
				sortJ.put("sort_sort", article_sort.getSort().getSort());
				sortA.add(sortJ);
			}
			Iterator articleTags=a.getArticleTags().iterator();
			while(articleTags.hasNext())
			{
				article_tag=(ArticleTag) articleTags.next();
				tagJ.put("tagId", article_tag.getTag().getId());
				tagJ.put("tag_tag", article_tag.getTag().getTag());
				tagA.add(tagJ);
			}
			ja.add(message);
			ja.add(outJ);
			ja.add(sortA);
			ja.add(tagA);
		}
		else {

			message.put("result", "error");
			ja.add(message);
		}
		System.out.println(ja.toString());
		return ja.toString();
	}
	/**
	 * 更新对象
	 * @param a
	 */
	public void update(Article a) {
		ad.updateArticle(a);
	}
	/**
	 * 网页跳转 根据页码获取文章
	 * @param page
	 * @return
	 */
	public List GetArticleByPageR(int page) {
		return GetArticleBtPage(page);
	}
	

	public List GetArticleBtPage(int page) {
		List articles=ad.getArticle();
		return GetArticleByPageList(page,articles);
		
	}
	
	/**
	 * 从List列表中获取第page页
	 * @param page  第page页
	 * @param articles 需要获取的列表
	 * @return
	 */
	public List GetArticleByPageList(int page,List articles) {
		int articleCount=articles.size();
		int pageCount;
		if(articleCount>=10) {
			if(articleCount%10==0)
				pageCount=articleCount/10;
			else
				pageCount=articleCount/10+1;
			
		}
		else {
			pageCount=1;
		}
		
		if(page==pageCount)
			return articles.subList((pageCount-1)*10, articleCount);
		else if(page<pageCount)
			return articles.subList((page-1)*10, page*10);
		else 
			return null;
	}
	
	
	/**
	 * 文章点赞
	 * @param article_id
	 * @return
	 */
	public String addStar(int article_id) {
		a=ad.getArticleByArticleId(article_id);
		a.setStar(a.getStar()+1);
		ad.updateArticle(a);
		return "[{\"result\":\"success\"}]";
	}	
	/**
	 * 文章取消点赞
	 * @param article_id
	 * @return
	 */
	public String deStar(int article_id) {
		a=ad.getArticleByArticleId(article_id);
		if(a.getStar()!=0)	{
			a.setStar(a.getStar()-1);
			ad.updateArticle(a);
		}
		return "[{\"result\":\"success\"}]";
	}
	public ArticleDaoInterface getAd() {
		return ad;
	}

	public void setAd(ArticleDaoInterface ad) {
		this.ad = ad;
	}

	public Article getA() {
		return a;
	}

	public void setA(Article a) {
		this.a = a;
	}

	public SortDaoInterface getSd() {
		return sd;
	}

	public void setSd(SortDaoInterface sd) {
		this.sd = sd;
	}

	public ArticleSortDaoInterface getAsd() {
		return asd;
	}

	public void setAsd(ArticleSortDaoInterface asd) {
		this.asd = asd;
	}

	public ArticleSort getArticle_sort() {
		return article_sort;
	}

	public void setArticle_sort(ArticleSort article_sort) {
		this.article_sort = article_sort;
	}

	public Sort getS() {
		return s;
	}

	public void setS(Sort s) {
		this.s = s;
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

	public ArticleTag getArticle_tag() {
		return article_tag;
	}

	public void setArticle_tag(ArticleTag article_tag) {
		this.article_tag = article_tag;
	}

	public Tag getT() {
		return t;
	}

	public void setT(Tag t) {
		this.t = t;
	}
	
}
