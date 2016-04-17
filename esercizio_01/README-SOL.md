Soluzioni
===================

---- alfa.f(null, gamma)

FIRME CANDIDATE
f(A a, B b)
f(B b, C c)

OUTPUT: 1

---- beta.f(gamma, gamma)

FIRME CANDIDATE
f(A a, B b)
f(C c, B b)
f(C c, Object x)
f(B b, C c)

OUTPUT: Errore a tempo di compilazione (firme ambigue)

---- beta.f(gamma, alfa)

FIRME CANDIDATE
f(C c, Object x)

OUTPUT: 4

---- gamma.f(beta, beta)

FIRME CANDIDATE
f(A a, B b)

OUTPUT: 6

---- System.out.println(1 + "1")
"11"