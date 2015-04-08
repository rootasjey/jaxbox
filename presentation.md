# PRESENTATIONS

## XML

1. Présentation Projet, méthodes REST, APIs utilisées
2. Transformations XSLT, SAX
3. Persistance BD Hibernate
4. Service Web SOAP, UI

## INTEGRATION

1. Présentation Talend
2. Aspect sémantique (schéma)
3. Mapping
4. Composants de Talend
5. Interfaçage avec différentes sources de donnés
6. Mise en pratique des techniques vues en cours

* **fichier délimité** : .csv

* **tFileOutputDelimited** : This component writes a delimited file that holds data organized according to the defined schema. -- mettre les doublons dans un fichier (après les avoir supprimés de la bdd, au cas où)

* **tUniqRow** : Compares entries and sorts out duplicate entries from the input flow. -- Ensures data quality of input or output flow in a Job.

* **tUnite** : Merges data from various sources, based on a common schema. Centralize data from various and heterogeneous sources.

* **tReplicate** : Duplicate the incoming schema into two identical output flows. Allows you to perform different operations on the same schema.

* **tMysqlInput** : tMysqlInput reads a database and extracts fields based on a query. tMysqlInput executes a DB query with a strictly defined order which must correspond to the schema definition. Then it passes on the field list to the next component via a Main row link.

* **tMysqlOutput** : tMysqlOutput writes, updates, makes changes or suppresses entries in a database. tMysqlOutput executes the action defined on the table and/or on the data contained in the table, based on the flow incoming from the preceding component in the Job.

* **tSortRow** : Sorts input data based on one or several columns, by sort type and order. Helps creating metrics and classification table.

* **tMap** : tMap is an advanced component, which integrates itself as plugin to Talend Studio. tMap transforms and routes data from single or multiple sources to single or multiple destinations. (EX. JOINTURE)

* **tLogRow** : Displays data or results in the Run console. tLogRow is used to monitor data processed.

* **Business model designer** : modéliser des entités. Le business model designer permet de générer des modèles (vue) non techniques des différents échanges et flux de données au sein de l’entreprise.

* **job** : Un Job est l'implémentation technique du Business Model. C’est le programme généré par Talend qui permet de mettre en place et de réaliser le(s) flux de données identifié(s) au niveau supérieur (Business Model). C’est la couche « code-métier » que Talend permet de réaliser.

* **génération de code** :

* **composants** :
