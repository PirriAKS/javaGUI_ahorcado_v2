/**
 * @author Alejandro Alba
 */
public class Objeto {
    String nombre;
    String tema;
    String pista;

    public Objeto() {
    }

    public Objeto(String nombre, String tema, String pista) {
        this.nombre = nombre;
        this.tema = tema;
        this.pista = pista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", tema='" + tema + '\'' +
                ", pista='" + pista + '\'' +
                '}';
    }
}
