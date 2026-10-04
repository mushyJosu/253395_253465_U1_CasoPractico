public class Proveedor {
    private String nombreEmpresa;
    private String nombreRepartidor;
    private String telefonoContacto;

    //inicializa el constructor
    public Proveedor(String nombreEmpresa, String nombreRepartidor, String telefonoContacto) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombreRepartidor = nombreRepartidor;
        this.telefonoContacto = telefonoContacto;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public String getNombreRepartidor() {
        return nombreRepartidor;
    }
    public String getTelefonoContacto() {
        return telefonoContacto;
    }
}
