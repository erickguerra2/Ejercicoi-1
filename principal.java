package Ejercicio_Tylor;
import java.util.Scanner;
import java.util.Random;

public class principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comprador comprador = null;
        Localidad localidad1 = new Localidad("Localidad 1", 100, 20);
        Localidad localidad5 = new Localidad("Localidad 5", 500, 20);
        Localidad localidad10 = new Localidad("Localidad 10", 1000, 20);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); 
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese su email: ");
                    String email = scanner.nextLine();
                    System.out.print("Ingrese su presupuesto maximo: ");
                    int presupuesto = scanner.nextInt();
                    comprador = new Comprador(nombre, email, presupuesto);
                    System.out.println("registrado exitosamente.");
                    break;
                case 2:
                    if (comprador == null) {
                        System.out.println("Aun no hay un comprador");
                        break;
                    }
                    System.out.print("Cantidad de boletos: ");
                    int cantidadBoletos = scanner.nextInt();
                    if (cantidadBoletos <= 0) {
                        System.out.println("La cantidad debe ser mayor a 0");
                        break;
                    }            
                    Random random = new Random();
                    int solicitud = random.nextInt(15000) + 1;
                    int lim_inf = random.nextInt(15000) + 1;
                    int lim_sup = random.nextInt(15000) + 1;
                    boolean solicitudApto = (solicitud >= Math.min(lim_inf, lim_sup) && solicitud <= Math.max(lim_inf,lim_sup));
                    if (solicitudApto) {
                        System.out.println("El solicitud " + solicitud + " es apto para compra.");
                        Random randomLocalidad = new Random();
                        int seleccionLocalidad = randomLocalidad.nextInt(3) + 1; // 1, 2 o 3
                        Localidad localidadSeleccionada = null;
                        switch (seleccionLocalidad) {
                            case 1:
                                localidadSeleccionada = localidad1;
                                break;
                            case 2:
                                localidadSeleccionada = localidad5;
                                break;
                            case 3:
                                localidadSeleccionada = localidad10;
                                break;
                            default:
                                System.out.println("Error en la selección de localidad.");
                        }
                        if (localidadSeleccionada != null) {
                            int boletosDisponibles = localidadSeleccionada.getBoletosDisponibles();
                            int boletosAVender = Math.min(cantidadBoletos, boletosDisponibles);
                            int precioTotal = boletosAVender * localidadSeleccionada.getPrecio();
                            if (precioTotal > comprador.getpresupuesto()) {
                                System.out.println("El precio total excede el presupuesto del comprador. Compra cancelada.");
                            } else {
                                localidadSeleccionada.venderBoletos(boletosAVender);
                                System.out.println("Compra exitosa: " + boletosAVender + " boletos en " + localidadSeleccionada.getNombre() + " por $" + precioTotal);
                            }
                        }
                    } else {
                        System.out.println("El solicitud " + solicitud + " no es apto para compra.");
                    }
                    break;
                case 3:
                    System.out.println("Disponibilidad total:");
                    System.out.println(localidad1.getNombre() + ": Vendidos " + localidad1.getBoletosVendidos() + ", Disponibles " + localidad1.getBoletosDisponibles());
                    System.out.println(localidad5.getNombre() + ": Vendidos " + localidad5.getBoletosVendidos() + ", Disponibles " + localidad5.getBoletosDisponibles());
                    System.out.println(localidad10.getNombre() + ": Vendidos " + localidad10.getBoletosVendidos() + ", Disponibles " + localidad10.getBoletosDisponibles());
                    break;
                case 4:
                    System.out.println("Seleccione una localidad para consultar disponibilidad (1: Localidad 1, 2: Localidad 5, 3: Localidad 10): ");
                    int seleccionLocalidad = scanner.nextInt();
                    Localidad localidadSeleccionada = null;
                    switch (seleccionLocalidad) {
                        case 1:
                            localidadSeleccionada = localidad1;
                            break;
                        case 2:
                            localidadSeleccionada = localidad5;
                            break;
                        case 3:
                            localidadSeleccionada = localidad10;
                            break;
                        default:
                            System.out.println("Selección inválida.");
                    }
                    if (localidadSeleccionada != null) {
                        System.out.println("Disponibilidad en " + localidadSeleccionada.getNombre() + ": " + localidadSeleccionada.getBoletosDisponibles() + " boletos disponibles.");
                    }
                    break;
                case 5:
                    int ingresosTotales = (localidad1.getBoletosVendidos() * localidad1.getPrecio()) +
                                         (localidad5.getBoletosVendidos() * localidad5.getPrecio()) +
                                         (localidad10.getBoletosVendidos() * localidad10.getPrecio());
                    System.out.println("Reporte de caja: Ingresos totales $" + ingresosTotales);
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}