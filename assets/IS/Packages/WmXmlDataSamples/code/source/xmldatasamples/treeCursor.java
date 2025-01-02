package xmldatasamples;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.xmldata.*;
import com.wm.lang.ns.NSNode;
import com.wm.app.b2b.server.ns.Namespace;
// --- <<IS-END-IMPORTS>> ---

public final class treeCursor

{
	// ---( internal utility methods )---

	final static treeCursor _instance = new treeCursor();

	static treeCursor _newInstance() { return new treeCursor(); }

	static treeCursor _cast(Object o) { return (treeCursor)o; }

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
		
		// Obtain an XmlDataTreeCursor
		XmlDataTreeCursor xdc = XmlData.getXmlDataTreeCursor(input);
		// Position to the first and only element, "root"
		xdc.first();
		// position on the first child
		xdc.firstChild();
		
		// iterate over items
		sb.append(xdc.getTag().toString() + " " + xdc.getValue() + "\n");
		while(xdc.nextItem()) 
			sb.append(xdc.getTag().toString() + " " + xdc.getValue() + "\n");
		sb.append("\n");
		
		// position on first object again
		// iterate again using the XmlDataCursor methods
		xdc.first();
		sb.append(xdc.getTag().toString() + " " + xdc.getObject() + "\n");
		while(xdc.next()) 
			sb.append(xdc.getTag().toString() + " " + xdc.getObject() + "\n");
		ValuesEmulator.put(pipeline, "console", sb.toString());
		
		// Release resources
		xdc.destroy();
		
			
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
		Integer change;
		while((change = xdc.nextInOrder()) != null) 
			sb.append(xdc.getTag().toString() + "  index=" + xdc.currentIndex() + "  change=" + change + "  paricleId=" + xdc.getTag().getParticleId() + "\n");
		
		ValuesEmulator.put(pipeline, "console", sb.toString());
		
		// Release resources
		xdc.destroy();
		
			
		// --- <<IS-END>> ---

                
	}
}

