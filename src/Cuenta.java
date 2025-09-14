public class Cuenta {
    // Atributos
    private String numeroCuenta;
    private String dniCliente;
    private double saldoActual;

    // Constructores
    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, String dniCliente, double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.dniCliente = dniCliente;
        this.saldoActual = saldoActual;
    }

    // Getters y Setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    //operaciones
    public void ingresar(double cantidad) {
        this.saldoActual += cantidad;
        System.out.println("Dinero ingresado $" + cantidad + " en su cuenta");
    }

    public void retirar(double cantidad) {
        if (cantidad > this.saldoActual) {
            System.out.println("Saldo insuficiente");
            this.saldoActual = 0;
        } else {
            this.saldoActual -= cantidad;
            System.out.println("Dinero retirado $" + cantidad + " de su cuenta");
        }
    }

    public void extraccionRapida(double cantidad) {
        double limite = this.saldoActual * 0.20;
        if (cantidad > limite) {
            System.out.println("Error: No puede retirar más del 20% de su saldo actual \n El límite es $" + String.format("%.2f", limite));
            // cantidad es mayor al 20% el saldo se pone en 0
            this.saldoActual = 0;
        } else {
            this.saldoActual -= cantidad;
            System.out.println("Extracción  exitosa Se han retirado $" + cantidad);
        }
    }

    public void consultarSaldo() {
        System.out.println("Su saldo actual es: $" + this.saldoActual);
    }

    public void consultarDatos() {
        System.out.println("--- Datos de la Cuenta ---");
        System.out.println("Número de Cuenta: " + this.numeroCuenta);
        System.out.println("DNI del Cliente: " + this.dniCliente);
        System.out.println("Saldo Actual: $" + this.saldoActual);
    }
}