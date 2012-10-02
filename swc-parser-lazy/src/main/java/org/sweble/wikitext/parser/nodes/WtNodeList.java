package org.sweble.wikitext.parser.nodes;

import java.util.Collection;

import xtc.util.Pair;
import de.fau.cs.osr.ptk.common.ast.GenericNodeList;
import de.fau.cs.osr.ptk.common.ast.RtData;

public class WtNodeList
		extends
			GenericNodeList<WtNode>
		implements
			WtNode
{
	
	private static final long serialVersionUID = 6285729315278264384L;
	
	// =========================================================================
	
	public WtNodeList()
	{
		super();
	}
	
	public WtNodeList(Collection<? extends WtNode> list)
	{
		super(list);
	}
	
	public WtNodeList(Pair<? extends WtNode> list)
	{
		super(list);
	}
	
	public WtNodeList(WtNode car, Pair<? extends WtNode> cdr)
	{
		super(car, cdr);
	}
	
	public WtNodeList(WtNode a, WtNode b, WtNode c, WtNode d)
	{
		super(a, b, c, d);
	}
	
	public WtNodeList(WtNode a, WtNode b, WtNode c)
	{
		super(a, b, c);
	}
	
	public WtNodeList(WtNode a, WtNode b)
	{
		super(a, b);
	}
	
	public WtNodeList(WtNode... children)
	{
		super(children);
	}
	
	public WtNodeList(WtNode child)
	{
		super(child);
	}
	
	// =========================================================================
	
	@Override
	public RtData setRtd(RtData rtd)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public RtData setRtd(Object... glue)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public RtData setRtd(String... glue)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public RtData getRtd()
	{
		throw null;
	}
	
	@Override
	public void clearRtd()
	{
	}
	
}