package cn.yuan.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "cdp_job_config")
public class CdpJobConfig implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String code;
	@Column(name="job_type")
	private Integer jobType;
	@Column
	private String project;
	private String jobGroup;
	@Column
	private Integer sort;
	@Column(name="job_content")
	private String jobContent;
	@Column(name="status_flag")
	private Integer statusFlag;
	@Column(name="interrupt_flag")
	private Integer interruptFlag;
	@Column(name="creator_name")
	private String creatorName;
	@Column(name="creator_id")
	private String creatorId;
	@Column(name="updator_name")
	private String updatorName;
	@Column(name="updator_id")
	private String updatorId;
	@Column(name="server_create_time")
	private Date serverCreateTime;
	@Column(name="server_update_time")
	private Date serverUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getJobType() {
		return jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getJobContent() {
		return jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	public Integer getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(Integer statusFlag) {
		this.statusFlag = statusFlag;
	}

	public Integer getInterruptFlag() {
		return interruptFlag;
	}

	public void setInterruptFlag(Integer interruptFlag) {
		this.interruptFlag = interruptFlag;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getUpdatorName() {
		return updatorName;
	}

	public void setUpdatorName(String updatorName) {
		this.updatorName = updatorName;
	}

	public String getUpdatorId() {
		return updatorId;
	}

	public void setUpdatorId(String updatorId) {
		this.updatorId = updatorId;
	}

	public Date getServerCreateTime() {
		return serverCreateTime;
	}

	public void setServerCreateTime(Date serverCreateTime) {
		this.serverCreateTime = serverCreateTime;
	}

	public Date getServerUpdateTime() {
		return serverUpdateTime;
	}

	public void setServerUpdateTime(Date serverUpdateTime) {
		this.serverUpdateTime = serverUpdateTime;
	}

}
