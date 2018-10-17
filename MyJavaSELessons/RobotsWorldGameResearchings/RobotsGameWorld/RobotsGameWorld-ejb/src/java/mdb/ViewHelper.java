/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;
//import org.apache.commons.lang.StringUtils;

import java.util.Iterator;

/**
 *
 * @author Victor
 */
public final class ViewHelper {

    private ViewHelper() {
    }

    public static String getValuesAsString() {
        StringBuffer buffer = new StringBuffer();
        Iterator iter = InMemoryStorage.getValues().iterator();
        while (iter.hasNext()) {
            buffer.append(iter.next());
            if (iter.hasNext()) {
                buffer.append("<br/>");
            }
        }
        return buffer.toString();
        //return StringUtils.join(InMemoryStorage.getValues(), "<br/>");
    }
}
