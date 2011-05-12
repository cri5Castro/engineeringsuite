package gui;

import java.util.ArrayList;

/**
 * This class must be executed at first. Contains the translations.
 * 
 * @author Pablo Salinas
 * 
 */
public class Translation {
	public static ArrayList<String> Language = new ArrayList<String>();
	static char com = (int) 34;// "

	// IF YOU WANT TO ADD A NEW LANGUAGE JUST COPY AND PASTE THIS STRINGS INSIDE
	// THE BELOW METHOD.
	// AND ADD THE NAME YOU WILL USE IN PREFERENCES/getJCOMBOBOX3
	/**
	 * By default i will use the English language
	 */
	public Translation() {

		if (Config.Language.equalsIgnoreCase("Español")) {
			/* 0 */Language.add("Cortar");
			Language.add("Copiar");
			Language.add("Pegar");
			Language.add("Ecuaciones");
			Language.add("Resultados");
			/* 5 */Language.add("Log");
			Language.add("Valor inicial >>");
			Language
					.add("Cambia el valor inicial por defecto de todas las variables ");
			Language.add("como punto inicial para ");
			Language.add("las siguientes iteraciones");
			/* 10 */Language.add("Guardar valores");
			Language.add("Salvar ultimos valores");
			Language.add("Eliminar");
			Language.add("Añadir");
			Language.add("Borrar");
			/* 15 */Language
					.add("Va a eliminar todos los valores iniciales.\n¿Está seguro?");
			Language.add("Borrar valores");
			Language.add("Cerrar");
			Language.add("Valor >>");
			Language.add("Variable >>");
			/* 20 */Language.add("Valores iniciales");
			Language.add("Por favor, introduzca una variable");
			Language.add("Va a modificar el valor de");
			Language.add("¿Está seguro?");
			Language.add("Cambiar valor");
			/* 25 */Language.add("El valor debe ser un número");
			Language.add("No se encuentra la variable que quiere borrar");
			Language.add("Editar");
			Language.add("Ayuda");
			Language.add("Archivo");
			/* 30 */Language.add("Acerca de");
			Language.add(">> Proyecto fin de carrera de Pablo Salinas Cortés ");
			Language
					.add(">> Director de proyecto: Dr. Don Francisco José Gaspar Lorenz\n>> Ponente: Dr. María Cruz Lopez de Silanes Busto");
			Language.add(">> Versión actual ");
			Language.add("Este programa está licenciado bajo la LGPL");
			/* 35 */Language
					.add("Vaya a www.gnu.org/licenses/lgpl.html para más información");
			Language.add("Sobre engineering Suite");
			Language.add("Preferencias");
			Language.add("Resolver");
			Language.add("Renderizar ecuaciones");
			/* 40 */Language.add("Salir");
			Language.add("Nuevo");
			Language.add("Abrir");
			Language.add("Guardar");
			Language.add("Guardar como");
			/* 45 */Language.add("Exportar como PDF");
			Language.add("Imprimir...");
			// Language.add("//Variable                                  Cuenta");
			// Language.add("//Variable    Cuenta");
			Language.add(com + "Variable" + com + "                          "
					+ com + "Cuenta" + com);
			Language.add(com + "Variable    Cuenta" + com);
			Language.add("\nError inesperado");
			/* 50 */Language.add("Visualizar renderizado");
			Language.add("Gráfica");
			Language.add("Comando >>");
			Language.add("Simbólico");
			Language
					.add(new String(
							"Bienvenido a eSuite Mathematics"
									+ Config.JumpLine
									+ Config.JumpLine
									+ "Escribe "
									+ com
									+ "Help"
									+ com
									+ " para una lista completa de comandos o "
									+ com
									+ "QuickHelp"
									+ com
									+ " para los comandos importantes."
									+ Config.JumpLine
									+ "Este programa es insensible a mayusculas pero lo es para parentesis o corchetes."
									+ Config.JumpLine
									+ "Presiona "
									+ com
									+ "Enter"
									+ com
									+ " para la evaluar sibólicamente o "
									+ com
									+ "CTRL+Enter"
									+ com
									+ " para que sea numéricamente."
									+ Config.JumpLine
									+ "Usa "
									+ com
									+ "Arriba"
									+ com
									+ " y "
									+ com
									+ "Abajo"
									+ com
									+ " para navegar por el historial"
									+ Config.JumpLine
									+ "Deselecciona la opción "
									+ com
									+ "Visualizar renderizado"
									+ com
									+ " para poder copiar del terminal o si tienes problemas de visualización."
									+ Config.JumpLine
									+ "El tiempo límite está definido en el menú "
									+ com + "Preferencias" + com + "."
									+ Config.JumpLine));
			/* 55 */Language.add("Numéricamente");
			Language
					.add("Los metodos GN, DD y HM son algoritmos de optimización, esto activa una rutina para intentar evitar que acaben en un minimo. 0 = desactivado");
			Language.add("-1 = selección automática");
			Language
					.add("Cambia la precision del gradiente para los métodos GN, DD, HM");
			Language.add("Para asignación automática poner el 0");
			/* 60 */Language
					.add("Por defecto LM. Para sistemas grandes prueba DD o HM");
			Language.add("Por defecto Levenberg-Marquardt");
			Language.add("Por defecto 20 s");
			Language.add("Región de confianza >>");
			Language.add("Evitar minimos >>");
			/* 65 */Language
					.add("Los metodos GN, DD y HM son algoritmos de optimización, esto activa una modificacion para intentar evitar que caigan en un mínimo");
			Language.add("Precisión del gradiente >>");
			Language
					.add("Cambia la precision del gradiente de los metodos GN, DD, HM");
			Language.add("Salto maximo >>");
			Language
					.add("Los metodos GN, DD, HM, limitaran su salto máximo al aqui puesto");
			/* 70 */Language.add("Método general >>");
			Language.add("Algoritmo para resolver sistemas de ecuaciones");
			Language.add("Metodo de 1 variable >>");
			Language.add("Algoritmo para resolver ecuaciones de una variable");
			Language.add("Tiempo máx. calc. >>");
			/* 75 */Language.add("Max. valor negativo >>");
			Language.add("Max. valor positivo >>");
			Language.add("Preferencias de gráficas");
			Language
					.add("Tiempo máximo permitido para las operaciones en segundos");
			Language.add("Max. tiempo calc. >>");
			/* 80 */Language.add("Tiempo de cálculo");
			Language.add("200 es el valor recomendado");
			Language.add("No cambies este valor si no sabes lo que haces");
			Language.add("Max Nº iteraciones >>");
			Language.add("Precision >>");
			/* 85 */Language.add("Preferencias");
			Language.add("Aplicar");
			Language.add("Selec. tema  >>");
			Language.add("Tema");
			Language.add("Lenguaje");
			/* 90 */Language.add("Tamaño >>");
			Language.add("Opciones de fuente");
			Language.add("Radianes");
			Language.add("Grados");
			Language.add("Unidades");
			/* 95 */Language.add("Trigonometría");
			Language.add("Selección de unidades");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>General</body></html>");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Ecuaciones</body></html>");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Matemáticas</body></html>");
			/* 100 */Language.add("Reinicia eSuite para aplicar los cambios");
			Language.add("Reiniciar");
			Language.add("El valor debe ser un número positivo");
			Language.add("El valor debe ser un número entero positivo");
			Language.add("El valor debe ser un número positivo o -1");
			/* 105 */Language.add("Introduce las ecuaciones aqui");
			Language.add("Ecuaciones renderizadas");
			Language.add("Ecuaciones escritas apropiadamente");
			Language.add("Mostrar log");
			Language.add("Salida resultados");
			/* 110 */Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Recargar</body></html>");
			Language.add("Reescribe las ecuaciones");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Ayuda</body></html>");
			Language.add("Errores conocidos");
			Language
					.add("Una aplicación para resolver sistemas de ecuaciones no lineales");
			/* 115 */Language
					.add("Una aplicación para el calculo simbólico y numérico");
			Language.add(new String(
					"Usando y * x^(-1) da errores al renderizar"
							+ Config.JumpLine + "usa esto y / x "
							+ Config.JumpLine
							+ "Mejor esto x^(-1) que esto x^-1"));
			Language.add("¿Crear un documento nuevo?");
			Language.add("Va a cerrar eSuite.\n¿Está seguro?");
			Language
					.add("El número de ecuaciones es distinto al de variables.\nMira el Log para ver el número de apariciones de las variables.\nNota: La letra e (mayúscula o minúscula) corresponde a una constante");
			/* 120 */Language.add("Tiempo transcurrido: ");
			Language.add("Operaciones terminadas");
			Language
					.add("Tiempo límite sobrepasado.\nNota: Este número puede ser cambiado en preferencias.");
			Language.add("Caracter ilegal encontrado <");
			Language.add("> en la linea Nº: ");
			/* 125 */Language.add("Caracter inesperado encontrado <");
			Language.add("Operador inesperado encontrado <");
			Language.add("Punto/coma inesperado encontrado <");
			Language.add("No hay signo igual.");
			Language.add("Parentesis extra/falta.");
			/* 130 */Language.add("Parentesis vacio.");
			Language.add("Falta un operador");
			Language.add("Nota: Las variables no pueden empezar con un número");
			Language.add(com + "Residuales" + com);
			Language.add("Buscar >>");
			/* 135 */Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Ejecutar</body></html>");
			Language.add("Resuelve las ecuaciones");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Abrir</body></html>");
			Language.add("Abre un documento guardado");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Guardar</body></html>");
			/* 140 */Language.add("Guarda el documento actual");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Guardar como</body></html>");
			Language.add("Funciones comunes:");
			Language
					.add("<html><body leftmargin=0 topmargin=8 marginwidth=5 marginheight=6>Nuevo</body></html>");
			Language.add("Crea un documento nuevo");
			/* 145 */Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Pdf</body></html>");
			Language.add("Exportar a PDF");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Atrás</body></html>");
			Language.add("Busca hacia atrás desde la actual linea");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Adelante</body></html>");
			/* 150 */Language.add("Busca hacia adelante desde la actual línea");
			Language.add("Tiempo límite sobrepasado.");
			Language.add("Puede cambiar este valor en preferencias.");
			Language.add("Residuales elevados");
			Language
					.add("Puede probar a cambiar el método o a poner otros valores iniciales");
			/* 155 */Language.add("Error al evaluar.");
			Language
					.add("Por favor compruebe en valor inicial de estas variables: ");
			Language.add("o pruebe otro método de resolución.");
			Language.add("Operadores:");
			Language.add("Asignar valor a una variable:");
			/* 160 */Language.add("Eliminar el valor asignado a una variable:");
			Language.add("Representación de una matriz:");
			Language.add("Multiplicación de una matriz y un vector:");
			Language.add("Derivada de una función:");
			Language.add("Integración de una función:");
			/* 165 */Language.add("Inversa de una matriz:");
			Language.add("Integración numérica:");
			Language.add("Determinate de una matriz:");
			Language.add("Descomposición LU de una matriz:");
			Language.add("Matriz Jacobiana:");
			/* 170 */Language.add("Matriz identidad:");
			Language.add("Valores propios de una matriz:");
			Language.add("Vectores propios de una matriz:");
			Language.add("Distancia euclidea:");
			Language.add("Elevar una matriz:");
			/* 175 */Language.add("Matriz de Hilber:");
			Language.add("Trace[]:");
			Language.add("PrimeQ[Number]");
			Language.add("NextPrime[Number]");
			Language.add("Fibonacci[Number]");
			/* 180 */Language.add("Binomial[Number1,Number2]");
			Language
					.add("Busca la solución de una función no lineal con el metodo de Bisección:");
			Language
					.add("Busca la solución de una función no lineal con el metodo de Brent:");
			Language.add("El McLaurin de una función:");
			Language.add("Expandir:");
			/* 185 */Language.add("Factorizar:");
			Language.add("Absoluto:");
			Language.add("Parte real:");
			Language.add("Parte compleja:");
			Language.add("Número Catalan:");
			/* 190 */Language.add("Número Harmocio:");
			Language.add("Factor de integración:");
			Language.add("Comparación:");
			Language.add("Sumatorio:");
			Language.add("Multiplicatorio:");
			/* 195 */Language.add("Compruebe: ");
			Language.add("Operador vacio. Compruebe <");
			Language.add("Errores");
			Language.add("Resultados");
			Language.add("Renderizado");
			/* 200 */Language.add("Ecuaciones");
			Language.add("Valores iniciales");
			Language.add("Ejemplos");
			Language.add("Algoritmos");
			Language.add("Matemáticas");
			/* 205 */Language
					.add("Este programa esta basado en otros programas como MathEclipse, Symja, jCommonsMath, Jeuclid, rSyntaxTextArea, iText and the Optimization Java package cuyos algoritmos de optimización"
							+ " son son los que usa eSuite para resolver los sitemas. Gracias a todos los desarrolladores que decidieron crear software libre.\n\n\n"
							+ "Quiero ademas dar las gracias al Doctor Don Francisco Gaspar por ser mi director de proyecto, a Cristina por apoyarme durante esta etapa y a mi hermano David que me ayudo siempre que lo necesitaba.");
			Language
					.add("eSuite Solver resuelve sistemas de ecuaciones no lineales utilizando algoritmos de región de confianza. Sus características fundamentales son: \n\n");
			Language
					.add("Las ecuaciones pueden escribirse sin ningún orden.\n\n");
			Language
					.add("Los comentarios empiezan con /* o con /** y terminan con */\n\n");
			Language
					.add("Caracteres permitidos: a b c d e f g h i j k l m n o p q r s t u v w x y z 1 2 3 4 5 6 7 8 9 0 + - * / , . ^ ( ) [ ] = _ y el tabulador.\n\n");
			/* 210 */Language
					.add("No importa usar mayúsculas o minúsculas, así que x y X es lo mismo.\n\n");
			Language
					.add("Las variables deben empezar con una letra pero luego pueden contener más signos, por ejemplo, está permitido x23 pero no 3x2.\n\n");
			Language.add("Debe haber una única ecuación por línea.\n\n");
			Language
					.add("La única limitación para el número de ecuaciones es la memoria RAM o la complejidad de estas.\n\n");
			Language
					.add("El campo de búsqueda funciona en una sola dirección partiendo de la posición actual en el texto.\n\n");
			/* 215 */Language
					.add("El archivo guardado es un fichero en texto plano que puede ser abierto con el bloc de notas, con Gedit o similar.\n\n");
			Language
					.add("1) Quiero introducir un logaritmo distinto al natural pero no me lo permite. ¿Qué hago?\n");
			Language
					.add("En eSuite hay dos maneras de introducir algoritmos Ln o Log, pero ambas son iguales, "
							+ "Así que si quieres introducir uno distinto debes usar esta fórmula:\n"
							+ "Log[a,m]=ln[m]/ln[a] \nPor ejemplo: Si quieres hacer un algoritmo con base 10:\n"
							+ "Log(x*y)/Log(10).\n\n");
			Language
					.add("2) El programa dice que hay un error al evaluar. He comprobado todas las ecuaciones pero están bien. ¿Cuál es el problema?\n");
			Language
					.add("Tal vez al evaluar las ecuaciones en distintas iteraciones la Jacobiana llega a un punto singular, por tanto no sería culpa tuya. Puedes usar un algoritmo diferente o cambiar los valores iniciales.\n\n");
			/* 220 */Language
					.add("3) En preferencias, modifico la fuente del texto pero solamente cambia en la ventana de ecuaciones.\n");
			Language
					.add("Es algo normal, porque es necesario que en la ventana de resultados y en log haya una fuente monoespaciada para que los resultados salgan escritos en columnas.\n\n");
			Language
					.add("4) ¿Por qué el tiempo total de cálculo es superior al que he puesto en preferencias como máximo?\n");
			Language
					.add("Eso es porque el tiempo de preferencias en el tiempo máximo para el cálculo de un sistema. Si en tus ecuaciones hay más de un sistema de ecuaciones puede pasar que el tiempo total sea superior.\n\n");
			Language
					.add("5)¿Qué son los residuales y por qué deberían importarme?\n");
			/* 225 */Language
					.add("Los residuales son el resultado de introducir los resultados finales en las ecuaciones. Por tanto, un valor elevado significa que los resultados no son buenos.\n\n");
			Language
					.add("6) Muy bien, me has convencido. ¿Qué quieres decir con elevados?\n");
			Language
					.add("Los residuales elevados dependen de la situación y la precisión que se requiera pero valores por encima de 0.01 son malos.\n\n");
			Language.add("7) ¿Por qué software libre?\n");
			Language
					.add("Porque con software libre el coste de desarrollo es mucho más bajo y mucho más ético.\n");
			/* 230 */Language.add("8) ¿Puedo ayudar?\n");
			Language
					.add("Toda la documentación interna está en inglés para que todo el mundo pueda colaborar, así que sí, ¡bienvenido!\n\n");
			Language.add("Tipos de errores\n\n\n");
			Language.add("Tenemos varios tipos de errores:\n");
			Language
					.add("Carácter ilegal encontrado: Solamente tienes que cambiar el carácter especificado.\n\n");
			/* 235 */Language
					.add("Carácter inesperado. Esto puede deberse a dos signos igual en una ecuación. Elimínalo y solucionado.\n\n");
			Language
					.add("Dos o más operadores contiguos: / * ^ no pueden ir seguidos entre ellos.\n\n");
			Language
					.add("Punto o coma tras una letra: Las variables solamente pueden contener letras, números y _.\n\n");
			Language
					.add("No hay signo igual: ¿Cómo te lo has podido dejar?\n\n");
			Language
					.add("Hay más paréntesis o corchetes de apertura que de cierre. Busca en la ecuación con ayuda del remarcador de paréntesis o corchetes para encontrar el fallo.\n\n");
			/* 240 */Language
					.add("Si una función trigonométrica, logarítmica, exponencial o hiperbólica esta vacía.Example: Sin( ) = 5.\n\n");
			Language
					.add("Error si una variable empieza con número: Bórralo.\n\n");
			Language
					.add("Un operador está vacío. Por ejemplo: x = 2/ or x/( = 3. Solución: Bórralo.\n\n");
			Language
					.add("Una variable contiene algo diferente a un número, letra o _. Elimina el carácter.\n\n");
			Language
					.add("Se ha sobrepasado el tiempo de cálculo por operaciones que se han interrumpido: Esto puede deberse a muchas cosas, pero generalmente es debido a que algún fallo hace que el algoritmo se introduzca en un bucle infinito. Lo mejor es cambiar el punto inicial o cambiar de algoritmo..\n\n");
			/* 245 */Language
					.add("Error al evaluar: Esto quiere decir que el programa ha intentado evaluar una función y no ha obtenido un resultado por ejemplo 1/0. Prueba otro algoritmo, distinto punto inicial o las dos cosas.\n\n");
			Language
					.add("Residuales elevados. Mira Log o FAQ para saber más sobre esto.\n\n");
			Language
					.add("El número de ecuaciones y variables difiere. Mira el Log para saber el número de apariciones de cada variable.\n\n");
			Language
					.add("Error inesperado: Este problema surge cuando el programa no es capaz de rescatar el origen del error, mas sí detecta algún problema. Prueba las anteriores recomendaciones o reinicia el programa.\n\n");
			Language
					.add("Esta sección muestra cómo fue el cálculo y el número de apariciones de las variables.\n");
			/* 250 */Language
					.add("La primera sección, las cuentas, es útil cuando encontramos el error en que el número de variables y ecuaciones difiere, porque nos muestra si hay mal escrita alguna variable.\n");
			Language
					.add("La sección de residuales es importante para saber el nivel de confianza de los resultados. Unos residuales elevados pueden indicar tres cosas: \n\n");
			Language
					.add("El algoritmo ha caído en un mínimo. Prueba cambiando el algoritmo o el punto inicial. También puedes probar Double Dogleg, Line-Search o Hebden-More con el sistema de antimínimos activado. Consulta la sección Preferencias para más información.\n\n");
			Language
					.add("El algoritmo no ha alcanzado una solución. Esto puede deberse a que las ecuaciones son muy complejas o a que el Jacobiano ha alcanzado un punto singular. Puedes probar cambiando el algoritmo o el punto inicial de nuevo.\n\n");
			Language
					.add("Si el algoritmo queda interrumpido a mitad porque el tiempo de cálculo supera al permitido, entonces la solución estará a mitad y por tanto no será fiable.\n\n");
			/* 255 */Language.add("Ventana de resultados.\n\n\n");
			Language
					.add("Desde aquí puedes ver los resultados de las ecuaciones. Las variables se muestran por orden alfabético y sus valores están escritos en función de su valor:\n\n");
			Language.add("Números pequeños: ");
			Language.add("Números normales: ");
			Language.add("Números grandes: ");
			/* 260 */Language.add("Venatana de Log\n\n\n");
			Language
					.add("Si el valor absoluto de un número se encuentra entre 1 e-5, 0 el resultado  se muestra así: 1.23456E-7 .\n\n");
			Language
					.add("Esto es para números que no son ni pequeños ni grandes. La codificación es así: 12345.1234567.\n\n");
			Language
					.add("Para números mayores que 100000. El resultado se muestra así12345.12345E0.\n\n");
			Language.add("Ventana de renderizado\n\n\n");
			/* 265 */Language
					.add("En esta sección las ecuaciones quedan dibujadas de una manera más próxima a como serían, si fuesen escritas en papel.\n");
			Language
					.add("Para hacer esto eSuite utiliza la sintaxis MathML y jEuclid para mostrar el resultado.\n\n");
			Language
					.add("Para convertir una ecuación a sintaxis MathML eSuite llama a MathEclipse para que haga la conversión. Sin embargo, MathEclipse borra los signos * así que hay que convertir * a una letra y luego deshacer el cambio. Por eso incorporamos el botón de ayuda que muestra algunos problemas de este cambio.\n");
			Language.add("Ventana de ecuaciones\n\n\n");
			Language.add("Características: \n\n");
			/* 270 */Language
					.add("Caracteres permitidos: a b c d e f g h i j k l m n o p q r s t u v w x y z 1 2 3 4 5 6 7 8 9 0 + - * / , . ^ ( ) [ ] = _ y tabulador.\n\n");
			Language.add("Coloreado de texto, remarcado de paréntesis.\n\n");
			Language
					.add("Una ecuación por línea. Cada ecuación debe empezar y acabar en la misma línea.\n\n");
			Language
					.add("Dos tipos de comentarios. Verdes con /* y rojos con /** ambos son multilínea y ambos cierran igual, con */.\n\n");
			Language
					.add("No hay límite de filas o columnas. Sin embargo, al exportar a pdf o imprimir, las lineas que sean muy largas quedarán divididas en dos o más líneas, según convenga.\n\n");
			/* 275 */Language
					.add("Puedes usar Deshacer y Rehacer desde el Menú contextual del botón derecho o desde el menú en Editar. No tienen una memoria específica para cada cambio, sino que recuerdan los cambios en bloques.\n\n");
			Language
					.add("Las funciones de Cortar, Copiar y Pegar utilizan el portapapeles del sistema. Funcionan desde el Menú contextual del botón derecho o desde la barra de tareas en Editar, también funcionan los accesos directos desde el teclado.\n\n");
			Language
					.add("eSuite puede trabajar con estas funciones: Sin, Cos, Tan, ArcSin, ArcTan, ArcCos, Sinh, Cosh, Tanh, Log, Ln (que es igual a log), Exp. Además, incorpora dos constantes: e y Pi.\n\n");
			Language.add("Este menú está dividido en tres secciones: \n\n");
			Language.add("1) General\n\n");
			/* 280 */Language
					.add("En trigonometría podremos escoger entre radianes y grados. Esto solamente afecta a eSuite Solver, no a Mathematics.\n\n");
			Language
					.add("Fuente: Se puede modificar la fuente de ecuaciones y el tamaño para todas las ventanas.\n\n");
			Language
					.add("Lenguaje: Puede seleccionarse el lenguaje de la aplicación.\n\n");
			Language
					.add("Temas: Hay cuatro temas. El programa ha sido diseñado para trabajar con Nimbus, sin embargo, el tema que mejor se adapta a los sistemas operativos es System.\n\n");
			Language.add("2) Ecuaciones\n\n");
			/* 285 */Language
					.add("Precisión: Es un criterio de parada para los algoritmos. Valores más pequeños implicarán más tiempo de cálculo. La fórmula es:  si precisión < ((Xnew-Xold)/(Xnew)) entonces parar.\n\n");
			Language
					.add("Número de iteraciones: Si la solución no puede ser alcanzada, entonces el algoritmo parará al pasar un número de iteraciones.\n\n");
			Language
					.add("Tiempo máximo para operaciones: Tiempo tras el cual las operaciones serán interrumpidas.\n\n");
			Language
					.add("Métodos: Consulta la sección Algoritmos para saber más sobre esto.\n\n");
			Language
					.add("Salto máximo: Double Dogleg, Hebden-More y  Line-Search poseen otro criterio de parada que es el salto máximo entre dos iteraciones para evitar que el algoritmo de saltos muy elevados. Por defecto selección automática = 0.\n\n");
			/* 290 */Language
					.add("Precisión del gradiente: Criterio de parada de Double Dogle, Hebden-More y Line-Search. El algoritmo parará si está muy cerca de un maximo o mínimo en donde el gradiente vale cero.\n\n");
			Language
					.add("Evitar mínimos: Si el algoritmo alcanza un minimo parará en Double-Dogleg, Hebden-More y Line-Search puede pedir que se hagan iteraciones de Newton para escapar de ese minimo. Esto puede ser inestable.Por defecto desactivado = 0;\n\n");
			Language
					.add("Región de confianza: Para saber esto mire la sección de algoritmo. Por defecto -1 que significa que el programa escogerá por nosotros.\n\n");
			Language.add("3) Matemáticas\n\n");
			Language
					.add("Tiempo máximo: Tras un tiempo de cálculo, el motor de matemáticas será interrumpido.\n\n");
			/* 295 */Language
					.add("Valor Máximo/Mínimo: Puede seleccionar el valor máximo y mínimo de la sección de gráficas.\n\n");
			Language.add("Valores iniciales\n\n\n");
			Language
					.add("Desde aqui puede escoger el valor inicial de todas las variables. O solo para algunas. O incluso puede poner que las ultimas variables calculadas sean utilizadas como valores iniciales la proxima vez.\n\n");
			Language
					.add("El valor inicial es crucial en la resolución de ecuaciones numericamente. Estos algoritmos solamente buscan una solución por tanto ante el siguiente ejemplo x^2=1 hay dos soluciones:\n"
							+ "x = -1 y x= 1.\nSi el punto inicial es 2 el resultado será 1 pero si el punto inicial es -2 el resultado sera -1.\nEsta es una razón pero hay más.Si el algoritmo empieza muy lejos de la solucion tal vez este no sea capaz de llegar a resolverlo por que por ejemplo la función tenga muchos maximos por el camino"
							+ " y el algoritmo caiga en uno de ellos. O quizas llega a un punto donde la función no existe. Por ejemplo la siguiente ecuación :\n"
							+ "1/(x-1)= -2\nSi evalua en x = 1 El resultado es infinito y por tanto no podra seguir trabajando.\n\n");
			Language.add("1) Valor inicial\n");
			/* 300 */Language
					.add("Esto cambia el valor inicial de las variables.\n\n");
			Language.add("2) Guardar el ultimo valor como punto inicial\n");
			Language
					.add("Esto hará que el algoritmo trabaje mejor ya que para la proxima vez empezara directamente en la solución o si has cambiado las ecuaciones muy probablemente este más cerca del punto final. Por defecto desactivado.\n\n");
			Language.add("3) Poner punto inicial\n");
			Language
					.add("Puedes escoger un punto inicial para cada variable por separado. El boton de borrar elimina todos los valores de vez.");
			/* 305 */Language.add("Ejemplos\n\n\n");
			Language
					.add("Todos estos ejemplos pueden ser resueltos por el programa.\n\n");
			Language.add("Recomendaciones: \n");
			Language
					.add("Deje espacios entre operadores y entre lineas para hacerlo todo mucho mas legible.\n\n");
			Language.add("Ejemplo Nº 1\n\n");
			/* 310 */Language
					.add("Cos(x) + 4 * X = 0\nNo importa si x es mayuscula o minuscula.\n\n");
			Language.add("Ejemplo Nº 2\n\n");
			Language
					.add("Log[x) / Log(10) = 1\nX=10 es el resultado. Es la manera de hacer logaritmos con distinta base. Ademas puede apreciar que da igual usar corchetes que parentesis.\n\n");
			Language.add("Ejemplo Nº 3\n\n");
			Language
					.add("2 * x + y = 1\nx * y = 3\na + b = x\n3 * a * b = 6\nPuede ver que hay un sistema de 4 x 4 sin embargo si resuelve primero el de x e y puede resolverse mediante dos sistemas de 2 x 2. Esto es lo que hace eSuite.\n\n");
			/* 315 */Language.add("Ejemplo Nº 4\n\n");
			Language
					.add("1 / (x - 1) = 2\nSi prueba resolver esta ecuación (sin cambiar el valor inicial) no lo resolverá. Es porque en x = 1 la función vale infinito.Pruebe con valor inicial = 2 usando Line-Search y la resolverá.Sin embargo con valores por debajo de 1 no podra.\n\n");
			Language.add("Ejemplo Nº 5\n\n");
			Language
					.add("Estas ecuaciones las resuelve una a una:\nF = m * a ^ 2\nm = 3,4 * a\na = 2.3 \n\n");
			Language.add("Algoritmos\n\n\n");
			/* 320 */Language.add("Hay dos algoritmos importantes: \n\n");
			Language.add("1) Tarjan: \n");
			Language
					.add("Este algoritmo ordena las ecuaciones. Veamos un ejemplo:\n\n");
			Language
					.add("2 * x + y = 1\na + b = x \nx * y = 3\n3 * a * b = 6\n\n");
			Language
					.add("Esta ecuación puede ser puesta en una matriz de relaciones (relaciones entre funciones y variables) como esta: \n");
			/* 325 */Language.add("\n1.1) Antes de llamar a Tarjan\n\n");
			Language.add("\n1.2) Despues de llamar a Tarjan\n");
			Language.add("X<-->Y y F3<-->F2 han cambiado sus posiciones\n\n");
			Language
					.add("\n1.3) El primer sub-sistema esta coloreado en rojo\n\n");
			Language.add("\n1.4) Despues de resolverlo.\n");
			/* 330 */Language
					.add("La tercera fila solo tiene dos variables ya que la variable en azul ha sido resuelta previamente.\n\n");
			Language.add("\n1.5) Finalmente el ultimo sub-sistema.\n\n");
			Language
					.add("\nComo resultado de este algoritmo hemos visto que hemos resuelto dos sistemas 2x2 en vez uno de 4x4.\n\n");
			Language
					.add("2) Métodos de optimización de región de confianza: \n");
			Language
					.add("Estos algoritmos son globalmente convergentes. Para ver mejor como funcionan veamos un ejemplo:\n\n");
			/* 335 */Language.add("\nPunto inicial: x1=0,7; x2 = -3,3\n");
			Language
					.add("Esta es nuestra ecuación y el punto inicial es el punto rojo..\n\n");
			Language
					.add("Probamos con un radio inicial. Dentro de ese radio buscamos el punto optimo(la cruz roja).\n\n");
			Language
					.add("Si el valor de la función en ese punto es menor, aumentamos el radio de confianza. Y la nueva iteración será en ese punto. Y volvemos a buscar un punto mejor.\n\n");
			Language
					.add("Si en la cruz roja el valor de la función no es menor, reducimos la región de confianza y volvemos a probar.\n\n");
			/* 340 */Language
					.add("Ahora la nueva posición es mejor, asi que nos movemos al punto nuevo e incrementamos el radio.\n\n");
			Language
					.add("Estos pasos se repiten hasta que encontremos la solución.\n\n");
			Language.add("Matematicas\n\n\n");
			Language.add("Caracteristicas: \n\n");
			Language
					.add("A diferencia de eSuite Solver cos, exp, sinh,... deben estar seguidos de corchetes.\n\n");
			/* 345 */Language
					.add("La sección de graficas puede trabajar con varias funciones a la vez.\n\n");
			Language
					.add("Internamente el programa transforma las letras a mayusculas, por eso todas las variables y cuando falla al introducir un comando este sale en mayusculas.\n\n");
			Language
					.add("Las ecuaciones renderizadas no pueden ser copiadas.\n\n");
			Language
					.add("Los comandos y ejemplo pueden ser vistos escribiendo help o quickhelp en la linea de comandos.\n\n");
			Language
					.add("El documento no esta guardado.\n ¿Está seguro de que quiere salir?");
			/* 350 */Language
					.add("Imposible añadir material. Error al abrir el archivo.");
			Language
					.add("Imposible leer el archivo de ThermodynamicalProperties.");
			Language.add("Por favor rellene todos los campos.");
			Language.add("Va a eliminar una sustancia.\n¿Está seguro?");
			Language.add("Va a eliminar una propiedad.\n¿Está seguro?");
			/* 355 */Language.add("Propiedad");
			Language.add("Sustancia");
			Language.add("Información: ");
			Language
					.add("Reinicie esta ventana para trabajar con el nuevo material.");
			Language.add("Formula >>");
			/* 360 */Language.add("Obtener");
			Language.add("Formulas termodinámicas");
			Language.add("Variables");
			Language.add("La sustancia ya tiene esa propiedad.");
			Language.add("Propiedades termodinámicas");
			/* 365 */Language.add("Sustancia/Propiedad no encontrada:");
			Language.add("Formulas termodinámicas");
			Language
					.add("Desde este menú puede añadir formulas termodinámicas a sus ecuaciones o incluir las suyas propias en la base de datos del programa.");
			Language.add("Recomendaciones: ");
			Language
					.add("Use nombres de variables en vez de letras. Por ejemplo: Temperatura en vez de T.");
			/* 370 */Language
					.add("Las formulas deben añadirse como ecuaciones y con la sintaxis del programa. Por ejemplo: Presion * Volumen = mol * R * Temperatura.");
			Language
					.add("Use el area de información para incluir los límites de la formula, la precisión, etc.");
			Language
					.add("Las secciones: Sustancia, propiedad y formula son obligatorias.");
			Language
					.add("Puede eliminar sustancias y materiales asi que tenga cuidado.");
			Language
					.add("Propiedad no encontrada: Usted ha llamado a una función termodinámica ( Sustancia.propiedad(var1,var2) ) pero o la propiedad no existe o la ha escrito mal.\n\n");
			/* 375 */Language.add("¿Que desea incluir en el trabajo?");
			Language.add("Todo");
			Language
					.add("Si va a calcular la temperatura o presión de una formula de entalpia, entropia, cp, etc. probablemente tenga que darle un valor inicial a la propiedad que desea calcular.");
			Language.add("Limite de una función:");
			Language.add("Resolver un sistema de ecuaciones:");
			/* 380 */Language.add("Ceros de una función:");
			Language.add("Ceros numéricos de una función:");
			Language
					.add("Las siguientes variables han alcanzado un valor complejo");
			Language
					.add("Modifique las ecuaciones, valores iniciales o los algoritmos usados.");
			Language
					.add("Valor complejo alcanzado: Debido a las ecuaciones o al algoritmo usado, algunas variables han alcanzado el plano complejo. Lo mas probable es que una ecuación este mal escrita. Sin embargo, puedes probar a resolverlo en la sección Mathematics que si trabaja con números complejos.\n\n");
		} else {// If any error, the english
		/* 0 */
			Language.add("Cut");
			Language.add("Copy");
			Language.add("Paste");
			Language.add("Equations");
			Language.add("Results");
			/* 5 */Language.add("Log");
			Language.add("Default initial value >>");
			Language.add("Change the initial value of all the variables");
			Language.add("as initial points for");
			Language.add("next iterations");
			/* 10 */Language.add("Store values");
			Language.add("Save calculated values");
			Language.add("Remove");
			Language.add("Add");
			Language.add("Clear");
			/* 15 */Language
					.add("You are going to remove all the initial values.\nAre you sure?");
			Language.add("Clear values");
			Language.add("Close");
			Language.add("Value >>");
			Language.add("Variable >>");
			/* 20 */Language.add("Initial values");
			Language.add("Please introduce a variable");
			Language.add("You are about to change the value of");
			Language.add("Are you sure?");
			Language.add("Change value");
			/* 25 */Language.add("The value must be a number");
			Language.add("Variable not found to erase");
			Language.add("Edit");
			Language.add("Help");
			Language.add("File");
			/* 30 */Language.add("About");
			Language.add(">> Final year project of Pablo Salinas Cortés ");
			Language.add(">> Project manager : Dr. Francisco José Gaspar");
			Language.add(">> Current version ");
			Language.add("This program is licensed under the LGPL");
			/* 35 */Language
					.add("See www.gnu.org/licenses/lgpl.html for more information");
			Language.add("About engineering Suite");
			Language.add("Preferences");
			Language.add("Solve");
			Language.add("Render equations");
			/* 40 */Language.add("Exit");
			Language.add("New");
			Language.add("Open");
			Language.add("Save");
			Language.add("Save As");
			/* 45 */Language.add("Export to PDF");
			Language.add("Print...");
			Language.add(com + "Variable" + com + "                          "
					+ com + "Count" + com);
			Language.add(com + "Variable    Count" + com);
			Language.add("\nUnexpected error");
			/* 50 */Language.add("Rendered print");
			Language.add("2D Plot");
			Language.add("Command >>");
			Language.add("Symbolic");
			Language
					.add(new String(
							"Welcome to the eSuite Mathematics"
									+ Config.JumpLine
									+ Config.JumpLine
									+ "Type "
									+ com
									+ "Help"
									+ com
									+ "for the complete commands list or "
									+ com
									+ "QuickHelp"
									+ com
									+ " for the main commands."
									+ Config.JumpLine
									+ "This program is case-insensitive but sensitive to brackets "
									+ "or parenthesis."
									+ Config.JumpLine
									+ "Press "
									+ com
									+ "Enter"
									+ com
									+ " for the symbolic evaluator and "
									+ com
									+ "CTRL+Enter"
									+ com
									+ " for the numerical evaluator."
									+ Config.JumpLine
									+ "Use "
									+ com
									+ "Up"
									+ com
									+ " & "
									+ com
									+ "Down"
									+ com
									+ " to navigate over inputs"
									+ Config.JumpLine
									+ "Uncheck the "
									+ com
									+ "Render Print"
									+ com
									+ " option in case of copying from terminal or command printing issues."
									+ Config.JumpLine + "Time limit is set on "
									+ com + "Preferences" + com + " menu."
									+ Config.JumpLine));
			/* 55 */Language.add("Numerical");
			Language
					.add("The GN, DD and HM methods are methods for optimization, this activate a modification trying to avoid this methods falling in a minimum. 0 = disabled");
			Language.add("-1 means automatic selection");
			Language
					.add("This changes the gradient precission of the method GN, DD, HM");
			Language.add("For automatic assignation put 0");
			/* 60 */Language
					.add("By default LM. For large system use DD or HM");
			Language.add("By default Levenberg-Marquardt");
			Language.add("By default 20 s");
			Language.add("Trust region radius >>");
			Language.add("Avoid minimum >>");
			/* 65 */Language
					.add("The GN, DD and HM methods are methods for optimization, this activate a modification trying to avoid this methods falling in a minimum");
			Language.add("Gradient precission >>");
			Language
					.add("This change the gradient precission of the method GN, DD, HM");
			Language.add("Max. step jump >>");
			Language
					.add("The methods GN, DD, HM, will limite their maximum step to the one specified here");
			/* 70 */Language.add("General method >>");
			Language.add("Method for solving system of equations");
			Language.add("One variable method >>");
			Language.add("Method for solving one equation system");
			Language.add("Maximum calc. time >>");
			/* 75 */Language.add("Max. negative value >>");
			Language.add("Max. positive value >>");
			Language.add("Plot preferences");
			Language.add("Maximun time allowed for an operation in seconds");
			Language.add("Max. calculation time >>");
			/* 80 */Language.add("Calculation time");
			Language.add("200 is the recomended value");
			Language
					.add("Do not change this value unless you know what are you doing");
			Language.add("Max Nº Iterations >>");
			Language.add("Precision >>");
			/* 85 */Language.add("Settings");
			Language.add("Apply");
			Language.add("Set theme  >>");
			Language.add("Theme");
			Language.add("Language");
			/* 90 */Language.add("Size >>");
			Language.add("Font options");
			Language.add("Radians");
			Language.add("Degrees");
			Language.add("Unit System");
			/* 95 */Language.add("Trigonometrics");
			Language.add("Units selection");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>General</body></html>");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Equations</body></html>");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Math</body></html>");
			/* 100 */Language
					.add("Restart eSuite in order to apply the changes");
			Language.add("Restart");
			Language.add("The value must be a positive number");
			Language.add("The value must be a positive integer number");
			Language.add("The value must be a positive number or -1");
			/* 105 */Language.add("Introduce the equations here");
			Language.add("Redered Equations");
			Language.add("Equations writed properly");
			Language.add("Show log");
			Language.add("Results ouput");
			/* 110 */Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Refresh</body></html>");
			Language.add("Repaint the equations");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Help</body></html>");
			Language.add("Known erros");
			Language.add("An aplication to solve non linear equation system");
			/* 115 */Language
					.add("An aplicattion for symbolic and numerical evaluation");
			Language.add(new String(
					"Using y * x^(-1) gives some erros while rendering"
							+ Config.JumpLine + "Use y / x instead "
							+ Config.JumpLine + "Use x^(-1) better than x^-1"));
			Language.add("Create a new document?");
			Language.add("You are going to close eSuite.\nAre you sure?");
			Language
					.add("Number of equations differs from the variables.\nSee log to know the variables aparition count.\nNote:E or e it's a constant.");
			/* 120 */Language.add("Time elapsed: ");
			Language.add("Operations finished");
			Language
					.add("Time limit exceeded.\nYou can change this value in preferences.");
			Language.add("Illegal character found <");
			Language.add("> at line Nº: ");
			/* 125 */Language.add("Unexpected character found <");
			Language.add("Unexpected operator found <");
			Language.add("Unexpected dot/comma found <");
			Language.add("Equal sign missing.");
			Language.add("Parenthesis extra/missing.");
			/* 130 */Language.add("Empty parenthesis.");
			Language.add("Operator missing.");
			Language.add("Note: variables can't start with a number");
			Language.add(com + "Residuals" + com);
			Language.add("Search >>");
			/* 135 */Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Play</body></html>");
			Language.add("Solves the equations");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Open</body></html>");
			Language.add("Open a saved document");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Save</body></html>");
			/* 140 */Language.add("Save current document");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Save as</body></html>");
			Language.add("Common functions:");
			Language
					.add("<html><body leftmargin=0 topmargin=8 marginwidth=5 marginheight=6>New</body></html>");
			Language.add("Create a new document erasing the actual");
			/* 145 */Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Pdf</body></html>");
			Language.add("Export to a PDF document");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Previous</body></html>");
			Language.add("Search backward from the current line");
			Language
					.add("<html><body leftmargin=0 topmargin=6 marginwidth=5 marginheight=6>Next</body></html>");
			/* 150 */Language.add("Search forward from the current line");
			Language.add("Time limit exceeded.");
			Language.add("You can change this value in preferences.");
			Language.add("Residuals too High");
			Language
					.add("You can try changing the initial value or the solver method");
			/* 155 */Language.add("Error while evaluating.");
			Language.add("Please check initial values of these variables: ");
			Language.add("or change the solver method.");
			Language.add("Operators:");
			Language.add("Assing value to a variable:");
			/* 160 */Language.add("Clear the value assigned to a variable:");
			Language.add("Representation of a matrix:");
			Language.add("Multiplication of an array and a vector:");
			Language.add("Derivative of a function:");
			Language.add("Integrate of a function:");
			/* 165 */Language.add("Inverse of a matrix:");
			Language.add("Numerical integrate:");
			Language.add("Determinat of a matrix:");
			Language.add("LU decomposition of a matrix:");
			Language.add("Jacobi matrix:");
			/* 170 */Language.add("Identity matrix:");
			Language.add("Eigenvalues of a matrix:");
			Language.add("Eigenvectors of a matrix:");
			Language.add("Euclidian distance:");
			Language.add("MatrixPower:");
			/* 175 */Language.add("HilberMatrix:");
			Language.add("Trace[]:");
			Language.add("PrimeQ[Number]");
			Language.add("NextPrime[Number]");
			Language.add("Fibonacci[Number]");
			/* 180 */Language.add("Binomial[Number1,Number2]");
			Language
					.add("Find the root of a non-linear function using the bisection method:");
			Language
					.add("Find the root of a non-linear function using the brent method:");
			Language.add("McLaurin of a function:");
			Language.add("Expand:");
			/* 185 */Language.add("Factor:");
			Language.add("Absolute:");
			Language.add("Real part:");
			Language.add("Complext part:");
			Language.add("Catalan number:");
			/* 190 */Language.add("Harmonic number:");
			Language.add("Factor Integer:");
			Language.add("Comparation:");
			Language.add("Sum:");
			Language.add("Product:");
			/* 195 */Language.add("Check: ");
			Language.add("Empty operator. Check  <");
			Language.add("Errors");
			Language.add("Result");
			Language.add("Render");
			/* 200 */Language.add("Equations");
			Language.add("Initial Values");
			Language.add("Examples");
			Language.add("Algorithms");
			Language.add("Mathematics");
			/* 205 */Language
					.add("This program is based in other java programs like MathEclipse, Symja, jCommonsMath, Jeuclid,"
							+ "rSyntaxTextArea, iText, swingx and the Optimization Java package which optimization algorithm are "
							+ "used in eSuite. So Thanks to all the developers that decided to use and create free software.\n\n\n"
							+ "Also i want to thanks Francisco Gaspar for being my project manager, Cristina for "
							+ "supporting me during this part of my life and my brother David that helped me when i needed it.");
			Language
					.add("eSuite Solver solves systems of non-linear equations systems using trust region methods. Some characteristics:\n\n");
			Language.add("The equations can be written with no order.\n\n");
			Language
					.add("Comments starts with /* or with /** and finish with */\n\n");
			Language
					.add("The allowed characters are: a b c d e f g h i j k l m n o p q r s t u v w x y z 1 2 3 4 5 6 7 8 9 0 + - * / , . ^ ( ) [ ] = _ and Tabulator.\n\n");
			/* 210 */Language
					.add("The program is case insensitive so x and X are the same for the program.\n\n");
			Language
					.add("Variables must start with a letter but later they can contain any sign, which is allowable, except the operators for example x34b is allowed but 34xb isn't.\n\n");
			Language
					.add("Only one equation per line is allowed and everyone must have an equal sign.\n\n");
			Language
					.add("The only limitation for the number of equations are the memory RAM and the complexity of the equations.\n\n");
			Language
					.add("The search field works in one direction starting from the actual caret position.\n\n");
			/* 215 */Language
					.add("The saved file is a plain text file which can be open with the notepad or gedit.\n\n");
			Language
					.add("1) I want to introduce a different logarithm than the natural but i can't. What can i do?\n");
			Language
					.add("In eSuite you have two ways to introduce a logarithm but both are the same, ln and log"
							+ " so if you want to use a different base you must use this formula:\n"
							+ "Log[a,m]=ln[m]/ln[a] \nfor example: if you want a logarithm of base 10 you would write this:\n"
							+ "Log(x*y)/Log(10).\n\n");
			Language
					.add("2) The program says that there is an error while evaluating and i have checked all the equations"
							+ " and they are right. What's the problem?\n");
			Language
					.add("Maybe your equations falls in a point where the Jacobian matrix became singular therefore it's not your fault."
							+ " You can use a different algorithm or you can try changing the initial value of the variables.\n\n");
			/* 220 */Language
					.add("3) In preferences i change the font type but only in the equation window the font changes.\n");
			Language
					.add("That is because in the Log window and in the result window a monospace typography is necessary to make the results be written in columns.\n\n");
			Language
					.add("4) Why the time elapsed is higher that the one i have set in preferences as maximum?\n");
			Language
					.add("That is because that time is for internal operations not for the whole operations,for example"
							+ "if you have two system of equations and the time is set on 20 seconds the maximum time is 40 seconds.\n\n");
			Language
					.add("5) What are the residuals and why i should care about?\n");
			/* 225 */Language
					.add("The residuals are the result of introducing the variables in the equations, so if residuals are high is because the final result it's not acceptable.\n\n");
			Language
					.add("6) Ok, you have convinced me, however, what means residuals high?\n");
			Language
					.add("The residuals are high depending of the situation and the necessary precision, but if you want a reference... values higher than 0.01 are bad.\n\n");
			Language.add("7) Why free software?\n");
			Language
					.add("Why not? free software is the future thanks to their low cost and i have developed this thanks to free software so i want to contribute to it too. And i don't like programs that makes you accept"
							+ " a contract.\n");
			/* 230 */Language.add("8) Can i contribute?\n");
			Language
					.add("Of course you can, all the internal documentation, Javadoc, is in english and everybody is welcome to help\n\n");
			Language.add("Kind of errors\n\n\n");
			Language.add("We have many kind of errors:\n");
			Language
					.add("Illegal character found: you only have to change the character in the specified line.\n\n");
			/* 235 */Language
					.add("Unexpected character, again you only have to change the character. This can be due to two equal sign in the same equation for example.\n\n");
			Language
					.add("Two operators followed: / * ^ can't be followed, you only have the change the equation.\n\n");
			Language
					.add("Dot or comma after a letter: Variables only have numbers, letters, and _ nothing else. Again you only have to change the remove the dot or comma\n\n");
			Language
					.add("If there is no equal sign in a formula. How was you able to forget it! This is about equations!\n\n");
			Language
					.add("There are more open parenthesis/clasp than close parenthesis/clasp. You have to look the equation for the forgotten parenthesis/clasp. ESuite doesn't care about"
							+ "parenthesis or clasp so you can try changing all the clasp to parenthesis, or viceversa, and using the parenthesis assistant for making your work easier\n\n.");
			/* 240 */Language
					.add("If a trigonometric function, a logarithm, an exponential, or a hyperbolic function is empty.\n"
							+ "I.E. Sin( ) = 5.\n\n");
			Language.add("If a variable starts with a number: Remove it.\n\n");
			Language
					.add("If an operator is empty. For example: x = 2/ or x/( = 3. Solution: Erase it.\n\n");
			Language
					.add("if a variable contains something different from a letter, number or _. Remove the problematic character.\n\n");
			Language
					.add("If the time limit per operation is exceeded the operations will be stopped. This can be because of several things but usually this is since "
							+ "you have a low operations time or because some operations failure that introduce the equations in an infinite loop so you have to change the algorithm"
							+ "or you should try a different starting point for all or some variables.\n\n");
			/* 245 */Language
					.add("Error while evaluating: This message means that the program has tried to evaluate something with no result, for example 1/0 or an equations with two or more variables."
							+ "Try changing the algorithm or the starting point, if the problem continues try restarting eSuite or if not, you should try writing the equations in a different way.\n\n");
			Language
					.add("Residuals too high. See the Log or FAQ section to know what does this means.\n\n");
			Language
					.add("Number of equations and variables do not match. See the Log for knowing the count appearance of the variables to know if you didn't write a variable properly"
							+ " or just maybe you need more equations.\n\n");
			Language
					.add("Unexpected error: This is a kind of error where the origin is unknown so try doing all the recommendations of the previous errors.\n\n");
			Language
					.add("This section show how was the calculation and also shows the count appearance of the variables.\n");
			/* 250 */Language
					.add("The first section, the count, is useful when the error window Number of equations and variables do not match. For counting the appearance of variables and then see if wrote a variable bad.\n");
			Language
					.add("The residuals section is important to know how much you can trust the results of the algorithm. Low residuals means that the result of the operations is good. But a high residuals can mean three things: \n\n");
			Language
					.add("The algorithm has fallen into a minimum of the equations. Try changing the algorithm or the starting point. Or you can try using Double Dogleg, Line-Search or Hebden-More with the antiminimum activated."
							+ "See preferences for more information.\n\n");
			Language
					.add("The algorithm haven't reached a solution. This can be due to the equations are too complex or because the Jacobian matrix of the equations has fallen into a singular point."
							+ " Again yo can try using a different method or setting a new initial point.\n\n");
			Language
					.add("If the algorithm is interrupted at half because of the time limit or since a different error then the residuals will be high as a result of that interruption.\n\n");
			/* 255 */Language.add("Result window\n\n\n");
			Language
					.add("From here you can see the result of the equations. The variables are shown in alphabetical order"
							+ " and the are wrote differently depending of their value:\n\n");
			Language.add("Small numbers: ");
			Language.add("Average number: ");
			Language.add("Big numbers: ");
			/* 260 */Language.add("Log window\n\n\n");
			Language
					.add("If the absolute value of the number is between 1 e-5 and 0 the result value is like this: 1.23456E-7 \n\n");
			Language
					.add("This for numbers between small numbers and bug numbers. The codification is this: 12345.1234567.\n\n");
			Language
					.add("For numbers bigger than 100000. The result is shown this way: 12345.12345E0\n\n");
			Language.add("Render window\n\n\n");
			/* 265 */Language
					.add("In this section the equations are written more properly. As if they were written in a paper.\n");
			Language
					.add("In order to do this eSuite use the MathMl syntaxes and jEuclid to show the final result.\n\n");
			Language
					.add("To convert from an equation to the MathMl syntaxes eSuite calls to MathEclipse that make that conversion. However MathEclipse erase the multiplication sign so to maintain"
							+ " this symbols the multiplication sign is transformed to a letter and later re-transformed to *. That's why known issues button exists, because there are some exception in which this conversion doesn't work properly.\n");
			Language.add("Equation window\n\n\n");
			Language.add("Characteristics: \n\n");
			/* 270 */Language
					.add("Allowed characters are: a b c d e f g h i j k l m n o p q r s t u v w x y z 1 2 3 4 5 6 7 8 9 0"
							+ " + - * / , . ^ ( ) [ ] = _ and Tabulator.\n\n");
			Language.add("Highlight text, bracket matching.\n\n");
			Language
					.add("One equation per line, and an equation must start and finish in the same line.\n\n");
			Language
					.add("Two kind of comments. Green comments starts with /* and red comments starts with /** both finish with */ and both are multiline comments.\n\n");
			Language
					.add("There are no row or column limits to write.However if you print or export to PDF the equations and there are one or more lines which equations are too long then they will be cutted and "
							+ "written in two or more lines if necessary.\n\n");
			/* 275 */Language
					.add("You can use Undo/Redo with the contextual menu of the rigth click, from the tool bar or with the keyboard shortcut ctrl+z for undo and ctrl+y for redo. Undo and redo works with blocks, that means they "
							+ "do not remember everything, they make and snapshot for example after you type 5 letters.\n\n");
			Language
					.add("Cut, copy and Paste use the clipboard of the system. They works with the menu of the rigth click with the shortcuts of the keyborad such as ctrl+c for copying, ctrl+p to paste "
							+ "and ctrl+x for cutting.\n\n");
			Language
					.add("eSuite can handle all this functions: Sin, Cos, Tan, ArcSin, ArcTan, ArcCos, Sinh, Cosh, Tanh, Log, Ln (which is the same to Log), Exp. And also has to constants e and Pi.\n\n");
			Language.add("This menu is divided in three sections: \n\n");
			Language.add("1) General\n\n");
			/* 280 */Language
					.add("In trigonometric, you can select degrees or radians. This change only will take effect in the eSuite Solver not in mathematics.\n\n");
			Language
					.add("Font: You can select the font of the solver window and the font size of all the Solver windows.\n\n");
			Language.add("Language: You can select the language.\n\n");
			Language
					.add("Themes: There are four themes. The program has been designed to use with the nimbus theme, and the default theme is nimbus. However if you want the program to be more integrated with your system, select system theme"
							+ ". This theme is the same of your operating system.\n\n");
			Language.add("2) Equations\n\n");
			/* 285 */Language
					.add("Precision: this sets stop criteria for the algorithms. Lower values means higher precision but more time to accomplish the calculations. The stop criteria is the difference between to steps: if precision < ((Xnew-Xold)/(Xnew)) the stop.\n\n");
			Language
					.add("Number of iterations: If the solution can't be reach the algorithm must stop by other criteria. Number of iteration mean how much try do you want to try before stopping the algorithm. 200 is a good value. It is very difficult that you need a higher value.\n\n");
			Language
					.add("Maximum time per operations: As the Number of iterations if the algorithm does not find a solution it must be stopped. A different criteria is time. But this is the time for an iteration, not for the whole operations. That means that if you set 20 seconds the"
							+ " operation total time can be 60 if there are more than one equation system to solve. Which is usual.\n\n");
			Language
					.add("Methods: See the algorithm part to know more about this.\n\n");
			Language
					.add("Maximum step: The Double Dogleg, Hebden-More and the Line-Search method have another stop criteria that is maximum step between two iterations.This can be useful to avoid the algorithm jump to an unstable point. By default automatic selection = 0.\n\n");
			/* 290 */Language
					.add("Gradient precision: This is a stop criteria for the algorithm Double Dogle, Hebden-More and Line-Search. The algorithm will stop if the point is near a maximum or a minimum. That means if the gradient is close to zero.\n\n");
			Language
					.add("Avoid Minimum: If the algorithm finds a minimum it will stop so for the Double-Dogleg, Hebden-More and Line-Search you can set how many Newton iterations you want to do if the algorithms falls in a minimum. This is in order to escape from that minimum but it can be unstable. By default disabled = 0;\n\n");
			Language
					.add("Trust region: To know about this see the algorithm section. By default -1. That means that the algorithm will select Trust region radius.\n\n");
			Language.add("3) Mathematics\n\n");
			Language
					.add("Maximum time: If after the specified time the mathematics engine has not finish the calculation it will be stopped. Just the same of the solver time stop criteria.\n\n");
			/* 295 */Language
					.add("Maximum/Minimum value: You can select the maximum and minimum value of the plot area.\n\n");
			Language.add("Initial Values\n\n\n");
			Language
					.add("From here you can set the initial values for all the variables. You can change the initial value for some, and you can make the last calculated values be used as the initial values for the next time.\n\n");
			Language
					.add("The initial value is crucial in the resolution of equations with numerical algorithms. Because this methods only will find one solution. For example in the equation x^2=1 there are two solutions:\n"
							+ "x = -1 and x= 1.\nSo if the initial point is set in 2 the result will be 1 but if the initial point is set in -2 the result will be -1.\nThis is only one reason but there are one much more important than that. If the algorithm starts too far from the solution maybe the algorithm won't be able to reach a solution due to for example the equation has too many maximum on the way "
							+ "and the algorithm always fall in one of them. Or maybe because the algorithms falls in a point were the equations does not exist. For example in the equation :\n"
							+ "1/(x-1)= -2\nif the algorithm try x = 1 the result is infinitum so it won't be capable of solving it.\n\n");
			Language.add("1) Initial Value\n");
			/* 300 */Language
					.add("This change the initial value for all the variables.\n\n");
			Language.add("2) Save last value as initial point\n");
			Language
					.add("This will make next solves to be calculated faster. Also this may improve the capabilities of the algorithm because if add new equations but the last calculated value was good then the new value should be near of the last. By default disabled.\n\n");
			Language.add("3) Set initial point\n");
			Language
					.add("You can change the initial value of individual variables. The clear button erase all the individual initial values.");
			/* 305 */Language.add("Examples\n\n\n");
			Language
					.add("All this examples can be cut and copied in the equation window if you want to solve them.\n\n");
			Language.add("Recommendation: \n");
			Language
					.add("Leave one space between an operator and the next/previous number/variable/parenthesis to make you equations more legible. Also leave one blank line between equations to make your equations even more legible.\n\n");
			Language.add("Example Nº 1\n\n");
			/* 310 */Language
					.add("Cos(x) + 4 * X = 0\nAs you can see does not matter that the X is in upper and smaller case\n\n");
			Language.add("Example Nº 2\n\n");
			Language
					.add("Log[x) / Log(10) = 1\nX=10 is the result. This is the way for making different logarithms. Also you can se that the use of claps or parenthesis doesn't matter.\n\n");
			Language.add("Example Nº 3\n\n");
			Language
					.add("2 * x + y = 1\nx * y = 3\na + b = x\n3 * a * b = 6\nHere you can appreciate that there are for equations that can be solved as a one 4 x 4 equation system or as two 2 x 2 equation system if the first equation system is the [x,y] system. This is what eSuite does. Divides the equation system into subsystems.\n\n");
			/* 315 */Language.add("Example Nº 4\n\n");
			Language
					.add("1 / (x - 1) = 2\nIf you try to solve this equation (and you have change nothing on initial values) you will find that eSuite gives you a problem. That's because the initial point is 1 and the result of evaluating that equation in one is infinitum.You can try setting the initial point to 2 and using Line-Search and it will be solved.However if you try a negative number, or smaller than 1 possibly the equation won't be solved.\n\n");
			Language.add("Example Nº 5\n\n");
			Language
					.add("This equations are solved one by one:\nF = m * a ^ 2\nm = 3,4 * a\na = 2.3 \n\n");
			Language.add("Algorithms\n\n\n");
			/* 320 */Language.add("There are two main algorithms: \n\n");
			Language.add("1) Tarjan: \n");
			Language
					.add("This algorithm puts a equation system in order, to see if the equation system can be subdivided. Lets see an example:\n\n");
			Language
					.add("2 * x + y = 1\na + b = x \nx * y = 3\n3 * a * b = 6\n\n");
			Language
					.add("This equation can be put in a relation matrix (relations between function and variables) like this: \n");
			/* 325 */Language.add("\n1.1) Before calling Tarjan\n\n");
			Language.add("\n1.2) After calling Tarjan\n");
			Language
					.add("The X<-->Y and F3<-->F2 have changed their positions\n\n");
			Language
					.add("\n1.3) The first sub-equation system is colored in red\n\n");
			Language.add("\n1.4) After solving it.\n");
			/* 330 */Language
					.add("The third row has only two variables because the variable in blue has been solved with the first sub-equation system\n\n");
			Language.add("\n1.5) Finally the last sub-equation system\n\n");
			Language
					.add("\nAs a result of this algorithm we have seen that instead of solving a 4 x 4 equation system we have solved two equation system of 2 x 2.\n\n");
			Language.add("2) Trust Region optimization methods: \n");
			Language
					.add("This kind of algorithms are globally convergent and for explain how they works lets see and example:\n\n");
			/* 335 */Language.add("\nInitial point: x1=0,7; x2 = -3,3\n");
			Language
					.add("This is our equation. And the start position is the red dot.\n\n");
			Language
					.add("We try with an initial radius. Inside that radius the algorithm search the optimus position(the red cross).\n\n");
			Language
					.add("If the value of the function in the new position is lower, then the trust region radius is increased. And the next iteration will be at that position. And again we search a better position.\n\n");
			Language
					.add("If in the red cross position the value of the function is not lower, we will reduce the trust region radius and we will try again.\n\n");
			/* 340 */Language
					.add("Now the new position is better, so we move to that position and the trust region radius will be increased.\n\n");
			Language
					.add("This steps are repeated until the solution is founded\n\n");
			Language.add("Mathematics\n\n\n");
			Language.add("Characteristics: \n\n");
			Language
					.add("Unlike eSuite Solver the functions like cos, exp, sinh,... must be followed by clasps.\n\n");
			/* 345 */Language
					.add("Plot can handle more than one function at the same time\n\n");
			Language
					.add("Internally the program translates the functions to upper case, thats why if fail introducing one the result is in capital letters.\n\n");
			Language
					.add("The rendered print can't be copied to the clipboard.\n\n");
			Language
					.add("Commands and examples can be see in the program by typing help or quickhelp.\n\n");
			Language
					.add("The document is not saved.\n Are you sure you want to quit?");
			/* 350 */Language
					.add("Unable to add the material. Error while opening the file.");
			Language.add("Unable to read the file ThermodynamicalProperties.");
			Language.add("Please fill all the fields.");
			Language.add("You are going to erase a substance.\nAre you sure?");
			Language.add("You are going to remove a property.\nAre you sure?");
			/* 355 */Language.add("Property");
			Language.add("Susbtance");
			Language.add("Information: ");
			Language
					.add("Restart this window to work with the new substance/property.");
			Language.add("Formula >>");
			/* 360 */Language.add("Get");
			Language.add("Thermodynamic formulas");
			Language.add("Variables");
			Language.add("The Sustance has already that property.");
			Language.add("Thermodynamic properties");
			/* 365 */Language.add("Substante/Property not found:");
			Language.add("Thermodynamic formulas");
			Language
					.add("From this menu you can add material properties to your equations or you can create and store more formulas.");
			Language.add("Recommendations: ");
			Language
					.add("Use the name of the variable instead a letter. I.E: Temperature instead of T.");
			/* 370 */Language
					.add("Formulas must be added in an equation form. I.E: Pressure * Volume = mol * R * Temperature.");
			Language
					.add("Use the information area to introduce the validity limits of the equations, the accuracy, etc.");
			Language
					.add("The sections: Substance, properties and the formula are obligatory.");
			Language
					.add("You can remove substances and properties so be careful.");
			Language
					.add("Property not found: You have call to a thermodynamic substance ( Substance.Property(var1,var2) ) however you have fail writing the property.\n\n");
			/* 375 */Language.add("What do you want to include in the queue?");
			Language.add("Everything");
			Language
					.add("if you are going to calculate the temperature o presion from an enthalpy, entropy, Cp, etc. equation probably the variable will need an initial guess.");
			Language.add("Limit of a function:");
			Language.add("Solve a system of N equations:");
			/* 380 */Language.add("Roots of a function:");
			Language.add("Numerical roots of a function:");
			Language.add("The following variables has reached a complex value");
			Language
					.add("Modify the equations, initial values or the algorithms used.");
			Language
					.add("Complex value reached: Due to your equations or because the algorithms, some variables have reached a complex value. The most probably thing is that one equation is wrong. However, you can try solving in in the Mathematics section, which can work with complex numbers.\n\n");
		}

	}

}