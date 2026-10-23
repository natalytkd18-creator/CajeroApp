import java.util.Scanner;

public class HU06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // =====================================
        // CONSTANTES
        // =====================================
        final String NOMBRE_BANCO = "INN BANK";
        final int MAX_INTENTOS = 3;

        // =====================================
        // HU-06: ARREGLOS DE CLIENTES
        // =====================================
        String[] nombres = {"Mateo", "Edith", "David"};

        String[] pines = {"1296", "2912", "2022"};

        double[] saldos = {1000.00, 2500.00, 500.00};

        // =====================================
        // VARIABLES
        // =====================================
        int numeroCliente;
        int indiceCliente = -1;
        int intentosRestantes = MAX_INTENTOS;
        int opcion;
        int numeroDestino;
        int indiceDestino;

        double cantidad;
        boolean accesoPermitido = false;

        // =====================================
        // BIENVENIDA
        // =====================================
        System.out.println("==============================");
        System.out.println(" BIENVENIDO A " + NOMBRE_BANCO);
        System.out.println("==============================");

        // =====================================
        // HU-06: BUSCAR CLIENTE
        // =====================================
        System.out.print("Ingresa tu número de cliente: ");

        numeroCliente = leerEntero(scanner);

        // Convertimos número de cliente a índice.
        // Cliente 1 = índice 0
        // Cliente 2 = índice 1
        // Cliente 3 = índice 2

        int indiceBuscado = numeroCliente - 1;

        if (indiceBuscado >= 0 &&
                indiceBuscado < nombres.length) {

            indiceCliente = indiceBuscado;

        } else {

            System.out.println("El cliente no existe.");
            scanner.close();
            return;
        }

        // =====================================
        // HU-05: LOGIN CON PIN
        // =====================================
        while (intentosRestantes > 0 && !accesoPermitido) {

            System.out.print("Ingresa tu PIN: ");
            String pinIngresado = scanner.nextLine();

            if (pinIngresado.equals(pines[indiceCliente])) {

                accesoPermitido = true;

                System.out.println("Acceso autorizado.");
                System.out.println("Bienvenido, "
                        + nombres[indiceCliente]);

            } else {

                intentosRestantes--;

                System.out.println("PIN incorrecto.");
                System.out.println("Intentos restantes: "
                        + intentosRestantes);
            }
        }

        // =====================================
        // VERIFICACIÓN DE ACCESO
        // =====================================
        if (!accesoPermitido) {

            System.out.println("Cuenta bloqueada.");
            System.out.println("Agotaste tus 3 intentos.");

            scanner.close();
            return;
        }

        // =====================================
        // HU-04 + HU-06: MENÚ BANCARIO
        // =====================================
        do {

            System.out.println("\n===== MENÚ BANCARIO =====");
            System.out.println("Cliente: " + nombres[indiceCliente]);
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Transferir");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = leerEntero(scanner);

            switch (opcion) {

                // =====================================
                // CONSULTAR SALDO
                // =====================================
                case 1:

                    System.out.printf(
                            "Saldo actual: $%.2f%n",
                            saldos[indiceCliente]);

                    break;

                // =====================================
                // DEPOSITAR
                // =====================================
                case 2:

                    System.out.print("Cantidad a depositar: $");
                    cantidad = leerDecimal(scanner);

                    if (cantidad > 0 &&
                            Double.isFinite(cantidad) &&
                            Double.isFinite(
                                saldos[indiceCliente] + cantidad)) {

                        saldos[indiceCliente] += cantidad;

                        System.out.println("Depósito exitoso.");

                        System.out.printf(
                                "Nuevo saldo: $%.2f%n",
                                saldos[indiceCliente]);

                    } else {

                        System.out.println("Cantidad no válida.");
                    }

                    break;

                // =====================================
                // RETIRAR
                // =====================================
                case 3:

                    System.out.print("Cantidad a retirar: $");
                    cantidad = leerDecimal(scanner);

                    if (cantidad > 0 &&
                            Double.isFinite(cantidad) &&
                            cantidad <= saldos[indiceCliente]) {

                        saldos[indiceCliente] -= cantidad;

                        System.out.println("Retiro exitoso.");

                        System.out.printf(
                                "Nuevo saldo: $%.2f%n",
                                saldos[indiceCliente]);

                    } else {

                        System.out.println(
                                "Cantidad inválida o saldo insuficiente.");
                    }

                    break;

                // =====================================
                // HU-06: TRANSFERENCIAS
                // =====================================
                case 4:

                    System.out.print(
                            "Número de cliente destino: ");

                    numeroDestino = leerEntero(scanner);

                    indiceDestino = numeroDestino - 1;

                    // VALIDAR QUE EL DESTINO EXISTA
                    if (indiceDestino < 0 ||
                            indiceDestino >= nombres.length) {

                        System.out.println(
                                "El cliente destino no existe.");

                        break;
                    }

                    // VALIDAR QUE SEA OTRA CUENTA
                    if (indiceDestino == indiceCliente) {

                        System.out.println(
                                "No puedes transferirte a ti mismo.");

                        break;
                    }

                    System.out.println(
                            "Destino: " + nombres[indiceDestino]);

                    System.out.print(
                            "Cantidad a transferir: $");

                    cantidad = leerDecimal(scanner);

                    // VALIDAR MONTO
                    if (cantidad <= 0 ||
                            !Double.isFinite(cantidad)) {

                        System.out.println(
                                "Cantidad no válida.");

                        break;
                    }

                    // VALIDAR SALDO
                    if (cantidad > saldos[indiceCliente]) {

                        System.out.println(
                                "Saldo insuficiente.");

                        break;
                    }

                    // VALIDAR SALDO RESULTANTE
                    if (!Double.isFinite(
                            saldos[indiceDestino] + cantidad)) {

                        System.out.println(
                                "No se puede completar la transferencia.");

                        break;
                    }

                    // REALIZAR TRANSFERENCIA
                    saldos[indiceCliente] -= cantidad;
                    saldos[indiceDestino] += cantidad;

                    System.out.println(
                            "Transferencia exitosa.");

                    System.out.println(
                            "Destinatario: "
                                    + nombres[indiceDestino]);

                    System.out.printf(
                            "Cantidad transferida: $%.2f%n",
                            cantidad);

                    System.out.printf(
                            "Saldo disponible: $%.2f%n",
                            saldos[indiceCliente]);

                    break;

                // =====================================
                // SALIR
                // =====================================
                case 5:

                    System.out.println(
                            "Gracias por usar " + NOMBRE_BANCO);

                    break;

                default:

                    System.out.println(
                            "Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    // =====================================
    // LECTURA SEGURA DE ENTEROS
    // =====================================
    public static int leerEntero(Scanner scanner) {

        try {
            return Integer.parseInt(scanner.nextLine().trim());

        } catch (NumberFormatException e) {

            return -1;
        }
    }

    // =====================================
    // LECTURA SEGURA DE DECIMALES
    // =====================================
    public static double leerDecimal(Scanner scanner) {

        try {
            return Double.parseDouble(
                    scanner.nextLine().trim());

        } catch (NumberFormatException e) {

            return -1;
        }
    }
}


