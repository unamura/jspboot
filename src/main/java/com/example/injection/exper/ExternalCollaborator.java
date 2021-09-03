package com.example.injection.exper;

//@Component
public class ExternalCollaborator implements Expert {

	private String nickName;
	
	public ExternalCollaborator(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String currentOccupation() {
		return getNickName() + " could be an external collaborator";
	}

}
