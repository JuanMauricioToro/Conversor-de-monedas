package ContenidoPrincipal;

import javax.swing.JOptionPane;

public class Principal {

	/*
	 * ICONOS JOptionPane.ERROR_MESSAGE -> 0 JOptionPane.INFORMATION_MESSAGE -> 1
	 * JOptionPane.WARNING_MESSAGE -> 2 JOptionPane.QUESTION_MESSAGE -> 3
	 * 
	 */

	public static void main(String[] args) {

		Principal ini = new Principal();

		ini.inicio();

	}
	
	
	//Inicializa la app y muestra las dos opciones para elegir: 1.Conversor monedas 2.Conversor Temperatura
	public void inicio() {

		// lista con las dos opciones
		String[] opciones = { "Conversor de Divisas", "Conversor de Temperatura" };

		// muestra las opciones y guarda la opcion elegida, guarda null si cancela
		String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menú", 1,
				null, opciones, opciones[0]);

		if (opcion == "Conversor de Divisas") {
			elegirMonedas(opcion);

		}
		if (opcion == "Conversor de Temperatura") {
			elegirTemperatura(opcion);

		}

	}

	//muestra las opciones de conversion de temperatura para elegir
	public void elegirTemperatura(String opcion) {

		if (opcion == null) {

			continuar();
		}

		if (opcion.equals("Conversor de Temperatura")) {
			String[] temperatura = { "De Celsius a Kelvin", "De Kelvin a Celsius", "De Fahrenheit a Celsius",
					"De Celsius a Fahrenheit", "De Fahrenheit a Kelvin", "De Kelvin a Fahrenheit" };

			String tempera = (String) JOptionPane.showInputDialog(null, "Elija la Temperatura que desea convertir",
					"Menú", 1, null, temperatura, temperatura[0]);

			ingresarTemperatura(tempera);
		}
	}
	
	//pide ingresar el valor de temperatura a convertir

	public void ingresarTemperatura(String temperatura) {

		if (temperatura == null) {

			continuar();
		} else {
			String valor = JOptionPane
					.showInputDialog("Ingresa la Temperatura " + temperatura + " que deseas convertir:");
			// Valida que el valor sea numerico
			if (validar(valor) & valor.length() != 0) {

				double val = Double.parseDouble(valor);

				convertirTemperatura(temperatura, val);
				continuar();

			} else {
				JOptionPane.showMessageDialog(null, "Ingrese un valor válido", "Error", JOptionPane.ERROR_MESSAGE);
				inicio();
			}
		}

	}

	
	//convierte el valor ingresado a la temperatura seleccionada
	public void convertirTemperatura(String temperatura, double valor) {

		double conversion = 0;
		String conversio;

		switch (temperatura) {
		case "De Celsius a Kelvin":

			conversion = valor + 273;
			conversio = String.format("%.2f", conversion);

			JOptionPane.showConfirmDialog(null, valor + " Celsius equivale a: " + conversio + " Kelvin", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Kelvin a Celsius":

			conversion = valor - 273;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, valor + " Kelvin equivale a: " + conversio + " Celsius ", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Fahrenheit a Celsius":

			conversion = (valor - 32) / 1.8;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, valor + " Fahrenheint equivale a: " + conversio + " Celsius ",
					"mensaje", JOptionPane.CLOSED_OPTION);
			break;

		case "De Celsius a Fahrenheit":

			conversion = (valor + 32) * 1.8;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, valor + " Celsius equivale a: " + conversio + " Fahrenheit ", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Fahrenheit a Kelvin":

			conversion = (5 / 9) * (valor - 32) + 273;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, valor + " Fahrenheit equivale a: " + conversio + " Kelvin ", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Kelvin a Fahrenheit":

			conversion = (9 / 5) * (valor - 273) + 32;
			conversio = String.format("%.2f", conversion);

			JOptionPane.showConfirmDialog(null, valor + " Kelvin equivale a: " + conversio + " Fahrenheit ", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		default:
			break;
		}

	}

	//muestra las opciones de conversion de moneda para elegir
	public void elegirMonedas(String opcion) {

		if (opcion == null) {

			continuar();
		}

		if (opcion.equals("Conversor de Divisas")) {

			String[] monedas = { "De pesos(COP) a Dólar", "De pesos(COP) a Euros", "De pesos(COP) a Libras",
					"De pesos(COP) a Yen", "De pesos(COP) a Won Coreano", "De Dólar a Pesos(COP)",
					"De Euros a Pesos(COP)", "De Libras a Pesos(COP)", "De Yen a Pesos(COP)",
					"De Won Coreano a Pesos(COP)" };

			String moneda = (String) JOptionPane.showInputDialog(null,
					"Elija la moneda a la que deseas convertir tu dinero", "Menú", 1, null, monedas, monedas[0]);

			ingresarValor(moneda);

		}
	}

	//muestra mensaje para continuar en el programa o finalizar
	public void continuar() {

		int resp = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Seleccione una opción",
				JOptionPane.YES_NO_OPTION);

		if (resp == 0) {

			inicio();
		} else {
			JOptionPane.showMessageDialog(null, "Programa Terminado");
			System.exit(0);
		}

	}

	//pide ingresar el valor de la moneda a convertir
	public void ingresarValor(String moneda) {

		if (moneda == null) {

			continuar();
		} else {
			String option = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:");
			// Valida que el valor sea numerico
			if (validar(option) & option.length() != 0) {

				double cantidad = Double.parseDouble(option);
				if (cantidad > 0) {

					convertirMoneda(moneda, cantidad);
					continuar();

				} else {
					JOptionPane.showMessageDialog(null, "Ingrese un valor válido", "Error", JOptionPane.ERROR_MESSAGE);
					inicio();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Ingrese un valor válido", "Error", JOptionPane.ERROR_MESSAGE);
				inicio();
			}
		}
	}

	//convierte el valor ingresado a la moneda seleccionada
	public void convertirMoneda(String moneda, double cantidad) {

		double conversion = 0;
		String conversio;

		switch (moneda) {
		case "De pesos(COP) a Dólar":

			conversion = cantidad / 4849.49;
			conversio = String.format("%.2f", conversion);

			JOptionPane.showConfirmDialog(null, "Tienes $" + conversio + " Dolares", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De pesos(COP) a Euros":

			conversion = cantidad / 5105.39;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, "Tienes $" + conversio + " Euros", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De pesos(COP) a Libras":

			conversion = cantidad / 5800.40;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, "Tienes $" + conversio + " Libras", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De pesos(COP) a Yen":

			conversion = cantidad / 35.46;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, "Tienes $" + conversio + " Yenes", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De pesos(COP) a Won Coreano":

			conversion = cantidad * 0.27;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, "Tienes $" + conversio + " Won Coreano", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Dólar a Pesos(COP)":

			conversion = cantidad * 4849.65;
			conversio = String.format("%.2f", conversion);

			JOptionPane.showConfirmDialog(null, "Tienes $ " + conversio + " Pesos(COP)", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Euros a Pesos(COP)":

			conversion = cantidad * 5123.04;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, "Tienes $ " + conversio + " Pesos(COP)", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Libras a Pesos(COP)":

			conversion = cantidad * 5806.96;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, "Tienes $ " + conversio + " Pesos(COP)", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Yen a Pesos(COP)":

			conversion = cantidad * 35.58;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, "Tienes $ " + conversio + " Pesos(COP)", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		case "De Won Coreano a Pesos(COP)":

			conversion = cantidad * 3.69;
			conversio = String.format("%.2f", conversion);
			JOptionPane.showConfirmDialog(null, "Tienes $ " + conversio + " Pesos(COP)", "mensaje",
					JOptionPane.CLOSED_OPTION);
			break;

		default:
			break;
		}

	}

	//valida si una cadena de string trae un valor numerico
	public boolean validar(String cadena) {
		if (cadena.matches("[0-9]*")) {
			return true;
		} else {
			return false;
		}
	}
}
