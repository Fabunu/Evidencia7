import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Vuelo {
	private int numeroVuelo;
	private String ciudadOrigen;
	private String ciudadDestino;
	private LocalDate fechaLlegada;
	private LocalDate fechaSalida;
	private Piloto piloto;
	private List<Pasajero> listaPasajeros;
	private int capacidadMaxima;


    public Vuelo(int numeroVuelo, String ciudadOrigen, String ciudadDestino, LocalDate fechaLlegada, LocalDate fechaSalida) {
        this.numeroVuelo = numeroVuelo;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.listaPasajeros = new ArrayList<>();
		this.capacidadMaxima = 120;
    }


	public boolean registrarPasajero(Pasajero pasajero) {
        if (listaPasajeros.size() < capacidadMaxima) {
            if (pasajero.validarPasaporte()) {
                listaPasajeros.add(pasajero);
                System.out.println("Pasajero registrado con éxito.");
				return true;
            } else {
                System.out.println("El pasaporte del pasajero no es válido.");
				return false;
			}
        } else {
            System.out.println("El vuelo ha alcanzado su capacidad máxima.");
			return false;
		}
    }

	public void registrarPiloto(Piloto piloto) {
        this.piloto = piloto;
        System.out.println("Piloto registrado con éxito.");
    }
	
	public Piloto getPiloto() {
		return piloto;
	}

	public List<Pasajero> getListaPasajeros() {
		return new ArrayList<>(listaPasajeros);
	}

	public void cancelarPasajero(Pasajero pasajero) {
        if (listaPasajeros.remove(pasajero)) {
            System.out.println("El pasajero ha sido cancelado y se ha liberado un asiento.");
        } else {
            System.out.println("El pasajero no se encontró en la lista.");
        }
    }

	public void mostrarPasajeros() {
		System.out.println("Lista de pasajeros en el vuelo " + numeroVuelo + ":");
		for (Pasajero pasajero : listaPasajeros) {
			System.out.println(pasajero.getNombreCompleto() + " - Asiento: " + pasajero.getNumeroAsiento());
		}
	}

	public void modificarPasajero(int numeroAsiento, Pasajero pasajeroModificado) {
        for (int i = 0; i < listaPasajeros.size(); i++) {
            if (listaPasajeros.get(i).getNumeroAsiento() == numeroAsiento) {
                listaPasajeros.set(i, pasajeroModificado);
                System.out.println("Pasajero modificado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró un pasajero con el número de asiento especificado.");
    }

	public void cancelarVuelo() {
        listaPasajeros.clear();
        System.out.println("El vuelo ha sido cancelado. Todos los pasajeros han sido removidos.");
    }

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public int getNumeroVuelo() {
		return numeroVuelo;
	}

	public String detallesVuelo() {
		return "Vuelo: " + numeroVuelo + ", Origen: " + ciudadOrigen + ", Destino: " + ciudadDestino + 
			   ", Salida: " + fechaSalida + ", Llegada: " + fechaLlegada + ", Piloto: " + piloto.getNombre() + 
			   ", Pasajeros: " + listaPasajeros.size();
	}


	
}