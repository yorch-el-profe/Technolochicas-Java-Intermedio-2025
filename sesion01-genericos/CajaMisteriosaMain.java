public class CajaMisteriosaMain {

    public static void main(String ... args) {

        CajaMisteriosa<String> cajita = new CajaMisteriosa<>();

        cajita.guardar("Hola Mundo");

        String valor = cajita.sacar(); // <--- ERROR

        System.out.println("El valor de la caja es => " + valor);

        CajaMisteriosa<Integer> cajitaNumeros = new CajaMisteriosa<>();

        cajitaNumeros.guardar(1);

        CajaMisteriosa<Boolean> cajitaBool = new CajaMisteriosa<>();

        cajitaBool.guardar(true);
    }
}

/**
 * Tipos de datos primitivos son aquellos que nacieron con el lenguaje de programación
 *  int, float, double, byte, boolean, short, char
 * 
 * String NO es un tipo de dato primitivo
 * 
 * Wrapper Class -> La versión objeto de los tipos de datos primitivos
 * int -> Integer
 * float -> Float
 * double -> Double
 * boolean -> Boolean
 * short -> Short
 * char -> Character
 */

/*
    Herencia -> Especialización
    Polimorfismo -> Generalización

    Animal -> Mamifero -> Canino -> Perros
                                 -> Lobo

                       -> Felinos
                                 -> Gato


    Animal a = new Gato();

    Gato g = new Animal();


    Object -> String

    Object o = new String(); Polimorfismo
    String s = new Object(); ❌ Quien sabe que es
*/