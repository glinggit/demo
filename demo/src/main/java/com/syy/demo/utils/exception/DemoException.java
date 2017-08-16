package com.syy.demo.utils.exception;

/**
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2011.12</p>
 * @author sunyy
 * @version 1.0
 */

public class DemoException extends RuntimeException {

	private static final long serialVersionUID = 1;
	protected String _errorCode = "9900";
	protected String _moduleCode ="";
	protected String _moduleName ="";
	protected String _subsystem = "";
	protected Throwable _exception; //底层异常
	public DemoException(Throwable cause) {
		super(cause);
		setModule();
	}
	public DemoException(String msg,Throwable e) {
		super(msg,e);
		setModule();

	}
	public DemoException(String msg) {
		super(msg);
		setModule();

	}	
	public DemoException(String errorCode, String msg) {
		super(msg);
		setModule();
		_errorCode = errorCode;

	}
	public DemoException(String errorCode, String msg,String moduleCode,String subsystem) {
		super(msg);
		_errorCode = errorCode;
		_moduleCode = moduleCode;
		_subsystem = subsystem;	
		

	}
	public DemoException(Throwable exception,String msg) {
		super(msg,exception);
		_exception = exception;
		setModule();

	}
	public DemoException(Throwable exception,String errorCode, String msg) {
		super(msg,exception);
		_errorCode = errorCode;
		_exception = exception;
		setModule();

	}
	public DemoException(Throwable exception,String errorCode, String msg,String moduleCode,String subsystem) {
		super(msg,exception);
		_errorCode = errorCode;
		_exception = exception;
		_moduleCode = moduleCode;
		_subsystem = subsystem;	
		setModule();

	}
	public String getErrorCode() {
		return _errorCode;
	}
	public DemoException() {}
	
	public Throwable getRootCause() {
		if (_exception instanceof DemoException) {
			return ((DemoException) _exception).getRootCause();
		}
		return _exception == null ? this : _exception;
	}

	public String toString() {
		String desc = getFullMessage();
		if (_exception != null){
			desc = desc + "，底层异常为：" + _exception;
		}
		return desc;		
	}
	public String get_moduleCode()
	{
		return _moduleCode;
	}
	public String get_moduleName()
    {
    	return _moduleName;
    }
	public void set_moduleName(String moduleName)
    {
    	_moduleName = moduleName;
    }
	
	public String get_subsystem()
	{
		return _subsystem;
	}
	public String getFullMessage()
	{
		String info;
		if (_moduleCode==null || _moduleCode.isEmpty())
			info = "模块{"+_subsystem+"},错误代码{"+_errorCode+"},错误描述{"+this.getMessage()+"}";
		else
			info = "模块{"+_subsystem+":"+_moduleCode+"},错误代码{"+_errorCode+"},错误描述{"+this.getMessage()+"}";
		
		return info;
	}
	private void setModule()
	{
		_subsystem  = DemoExceptionCache.getSubsystemCode();
		_moduleCode = DemoExceptionCache.getModuleCode();
		_moduleName = DemoExceptionCache.getModuleName();
		
	}
	
}
