import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aeropuerto {
	private String nombre;
	private String ubicacion;
	private List<Avion> aviones;

    public Aeropuerto(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
		this.aviones = new ArrayList<>();
    }
	
	public void registrarAvion(Avion avion) {
        aviones.add(avion);
        System.out.println("Avión registrado en el aeropuerto.");
    }

	public List<Persona> buscarUsuariosPorFecha(Date fecha) {
        List<Persona> usuariosEnFecha = new ArrayList<>();
        for (Avion avion : aviones) {
            for (Vuelo vuelo : avion.getVuelos()) {
                if (vuelo.getFechaSalida().equals(fecha)) {
                    usuariosEnFecha.add(vuelo.getPiloto());
                    usuariosEnFecha.addAll(vuelo.getListaPasajeros());
                }
            }
        }
        return usuariosEnFecha;
    }

	public List<Persona> buscarUsuariosPorVuelo(int numeroVuelo) {
        List<Persona> usuariosEnVuelo = new ArrayList<>();
        for (Avion avion : aviones) {
            for (Vuelo vuelo : avion.getVuelos()) {
                if (vuelo.getNumeroVuelo() == numeroVuelo) {
                    usuariosEnVuelo.add(vuelo.getPiloto());
                    usuariosEnVuelo.addAll(vuelo.getListaPasajeros());
                }
            }
        }
        return usuariosEnVuelo;
    }

    public List<Pasajero> buscarPasajerosPorVuelo(int numeroVuelo) {
        for (Avion avion : aviones) {
            for (Vuelo vuelo : avion.getVuelos()) {
                if (vuelo.getNumeroVuelo() == numeroVuelo) {
                    return vuelo.getListaPasajeros();
                }
            }
        }
        return new ArrayList<>(); 
    }

	public List<Avion> listarAviones() {
		return aviones;
	}

	public void modificarAvion(Avion viejo, Avion nuevo) {
		int index = aviones.indexOf(viejo);
		if (index != -1) {
			aviones.set(index, nuevo);
		}
	}
	
	public void mostrarInformacionAviones() {
		for (Avion avion : aviones) {
			System.out.println(avion.toString());
		}
	}
	
    public void eliminarAvion(int idAvion) {
        Avion avionAEliminar = aviones.stream()
            .filter(avion -> avion.getId() == idAvion)
            .findFirst()
            .orElse(null);
    
        if (avionAEliminar != null) {
            aviones.remove(avionAEliminar);
            System.out.println("Avión eliminado del aeropuerto.");
        } else {
            System.out.println("No se encontró el avión con el ID especificado.");
        }
    }
    

    public void eliminarVuelo(int numeroVuelo) {
        for (Avion avion : aviones) {
            avion.eliminarVuelo(numeroVuelo);
        }
    }

}