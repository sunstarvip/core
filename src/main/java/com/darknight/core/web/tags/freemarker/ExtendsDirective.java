package com.darknight.core.web.tags.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * FTL中Extends标签处理类
 * @author
 */
public class ExtendsDirective implements TemplateDirectiveModel {

	private final static String PAGE_PREFIX = "";
	
	public void execute(Environment env,
            Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
		
		String path = DirectiveUtils.getRequiredParam(params, "path");
		String encoding = DirectiveUtils.getParam(params, "encoding", null);
//		String includeTemplateName = TemplateCache.getFullTemplatePath(env, getTemplatePath(env), name);
		String includeTemplateName = PAGE_PREFIX + path;  //模板路径整合
		env.include(includeTemplateName, encoding, true);
	}

}
