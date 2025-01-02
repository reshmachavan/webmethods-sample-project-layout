package xmldatasamples;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.xmldata.*;
// --- <<IS-END-IMPORTS>> ---

public final class repeating

{
	// ---( internal utility methods )---

	final static repeating _instance = new repeating();

	static repeating _newInstance() { return new repeating(); }

	static repeating _cast(Object o) { return (repeating)o; }

	// ---( server methods )---




	public static final void accessValues (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(accessValues)>> ---
		// @sigtype java 3.5
		// Retrieve the XmlData output from the conversion service
		IData input = (IData) ValuesEmulator.get(pipeline, "xmlDataDocument");
		
		// Obtain an XmlDataCursor
		XmlDataCursor xdc = XmlData.getXmlDataCursor(input);
		// Position to the first only element, "employee"
		xdc.first();
		
		// Retrieve its value which is an employee Document
		IData empValue = (IData) xdc.getValue();
		// Obtain a cursor on the employee Document
		XmlDataCursor xdc2 = XmlData.getXmlDataCursor(empValue);
		
		// Position to the tag "name"
		xdc2.first(new XmlDataElementTag("name"));
		// Retrieve the STring value
		String nameValue = (String) xdc2.getValue();
		
		// Put the retrieved name value into the pipeline
		ValuesEmulator.put(pipeline, "result", nameValue);
		// Release resources
		xdc.destroy();
		xdc2.destroy();	
			
		// --- <<IS-END>> ---

                
	}
}

