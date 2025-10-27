package servicio;
import api.ApiMoneda;
import modelo.Moneda;

public class ConversorServicio {

    private final ApiMoneda api = new ApiMoneda();

    public double convertir(String desde, String hacia, double valor) throws Exception {
        if (valor <= 0) throw new IllegalArgumentException("Debe ser un Numero mayor que 0.");
        if (desde.equals(hacia)) throw new IllegalArgumentException("Debe seleccionar monedas/peso diferentes.");

        Moneda moneda = api.obtenerTasas(desde);
        Double tasa = moneda.getConversion_rates().get(hacia);

        if (tasa == null) throw new IllegalArgumentException("No se ha encontrado tasa de conversion para " + hacia);

        return valor * tasa;
    }
}