package com.syy.demo.utils.exception;

/**
 * 
 * @author sunyy
 * @version 1.0
 */

// 数据库来自spring bean global-config-bean.xml

public class DemoExceptionCache {

	private static String subsystemCode = "";
	private static String subsystemName = "";
	private static final ThreadLocal<String> tlModuleCode = new ThreadLocal<String>();
	private static final ThreadLocal<String> tlModuleName = new ThreadLocal<String>();

	//
	// 定义了一些常用的全局信息的函数
	public static void setSubsystemCode(String subsystem_code) {
		subsystemCode = subsystem_code;
	}

	public static String getSubsystemCode() {
		return subsystemCode;

	}

	public static String getSubsystemName() {
		return subsystemName;
	}

	public static void setSubsystemName(String subsystemName) {
		DemoExceptionCache.subsystemName = subsystemName;
	}

	public static String getModuleCode() {
		String _moduleCode = tlModuleCode.get();
		return _moduleCode;
	}

	public static String getModuleName() {
		String _moduleName = tlModuleName.get();
		return _moduleName;
	}

	public static void setModuleCode(String _moduleCode) {
		tlModuleCode.set(_moduleCode);
	}

	public static void setModule(String _moduleCode, String _moduleName) {
		tlModuleCode.set(_moduleCode);
		tlModuleName.set(_moduleName);
	}

}
