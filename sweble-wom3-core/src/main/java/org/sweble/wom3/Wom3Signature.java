/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 */
package org.sweble.wom3;

import org.joda.time.DateTime;

/**
 * A Wikitext signature.
 * 
 * Corresponds to the XWML 1.0 element "signature".
 * 
 * <b>Child elements:</b> -
 */
public interface Wom3Signature
		extends
			Wom3ElementNode
{
	/**
	 * Get the signature format that describes how the signature should be
	 * rendered.
	 * 
	 * Corresponds to the XWML 1.0 attribute "format".
	 * 
	 * @return The signature format.
	 */
	public Wom3SignatureFormat getSignatureFormat();
	
	/**
	 * Set the signature format that describes how the signature should be
	 * rendered.
	 * 
	 * Corresponds to the XWML 1.0 attribute "format".
	 * 
	 * @param format
	 *            The new signature format.
	 * @return The old signature format.
	 * @throws NullPointerException
	 *             Thrown if <code>null</code> is given as format.
	 */
	public Wom3SignatureFormat setSignatureFormat(Wom3SignatureFormat format) throws NullPointerException;
	
	/**
	 * Get the name of the author.
	 * 
	 * Corresponds to the XWML 1.0 attribute "author".
	 * 
	 * @return The author name.
	 */
	public String getAuthor();
	
	/**
	 * Set the author name.
	 * 
	 * Corresponds to the XWML 1.0 attribute "author".
	 * 
	 * @param author
	 *            The new name of the author.
	 * @return The old author name.
	 * @throws IllegalArgumentException
	 *             Thrown if the given author name is not a valid MediaWiki user
	 *             name.
	 * @throws NullPointerException
	 *             Thrown if <code>null</code> is given as format.
	 */
	public String setAuthor(String author) throws IllegalArgumentException, NullPointerException;
	
	/**
	 * Get the date and time of the signature.
	 * 
	 * Corresponds to the XWML 1.0 attribute "timestamp".
	 * 
	 * @return The date and time of the signature.
	 */
	public DateTime getTimestamp();
	
	/**
	 * Set the date and time of the signature.
	 * 
	 * Corresponds to the XWML 1.0 attribute "timestamp".
	 * 
	 * @param timestamp
	 *            The new date and time of the signature.
	 * @return The old date and time of the signature.
	 * @throws NullPointerException
	 *             Thrown if <code>null</code> is given as format.
	 */
	public DateTime setTimestamp(DateTime timestamp) throws NullPointerException;
}
