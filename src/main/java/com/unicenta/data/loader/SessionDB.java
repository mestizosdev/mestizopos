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

/**
 *
 * @author adrianromero
 */
public interface SessionDB {

    /**
     *
     * @return
     */
    public String TRUE();

    /**
     *
     * @return
     */
    public String FALSE();

    /**
     *
     * @return
     */
    public String INTEGER_NULL();

    /**
     *
     * @return
     */
    public String CHAR_NULL();

    /**
     *
     * @return
     */
    public String getName();

    /**
     * Get sequence from ticketsnum by user or people
     * @param s
     * @param sequence
     * @param peopleId
     * @param code
     * @return 
     */
    public SentenceFind getSequenceSentence(Session s, String sequence, String peopleId, String code);

    
    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceFind getSequenceSentence(Session s, String sequence);

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceFind resetSequenceSentence(Session s, String sequence);
    
}


