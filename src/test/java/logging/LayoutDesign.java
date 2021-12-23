package logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;

public class LayoutDesign extends LayoutBase<ILoggingEvent> {

	DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
	
	public String doLayout(ILoggingEvent event) {
		StringBuffer sbuf = new StringBuffer(128);
		sbuf.append("---USER LOG---");
		sbuf.append(" ");
	    sbuf.append(dformat.format(new Date(event.getTimeStamp())));
	    sbuf.append(" ");
	    sbuf.append(event.getLevel());
	    sbuf.append(" [");
	    sbuf.append(event.getThreadName());
	    sbuf.append("] ");
	    sbuf.append(event.getLoggerName());
	    sbuf.append(" - ");
	    sbuf.append(event.getMessage());
	    sbuf.append(CoreConstants.LINE_SEPARATOR);
	    return sbuf.toString();
	}
	
	
}
