#Soluzione

##Firme in esame

1. `List<?> listIntersection(List<?> l, Set<?> s)`
2. `List<Object> listIntersection(List<Object> l, Set<?> s)`
3. `<T> List<T> listIntersection(List<T> l, Set<? extends T> s)`
4. `<T> List<T> listIntersection(List<T> l, Set<?> s)`
5. `<S,T> List<T> listIntersection(List<T> l, Set<S> s)`

##Presupposti

Nel risolvere questo esercizio, ho assunto le seguenti:

* il risultato dell'intersezione tra la lista in ingresso e l'insieme può essere vuoto;
* il tipo degli oggetti della lista può essere diverso dal tipo degli oggetti dell'insieme o anche totalmente scorrelato e determinare una lista vuota.

##Valutazione sintetica

Firma | Funzionalità | Completezza | Correttezza | Ulteriori Garanzie | Semplicità | Tipo di Ritorno
------|--------------|-------------|-------------|--------------------|------------|-----------------
1 | Sì | Sì | Sì | No | Sì | No
2 | Sì | No | Sì | - | - | No
3 | Sì | No | Sì | No | - | Sì
4 | Sì | Sì | Sì | Sì | Sì | Sì
5 | Sì | Sì | Sì | No | No | Sì

#### Firma 1

Una possibile implementazione potrebbe essere quella mostrata di seguito. Uno dei grossi difetti di questa firma è decisamente dato dal tipo di ritorno: la lista potrà solo essere assegnata ad un oggetto il cui tipo dichiarato è `?`.  

```java
public static List<?> listIntersection(List<?> l, Set<?> s)
	{
		List<Object> list = new ArrayList<Object>();
		
		for (Object x : l)
		{
			if (s.contains(x))
			{
				list.add(x);
			}
		}
		return list;	
	}
```

#### Firma 2

Dal momento che `List<Object>` non è un supertipo, ma semplicemente una lista di oggetti di tipo effettivo `Object`, l'implementazione mostrata pur essendo funzionale e corretta, non è completa in quanto funziona solamente per uno specifico sottoinsieme delle possibili istanze. Inoltre il tipo di ritorno costringe il chiamamente, proprio per quanto detto, a dichiarare l'oggetto contenente l'intersezione come una lista di oggetti di tipo `Object`.

```java
public static List<Object> listIntersection(List<Object> l, Set<?> s)
{
	List<Object> list = new ArrayList<Object>();
	
	for (Object x : l)
	{
		if (s.contains(x))
		{
			list.add(x);
		}
	}
	return list;	
}
```

#### Firma 3

Come anticipato nei presupposti, attraverso questa firma, precludiamo il chiamante dal passare lista ed insieme con tipi completamente scorrelati. Dal momento che si considera accettabile anche una lista senza elementi come output, allora ne deriva che la firma rigetta più di quanto dovrebbe e risulta essere pertanto non completa.

#### Firma 4

È la firma più corretta per l'implementazione di questa funzione.

#### Firma 5

È molto simile alla firma 4, pur tuttavia introducendo un parametro di tipo in maniera del tutto non necessaria.