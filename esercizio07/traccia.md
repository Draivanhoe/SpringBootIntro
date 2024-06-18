Sviluppa un'applicazione web Spring Boot con le seguenti librerie:
- Lombok
- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- MySQL Driver

Usa hibernate e JPA per connettersi ad un DB mysql locale, configura il parametro "ddl-auto" così che hibernate crei e distrugga lo schema alla fine di ciascuna sessione.

Considera questo scenario:
- Ciascuno studente può effettuare più iscrizioni
- Ciascun corso può avere diverse iscrizioni

avendo in mente gli usecase di cui sopra e usando le annotazioni, scrivi il codice per creare:

1) La tabella students dove ogni studente avrà:
- primary key
- colonna lastName (not null)
- colonna firstName (not null)
- colonna email con valori univoci e not null

2) La tabella classes dove ogni classe ha:
- primary key
- title (not null)
- description (not null)

3) La tabella enrollments per salvare collegamenti tra le tabelle students e classes:
- primary key
- 2 foreign keys
