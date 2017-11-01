package com.lemon.sp.dbmodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserInfo")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UID")
	private Integer uid;

	@Column(name = "Account")
	private String account;

	@Column(name = "Password")
	private String password;

	@Column(name = "CreateTime")
	private Date createtime;

	@Column(name = "State")
	private Integer state;

	@Column(name = "IconUrl")
	private String iconurl;

	@Column(name = "NickName")
	private String nickname;

	@Column(name = "Email")
	private String email;

	@Column(name = "RoleID")
	private Integer roleid;

	@Column(name = "sCode")
	private String scode;

	@Column(name = "LoginCount")
	private Integer logincount;

	@Column(name = "TotalLoginTime")
	private Integer totallogintime;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "IsActive")
	private String isActive;

	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Column(name = "ModifyTime")
	private String modifyTime;

	@Column(name = "Signature")
	private String signature;

	@Column(name = "realName")
	private String realName;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "SchoolReportUrl")
	private String schoolReportUrl;
	@Column(name = "sTeacherID")
	private String sTeacherID ;

	public String getsTeacherID() {
		return sTeacherID;
	}

	public void setsTeacherID(String sTeacherID) {
		this.sTeacherID = sTeacherID;
	}

	public Integer getUid() {
		return uid;
	}

	public Integer setUid(Integer uid) {
		return this.uid = uid;
	}

	public String getAccount() {
		return account;
	}

	public String setAccount(String account) {
		return this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public Date setCreatetime(Date createtime) {
		return this.createtime = createtime;
	}

	public Integer getState() {
		return state;
	}

	public Integer setState(Integer state) {
		return this.state = state;
	}

	public String getIconurl() {
		return iconurl;
	}

	public String setIconurl(String iconurl) {
		return this.iconurl = iconurl;
	}

	public String getNickname() {
		return nickname;
	}

	public String setNickname(String nickname) {
		return this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		return this.email = email;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public Integer setRoleid(Integer roleid) {
		return this.roleid = roleid;
	}

	public String getScode() {
		return scode;
	}

	public String setScode(String scode) {
		return this.scode = scode;
	}

	public Integer getLogincount() {
		return logincount;
	}

	public Integer setLogincount(Integer logincount) {
		return this.logincount = logincount;
	}

	public Integer getTotallogintime() {
		return totallogintime;
	}

	public Integer setTotallogintime(Integer totallogintime) {
		return this.totallogintime = totallogintime;
	}

	public String getPhone() {
		return phone;
	}

	public String setPhone(String phone) {
		return this.phone = phone;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSchoolReportUrl() {
		return schoolReportUrl;
	}

	public void setSchoolReportUrl(String schoolReportUrl) {
		this.schoolReportUrl = schoolReportUrl;
	}
	
	
}