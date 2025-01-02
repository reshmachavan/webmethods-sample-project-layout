package xmldatasamples;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.xmldata.*;
// --- <<IS-END-IMPORTS>> ---

public final class namespaces

{
	// ---( internal utility methods )---

	final static namespaces _instance = new namespaces();

	static namespaces _newInstance() { return new namespaces(); }

	static namespaces _cast(Object o) { return (namespaces)o; }

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
		
		// Position to the "*group" tag 
		xdc2.first(new XmlDataGroupTag());
		
		// Fetch the choice group content
		IData choice = (IData)xdc2.getValue();
		
		// Get a cursor for the choice group
		XmlDataCursor xdc3 = XmlData.getXmlDataCursor(choice);
		xdc3.first();
		// Put the retrieved name and value into the pipeline
		ValuesEmulator.put(pipeline, "resultName", xdc3.getTag().toString());
		ValuesEmulator.put(pipeline, "resultValue", xdc3.getValue());
		// Release resources
		xdc.destroy();
		xdc2.destroy();	
			
		// --- <<IS-END>> ---

                
	}
}

