## Food overflow (student project)
![UML](img/Food%20Overflow_UML.jpg)
### Patterns present in this project
#### Composite (Recipes)
Recipes have the following attributes:
* Difficulty.
* Ingredients.
* Inadequate conditions.  
From the client's perspective recipes behave polymorphically.
The difficulty of a SimpleRecipe comes from it's attribute difficulty.
The difficulty of a CompoundRecipe is calculated from the maximum difficulty of all it's sub recipes
#### Strategy

### Alimento
* cada alimento es inadecuado para un conjunto de condiciones alimenticias

### Usuarios
* Pueden tener distintas condiciones alimenticias: vegano, vegetariano, hipertenso, diabetico, celiaco
* Pueden ser saludables dependiendo de sus condiciones alimenticias
* Pueden crear recetas y colaborar en recetas.

### Recetas
* Tienen ingredientes compuestos por un alimento y su cantidad
* Pueden ser sugeribles o no sugeribles para un usuario dependiendo de las condiciones alimenticias del usuario y si este las subsana
* Existen recetas simples y recetas compuestas que contienen multiples recetas, simples o compuestas.
* 