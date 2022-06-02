package au.com.bettercodingtools.sonar.messagebrokersonar;


import com.ibm.broker.plugin.*;

public class MBCallLogTraceNode extends MbNode implements MbNodeInterface
{
	private String ref; 
	private String srcFileName; 
	private String lineNumber; 
	private String branches; 
	private String port;
	private String address;
	private String throwError;
	

	public MBCallLogTraceNode() throws MbException
	{
		System.out.println("calling MBCallLogTraceNode()");
		
		// create terminals here
		createInputTerminal ("in");
		createOutputTerminal ("out");
		// createOutputTerminal ("failure");
	}
	
	public static String getNodeName()
	{
		System.out.println("calling getNodeName()");
		
		// return "MBCallLogTrace";
		return "MBCallLogTraceNode";
	}
			 
	public void evaluate(MbMessageAssembly assembly, MbInputTerminal inTerm) throws MbException
	{
		// add message processing code here
		System.out.println("calling evaluate");
		System.out.println("ref=" + ref);
		System.out.println("srcFileName=" + srcFileName);
		System.out.println("lineNumber=" + lineNumber);
		System.out.println("branches=" + branches);
		System.out.println("port=" + port);
		System.out.println("address=" + address);
		System.out.println("throwError=" + throwError);
		
						
		// do something 

		getOutputTerminal("out").propagate(assembly);
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getBranches() {
		return branches;
	}

	public void setBranches(String branches) {
		this.branches = branches;
	}

	public String getPort() {

		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getThrowError() {
		return throwError;
	}

	public void setThrowError(String throwError) {
		this.throwError = throwError;
	}
	
}
