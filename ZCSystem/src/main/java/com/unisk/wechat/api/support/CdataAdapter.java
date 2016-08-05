package com.unisk.wechat.api.support;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 利用jaxb生成的xml内容添加<![CDATA[]]>
 * 
 * @author shijingbang
 * @Date 2015-11-18
 */
public class CdataAdapter extends XmlAdapter<String, String> {

	@Override
	public String unmarshal(String v) throws Exception {
		return v;
	}

	@Override
	public String marshal(String v) throws Exception {
		return "<![CDATA[" + v + "]]>";
	}

}
