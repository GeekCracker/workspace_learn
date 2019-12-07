package com.javatishengzhilu.init.wx;

/**
 * 
 * view类型的菜单
 */
public class ViewButton extends Button {  
	
	//	菜单类型
    private String type;
    
    //	当菜单类型是view类型时,该属性必须的
    private String url;
    
    //	当菜单类型是click类型时,该属性必须的
    private String key;
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getUrl() {  
        return url;  
    }  
  
    public void setUrl(String url) {  
        this.url = url;  
    }

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}  
}  
