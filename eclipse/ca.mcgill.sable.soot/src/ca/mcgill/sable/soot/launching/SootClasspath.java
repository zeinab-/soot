package ca.mcgill.sable.soot.launching;

import org.eclipse.core.runtime.*;
import org.eclipse.jdt.core.*;


/**
 * @author jlhotak
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class SootClasspath {

	private String jre_lib;
	private String soot_lib;
	private String jasmin_lib;
	private String dot = ".";
	private String separator = System.getProperty("path.separator");
	
	public SootClasspath() {	
	}
	
	public void initialize() {
		// local location of jre lib 
		setJre_lib(JavaCore.getClasspathVariable("JRE_LIB").toOSString());
		// external jars location - may need to change
		//System.out.println(JavaCore.getClasspathVariable("SOOT_LIB").toString());
		String external_jars_location = Platform.getLocation().removeLastSegments(2).toOSString();
		// location of soot classes
		setSoot_lib(external_jars_location+System.getProperty("file.separator")+"soot_dir"+System.getProperty("file.separator")+"classes");
		// location of jasmin classes
		setJasmin_lib(external_jars_location+System.getProperty("file.separator")+"jasminclasses-sable-1.2.jar");
	}
	
	public String getSootClasspath() {
		StringBuffer cp = new StringBuffer();
		cp.append(getJre_lib());
		cp.append(getSeparator());
		//cp.append(getSoot_lib());
		//cp.append(getSeparator());
		//cp.append(getJasmin_lib());
		//cp.append(getSeparator());
		cp.append(getDot());
		
		return cp.toString();
	}
	
	
	/**
	 * Returns the dot.
	 * @return String
	 */
	public String getDot() {
		return dot;
	}

	/**
	 * Returns the jasmin_lib.
	 * @return String
	 */
	public String getJasmin_lib() {
		return jasmin_lib;
	}

	/**
	 * Returns the jre_lib.
	 * @return String
	 */
	public String getJre_lib() {
		return jre_lib;
	}

	/**
	 * Returns the separator.
	 * @return String
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * Returns the soot_lib.
	 * @return String
	 */
	public String getSoot_lib() {
		return soot_lib;
	}

	/**
	 * Sets the dot.
	 * @param dot The dot to set
	 */
	public void setDot(String dot) {
		this.dot = dot;
	}

	/**
	 * Sets the jasmin_lib.
	 * @param jasmin_lib The jasmin_lib to set
	 */
	public void setJasmin_lib(String jasmin_lib) {
		this.jasmin_lib = jasmin_lib;
	}

	/**
	 * Sets the jre_lib.
	 * @param jre_lib The jre_lib to set
	 */
	public void setJre_lib(String jre_lib) {
		this.jre_lib = jre_lib;
	}

	/**
	 * Sets the separator.
	 * @param separator The separator to set
	 */
	public void setSeparator(String separator) {
		this.separator = separator;
	}

	/**
	 * Sets the soot_lib.
	 * @param soot_lib The soot_lib to set
	 */
	public void setSoot_lib(String soot_lib) {
		this.soot_lib = soot_lib;
	}

}