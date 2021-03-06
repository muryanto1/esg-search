/*******************************************************************************
 * Copyright (c) 2010 Earth System Grid Federation
 * ALL RIGHTS RESERVED. 
 * U.S. Government sponsorship acknowledged.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package esg.search.query.api;

import java.util.List;
import java.util.Map;

import esg.search.core.Record;

/**
 * Interface representing the output of a search operation,
 * composed of search results and facets.
 */
public interface SearchOutput {
	
	/**
	 * Getter method for the total number of results found.
	 * @return
	 */
	public int getCounts();

	/**
	 * Setter method for the total number of results found.
	 * @param counts
	 */
	public void setCounts(int counts);
	
	/**
	 * Getter method for the offset into the returned results.
	 * @return
	 */
	public int getOffset();
	
	/**
	 * Setter method for the offset into the returned results.
	 * @return
	 */
	public void setOffset(int offset);
	
	/**
	 * Method to return the results list.
	 * @return
	 */
	public List<Record> getResults();
	
	/**
	 * Method to return the facets map (indexed by facet key).
	 * indexed by key.
	 * @return
	 */
	public Map<String, Facet> getFacets();
	
	/**
	 * Method to add a single result to the list.
	 * @param record
	 */
	public void addResult(Record record) ;
	
	/**
	 * Method to remove a single result from the list.
	 * Note: Added primarily to filter results AFTER a query to solr
	 * (used for radius based-search)
	 * @param record
	 */
	public void removeResult(Record record);
	
	
	/**
	 * Method to add a facet to the map.
	 * @param key
	 * @param facet
	 */
	public void addFacet(String key, Facet facet);
	


}
