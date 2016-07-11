# Soluzioni

- `alfa.f(alfa, alfa, null)`
  * `f(A, Object, B)`
  * `f(A, A, B)`
  
**Output**: `B1`

- `beta.f(alfa, beta, beta)`
  * `f(A, Object, B)`
  * `f(A, Object, A)`
  * `f(A, A, B)`

  **Output**: `B1`

- `beta.f(beta, beta, beta)`
  * `f(A, Object, B)`
  * `f(A, Object, A)`
  * `f(A, A, B)`
  * `f(B, Object, B)`

  **Output**: *Errore a tempo di compilazione (firme ambigue).*

- `beta.f(alfa, alfa, alfa)`
  * `f(A, Object, A)`

**Output**: `B2`