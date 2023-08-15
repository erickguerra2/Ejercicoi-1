package Ejercicio_Tylor;
class Localidad {
    private String nombre;
    private int precio;
    private int totalBoletos;
    private int vendidos_localidad;

    public Localidad(String nombre, int precio, int totalBoletos) {
        this.nombre = nombre;
        this.precio = precio;
        this.totalBoletos = totalBoletos;
        this.vendidos_localidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int gettotalBoletos() {
        return totalBoletos;
    }

    public int getBoletosVendidos() {
        return vendidos_localidad;
    }

    public int getBoletosDisponibles() {
        return totalBoletos - vendidos_localidad;
    }

    public boolean venderBoletos(int cantidad) {
        if (vendidos_localidad + cantidad <= totalBoletos) {
            vendidos_localidad += cantidad;
            return true;
        }
        return false;
    }
}

class Comprador {
    private String nombre;
    private String email;
    private int presupuesto;

    public Comprador(String nombre, String email, int presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getpresupuesto() {
        return presupuesto;
    }
}


