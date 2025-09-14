import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        int opcionPrincipal;

        do {
            System.out.println(" Menú Principal del Cajero ");
            System.out.println("1. Agregar un nuevo usuario ");
            System.out.println("2. Buscar un usuario por DNI");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    System.out.println(" Creación de Cuenta para Nuevo Usuario ");
                    System.out.print("Ingrese el número de cuenta: ");
                    String numeroCuenta = scanner.next();
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dniCliente = scanner.next();
                    System.out.print("Ingrese el saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();

                    Cuenta nuevaCuenta = new Cuenta(numeroCuenta, dniCliente, saldoInicial);
                    listaCuentas.add(nuevaCuenta);
                    System.out.println(" agregado con éxito");
                    break;

                case 2:
                    System.out.print("DNI del usuario a buscar: ");
                    String dniBuscado = scanner.next();

                    Cuenta cuentaEncontrada = buscarCuentaPorDNI(listaCuentas, dniBuscado);

                    if (cuentaEncontrada != null) {
                        System.out.println("Usuario encontrado");

                        cuentaEncontrada.consultarDatos();

                        mostrarMenuOperaciones(scanner, cuentaEncontrada);
                    } else {
                        System.out.println(" Usuario no encontrado. Verifique el DNI e intente de nuevo.");
                    }
                    break;

                case 0:
                    System.out.println("Hasta pronto");
                    break;

                default:
                    System.out.println("Opción no válida elija una opción del menú.");
                    break;
            }
        } while (opcionPrincipal != 0);

        scanner.close();
    }

    public static Cuenta buscarCuentaPorDNI(ArrayList<Cuenta> lista, String dni) {
        for (Cuenta cuenta : lista) {
            if (cuenta.getDniCliente().equals(dni)) {
                return cuenta;
            }
        }
        return null;
    }

    public static void mostrarMenuOperaciones(Scanner scanner, Cuenta cuenta) {
        int opcionOperacion;
        do {
            System.out.println("Menú del Cajero ");
            System.out.println("1. Ingresar Dinero");
            System.out.println("2. Retirar Dinero");
            System.out.println("3. Extracción Rápida (max 20%)");
            System.out.println("4. Consultar Saldo");
            System.out.println("5. Consultar Datos de la Cuenta");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcionOperacion = scanner.nextInt();

            switch (opcionOperacion) {
                case 1:
                    System.out.print("Cantidad a ingresar ");
                    double ingreso = scanner.nextDouble();
                    cuenta.ingresar(ingreso);
                    break;
                case 2:
                    System.out.print("Cantidad a retirar ");
                    double retiro = scanner.nextDouble();
                    cuenta.retirar(retiro);
                    break;
                case 3:
                    System.out.print("Cantidad de extracción rápida ");
                    double extraccion = scanner.nextDouble();
                    cuenta.extraccionRapida(extraccion);
                    break;
                case 4:
                    cuenta.consultarSaldo();
                    break;
                case 5:
                    cuenta.consultarDatos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
                default:
                    System.out.println("Opción no válida elige una opción del menú.");
                    break;
            }
        } while (opcionOperacion != 0);
    }
}