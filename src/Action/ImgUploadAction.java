package Action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ImgUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String err = "";
	private String msg;// 返回信息
	private File fileData;// 上传文件
	private String fileDataFileName; // 文件名

	public void imgUpload() {// 获取response、request对象 
		System.out.println("Create");
		ActionContext ac = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String saveRealFilePath = ServletActionContext.getServletContext().getRealPath("/upload");
		File fileDir = new File(saveRealFilePath);
		if (!fileDir.exists()) { // 如果不存在 则创建
			fileDir.mkdirs();
		}
		File savefile;
		Date time=new Date();
		String fileName=time.getTime()+fileDataFileName;
		savefile = new File(saveRealFilePath + "/" +fileName);
		try {
			FileUtils.copyFile(fileData, savefile);
		} catch (IOException e) {
			err = "错误" + e.getMessage();
			e.printStackTrace();
		}
		String file_Name = request.getContextPath() + "/upload/" + fileName;
		System.out.println(file_Name);
		msg = "{\"success\":\"" + true + "\",\"file_path\":\"" + file_Name + "\"}";
		System.out.println(msg);
		out.print(msg); // 返回msg信息     
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public File getFileData() {
		return fileData;
	}

	public void setFileData(File fileData) {
		this.fileData = fileData;
	}

	public String getFileDataFileName() {
		return fileDataFileName;
	}

public void setFileDataFileName(String fileDataFileName) {
	this.fileDataFileName = fileDataFileName;
	}
}
