package Pojo;

/**
 * Visitor entity. @author MyEclipse Persistence Tools
 */

public class Visitor  {

	// Fields

	private Integer id;
	private String ip;
	private String time;

	// Constructors

	/** default constructor */
	public Visitor() {
	}

	/** full constructor */
	public Visitor(String ip, String time) {
		this.ip = ip;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}