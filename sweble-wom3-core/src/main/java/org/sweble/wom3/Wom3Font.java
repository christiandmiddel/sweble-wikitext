/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 */
package org.sweble.wom3;

/**
 * Specifies the font color, font face and size of the text content.
 * 
 * Corresponds to the XHTML 1.0 Transitional element "font".
 * 
 * <b>Child elements:</b> Mixed, [Inline elements]*
 */
public interface Wom3Font
		extends
			Wom3ElementNode,
			Wom3CoreAttributes,
			Wom3I18nAttributes
{
	/**
	 * Get the color of the text content.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "color".
	 * 
	 * @return The text color or <code>null</code> if the attribute is not
	 *         specified.
	 */
	public Wom3Color getColor();
	
	/**
	 * Set the color of the text content.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "color".
	 * 
	 * @param color
	 *            The new color of the text content or <code>null</code> to
	 *            remove the attribute.
	 * @return The old color of the text content.
	 */
	public Wom3Color setColor(Wom3Color color);
	
	/**
	 * Get the name of the font face of the text content.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "face".
	 * 
	 * @return The name of the font face or <code>null</code> if the attribute
	 *         is not specified.
	 */
	public String getFace();
	
	/**
	 * Set the name of the font face.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "face".
	 * 
	 * @param face
	 *            The name of the new font face.
	 * @return The name of the old font face.
	 */
	public String setFace(String face);
	
	/**
	 * Get the size of the text content.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "size".
	 * 
	 * @return The size of the text content. A value between 1 and 7.
	 */
	public Integer getSize();
	
	/**
	 * Set the text size.
	 * 
	 * Corresponds to the XHTML 1.0 Transitional attribute "size".
	 * 
	 * @param size
	 *            The new text size. A value between 1 and 7.
	 * @return The old text size.
	 */
	public Integer setSize(Integer size);
}
