#Soluzione

##Firme in esame

1. `Iterator<Object> concat(Iterator<Object> a, Iterator<Object> b)`
2. `Iterator<?> concat(Iterator<?> a, Iterator<?> b)`
3. `Iterator<S> concat(Iterator<S> a, Iterator<S> b)`
4. `Iterator<S> concat(Iterator<? extends S> a, Iterator<? extends S> b)`
5. `Iterator<S,T> concat(Iterator<S> a, Iterator<T> b)`
6. `Iterator<S, T extends S> concat(Iterator<T> a, Iterator<S> b)`

Firma | Funzionalità | Completezza | Correttezza | Ulteriori Garanzie | Semplicità | Tipo di Ritorno
------|--------------|-------------|-------------|--------------------|------------|-----------------
1 | Sì | No | Sì | - | - | -
2 | Sì | Sì | Sì | - | Sì | No
3 | Sì | No | Sì | - | Sì | Sì
4 | Sì | Sì | Sì | Sì | Sì | Sì
5 | No | - | - | - | - | -
6 | No | - | - | - | - | -


#### Firma 1
È funzionale perché si riesce a scrivere un corpo che compili e realizzi la post-condizione. Il problema di questa firma risiede nel fatto che in primis non è completa poiché accetta unicamente oggetti di tipo Object ed in secundis perché restituisce al chiamante solamente oggetti Object.

#### Firma 2
È migliore della prima perché accetta qualunque tipo senza restrizioni. Tuttavia questa firma è insoddisfacente dal punto di vista della specificità del tipo di ritorno.

#### Firma 3
È certamente meno restrittiva della firma 1, ma più della 2, sussiste il vincolo per il quale gli iteratori in ingresso devono essere del medesimo tipo. 

#### Firma 4
È quella che più si avvicina all'ideale di firma perfetta per questa funzione. Coglie tutti i lati positivi delle firme precedenti ed in più restituisce al chiamante un tipo, comune ad ambo gli elementi degli iteratori, che sia effettivamente impiegabile per altre operazioni.

#### Firma 5
Non è funzionale perché presi due qualsivoglia tipi tra loro disgiunti, all'interno del corpo, dopo aver scritto l'iteratore specifico per gli elementi di tipo S, non è possibile ritornare elementi di tipo T.

#### Firma 6
Non è funzionale dal momento che nello scrivere il secondo iteratore, si restituirebbero elementi che sono supertipo del tipo di ritorno.