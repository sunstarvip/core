package com.darknight.core.web.tags.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;
import com.darknight.core.web.tags.freemarker.OverrideDirective.TemplateDirectiveBodyOverrideWraper;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * FTL模板继承标签工具类
 * @author
 */
public class DirectiveUtils {
	
	public static String BLOCK = "__ftl_override__";
	public static String OVERRIDE_CURRENT_NODE = "__ftl_override_current_node";
	
	public static String getOverrideVariableName(String name) {
		return BLOCK + name;
	}

	/**
	 * 获取必须参数
	 * @param params
	 * @param key
	 * @return
	 * @throws freemarker.template.TemplateException
	 */
	static String getRequiredParam(Map params,String key) throws TemplateException {
		Object value = params.get(key);
		if(value == null || StringUtils.isEmpty(value.toString())) {
			throw new TemplateModelException("not found required parameter:"+key+" for directive");
		}
		return value.toString();
	}

	/**
	 * 获取非必须参数
	 * @param params
	 * @param key
	 * @param defaultValue
	 * @return
	 * @throws freemarker.template.TemplateException
	 */
	static String getParam(Map params,String key,String defaultValue) throws TemplateException {
		Object value = params.get(key);
		return value == null ? defaultValue : value.toString();
	}

	/**
	 * 获取重载内容
	 * @param env
	 * @param name
	 * @return
	 * @throws freemarker.template.TemplateModelException
	 */
	static TemplateDirectiveBodyOverrideWraper getOverrideBody(Environment env, String name) throws TemplateModelException {

		TemplateDirectiveBodyOverrideWraper value = (TemplateDirectiveBodyOverrideWraper)env.getVariable(DirectiveUtils.getOverrideVariableName(name));
		return value;
	}

	/**
	 * 递归继承
	 * @param env
	 * @param topBody
	 * @param overrideBody
	 */
	static void setTopBodyForParentBody(Environment env,
			TemplateDirectiveBodyOverrideWraper topBody,
			TemplateDirectiveBodyOverrideWraper overrideBody) {
		TemplateDirectiveBodyOverrideWraper parent = overrideBody;
		while(parent.parentBody != null) {
			parent = parent.parentBody;
		}
		parent.parentBody = topBody;
	}
}
