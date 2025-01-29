# Gestor de Reserves d'Esdeveniments

Implementem un sistema de gestió de reserves per a un esdeveniment amb places limitades, on assistents poden reservar i cancel·lar places de manera concurrent.

## Estructura del Codi

El projecte es compon de les següents classes:

- **`Esdeveniment`**: Gestiona les reserves i cancel·lacions de places.
- **`Assistent`**: Representa un participant que pot fer reserves i cancel·lar-les aleatòriament.
- **`Organitzador`**: Crea l'esdeveniment i inicia els assistents.

## Funcionament

1. Es crea un esdeveniment amb un màxim de 5 places.
2. Es creen 10 assistents que intenten reservar o cancel·lar la seva plaça de manera contínua.
3. Els assistents esperen un temps aleatori entre 0 i 1 segons abans d'intentar una nova acció.
4. El programa imprimeix en consola l'estat de les reserves en temps real.

## Parts Fonamentals del Codi

- **Sincronització**: La classe `Esdeveniment` utilitza mètodes sincronitzats (`synchronized`) per evitar condicions de carrera quan múltiples fils intenten fer reserves o cancel·lar simultàniament.
- **Fils (`Threads`)**: Cada `Assistent` és un fil independent que executa accions de manera aleatòria.
- **Aleatorietat**: L'ús de `Random` per determinar si un assistent fa una reserva o la cancel·la i per definir el temps d'espera.
- **Estructura concurrent**: La implementació permet que múltiples assistents interactuïn en temps real amb el sistema de reserves.

## Exemple de Sortida

```
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-3 ha cancel·lat una reserva. Places disponibles: 5
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
```