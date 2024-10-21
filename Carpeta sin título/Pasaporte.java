import java.time.LocalDate;

public class Pasaporte {
	private int id;
	private String nacionalidad;
	private int hojasDisponibles;
	private LocalDate fechaExpiracion;

	public Pasaporte(int id, String nacionalidad, int hojasDisponibles, LocalDate fechaExpiracion) {
        this.id = id;
        this.nacionalidad = nacionalidad;
        this.hojasDisponibles = hojasDisponibles;
        this.fechaExpiracion = fechaExpiracion;
    }

    public void renovarPasaporte(int nuevasHojas, LocalDate nuevaFechaExpiracion) {
		this.hojasDisponibles += nuevasHojas;
		this.fechaExpiracion = nuevaFechaExpiracion;
	}

	public boolean isValido() {
        LocalDate fechaActual = LocalDate.now();
        return fechaExpiracion.isAfter(fechaActual) && hojasDisponibles > 0;
    }
}