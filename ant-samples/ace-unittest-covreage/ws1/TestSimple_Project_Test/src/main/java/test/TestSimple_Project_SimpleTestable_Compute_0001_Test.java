package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.ibm.integration.test.v1.NodeSpy;
import com.ibm.integration.test.v1.SpyObjectReference;
import com.ibm.integration.test.v1.TestMessageAssembly;
import com.ibm.integration.test.v1.TestSetup;
import com.ibm.integration.test.v1.exception.TestException;

import static com.ibm.integration.test.v1.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSimple_Project_SimpleTestable_Compute_0001_Test {

	/*
	 * TestSimple_Project_SimpleTestable_Compute_0001_Test
	 * Test generated by IBM App Connect Enterprise Toolkit 12.0.1.0 on 17/01/2022 9:16:41 PM
	 */

	@AfterEach
	public void cleanupTest() throws TestException {
		// Ensure any mocks created by a test are cleared after the test runs 
		TestSetup.restoreAllMocks();
	}

	// InputStream input = new FileInputStream("input.txt");
	public InputStream readFile(String fileName) throws Exception {
	
		System.out.println("=============================================================");
		System.out.println("readFile called " + fileName);
		System.out.println("=============================================================");
	
		InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(fileName);
	
		if (messageStream == null) {
		
			// loading from file
			if (fileName.startsWith("/"))
			{
				fileName = fileName.replace("/",  "\\");
			}
			// hacky
			String fullPath = "C:\\richard\\projects\\mb_precise_git\\mb-precise-demos\\workspaces\\ws1\\TestSimple_Project_Test\\src\\main\\resources" +  fileName;
			
			System.out.println("readFile called with fillpath:" + fullPath);
			
			try {			
				InputStream inputStream = new FileInputStream(fullPath);
				System.out.println("after loading file :" + fullPath);
				System.out.println("inputStream=" + inputStream);
				
			
				return inputStream;
			} catch (FileNotFoundException ef) {
			
				throw new Exception("Cannot find file: " + fullPath);
			}
		}
		
		return messageStream;
	
	}
	
	@Test
	public void TestSimple_Project_SimpleTestable_Compute_TestCase_001() throws TestException {

		System.out.println("=============================================================");
		System.out.println("TestSimple_Project_SimpleTestable_Compute_TestCase_001 called v0.2");
		System.out.println("=============================================================");
	
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("TestSimple_Project")
				.messageFlow("SimpleTestable").node("Compute");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/SimpleTestable_Compute_0001_test1_input_data.mxml";
			
			InputStream messageStream = readFile(messageAssemblyPath);
									
			/* InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath); */
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
			
			System.out.println("finished building from messageStream");
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		System.out.println("Starting evaluate");
		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");
		
		System.out.println("Starting evaluate..done");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		/* Compare Output Message 1 at output terminal out */

		try {
			TestMessageAssembly actualMessageAssembly = null;
			TestMessageAssembly expectedMessageAssembly = null;

			// Get the TestMessageAssembly object for the actual propagated message
			actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

			// Assert output message body data
			// Get the TestMessageAssembly object for the expected propagated message
			expectedMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the expected output mxml resource
			String messageAssemblyPath = "/SimpleTestable_Compute_0001_test1_output_data.mxml";
			InputStream messageStream = readFile(messageAssemblyPath);
			
			/* InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath); */
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			System.out.println("buildFromRecordedMessageAssembly");
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
			System.out.println("buildFromRecordedMessageAssembly...done");

			// Assert that the actual message tree matches the expected message tree
			assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly));

			// Assert that the actual exception list tree matches the expected exception list tree
			assertThat(actualMessageAssembly, equalsExceptionList(expectedMessageAssembly));

			// Assert that the actual local environment tree matches the expected local environment tree
			assertThat(actualMessageAssembly, equalsLocalEnvironment(expectedMessageAssembly));

			// Assert that the actual environment tree matches the expected environment tree
			assertThat(actualMessageAssembly, equalsEnvironment(expectedMessageAssembly));

		} catch (Exception ex) {
			throw new TestException("Failed to compare with expected message", ex);
		}

	}

}
