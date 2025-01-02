package xmldatasamples;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.ns.XmlDataWorkspace;
import com.wm.xmldata.*;
import com.wm.lang.ns.NSNode;
import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSRecord;
import com.wm.app.b2b.server.ns.Namespace;
// --- <<IS-END-IMPORTS>> ---

public final class copy

{
	// ---( internal utility methods )---

	final static copy _instance = new copy();

	static copy _newInstance() { return new copy(); }

	static copy _cast(Object o) { return (copy)o; }

	// ---( server methods )---




	public static final void first (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(first)>> ---
		// @sigtype java 3.5
		// Retrieve the XmlData output from the conversion service
		IData doc = (IData) ValuesEmulator.get(pipeline, "xmlDataDocument");
		// Get the content of the document element
		IData input = (IData) XmlData.getValueCursor(doc).getValue();
		
		// Create workspace in order to access the relevant Doctypes
		XmlDataWorkspace ws = XmlDataWorkspace.getServerWorkspace();
		ws.setFolder("xmldatasamples.copy");
		
		// Fetch the two relevant records
		NSRecord recA = (NSRecord) ws.getType(new XmlDataTypeTag("normal"));
		NSRecord recB = (NSRecord) ws.getType(new XmlDataTypeTag("inverted"));
		
		// create an empty output document
		IData output = XmlData.createComplexValue();
		
		// Perform the copy
		XmlDataCopy.copy(input, recA, "/!a/!b", output, recB, "/!b/!a");
		
		ValuesEmulator.put(pipeline, "input", input);		  	
		ValuesEmulator.put(pipeline, "output", output);		 
		// --- <<IS-END>> ---

                
	}



	public static final void second (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(second)>> ---
		// @sigtype java 3.5
		// Retrieve the XmlData output from the conversion service
		IData doc = (IData) ValuesEmulator.get(pipeline, "xmlDataDocument");
		// Get the content of the document element
		IData input = (IData) XmlData.getValueCursor(doc).getValue();
		
		// Create workspace in order to access the relevant Doctypes
		XmlDataWorkspace ws = XmlDataWorkspace.getServerWorkspace();
		ws.setFolder("xmldatasamples.copy");
		
		// Fetch the two relevant records
		NSRecord recA = (NSRecord) ws.getType(new XmlDataTypeTag("typeAnest"));
		NSRecord recB = (NSRecord) ws.getType(new XmlDataTypeTag("typeBlist"));
		
		// create an empty output document
		IData output = XmlData.createComplexValue();
		
		// perform the copy
		XmlDataCopy.copy(input, recA, "/ableTop[!x]/ableItem", output, recB, "/baker[!x]");
		
		ValuesEmulator.put(pipeline, "input", input);		  	
		ValuesEmulator.put(pipeline, "output", output);		 
		// --- <<IS-END>> ---

                
	}
}

