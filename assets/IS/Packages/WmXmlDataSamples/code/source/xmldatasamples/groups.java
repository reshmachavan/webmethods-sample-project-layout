package xmldatasamples;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.xmldata.*;
// --- <<IS-END-IMPORTS>> ---

public final class groups

{
	// ---( internal utility methods )---

	final static groups _instance = new groups();

	static groups _newInstance() { return new groups(); }

	static groups _cast(Object o) { return (groups)o; }

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
		
		// Position to the tag "{1}*group"
		xdc2.first(new XmlDataGroupTag());
		// Retrieve the STring value
		IData choiceGroup = (IData) xdc2.getValue();
		XmlDataCursor xdc3 = XmlData.getXmlDataCursor(choiceGroup);
		xdc3.first();
		
		// Put the retrieved name and value into the pipeline
		ValuesEmulator.put(pipeline, "resultName", xdc3.getTag().toString());
		ValuesEmulator.put(pipeline, "resultValue", xdc3.getValue());
		// Release resources
		xdc.destroy();
		xdc2.destroy();	
		xdc3.destroy();	
			
		// --- <<IS-END>> ---

                
	}
}

