package com.darknight.core.web.tags.jsp;

/**
 * @author badqiu
 */
class Utils {
	public static String BLOCK = "__jsp_override__";
	
	static String getOverrideVariableName(String name) {
		return BLOCK + name;
	}

}
