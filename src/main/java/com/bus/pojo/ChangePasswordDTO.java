package com.bus.pojo;

public class ChangePasswordDTO {

	private Long changePasswordUserId;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	
	public Long getChangePasswordUserId() {
		return changePasswordUserId;
	}
	public void setChangePasswordUserId(Long changePasswordUserId) {
		this.changePasswordUserId = changePasswordUserId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
