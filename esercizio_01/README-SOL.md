#Soluzioni

- `alfa.f(null, gamma)`
  * `f(A a, B b)`
  * `f(B b, C c)`

**Output**: `1`

- `beta.f(gamma, gamma)`
  * `f(A a, B b)`
  * `f(C c, B b)`
  * `f(C c, Object x)`
  * `f(B b, C c)`

**Output**: *Errore a tempo di compilazione (firme ambigue).*

- `beta.f(gamma, alfa)`
  * `f(C c, Object x)`

**Output**: `4`

- `gamma.f(beta, beta)`
  * `f(A a, B b)`

**Output**: `6`

- `System.out.println(1 + "1")`

**Output**: `11`
