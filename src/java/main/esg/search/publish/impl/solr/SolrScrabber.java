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
package esg.search.publish.impl.solr;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import esg.search.core.Record;
import esg.search.publish.api.RecordConsumer;

/**
 * Implementation of {@link RecordConsumer} that sends (skeleton) records to a Solr server for removal.
 */
@Component("scrabber")
public class SolrScrabber implements RecordConsumer {
    
    // client object that sends XML requests to Solr server
    final SolrClient solrClient;
						
	/**
	 * Constructor delegates to superclass.
	 * @param url
	 */
	@Autowired
	public SolrScrabber(final @Value("${esg.search.solr.publish.url}") URL url) {
	    solrClient = new SolrClient(url);
	}

	/**
	 * {@inheritDoc}
	 */
	public void consume(final Record record) throws Exception {
		
	    solrClient.delete( Arrays.asList( new String[]{record.getId()} ) );
		
	}
	
	
	/**
     * {@inheritDoc}
     */
    public void consume(final Collection<Record> records) throws Exception {
        
        List<String> ids = new ArrayList<String>();
        for (final Record record : records) {
            ids.add(record.getId());
        }
        solrClient.delete(ids);
        
    }

}
