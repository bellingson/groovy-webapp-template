package com.myapp.util

class StringUtil {

    static String delimit(Collection items) {
        StringBuffer s = new StringBuffer()
        Iterator i = items.iterator()
        while(i.hasNext()) {
            s.append(i.next())
            if(i.hasNext())
                s.append(",")
        }

        return s.toString()
    }

}
