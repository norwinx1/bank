#BBW M326 Bank

In diesem Readme befinden sich die verschiedenen Anwendungsfälle, Aktivitäts- und Klassendiagramme zu allen Bank Aufgaben.

##Bank 2
###Anwendungsfälle
####Kontoeröffnung
| Name             | **Kunde eröffnet am Bankschalter ein Bankkonto**                                 |
|------------------|----------------------------------------------------------------------------------|
| Kurzbeschreibung | Der Bankangestellte eröffnet für den Kunden am Bankschalter ein neues Bankkonto. |
| Akteure          | Kunde, Bankangestellter                                                          |
| Auslöser         | Der Kunde möchte ein Konto eröffnen.                                             |
| Vorbedingungen   | Der Kunde muss vom Gesetz her berechtigt sein, ein Bankkonto zu eröffnen.        |
| Eingehende Infos | Personalien des Kunden                                                           |
| Ergebnis         | Bestätigung der Kontoeröffnung                                                   |
| Nachbedingung    | Für den Kunden wurde ein Bankkonto eröffnet.                                     |
| Ablauf           | 1. Bankkonto eröffnen <br/> 2. Eröffnung bestätigen                              |
####Einzahlung und Auszahlung
| Name             | **Kunde tätigt eine Ein- oder Auszahlung am Bankschalter ein**                                         |
|------------------|--------------------------------------------------------------------------------------------------------|
| Kurzbeschreibung | Der Bankangestellte tätigt für den Kunden am Bankschalter eine Ein- oder Auszahlung.                   |
| Akteure          | Kunde, Bankangestellter                                                                                |
| Auslöser         | Der Kunde möchte eine Ein- oder Auszahlung tätigen.                                                    |
| Vorbedingungen   | Der Kunde muss ein Bankkonto besitzen.                                                                 |
| Eingehende Infos | Kundenkonto, Geldmenge                                                                                 |
| Ergebnis         | Bestätigung der Ein- oder Auszahlung                                                                   |
| Nachbedingung    | Für den Kunden wurde eine Ein- oder Auszahlung für sein Konto getätigt.                                |
| Ablauf           | 1. Kundenkonto identifizieren <br/> 2. Geldmenge überprüfen <br/> 3. Auf Bankkonto ein- oder auszahlen |
####Kontoauszug
| Name             | **Kunde erhält einen Kontoauszug für sein Bankkonto**                  |
|------------------|------------------------------------------------------------------------|
| Kurzbeschreibung | Der Bankangestellte gibt dem Kunden am Bankschalter einen Kontoauszug. |
| Akteure          | Kunde, Bankangestellter                                                |
| Auslöser         | Der Kunde möchte einen Kontoauszug für sein Konto erhalten.            |
| Vorbedingungen   | Der Kunde muss ein Bankkonto besitzen.                                 |
| Eingehende Infos | Kundenkonto                                                            |
| Ergebnis         | Kunde erhält Kontoauszug                                               |
| Nachbedingung    | -                                                                      |
| Ablauf           | 1. Kundenkonto identifizieren <br/> 2. Kontoauszug ausgeben            |
###Klassendiagramm
![](classDiagram1.png)
##Bank 3