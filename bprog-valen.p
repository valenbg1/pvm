// Ini puntero cima
apila(14)
desapila_dir(0)

// Salto 1º instr del prog
ir_a(683)

// Trad de LeeValor(int & valor) delta=3, N=2
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(2)
desapila_ind
desapila_dir(2)
apila_dir(0)
apila(3)
suma
desapila_dir(0)

apila_dir(2)
apila(0)
suma
apila_ind
lee
desapila_ind

apila_dir(1)
apila(1)
suma
apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(-1)
igual
desapila_ind

// Epílogo
apila_dir(0)
apila(3)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(2)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind

// Trad de AlmacenaValor() delta=2, N=3
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(3)
desapila_ind
desapila_dir(3)
apila_dir(0)
apila(2)
suma
desapila_dir(0)

apila_dir(2)
apila(0)
suma
apila_ind
reserva(3)
desapila_ind

apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(0)
suma
apila_dir(1)
apila(2)
suma
apila_ind
desapila_ind

apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(1)
suma
apila(0)
desapila_ind

apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(2)
suma
apila(0)
desapila_ind

// Epílogo
apila_dir(0)
apila(2)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(3)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind

// Trad de GuardaValor(TArbol & arbol) delta=3, N=2
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(2)
desapila_ind
desapila_dir(2)
apila_dir(0)
apila(3)
suma
desapila_dir(0)

apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(0)
igual
ir_f(132)

// Prellamada AlmacenaValor()
apila_dir(0)
apila(3)
suma
apila_dir(0)
apila(1)
suma
apila(131)
desapila_ind
ir_a(44)
ir_a(202)

apila_dir(1)
apila(2)
suma
apila_ind
apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(0)
suma
apila_ind
menor
ir_f(167)

// Prellamada GuardaValor(arbol->.izq)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(1)
suma
desapila_ind
apila_dir(0)
apila(1)
suma
apila(166)
desapila_ind
ir_a(104)
ir_a(202)

apila_dir(1)
apila(2)
suma
apila_ind
apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(0)
suma
apila_ind
mayor
ir_f(202)

// Prellamada GuardaValor(arbol->.der)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(2)
apila(0)
suma
apila_ind
apila_ind
apila(2)
suma
desapila_ind
apila_dir(0)
apila(1)
suma
apila(201)
desapila_ind
ir_a(104)
ir_a(202)

// Epílogo
apila_dir(0)
apila(3)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(2)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind

// Trad de LeeValores(TArbol & arbol) delta=5, N=1
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(1)
desapila_ind
desapila_dir(1)
apila_dir(0)
apila(5)
suma
desapila_dir(0)

apila_dir(1)
apila(1)
suma
apila(false)
desapila_ind

// Prellamada LeeValor(valor)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(1)
apila(2)
suma
desapila_ind
apila_dir(0)
apila(1)
suma
apila(247)
desapila_ind
ir_a(3)

apila_dir(1)
apila(1)
suma
apila_ind
not
ir_f(271)

// Prellamada GuardaValor(arbol)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(1)
apila(0)
suma
apila_ind
desapila_ind
apila_dir(0)
apila(1)
suma
apila(270)
desapila_ind
ir_a(104)
ir_a(271)

apila_dir(1)
apila(1)
suma
apila_ind
not
ir_v(231)

// Epílogo
apila_dir(0)
apila(5)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(1)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind

// Trad de AlmacenaEnSecuencia(TArbol arbol) delta=3, N=2
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(2)
desapila_ind
desapila_dir(2)
apila_dir(0)
apila(3)
suma
desapila_dir(0)

apila_dir(1)
apila(1)
suma
apila_ind
apila(10)
menor
apila_dir(2)
apila(0)
suma
apila_ind
apila(0)
distinto
and
ir_f(386)

// Prellamada AlmacenaEnSecuencia(arbol->.izq)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(2)
apila(0)
suma
apila_ind
apila(1)
suma
clona(1)
apila_dir(0)
apila(1)
suma
apila(334)
desapila_ind
ir_a(291)

apila_dir(1)
apila(1)
suma
apila_ind
apila(10)
menor
ir_f(366)

apila(4)
apila_dir(1)
apila(1)
suma
apila_ind
suma
apila_dir(2)
apila(0)
suma
apila_ind
apila(0)
suma
apila_ind
desapila_ind

apila_dir(1)
apila(1)
suma
apila_dir(1)
apila(1)
suma
apila_ind
apila(1)
suma
desapila_ind
ir_a(366)

// Prellamada AlmacenaEnSecuencia(arbol->.der)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(2)
apila(0)
suma
apila_ind
apila(2)
suma
clona(1)
apila_dir(0)
apila(1)
suma
apila(386)
desapila_ind
ir_a(291)
ir_a(386)

// Epílogo
apila_dir(0)
apila(3)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(2)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind

// Trad de ConstruyeSecOrdenada(TArbol arbol) delta=4, N=1
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(1)
desapila_ind
desapila_dir(1)
apila_dir(0)
apila(4)
suma
desapila_dir(0)

apila_dir(1)
apila(1)
suma
apila(0)
desapila_ind

// Prellamada AlmacenaEnSecuencia(arbol)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(1)
apila(0)
suma
clona(1)
apila_dir(0)
apila(1)
suma
apila(431)
desapila_ind
ir_a(291)

apila_dir(1)
apila(1)
suma
apila_ind
apila(10)
menor
ir_f(447)

apila(4)
apila_dir(1)
apila(1)
suma
apila_ind
suma
apila(-1)
desapila_ind
ir_a(447)

// Epílogo
apila_dir(0)
apila(4)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(1)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind

// Trad de Libera(TArbol arbol) delta=3, N=2
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(2)
desapila_ind
desapila_dir(2)
apila_dir(0)
apila(3)
suma
desapila_dir(0)

apila_dir(2)
apila(0)
suma
apila_ind
apila(0)
distinto
ir_f(522)

// Prellamada Libera(arbol->.izq)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(2)
apila(0)
suma
apila_ind
apila(1)
suma
clona(1)
apila_dir(0)
apila(1)
suma
apila(497)
desapila_ind
ir_a(461)

// Prellamada Libera(arbol->.der)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(2)
apila(0)
suma
apila_ind
apila(2)
suma
clona(1)
apila_dir(0)
apila(1)
suma
apila(516)
desapila_ind
ir_a(461)

apila_dir(2)
apila(0)
suma
apila_ind
libera(3)
ir_a(522)

// Epílogo
apila_dir(0)
apila(3)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(2)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind

// Trad de LiberaArbol(TArbol & arbol) delta=3, N=1
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(1)
desapila_ind
desapila_dir(1)
apila_dir(0)
apila(3)
suma
desapila_dir(0)

// Prellamada Libera(arbol)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila_dir(1)
apila(0)
suma
apila_ind
clona(1)
apila_dir(0)
apila(1)
suma
apila(563)
desapila_ind
ir_a(461)

apila_dir(1)
apila(0)
suma
apila_ind
apila(0)
desapila_ind

// Epílogo
apila_dir(0)
apila(3)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(1)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind

// Trad de MuestraSecuencia(TSecuencia secuencia) delta=14, N=1
// Prólogo
apila_dir(0)
apila(2)
suma
apila_dir(1)
desapila_ind
desapila_dir(1)
apila_dir(0)
apila(14)
suma
desapila_dir(0)

apila_dir(1)
apila(10)
suma
apila(0)
desapila_ind

apila_dir(1)
apila(11)
suma
apila_dir(1)
apila(0)
suma
apila(0)
suma
apila_ind
apila(-1)
igual
desapila_ind

apila_dir(1)
apila(11)
suma
apila_ind
not
ir_f(669)

apila_dir(1)
apila(0)
suma
apila_dir(1)
apila(10)
suma
apila_ind
suma
apila_ind
escribe

apila_dir(1)
apila(10)
suma
apila_dir(1)
apila(10)
suma
apila_ind
apila(1)
suma
desapila_ind

apila_dir(1)
apila(11)
suma
apila_dir(1)
apila(10)
suma
apila_ind
apila(10)
igual
desapila_ind

apila_dir(1)
apila(11)
suma
apila_ind
not
ir_f(668)

apila_dir(1)
apila(11)
suma
apila_dir(1)
apila(0)
suma
apila_dir(1)
apila(10)
suma
apila_ind
suma
apila_ind
apila(-1)
igual
desapila_ind
ir_a(668)

ir_a(610)

// Epílogo
apila_dir(0)
apila(14)
resta
desapila_dir(0)
apila_dir(0)
apila(2)
suma
apila_ind
desapila_dir(1)
apila_dir(0)
apila(1)
suma
apila_ind
ir_ind


// Inicio programa
// Prellamada LeeValores(arbol)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila(14)
desapila_ind
apila_dir(0)
apila(1)
suma
apila(697)
desapila_ind
ir_a(216)

// Prellamada ConstruyeSecOrdenada(arbol)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila(14)
clona(1)
apila_dir(0)
apila(1)
suma
apila(711)
desapila_ind
ir_a(400)

// Prellamada LiberaArbol(arbol)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila(14)
desapila_ind
apila_dir(0)
apila(1)
suma
apila(725)
desapila_ind
ir_a(536)

// Prellamada MuestraSecuencia(secuencia)
apila_dir(0)
apila(3)
suma
dup
apila(0)
suma
apila(4)
clona(10)
apila_dir(0)
apila(1)
suma
apila(739)
desapila_ind
ir_a(583)
