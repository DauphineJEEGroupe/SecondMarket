/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gnepa.rene.barou
 *
 */
public class UtilsDate {

	public static String toString(Date date) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormatter.format(date);

	}
}
