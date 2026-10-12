package Ejercicio13_stockPrenda;

public class Main {
    public static void main(String[] args) {
        Prenda remera = new Prenda("Remera básica", 18000.0);

        remera.agregarStock("S", 10);
        remera.agregarStock("M", 15);
        remera.agregarStock("L", 8);
        System.out.println("Agregar al talle XXL: " + (remera.agregarStock("XXL", 5) ? "OK" : "RECHAZADO (talle inexistente)"));

        System.out.println("Vender 5 de M: " + (remera.vender("M", 5) ? "OK" : "RECHAZADA"));
        System.out.println("Vender 20 de L: " + (remera.vender("L", 20) ? "OK" : "RECHAZADA (stock insuficiente)"));
        System.out.println("Stock del talle XL: " + remera.consultarStock("XL"));
        System.out.println("Stock del talle XXL: " + remera.consultarStock("XXL") + " (-1 = talle inexistente)");

        remera.mostrarInventario();
    }
}
