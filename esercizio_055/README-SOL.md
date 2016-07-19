#Soluzione

##Firme in esame

1. `List<?> reverseList(List<?> l)`
2. `<T> List<? extends T> reverseList (List<? super T> l)`
3. `<T extends List<?>> T reverseList(T l)`
4. `<T> List<T> reverseList(List<T> l)`
5. `List<Object> reverseList(List<Object> l)`

##Valutazione sintetica

Firma | Funzionalità | Completezza | Correttezza | Ulteriori Garanzie | Semplicità | Tipo di Ritorno
------|--------------|-------------|-------------|--------------------|------------|-----------------
1| Sì | Sì | Sì | - | Sì | No
2| No | - | - | - | - | -
3| Sì | Sì | Sì | No | No | No
4| Sì | Sì | Sì | Sì | Sì | Sì
5| Sì | No | Sì | - | - | -


#### Firma 1

Una possibile implementazione potrebbe essere quella mostrata di seguito. Uno dei grossi difetti di questa firma è decisamente dato dal tipo di ritorno: la lista potrà solo essere assegnata ad un oggetto il cui tipo dichiarato è `?`.  

```java
public List<?> reverseList(List<?> l)
{
	List<Object> list = new ArrayList<Object>();
	
	for (int i = l.size()-1; i >= 0; i--)
	{
		list.add(l.get(i));
	}

	return list;	
}
```

#### Firma 2

Non è funzionale: il tipo sconosciuto degli elementi contenuti nella lista in ingresso deve essere supertipo degli elementi contenuti nella lista d'uscita. Questo genera problemi in due punti, come illustrato nello snippet sottostante.

```java
public <T> List<? extends T> reverseList(List<? super T> l)
{
	// Downcast illecito
	List<Manager> list = new ArrayList<Person>();
	
	for (int i = l.size()-1; i >= 0; i--)
	{
		// Dovrebbero essere inseriti in una lista di sottotipo di T
		// elementi con supertipo di T.
		list.add(l.get(i));
	}

	return list;	
}
```

#### Firma 3

La seguente funzione riesce a realizzare la post-condizione, ma a prezzo della pericolosità del tipo di ritorno da concreto a sconosciuto che potrà pagare a runtime con un'eccezione di tipo.

public <T extends List<?>> T reverseList(T l)
{
	List<Object> reverse = new ArrayList<Object>();
	
	for (int i = l.size()-1; i >= 0; i--)
	{
		reverse.add(l.get(i));
	}
	
	// Conversione potenzialmente pericolosa da ArrayList<Object> a List<?>.
	return (T) reverse;
}

#### Firma 4

È la miglior firma per il problema delineato.

#### Firma 5

La firma così delineata realizza la condizione, ma solamente per una sottoclasse di istanze: puòS infatti accettare unicamente liste i cui oggetti siano di tipo Object. 