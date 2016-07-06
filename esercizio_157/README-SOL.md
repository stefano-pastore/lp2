# Soluzioni

- `alfa.f(3.0, gamma)`
  * `f(double, A)`
  * `f(double, Object)`
  
**Output**: `C1`

- `beta.f(3, beta)`
  * `f(float, Object)`
  * `f(double, Object)`
  * `f(int, Object)`
  * `f(double, A)`
  
**Output**: *Errore a tempo di compilazione (firme ambigue).*

- `beta.f(3.0, null)`
  * `f(float, Object)`
  * `f(double, Object)`
  * `f(double, A)`

**Output**: `A2`

- `gamma.f(3.0, gamma)`
  * `f(double, A)`
  * `f(float, Object)`
  * `f(double, Object)`

  **Output**: `C1`

- `true && (alfa == beta)`

**Output**: `false`