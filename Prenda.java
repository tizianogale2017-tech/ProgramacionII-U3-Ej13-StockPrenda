package Ejercicio13_stockPrenda;

import java.util.LinkedHashMap;
import java.util.Map;

public class Prenda {
    private String modelo;
    private double precio;
    private Map<String, Integer> stockPorTalle = new LinkedHashMap<>();

    public Prenda(String modelo, double precio) {
        this.modelo = modelo;
        this.precio = precio;
        stockPorTalle.put("S", 0);
        stockPorTalle.put("M", 0);
        stockPorTalle.put("L", 0);
        stockPorTalle.put("XL", 0);
    }

    public int consultarStock(String talle) {
        if (!stockPorTalle.containsKey(talle)) {
            return -1;
        }
        return stockPorTalle.get(talle);
    }

    public boolean agregarStock(String talle, int cantidad) {
        if (!stockPorTalle.containsKey(talle) || cantidad <= 0) {
            return false;
        }
        stockPorTalle.put(talle, stockPorTalle.get(talle) + cantidad);
        return true;
    }

    public boolean vender(String talle, int cantidad) {
        if (!stockPorTalle.containsKey(talle) || cantidad <= 0) {
            return false;
        }
        int disponible = stockPorTalle.get(talle);
        if (cantidad > disponible) {
            return false;
        }
        stockPorTalle.put(talle, disponible - cantidad);
        return true;
    }

    public void mostrarInventario() {
        System.out.println("Inventario de " + modelo + " ($" + precio + "):");
        for (Map.Entry<String, Integer> e : stockPorTalle.entrySet()) {
            System.out.println("  Talle " + e.getKey() + ": " + e.getValue() + " unidades");
        }
    }
}
