/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 */
package org.sweble.wom3.impl;

import org.sweble.wom3.Wom3Node;
import org.sweble.wom3.Wom3Redirect;
import org.sweble.wom3.Wom3Title;

public class RedirectImpl
		extends
			BackboneWomElement
		implements
			Wom3Redirect
{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	public RedirectImpl(DocumentImpl owner)
	{
		super(owner);
		setTarget("unknown");
	}
	
	// =========================================================================
	
	@Override
	public String getWomName()
	{
		return "redirect";
	}
	
	// =========================================================================
	
	@Override
	public String getDisplacementId()
	{
		return getStringAttr("did");
	}
	
	@Override
	public String setDisplacementId(String did)
	{
		return setStringAttr(Attributes.DID, "did", did);
	}
	
	@Override
	public String getTarget()
	{
		return getAttribute("target");
	}
	
	@Override
	public String setTarget(String page)
	{
		return setAttributeDirect(Attributes.TARGET, "target", page);
	}
	
	@Override
	public Wom3Title getLinkTitle()
	{
		// TODO: Implement
		throw new UnsupportedOperationException();
		
		/*
		return EmptyTitleImpl.get();
		*/
	}
	
	@Override
	public String getLinkTarget()
	{
		return getTarget();
	}
	
	// =========================================================================
	
	@Override
	protected AttributeDescriptor getAttributeDescriptor(
			String namespaceUri,
			String localName,
			String qualifiedName)
	{
		return getAttrDescStrict(namespaceUri, localName, qualifiedName,
				"target", Attributes.TARGET,
				"did", Attributes.DID);
	}
	
	protected static enum Attributes implements AttributeDescriptor
	{
		TARGET
		{
			@Override
			public boolean verifyAndConvert(
					Backbone parent,
					NativeAndStringValuePair verified)
			{
				if (verified.strValue == null)
					verified.strValue = (String) verified.value;
				
				Toolbox.checkValidTarget(verified.strValue);
				return true;
			}
		},
		DID
		{
			@Override
			public boolean verifyAndConvert(
					Backbone parent,
					NativeAndStringValuePair verified)
			{
				return AttributeVerifiers.ID.verifyAndConvert(parent, verified);
			}
			
			@Override
			public boolean isRemovable()
			{
				return true;
			}
		};
		
		// =====================================================================
		
		@Override
		public boolean isRemovable()
		{
			return false;
		}
		
		@Override
		public Normalization getNormalizationMode()
		{
			return Normalization.CDATA;
		}
		
		@Override
		public void customAction(
				Wom3Node parent,
				AttributeBase oldAttr,
				AttributeBase newAttr)
		{
		}
	}
}
