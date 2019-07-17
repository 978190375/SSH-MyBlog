package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Pojo.Tag;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Service.TagService;

public class TagAction extends ActionSupport   {
	String input_value;
	TagService ts;
	private int tag_id;
	private String	tag_value;
	public void getTagsByInput() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(ts.getTagByInput(input_value));
	}
	
	/**
	 * 通过Json获取tag和该Tag包含的文章数量
	 */
	public void getTagByJson(){
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(ts.getTagByJson());
	}
	public void addTag() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(ts.addTag(input_value));
	}
	
	public void deleteTag() {
		ts.deleteTag(tag_id);
	}
	
	/**
	 * 更新Tag
	 */
	public void updateTag() {
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			 out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(ts.updateTag(tag_id, tag_value));
		
	}
	public String getInput_value() {
		return input_value;
	}
	public void setInput_value(String input_value) {
		this.input_value = input_value;
	}
	public TagService getTs() {
		return ts;
	}
	public void setTs(TagService ts) {
		this.ts = ts;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public String getTag_value() {
		return tag_value;
	}

	public void setTag_value(String tag_value) {
		this.tag_value = tag_value;
	}
	
}
