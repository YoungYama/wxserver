package com.yzz.entity; 

import javax.persistence.Entity; 
import javax.persistence.Id; 
import javax.persistence.Table; 

/** 
* 
* @description: wx_public_account表WxPublicAccount实体类 
* 
* @author 杨志钊 
* @date 2017-04-07 18:43:38 
*/

@Entity 
@Table(name = "wx_public_account") 
public class WxPublicAccount { 

	@Id 
 	private String wxPublicAccountId;//wx_public_account_id

	public String getWxPublicAccountId() { 
		return wxPublicAccountId; 
	} 

	public void setWxPublicAccountId(String wxPublicAccountId) { 
 		this.wxPublicAccountId = wxPublicAccountId == null ? null : wxPublicAccountId.trim(); 
	} 

 
 } 
