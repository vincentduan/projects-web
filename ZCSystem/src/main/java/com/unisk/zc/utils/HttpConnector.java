package com.unisk.zc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class HttpConnector {

	public static final Logger log = Logger.getLogger(HttpConnector.class);

	public static String requestPost(String url, String param, boolean isSSL)
			throws Exception {
		return connect(url, param, isSSL, "POST");
	}

	public static String requestGet(String url, String param, boolean isSSL)
			throws Exception {
		return connect(url, param, isSSL, "GET");
	}

	/**
	 * 通过get或者post方式获取请求
	 * 
	 * @param url
	 *            post请求，此时参数从body中传过来,body为json类型
	 * @param postParams
	 *            如果没有则为空
	 * @return
	 */
	private static String connect(String url, String params, boolean isSSL,
			String method) throws Exception {

		if (isSSL) {
			_ignoreSSL();
		}

		HttpURLConnection conn = null;
		OutputStreamWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();

		try {
			if ("POST".equals(method)) {
				URL urlEntity = new URL(url);
				conn = (HttpURLConnection) urlEntity.openConnection();

				conn.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
			} else {
				URL urlEntity = new URL(url + "?" + params);
				conn = (HttpURLConnection) urlEntity.openConnection();
			}
			conn.setRequestMethod(method);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Length", "" + params.length());

			if ("POST".equals(method)) {
				out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
				out.write(params);

				out.close();
			} else
				conn.connect();

			log.info(result);

			int responseCode = conn.getResponseCode();
			log.info("当前的responseCode为： [ " + responseCode + " ] ");

//			log.info("该请求发送的地址为： [ " + url + " ] ，参数为： [ " + params + " ] ");
//			log.info("responsecode为：" + responseCode);

			if (responseCode == 200) {

			} else if (responseCode == 302) {

			} else if (responseCode >= 400 && responseCode < 500) {
				throw new IOException(
						"4XX错误，服务器内部错误，该错误需要启动定时任务，并且请通知责任人检查服务器，地址为： [ " + url
								+ " ] ，参数为： [ " + params + " ] ");

			} else if (responseCode >= 500 && responseCode < 600) {
				throw new IOException("5XX错误，地址为： [ " + url + " ] ，参数为： [ "
						+ params + " ] ， 的程序内部错误，准备启动定时回调任务。");

			}

			String line = "";
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			while ((line = in.readLine()) != null) {
				result.append(line).append("\n");

			}

		} catch (IOException e) {
			StringBuffer errorMsg = new StringBuffer();
			String line = StringUtils.EMPTY;
			in = new BufferedReader(new InputStreamReader(
					conn.getErrorStream(), "utf-8"));
			while ((line = in.readLine()) != null) {
				errorMsg.append(line).append("\n");
			}
			throw new Exception("连接错误，启动定时回调任务，连接地址为：[ " + url
					+ " ] ，参数为： [ " + params + " ] 异常原因[" + errorMsg + "]", e);

		} catch (Exception e) {
			throw new Exception("程序异常，连接地址为：[ " + url + " ] ，参数为： [ " + params
					+ " ]，该异常不需要启动定时任务 ", e);

		} finally {

			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();

				}

			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();

				}

		}

		return result.toString();
	}

	/**
	 * 忽略SSL
	 */
	private static void _ignoreSSL() {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(X509Certificate[] certs,
						String authType) {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] certs,
						String authType) {
				}
			} };

			// Install the all-trusting trust manager

			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection
					.setDefaultHostnameVerifier(new HostnameVerifier() {
						@Override
						public boolean verify(String s, SSLSession sslsession) {
							return true;
						}
					});
		} catch (KeyManagementException ex) {

		} catch (NoSuchAlgorithmException ex) {

		}
	}

	public static void main(String[] args) {
		try {
			// 华谊
			// connect("http://192.168.3.65:9000/billingcenter2.0/palmBilling/huayiEntertainmentPay/callback.do",
			// "<?xml version=\"1.0\" encoding=\"gbk\"?><ServiceWebTransfer2APReq><transactionID>1404841873828</transactionID><spId>1805825</spId><serviceId>1816825</serviceId><serviceType>1</serviceType><feeType>2</feeType><channelId>1805927</channelId><extend>11</extend><itemId>yy,11,10007216</itemId><destmsisdn>13775969547</destmsisdn><actiontime>2014-07-09 01:51:13</actiontime><fee>200</fee><area>0</area><success>0</success></ServiceWebTransfer2APReq>",
			// false, "POST");

//			connect("http://sms.q1w2e3r4.net/smscenter/smsc.php/SmsSync/sms140609",
//					"dest=10658035616002&p=YY,11,100204&mobile=13811195368&linkid=00012014071013562096200&code=21000&region=1561100&feecode=200&sign=b83b8e80a392010dae0cca0e13f7d945&desc=成功",
//					false, "GET");
			// ivr
			// connect("http://172.16.108.35:8888/billingcenter2.0/palmBilling/ivrPay/callback.do",
			// "callingNo=13937540629&calledNo=12590620211&startTime=2014-07-02 10:05:05&endTime=2014-07-02 10:06:56",
			// false, "POST");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
