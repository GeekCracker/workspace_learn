package com.javatishengzhilu.init.wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.ClassPathResource;

public class HttpClientUtil {

	/**
	 * 执行doGet请求
	 */
	public static String doGet(String url, Map<String, String> param) {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null && !param.isEmpty()) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	// ------------------------------------------------------------

	/**
	 * 执行doPost请求 请求参数：Map
	 */
	public static String doPost(String url, Map<String, String> urlParams, Map<String, String> requestBodyParam) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (urlParams != null && !urlParams.isEmpty()) {
				for (String key : urlParams.keySet()) {
					builder.addParameter(key, urlParams.get(key));
				}
			}
			URI uri = builder.build();

			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(uri.toString());
			// 创建参数列表
			if (requestBodyParam != null && !requestBodyParam.isEmpty()) {
				List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
				for (String key : requestBodyParam.keySet()) {
					paramList.add(new BasicNameValuePair(key, requestBodyParam.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	/**
	 * 执行doPost请求 请求参数：Json
	 */
	public static String doPostJson(String url, Map<String, String> urlParams, String requestJson) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (urlParams != null && !urlParams.isEmpty()) {
				for (String key : urlParams.keySet()) {
					builder.addParameter(key, urlParams.get(key));
				}
			}
			URI uri = builder.build();

			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(uri.toString());
			// 创建请求内容
			StringEntity entity = new StringEntity(requestJson, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	// ----------------------------------------------------

	/**
	 * 执行doPut请求
	 */
	public static String doPut(String url, Map<String, String> urlParams, Map<String, String> requestBodyParam) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (urlParams != null && !urlParams.isEmpty()) {
				for (String key : urlParams.keySet()) {
					builder.addParameter(key, urlParams.get(key));
				}
			}
			URI uri = builder.build();

			// 创建Http Post请求
			HttpPut httpPut = new HttpPut(uri.toString());
			// 创建参数列表
			if (requestBodyParam != null && !requestBodyParam.isEmpty()) {
				List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
				for (String key : requestBodyParam.keySet()) {
					paramList.add(new BasicNameValuePair(key, requestBodyParam.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPut.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPut);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	/**
	 * 	POST请求
	*/
	public static String doPostSSL(String url, String requestXml,String machid)throws Exception {
		
		KeyStore keyStore  = KeyStore.getInstance("PKCS12");
		ClassPathResource cl = new ClassPathResource("apiclient_cert.p12");
		InputStream is = null;
        try {
        	is = cl.getInputStream();
            keyStore.load(cl.getInputStream(), machid.toCharArray());
        } finally {
        	if(is != null){
        		is.close();
        	}
        }

        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, machid.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		
		HttpPost httpPost = new HttpPost(url);
		try {
			StringEntity reqEntity = new StringEntity(requestXml);
			reqEntity.setContentType("application/x-www-form-urlencoded");
			httpPost.setEntity(reqEntity);
			CloseableHttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
				StringBuilder sb = new StringBuilder();  
				String text = null;
				while ((text = bufferedReader.readLine()) != null) {
					sb.append(text);  
		            sb.append("\r\n");  
				}
				return sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(httpclient != null){
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}