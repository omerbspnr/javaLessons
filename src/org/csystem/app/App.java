/*
Başlamadan sor allocCapacity fonksiyonu null atama yapması gerekmiyor mu
??
 */

package org.csystem.app;


import org.csystem.collection.CSDArrayList;
import org.csystem.util.StringUtil;
import org.csystem.util.datetime.Time;

import java.util.*;

class App {

    public static void main(String [] args)
    {
        Time time = new Time.TimeBuilder()
                            .setMinute(55)
                            .build();

        System.out.println(time.toLongTimeString());

        Time time2 = new Time.TimeBuilder().setHour(23).build();
        System.out.println(time.toLongTimeString());
        System.out.println(time2.toLongTimeString());
    }
}
