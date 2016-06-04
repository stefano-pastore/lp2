#Soluzioni

- `alfa.f(beta, "ciao")`
  * `f(B x, Object y)`

**Output**: `B2`

- `beta.f(beta, new A[10])`
  * `f(B x, Object y)`
  * `f(B x, A y)`
  * `f(B x, Object y)`
  * `f(B x, B y)`
  * `f(B x, A y)`

**Output**: `B2`

- `f(x,x)`
  * `f(B x, Object y)`
  * `f(B x, A y)`

- `f(x,x)`
  * `f(B x, Object y)`
  * `f(B x, A y)`
  * `f(B x, Object y)`
  * `f(B x, B y)`
  * `f(B x, A y)`

- `System.out.println((1 == 2) || (7 >= 7))`

**Output**: `true`
