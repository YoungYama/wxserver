package com.yzz.temp; 

import javax.persistence.Entity; 
import javax.persistence.Id; 
import javax.persistence.Table; 

/** 
* 
* @description: wx_news表WxNews实体类 
* 
* @author 杨志钊 
* @date 2017-04-07 18:43:38 
*/

@Entity 
@Table(name = "wx_news") 
public class WxNews { 

	@Id 
 	private String wxNewsId;//图文ID

	private String sysUserId;//系统用户编号

	private String wxPublicAccountId;//所属公账号ID

	private String mediaId;//媒体文件上传后，获取的标识

	private String title;//图文消息的标题

	private String thumbMediaId;//图文消息的封面图片素材id（必须是永久mediaID）

	private String showCoverPic;//是否显示封面，0为false，即不显示，1为true，即显示

	private String author;//作者

	private String digest;//图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空

	private String content;//图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS

	private String url;//图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL

	private String contentSourceUrl;//图文消息的原文地址，即点击“阅读原文”后的URL

	private String updateTime;//这篇图文消息素材的最后更新时间

	private String createTime;//这篇图文消息素材的创建时间

	public String getWxNewsId() { 
		return wxNewsId; 
	} 

	public void setWxNewsId(String wxNewsId) { 
 		this.wxNewsId = wxNewsId == null ? null : wxNewsId.trim(); 
	} 

	public String getSysUserId() { 
		return sysUserId; 
	} 

	public void setSysUserId(String sysUserId) { 
 		this.sysUserId = sysUserId == null ? null : sysUserId.trim(); 
	} 

	public String getWxPublicAccountId() { 
		return wxPublicAccountId; 
	} 

	public void setWxPublicAccountId(String wxPublicAccountId) { 
 		this.wxPublicAccountId = wxPublicAccountId == null ? null : wxPublicAccountId.trim(); 
	} 

	public String getMediaId() { 
		return mediaId; 
	} 

	public void setMediaId(String mediaId) { 
 		this.mediaId = mediaId == null ? null : mediaId.trim(); 
	} 

	public String getTitle() { 
		return title; 
	} 

	public void setTitle(String title) { 
 		this.title = title == null ? null : title.trim(); 
	} 

	public String getThumbMediaId() { 
		return thumbMediaId; 
	} 

	public void setThumbMediaId(String thumbMediaId) { 
 		this.thumbMediaId = thumbMediaId == null ? null : thumbMediaId.trim(); 
	} 

	public String getShowCoverPic() { 
		return showCoverPic; 
	} 

	public void setShowCoverPic(String showCoverPic) { 
 		this.showCoverPic = showCoverPic == null ? null : showCoverPic.trim(); 
	} 

	public String getAuthor() { 
		return author; 
	} 

	public void setAuthor(String author) { 
 		this.author = author == null ? null : author.trim(); 
	} 

	public String getDigest() { 
		return digest; 
	} 

	public void setDigest(String digest) { 
 		this.digest = digest == null ? null : digest.trim(); 
	} 

	public String getContent() { 
		return content; 
	} 

	public void setContent(String content) { 
 		this.content = content == null ? null : content.trim(); 
	} 

	public String getUrl() { 
		return url; 
	} 

	public void setUrl(String url) { 
 		this.url = url == null ? null : url.trim(); 
	} 

	public String getContentSourceUrl() { 
		return contentSourceUrl; 
	} 

	public void setContentSourceUrl(String contentSourceUrl) { 
 		this.contentSourceUrl = contentSourceUrl == null ? null : contentSourceUrl.trim(); 
	} 

	public String getUpdateTime() { 
		return updateTime; 
	} 

	public void setUpdateTime(String updateTime) { 
 		this.updateTime = updateTime == null ? null : updateTime.trim(); 
	} 

	public String getCreateTime() { 
		return createTime; 
	} 

	public void setCreateTime(String createTime) { 
 		this.createTime = createTime == null ? null : createTime.trim(); 
	} 

 
 } 
