package Clases;

class ConductorNoDisponibleException extends Exception {
    public ConductorNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}