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

public final class map

{
	// ---( internal utility methods )---

	final static map _instance = new map();

	static map _newInstance() { return new map(); }

	static map _cast(Object o) { return (map)o; }

	// ---( server methods )---




	public static final void first (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(first)>> ---
		// @sigtype java 3.5
		// Retrieve the XmlData output from the conversion service
		IData input = (IData) ValuesEmulator.get(pipeline, "xmlDataDocument");
		// create a buffer for console output
		StringBuilder sb = new StringBuilder();
		
		// Find the NSRecord
		XmlDataWorkspace ws = XmlDataWorkspace.getServerWorkspace();
		ws.setFolder("xmldatasamples.map");
		NSField rec = ws.getWrapper(new XmlDataElementTag("alpha", "sampleMaps"));
		// Position to the first and only element, "root"
		XmlDataMap map = XmlDataMap.create(input, (NSRecord) rec);
		 
		Object answer = map.getValue(new XmlDataElementTag("alpha", "sampleMaps"));
		ValuesEmulator.put(pipeline, "answer", answer);
		
		map.map(new XmlDataElementTag("alpha", "sampleMaps")); 
		ValuesEmulator.put(pipeline, "answer2", map.getValue(new XmlDataElementTag("one", "sampleMaps")));
		map.map(new XmlDataElementTag("three", "sampleMaps"));
		ValuesEmulator.put(pipeline, "answer3", map.getValue(new XmlDataElementTag("baker", "sampleMaps")));
		map.parent();		
		ValuesEmulator.put(pipeline, "answer4", map.getValue(new XmlDataElementTag("two", "sampleMaps")));			
		// --- <<IS-END>> ---

                
	}



	public static final void second (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(second)>> ---
		// @sigtype java 3.5
		// Retrieve the XmlData output from the conversion service
		IData input = (IData) ValuesEmulator.get(pipeline, "xmlDataDocument");
		// create a buffer for console output
		StringBuilder sb = new StringBuilder();
		
		// Obtain an XmlDataTreeCursor
		XmlDataTreeCursor xdc = XmlData.getXmlDataTreeCursor(input);
		
		// iterate over items
		while(xdc.nextInOrder() != null) 
			sb.append(xdc.getTag().toString() + " " + xdc.currentIndex()  + "\n");
		sb.append("\n");
		
		ValuesEmulator.put(pipeline, "console", sb.toString());
		
		// Release resources
		xdc.destroy();
		
			
		// --- <<IS-END>> ---

                
	}
}

