package com.alee.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * This class provides a set of utilities to work with exceptions.
 * Some methods in this class are based on {@link https://commons.apache.org/} library sources.
 *
 * @author Mikle Garin
 */

public class ExceptionUtils
{
    /**
     * Returns the stack trace from a Throwable as a String.
     * <p/>
     * The result of this method vary by JDK version as this method uses {@link Throwable#printStackTrace(java.io.PrintWriter)}.
     * On JDK1.3 and earlier, the cause exception will not be shown unless the specified throwable alters printStackTrace.
     *
     * @param throwable the {@code Throwable} to be examined
     * @return the stack trace as generated by the exception's {@code printStackTrace(PrintWriter)} method
     */
    public static String getStackTrace ( final Throwable throwable )
    {
        final StringWriter sw = new StringWriter ();
        final PrintWriter pw = new PrintWriter ( sw, true );
        throwable.printStackTrace ( pw );
        return sw.getBuffer ().toString ();
    }
}