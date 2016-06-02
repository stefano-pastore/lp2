#Soluzioni

- `alfa.f(1,2,3)`
  * `f(int i, long l1, long l2)`
  * `f(int i1, int i2, double d)`

**Output**: *Errore a tempo di compilazione:* `reference to f is ambiguous both method f(int,long,long) in A and method f(int,int,double) in A match`

- `alfa.f(1,2,3.0)`
  * `f(int i1, int i2, double d)`

 **Output**: `5`

 - `beta.f(true, 5, 6)`
   * `f(boolean b, double d, long l)`
   * `f(boolean b, int i, double d)`

**Output**: *Errore a tempo di compilazione:* `reference to f is ambiguous both method f(boolean,double,long) in B and method f(boolean,int,double) in B match`

- `beta.f(false, 3.0, 4)`
  * `f(boolean b, double d, long l)`

**Output**: `3`

- `System.out.println(7 & 5)`

**Output**: `5`