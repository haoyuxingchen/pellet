// Copyright (c) 2006 - 2008, Clark & Parsia, LLC. <http://www.clarkparsia.com>
// This source code is available under the terms of the Affero General Public License v3.
//
// Please see LICENSE.txt for full license terms, including the availability of proprietary exceptions.
// Questions, comments, or requests for clarification: licensing@clarkparsia.com

package com.clarkparsia.pellet.rules.rete;

import java.util.logging.Level;

/**
 */
public class BetaTopNode extends BetaNode {
	private final AlphaNode alpha;

	public BetaTopNode(AlphaNode alpha) {
		this.alpha = alpha;
	}
	
	public AlphaNode getAlphaNode() {
		return alpha;
	}
	
	public boolean isTop() {
		return true;
	}
	
	@Override
	public void activate(WME wme) {
		if (log.isLoggable(Level.FINE)) {
			log.fine("Activate beta " + wme);
		}
		
		activateChildren(wme, null);
	}
	
	@Override
	public void activate(Token token) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void print(String indent) {
		System.out.print(indent);
		System.out.println(alpha);
		indent += "  ";
		System.out.print(indent);
		System.out.println(this);
		for (BetaNode node : getBetas()) {
	        node.print(indent);
        }
	}
	
	public String toString() {
		return "Top";
	}
}
