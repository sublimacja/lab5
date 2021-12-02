**PPKWU lab4**
----
Rest API, które otrzymany ciąg znaków przekazuje do zadania 3 i zwraca rezultat w postaci jednego z czterech formatów:
txt ("rodzaj znaków: %d\n..."), json, xml i csv. Formaty zwracanych i pobieranych danych są "wybierane" przy wywołaniu
API. API posiada również endpoint, w którym przekazujemy dane (archiwalne, np. z pliku: txt,json,csv) z zadania 3 (w
dowolnym formacie), a zadanie 4 dokonuje konwersji do jednego z czterech formatów: txt ("rodzaj znaków: %d\n..."), json,
xml i csv.

* **SKŁADNIA**

 ``` 
ścieżkaApi/{tekst}/{formatZad3}/{formatZad4}
```

* **Parametry**

 ```
{tekst} - ciąg znaków przekazywany do API z zadania 3
{formatZad3} - format zwracany przez API z zadania 3
{formatZad4} - format do ktorego konwertujemy
 ```

* **Metoda**

```
GET
```

* **Przykłady użycia:**

**konwersja formatu TXT zwracanego przez API z zadania 3 do formatu JSON:**

```
http://localhost:8082/api/ppkwu/lab4/TESt0912./txt/json
```

`wejście:`

```
txt
TESt0912.
```

`wyjście:`

```
{"UPPER":"3","LOWER":"1","OWN":"5","DIGIT":"4","SPECIAL":"1"}
```

**konwersja formatu CSV zwracanego przez API z zadania 3 do formatu JSON:**

```
http://localhost:8082/api/ppkwu/lab4/TESt0912./csv/json
```

`wejście:`

```
csv
TESt0912.
```

`wyjście:`

```
{"UPPER":"3","LOWER":"1","OWN":"5","DIGIT":"4","SPECIAL":"1"}
```

**konwersja formatu XML zwracanego przez API z zadania 3 do formatu JSON:**

```
http://localhost:8082/api/ppkwu/lab4/TESt0912./xml/json
```

`wejście:`

```
xml
TESt0912.
```

`wyjście:`

```
{"stringHelper": { "ownCombinationCounter": 5, "digitCounter": 4, "specialCounter": 1, "lowerCounter": 1, "upperCounter": 3 }}
```

**konwersja formatu JSON zwracanego przez API z zadania 3 do formatu XML:**

```
http://localhost:8082/api/ppkwu/lab4/TESt0912./json/xml
```

`wejście:`

```
json
TESt0912.
```

`wyjście:`

```
<stringHelper>
<UPPER>3</UPPER>
<LOWER>1</LOWER>
<OWN>5</OWN>
<DIGIT>4</DIGIT>
<SPECIAL>1</SPECIAL>
</stringHelper>
```

