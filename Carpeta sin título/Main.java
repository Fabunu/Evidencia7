import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creación de pasaportes
        Pasaporte pasaporte1 = new Pasaporte(123, "Chilena", 5, LocalDate.of(2025, 12, 31));
        Pasaporte pasaporte2 = new Pasaporte(456, "Peruana", 3, LocalDate.of(2025, 7, 15));
        Pasaporte pasaporte3 = new Pasaporte(789, "Chilena", 8, LocalDate.of(2024, 11, 20));
        Pasaporte pasaporte4 = new Pasaporte(209, "Chilena", 2, LocalDate.of(2023, 12, 20));
        Pasaporte pasaporte5 = new Pasaporte(700, "Chilena", 7, LocalDate.of(2025, 7, 13));
        Pasaporte pasaporte6 = new Pasaporte(701, "Chilena", 4, LocalDate.of(2025, 8, 13));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Creación de personas (piloto y pasajeros)");
        
        // Creación de personas (piloto y pasajeros)
        Piloto piloto = new Piloto("Juan", "Sanchez", pasaporte1, "LIC123");
        Pasajero pasajero1 = new Pasajero("Luis", "Zamora", pasaporte2, 15);
        Pasajero pasajero2 = new Pasajero("Felicia", "Garcia", pasaporte3, 20);
        Pasajero pasajero3 = new Pasajero("Mario", "Santibañez", pasaporte4, 12);
        Pasajero pasajero4 = new Pasajero("Miriam", "Torres", pasaporte5, 6);
        System.out.println("---------------------------------------------------------------------");

        // Creación de vuelo
        System.out.println("Creación de vuelos");
        Vuelo vuelo1 = new Vuelo(101, "New York", "Los Angeles", LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 16));
        vuelo1.registrarPiloto(piloto);
        vuelo1.registrarPasajero(pasajero1);
        vuelo1.registrarPasajero(pasajero2);
        vuelo1.registrarPasajero(pasajero3);
        vuelo1.registrarPasajero(pasajero4);
        System.out.println("---------------------------------------------------------------------");

        // Creación de avión
        System.out.println("Creación de aviones");
        Avion avion1 = new Avion(1, "Boeing 747");
        avion1.agregarVuelo(vuelo1);
        System.out.println("---------------------------------------------------------------------");

        // Creación de aeropuerto
        System.out.println("Creación de aeropuerto");
        Aeropuerto aeropuerto = new Aeropuerto("JFK Airport", "New York");
        aeropuerto.registrarAvion(avion1);
        System.out.println("---------------------------------------------------------------------");

        // Buscar pasajeros por vuelo
        System.out.println("Buscando pasajeros por vuelo...");
        List<Persona> pasajerosVuelo = aeropuerto.buscarUsuariosPorVuelo(101);
        System.out.println("Usuarios en el vuelo 101: " + pasajerosVuelo.size());
        System.out.println("---------------------------------------------------------------------");

        // Mostrar detalles de los pasajeros
        System.out.println("Pasajeros en el vuelo 101:");
        for (Persona pasajero : pasajerosVuelo) {
            System.out.println("- " + pasajero.getNombreCompleto());
        }
        System.out.println("---------------------------------------------------------------------");

        // Cancelar pasajero
        System.out.println("Cancelando pasajero: " + pasajero3.getNombreCompleto());
        vuelo1.cancelarPasajero(pasajero3);
        System.out.println("---------------------------------------------------------------------");

        // Mostrar detalles del vuelo después de cancelar
        System.out.println("Detalles del vuelo después de la cancelación:");
        System.out.println(vuelo1.detallesVuelo());
        System.out.println("---------------------------------------------------------------------");

        // Modificar pasajero
        System.out.println("Modificando pasajero...");
        Pasajero pasajeroModificado = new Pasajero("Alonso", "Peral", pasaporte6, 15);
        vuelo1.modificarPasajero(15, pasajeroModificado);
        System.out.println("Pasajero modificado: " + pasajeroModificado.getNombreCompleto());
        System.out.println("---------------------------------------------------------------------");

        // Mostrar detalles del vuelo después de la modificación
        System.out.println("Detalles del vuelo después de la modificación:");
        System.out.println(vuelo1.detallesVuelo());
        System.out.println("---------------------------------------------------------------------");
    }
}
