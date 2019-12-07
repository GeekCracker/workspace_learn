package com.javatishengzhilu.init.wx;

import com.alibaba.fastjson.JSONObject;

public class AccessTokenUtils {

	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = ConstantWeChat.ACCESS_TOKEN.replace("APPID", appid).replace(
				"APPSECRET", appsecret);

		String result = HttpClientUtil.doGet(requestUrl);
		System.err.println(result);
		if(result != null && !"".equals(result.trim())){
			JSONObject obj = JSONObject.parseObject(result);
			if(obj != null){
				String access_token = obj.getString("access_token");
				Integer expires_in = obj.getInteger("expires_in");

				System.err.println(access_token);
				System.err.println(expires_in);
				accessToken = new AccessToken(access_token,expires_in);
			}
		}
		return accessToken;
	}
	
}
