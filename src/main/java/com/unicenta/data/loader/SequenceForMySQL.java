//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta & previous Openbravo POS works
//    https://unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.unicenta.data.loader;

import com.unicenta.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class SequenceForMySQL extends BaseSentence {
    
    private BaseSentence sent1;
    private BaseSentence sent2;
    
    /** Creates a new instance of SequenceForMySQL
     * @param s
     * @param sSeqTable */
    public SequenceForMySQL(Session s, String sSeqTable) {
        
        sent1 = new StaticSentence(s, "UPDATE " + sSeqTable + " SET ID = LAST_INSERT_ID(ID + 1)");
        sent2 = new StaticSentence(s, "SELECT LAST_INSERT_ID()", null, SerializerReadInteger.INSTANCE);
    }
    
    /**
     * Get sequence from ticketsnum and update next by user or people
     *
     * @param s
     * @param sSeqTable
     * @param peopleId
     * @param code
     */
    public SequenceForMySQL(Session s, String sSeqTable, String peopleId, String code) {
            var query = "UPDATE " + sSeqTable + " "
                    + "SET ID = LAST_INSERT_ID(ID + 1) "
                    + "where people_id = '" + peopleId + "'"
                    + "and code = '" + code + "'";
            
            sent1 = new StaticSentence(s, query);
            sent2 = new StaticSentence(s, "SELECT LAST_INSERT_ID()", null, SerializerReadInteger.INSTANCE);
    }
    
    // Funciones de bajo nivel
        
    /**
     *
     * @param params
     * @return
     * @throws BasicException
     */
        public DataResultSet openExec(Object params) throws BasicException {        
        sent1.exec();
        return sent2.openExec(null);
    }   

    /**
     *
     * @return
     * @throws BasicException
     */
    public DataResultSet moreResults() throws BasicException {
        return sent2.moreResults();
    }

    /**
     *
     * @throws BasicException
     */
    public void closeExec() throws BasicException {
        sent2.closeExec();
    }
}
