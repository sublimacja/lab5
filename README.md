**PPKWU lab5**
----
Rest API, które generuje stronę mobilną wykorzystującą wyszukiwarkę pracowników ze strony https://panoramafirm.pl. Po
wyszukaniu wyników (może ich być więcej, niż jeden), jest możliwość kliknięcia na opcję "wygeneruj vCard" dla każdego
znalezionego wpisu. Implementacja zawiera "wyciąganie" maili, numerów telefonów, adresów itp.

* **SKŁADNIA**

 ``` 
ścieżkaApi/{searchTerm}
```

* **Parametry**

 ```
{searchTerm} - fraza którą chcemy wyszukać w serwisie https://panoramafirm.pl.
 ```

* **Metoda**

```
GET
```

* **Przykłady użycia:**

```
http://localhost:8080/api/ppkwu/lab5/fryzjer
```

`wejście:`

```
fryzjer
```

`wyjście:`

![alt text](https://github.com/sublimacja/lab5/blob/master/photo.PNG)
