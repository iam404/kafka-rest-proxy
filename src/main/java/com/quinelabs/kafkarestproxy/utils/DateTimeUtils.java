package com.quinelabs.kafkarestproxy.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  @author mail@prabuddha.me
 *  on 28/01/18.
 */
public class DateTimeUtils {

  public static String getCurrentTimeString() {
    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("hh.mm.ss");
    return sdf.format(date);
  }

  public static String getCurrentDateString() {
    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    return sdf.format(date);
  }

  public static String getCurrentTimeStampString() {
    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS");
    return sdf.format(date);
  }

}
