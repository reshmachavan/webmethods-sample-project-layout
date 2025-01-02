package xmldatasamples;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.ns.XmlDataWorkspace;
import com.wm.xmldata.*;
import com.wm.xmldata.xmldocumenttype.*;
import com.wm.lang.ns.NSNode;
import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSRecord;
import com.wm.app.b2b.server.ns.Namespace;
// --- <<IS-END-IMPORTS>> ---

public final class types

{
	// ---( internal utility methods )---

	final static types _instance = new types();

	static types _newInstance() { return new types(); }

	static types _cast(Object o) { return (types)o; }

	// ---( server methods )---




	public static final void first (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(first)>> ---
		// @sigtype java 3.5
		// Create the workspace
		XmlDataWorkspace ws = XmlDataWorkspace.getTempWorkspace();
		
		// For convenience, create the root tag once
		XmlDataElementTag rootTag = new XmlDataElementTag("top", "xyz");
		
		// populate the workspace with an element definition
		ws.element(
			rootTag,
			ws.complexType(
				ws.sequence(
					ws.element(new XmlDataElementTag("a"), null, 1, 1),
					ws.element(new XmlDataElementTag("b", "xyz"), null, 1, 1),
					ws.element(new XmlDataElementTag("c", "xyz"), null, 1, 1)
				),
				null 
			)
		);
		
		// create the root wrapper for the root element 
		ws.wrapper(rootTag, false); 
		
		// create the top-level output
		IData out = XmlData.createGroupValue();
		// fetch the NSRecord that defines the output (a group with the single root element)
		NSRecord rootRec = (NSRecord) ws.getWrapper(rootTag);
		// create the map association between the new group value and the NSRecord that describes it
		XmlDataMap map = XmlDataMap.create(out, (NSRecord) rootRec);
		// map the only child
		map.map(rootTag);
		// set a value
		map.setValue(new XmlDataElementTag("a"), "999");
		// set another value
		map.setValue(new XmlDataElementTag("c", "xyz"), "111");
		// commit the change
		map.parent();		
		ValuesEmulator.put(pipeline, "answer", out);			
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

