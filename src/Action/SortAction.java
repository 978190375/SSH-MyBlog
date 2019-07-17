package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Service.SortService;

public class SortAction extends ActionSupport {
	public SortService ss;
	public String sort_value;
	private int sort_id;
	public void getAllSort() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(ss.getAllSort());
	}
	
	public void addSort() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(ss.addSort(sort_value));
	}
	public void getSortByJson(){
		System.out.println("getSortByJson");
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(ss.getSortByJson());
	}
	/**
	 * 删除分类
	 */
	public void deleteSort() {
		ss.deleteSort(sort_id);
	}
	
	/**
	 * 更新分类
	 */
	public void updateSort() {
		System.out.println("getSortByJson");
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(ss.updateSort(sort_id, sort_value));
	}
	public SortService getSs() {
		return ss;
	}
	public void setSs(SortService ss) {
		this.ss = ss;
	}
	public String getSort_value() {
		return sort_value;
	}
	public void setSort_value(String sort_value) {
		this.sort_value = sort_value;
	}
	public int getSort_id() {
		return sort_id;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	
}
