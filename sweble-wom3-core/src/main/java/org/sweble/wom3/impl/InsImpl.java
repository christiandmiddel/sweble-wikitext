/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sweble.wom3.impl;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.sweble.wom3.Wom3Ins;
import org.sweble.wom3.Wom3Node;

public class InsImpl
		extends
			BackboneWomElemWithCoreAttrs
		implements
			Wom3Ins
{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	public InsImpl(DocumentImpl owner)
	{
		super(owner);
	}
	
	// =========================================================================
	
	@Override
	public String getWomName()
	{
		return "ins";
	}
	
	// =========================================================================
	
	@Override
	public URL getCite()
	{
		return getUrlAttr("cite");
	}
	
	@Override
	public URL setCite(URL url)
	{
		return setUrlAttr(Attributes.CITE, "cite", url);
	}
	
	@Override
	public DateTime getDatetime()
	{
		return setDatetimeAttr("datetime");
	}
	
	@Override
	public DateTime setDatetime(DateTime timestamp)
	{
		return setDatetimeAttr(Attributes.DATETIME, "datetime", timestamp);
	}
	
	// =========================================================================
	
	private static final Map<String, AttributeDescriptor> nameMap = getNameMap();
	
	private static Map<String, AttributeDescriptor> getNameMap()
	{
		Map<String, AttributeDescriptor> nameMap =
				new HashMap<String, AttributeDescriptor>();
		
		nameMap.putAll(UniversalAttributes.getNameMap());
		nameMap.put("cite", Attributes.CITE);
		nameMap.put("datetime", Attributes.DATETIME);
		
		return nameMap;
	}
	
	@Override
	protected AttributeDescriptor getAttributeDescriptor(
			String namespaceUri,
			String localName,
			String qualifiedName)
	{
		return getAttrDesc(namespaceUri, localName, qualifiedName, nameMap);
	}
	
	private static enum Attributes implements AttributeDescriptor
	{
		CITE
		{
			@Override
			public boolean verifyAndConvert(
					Backbone parent,
					NativeAndStringValuePair verified)
			{
				return AttributeVerifiers.URL.verifyAndConvert(parent, verified);
			}
		},
		DATETIME
		{
			@Override
			public boolean verifyAndConvert(
					Backbone parent,
					NativeAndStringValuePair verified)
			{
				return AttributeVerifiers.DATETIME.verifyAndConvert(parent, verified);
			}
		};
		
		// =====================================================================
		
		@Override
		public boolean isRemovable()
		{
			return true;
		}
		
		@Override
		public Normalization getNormalizationMode()
		{
			return Normalization.NON_CDATA;
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
