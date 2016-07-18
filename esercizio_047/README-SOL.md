#Soluzione

##Firme in esame

1. `Set<?> difference(Set<?> a, Set<?> b)`
2. `Set<Object> difference(Set<?> a, Set<?> b)`
3. `Set<Object> difference(Set<String> a, Set<String> b)`
4. `<T> Set<T> difference(Set<T> a, Set<?> b)`
5. `<T> Set<T> difference(Set<? extends T> a, Set<? extends T> b)`
6. `<T> Set<T> difference(Set<T> a, Set<? extends T> b)`

Firma | Funzionalità | Completezza | Correttezza | Ulteriori Garanzie | Semplicità | Tipo di Ritorno
------|--------------|-------------|-------------|--------------------|------------|-----------------
1 | Sì | Sì | Sì | - | Sì | No
2 | Sì | Sì | Sì | - | Sì | No
3 | No | - | - | - | - | -
4 | Sì | Sì | Sì | Sì | Sì | Sì
5 | Sì | No | Sì | Sì | Sì | Sì
6 | Sì | No | Sì | Sì | Sì | Sì


#### Firma 1

Una possibile implementazione potrebbe essere quella mostrata di seguito. Uno dei grossi difetti di questa firma è decisamente dato dal tipo di ritorno: l'insieme in output potrà solo essere assegnato ad un oggetto il cui tipo dichiarato è `?`. 

```java
public Set<?> difference(Set<?> a, Set<?> b)
{
	Set<Object> set = new HashSet<Object>();
	
	for (Object x : a)
	{
		if (!(b.contains(x)))
		{
			set.add(x);
		}
	}
	
	return set;
}
```
#### Firma 2

Con minime modifiche rispetto alla soluzione precedente, è possibile che la funzione restituisca un insieme di oggetti di tipo Object. Tuttavia, proprio come nel primo caso, questa implementazione eredita il problema dell'assegnazione: è necessario che gli oggetti siano usati come Object.

```java
public Set<Object> difference(Set<?> a, Set<?> b)
{
	Set<Object> set = new HashSet<Object>();
	
	for (Object x : a)
	{
		if (!(b.contains(x)))
		{
			set.add(x);
		}
	}
	
	return set;
}
```

#### Firma 3

Non è funzionale poiché eccezion fatta per una specifica istanza di tipo la firma non consente di realizzare pienamente la post-condizione.

#### Firma 4

Risulta essere la firma migliore.

#### Firma 5

Viene applicata una restrizione su tutte quelle istanze di input per le quali i tipi dei due insiemi non sono correlati tra loro e pertanto la firma non risulta essere completa.

#### Firma 6

La firma rigetta tutte quelle coppie di insiemi per cui il tipo gli elementi del primo insieme non sia supertipo del tipo degli elementi del secondo insieme. Ancora una volta la firma non è completa.