package xmldatasamples;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.xmldata.*;
// --- <<IS-END-IMPORTS>> ---

public final class anyWildcard

{
	// ---( internal utility methods )---

	final static anyWildcard _instance = new anyWildcard();

	static anyWildcard _newInstance() { return new anyWildcard(); }

	static anyWildcard _cast(Object o) { return (anyWildcard)o; }

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
		
		// Retrieve its value which is an employee Docume
		IData empValue = (IData) xdc.getValue();
		// Obtain a cursor on the employee Document
		XmlDataCursor xdc2 = XmlData.getXmlDataCursor(empValue);
		
		// Position to the "any" tag
		xdc2.first(new XmlDataAnyTag());
		
				
		// Put the retrieved name value into the pipeline
		ValuesEmulator.put(pipeline, "resultNme", xdc2.getValueTag(1).toString());
		ValuesEmulator.put(pipeline, "resulValue", xdc2.getValue(1));
		// Release resources
		xdc.destroy();
		xdc2.destroy();	
			
		// --- <<IS-END>> ---

                
	}
}

