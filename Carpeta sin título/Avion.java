import java.util.ArrayList;
import java.util.List;

public class Avion {
	private int id;
	private String modelo;
	private int capacidad;
	private List<Vuelo> vuelos;

    public Avion(int id, String modelo) {
        this.capacidad = 120;
        this.id = id;
        this.modelo = modelo;
        this.vuelos = new ArrayList<>();
    }

	public void agregarVuelo(Vuelo vuelo) {
        if (vuelos.size() < capacidad) {
            vuelos.add(vuelo);
            System.out.println("Vuelo agregado al avión.");
        } else {
            System.out.println("Capacidad del avión alcanzada.");
        }
    }

	public int getId() {
		return id;
	}
	
	public void eliminarVuelo(int numeroVuelo) {
        Vuelo vueloAEliminar = null;
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getNumeroVuelo() == numeroVuelo) {
                vueloAEliminar = vuelo;
                break;
            }
        }
        if (vueloAEliminar != null) {
            vuelos.remove(vueloAEliminar);
            System.out.println("Vuelo eliminado del avión.");
        } else {
            System.out.println("No se encontró el vuelo con el número especificado.");
        }
    }

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public boolean tieneEspacio() {
		int totalPasajeros = 0;
		
		for (Vuelo vuelo : vuelos) {
			totalPasajeros += vuelo.getListaPasajeros().size();
		}
		
		return totalPasajeros < capacidad;
	}
	

	public void setCapacidad(int nuevaCapacidad) {
		this.capacidad = nuevaCapacidad;
	}
	
	@Override
	public String toString() {
    	return "Avión ID: " + id + ", Modelo: " + modelo + ", Capacidad: " + capacidad;
	}
}