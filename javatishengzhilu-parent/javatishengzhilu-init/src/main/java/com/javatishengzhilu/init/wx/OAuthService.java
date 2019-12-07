package com.javatishengzhilu.init.wx;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * oAuth服务
 * @author caspar.chen
 * @version 1.0
 * 
 */
public class OAuthService {

	public static Logger log = LoggerFactory.getLogger(OAuthService.class);
	
	/**
	 * 网页授权
	 */
	public static String OAUTH = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
	/**
	 * 通过oauth获取用户详细信息
	 */
	public static String GET_USER_INFO_OAUTH = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	/**
	 * 获取oauth网页认证的token
	 */
	public static String GET_ACCESS_TOKEN_OAUTH = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	/**
	 * 检验授权凭证（access_token）是否有效
	 */
	public static String IS_ON_TOKEN_OAUTH = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	
	/**
	 * 刷新access_token（如果需要）(refresh_token拥有较长的有效期（7天、30天、60天、90天）)
	 */
	public static String REFRESH_TOKEN_OAUTH = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	
	/**
	 * 获得Oauth认证的URL1
	 * @param redirectUrl	跳转的url
	 * @param scope	(snsapi_base 网页授权静默：关注公众号的/ snsapi_userinfo网页授权手动同意：未关注公众号的)
	 * @param state:重定向后会带上state参数，可以填写a-zA-Z0-9的参数值，最多128字节(可携带邀请人的user_id)
	 * @return oauth url
	 */
	public static String getOauthUrlUtf8(String redirectUrl, String scope, String state){
		String url = "";
		try {
			url = OAUTH
					.replace("APPID", ConfigUtil.get("appId"))
					.replace("REDIRECT_URI",
							URLEncoder.encode(redirectUrl, "utf-8"))
					.replace("STATE", state)
					.replace("SCOPE", scope);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * 获得Oauth认证的URL1
	 * @param redirectUrl	跳转的url
	 * @param charset	字符集格式
	 * @param scope	(snsapi_base 网页授权静默：关注公众号的/ snsapi_userinfo网页授权手动同意：未关注公众号的)
	 * @param state:重定向后会带上state参数，可以填写a-zA-Z0-9的参数值，最多128字节(可携带邀请人的user_id)
	 * @return oauth url
	 */
	public static String getOauthUrl(String redirectUrl,String charset,String scope, String state){
		String url = "";
		try {
			url = OAUTH
					.replace("APPID", ConfigUtil.get(ConstantWeChat.APPID))
					.replace("REDIRECT_URI",
							URLEncoder.encode(redirectUrl, charset))
					.replace("SCOPE", scope);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * 获得Oauth认证的URL2
	 * @param redirectUrl	跳转的url
	 * @param charset	字符集格式
	 * @param scope	OAUTH scope (snsapi_base 网页授权静默：关注公众号的/ snsapi_userinfo网页授权手动同意：未关注公众号的)
	 * @return oauth url
	 */
	public static String getOauthUrl(String redirectUrl,String charset,String scope){
		String url = "";
		try {
			url = OAUTH
					.replace("APPID", ConfigUtil.get(ConstantWeChat.APPID))
					.replace("REDIRECT_URI",
							URLEncoder.encode(redirectUrl, charset))
					.replace("SCOPE", scope);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}
	
}