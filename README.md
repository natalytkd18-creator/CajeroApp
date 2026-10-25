# 🏦 INN BANK — Guía didáctica del sistema bancario

¡Bienvenido/a a **INN BANK**! Este proyecto es una práctica en Java que simula el funcionamiento básico de un banco desde la consola.

En esta guía aprenderás **qué hace el programa, cómo ejecutarlo y cómo probar cada operación**, paso a paso.

---

## 🎯 1. ¿Qué aprenderás con este proyecto?

Al terminar de revisar y probar el programa, podrás identificar cómo se utilizan:

- **Variables y constantes** para guardar información.
- **Arreglos** para almacenar los datos de varios clientes.
- **Condiciones (`if / else`)** para validar datos.
- **Ciclos (`while` y `do-while`)** para repetir acciones.
- **`switch`** para elegir una operación del menú.
- **Métodos** para leer números de manera controlada.
- **Operaciones matemáticas** para actualizar saldos y hacer transferencias.

## 🧰 2. ¿Qué necesitas antes de comenzar?

Instala o prepara lo siguiente:

1. **Java JDK:** permite compilar y ejecutar el programa.
2. **Visual Studio Code:** editor donde trabajarás con el código.
3. **Extension Pack for Java:** extensión de VS Code que facilita el trabajo con Java.

### Comprueba que Java esté instalado

Abre una terminal y escribe estos comandos, uno por uno:

```bash
java -version
javac -version
```

**¿Qué debe pasar?** Cada comando debe mostrar una versión de Java. Si aparece un mensaje indicando que el comando no se reconoce, revisa la instalación del JDK y la configuración de `PATH`.

## 📁 3. Prepara tu carpeta de trabajo

1. Crea una carpeta llamada `INN-BANK`.
2. Abre Visual Studio Code.
3. Entra en **Archivo → Abrir carpeta** y selecciona `INN-BANK`.
4. Crea un archivo llamado exactamente `HU06.java`.
5. Copia el código del programa dentro del archivo.
6. Guarda con `Ctrl + S`.

La carpeta debe verse así:

```text
INN-BANK/
└── HU06.java
```

> **Importante:** el archivo debe llamarse `HU06.java` porque dentro del código la clase pública se llama `HU06`. El nombre del archivo y el de la clase pública deben coincidir.

## ▶️ 4. Compila y ejecuta el programa

En Visual Studio Code:

1. Abre **Terminal → Nueva terminal**.
2. Comprueba que estás dentro de la carpeta `INN-BANK`.
3. Escribe el siguiente comando para compilar:

   ```bash
   javac HU06.java
   ```

4. Si no aparecen errores, ejecuta el programa:

   ```bash
   java HU06
   ```

**¿Cuál es la diferencia?**

- `javac HU06.java` revisa y compila el código Java.
- `java HU06` ejecuta el programa compilado.

Al compilar, normalmente se crea un archivo `HU06.class`. No necesitas escribirlo ni modificarlo manualmente.

## 👤 5. Conoce los clientes de prueba

El programa ya contiene tres clientes. Utiliza estos datos para practicar:

| Número de cliente | Nombre | PIN de prueba | Saldo inicial |
|---:|---|---|---:|
| 1 | Mateo | `1296` | $1,000.00 |
| 2 | Edith | `2912` | $2,500.00 |
| 3 | David | `2022` | $500.00 |

Por ejemplo, para entrar como Mateo:

1. Escribe `1` cuando el programa solicite el número de cliente.
2. Escribe `1296` cuando solicite el PIN.
3. Si los datos coinciden, aparecerá un mensaje de acceso autorizado.

> 🔐 Estos PIN son datos de demostración guardados directamente en el código. No son credenciales reales ni deben usarse en un sistema bancario verdadero.

## 🔑 6. Paso a paso: iniciar sesión

### Paso 1. Ingresa tu número de cliente

El programa pide un número entre `1` y `3`.

- Si ingresas `1`, selecciona a Mateo.
- Si ingresas `2`, selecciona a Edith.
- Si ingresas `3`, selecciona a David.
- Si ingresas otro número, el sistema indica que el cliente no existe y termina.

### Paso 2. Escribe tu PIN

El PIN debe coincidir con el del cliente elegido.

- **PIN correcto:** el acceso es autorizado.
- **PIN incorrecto:** el programa resta un intento.
- **Tres intentos fallidos:** el programa muestra que la cuenta está bloqueada y termina.

### ¿Por qué el cliente y el PIN deben coincidir?

El programa utiliza el número de cliente para buscar su posición en los arreglos. Luego compara el PIN escrito con el PIN guardado en esa misma posición.

## 🧭 7. Aprende a usar el menú bancario

Después de iniciar sesión correctamente, verás este menú:

```text
===== MENÚ BANCARIO =====
Cliente: Mateo
1. Consultar saldo
2. Depositar
3. Retirar
4. Transferir
5. Salir
Selecciona una opción:
```

Escribe el número de la operación que quieres realizar. Después de cada operación, el menú vuelve a mostrarse, excepto cuando eliges salir.

### Opción 1: consultar saldo

**Objetivo:** conocer cuánto dinero hay en tu cuenta.

1. Escribe `1`.
2. Lee el saldo que aparece en pantalla.
3. El menú volverá a mostrarse.

**Ejemplo:** si Mateo no ha hecho operaciones, verá `$1000.00`. Consultar el saldo no cambia el dinero.

### Opción 2: depositar dinero

**Objetivo:** agregar dinero a tu cuenta.

1. Escribe `2`.
2. Introduce una cantidad mayor que cero, por ejemplo `200`.
3. El programa valida la cantidad.
4. Si es válida, suma el depósito al saldo y muestra el nuevo total.

**Ejemplo con Mateo:**

- Saldo inicial: $1,000.00
- Depósito: $200.00
- Nuevo saldo: $1,200.00

Si ingresas `0` o una cantidad negativa, el depósito será rechazado.

### Opción 3: retirar dinero

**Objetivo:** sacar dinero de tu cuenta.

1. Escribe `3`.
2. Introduce cuánto deseas retirar.
3. El programa verifica que la cantidad sea positiva y no supere tu saldo.
4. Si todo está bien, resta la cantidad y muestra el saldo actualizado.

**Ejemplo con Mateo:**

- Saldo inicial: $1,000.00
- Retiro: $150.00
- Nuevo saldo: $850.00

Si intentas retirar `$2,000` teniendo solo `$1,000`, la operación será rechazada por falta de saldo.

### Opción 4: transferir dinero

**Objetivo:** enviar dinero desde tu cuenta a la de otro cliente.

Sigue estos pasos:

1. Escribe `4`.
2. Introduce el número del cliente destinatario.
3. Comprueba el nombre que muestra el programa.
4. Introduce la cantidad que deseas transferir.
5. El programa valida que el destinatario exista, que sea otra cuenta y que tengas saldo suficiente.
6. Si todas las validaciones pasan, el dinero se descuenta de tu cuenta y se agrega a la del destinatario.
7. Revisa el mensaje de confirmación y tu saldo disponible.

**Ejemplo:** Mateo transfiere `$100` a Edith.

| Cuenta | Antes | Movimiento | Después |
|---|---:|---:|---:|
| Mateo | $1,000.00 | −$100.00 | $900.00 |
| Edith | $2,500.00 | +$100.00 | $2,600.00 |

El programa no permite transferir a un cliente inexistente, transferirte a ti mismo, ingresar una cantidad inválida o enviar más dinero del que tienes.

### Opción 5: salir

1. Escribe `5`.
2. El programa muestra un mensaje de despedida.
3. El menú termina y se cierra el lector de entradas.

## 🧠 8. ¿Cómo está organizado el código?

Esta tabla explica las partes principales con palabras sencillas:

| Parte del código | ¿Para qué sirve? |
|---|---|
| `Scanner` | Lee lo que escribes en la consola. |
| `NOMBRE_BANCO` | Guarda el nombre del banco. |
| `MAX_INTENTOS` | Establece el máximo de intentos de PIN. |
| `nombres[]` | Guarda los nombres de los clientes. |
| `pines[]` | Guarda los PIN de prueba. |
| `saldos[]` | Guarda el saldo de cada cliente. |
| `if / else` | Decide qué hacer según se cumpla una condición. |
| `while` | Repite la validación del PIN mientras queden intentos. |
| `do-while` | Repite el menú hasta que se elige salir. |
| `switch` | Ejecuta la opción seleccionada del menú. |
| `leerEntero()` | Intenta convertir lo escrito en un número entero. |
| `leerDecimal()` | Intenta convertir lo escrito en un número decimal. |

### ¿Qué es un arreglo?

Un arreglo guarda varios datos del mismo tipo en una lista. En este programa, los tres arreglos están relacionados por la posición:

| Posición del arreglo | `nombres[]` | `pines[]` | `saldos[]` |
|---:|---|---|---:|
| `0` | Mateo | `1296` | $1,000.00 |
| `1` | Edith | `2912` | $2,500.00 |
| `2` | David | `2022` | $500.00 |

**Recuerda:** las posiciones empiezan en `0`, pero los números de cliente empiezan en `1`. Por eso el código resta uno al número de cliente para encontrar la posición correcta.

### ¿Para qué sirven `leerEntero()` y `leerDecimal()`?

Estos métodos intentan convertir el texto que escribes en un número.

- `leerEntero()` se usa para opciones y números de cliente.
- `leerDecimal()` se usa para depósitos, retiros y transferencias.
- Si la conversión falla, ambos métodos devuelven `-1`, que después puede ser rechazado por las validaciones.

## 🧪 9. Práctica guiada: prueba el programa

Prueba los siguientes casos. Después de cada operación, revisa el mensaje y el saldo.

### Ejercicio A — Consultar saldo

1. Inicia sesión como Mateo con cliente `1` y PIN `1296`.
2. Selecciona `1`.
3. Comprueba que el saldo inicial sea `$1000.00`.

### Ejercicio B — Depositar

1. En el menú, selecciona `2`.
2. Escribe `200`.
3. Consulta el saldo con la opción `1`.

**Comprueba:** el saldo de Mateo debe ser `$1200.00` mientras la misma ejecución siga abierta.

### Ejercicio C — Retirar

1. Selecciona `3`.
2. Escribe `50`.
3. Consulta el saldo.

**Comprueba:** después del depósito y el retiro, Mateo debe tener `$1150.00`.

### Ejercicio D — Transferir

1. Selecciona `4`.
2. Como destinatario, escribe `2` para Edith.
3. Escribe `100` como cantidad.
4. Lee la confirmación.

**Comprueba:** Mateo debe quedar con `$1050.00` y Edith debe pasar de `$2500.00` a `$2600.00`.

### Ejercicio E — Validar errores

Prueba también:

- Ingresar un número de cliente `9`.
- Escribir un PIN incorrecto tres veces.
- Intentar depositar `0`.
- Intentar retirar más dinero del saldo disponible.
- Intentar transferir dinero a tu propio número de cliente.
- Escribir una opción de menú que no esté entre `1` y `5`.

En cada caso, observa qué mensaje muestra el programa.

## ⚠️ 10. Cosas importantes que debes saber

- Los clientes y sus datos están escritos directamente en el código.
- El programa guarda los cambios solo en la memoria mientras está ejecutándose.
- **Cuando cierras el programa, los saldos vuelven a los valores iniciales** al ejecutarlo de nuevo.
- Los PIN se ven en el código. Este sistema es educativo y no tiene la seguridad necesaria para un banco real.
- El código usa `double` para las cantidades de dinero. Para un sistema financiero real sería preferible utilizar `BigDecimal` y añadir más controles de seguridad.

## 🛠️ 11. Problemas comunes y soluciones

**Problema:** `javac` no se reconoce.

**Solución:** comprueba que instalaste el JDK y que su carpeta `bin` está configurada en `PATH`. Cierra y abre nuevamente la terminal.

**Problema:** aparece un error indicando que la clase `HU06` debe estar en `HU06.java`.

**Solución:** cambia el nombre del archivo a `HU06.java`, respetando las mayúsculas.

**Problema:** no se ejecuta el programa.

**Solución:** abre la terminal en la carpeta donde está el archivo y ejecuta primero `javac HU06.java`. Si aparecen errores, corrígelos antes de ejecutar `java HU06`.

**Problema:** el saldo vuelve a su valor original.

**Solución:** es el comportamiento esperado: el programa todavía no guarda la información en un archivo o base de datos.

## ✅ 12. Lista final de comprobación

Antes de entregar tu actividad, revisa que hayas podido:

- [ ] Instalar o comprobar Java JDK.
- [ ] Abrir el proyecto en Visual Studio Code.
- [ ] Guardar el código como `HU06.java`.
- [ ] Compilar y ejecutar el programa.
- [ ] Iniciar sesión con un cliente válido.
- [ ] Consultar saldo, depositar y retirar.
- [ ] Hacer una transferencia entre dos clientes.
- [ ] Probar entradas incorrectas.
- [ ] Explicar por qué los cambios de saldo se pierden al cerrar el programa.

## 📌 Resumen

El sistema **INN BANK** permite iniciar sesión con un número de cliente y PIN, consultar el saldo, depositar, retirar y transferir dinero entre tres clientes de prueba. La práctica ayuda a comprender arreglos, condiciones, ciclos, métodos y operaciones aritméticas en Java.

¡Éxito con tu proyecto!
