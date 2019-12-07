package com.javatishengzhilu.init.wx;


/**
 * 微信常量
 */
public class ConstantWeChat {

	/**
	 * 微信服务号的原始ID
	 */
	public static String WEIXIN_URL_HEAD = "weixin.url.head";
	/**
	 * 微信服务号的原始ID
	 */
	public static String WEIXIN_ORIGIN_ID = "weixin.origin.id";
	
	/**
	 * 判断跳转是否来源于微信菜单
	 */
	public static String WX_STATE = "wxMenu";
	
	/**
	 * 与接口配置信息中的Token要一致
	*/
	public static String TOKEN = ConfigUtil.get("token");
	
	/**
	 * 第三方用户唯一凭证
	 */
	public static String APPID = ConfigUtil.get("appId");
	
	/**
	 * 第三方用户唯一凭证密钥
	 */
	public static String APPSECRET = ConfigUtil.get("appSecret");
	
	/**
	 * 商户号
	*/
	public static String MCHID = ConfigUtil.get("mchId");
	
	/***
	 * 	商户密钥
	*/
	public static String KEY = ConfigUtil.get("partnerkey");
	
	
	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	
	/**
	 * 返回消息类型：语音
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	
	/**
	 * 返回消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	
	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	
	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：事件
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";
	
	/**
	 * 	地理位置信息异步推送
	*/
	public static final String REQ_MESSAGE_TYPE_USER_SCAN_PRODUCT_ASYNC= "user_scan_product_async";

	/**
	 * 事件类型：subscribe(关注)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消关注)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";
	
	/**
	 * 事件类型：SCAN(扫码事件)
	 */
	public static final String EVENT_TYPE_CLICK_SCAN = "SCAN";

    /**
     * 事件信息，此处为MASSSENDJOBFINISH(群发之后的回推)
     */
    public static final String MASSSENDJOBFINISH = "MASSSENDJOBFINISH";
    /**
     * 事件信息，此处为模板信息发送后的送达信息(事件为模板消息发送结束)
     */
    public static final String TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";
    
    
    
	// 菜单创建（POST） 限100（次/天）
	public static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	// 群发列表链接（开发者使用高级群发接口的每日调用限制为100次，但是用户每月只能接收4条，请小心测试）
	public final static String POST_OPENID_LIST = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";

	// 获取素材列表总数
	public final static String PIC_OPEN_LIST_COUNT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	
	// 获取素材列表
	public final static String PIC_OPEN_LIST = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	/**
	 * 获取access_token的接口地址（GET） 限200（次/天）
	 */
	public final static String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
	 * 获取jsapi_ticket
	*/
	public final static String JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	/**
	 * OAUTH scope
	 * snsapi_base(网页授权静默：关注公众号的）
	 */
	public static final String SCOPE_SNSAPI_BASE = "snsapi_base";
	/**
	 * OAUTH scope
	 * snsapi_userinfo(网页授权用户手动同意：未关注公众号的）
	 */
	public static final String SCOPE_SNSAPI_USERINFO = "snsapi_userinfo";
	
	
}
