# SCAA (Software Component Assembly Assistant)

Le logiciel SCAA est un assistant à la construction d’applications à base de composants logiciels. Sa fonction est d’assembler des composants, de manière plus ou moins automatique, afin de produire des applications.

### Pré-requis

- Un Jdk installé avec un JAVA_HOME bien configuré
- Maven

### Installation
  ``` mvn package``` Donne un jar.

## Démarrage

Il s'agit juste de bricks logiciels pour l'instant.

### IHM 

![Image of IHM explain](https://github.com/leunam217/scaa/blob/master/ihm.png)

 **Le brick est fonctionnel.**
   1) showResults permet de présenter à l’utilisateur un ensemble de composants.
   1) getFirstComponent permet de proposer à un utilisateur le choix entre plusieurs ports Cela est fait via le terminal en affichant les options et demandant le nom du composant associé choisi.
   1) importEnvironment demande à l'utilisateur de renseigner le chemin d'accès au fichier contenant l'environnement (format JSON définis comme une liste de ComponentDTO). Puis on a la liste de composants comme retour de la fonction.
   Les classes de IHM utilisent le sous package console. La classe Get a les méthodes qui récupèrent de l'infromation de l'utilisateur. La classe Show sert à montrer des informations. Ces classes sont implémentées avec l'usage d'une console mais peuvent être implémentées via une "vraie" ihm, il faut juste offrir les même fonctions
   
### AgentAdapter

 **Le brick est fonctionnel.**   
Dans cet exemple, on crée un monde avec deux agents. On dit que le premier agent, quand il reçoit un message, dit à tout le monde “lol”. Le deuxième agent, quand il reçoit un message, l’affiche et fait un exit. Pour déclencher les événements on envoie un message au premier agent. Pour commencer l'exécution on exécute start. L'exemple se trouve dans la classe WorldAdapter. 
 
   ![scaa1](https://github.com/leunam217/scaa/blob/master/scaa1.png)
   ![scaa2](https://github.com/leunam217/scaa/blob/master/scaa2.png)
   
  
   
   ![scaa1](https://github.com/leunam217/scaa/blob/master/exp1.png)
   ![scaa2](https://github.com/leunam217/scaa/blob/master/exp2.png)
   
### ImportExport

 **Le brick est fonctionnel.**
 
Le module “Converter” permet d’importer le fichier JSON contenant la description des composants présents dans l’environnement et d’exporter l’application construite par SCAA en fichier JSON

### Coordinator (pas fonctionnel)

  Contient pour l'instant un exemple d'utiliation de l'import/export
  
### Models 
Structures de données utilisées par scaa. Un component a des connectors. Les DTO existent pour la sérialisation/désérialisation avec **JSON-B**.

### Agents

Contient le début de l'implémentation des agents s'appuyant sur les services fournis par l'adaptateur

## Fabriqué avec

* INFRA - Bibliothèque Java qui permet la création et l’exécution d’agents génériques

## Auteurs

* **Manuel CABARCOS BAULINA**
* **Pierre SELEBRAN**
* **Jonathan LAO-KAN**
* **Romain GRIMAL**
* **Alexandre ELLERO**
* **Arnaud CHEVALLIER**
