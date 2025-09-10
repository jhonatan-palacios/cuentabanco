//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        // datos de la nueua cuenta
        System.out.println(" Creación de cuenta nueva");

        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.next();

        System.out.print("Ingrese el DNI : ");
        String dniCliente = scanner.next();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        //datos ingresados
        Cuenta miCuenta = new Cuenta(numeroCuenta, dniCliente, saldoInicial);

        do {
            System.out.println("  menu del cajero");
            System.out.println("1. ingresar dinero");
            System.out.println("2. Retirar Dinero");
            System.out.println("3. Extracción Rápida ");
            System.out.println("4. Consultar Saldo");
            System.out.println("5. Consultar Datos de la Cuenta");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Cantidad a ingresar: ");
                    double ingreso = scanner.nextDouble();
                    miCuenta.ingresar(ingreso);
                    break;
                case 2:
                    System.out.print("cantidad a retirarr: ");
                    double retiro = scanner.nextDouble();
                    miCuenta.retirar(retiro);
                    break;
                case 3:
                    System.out.print("cantidad para retiro rapido: ");
                    double extraccion = scanner.nextDouble();
                    miCuenta.extraccionRapida(extraccion);
                    break;
                case 4:
                    miCuenta.consultarSaldo();
                    break;
                case 5:
                    miCuenta.consultarDatos();
                    break;
                case 0:
                    System.out.println("saliendo del cajero");
                    break;
                default:
                    System.out.println("opción no válida elige una opción del menu.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}



