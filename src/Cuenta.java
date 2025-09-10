public class Cuenta {
    // Atributos de la clase

        private String numeroCuenta;
        private String dniCliente;
        private double saldoActual;

        // a) Constructores
        // Constructor por defecto
        public Cuenta() {
        }

        // Constructor con parámetros
        public Cuenta(String numeroCuenta, String dniCliente, double saldoActual) {
            this.numeroCuenta = numeroCuenta;
            this.dniCliente = dniCliente;
            this.saldoActual = saldoActual;
        }

        // b) Getters y Setters
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

        //  ingresar
        public void ingresar(double cantidad) {
            this.saldoActual += cantidad;
            System.out.println("Se han ingresado $" + cantidad + " en su cuenta.");
        }

        // retirar
        public void retirar(double cantidad) {
            if (cantidad > this.saldoActual) {
                System.out.println("Saldo insuficiente. Se retirará la totalidad del saldo disponible.");
                this.saldoActual = 0;
            } else {
                this.saldoActual -= cantidad;
                System.out.println("Se han retirado $" + cantidad + " de su cuenta.");
            }
        }

        // extraccionRapida
        public void extraccionRapida(double cantidad) {
            double limite = this.saldoActual * 0.20;
            if (cantidad > limite) {
                System.out.println("Error: No puede retirar más del 20% de su saldo actual. El límite es $" + limite);
            } else {
                this.saldoActual -= cantidad;
                System.out.println("Extracción rápida exitosa. Se han retirado $" + cantidad);
            }
        }

        //  Saldo

        public void consultarSaldo() {
            System.out.println("Su saldo actual es: $" + this.saldoActual);
        }

        // Datos
        public void consultarDatos() {
            System.out.println("--- Datos de la Cuenta ---");
            System.out.println("Número de Cuenta: " + this.numeroCuenta);
            System.out.println("DNI del Cliente: " + this.dniCliente);
            System.out.println("Saldo Actual: $" + this.saldoActual);
        }
    }