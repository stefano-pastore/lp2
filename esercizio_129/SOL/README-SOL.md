# Quesiti

Si consideri il seguente schema di sincronizzazione: `insert` è mutuamente esclusivo con `take(i)`, per
ogni valore di `i`; `take(i)` è mutuamente esclusivo con `take(i)`, ma è compatibile con `take(j)`, quando
`j` è diverso da `i`. Rispondere alle seguenti domande:

- Questo schema evita le *race condition*?
- È possibile implementare questo schema utilizzando metodi e blocchi sincronizzati?

## Risposte ai quesiti

Il seguente schema non evita le *race condition* infatti è lampante se si suppone che ad usare la classe siano due o più thread e che almeno due tentino di accedere al buffer collocato nella posizione `i`.

Tuttavia è possibile implementare questo schema ad esempio sincronizzando i thread sui mutex rispettivamente propri di ogni buffer in posizione `i`-ma. 