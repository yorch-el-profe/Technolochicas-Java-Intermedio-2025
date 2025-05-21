import java.util.List;

public class Banco {

    // ? -> significa cualquier tipo (similar a poner T, X, etc)
    // Se utiliza cuando el código no usa nada especifico de la clase objetivo
    public static void verCuentas(List<?> cuentas) {
        for (Object o : cuentas) {
            // System.out.println(o.toString());
            System.out.println(o);
        }
    }

    // Upper Bouded Wilcard
    // List<CuentaBancaria> != List<CuentaDebito>
    // extends: Se utiliza unicamente para la lectura
    // Entonces la lista puede ser de CuentaBancaria, CuentaDebito (hijo) o CuentaCredito (hijo)
    public static void verTitulares(List<? extends CuentaBancaria> cuentas) {
        for (CuentaBancaria o : cuentas) {
            System.out.println(o.getTitular());
        }
    }

    // Lower Bounded Wildcard
    // super: Se utiliza unicamente para la escritura
    // Entonces la lista puede ser CuentaDebito o CuentaBancaria (padre)
    public static void depositarACuentas(List<? super CuentaDebito> cuentas) {
        for (Object o : cuentas) {
            if (o instanceof CuentaBancaria) {
                o.depositar(100);
            }
        }
    }
}