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

public final class path

{
	// ---( internal utility methods )---

	final static path _instance = new path();

	static path _newInstance() { return new path(); }

	static path _cast(Object o) { return (path)o; }

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
		ws.setFolder("xmldatasamples.path");
		NSField rec = ws.getWrapper(new XmlDataElementTag("alpha", "sampleMaps"));
		// Position to the first and only element, "root"
		XmlDataMap map = XmlDataMap.create(input, (NSRecord) rec);
		 
		map.map(new XmlDataContentTag[]{
				new XmlDataElementTag("alpha", "sampleMaps"), 
				new XmlDataElementTag("three", "sampleMaps"),
				new XmlDataElementTag("charlie", "sampleMaps") 
		});
		
		
		ValuesEmulator.put(pipeline, "answer", map.getValue(new XmlDataElementTag("quark", "sampleMaps")));			
		// --- <<IS-END>> ---

                
	}



	public static final void second (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(second)>> ---
		// @sigtype java 3.5
		// Retrieve the XmlData output from the conversion service
		IData input = (IData) ValuesEmulator.get(pipeline, "xmlDataDocument");
		
		// create the workspace
		XmlDataWorkspace ws = XmlDataWorkspace.getServerWorkspace();
		ws.setFolder("xmldatasamples.path");
		NSField rec = ws.getWrapper(new XmlDataElementTag("alpha", "sampleMaps"));
		// associate the XmlData infoset with the wrapper for the "alpha" root element
		XmlDataMap map = XmlDataMap.create(input, (NSRecord) rec);
		
		// Fetch a value using the script form of a Map Path
		Object o = map.getValue("{ns sampleMaps}/ns:alpha/ns:three/ns:charlie/ns:quark");
				
		// save the result to the pipeline		
		ValuesEmulator.put(pipeline, "answer", o);		
			
		// --- <<IS-END>> ---

                
	}
}

