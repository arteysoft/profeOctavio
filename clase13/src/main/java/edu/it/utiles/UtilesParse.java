package edu.it.utiles;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import edu.it.dto.UriID;
import edu.it.enumerados.TipoDeGet;
import edu.it.errores.BadRequestException;

public class UtilesParse {
	private static Logger logger = Logger.getLogger("UtilesParse");

	public static void obtenerMetadataConsulta(String uri) {
		logger.info("Este metodo se va a encargar de brindar info");
		logger.info("Si viene params o viene path");
	}
	public static TipoDeGet obtenerTipoDeGet(String uri) {
		try {
			System.out.println(uri);
			uri = uri.substring(1);
			String[] arr = uri.split("/");
			if (arr.length > 1) {
				return TipoDeGet.POR_ID;
			}
			return TipoDeGet.QUERY_STRING;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new BadRequestException("Mal formateado");
		}
	}
	public static UriID separarUriDeId(String uri) {
		try {
			logger.debug("separar uri del id");
			logger.debug(uri);
			uri = uri.substring(1);
			String[] arr = uri.split("/");
			logger.debug("split... ");
			for (String s : arr) {
				logger.debug("  " + s);
			}
			if (arr.length == 1) {
				return new UriID(arr[0], arr[0]);
			}
			List<String> lstStr = Arrays.asList(arr);
			lstStr = lstStr.subList(0, lstStr.size()-1);
			return new UriID(String.join("/", lstStr), arr[arr.length-1]);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new BadRequestException("Mal formateado");
		}
	}
}
