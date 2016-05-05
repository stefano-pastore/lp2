# Soluzioni

- `alfa.f(beta, null)`
  * `f(A a, B b)` _abstract_
  * `f(B b, C c)`
  
**Output**: `3`

- `beta.f(beta, beta)`
  * `f(A a, B b)`
  * `f(A a, B b)` _abstract_
  
**Output**: `6`

- `beta.f(gamma, alfa)`
  * `f(C c, Object x)`
  
**Output**: `4`

- `beta.f(gamma, gamma)`
  * `f(A a, B b)` _abstract_
  * `f(B b, C c)`
  * `f(C c, Object x)`
  * `f(A a, B b)`
  * `f(C c1, C c2)`
  
**Output**: `5`

- `beta.getClass().getName()`
  
**Output**: `C`
