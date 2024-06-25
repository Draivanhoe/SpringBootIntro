Scrivi un'applicazione web Spring Boot con le dipendenze neccessarie che:
- giri sulla porta 5050
- utilizzi Rest Repositories HAL Explorer
- si connetta ad una base dati MySQL locale
- cancelli lo schema alla fine della sessione
- Crei la tabella di linguaggi di programmazione, dove ogni ProgrammingLanguage ha:
-- primary key
-- name (not null)
-- anno di crezione firstAppearance (che può essere null)
-- inventor (not null)
- Abbia un repository dedicato per linguaggi di programmazione, così puoi usare HAL Explorer e Postman:
-- il repository usa path specifico repo-prog-languages con la descrizione

Utilizza Postman per:
- aggiungere 4 linguaggi di programmazione (Java, C++, JavaScript e Go)
- prendere la lista di tutti i linguaggi di programmazione nella base dati, con la paginazione con 2 risultati per pagina
- cambiare inventor di uno dei linguaggi esistenti, mettendo il tuo nome
